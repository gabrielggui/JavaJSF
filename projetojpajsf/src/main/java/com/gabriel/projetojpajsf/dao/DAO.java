package com.gabriel.projetojpajsf.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.gabriel.projetojpajsf.util.JPAUtil;

public class DAO<E> {
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	private Class<?> classe;

	public DAO(Class<?> classe) {
		this.entityManager = null;
		this.entityTransaction = null;
		this.classe = classe;
	}

	private void abrirTransacao() {
		this.entityManager = JPAUtil.getEntityManager();
		this.entityTransaction = entityManager.getTransaction();
		this.entityTransaction.begin();
	}

	private void fecharTransacao() {
		this.entityTransaction.commit();
		this.entityManager.close();
	}

	public E salvar(E entidade) {
		abrirTransacao();

		E entidadeRetornada = entityManager.merge(entidade);

		fecharTransacao();

		return entidadeRetornada;
	}

	public E atualizar(E entidade) {
		return salvar(entidade);
	}

	public void deletar(Long id) {
		abrirTransacao();

		entityManager.createQuery("delete from " + classe.getCanonicalName() + " where id = " + id).executeUpdate();

		fecharTransacao();
	}

	public List<E> listar() {

		@SuppressWarnings("unchecked")
		List<E> lista = JPAUtil.getEntityManager()
			.createQuery("select e from " + classe.getCanonicalName() + " e")
			.getResultList();

		return lista;
	}
}
