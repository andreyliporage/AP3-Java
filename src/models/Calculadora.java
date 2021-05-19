package models;

public abstract class Calculadora {
		
	public Calculadora() {
		
	}
	
	public Integer soma(int x, int y) {
		return Integer.sum(x, y);
	}
	
	public Integer subtrai(int x, int y) {
		return x - y;
	}
	
	public Integer divide(int x, int y) {
		return (x / y);
	}
	
	public Integer multiplica(int x, int y) {
		return x * y;
	}
}
