//商品変更フォーム
package com.example.demo.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ChangeForm {
	
	@NotNull(message="1～4の数字を選択してください")
	@Min(1)
	@Max(4)
	private int id;
	
	@NotEmpty(message="商品名を入力してください")
	@Size(min = 1, max = 30, message="1文字以上30文字以下で入力してください")
	private String name;
	
	@NotEmpty(message="商品画像を入力してください")
	@Size(max=255)
	private String image;
	
	@NotNull(message="価格を入力してください")
	@Positive(message="1より大きい数字を入力してください")
	private int price;
	
	@NotEmpty(message="Hot or Coldを入力してください")
	@Size(min = 3, max = 4)
	private String hotcold;
	
	@NotNull(message="品数を入力してください")
	@Positive(message="1より大きい数字を入力してください")
	@Max(50)
	private int stock;
	
	@NotNull(message="内容量を入力してください")
	@Positive(message="1より大きい数字を入力してください")
	@Max(700)
	private int quantity;
	
	public ChangeForm() {}

	public ChangeForm(int id,
			String name,
			String image,
			int price,
			String hotcold,
			int stock,
			int quantity) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.hotcold = hotcold;
		this.stock = stock;
		this.quantity = quantity;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getHotcold() {
		return hotcold;
	}

	public void setHotcold(String hotcold) {
		this.hotcold = hotcold;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	



	

	
	
}
