package com.petreca.financas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.petreca.financas.model.Conta;
import com.petreca.financas.model.Movimentacao;
import com.petreca.financas.model.TipoMovimentacao;
import com.petreca.financas.utils.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		String jpql = "select m from Movimentacao m where m.conta = :pConta and m.tipoMovimentacao = :pTipo order by m.valor desc" ;
		Query query = em.createQuery(jpql);
		
			
		
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
		
		List<Movimentacao> resultados = query.getResultList();
		
		for (Movimentacao movimentacao : resultados) {
			System.out.println("Desc: " +  movimentacao.getDescricao());
			System.out.println("id: " +  movimentacao.getId());
		}
		
		em.getTransaction().commit();
		em.close();
	
	}
}
