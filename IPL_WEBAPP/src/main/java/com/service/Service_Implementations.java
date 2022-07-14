package com.service;

import java.sql.SQLException;
import java.util.List;

import com.entity.Team;
import com.persistance.Team_Implementations;

public class Service_Implementations {
	
	public List<Team> fetchAllTeams() throws ClassNotFoundException, SQLException {
		
		return new Team_Implementations().getAllTeams();
	}

	public int addTeam(Team team) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return new Team_Implementations().insertTeam(team);
	}

	
	public int deleteTeam(int teamid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Team getTeam(int teamid) {
		// TODO Auto-generated method stub
		return null;
	}


}
