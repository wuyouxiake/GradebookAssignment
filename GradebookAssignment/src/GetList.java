import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import postTools.DBUtil;
import model.Gradebook;



import java.util.List;

/**
 * Servlet implementation class GetList
 */
@WebServlet("/GetList")
public class GetList extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fullList;

	public void init() throws ServletException {
		// Do required initialization
		fullList = "";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select g from Gradebook g";
			TypedQuery<Gradebook> q = em.createQuery(qString, Gradebook.class);
			List<Gradebook> gradeList;
			gradeList = q.getResultList();
			
			for (int i = 0; i < gradeList.size(); i++) {
				fullList += ("<tr><td>" + gradeList.get(i).getAssignment()
						+ "</td><td>" + gradeList.get(i).getGrade() + "</td></tr>");
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		// Set response content type
		response.setContentType("text/html");

		// Actual logic goes here.
		// PrintWriter out = response.getWriter();
		// message = "Hello";
		// out.println("&lt;h1&gt;" + message + "&lt;/h1&gt;");
		request.setAttribute("fullList", fullList);

		getServletContext().getRequestDispatcher("/list.jsp").forward(request,
				response);
		fullList = "";
	}

	public void destroy() {
		// do nothing.
	}

}
