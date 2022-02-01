package com.idat.Controllers;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.Interfaces.IRecoveryAccount;
import com.idat.Interfaces.IUsuario;
import com.idat.Models.RecoveryAccount;
import com.idat.Models.Usuario;

@RestController
@RequestMapping("/recoveryAccount")
public class CRecoveryAccount {
	@Autowired
	IRecoveryAccount data;
	
	@Autowired
	IUsuario datauser;
	
	public String getAlphaNumericString(int n)
    {
        // length is bounded by 256 Character
        byte[] array = new byte[256];
        new Random().nextBytes(array);
  
        String randomString
            = new String(array, Charset.forName("UTF-8"));
        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer();
  
        // remove all spacial char
        String  AlphaNumericString
            = randomString
                  .replaceAll("[^A-Za-z0-9]", "");
  
        // Append first 20 alphanumeric characters
        // from the generated random String into the result
        for (int k = 0; k < AlphaNumericString.length(); k++) {
  
            if (Character.isLetter(AlphaNumericString.charAt(k))
                    && (n > 0)
                || Character.isDigit(AlphaNumericString.charAt(k))
                       && (n > 0)) {
                r.append(AlphaNumericString.charAt(k));
                n--;
            }
        }
        // return the resultant string
        return r.toString();
    }
	
	
	@GetMapping
	public List<RecoveryAccount> listAll(){
		return (List<RecoveryAccount>) data.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<RecoveryAccount> findById(@PathVariable int id){
		return data.findById(id);
	}
	
	@GetMapping("/setRecoveryCode/{mail}")
	public RecoveryAccount save(@PathVariable("mail")String email) {
		Usuario us = datauser.loginUserMailPass(email);
		//System.out.println(email);
		//System.out.println(us.getCorreo());
		if(us==null) {
			return null;	
		}
		RecoveryAccount recAcc = data.getByemail(email);
		if (recAcc == null) {
			String keycode = getAlphaNumericString(20);
			//System.out.println(keycode);
			recAcc = new RecoveryAccount();
			recAcc.setEmail(email);
			recAcc.setKeycode(keycode);
			return data.save(recAcc);
		}
		return recAcc;
		
		
	}
	/*
	@GetMapping("/getRecoveryCode/{mail}")
	public RecoveryAccount getRecoveryCode(@PathVariable("mail")String email) {
		RecoveryAccount rec = data.getByemail(email);
		return rec;
	}
	*/
	public RecoveryAccount getRecoveryCode(String email) {
		RecoveryAccount rec = data.getByemail(email);
		return rec;
	}
	
	@DeleteMapping("/{id}")
	public int delete(@PathVariable("id") int id) {
		data.deleteById(id);
		if(data.existsById(id)) {
			return 1;
		}
		return 0;
	}
}
