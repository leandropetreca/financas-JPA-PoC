package com.petreca.financas.testes;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.petreca.financas.model.Conta;
import com.petreca.financas.utils.JPAUtil;

public class TesteConsultaFuncaoCount {
	public static void main(String[] args) {
	    EntityManager manager = new JPAUtil().getEntityManager();
	    Conta conta = manager.find(Conta.class, 2);//id 2 deve existir no banco
	    
	    Query query = manager.createQuery("select count(m) from Movimentacao m where m.conta = :pConta");
	    
	    query.setParameter("pConta", conta);
	    Long quantidade =  (Long) query.getSingleResult();
	    System.out.println("Total de movimentações: " + quantidade);
	    
	    manager.getTransaction().commit();
	    manager.close();

		
	}
}
