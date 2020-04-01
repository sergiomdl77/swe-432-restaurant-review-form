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
       
	// Location of servlet.
	static String Domain  = "swe432-assignment6.herokuapp.com";
	static String Path    = "/";
	static String Servlet = "restaurantForm2";
	
	static String indexPage = "/resources/restaurantForm/index.html";
	
	static String formStyles = "/resources/css/form.css";
	static String bootstrapStyles = "/resources/css/bootstrap.min.css";
	static String bootstrapGridStyles = "/resources/css/bootstrap-grid.min.css.css";
    
	static String formJs = "/resources/js/form.js";
	
	/** *****************************************************
	 *  Overrides HttpServlet's doGet().
	 *  Prints an HTML page with a blank form.
	********************************************************* */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");
	    //PrintWriter out = response.getWriter();
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
		
		// get the response printer ready
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	}
}
