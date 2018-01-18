package com.petreca.financas;

import java.util.List;

import javax.persistence.EntityManager;

import com.petreca.financas.model.Conta;
import com.petreca.financas.model.Movimentacao;
import com.petreca.financas.utils.JPAUtil;

public class TesteInserirMovimentacao {
	
	public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();

        Conta conta = em.find(Conta.class, 1);

        List<Movimentacao> movimentacoes = conta.getMovimentacoes();

        em.close();

        for (Movimentacao movimentacao : movimentacoes) {
            System.out.println("Movimentação: " + movimentacao.getDescricao());
        }

    }
}
