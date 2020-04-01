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
	
	static String formStyles = "/resources/css/form.css";
	static String bootstrapStyles = "/resources/css/bootstrap.min.css";
	static String bootstrapGridStyles = "/resources/css/bootstrap-grid.min.css.css";
    
	static String formJs = "/resources/js/form.js";
	
	/** *****************************************************
	 *  Overrides HttpServlet's doGet().
	 *  Prints an HTML page with a blank form.
	********************************************************* */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    PrintHead(out, request);
	    PrintBody(out, request);
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
	    PrintHead(out, request);
	    PrintBody(out, request, requestParameters);
	    PrintTail(out);
	}
	
	/** *****************************************************
	 *  Prints the <head> of the HTML page, no <body>.
	********************************************************* */
	private void PrintHead (PrintWriter out, HttpServletRequest request)
	{
	   String context = request.getContextPath();
		
	   out.println("<html>");
	   out.println("");
	   out.println("	<head>");
	   out.println("		<title>Rate Restaurants on Campus</title>");
	   out.println("		<link rel=\"stylesheet\" type=\"text/css\" href=\"" + context + formStyles + "\">");
	   out.println("		<link rel=\"stylesheet\" type=\"text/css\" href=\"" + context + bootstrapStyles + "\">");
	   out.println("		<link rel=\"stylesheet\" type=\"text/css\" href=\"" + context + bootstrapGridStyles + "\">");
	   out.println("	</head>");
	   out.println("");
	} 

	/** *****************************************************
	 *  Prints the <BODY> of the HTML page. Blank form.
	********************************************************* */
	private void PrintBody (PrintWriter out, HttpServletRequest request)
	{
	   String context = request.getContextPath();
	   
           	out.println("    <body class=\"container\">");
           	out.println("        <div class=\"text-center\">");
        	out.println("            <h1>Rate Restaurants on Campus</h1>");
        	out.println("            <p class=\"f-09\">Form by Tanya Howard and Sergio Delgado</p>");
        	out.println("            <form id=\"restaurantForm\" method=\"post\" action=\"" + Path + Servlet + "\">");
        	out.println("                <fieldset class=\"centerFieldset\">");
        	out.println("                    <legend>Personal Information</legend>");
        	out.println("                    <div>");
        	out.println("                        <p class=\"font-italic f-09\">Please provide some information about yourself.</p>");
        	out.println("                        <div>");
        	out.println("                            <label for=\"pName\">Name:</label>");
        	out.println("                            <input type=\"text\" id=\"pName\" name=\"pName\" maxlength=\"20\" class=\"input-box\" required />");
        	out.println("                            <label for=\"pAge\">Age:</label>");
        	out.println("                            <input type=\"number\" id=\"pAge\" name=\"pAge\" max=\"200\" maxlength=\"4\" class=\"input-box\" required />");
        	out.println("                            <div class=\"radio-button-div\"> ");
        	out.println("                                <label>Gender: </label>");
        	out.println("                                <input type=\"radio\" name=\"pGender\" id=\"genderMale\" value=\"male\" required /><label for = \"genderMale\">Male</label>");
        	out.println("                                <input type=\"radio\" name=\"pGender\" id=\"genderFemale\" value=\"female\" required /><label for = \"genderFemale\">Female</label>");
        	out.println("                                <input type=\"radio\" name=\"pGender\" id=\"genderOther\" value=\"other\" required /><label for = \"genderOther\">Other</label>");
        	out.println("                                <input type=\"text\"  id=\"pOtherGender\" name=\"pOtherGender\" placeholder=\"Other gender\" maxlength=\"15\" class=\"input-box\" />");
        	out.println("                            </div>");
        	out.println("                        </div>");
        	out.println("                    </div>");
        	out.println("                </fieldset>");
        	out.println("");
        	out.println("                <fieldset>");
        	out.println("                    <legend>Restaurant Information</legend>");
        	out.println("                    <div>");
        	out.println("                        <p class=\"font-italic f-09\">Please provide information about the restaurant you visited on campus.</p>");
        	out.println("                        <div>");
        	out.println("                            <label for=\"rName\">Name:</label>");
        	out.println("                            <input type=\"text\" id=\"rName\" name=\"rName\" maxlength=\"20\" class=\"input-box\" required />");
        	out.println("                            <label for=\"rVisit\">Date of Visit:</label>");
        	out.println("                            <input type=\"date\" id=\"rVisit\" name=\"rVisit\" class=\"input-box\" min=\"2000-01-01\" max=\"2020-12-31\" required />");
        	out.println("                            <div class=\"radio-button-div\"> ");
        	out.println("                                <label>Time of Visit: </label>");
        	out.println("                                <input type=\"radio\" name=\"vTime\" id=\"timeBreakfast\" value=\"Breakfast\" required /><label for=\"timeBreakfast\">Breakfast</label>");
        	out.println("                                <input type=\"radio\" name=\"vTime\" id=\"timeLunch\" value=\"Lunch\" required /><label for=\"timeLunch\">Lunch</label>");
        	out.println("                                <input type=\"radio\" name=\"vTime\" id=\"timeDinner\" value=\"Dinner\" required /><label for=\"timeDinner\">Dinner</label>");
        	out.println("                            </div>");
        	out.println("                        </div>");
        	out.println("                    </div>");
        	out.println("                </fieldset>");
        	out.println("                <fieldset>");
        	out.println("                    <legend>Review</legend>");
        	out.println("                    <div>");
        	out.println("                        <p class=\"font-italic f-09\">Please rate each category from 1 to 5 based on your experience (1 being the worst rating, 5 being the best rating).</p>");
        	out.println("                        <div>");
        	out.println("                            <input type=\"button\" id=\"greatButton\" value=\"Everything was great!\" />");
        	out.println("                            <p class=\"f-09\">Rate everything as a 5.</p>");
        	out.println("                        </div>");
        	out.println("                        <div class=\"d-flex\">");
        	out.println("                            <div class=\"col-3\"></div>");
        	out.println("                            <div class=\"col-3\">");
        	out.println("                                <p>Customer Service: </p>");
        	out.println("                            </div>");
        	out.println("                            <div class=\"col-3 text-nowrap\">");
        	out.println("                                <input type=\"radio\" name=\"customerService\" id=\"cust1\" value=\"1\" required /><label for=\"cust1\">1</label>");
        	out.println("                                <input type=\"radio\" name=\"customerService\" id=\"cust2\" value=\"2\" required /><label for=\"cust2\">2</label>");
        	out.println("                                <input type=\"radio\" name=\"customerService\" id=\"cust3\" value=\"3\" required /><label for=\"cust3\">3</label>");
        	out.println("                                <input type=\"radio\" name=\"customerService\" id=\"cust4\" value=\"4\" required /><label for=\"cust4\">4</label>");
        	out.println("                                <input type=\"radio\" name=\"customerService\" id=\"cust5\" value=\"5\" required /><label for=\"cust5\">5</label>");
        	out.println("                            </div>");
        	out.println("                            <div class=\"3\"></div>");
        	out.println("                        </div>");
        	out.println("                        <div class=\"d-flex\">");
        	out.println("                            <div class=\"col-3\"></div>");
        	out.println("                            <div class=\"col-3\">");
        	out.println("                                <p>Speed of Service: </p>");
        	out.println("                            </div>");
        	out.println("                            <div class=\"col-3 text-nowrap\">");
        	out.println("                                <input type=\"radio\" name=\"speed\" id=\"speed1\" value=\"1\" required /><label for=\"speed1\">1</label>");
        	out.println("                                <input type=\"radio\" name=\"speed\" id=\"speed2\" value=\"2\" required /><label for=\"speed2\">2</label>");
        	out.println("                                <input type=\"radio\" name=\"speed\" id=\"speed3\" value=\"3\" required /><label for=\"speed3\">3</label>");
        	out.println("                                <input type=\"radio\" name=\"speed\" id=\"speed4\" value=\"4\" required /><label for=\"speed4\">4</label>");
        	out.println("                                <input type=\"radio\" name=\"speed\" id=\"speed5\" value=\"5\" required /><label for=\"speed5\">5</label>");
        	out.println("                            </div>");
        	out.println("                            <div class=\"3\"></div>");
        	out.println("                        </div>");
        	out.println("                        <div class=\"d-flex\">");
        	out.println("                            <div class=\"col-3\"></div>");
        	out.println("                            <div class=\"col-3\">");
        	out.println("                                <p>Quality of Food: </p>");
        	out.println("                            </div>");
        	out.println("                            <div class=\"col-3 text-nowrap\">");
        	out.println("                                <input type=\"radio\" name=\"quality\" id=\"quality1\" value=\"1\" required /><label for=\"quality1\">1</label>");
        	out.println("                                <input type=\"radio\" name=\"quality\" id=\"quality2\" value=\"2\" required /><label for=\"quality2\">2</label>");
        	out.println("                                <input type=\"radio\" name=\"quality\" id=\"quality3\" value=\"3\" required /><label for=\"quality3\">3</label>");
        	out.println("                                <input type=\"radio\" name=\"quality\" id=\"quality4\" value=\"4\" required /><label for=\"quality4\">4</label>");
        	out.println("                                <input type=\"radio\" name=\"quality\" id=\"quality5\" value=\"5\" required /><label for=\"quality5\">5</label>");
        	out.println("                            </div>");
        	out.println("                            <div class=\"3\"></div>");
        	out.println("                        </div>");
        	out.println("                        <div class=\"d-flex\">");
        	out.println("                            <div class=\"col-3\"></div>");
        	out.println("                            <div class=\"col-3\">");
        	out.println("                                <p>Price: </p>");
        	out.println("                            </div>");
        	out.println("                            <div class=\"col-3 text-nowrap\">");
        	out.println("                                <input type=\"radio\" name=\"price\" id=\"price1\" value=\"1\" required /><label for=\"price1\">1</label>");
        	out.println("                                <input type=\"radio\" name=\"price\" id=\"price2\" value=\"2\" required /><label for=\"price2\">2</label>");
        	out.println("                                <input type=\"radio\" name=\"price\" id=\"price3\" value=\"3\" required /><label for=\"price3\">3</label>");
        	out.println("                                <input type=\"radio\" name=\"price\" id=\"price4\" value=\"4\" required /><label for=\"price4\">4</label>");
        	out.println("                                <input type=\"radio\" name=\"price\" id=\"price5\" value=\"5\" required /><label for=\"price5\">5</label>");
        	out.println("                            </div>");
        	out.println("                            <div class=\"3\"></div>");
        	out.println("                        </div>");
        	out.println("                        <div class=\"d-flex\">");
        	out.println("                            <div class=\"col-12\">");
        	out.println("                                <label class=\"d-block\">Other Comments (optional): </label>");
        	out.println("                                <textarea name=\"comments\" class=\"w-50 mb-3\" rows=\"5\"></textarea>");
        	out.println("                            </div>");
        	out.println("                        </div>");
        	out.println("                    </div>");
        	out.println("                </fieldset>");
        	out.println("");                
        	out.println("                <input type=\"reset\" id=\"resetButton\" class=\"mr-3\" value=\"Clear Answers\" />");
        	out.println("                <input type=\"submit\" id=\"submitButton\" value=\"Submit Review\" />");
        	out.println("		</form>");
        	out.println("        </div>");
        	out.println("");
        	out.println("        <!-- put script at the bottom of the body so it can run after the page is instantiated -->");
        	out.println("        <script type=\"text/javascript\" src=\"" + context + formJs + "\"></script> ");
        	out.println("    </body>");
	} 
	
	
	/** *****************************************************
	 *  Prints the results page, 
	 *  echoing the form data to the user.
	********************************************************* */
	private void PrintBody (PrintWriter out, HttpServletRequest request, Enumeration<String> parameters)
	{
	   String context = request.getContextPath();
		
	   out.println("	<body  class=\"container text-center\">");
	   out.println("		<h1>Form Results Page</h1>");
	   out.println("");
	   out.println("		<table>");
	   
	   // print table header
	   out.println("			<tr>");
	   out.println("				<td>Parameter Name</td>");
	   out.println("");
	   out.println("				<td>Value</td>");
	   out.println("			</tr>");
	   out.println("");
	   
	   // iteratively print out rows for each parameter/value pair
	   while (parameters.hasMoreElements()) {
		   String parameterName = parameters.nextElement();
		   String parameterValue = request.getParameter(parameterName);
		   
		   out.println("			<tr>");
		   out.println("				<td>" + parameterName + "</td>");
		   out.println("");
		   out.println("				<td>" + parameterValue + "</td>");
		   out.println("			</tr>");
		   out.println("");
	   }
	   
	   out.println("		</table>");
	   out.println("");
	   out.println("		<script type=\"text/javascript\" src=\"" + context + formJs + "\"></script>");
	   out.println("	</body>");
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
