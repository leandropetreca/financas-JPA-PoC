package com.petreca.financas.Dao;

import javax.persistence.EntityManager;

public class CategoriaDao {

	private EntityManager em;

    public CategoriaDao(EntityManager manager) {
        this.em = manager;
    }
}
