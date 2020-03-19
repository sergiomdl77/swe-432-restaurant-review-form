package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RestaurantFormServlet
 */
@WebServlet(
        name = "RestaurantFormServlet",
        urlPatterns = {"/restaurantForm"}
    )
public class RestaurantFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// Location of servlet.
	static String Domain  = "swe432-assignment6.herokuapp.com";
	static String Path    = "/";
	static String Servlet = "restaurantForm";
	
	static String formStyles = "http://mason.gmu.edu/~thoward9/Form_Assignment/SWE432-Form/form.css";
	static String bootstrapStyles = "http://mason.gmu.edu/~thoward9/Form_Assignment/SWE432-Form/bootstrap-css/bootstrap.min.css";
	static String bootstrapGridStyles = "http://mason.gmu.edu/~thoward9/Form_Assignment/SWE432-Form/bootstrap-css/bootstrap-grid.min.css.css";
    
	static String formJs = "http://mason.gmu.edu/~thoward9/Form_Assignment/SWE432-Form/form.js";
	
	/** *****************************************************
	 *  Overrides HttpServlet's doGet().
	 *  Prints an HTML page with a blank form.
	********************************************************* */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    PrintHead(out);
	    PrintBody(out);
	    PrintTail(out);
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
	    
	    // print the results page
	    PrintHead(out);
	    PrintBody(out, request, requestParameters);
	    PrintTail(out);
	}
	
	/** *****************************************************
	 *  Prints the <head> of the HTML page, no <body>.
	********************************************************* */
	private void PrintHead (PrintWriter out)
	{
	   out.println("<html>");
	   out.println("");

	   out.println("<head>");
	   out.println("<title>Rate Restaurants on Campus</title>");
	   out.println(" <link rel=\"stylesheet\" type=\"text/css\" href=\"" + formStyles + "\">");
	   out.println(" <link rel=\"stylesheet\" type=\"text/css\" href=\"" + bootstrapStyles + "\">");
	   out.println(" <link rel=\"stylesheet\" type=\"text/css\" href=\"" + bootstrapGridStyles + "\">");
	   out.println("</head>");
	   out.println("");
	} 

	/** *****************************************************
	 *  Prints the <BODY> of the HTML page. Blank form.
	********************************************************* */
	private void PrintBody (PrintWriter out)
	{
	   out.println("<body>");
	   out.print  ("<form method=\"post\"");
	   out.println(" action=\"https://" + Domain + Path + Servlet + "\">");
	   out.println("");
	   out.println(" <br>");
	   out.println("</form>");
	   out.println("<script type=\"text/javascript\" src=\"" + formJs + "\"></script>");
	   out.println("</body>");
	} 
	
	
	/** *****************************************************
	 *  Prints the results page, 
	 *  echoing the form data to the user.
	********************************************************* */
	private void PrintBody (PrintWriter out, HttpServletRequest request, Enumeration<String> parameters)
	{
	   out.println("<body>");
	   out.println("<h1>Form Results Page</h1>");
	   out.println("");
	   out.println("<table>");
	   
	   // print table header
	   out.println("<tr>");
	   out.println("<td>");
	   out.println("Parameter Name");
	   out.println("</td>");
	   out.println("");
	   out.println("<td>");
	   out.println("Value");
	   out.println("</td>");
	   out.println("</tr>");
	   out.println("");
	   
	   // iteratively print out rows for each parameter/value pair
	   while (parameters.hasMoreElements()) {
		   String parameterName = parameters.nextElement();
		   String parameterValue = request.getParameter(parameterName);
		   
		   out.println("<tr>");
		   out.println("<td>");
		   out.println(parameterName);
		   out.println("</td>");
		   out.println("");
		   out.println("<td>");
		   out.println(parameterValue);
		   out.println("</td>");
		   out.println("</tr>");
		   out.println("");
	   }
	   
	   out.println("</table>");
	   out.println("");
	   out.println("<script type=\"text/javascript\" src=\"" + formJs + "\"></script>");
	   out.println("</body>");
	} 


	/** *****************************************************
	 *  Prints the bottom of the HTML page.
	********************************************************* */
	private void PrintTail (PrintWriter out)
	{
	   out.println("");
	   out.println("</html>");
	} 

}
