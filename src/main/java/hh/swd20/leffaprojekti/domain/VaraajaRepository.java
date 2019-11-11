package hh.swd20.leffaprojekti.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface VaraajaRepository extends CrudRepository <Varaaja, Long> {
	List<Varaaja> findByNimi(String nimi);

	

}
