package murat.swings.sample.label.extend;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Ekran extends JFrame{
	JRadioButton rdbtnMale , rdbtnFemale;
	public Ekran() {
		setTitle("Ornek");
		setBounds(150,250,484,400);
		getContentPane().setLayout(null);

		JLabel lbSwingLabel = new JLabel("Swing label");
		lbSwingLabel.setBounds(35, 26, 86, 33);
		getContentPane().add(lbSwingLabel);

		/*kendimiz class icerisinde yarattigimiz label*/
		Genisletme lblBenim = new Genisletme();
		lblBenim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(Ekran.this, lblBenim.getAdi()+" "+lblBenim.getSoyadi());
			}
		});
		lblBenim.setBounds(35, 75, 86, 33);
		lblBenim.setAdi("Murat");
		lblBenim.setSoyadi("Gureken");
		getContentPane().add(lblBenim);

		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				stateChangedEventForBtnMale(e);
			}
		});
		rdbtnMale.setBounds(45, 165, 109, 23);
		getContentPane().add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				stateChangedEventForBtnFemale(e);
			}
		});
		rdbtnFemale.setBounds(170, 165, 109, 23);
		getContentPane().add(rdbtnFemale);


		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	protected void stateChangedEventForBtnMale(ItemEvent e)
	{
		e.getClass();
		if(rdbtnFemale!=null && rdbtnMale!=null) 
		{
			if(rdbtnMale.isSelected())
			{
				rdbtnFemale.setSelected(false);
			}
		}

	}

	protected void stateChangedEventForBtnFemale(ItemEvent e)
	{
		if(rdbtnFemale!=null && rdbtnMale!=null) 
		{
			if(rdbtnFemale.isSelected())
			{
				rdbtnMale.setSelected(false);
			}
		}

	}
}
