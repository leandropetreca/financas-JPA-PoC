package com.petreca.financas;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import com.petreca.financas.model.Conta;
import com.petreca.financas.model.Movimentacao;
import com.petreca.financas.model.TipoMovimentacao;
import com.petreca.financas.utils.JPAUtil;

public class TesteJPARelacionamento {
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setAgencia("111");
		conta.setBanco("Itau");
		conta.setNumero("2342332");
		conta.setTitular("Lula");
		
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance()); 
		movimentacao.setDescricao("churrascaria");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("200.0"));
		
		movimentacao.setConta(conta);
			
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(conta);
		manager.persist(movimentacao);
		
		manager.getTransaction().commit();
		manager.clear();
		
				
	}
}
