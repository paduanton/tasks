package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q63 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		int par = 0, impar = 0, positivo = 0, negativo = 0;
		
		System.out.println("DIGITE 10 VALORES (n�o esque�a de pressionar enter ap�s digitar cada valor)");
		int v = teclado.nextInt(); int v2= teclado.nextInt();
		int v3 = teclado.nextInt(); int v4 = teclado.nextInt();
		int v5 = teclado.nextInt(); int v6 = teclado.nextInt();
		int v7 = teclado.nextInt(); int v8 = teclado.nextInt();
		int v9 = teclado.nextInt(); int v0 = teclado.nextInt();
		
		    if(v % 2 == 0) {
			par = 1;} if(v2 % 2 == 0) {
			par = par + 1;} if(v3 % 2 == 0) {
			par = par + 1;} if(v4 % 2 == 0) {
			par = par + 1;} if(v5 % 2 == 0) {
			par = par + 1;} if(v6 % 2 == 0) {
			par = par + 1;} if(v7 % 2 == 0) {
			par = par + 1;} if(v8 % 2 == 0) {
			par = par + 1;} if(v9 % 2 == 0) {
			par = par + 1;} if(v0 % 2 == 0) {
			par = par + 1;}

		    if(v % 2 != 0) {
			impar = 1;} if(v2 % 2 != 0) {
			impar = impar + 1;} if(v3 % 2 != 0) {
			impar = impar + 1;} if(v4 % 2 != 0) {
			impar = impar + 1;} if(v5 % 2 != 0) {
			impar = impar + 1;} if(v6 % 2 != 0) {
			impar = impar + 1;} if(v7 % 2 != 0) {
			impar = impar + 1;} if(v8 % 2 != 0) {
			impar = impar + 1;} if(v9 % 2 != 0) {
			impar = impar + 1;} if(v0 % 2 != 0) {
			impar = impar + 1;}

		     if(v < 0) {
			negativo = 1;} if(v2 < 0) {
			negativo = negativo +1;} if(v3 < 0) {
			negativo = negativo +1;} if(v4 < 0) {
			negativo = negativo +1;} if(v5 < 0) {
			negativo = negativo +1;} if(v6 < 0) {
			negativo = negativo +1;} if(v7 < 0) {
			negativo = negativo +1;} if(v8 < 0) {
			negativo = negativo +1;} if(v9 < 0) {
			negativo = negativo +1;} if(v0 < 0) {
			negativo = negativo +1;}

		    if(v > 0) {
			positivo = 1;} if(v2 > 0) {
			positivo = positivo +1;} if(v3 > 0) {
			positivo = positivo +1;} if(v4 > 0) {
			positivo = positivo +1;} if(v5 > 0) {
			positivo = positivo +1;} if(v6 > 0) {
			positivo = positivo +1;} if(v7 > 0) {
			positivo = positivo +1;} if(v8 > 0) {
			positivo = positivo +1;} if(v9 > 0) {
			positivo = positivo +1;} if(v0 > 0) {
			positivo = positivo +1;}
			
			System.out.print("\n" + par + " n�meros s�o pares." + "\n" + impar + " n�meros s�o �mpares." + "\n" + positivo + " n�meros s�o positivos." + "\n" + negativo + " n�meros s�o negativos.");
    }
}