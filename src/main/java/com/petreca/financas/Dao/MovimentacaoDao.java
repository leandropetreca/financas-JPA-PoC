package com.petreca.financas.Dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.petreca.financas.model.Conta;
import com.petreca.financas.model.Movimentacao;
import com.petreca.financas.model.TipoMovimentacao;

public class MovimentacaoDao {

	
	private EntityManager em;

    public MovimentacaoDao(EntityManager manager) {
        this.em = manager;
    }
    
    
    public List<Double> getMediasPorDiaETipo(TipoMovimentacao tipoMovimentacao, Conta conta) {

        String jpql = "select distinct avg(m.valor) from Movimentacao m where m.conta = :pConta and m.tipoMovimentacao = :pTipo group by m.data";

        // TypedQuery,  indicamos explicitamente o tipo de query que será retornado
        TypedQuery<Double> query = em.createQuery(jpql, Double.class);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", tipoMovimentacao);

        return query.getResultList();

    }
    
    
    // usando sum para retornar a soma
    public BigDecimal getSomaPorContaETipo(TipoMovimentacao tipoMovimentacao, Conta conta) {

        String jpql = "select sum(m.valor) from Movimentacao m where m.conta = :pConta and m.tipoMovimentacao = :pTipo";

        Query query = em.createQuery(jpql);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", tipoMovimentacao);

        
        return (BigDecimal) query.getSingleResult();

    }
    
    
 // usando svg para retornar a média
    public Double getMediaPorContaETipo(TipoMovimentacao tipoMovimentacao, Conta conta) {

        String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta and m.tipoMovimentacao = :pTipo";

        Query query = em.createQuery(jpql);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", tipoMovimentacao);

        
        return (Double) query.getSingleResult();

    }
    
    // usando max para retornar o maior valor
    public BigDecimal getMaxPorContaETipo(TipoMovimentacao tipoMovimentacao, Conta conta) {

        String jpql = "select max(m.valor) from Movimentacao m where m.conta = :pConta and m.tipoMovimentacao = :pTipo";

        Query query = em.createQuery(jpql);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", tipoMovimentacao);

        
        return (BigDecimal) query.getSingleResult();

    }


	public void addMovimentacao(Movimentacao movimentacao, Conta conta) {
		
		em.persist(conta);
		em.persist(movimentacao);
		
		
	}

    
    
}
