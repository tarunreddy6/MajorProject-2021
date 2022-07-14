package com.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.Team;

public class Team_Implementations implements Team_Declarations{

	@Override
	public List<Team> getAllTeams() throws ClassNotFoundException, SQLException {
		
		List<Team> teamList=new ArrayList<Team>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ipl","root","password");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from team");
		
		while(rs.next()) {
			Team team = new Team();
			team.setTeamid(rs.getInt(1));
			team.setName(rs.getString(2));
			team.setCity(rs.getString(3));
			team.setState(rs.getString(4));
			teamList.add(team);
		}
		return teamList;
	}

	@Override
	public int insertTeam(Team team) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ipl","root","password");
		PreparedStatement ps = con.prepareStatement("insert into team(name,city,state)values(?,?,?)");
		ps.setString(1, team.getName());
		ps.setString(2,team.getCity());
		ps.setString(3, team.getState());
		int r = ps.executeUpdate();
		System.out.println("Inserted "+r+" row");
		con.close();
		return r;
	}

	@Override
	public int deleteTeamById(int teamid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Team getTeamById(int teamid) {
		// TODO Auto-generated method stub
		return null;
	}

}
