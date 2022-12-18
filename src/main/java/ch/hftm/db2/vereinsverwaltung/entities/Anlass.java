package ch.hftm.db2.vereinsverwaltung.entities;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Anlass {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ANLAID")
    private BigInteger anlaid;
    @Basic
    @Column(name = "BEZEICHNER")
    private String bezeichner;
    @Basic
    @Column(name = "ORT")
    private String ort;
    @Basic
    @Column(name = "DATUM")
    private Date datum;
    @Basic
    @Column(name = "KOSTEN")
    private Integer kosten;
    @Basic
    @Column(name = "ORGID")
    private BigInteger orgid;

    public BigInteger getAnlaid() {
        return anlaid;
    }

    public void setAnlaid(BigInteger anlaid) {
        this.anlaid = anlaid;
    }

    public String getBezeichner() {
        return bezeichner;
    }

    public void setBezeichner(String bezeichner) {
        this.bezeichner = bezeichner;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Integer getKosten() {
        return kosten;
    }

    public void setKosten(Integer kosten) {
        this.kosten = kosten;
    }

    public BigInteger getOrgid() {
        return orgid;
    }

    public void setOrgid(BigInteger orgid) {
        this.orgid = orgid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anlass anlass = (Anlass) o;
        return Objects.equals(anlaid, anlass.anlaid) && Objects.equals(bezeichner, anlass.bezeichner) && Objects.equals(ort, anlass.ort) && Objects.equals(datum, anlass.datum) && Objects.equals(kosten, anlass.kosten) && Objects.equals(orgid, anlass.orgid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anlaid, bezeichner, ort, datum, kosten, orgid);
    }
}
