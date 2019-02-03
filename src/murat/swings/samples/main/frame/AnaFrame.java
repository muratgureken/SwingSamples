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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnaFrame extends JFrame{
	private JTextField txtUyari;
	private JTextField textKullaniciAdi;
	private JTextField textSifre;
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
		
		textKullaniciAdi = new JTextField();
		textKullaniciAdi.setBounds(138, 87, 86, 20);
		getContentPane().add(textKullaniciAdi);
		textKullaniciAdi.setColumns(10);
		
		textSifre = new JTextField();
		textSifre.setBounds(127, 135, 86, 20);
		getContentPane().add(textSifre);
		textSifre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblNewLabel.setBounds(36, 90, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u015Eifre");
		lblNewLabel_1.setBounds(36, 138, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnIptal = new JButton("Iptal");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnIptal.setBounds(36, 193, 91, 23);
		getContentPane().add(btnIptal);
		
		JButton btnGiris = new JButton("Giri\u015F");
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textKullaniciAdi.getText().equals("Murat"))
				{
					if(textSifre.getText().equals(1))
					{
						AnaFrame temp = new AnaFrame();
						temp.setVisible(true);
						Layouts.this.dispose();
					}
					else
					{
						
					}
				}
			}
		});
		btnGiris.setBounds(162, 193, 91, 23);
		getContentPane().add(btnGiris);
		
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
