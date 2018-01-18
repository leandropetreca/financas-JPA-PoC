package com.petreca.financas.testes;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import com.petreca.financas.Dao.MovimentacaoDao;
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
		
		
			
		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDao movDao = new MovimentacaoDao(em);
		
		
		em.getTransaction().begin();
		
		movDao.addMovimentacao(movimentacao, conta);
		
		em.getTransaction().commit();
		em.clear();
		
				
	}
}
