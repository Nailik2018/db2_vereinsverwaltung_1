package ch.hftm.db2.vereinsverwaltung.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "FUNKTION")
public class Funktion {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "FUNKID")
    private Long id;

    @Column(name = "BEZEICHNER")
    private String bezeichner;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getBezeichner() {
        return bezeichner;
    }

    public void setBezeichner(String bezeichner) {
        this.bezeichner = bezeichner;
    }
}
