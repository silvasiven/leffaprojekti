package hh.swd20.leffaprojekti.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.leffaprojekti.domain.Kategoria;
import hh.swd20.leffaprojekti.domain.KategoriaRepository;
import hh.swd20.leffaprojekti.domain.Leffa;
import hh.swd20.leffaprojekti.domain.LeffaRepository;
import hh.swd20.leffaprojekti.domain.Varaaja;
import hh.swd20.leffaprojekti.domain.VaraajaRepository;
import hh.swd20.leffaprojekti.domain.Varaus;
import hh.swd20.leffaprojekti.domain.VarausRepository;

@Controller
public class LeffaController {

	@Autowired
	private LeffaRepository lRepository;
	@Autowired
	private KategoriaRepository kRepository;
	@Autowired
	private VaraajaRepository vRepository;
	@Autowired
	private VarausRepository vsRepository;
	
	// login
			@RequestMapping(value="/login")
			public String login() {
				return "login";
			}
	//REST kaikki leffat
	@RequestMapping(value="/leffat", method = RequestMethod.GET)
	public @ResponseBody List<Leffa> leffaListRest() {
		return (List<Leffa>) lRepository.findAll();
	}
	
	//REST hakee leffa id:n perusteella
	@RequestMapping(value="/leffa/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Leffa> findLeffaRest(@PathVariable("id") Long leffaId) {
		return lRepository.findById(leffaId);
	}
	//REST kaikki varaajat
		@RequestMapping(value="/varaajat", method = RequestMethod.GET)
		public @ResponseBody List<Varaaja> varaajaListRest() {
			return (List<Varaaja>) vRepository.findAll();
	}
		//REST kaikki varaajat
				@RequestMapping(value="/varaukset", method = RequestMethod.GET)
				public @ResponseBody List<Varaus> varausListRest() {
					return (List<Varaus>) vsRepository.findAll();
					
				}
	//REST kaikki kategoriat ja niihin liitetyt elokuvat
				@RequestMapping(value="/kategoriat", method = RequestMethod.GET)
				public @ResponseBody List<Kategoria> kategoriaListRest() {
					return (List<Kategoria>) kRepository.findAll();
	}
	// Näyttää listauksen elokuvista
	@RequestMapping(value="/leffalista")
	public String listLeffa(Model model) {
		model.addAttribute("leffat", lRepository.findAll());
		model.addAttribute("varaajat", vRepository.findAll());
		return "leffalista";
	}
	
	
	// Admin oikeus: lisää uuden leffa
	@RequestMapping(value="/add")
	public String addLeffa(Model model) {
		model.addAttribute("leffa", new Leffa());
		model.addAttribute("kategoriat", kRepository.findAll());
		return "lisaaleffa";
	}
	
	// tallentaa uuden elokuvan/päivittää muuttuneet tiedot
		@RequestMapping(value="/tallenna", method=RequestMethod.POST)
		public String save(Leffa leffa) {
			lRepository.save(leffa);
			return "redirect:leffalista";
		}
		
	// Lähettää ja avaa varauslomakkeen
	@RequestMapping(value="/varaa/{id}", method=RequestMethod.GET)
	public String newVaraus(@PathVariable("id") Long leffaId, Model model) {
	//	Leffa leffa = lRepository.findById(leffaId);
		model.addAttribute("leffa",lRepository.findById(leffaId));
		model.addAttribute("varaaja", new Varaaja());
	//	leffa.setId(leffaId);
		model.addAttribute("leffaId",leffaId);
		return "teevaraus";
		
	}
	//tallentaa uuden varauksen
	@RequestMapping(value="/tallennavaraus", method=RequestMethod.POST)
	public String save(Varaaja varaaja, @RequestParam(name="leffaId") Long leffaid,Model model) {
		//Leffa leffa = lRepository.findById(leffaid);
	//	Long varaajaid = leffaid;
	//	varaaja.setVaraajaid(leffaid);
		vRepository.save(varaaja);
		Optional <Leffa> leffa1 = lRepository.findById(leffaid);
		Leffa leffa = leffa1.get();
		leffa.setId(leffaid);
		leffa.setVaraaja(varaaja);
		lRepository.save(leffa);
		return "redirect:leffalista";
	}
		
		
	// elokuvan poisto
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteLeffa(@PathVariable("id") Long leffaId, Model model) {
		lRepository.deleteById(leffaId);
		return "redirect:../leffalista";
	}
	//elokuvan muokkaus
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editLeffa(@PathVariable("id") Long leffaId, Model model) {
		model.addAttribute("leffa",lRepository.findById(leffaId));
		model.addAttribute("kategoriat", kRepository.findAll());
		return "muokkaaleffa";
	}

}
