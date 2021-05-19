package factory;

import models.Calculadora;
import models.CalculadoraDivisao;
import models.CalculadoraMultiplicacao;
import models.CalculadoraSoma;
import models.CalculadoraSubtracao;

public class CalculadoraFactory {

	public static Calculadora factory(int escolha) {
		switch (escolha) {
		case 1 :
			return new CalculadoraSoma();
		case 2 :
			return new CalculadoraSubtracao();
		case 3 :
			return new CalculadoraMultiplicacao();
		case 4 :
			return new CalculadoraDivisao();
		}
		return null;
	}
	
}
