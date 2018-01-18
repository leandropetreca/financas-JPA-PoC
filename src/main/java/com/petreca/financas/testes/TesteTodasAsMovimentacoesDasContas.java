package com.petreca.financas.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.petreca.financas.model.Conta;
import com.petreca.financas.utils.JPAUtil;

public class TesteTodasAsMovimentacoesDasContas {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        // Desse modo vamos ter o problema de n+1 quando chamar o getMovimentacoes | por padrão é Lazy
        //String jpql = "select c from Conta c";
        
        // mudamos de lazy para o comportamento Eager Loading usando join fetch
        //String jpql = "select c from Conta c join fetch c.movimentacoes";

        // Ao usar distinct dizemos ao banco que queremos apenas os resultados diferentes. (sem ele temos um "produto cartesiano" --> trazer uma conta para cada movimentação relacionada a ela)
        // usando o left join para trazer tudo que está do lado esquerdo do join
        String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";
        
        
        Query query = em.createQuery(jpql);

        List<Conta> todasAsContas = query.getResultList();

        for (Conta conta : todasAsContas) {
            System.out.println("Titular: " + conta.getTitular());
            System.out.println("Movimentacoes: ");
            
            System.out.println(conta.getMovimentacoes());
        }
        
        
	}
}
