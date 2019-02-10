package murat.swings.sample.main.frame.sample;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;

public class SampleFrame extends JFrame {
	JProgressBar prbarOrnek=null;
	JButton btn = null;
	boolean durum=true;
	Timer time=null;
	private JTextField textProgress;
	private JTextField textColor;
	private JTextField txtKullaniciAdi;
	private JTextField txtSifre;
	JRadioButton rdbtnErkek;
	JRadioButton rdbtnKadin;
	File fl;
	BufferedReader rd;
	public SampleFrame() {
		initialize();
	}

	private void initialize()
	{
		setTitle("Deneme");
		getContentPane().setLayout(null);
		setBounds(150,250,484,545);
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
		textProgress.setBounds(25, 84, 118, 36);
		getContentPane().add(textProgress);
		textProgress.setColumns(10);

		JButton btnColorChooser = new JButton("Renk Secimi");
		btnColorChooser.setBounds(316, 128, 144, 36);
		btnColorChooser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Color renk = JColorChooser.showDialog(SampleFrame.this, "Renk Secim Ekrani", Color.BLACK);
				if(renk!=null)
				{
					//textColor.setBackground(renk);	
					getContentPane().setBackground(renk);
				}
				else
				{
					JOptionPane.showConfirmDialog(SampleFrame.this, "Renk secimi yapilmadi...!");
				}
			}
		});
		getContentPane().add(btnColorChooser);

		textColor = new JTextField();
		textColor.setBounds(25, 128, 118, 36);
		getContentPane().add(textColor);
		textColor.setColumns(10);

		JButton btnDosyaSec = new JButton("Dosya Sec");
		btnDosyaSec.setBounds(316, 175, 144, 36);
		btnDosyaSec.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				//fc.setCurrentDirectory(dir); /*dosya secim ekraninda hangi dizin default acilsin*/
				fc.addChoosableFileFilter(new FileNameExtensionFilter("Text Dosyasi", "txt"));
				int secim = fc.showDialog(SampleFrame.this, "Tamam");
				if(secim==JFileChooser.APPROVE_OPTION)
				{
					JOptionPane.showMessageDialog(SampleFrame.this, "Dosya secildi : "+fc.getSelectedFile().getName());
				}
				else if(secim==JFileChooser.CANCEL_OPTION)
				{
					JOptionPane.showMessageDialog(SampleFrame.this, "Dosya secilmedi");					
				}
			}
		});

		getContentPane().add(btnDosyaSec);

		JTextArea txtOkunan = new JTextArea();
		txtOkunan.setBounds(25, 175, 159, 95);
		getContentPane().add(txtOkunan);

		JButton btnDosyaSec2 = new JButton("Dosya Sec2");
		btnDosyaSec2.setBounds(316, 222, 144, 36);
		btnDosyaSec2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				File fl = new File("D:\\muratgrkn");
				fc.setCurrentDirectory(fl); /*dosya secim ekraninda hangi dizin default acilsin*/
				fc.addChoosableFileFilter(new FileNameExtensionFilter("exe Dosyasi", "exe"));
				fc.addChoosableFileFilter(new FileNameExtensionFilter("PDF Dosyasi", "pdf"));
				int secim = fc.showDialog(SampleFrame.this, "Dosya Sec");
				if(secim==JFileChooser.APPROVE_OPTION)
				{
					File secilen = fc.getSelectedFile();
					if(secilen!=null)
					{
						JOptionPane.showMessageDialog(SampleFrame.this, "Dosya secildi : "+secilen.getName());
						try {
							BufferedReader rd = new BufferedReader(new FileReader(secilen));
							String s=null;
							while((s = rd.readLine()) != null)
							{
								String[] s1 = s.split("=");
								txtOkunan.append(s1[1]+"\n");
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				else if(secim==JFileChooser.CANCEL_OPTION)
				{
					JOptionPane.showMessageDialog(SampleFrame.this, "Dosya secilmedi");					
				}
			}
		});

		getContentPane().add(btnDosyaSec2);

		txtKullaniciAdi = new JTextField();
		txtKullaniciAdi.setBounds(130, 281, 86, 20);
		getContentPane().add(txtKullaniciAdi);
		txtKullaniciAdi.setColumns(10);

		txtSifre = new JTextField();
		txtSifre.setBounds(130, 312, 86, 20);
		getContentPane().add(txtSifre);
		txtSifre.setColumns(10);

		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblKullancAd.setBounds(25, 284, 75, 14);
		getContentPane().add(lblKullancAd);

		JLabel lblifre = new JLabel("\u015Eifre");
		lblifre.setBounds(25, 315, 46, 14);
		getContentPane().add(lblifre);

		fl = new File("D:\\\\muratgrkn\\KullaniciBilgileri.txt");
		String[] s2 = new String[2];
		int count=0;
		try {
			rd = new BufferedReader(new FileReader(fl));
			String s=null;
			try {
				while((s = rd.readLine()) != null)
				{
					String[] s1 = s.split("=");
					s2[count] = s1[1];
					count++;
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		JButton btnGiris = new JButton("Giris");
		btnGiris.setBounds(260, 296, 91, 23);
		btnGiris.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(s2[0].equals(txtKullaniciAdi.getText())&&(s2[1].equals(txtSifre.getText())))
				{
					JOptionPane.showMessageDialog(SampleFrame.this, "Giris Basarili");							
				}
				else
				{
					JOptionPane.showMessageDialog(SampleFrame.this, "Kullanici Adi veya Sifre Hatali...!");	
				}
			}
		});
		getContentPane().add(btnGiris);

		Personel p1 = new Personel(1, "Murat", "EE Muh");
		Personel p2 = new Personel(2, "Emel", "Ogretmen");
		Personel p3 = new Personel(3, "Evren", "Bil Muh");
		Personel[] liste = {p1,p2,p3};

		String[] veri = {"Bil Muh","EE Muh","Ogretmen","Doktor","Polis"};
		/*1. yontem*/
		//JComboBox cmbUnvan = new JComboBox(liste);/*veri de girdi olarak verilebilir.*/
		/*2. yontem : model ile yapma*/
		JComboBox cmbUnvan = new JComboBox();
		DefaultComboBoxModel model = new DefaultComboBoxModel(liste);/*combobox'a listenin toString metodundaki degerini yaziyor. Personel class icerisinde toString'i override ettik.*/
		cmbUnvan.setModel(model);
		cmbUnvan.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int id = ((Personel)cmbUnvan.getSelectedItem()).getId(); /*personelin getter fonksiyonu cagrilir.*/
				textColor.setText(""+id);
			}
		});
		cmbUnvan.setBounds(59, 359, 125, 22);
		getContentPane().add(cmbUnvan);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(251, 361, 118, 20);
		getContentPane().add(spinner);

		javax.swing.event.ChangeListener listener = new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if(rdbtnErkek!=null &&rdbtnKadin!=null)
				{
					if(rdbtnErkek.isSelected())
						rdbtnKadin.setSelected(false);
					if(rdbtnKadin.isSelected())
						rdbtnErkek.setSelected(false);
				}
			}
		};



		rdbtnErkek = new JRadioButton("Erkek");
		rdbtnErkek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnErkek!=null)
				{
					if(rdbtnErkek.isSelected())
						rdbtnKadin.setSelected(false);
					else
						rdbtnKadin.setSelected(true);	
				}
			}
		});
		/*rdbtnErkek.addChangeListener(listener);*/
		rdbtnErkek.setBounds(25, 416, 109, 23);
		getContentPane().add(rdbtnErkek);

		rdbtnKadin = new JRadioButton("Kadin");
		rdbtnKadin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnKadin!=null)
				{
					if(rdbtnKadin.isSelected())
						rdbtnErkek.setSelected(false);
					else
						rdbtnKadin.setSelected(true);					
				}
			}
		});
		/*rdbtnKadin.addChangeListener(listener);*/
		rdbtnKadin.setBounds(131, 416, 109, 23);
		getContentPane().add(rdbtnKadin);

	}
}
