package com.revature.models;

import org.springframework.stereotype.Component;

@Component
public class Recipe {

	private int nGredId;
	private int fruitId;
	private int smoothId;

	public Recipe() {
		super();
	}

	public Recipe(int nGredId, int fruitId, int smoothId) {
		super();
		this.nGredId = nGredId;
		this.fruitId = fruitId;
		this.smoothId = smoothId;
	}

	public int getnGredId() {
		return nGredId;
	}

	public void setnGredId(int nGredId) {
		this.nGredId = nGredId;
	}

	public int getFruitId() {
		return fruitId;
	}

	public void setFruitId(int fruitId) {
		this.fruitId = fruitId;
	}

	public int getSmoothId() {
		return smoothId;
	}

	public void setSmoothId(int smoothId) {
		this.smoothId = smoothId;
	}

	@Override
	public String toString() {
		return "Recipe [nGredId=" + nGredId + ", fruitId=" + fruitId + ", smoothId=" + smoothId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fruitId;
		result = prime * result + nGredId;
		result = prime * result + smoothId;
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
		Recipe other = (Recipe) obj;
		if (fruitId != other.fruitId)
			return false;
		if (nGredId != other.nGredId)
			return false;
		if (smoothId != other.smoothId)
			return false;
		return true;
	}

}