package ch.hftm.db2.vereinsverwaltung.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "STATUS")
public class Status {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "STATID")
	private Long id;
	
	@Column(name = "BEZEICHNER")
	private String bezeichner;
	
	@Column(name = "BEITRAG")
	private Integer beitrag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBezeichner() {
		return bezeichner;
	}

	public void setBezeichner(String bezeichner) {
		this.bezeichner = bezeichner;
	}

	public Integer getBeitrag() {
		return beitrag;
	}

	public void setBeitrag(Integer beitrag) {
		this.beitrag = beitrag;
	}
}