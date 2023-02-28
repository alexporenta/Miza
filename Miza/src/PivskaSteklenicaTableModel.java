/*
			Ime datoteke: Steklenica.java
			Avtor:		  Aleksander Porenta
			Vhodni podatki: /
			Opis:			/
			Izhodni podatki:Steklenica
			
		*/
		import javax.swing.table.*;
		public class PivskaSteklenicaTableModel extends DefaultTableModel {
	
		public PivskaSteklenicaTableModel() {
			
		super();
		
		//v tabelo dodamo stolpce
		addColumn("Znamka");
		addColumn("Stopnja alkohola");
		
		//dodamo naslovno vrstico
	
		Object[] vrstica = new Object[] {"Znamka test", "Stopnja test"};
		//Dodamo vrstico v tabelo
		System.out.println("Dodajam vrstico");
		addRow(vrstica);
		
		
	}
		
        // Vhodni parametri: ps - pivska steklenica
        // Potek/opis: doda steklenico  v tabelo
        // Vrne vrednost: /
		public void addPivskaSteklenica(PivskaSteklenica ps)  {
			
			//ustvarimo statičen seznam objektov
			Object[] vrstica = new Object[] {ps.getZnamkaKolicina(), ps.getStopnjaAlkohola()};
			//Dodamo vrstico v tabelo
			addRow(vrstica);
			System.out.println("Dodajam vrstico");
		}
		
	}