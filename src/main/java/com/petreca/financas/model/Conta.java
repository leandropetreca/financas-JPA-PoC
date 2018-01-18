package com.petreca.financas.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titular;
	private String banco;
	private String agencia;
	private String numero;
	
	@OneToOne
	@JoinColumn(unique=true)
	private Cliente cliente;
	
	@OneToMany(mappedBy="conta")
	private List<Movimentacao> movimentacoes;
	
	
	
	
	public Conta(String titular, String banco, String agencia, String numero, Cliente cliente) {
		
		this.titular = titular;
		this.banco = banco;
		this.agencia = agencia;
		this.numero = numero;
		this.cliente = cliente;
	}
	
	
	public Conta() {
		
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}


	public List<Movimentacao> getMovimentacoes() {	   
	    return movimentacoes;
	}

}
