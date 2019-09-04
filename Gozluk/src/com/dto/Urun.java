package com.dto;

public class Urun {

    protected int urunId;
    protected String urunAdi;
    protected String urunKat;
	protected String urunModel;
    protected int urunMarkaId;
    protected int urunStok;   
    protected int urunFiyat;
    protected String urunCins;
    protected String urunResim;
    public Urun() {
        super();
        
    }
    public Urun(int urunId, String urunAdi, String urunKat, String urunModel, int urunMarkaId, int urunStok, int urunFiyat,  String urunCins, String urunResim) {
        super();
        this.urunId = urunId;
        this.urunAdi = urunAdi;
        this.urunKat = urunKat;
        this.urunModel = urunModel;
        this.urunMarkaId = urunMarkaId;
        this.urunStok = urunStok;
        this.urunFiyat = urunFiyat; 
        this.urunCins = urunCins;     
        this.urunResim = urunResim;  
    }
    public Urun( String urunAdi, String urunKat, String urunModel, int urunMarkaId, int urunStok, int urunFiyat,  String urunCins, String urunResim) {
        super();
        
        this.urunAdi = urunAdi;
        this.urunKat = urunKat;
        this.urunModel = urunModel;
        this.urunMarkaId = urunMarkaId;
        this.urunStok = urunStok;
        this.urunFiyat = urunFiyat; 
        this.urunCins = urunCins;     
        this.urunResim = urunResim;  
    }
    
    public int getUrunId() {
        return urunId;
    }
    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }
    public String getUrunAdi() {
        return urunAdi;
    }
    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }
    public String getUrunTuru() {
        return urunKat;
    }
    public void setUrunTuru(String urunKat) {
        this.urunKat = urunKat;
    }
    public String getUrunModel() {
        return urunModel;
    }
    public void setUrunModel(String urunModel) {
        this.urunModel = urunModel;
    }
    public int getUrunMarkaId() {
        return urunMarkaId;
    }
    public void setUrunMarkaId(int urunMarkaId) {
        this.urunMarkaId = urunMarkaId;
    }
    public int getUrunStok() {
        return urunStok;
    }
    public void setUrunStok(int urunStok) {
        this.urunStok = urunStok;
    }
    public String getUrunCins() {
        return urunCins;
    }
    public void setUrunCins(String urunCins) {
        this.urunCins = urunCins;
    }
    public int getUrunFiyat() {
        return urunFiyat;
    }
    public void setUrunFiyat(int urunFiyat) {
        this.urunFiyat = urunFiyat;
    }
    public String getUrunResim() {
        return urunResim;
    }
    public void setUrunResim(String urunResim) {
        this.urunResim = urunResim;
    }
    public String getUrunKat() {
		return urunKat;
	}
	public void setUrunKat(String urunKat) {
		this.urunKat = urunKat;
	}
}