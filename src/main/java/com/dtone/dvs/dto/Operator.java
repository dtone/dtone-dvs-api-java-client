package com.dtone.dvs.dto;

import java.util.List;

public class Operator {
	private Long id;

	private String name;

	private List<Region> regions;

	private Country country;

	private Boolean identified;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Boolean getIdentified() {
		return identified;
	}

	public void setIdentified(Boolean identified) {
		this.identified = identified;
	}

	@Override
	public String toString() {
		return "Operator [id=" + id + ", name=" + name + ", regions=" + regions + ", country=" + country
				+ ", identified=" + identified + "]";
	}

}
