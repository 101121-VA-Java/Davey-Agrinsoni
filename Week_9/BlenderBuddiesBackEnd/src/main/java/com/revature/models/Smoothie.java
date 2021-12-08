package com.revature.models;

import org.springframework.stereotype.Component;

@Component
public class Smoothie {
	private int smoothId;
	private String decrip;
	private String name;
	
	public Smoothie() {
		super();
		
	}

	public Smoothie(int smoothId, String decrip, String name) {
		super();
		this.smoothId = smoothId;
		this.decrip = decrip;
		this.name = name;
	}

	public int getSmoothId() {
		return smoothId;
	}

	public void setSmoothId(int smoothId) {
		this.smoothId = smoothId;
	}

	public String getDecrip() {
		return decrip;
	}

	public void setDecrip(String decrip) {
		this.decrip = decrip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Smoothie [smoothId=" + smoothId + ", decrip=" + decrip + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((decrip == null) ? 0 : decrip.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Smoothie other = (Smoothie) obj;
		if (decrip == null) {
			if (other.decrip != null)
				return false;
		} else if (!decrip.equals(other.decrip))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (smoothId != other.smoothId)
			return false;
		return true;
	}

}