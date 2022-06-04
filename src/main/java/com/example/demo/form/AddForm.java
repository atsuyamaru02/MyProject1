package com.example.demo.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AddForm {
	@NotNull(message="1～4の数字を選択してください")
	@Min(1)
	@Max(4)
	private int id;
	
	
	private String name;
	
	
	@NotNull(message="品数を入力してください")
	@Positive(message="1より大きい数字を入力してください")
	@Max(50)
	private int stock;
	
	public AddForm() {}

	public AddForm(@NotNull(message = "1～4の数字を選択してください") @Min(1) @Max(4) int id,
			String name,
			@NotNull(message = "品数を入力してください") @Positive(message = "1より大きい数字を入力してください") @Max(50) int stock) {
		this.id = id;
		this.name = name;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
}
