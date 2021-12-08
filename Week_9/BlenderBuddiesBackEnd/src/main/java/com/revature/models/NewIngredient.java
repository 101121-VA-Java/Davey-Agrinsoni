package com.revature.models;

import org.springframework.stereotype.Component;

@Component
public class NewIngredient {

	private int nGredId;
	private String name;
	private int nutrions;

	public NewIngredient() {
		super();
	}

	public NewIngredient(int nGredId, String name, int nutrions) {
		super();
		this.nGredId = nGredId;
		this.name = name;
		this.nutrions = nutrions;
	}

	public int getnGredId() {
		return nGredId;
	}

	public void setnGredId(int nGredId) {
		this.nGredId = nGredId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNutrions() {
		return nutrions;
	}

	public void setNutrions(int nutrions) {
		this.nutrions = nutrions;
	}

	@Override
	public String toString() {
		return "NewIngredient [nGredId=" + nGredId + ", name=" + name + ", nutrions=" + nutrions + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nGredId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + nutrions;
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
		NewIngredient other = (NewIngredient) obj;
		if (nGredId != other.nGredId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nutrions != other.nutrions)
			return false;
		return true;
	}

}