package com.gabriel.projetojpajsf.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.gabriel.projetojpajsf.util.JPAUtil;

@WebFilter(urlPatterns = {"/*"})//padrão intercepta todas as URLs
public class FilterAutenticacao implements Filter {
	/**
	 * Executado ao iniciar o servidor
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		JPAUtil.getEntityManager();
		
	}
	
	/**
	 * Executado em todas as requisições
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
