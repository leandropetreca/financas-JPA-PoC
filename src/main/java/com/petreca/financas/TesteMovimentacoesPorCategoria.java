package com.petreca.financas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.petreca.financas.model.Categoria;
import com.petreca.financas.model.Movimentacao;
import com.petreca.financas.utils.JPAUtil;

public class TesteMovimentacoesPorCategoria {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		
		Categoria categoria = new Categoria();
		categoria.setId(3);
		
		String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		
		List<Movimentacao> resultados = query.getResultList();
		
		for (Movimentacao movimentacao : resultados) {
			System.out.println("Desc: " + movimentacao.getDescricao());
			System.out.println("id: " + movimentacao.getId());
		}
		
		
		em.getTransaction().commit();
		em.close();
				
		
		
	}
}
