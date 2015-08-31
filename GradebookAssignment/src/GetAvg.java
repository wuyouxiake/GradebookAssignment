import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Gradebook;
import postTools.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * Servlet implementation class GetList
 */
@WebServlet("/GetAvg")
public class GetAvg extends HttpServlet {
	private float avg;
	public void init() throws ServletException {
		// Do required initialization
	}
	
	@SuppressWarnings("null")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
			try {
				EntityManager em = DBUtil.getEmFactory().createEntityManager();
				String qString = "select AVG(g.grade) from Gradebook g";
				TypedQuery<Gradebook> q = em.createQuery(qString, Gradebook.class);
				//System.out.println(q.getSingleResult());
				response.setContentType("text/html");
				request.setAttribute("avgGrade",q.getSingleResult());
				getServletContext().getRequestDispatcher("/avg.jsp").forward(request, response);
				avg=0;	
				
					
				
			} catch (Exception e) {
				System.out.println(e);
			}
		// Set response content type
		
	}


	public void destroy() {
		// do nothing.
	}

	
	
}
