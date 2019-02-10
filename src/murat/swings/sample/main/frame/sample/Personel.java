package murat.swings.sample.main.frame.sample;

public class Personel {
	private int id;
	private String adi;
	private String unvan;

	public Personel(int id, String adi, String unvan) {
		this.id = id;
		this.adi = adi;
		this.unvan = unvan;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public String getUnvan() {
		return unvan;
	}
	public void setUnvan(String unvan) {
		this.unvan = unvan;
	}

	@Override
	public String toString() {
		return unvan+" "+adi;
	}

}
