package com.petreca.financas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.petreca.financas.model.Conta;
import com.petreca.financas.model.TipoMovimentacao;
import com.petreca.financas.utils.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		// Retorna a soma
		//String jpql = "select sum(m.valor) from Movimentacao m where m.conta = :pConta and m.tipoMovimentacao = :pTipo";
		
		//Retorna a média
		//String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta and m.tipoMovimentacao = :pTipo";
		
		// Retorna o maior valor
		//String jpql = "select max(m.valor) from Movimentacao m where m.conta = :pConta and m.tipoMovimentacao = :pTipo";
		
		
		// Retorna a media por dia
		String jpql = "select distinct avg(m.valor) from Movimentacao m where m.conta = :pConta and m.tipoMovimentacao = :pTipo group by m.data";
		
//		Query query = em.createQuery(jpql);
//		query.setParameter("pConta", conta);
//		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		TypedQuery query = em.createQuery(jpql, Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		
		//BigDecimal resultado = (BigDecimal) query.getSingleResult();
		//Double resultado = (Double) query.getSingleResult();
		List<Double> resultado = query.getResultList();
		
		
		
		
		System.out.println("O resultado é: " + resultado);
		
		
		em.getTransaction().commit();
		em.close();
	
	}
}
