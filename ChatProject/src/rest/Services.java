package rest;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Services {
	private static EntityManagerFactory entityManagerFactory;
	private static History history;

	public synchronized static History getHistory() {
		if (history == null) {
			history = new History();
		}
		return history;
	}
	

	public synchronized static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			try {
				Class.forName("org.apache.derby.jdbc.ClientDriver");
			} catch (ClassNotFoundException e) {
				throw new IllegalStateException("No driver", e);
			}
			entityManagerFactory = Persistence.createEntityManagerFactory("Datasa");
		}
		return entityManagerFactory;
	}
}
