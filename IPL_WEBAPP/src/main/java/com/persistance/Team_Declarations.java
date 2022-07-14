package com.persistance;

import java.sql.SQLException;
import java.util.List;

import com.entity.Team;

public interface Team_Declarations {
	
	public List<Team> getAllTeams() throws ClassNotFoundException, SQLException;
	public int insertTeam(Team team) throws ClassNotFoundException, SQLException;
	public int deleteTeamById(int teamid);
	public Team getTeamById(int teamid);

}
