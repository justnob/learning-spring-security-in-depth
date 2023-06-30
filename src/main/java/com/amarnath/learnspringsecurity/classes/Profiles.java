package com.amarnath.learnspringsecurity.classes;

public class Profiles {
	
	private Long id;
	private String name;
	private String address;
	private String occupation;
	
	public Profiles() {
		
	}
	
	public Profiles(Long id, String name, String address, String occupation) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.occupation = occupation;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Override
	public String toString() {
		return "Profiles [id=" + id + ", name=" + name + ", address=" + address + ", occupation=" + occupation + "]";
	}
	
	

}
