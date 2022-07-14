package com.entity;

public class Team {
	
	private int teamid;
	private String name;
	private String city;
	private String state;

	public Team() {	}

	public Team(int teamid, String name, String city, String state) {
		
		this.teamid = teamid;
		this.name = name;
		this.city = city;
		this.state = state;
	}

	public int getTeamid() {
		return teamid;
	}

	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String toString() {
		return "Team [teamid=" + teamid + ", name=" + name + ", city=" + city + ", state=" + state + "]";
	}
		
	

}
