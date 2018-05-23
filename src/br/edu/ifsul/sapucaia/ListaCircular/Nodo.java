package br.edu.ifsul.sapucaia.ListaCircular;
import java.util.Scanner;
/**
 * @author anton
 *
 * Instituto Federal Campus Sapucaia do Sul 
 * Técnico Em Informática 
 * Aluno: Antonio Júnior
 * Turma: 3I 
 */

public class Nodo {
	private int valor;
	private Nodo prox;
	private Nodo ant;
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public Nodo getProx() {
		return prox;
	}
	public void setProx(Nodo prox) {
		this.prox = prox;
	}
	public Nodo getAnt() {
		return ant;
	}
	public void setAnt(Nodo ant) {
		this.ant = ant;
	}
	
}
