package hh.swd20.leffaprojekti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Leffa {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	
	private Long id;
	private String nimi;
	private String genre;
	private String ohjaaja;
	private String paanayttelija;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn (name = "kategoriaid")
	private Kategoria kategoria;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn (name ="varaajaid")
	private Varaaja varaaja;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn (name = "varausid")
	private Varaus varaus;
	
	public Leffa() {	
	}

	public Leffa(Long id, String nimi, String genre, String ohjaaja, String paanayttelija, Kategoria kategoria, Varaaja varaaja, Varaus varaus) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.genre = genre;
		this.ohjaaja = ohjaaja;
		this.paanayttelija = paanayttelija;
		this.kategoria = kategoria;
		this.varaaja = varaaja;
		this.varaus = varaus;
	
	}

	public Leffa(String nimi, String genre, String ohjaaja, String paanayttelija,Kategoria kategoria, Varaaja varaaja, Varaus varaus) {
		super();
		this.nimi = nimi;
		this.genre = genre;
		this.ohjaaja = ohjaaja;
		this.paanayttelija = paanayttelija;
		this.kategoria = kategoria;
		this.varaaja = varaaja;
		this.varaus = varaus;
	}
	

	public Leffa(Long id, String nimi, String genre, String ohjaaja, String paanayttelija, Kategoria kategoria) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.genre = genre;
		this.ohjaaja = ohjaaja;
		this.paanayttelija = paanayttelija;
		this.kategoria = kategoria;
	}
	


	public Leffa(String nimi, String genre, String ohjaaja, String paanayttelija, Kategoria kategoria) {
		super();
		this.nimi = nimi;
		this.genre = genre;
		this.ohjaaja = ohjaaja;
		this.paanayttelija = paanayttelija;
		this.kategoria = kategoria;
	}

	public Kategoria getKategoria() {
		return kategoria;
	}

	public void setKategoria(Kategoria kategoria) {
		this.kategoria = kategoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getOhjaaja() {
		return ohjaaja;
	}

	public void setOhjaaja(String ohjaaja) {
		this.ohjaaja = ohjaaja;
	}

	public String getPaanayttelija() {
		return paanayttelija;
	}

	public void setPaanayttelija(String paanayttelija) {
		this.paanayttelija = paanayttelija;
	
	}

	public Varaaja getVaraaja() {
		return varaaja;
	}

	public void setVaraaja(Varaaja varaaja) {
		this.varaaja = varaaja;
	}

	public Varaus getVaraus() {
		return varaus;
	}

	public void setVaraus(Varaus varaus) {
		this.varaus = varaus;
	}

	@Override
	public String toString() {
		return "Leffa [id=" + id + ", nimi=" + nimi + ", genre=" + genre + ", ohjaaja=" + ohjaaja + ", paanayttelija="
				+ paanayttelija + ", kategoria=" + kategoria + ", varaaja=" + varaaja + ", varaus=" + varaus + "]";
	}

	
	
	
}

	