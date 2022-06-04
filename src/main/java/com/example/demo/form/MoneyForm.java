package com.example.demo.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class MoneyForm {
	
	@Min(0)
	@Max(1)
	private int thousand;
	
	@Min(0)
	@Max(1)
	private int fiveHundred;
	
	@Min(0)
	@Max(2)
	private int oneHundred;
	
	@Min(0)
	@Max(4)
	private int fifty;
	
	@Min(0)
	@Max(30)
	private int ten;
	
	
	public MoneyForm() {}

	public MoneyForm(@Min(0) @Max(1) int thousand, @Min(0) @Max(1) int fiveHundred, @Min(0) @Max(9) int oneHundred,
			@Min(0) @Max(19) int fifty, @Min(0) @Max(99) int ten) {
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
