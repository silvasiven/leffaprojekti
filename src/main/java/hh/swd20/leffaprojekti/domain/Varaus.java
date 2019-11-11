package hh.swd20.leffaprojekti.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Varaus {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long varausid;
	private String tila;

	@OneToMany(cascade = CascadeType.ALL,mappedBy ="varaus")
	private List<Varaaja> varaajat;	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="varaus")
	private List<Leffa> leffat;

	public Varaus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Varaus(Long varausid, String tila, List<Varaaja> varaajat, List<Leffa> leffat) {
		super();
		this.varausid = varausid;
		this.tila = tila;
		this.varaajat = varaajat;
		this.leffat = leffat;
	}

	public Varaus(String tila, List<Varaaja> varaajat, List<Leffa> leffat) {
		super();
		this.tila = tila;
		this.varaajat = varaajat;
		this.leffat = leffat;
	}

	public Long getVarausid() {
		return varausid;
	}

	public void setVarausid(Long varausid) {
		this.varausid = varausid;
	}

	public String getTila() {
		return tila;
	}

	public void setTila(String tila) {
		this.tila = tila;
	}

	public List<Varaaja> getVaraajat() {
		return varaajat;
	}

	public void setVaraajat(List<Varaaja> varaajat) {
		this.varaajat = varaajat;
	}

	public List<Leffa> getLeffat() {
		return leffat;
	}

	public void setLeffat(List<Leffa> leffat) {
		this.leffat = leffat;
	}

	@Override
	public String toString() {
		return "Varaus [varausid=" + varausid + ", tila=" + tila + ", varaajat=" + varaajat + ", leffat=" + leffat
				+ "]";
	}	
}