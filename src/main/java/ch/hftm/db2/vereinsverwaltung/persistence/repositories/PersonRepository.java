package ch.hftm.db2.vereinsverwaltung.persistence.repositories;

import ch.hftm.db2.vereinsverwaltung.entities.Funktion;
import ch.hftm.db2.vereinsverwaltung.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PersonRepository {
    EntityManager entityManager;

    public PersonRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void insert(Person person){
        this.entityManager.persist(person);
    }

    public void delete(long id) {
        Person person = findById(id);
        if (person != null) {
            this.entityManager.remove(person);
        }
    }

    public Person findById(long id) {
        return this.entityManager.find(Person.class, id);
    }

    public List<Person> findByName(String name) {
        String searchString = "%" + name +"%";
        TypedQuery <Person> query = this.entityManager.createQuery("SELECT p FROM Person p WHERE p.name LIKE :name", Person.class);
        query.setParameter("name", searchString);
        return query.getResultList();
    }

    public List<Person> findByVorname(String vorname) {
        String searchString = "%" + vorname +"%";
        TypedQuery <Person> query = this.entityManager.createQuery("SELECT p FROM Person p WHERE p.vorname LIKE :vorname", Person.class);
        query.setParameter("vorname", searchString);
        return query.getResultList();
    }

    public List<Person> findByOrt(String ort) {
        String searchString = "%" + ort +"%";
        TypedQuery <Person> query = this.entityManager.createQuery("SELECT p FROM Person p WHERE p.ort LIKE :ort", Person.class);
        query.setParameter("ort", searchString);
        return query.getResultList();
    }

    public List<Person> findByPLZ(String plz) {
        String searchString = "%" + plz +"%";
        TypedQuery <Person> query = this.entityManager.createQuery("SELECT p FROM Person p WHERE p.plz LIKE :plz", Person.class);
        query.setParameter("plz", searchString);
        return query.getResultList();
    }
}