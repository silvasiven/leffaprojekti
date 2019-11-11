package hh.swd20.leffaprojekti.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Varaaja {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long varaajaid;
	private String nimi;
	private String puhelinnumero;
	private String lisatiedot;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="varaaja")
	private List<Leffa> leffat;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn (name = "varausid")
	private Varaus varaus;
	
	public Varaaja() {
		
	}
	public Varaaja(Long varaajaid, String nimi, String puhelinnumero, String lisatiedot, Varaus varaus) {
		super();
		this.varaajaid = varaajaid;
		this.nimi = nimi;
		this.puhelinnumero = puhelinnumero;
		this.lisatiedot = lisatiedot;
		this.varaus = varaus;
	}

	public Varaaja(String nimi, String puhelinnumero, String lisatiedot, Varaus varaus) {
		super();
		this.nimi = nimi;
		this.puhelinnumero = puhelinnumero;
		this.lisatiedot = lisatiedot;
		this.varaus=varaus;
	}


	public Long getVaraajaid() {
		return varaajaid;
	}

	public void setVaraajaid(Long varaajaid) {
		this.varaajaid = varaajaid;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getPuhelinnumero() {
		return puhelinnumero;
	}

	public void setPuhelinnumero(String puhelinnumero) {
		this.puhelinnumero = puhelinnumero;
	}

	public String getLisatiedot() {
		return lisatiedot;
	}

	public void setLisatiedot(String lisatiedot) {
		this.lisatiedot = lisatiedot;
	}

	public List<Leffa> getLeffat() {
		return leffat;
	}

	public void setLeffat(List<Leffa> leffat) {
		this.leffat = leffat;
	}
	

	public Varaus getVaraus() {
		return varaus;
	}
	public void setVaraus(Varaus varaus) {
		this.varaus = varaus;
	}
	@Override
	public String toString() {
		return "Varaaja [varaajaid=" + varaajaid + ", nimi=" + nimi + ", puhelinnumero=" + puhelinnumero
				+ ", lisatiedot=" + lisatiedot + ", leffat=" + leffat + ", varaus=" + varaus + "]";
	}




}
