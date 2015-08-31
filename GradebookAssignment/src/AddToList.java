import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import postTools.DBUtil;
import model.Gradebook;

/**
 * Servlet implementation class AddComment
 */
@WebServlet("/AddToList")
public class AddToList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String assignment = request.getParameter("assignment");
				long grade = (long) Double.parseDouble(request.getParameter("grade"));
				Gradebook g = new Gradebook();
				
				g.setAssignment(assignment);
				g.setGrade(grade);
				
				GradeDB.insert(g);
				getServletContext().getRequestDispatcher("/GetList").forward(request, response);
		
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
