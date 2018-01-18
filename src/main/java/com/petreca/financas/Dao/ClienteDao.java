package com.petreca.financas.Dao;

import javax.persistence.EntityManager;

public class ClienteDao {

	
	private EntityManager em;

    public ClienteDao(EntityManager manager) {
        this.em = manager;
    }
}
