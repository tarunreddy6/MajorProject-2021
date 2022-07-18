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
	
	public int deleteTeam(int teamid) throws ClassNotFoundException, SQLException {
		
		return new Team_Implementations().deleteTeamById(teamid);
	}

	public Team getTeam(int teamid) throws ClassNotFoundException, SQLException {
		
		return new Team_Implementations().getTeamById(teamid);
	}
	
	public int updateTeam(Team team) throws ClassNotFoundException, SQLException {
		return new Team_Implementations().updateTeam(team);
	}


}
