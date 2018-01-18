package com.petreca.financas;

import javax.persistence.EntityManager;

import com.petreca.financas.model.Conta;
import com.petreca.financas.utils.JPAUtil;


public class TestaConta 
{
    public static void main( String[] args )
    {
        
    		Conta conta = new Conta();
    		conta.setTitular("Jucilei");
    		conta.setBanco("bradesco");
    		conta.setAgencia("123");
    		conta.setNumero("23432");
    		
    		EntityManager em = new JPAUtil().getEntityManager();
    		em.getTransaction().begin();
    		
    		em.persist(conta);
    		em.getTransaction().commit();
    		em.close();
    		
       
    }
}
