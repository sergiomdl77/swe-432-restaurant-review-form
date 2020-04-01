package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RestaurantFormServlet2, integrated with react
 */
@WebServlet(
        name = "RestaurantFormServletV2",
        urlPatterns = {"/restaurantForm2"}
    )
public class RestaurantFormServletV2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static String indexPage = "/resources/restaurantForm/index.html";
	static String resultsPage = "/resources/restaurantForm/results.html";
	
	/** *****************************************************
	 *  Overrides HttpServlet's doGet().
	 *  Prints an HTML page with a blank form.
	********************************************************* */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher view = request.getRequestDispatcher(indexPage);
        view.forward(request, response); 
	}

	/** *****************************************************
	 *  Overrides HttpServlet's doPost().
	 *  Process the values in the form
	 *  and echoes the result to the user.
	********************************************************* */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get all of the parameters sent to the server
		Enumeration<String> requestParameters = request.getParameterNames();
		
		// todo: find a way to pass parameters to the results page?
		
		RequestDispatcher view = request.getRequestDispatcher(resultsPage);
        view.forward(request, response); 
	}
}
