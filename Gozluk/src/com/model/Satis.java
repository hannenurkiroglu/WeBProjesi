package com.model;

public class Satis {

	int kullanicid;
	Long urunid;
	int tutar;
	
	  public void setTutar(int tutar) {
		this.tutar = tutar;
	}
	public Satis() {
	        super();
	        
	    }
	    public Satis(int kullanicid, int urunid,  int tutar) {
	        super();
	        this.kullanicid = kullanicid;
	        this. urunid = (long) urunid;
	        this.tutar = tutar;

	    }
	
	
	public int getKullanicid() {
		return kullanicid;
	}
	public void setKullanicid(int kullanicid) {
		this.kullanicid = kullanicid;
	}
	public Long getUrunid() {
		return urunid;
	}
	public void setUrunid(Long long1) {
		this.urunid = long1;
	}
	
	public int getTutar() {
		return tutar;
	}

}
