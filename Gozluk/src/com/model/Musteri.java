package com.model;

public class Musteri {

	int id;
	String adi;
	String soyadi;
	String email;
	String parola;
	int yetki;
	
	
	  public Musteri() {
	        super();
	        
	    }
	    public Musteri(int id, String adi, String soyadi, String email, String parola, int yetki) {
	        super();
	        this.id = id;
	        this.adi = adi;
	        this.soyadi = soyadi;
	        this.email = email;
	        this.parola = parola;
	        this.yetki = yetki;
	      
	    }
	    public Musteri(String adi, String soyadi, String email, String parola, int yetki) {
	        super();
	    
	        this.adi = adi;
	        this.soyadi = soyadi;
	        this.email = email;
	        this.parola = parola;
	        this.yetki = yetki;
	      
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
	public String getSoyadi() {
		return soyadi;
	}
	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public int getYetki() {
		return yetki;
	}
	public void setYetki(int yetki) {
		this.yetki = yetki;
	}

}
