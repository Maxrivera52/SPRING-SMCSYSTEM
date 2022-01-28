package com.idat.Interfaces;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.idat.Models.DetalleCursoDocente;

@Repository
public interface IDetalleCursoDocentes extends CrudRepository<DetalleCursoDocente, Integer> {
	/*@Query("SELECT dcr FROM DetalleCursoDocente dcr "
			+ "INNER JOIN Curso cur ON cur.idcurso = dcr.idcurso.idcurso "
			+ "INNER JOIN Profesor prf ON prf.idprofesor = dcr.idprofesor.idprofesor "
			+ "INNER JOIN Grado gr ON gr.idgrado = cur.idgrado "
			+ "INNER JOIN Nivel nv ON nv.idnivel = gr.idnivel "
			+ "WHERE nv.nombre = :nivel AND CONCAT(prf.nombre,' ',prf.apellido) = :docente "
			+ "ORDER BY cur.descripcion ASC")*/
	@Query("SELECT dcr FROM DetalleCursoDocente dcr "
			+ "INNER JOIN Curso cur ON cur.idcurso = dcr.idcurso\r\n"
			+ "INNER JOIN Profesor prf ON prf.idprofesor = dcr.idprofesor.idprofesor\r\n"
			+ "INNER JOIN DetalleProfesorSeccion dtps ON dtps.idprofesor.idprofesor = prf.idprofesor\r\n"
			+ "INNER JOIN Seccion scc ON dtps.idseccion.idseccion = scc.idseccion\r\n"
			+ "INNER JOIN Grado gr ON cur.idgrado.idgrado = gr.idgrado\r\n"
			+ "INNER JOIN Nivel nv ON nv.idnivel = gr.idnivel\r\n"
			+ "WHERE nv.nombre = :nivel AND CONCAT(prf.nombre,' ',prf.apellido) = :docente\r\n"
			+ "GROUP BY dcr.iddtcurso\r\n"
			+ "ORDER BY prf.idprofesor ASC")
	Collection<DetalleCursoDocente> getDetalleCursosDocenteByDocenteNivel(@Param("nivel") String nivel,@Param("docente") String docente);
	
}
