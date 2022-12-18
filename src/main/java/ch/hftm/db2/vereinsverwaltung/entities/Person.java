package ch.hftm.db2.vereinsverwaltung.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Person {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "PERSID")
    private Long persid;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "VORNAME")
    private String vorname;
    @Basic
    @Column(name = "STRASSE_NR")
    private String strasseNr;
    @Basic
    @Column(name = "PLZ")
    private String plz;
    @Basic
    @Column(name = "ORT")
    private String ort;
    @Basic
    @Column(name = "BEZAHLT")
    private String bezahlt;
    @Basic
    @Column(name = "BEMERKUNGEN")
    private String bemerkungen;
    @Basic
    @Column(name = "EINTRITT")
    private Date eintritt;
    @Basic
    @Column(name = "AUSTRITT")
    private Date austritt;
//    @Basic
//    @Column(name = "STATID")
//    private Long statid;

    @ManyToOne
    @JoinColumn(name = "STATID")
    private Status status;
    @Basic
    @Column(name = "MENTORID")
    private Long mentorid;

//    public Person(){
//    }

//    public Person(Long persid, String name, String vorname, String strasseNr, String plz, String ort, String bezahlt, String bemerkungen, Date eintritt, Date austritt, Long statid, Long mentorid) {
//        this.persid = persid;
//        this.name = name;
//        this.vorname = vorname;
//        this.strasseNr = strasseNr;
//        this.plz = plz;
//        this.ort = ort;
//        this.bezahlt = bezahlt;
//        this.bemerkungen = bemerkungen;
//        this.eintritt = eintritt;
//        this.austritt = austritt;
//        this.statid = statid;
//        this.mentorid = mentorid;
//    }

    public Long getPersid() {
        return persid;
    }

    public void setPersid(Long persid) {
        this.persid = persid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getStrasseNr() {
        return strasseNr;
    }

    public void setStrasseNr(String strasseNr) {
        this.strasseNr = strasseNr;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getBezahlt() {
        return bezahlt;
    }

    public void setBezahlt(String bezahlt) {
        this.bezahlt = bezahlt;
    }

    public String getBemerkungen() {
        return bemerkungen;
    }

    public void setBemerkungen(String bemerkungen) {
        this.bemerkungen = bemerkungen;
    }

    public Date getEintritt() {
        return eintritt;
    }

    public void setEintritt(Date eintritt) {
        this.eintritt = eintritt;
    }

    public Date getAustritt() {
        return austritt;
    }

    public void setAustritt(Date austritt) {
        this.austritt = austritt;
    }

//    public Long getStatid() {
//        return statid;
//    }
//
//    public void setStatid(Long statid) {
//        this.statid = statid;
//    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getMentorid() {
        return mentorid;
    }

    public void setMentorid(Long mentorid) {
        this.mentorid = mentorid;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return Objects.equals(persid, person.persid) && Objects.equals(name, person.name) && Objects.equals(vorname, person.vorname) && Objects.equals(strasseNr, person.strasseNr) && Objects.equals(plz, person.plz) && Objects.equals(ort, person.ort) && Objects.equals(bezahlt, person.bezahlt) && Objects.equals(bemerkungen, person.bemerkungen) && Objects.equals(eintritt, person.eintritt) && Objects.equals(austritt, person.austritt) && Objects.equals(statid, person.statid) && Objects.equals(mentorid, person.mentorid);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(persid, person.persid) && Objects.equals(name, person.name) && Objects.equals(vorname, person.vorname) && Objects.equals(strasseNr, person.strasseNr) && Objects.equals(plz, person.plz) && Objects.equals(ort, person.ort) && Objects.equals(bezahlt, person.bezahlt) && Objects.equals(bemerkungen, person.bemerkungen) && Objects.equals(eintritt, person.eintritt) && Objects.equals(austritt, person.austritt) && Objects.equals(status.getId(), person.status.getId()) && Objects.equals(mentorid, person.mentorid);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(persid, name, vorname, strasseNr, plz, ort, bezahlt, bemerkungen, eintritt, austritt, statid, mentorid);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(persid, name, vorname, strasseNr, plz, ort, bezahlt, bemerkungen, eintritt, austritt, status.getId(), mentorid);
    }
}
