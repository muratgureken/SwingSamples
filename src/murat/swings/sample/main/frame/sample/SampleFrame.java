package murat.swings.sample.main.frame.sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class SampleFrame extends JFrame {
	JProgressBar prbarOrnek=null;
	JButton btn = null;
	boolean durum=true;
	Timer time=null;
	private JTextField textProgress;
	public SampleFrame() {
		initialize();
	}

	private void initialize()
	{
		setTitle("Deneme");
		getContentPane().setLayout(null);
		setBounds(150,250,484,400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		btn = new JButton("Tikla");
		btn.setVisible(true);
		btn.setBounds(316, 11, 150, 50);
		
		//TIMER VERSIYONU
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(null==time)
				{
					time = new Timer(50,new ActionListener() /*50MS'DE BÝR KENDÝNÝ CAGÝR*/{
						int deger=0;
						@Override
						public void actionPerformed(ActionEvent e) {
							deger++;
							if(deger>100)
							{
								time.stop();
								time = null;
							}
							prbarOrnek.setValue(deger);
						}
					});
					
					time.start();
				}
			}
		});
		/*THREAD versiyonu*/
		/*btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Thread t1 = new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						btn.setEnabled(false);
						//veya asagidaki IF kontrolu
						if(durum)
						{
							durum=false;
							for(int i=0;i<=100;i++)
							{
								prbarOrnek.setValue(i);
								textProgress.setText(Integer.toString(i));
								try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							durum = true;
						}
						btn.setEnabled(true);
					}
				});
				t1.start();
			}
		});*/
		getContentPane().add(btn);

		prbarOrnek = new JProgressBar();
		prbarOrnek.setStringPainted(true);//ekranda yuzde sayisal degerini goster
		prbarOrnek.setBounds(10, 11, 150, 50);
		getContentPane().add(prbarOrnek);

		textProgress = new JTextField();
		textProgress.setHorizontalAlignment(SwingConstants.CENTER);
		textProgress.setBounds(25, 101, 118, 36);
		getContentPane().add(textProgress);
		textProgress.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(322, 101, 144, 36);
		getContentPane().add(btnNewButton);
	}
}
