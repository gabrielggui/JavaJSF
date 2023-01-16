package com.gabriel.projetojpajsf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class JPATest {
	
	@Test
	public void testarConexao() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetojpajsf");
		EntityManager em = emf.createEntityManager();
	}
}
