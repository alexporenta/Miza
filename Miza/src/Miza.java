/*
			Ime datoteke: Steklenica.java
			Avtor:		  Aleksander Porenta
			Vhodni podatki: /
			Opis:			/
			Izhodni podatki:Steklenica
			
		*/
	

// Uvozimo pakete za delo z GUI
import javax.swing.*;

//Uvozimo paket za delo z dogodki
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;
// Deklariramo javni razred
public class Miza extends JFrame implements ActionListener {

        // Deklariramo zasebne lastnosti
        private JPanel povrsina;
        private JButton dodajJButton;
        private JTextField znamkaPolje, alkoholPolje;
		private JTable tabela;
		private PivskaSteklenicaTableModel modelTabele;

        // Deklariramo javno statično metodo, ki se izvede ob zagonu programa
        // Vhodni parametri: vhodni parametri iz konzole
        // Potek/opis: ustvari novo okno
        // Vrne vrednost: /
        public static void main(String[] args) {
        
                Miza m = new Miza("Miza s pivskimi steklenicami");
                
        }
        
        // Javni konstruktor
        // Vhodni parametri: n - naslov okna
        // Potek/opis: ustvari nov objekt tipa Miza
        // Vrne vrednost: nov objekt
        public Miza(String n) {
                
                // Kličemo konstruktor nadrazreda
                super(n);
                
                // Inicializiramo zasebne lastnosti
                povrsina = new JPanel();
                dodajJButton = new JButton("Dodaj steklenico");
                dodajJButton.setForeground(UIManager.getColor("Button.darkShadow"));
                dodajJButton.setBackground(new Color(0, 0, 102));
                znamkaPolje = new JTextField(32);
                alkoholPolje = new JTextField(8);
                alkoholPolje.setFont(new Font("Tahoma", Font.BOLD, 13));
                alkoholPolje.setToolTipText("sem vnesete znamko piva");
				modelTabele = new PivskaSteklenicaTableModel();
				tabela = new JTable(modelTabele);
                
                // Površino damo na mizo
                getContentPane().add(povrsina);
				
				dodajJButton.addActionListener(this);
                
                // Dodamo gumb in vnosna polja na površino
                JLabel label = new JLabel("Znamka:");
                label.setLabelFor(znamkaPolje);
                povrsina.add(label);
                povrsina.add(znamkaPolje);
                JLabel label_1 = new JLabel("Stopnja alkohola:");
                label_1.setLabelFor(alkoholPolje);
                povrsina.add(label_1);
                povrsina.add(alkoholPolje);
                povrsina.add(dodajJButton);
                povrsina.add(tabela);    
                // Pokažemo okno
                setVisible(true);
                
                // Nastavimo velikost
                setSize(800, 600);
                
                // Nastavimo obnašanje križca (x) - da konča aplikacijo
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                System.out.println("Ustvarjam nov objekt tipa Miza");
                
        }
		// Metoda ki jo predpisuje vmestnik ActionListener
        // Vhodni parametri: dogodek
        // Potek/opis: doda steklenico na seznam v tabelo
        // Vrne vrednost: /
		public void actionPerformed(ActionEvent ae) {
			
			System.out.println("Dodajam steklenico ...");
			System.out.println("Znamka je " + znamkaPolje.getText());
			System.out.println("stopnja alkohola je" + alkoholPolje.getText());
			
			//Ustvarimo lokalno spremenljivko flasa
			//double d = Double.parseDouble(alkoholPolje.getText());
			//PivskaSteklenica flasa = new PivskaSteklenica(znamkaPolje.getText(),500, d);
			
			//dodamo model v seznam
			modelTabele.addPivskaSteklenica(new PivskaSteklenica(znamkaPolje.getText(),500, Double.parseDouble(alkoholPolje.getText())));
			
		}
}