package murat.swings.samples.main.btn;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BtnOrnek extends JFrame{
	public BtnOrnek() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				JOptionPane.showMessageDialog(BtnOrnek.this, "Uyarý");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		getContentPane().setLayout(null);
		
		JButton btnGiris = new JButton("Giri\u015F");
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGiris.setText("Giris yapildi.");
			}
		});
		btnGiris.setBounds(93, 60, 158, 23);
		getContentPane().add(btnGiris);
		initialize();
	}
	
	private void initialize()
	{
		setTitle("Giri\u015F Paneli");
		setBounds(150, 150, 361, 335);//ekranda cikacagi yer ve boyutu
	}
}
