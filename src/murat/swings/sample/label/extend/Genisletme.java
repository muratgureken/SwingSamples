package murat.swings.sample.label.extend;

import javax.swing.JLabel;

public class Genisletme extends JLabel{
	private String adi;
	private String soyadi;
	private String tckNo;
	private Roller rol;
	
	public Genisletme() {
		super("Yeni Label");
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getSoyadi() {
		return soyadi;
	}

	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}

	public String getTckNo() {
		return tckNo;
	}

	public void setTckNo(String tckNo) {
		this.tckNo = tckNo;
	}

	public Roller getRol() {
		return rol;
	}

	public void setRol(Roller rol) {
		this.rol = rol;
	}
	
	
}
