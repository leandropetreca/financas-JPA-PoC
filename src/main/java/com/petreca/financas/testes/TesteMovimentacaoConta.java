package com.petreca.financas.testes;

import javax.persistence.EntityManager;

import com.petreca.financas.model.Conta;
import com.petreca.financas.model.Movimentacao;
import com.petreca.financas.utils.JPAUtil;

public class TesteMovimentacaoConta {
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        // testando o relacionamento reverso
        Movimentacao movimentacao = em.find(Movimentacao.class, 3);
        Conta conta = movimentacao.getConta();

        System.out.println(conta.getMovimentacoes().size());
		
	}
}
