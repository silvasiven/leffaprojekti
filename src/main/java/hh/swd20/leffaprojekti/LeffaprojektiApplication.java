package hh.swd20.leffaprojekti;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import hh.swd20.leffaprojekti.domain.Kategoria;
import hh.swd20.leffaprojekti.domain.KategoriaRepository;
import hh.swd20.leffaprojekti.domain.Kayttaja;
import hh.swd20.leffaprojekti.domain.KayttajaRepository;
import hh.swd20.leffaprojekti.domain.Leffa;
import hh.swd20.leffaprojekti.domain.LeffaRepository;

import hh.swd20.leffaprojekti.domain.VaraajaRepository;



@SpringBootApplication
public class LeffaprojektiApplication {
	private static final Logger log = LoggerFactory.getLogger(LeffaprojektiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LeffaprojektiApplication.class, args);
	
	Locale locale=Locale.getDefault();  

	  
	System.out.println(locale.getDisplayCountry());
	System.out.println(locale.getDisplayLanguage());  
	System.out.println(locale.getDisplayName());  
	System.out.println(locale.getISO3Country());  
	System.out.println(locale.getISO3Language());  
	System.out.println(locale.getLanguage());  
	System.out.println(locale.getCountry());  
	      
	}
	 

@Bean
	public CommandLineRunner leffaDemo (LeffaRepository lRepository, KategoriaRepository kRepository, VaraajaRepository vRepository, KayttajaRepository kaRepository) {
		return (args) -> {
		log.info("Tallenna muutamia elokuvia ja kategorioita");
		kRepository.save(new Kategoria("Lainassa"));
		kRepository.save(new Kategoria("Hyllyssä"));
		kRepository.save(new Kategoria("Myynnissä"));
		
		lRepository.save(new Leffa("Blade Runner","Scifi","Ridley Scott","Harrison Ford", kRepository.findByNimi("Hyllyssä").get(0)));
		lRepository.save(new Leffa("Hannibal","Trilleri","Ridley Scott","Anthony Hopkins",kRepository.findByNimi("Lainassa").get(0)));
		lRepository.save(new Leffa("Ring","Kauhu","Gore Verbinski","Naomi Watts",kRepository.findByNimi("Myynnissä").get(0)));

		Kayttaja user1 = new Kayttaja("user", "$2a$10$/iEyHBLqguFtM/aIiaOKmu2PiPe635mDmoqkOdG21yJbHGLgYF07e", "kayttaja@kayttaja.fi", "USER");
		Kayttaja user2 = new Kayttaja("admin", "$2a$10$JWXmJcPJWkMuoPWgypbkou492xYY.8IGhmnd91PvJe0FPyz.dxFLK", "admin@admin.fi", "ADMIN");
		kaRepository.save(user1);
		kaRepository.save(user2);
		
		log.info("nouda kaikki leffat");
		for (Leffa leffa : lRepository.findAll()) {
			log.info(leffa.toString());
		}

	};
}
}
		

		