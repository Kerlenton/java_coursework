package com.cs322.ors.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "KeyWords")
public class DishKeyWord {
	
	@Id
	@GeneratedValue  //auto by default
	private long Id;
	
	@Column(name = "Word")
	private String keyWord;
	
	@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class)
	@JsonIdentityReference(alwaysAsId = true)
	@ManyToOne   //multiple dishes can be marked by same keyword
	private Dish dish;
	
	@ManyToOne (optional = false)	// one chef can use many keywords
	private User chef;

	
	//empty constructor
	public DishKeyWord() {

	}
	
	// main constructor
	public DishKeyWord(String keyWord, Dish dish, User chef) {
		super();
		this.keyWord = keyWord;
		this.dish = dish;
		this.chef = chef;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public User getChef() {
		return chef;
	}

	public void setChef(User chef) {
		this.chef = chef;
	}
	
	
	
}
