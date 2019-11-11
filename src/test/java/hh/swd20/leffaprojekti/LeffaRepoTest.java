package hh.swd20.leffaprojekti;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.leffaprojekti.domain.Kategoria;
import hh.swd20.leffaprojekti.domain.Leffa;
import hh.swd20.leffaprojekti.domain.LeffaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LeffaRepoTest {
	
	@Autowired
	    private LeffaRepository lRepository;
	 
	@Test
    public void findByNimiShouldReturnMovie() {
        
        
    }
    
    @Test
    public void luoUusiElokuva() {
    	Leffa leffa = new Leffa("Maissilapset", "Kauhu", "Fritz Kiersch","Peter Horton ja Linda Hamilton", new Kategoria("Hyllyssä"));
    	lRepository.save(leffa);
    
    }    

}