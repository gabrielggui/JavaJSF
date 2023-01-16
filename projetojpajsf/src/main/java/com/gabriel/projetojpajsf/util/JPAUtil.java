package com.gabriel.projetojpajsf.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("projetojpajsf");
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
