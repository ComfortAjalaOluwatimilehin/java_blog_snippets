package com.tutorialspoint.eclipselink.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  @Table(name="menus")
public class Menu {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="name", nullable=false, length=50)
	private String dish_name;
	
	@Column(name="price", nullable=false, precision=3)
	private float dish_price = (float) 0.0;
	
	@Column(name="sold", nullable=false)
	private int number_sold = 0;
	
	
	
	public int getId() {
		return this.id;
	}
	public void setId(int newid) {
		this.id = newid;
	}
	public String getName() {
		return this.dish_name;
	}
	public void setName(String name) {
		this.dish_name = name;
	}
	public float getDishPrice() {
		return this.dish_price;
	}
	public void setDishPrice(float dishPrice) {
		this.dish_price = dishPrice;
	}
	public int getNumberSold() {
		return this.number_sold;
	}
	public void setNumberSold(int sold) {
		this.number_sold = sold;
	}
	public String printRow() {
		return "| "  + this.id+ " | " + this.dish_name + " | " + this.dish_price + " | " + this.number_sold;
	}
}
