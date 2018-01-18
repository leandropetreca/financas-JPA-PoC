package com.petreca.financas.testes;

import javax.persistence.EntityManager;

import com.petreca.financas.model.Cliente;
import com.petreca.financas.model.Conta;
import com.petreca.financas.utils.JPAUtil;

public class TestaContaCliente {

	public static void main(String[] args) {
		
		
		Cliente cliente = new Cliente();
		cliente.setNome("Joao");
		cliente.setEndereco("blablablalba");
		cliente.setProfissao("Engenheiro");
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Doug Fany");
		cliente2.setEndereco("blablablalba");
		cliente2.setProfissao("Prof de historia");		
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1);
		Conta conta2 = em.find(Conta.class, 2);
		
		cliente.setConta(conta);
		cliente2.setConta(conta2);		
		
		em.persist(cliente);
		em.persist(cliente2);
		
		em.getTransaction().commit();
		em.close();
		
				
		
	}
}
