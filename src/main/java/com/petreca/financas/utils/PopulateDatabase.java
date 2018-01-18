package com.petreca.financas.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;

import com.petreca.financas.model.Categoria;
import com.petreca.financas.model.Cliente;
import com.petreca.financas.model.Conta;
import com.petreca.financas.model.Movimentacao;
import com.petreca.financas.model.TipoMovimentacao;

public class PopulateDatabase {

	public static void main(String[] args) {
		
		Random randomGenerator = new Random();

		EntityManager em = new JPAUtil().getEntityManager();	
		em.getTransaction().begin();
		
		
		
		
		Cliente cliente1 = new Cliente("Joao", "Rua um", "marcineiro");
		Cliente cliente2 = new Cliente("Maria", "Rua dois", "pedreito");
		Cliente cliente3 = new Cliente("José", "Rua tres", "carpinteiro");
		Cliente cliente4 = new Cliente("Geremias", "Rua quatro", "eletricista");
		Cliente cliente5 = new Cliente("Euclides", "Rua cinco", "jardineiro");
		List<Cliente> clientes = Arrays.asList(cliente1,cliente2,cliente3,cliente4,cliente5);
		
		em.persist(cliente1);
		em.persist(cliente2);
		em.persist(cliente3);
		em.persist(cliente4);
		em.persist(cliente5);

		Conta conta1 = new Conta("João", "001 - BANCO DO BRASIL", "13387-8", "1543", cliente1);
		Conta conta2 = new Conta("Alfredo", "002 - BANCO BRADESCO", "16122-4", "1937", cliente2);
		Conta conta3 = new Conta("Godofredo", "003 - BANCO ITAU UNIBANCO", "16987-1", "8833", cliente3);
		Conta conta4 = new Conta("Cleber", "004 - BANCO SANTANDER", "13327-4", "1745", cliente4);
		Conta conta5 = new Conta("Cleber", "005 - CAIXA ECONOMICA FEDERAL", "16657-8", "0097", cliente5);
		List<Conta> contas = Arrays.asList(conta1,conta2,conta3,conta4,conta5);
		
		em.persist(conta1);
		em.persist(conta2);
		em.persist(conta3);
		em.persist(conta4);
		em.persist(conta5);
		
		
		Categoria cat1 = new Categoria("Viagem");
		Categoria cat2 = new Categoria("Automovel");
		Categoria cat3 = new Categoria("Estudos");
		List<Categoria> categorias = Arrays.asList(cat1, cat2, cat3);
		
		em.persist(cat1);
		em.persist(cat2);
		em.persist(cat3);
		
		for (int i = 0; i < 40; i++) {
			Movimentacao movimentacao = new Movimentacao();
			
			List<Categoria> categoriasList = new ArrayList<Categoria>();
			categoriasList.add(categorias.get(randomGenerator.nextInt(categorias.size())));
			movimentacao.setCategorias(categoriasList);
			
			movimentacao.setConta(contas.get(randomGenerator.nextInt(contas.size())));
			
			Calendar randomData = Calendar.getInstance();
			randomData.add(Calendar.DAY_OF_MONTH, randomGenerator.nextInt(5));
			movimentacao.setData(randomData);
			
			movimentacao.setDescricao("****Alguma Descricao***");
			if ((i & 1) == 0) {
				movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
			} else {
				movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
			}
			
			movimentacao.setValor(new BigDecimal(randomGenerator.nextInt(5) * 100));
			
			em.persist(movimentacao);
			
					
		}
		
		
		em.getTransaction().commit();
		em.close();
	}
	
}
