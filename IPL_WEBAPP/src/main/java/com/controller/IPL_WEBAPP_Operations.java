package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.naming.ldap.Rdn;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Team;
import com.service.Service_Implementations;

/**
 * Servlet implementation class IPL_WEBAPP_Operations
 */
@WebServlet("/IPL_WEBAPP_Operations")
public class IPL_WEBAPP_Operations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IPL_WEBAPP_Operations() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	try {
			List <Team> teamList = new Service_Implementations().fetchAllTeams();
			request.setAttribute("allTeams", teamList);
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String RequestType = request.getParameter("request_type");
		PrintWriter out = response.getWriter();
		
		if(RequestType.equalsIgnoreCase("addteam")) { 	
			try {										// adding the row to the data_base
				Team team = new Team();
				team.setName(request.getParameter("teamName"));
				team.setCity(request.getParameter("city"));
				team.setState(request.getParameter("state"));
				int r = new Service_Implementations().addTeam(team);
				RequestDispatcher rd = null;
				if(r==0) {
					out.write("<h1>Not Inserted</h1>");
					rd = request.getRequestDispatcher("Home.jsp");
					rd.forward(request, response);
				}
				else
					doGet(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		}
		else if(RequestType.equalsIgnoreCase("ModifyTeam")) {   // changing the data 
			
			try {
				int teamid = Integer.parseInt(request.getParameter("team_id"));
				Team team = new Service_Implementations().getTeam(teamid);
				request.setAttribute("team", team);
				RequestDispatcher rd = request.getRequestDispatcher("EditTeam.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else if(RequestType.equalsIgnoreCase("Delete")) {
											// deleting the record from db by selecting id
			try{
				int teamid= Integer.parseInt(request.getParameter("team_id"));
				int i = new Service_Implementations().deleteTeam(teamid);
				if(i!=0)
					doGet(request, response);
				else
					out.write("<h1>Not deleted</h1>");
				} catch (ClassNotFoundException | SQLException e){
					e.printStackTrace();
				}
		}		
   }
}
