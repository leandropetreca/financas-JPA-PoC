package com.petreca.financas.Dao;

import javax.persistence.EntityManager;

public class ContaDao {
	
	private EntityManager em;

    public ContaDao(EntityManager manager) {
        this.em = manager;
    }
    
    

}
