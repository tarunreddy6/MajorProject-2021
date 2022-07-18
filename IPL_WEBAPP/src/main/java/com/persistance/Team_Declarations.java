package com.persistance;

import java.sql.SQLException;
import java.util.List;

import com.entity.Team;

public interface Team_Declarations {
	
	public List<Team> getAllTeams() throws ClassNotFoundException, SQLException;
	public int insertTeam(Team team) throws ClassNotFoundException, SQLException;
	public int deleteTeamById(int teamid) throws SQLException, ClassNotFoundException;
	public Team getTeamById(int teamid) throws SQLException, ClassNotFoundException;
	public int updateTeam(Team team) throws SQLException, ClassNotFoundException;

}
