package com.revature.models;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class Nutrition {
	@JsonProperty("carbohydrates")
	private double carb;
	@JsonProperty("protein")
	private double prot;
	@JsonProperty("fat")
	private double phat;
	@JsonProperty("calories")
	private int calo;
	@JsonProperty("sugar")
	private double suga;

	public Nutrition() {
		super();
	}

	public double getCarb() {
		return carb;
	}

	public void setCarb(double carb) {
		this.carb = carb;
	}

	public double getProt() {
		return prot;
	}

	public void setProt(double prot) {
		this.prot = prot;
	}

	public double getPhat() {
		return phat;
	}

	public void setPhat(double phat) {
		this.phat = phat;
	}

	public int getCalo() {
		return calo;
	}

	public void setCalo(int calo) {
		this.calo = calo;
	}

	public double getSuga() {
		return suga;
	}

	public void setSuga(double suga) {
		this.suga = suga;
	}

	@Override
	public String toString() {
		return "Nutrition [carb=" + carb + ", prot=" + prot + ", phat=" + phat + ", calo=" + calo + ", suga=" + suga
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + calo;
		long temp;
		temp = Double.doubleToLongBits(carb);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(phat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(prot);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(suga);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Nutrition other = (Nutrition) obj;
		if (calo != other.calo)
			return false;
		if (Double.doubleToLongBits(carb) != Double.doubleToLongBits(other.carb))
			return false;
		if (Double.doubleToLongBits(phat) != Double.doubleToLongBits(other.phat))
			return false;
		if (Double.doubleToLongBits(prot) != Double.doubleToLongBits(other.prot))
			return false;
		if (Double.doubleToLongBits(suga) != Double.doubleToLongBits(other.suga))
			return false;
		return true;
	}

}