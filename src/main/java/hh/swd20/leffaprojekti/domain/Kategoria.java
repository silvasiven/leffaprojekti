package hh.swd20.leffaprojekti.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kategoria {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long kategoriaId;
	private String nimi;
	
	@OneToMany(cascade =CascadeType.ALL,mappedBy ="kategoria")
	private List<Leffa> leffat;
	
	public Kategoria() {
	}

	public Kategoria(String nimi) {
		super();
		this.nimi = nimi;
	}

	public Long getKategoriaId() {
		return kategoriaId;
	}

	public void setKategoriaId(Long kategoriaId) {
		this.kategoriaId = kategoriaId;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public List<Leffa> getLeffat(){
		return leffat;
	}
	public void setLeffat(List<Leffa> leffat) {
		this.leffat =leffat;
	}

	@Override
	public String toString() {
		return "Kategoria [kategoriaId=" + kategoriaId + ", nimi=" + nimi + "]";
	}

}
