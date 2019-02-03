package murat.swings.samples.main.frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AnaFrame extends JFrame{
	private JTextField txtUyari;
	public AnaFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\MALZEME-Temp0007.jpeg"));
		getContentPane().setBackground(new Color(192, 192, 192));
		setBackground(new Color(102, 153, 0));
		setTitle("Giri\u015F Paneli");
		//setSize(200, 200); //default boyutu
		setBounds(150, 150, 361, 335);//ekranda cikacagi yer ve boyutu
		getContentPane().setLayout(null);
		
		JLabel lblUyari = new JLabel("Uyari");
		lblUyari.setBounds(10, 40, 82, 17);
		lblUyari.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUyari.setHorizontalAlignment(SwingConstants.CENTER);
		lblUyari.setForeground(new Color(204, 0, 0));
		lblUyari.setBackground(new Color(102, 0, 255));
		getContentPane().add(lblUyari);//label frame'e eklenir.
		
		txtUyari = new JTextField();
		txtUyari.setEditable(false);
		txtUyari.setBounds(109, 40, 115, 20);
		getContentPane().add(txtUyari);
		txtUyari.setColumns(10);
		
		/*JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(50, 50, 25, 25);
		getContentPane().add(btnNewButton);
		
		
		JButton button_1 = new JButton("");
		button_1.setBounds(74, 50, 25, 25);
		getContentPane().add(button_1);

		JButton button = new JButton("");
		button.setBounds(98, 50, 25, 25);
		getContentPane().add(button);

		
		JButton button_5 = new JButton("");
		button_5.setBounds(100, 119, 36, 23);
		getContentPane().add(button_5);
		
		
		JButton button_2 = new JButton("");
		button_2.setBounds(96, 170, 36, 23);
		getContentPane().add(button_2);
		

		
		JButton button_3 = new JButton("");
		button_3.setBounds(142, 170, 36, 23);
		getContentPane().add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setBounds(188, 170, 36, 23);
		getContentPane().add(button_4);
		

		
		JButton button_6 = new JButton("");
		button_6.setBounds(142, 136, 36, 23);
		getContentPane().add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setBounds(188, 136, 36, 23);
		getContentPane().add(button_7);*/
	}
	
	public void veriAl(String isim, String deger)
	{
		if(isim.equals("txtUyari"))
		{
			txtUyari.setText(deger);					
		}
	}
}
