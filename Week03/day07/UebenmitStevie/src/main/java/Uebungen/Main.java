package Uebungen;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Test");
		
		IConfig c = new Config();
		ApplyMyConfig(c);
		
		Auto auto = new Auto();
		auto.Fahren();
		auto.VorderSitzEinstellen();
		
		Auto zweitAuto = new Auto();
		
		Fahrzeug.BegrenzeGeschwindigkeit(120);
	}
	
	public static void ApplyMyConfig(IConfig myConfig) {
		myConfig.LoadVar();
	}
}
