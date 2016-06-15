package com.sa42.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.ws.rs.core.MediaType;

@WebServlet("/film-query")
public class FilmServlet extends HttpServlet {
    
    @Resource(lookup = "jdbc/sakila")
    private DataSource sakilaDB;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer fid = Integer.parseInt(req.getParameter("fid"));        
		System.out.println(">>> fid = " + fid);

        try (Connection conn = sakilaDB.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("select * from film where film_id = ?");
            ps.setInt(1, fid);
            ResultSet rs = ps.executeQuery();
             if (rs.next()) {
                Film f = Film.create(rs);

				resp.setStatus(200);
				resp.setContentType(MediaType.APPLICATION_JSON);
				try (PrintWriter pw = resp.getWriter()) {
					pw.println(f.asJson().toString());
					pw.flush();
				} 
				
/*
                req.setAttribute("film", f);
                req.getRequestDispatcher("film_search.jsp")
                        .forward(req, resp);
*/
                return;
             } 
             
             resp.setStatus(404);
			 resp.setContentType("text/html");
             try (PrintWriter pw = resp.getWriter()) {
                 pw.println("<h1>Not found</h1>");
                 pw.flush();    
             }
            
        } catch (SQLException ex) {
            throw new IOException(ex);
        }
         
    }
    
    
    
}
