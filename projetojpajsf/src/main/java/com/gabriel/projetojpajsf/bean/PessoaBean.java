package com.gabriel.projetojpajsf.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.gabriel.projetojpajsf.dao.DAO;
import com.gabriel.projetojpajsf.model.Pessoa;

@ViewScoped
@ManagedBean
public class PessoaBean {

	private final DAO<Pessoa> dao;
	private List<Pessoa> listaDePessoas;
	private Pessoa pessoa;

	public PessoaBean() {
		dao = new DAO<>(Pessoa.class);
		pessoa = new Pessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String salvar() {
		pessoa = this.dao.salvar(pessoa);
		limparCampos();
		return "";
	}

	public String deletar() {
		this.dao.deletar(this.pessoa.getId());
		pessoa = new Pessoa();
		limparCampos();
		return "";
	}
	
	@PostConstruct
	public void atualizarListaDePessoas() {
		listaDePessoas = this.dao.listar();
	}
	
	public List<Pessoa> getListaDePessoas(){
		return this.listaDePessoas;
	}
	
	public String limparCampos() {
		pessoa = new Pessoa();
		atualizarListaDePessoas();
		return "";
	}

}
