package com.revature.models;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SpoonNutrition {
	private List<Nutrient> nutrients;

	public SpoonNutrition() {
		super();
	}

	public List<Nutrient> getNutrients() {
		return nutrients;
	}

	public void setNutrients(List<Nutrient> nutrients) {
		this.nutrients = nutrients;
	}

	@Override
	public String toString() {
		return "SpoonNutrition [nutrients=" + nutrients + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nutrients == null) ? 0 : nutrients.hashCode());
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
		SpoonNutrition other = (SpoonNutrition) obj;
		if (nutrients == null) {
			if (other.nutrients != null)
				return false;
		} else if (!nutrients.equals(other.nutrients))
			return false;
		return true;
	}

}