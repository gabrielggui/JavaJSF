package com.gabriel.projetojpajsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.gabriel.projetojpajsf.model.PerfilUsuario;
import com.gabriel.projetojpajsf.model.Sexo;

@ManagedBean
@RequestScoped
public class DataBean {
	public Sexo[] getSexo() {
		return Sexo.values();
	}
	
	public PerfilUsuario[] getPerfilUsuario() {
		return PerfilUsuario.values();
	}
}
