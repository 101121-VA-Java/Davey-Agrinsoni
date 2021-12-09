package com.revature.models;

import org.springframework.stereotype.Component;
@Component
public class Spoonacular {
	
	private int id;
	private String name;
	private SpoonNutrition nutrition;
	
	public Spoonacular() {
		super();
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

	public SpoonNutrition getNutrition() {
		return nutrition;
	}

	public void setNutrition(SpoonNutrition nutrition) {
		this.nutrition = nutrition;
	}

	@Override
	public String toString() {
		return "Spoonacular [id=" + id + ", name=" + name + ", nutrition=" + nutrition + "]";
	}


}
