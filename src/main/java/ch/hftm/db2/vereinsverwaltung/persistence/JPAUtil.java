package ch.hftm.db2.vereinsverwaltung.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.hibernate.HibernateException;

public class JPAUtil {

	// Globale, Thread-sichere, einmal erzeugte
	// EntityManagerFactory-Instanz
	private static final EntityManagerFactory emFactory;

	// Statischer Initialisierer, der einmalig pro Applikation eine EntityManagerFactory erzeugt
	static {
		try {
			// Erzeugung der EntityManagerFactory
			emFactory = Persistence
					.createEntityManagerFactory("ch.hftm.db2.vereinsverwaltung");
		} catch (Throwable ex) {
			System.err.println("Initial EntityManagerFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	// Die ThreadLocal-Instanz bindet die von der
	// EntityManagerFactory gelieferte EntityManager-Instanz
	// an den aktuellen Thread
	public static final ThreadLocal<EntityManager> entityManagerSession = new ThreadLocal<EntityManager>();

	public static EntityManager currentEntityManager() throws HibernateException {
		EntityManager em = (EntityManager) entityManagerSession.get();
		// Öffnet einen neuen EntityManager, falls der aktuelle
		// Thread noch keinen besitzt
		if (em == null) {
			em = emFactory.createEntityManager();
			entityManagerSession.set(em);
		}
		return em;
	}

	public static void closeEntityManager() {
		EntityManager em = (EntityManager) entityManagerSession.get();
		entityManagerSession.set(null);
		if (em != null)
			em.close();
	}

	// Beim Beenden der Applikation
	public static void closeEntityManagerFactory() {
		emFactory.close();
	}
}
