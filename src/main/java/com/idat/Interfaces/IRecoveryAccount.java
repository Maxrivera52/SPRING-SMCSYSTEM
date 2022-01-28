package com.idat.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.Models.RecoveryAccount;

@Repository
public interface IRecoveryAccount extends CrudRepository<RecoveryAccount, Integer>{

	public RecoveryAccount getByemail(String email);
}
