package Uebungen;

public abstract class Fahrzeug {
	 
		private static int maxGeschwindigkeit = 160;

	private Sitz vorderSitz = new Sitz();
	private Sitz hinterSitz = new Sitz();
	
	public static void BegrenzeGeschwindigkeit(int max) {
		maxGeschwindigkeit = max;
	}
	
	public void Fahren() {
		vorderSitz.Einstellen();
	}
	
	protected void VorderSitzEinstellen() {
		vorderSitz.Einstellen();
	}
	
	private class Sitz {
		public void Einstellen() {
			
		}
		
		public void Heizen() {
			
		}
	}
}
