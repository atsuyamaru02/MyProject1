package com.example.demo.form;

public class MoneyForm2 {
	
	private int thousand;
	
	private int fiveHundred;
	
	private int oneHundred;
	
	private int fifty;
	
	private int ten;
	
	public MoneyForm2() {}
	

	
	public MoneyForm2(int thousand,
			int fiveHundred,
			int oneHundred,
			int fifty,
			int ten) {
		this.thousand = thousand;
		this.fiveHundred = fiveHundred;
		this.oneHundred = oneHundred;
		this.fifty = fifty;
		this.ten = ten;
	}



	public int getThousand() {
		return thousand;
	}
	public void setThousand(int thousand) {
		this.thousand = thousand;
	}
	public int getFiveHundred() {
		return fiveHundred;
	}
	public void setFiveHundred(int fiveHundred) {
		this.fiveHundred = fiveHundred;
	}
	public int getOneHundred() {
		return oneHundred;
	}
	public void setOneHundred(int oneHundred) {
		this.oneHundred = oneHundred;
	}
	public int getFifty() {
		return fifty;
	}
	public void setFifty(int fifty) {
		this.fifty = fifty;
	}
	public int getTen() {
		return ten;
	}
	public void setTen(int ten) {
		this.ten = ten;
	}
	
	
}
