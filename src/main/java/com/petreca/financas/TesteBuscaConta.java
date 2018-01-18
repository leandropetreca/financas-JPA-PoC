package com.petreca.financas;

import javax.persistence.EntityManager;

import com.petreca.financas.model.Conta;
import com.petreca.financas.utils.JPAUtil;

public class TesteBuscaConta {
	
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1);
		System.out.println(conta.getTitular());
		
		em.getTransaction().commit();
		em.close();
	}
	
	

	
	
	

}
