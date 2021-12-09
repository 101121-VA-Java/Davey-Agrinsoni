package com.revature.models;

import org.springframework.stereotype.Component;
@Component
public class Fruityvice {
	
	private int id;
	private String name;
	private Nutrition nutritions;
//	private List<nutritions> nutritions;
////	private int nutrions1;
////	private Nutrition nutrions; 

	public Fruityvice() {
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

	public Nutrition getNutritions() {
		return nutritions;
	}

	public void setNutritions(Nutrition nutritions) {
		this.nutritions = nutritions;
	}

	@Override
	public String toString() {
		return "Fruityvice [id=" + id + ", name=" + name + ", nutritions=" + nutritions + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nutritions == null) ? 0 : nutritions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fruityvice other = (Fruityvice) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nutritions == null) {
			if (other.nutritions != null)
				return false;
		} else if (!nutritions.equals(other.nutritions))
			return false;
		return true;
	}

}