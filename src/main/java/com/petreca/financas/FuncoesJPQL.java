package com.petreca.financas;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.petreca.financas.Dao.MovimentacaoDao;
import com.petreca.financas.model.Conta;
import com.petreca.financas.model.TipoMovimentacao;
import com.petreca.financas.utils.JPAUtil;

public class FuncoesJPQL {

	public static void main(String[] args) {
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		
		// Usando @NamedQuery no modelo, (@NamedQuery são processador quando inicia o hibernate, se estiver errado ele já avisa)
		TypedQuery<Double> typedQuery = em.createNamedQuery("MediaPorDiaETipo", Double.class);
		typedQuery.setParameter("pConta", conta);
		typedQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		
		List<Double> medias = typedQuery.getResultList();
		
		for (Double resultado : medias) {
			System.out.println("Media do dia: " + resultado);
		}
		
		// Usando DAO para executar querys
		MovimentacaoDao movDao = new MovimentacaoDao(em);
		
		BigDecimal soma = movDao.getSomaPorContaETipo(TipoMovimentacao.SAIDA, conta);
		System.out.println("Soma: " + soma);
		
		Double mediaContaTipo = movDao.getMediaPorContaETipo(TipoMovimentacao.SAIDA, conta);
		System.out.println("Media por Conta e Tipo: " + mediaContaTipo);
		
		BigDecimal maxValor = movDao.getMaxPorContaETipo(TipoMovimentacao.SAIDA, conta);
		System.out.println("Maior Valor: " + maxValor);
		

	
		
		em.getTransaction().commit();
		em.close();
		
	}
}
