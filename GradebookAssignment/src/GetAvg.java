import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:testuser/password@localhost";
				//properties for creating connection to Oracle database
		        Properties props = new Properties();
		        props.setProperty("user", "testdb");
		        props.setProperty("password", "password");
		        Connection conn=DriverManager.getConnection(url,props);
				
        String sql = "select avg(grade) as avgGrade from gradebook";
        PreparedStatement preStatement = conn.prepareStatement(sql);
		ResultSet result = preStatement.executeQuery();
			
				while(result.next()){
					avg=result.getFloat("avgGrade");
					
				}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		// Set response content type
		response.setContentType("text/html");

		// Actual logic goes here.
		//PrintWriter out = response.getWriter();
		//message = "Hello";
		//out.println("&lt;h1&gt;" + message + "&lt;/h1&gt;");
		request.setAttribute("avgGrade",avg);
		
		getServletContext().getRequestDispatcher("/avg.jsp").forward(request, response);
		avg=0;	
	}


	public void destroy() {
		// do nothing.
	}

	
	
}
