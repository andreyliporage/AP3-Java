package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import factory.CalculadoraFactory;
import models.Calculadora;
import models.CalculadoraDivisao;
import models.CalculadoraMultiplicacao;
import models.CalculadoraSoma;
import models.CalculadoraSubtracao;

public class Main {
	
	private static List<Integer> valoresInputados = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Olá! Como vai? Espero que esteja tudo bem!");
		int escolha = 1;
		
		while(escolha == 1) {
			try {
				System.out.println("Qual operação você quer realizar?");
				System.out.println("1 - Adição | 2 - Subtração | 3 - Multiplicação | 4 - Divisão");
				int operacao = scan.nextInt();
				System.out.println("Entre com o primeiro valor inteiro: ");
				int x = scan.nextInt();
				System.out.println("Entre com o segundo valor inteiro: ");
				int y = scan.nextInt();
				Calculadora calculadora = CalculadoraFactory.factory(operacao);
				System.out.println("Resultado: " + Main.verificaInstancia(calculadora, x, y));
			} catch (InputMismatchException e) { 
				System.out.println("Lembre-se que estamos trabalhando somente com números inteiros :)");
				System.out.println("Rode a aplicação novamente");
				break;
			} catch (ArithmeticException e) {
				System.out.println("Segundo as leis da matemática, não é possível dividir um número por zero :(");
			} catch (Exception e) {
				System.out.println("Algum erro interno aconteceu. Rode o programa novamente!");
			}
			
			System.out.println("1 - Fazer outra operação | 0 - Sair da aplicação");
			escolha = scan.nextInt();
		}
		scan.close();
		
		Main.despedida();
	}
	
	public static int verificaInstancia(Calculadora calculadora, int a, int b) throws Exception {
		Main.adicionaValoresALista(a, b);
		if (calculadora instanceof CalculadoraSoma) {
			return calculadora.soma(a, b);
		} else if (calculadora instanceof CalculadoraSubtracao) {
			return calculadora.subtrai(a, b);
		} else if (calculadora instanceof CalculadoraMultiplicacao) {
			return calculadora.multiplica(a, b);
		} else if (calculadora instanceof CalculadoraDivisao) {
			return calculadora.divide(a, b);
		} else {
			throw new Exception("Erro interno!");
		}
	}
	
	public static void adicionaValoresALista(int a, int b) {
		Main.valoresInputados.addAll(Arrays.asList(a, b));
	}
	
	public static void despedida() {
		System.out.println("Uma curiosidade antes de você partir: ");
		System.out.println("Você digitou os seguintes números: " + Main.valoresInputados.toString());
		System.out.println("E a soma entre esses valores é " + Main.somaValoresLista());
	}
	
	public static int somaValoresLista() {
		int soma = 0;
		for (Integer valor : valoresInputados) {
			soma += valor;
		}
		return soma;
	}
	
}