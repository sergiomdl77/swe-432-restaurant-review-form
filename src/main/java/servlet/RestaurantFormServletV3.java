package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.net.URISyntaxException;

/**
 * Servlet implementation class RestaurantFormServlet
 */
@WebServlet(
        name = "RestaurantFormServletV3",
        urlPatterns = {"/restaurantForm3"}
    )
public class RestaurantFormServletV3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// Location of servlet.
	static String Domain  = "";
	static String Path    = "";
	static String Servlet = "restaurantForm3";
	
	static String formStyles = "/resources/css/form.css";
	static String bootstrapStyles = "/resources/css/bootstrap.min.css";
	static String bootstrapGridStyles = "/resources/css/bootstrap-grid.min.css.css";
    
	static String formJs = "/resources/js/form.js";

	private static Connection connection = null;
	
	private static String[] headerNames = {"pName", "pAge", "pGender", "pOtherGender", "rName", "rVisit",
        	"vTime", "customerService", "speed", "quality", "price", "comments"};
	private static String[] reviewTableHeaderNames = {"restaurant", "average rating"};
	
	private class EntriesManager{
		private Connection getConnection()
				throws URISyntaxException, SQLException {
			String dbUrl = System.getenv("JDBC_DATABASE_URL");
			return DriverManager.getConnection(dbUrl);
		}

		public boolean save(Enumeration<String> parameters, HttpServletRequest request){
			PreparedStatement statement = null;
			try {
				connection = connection == null ? getConnection() : connection;
				statement = connection.prepareStatement(
						"INSERT INTO reviews (pName, pAge, pGender, pOtherGender, rName, rVisit, vTime, customerService, speed, quality, price, comments) values (?,?,?,?,?,?,?,?,?,?,?,?);" 
						);  

				int c = 1;
				while (parameters.hasMoreElements()) 
				{
					String parameterName = parameters.nextElement();
					String parameterValue = request.getParameter(parameterName);

					if (parameterName.compareTo("pAge") == 0 || parameterName.compareTo("customerService") == 0 || 
							parameterName.compareTo("speed") == 0 || parameterName.compareTo("quality") == 0 || 
							parameterName.compareTo("price") == 0)
					{
						int intValue = Integer.parseInt(parameterValue);
						statement.setInt(c, intValue);
					}
					else
						statement.setString(c, parameterValue);

					c++;	

				} // end while

				statement.executeUpdate();
				return true;

			}catch(URISyntaxException uriSyntaxException){
				uriSyntaxException.printStackTrace();
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}finally {
				if (statement != null) {
					try{
						statement.close();
					}catch(SQLException sqlException){
						sqlException.printStackTrace();
					}
				}
			}

			return false;
		}	

		public String[][] getAllReviews()
		{
			int reviewsCount;
			String[][] reviewsTable = new String[200][12];
			for (int i=0; i<200; i++)
				for (int j=0; j<12; j++)
					reviewsTable[i][j] = "";

			Statement statement = null;
			ResultSet entries = null;

			try {
				connection = connection == null ? getConnection() : connection;
				statement = connection.createStatement();
				entries = statement.executeQuery(
						"SELECT pName, pAge, pGender, pOtherGender, rName, rVisit, vTime, customerService, speed, quality, price, comments FROM reviews"
						);

				reviewsCount = 0;
				while (entries.next())
				{
					for (int i=1; i<=12; i++)
					{
						if (i==2 || i==8 || i==9 || i==10 || i==11)
							reviewsTable[reviewsCount][i-1] = Integer.toString(entries.getInt(i));
						else
							reviewsTable[reviewsCount][i-1] = entries.getString(i);
					}
					reviewsCount++;
				}
				return reviewsTable;
			}// end of try

			catch(URISyntaxException uriSyntaxException){
				uriSyntaxException.printStackTrace();
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}finally {
				if (statement != null) {
					try{
						statement.close();
					}catch(SQLException sqlException){
						sqlException.printStackTrace();
					}
				}
			}
			return null;
		} // end of getAllReviews


	}// end of class EntriesManager	
				
				
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
		HttpSession session = request.getSession();


		out.println("    <body class=\"container\">");
		out.println("        <div class=\"text-center\">");
		
		// display a welcome back message if the user has visited this site in the same session
		if (session.isNew()) {
			out.println("            <h1>Rate Restaurants on Campus Form</h1>");
		}
		else {
			out.println("            <h1>Welcome Back to the Rate Restaurants on Campus Form</h1>");
		}
		
		out.println("            <p class=\"f-09 mb-0\">Form by Sergio Delgado and Tanya Howard </p>");
		out.println("            <a class=\"f-09\" href=\"http://mason.gmu.edu/~thoward9/Assignment8/SWE432%20-%20Assignment%208%20Collaboration%20Summary.pdf\" target=\"_blank\">Collaboration Summary</a>");
		out.println("            <p class=\"f-09 font-weight-bold mb-0\">Additional Features Implemented:</p>");
		out.println("            <ul class=\"f-09\">");
		out.println("            	<li class=\"f-09\">Store the data into a database.</li>");
		out.println("            	<li class=\"f-09\">An average or aggregate summary of all reviews.</li>");
		out.println("            	<li class=\"f-09\">Add use of a session object to display either the default header for the form, or a 'Welcome Back' message.</li>");
		out.println("            </ul>");
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
		out.println("		 	</form>");
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
		
		// print all previous reviews in a table
		out.println("	<body  class=\"container-fluid text-center\">");
		out.println("		<h1>All Reviews</h1>");
		out.println("		<p class=\"font-italic f-09\">Thank you for submitting the form.</p>");
		out.println("		<table class=\"table table-sm table-bordered table-hover\">");

		// print table header
		out.println("			<thead class=\"thead-light\">");
		out.println("				<tr>");
		for (int i = 0; i < headerNames.length; i++) {
			out.println("				<th>" + headerNames[i] + "</th>");
		}
		out.println("				</tr>");
		out.println("			</thead>");
			
		// save the current review in db and retrieve all previous reviews
		EntriesManager entriesManager = new EntriesManager();
		boolean ok = entriesManager.save(parameters, request);
		String[][] reviewsTable = entriesManager.getAllReviews();
		HashMap<String, HashMap<Integer, Integer>> avgReviewsMap = new HashMap(); // parameters: restaurant name, sum, numReviews

		// print table body
		out.println("			<tbody>");
		for (int i = 0; i < reviewsTable.length; i++)
		{
			if (reviewsTable[i][0].trim() == "") {
				break; // name is required, so if it's empty that means we have reached an empty row
				// for some reason, the default size of the table is 200, so lots of useless rows are printed without this check
			}
			String restaurantName = "";
			boolean foundRestaurantName = false;

			out.println("				<tr>");
			for (int j = 0; j < headerNames.length; j++)
			{
				// get the restaurant name and insert into hashmap if it's not already in there
				if (!foundRestaurantName && headerNames[j].compareTo("rName") == 0) {
					restaurantName = reviewsTable[i][j];
					if (!avgReviewsMap.containsKey(restaurantName)) {
						HashMap<Integer, Integer> x = new HashMap();
						x.put(0, 0);
						avgReviewsMap.put(restaurantName, x);
					}
					foundRestaurantName = true;
				}
				// add up total sum of reviews for that restaurant and keep track of numReviews to aid in calculating average
				if (foundRestaurantName && headerNames[j].compareTo("customerService") == 0 || 
							headerNames[j].compareTo("speed") == 0 || headerNames[j].compareTo("quality") == 0 || 
							headerNames[j].compareTo("price") == 0) {
					int sum = new ArrayList<Integer>(avgReviewsMap.get(restaurantName).keySet()).get(0);
					int numReviews = avgReviewsMap.get(restaurantName).get(sum);
					numReviews++;
					sum += Integer.parseInt(reviewsTable[i][j]);
					HashMap<Integer, Integer> x = new HashMap();
					x.put(sum, numReviews);
					avgReviewsMap.replace(restaurantName, x);
				}
				
				// print out value for parameter
				out.println("					<td>  " + reviewsTable[i][j] + " </td>");
			}
			out.println("				</tr>");
		}
		out.println("			</tbody>");
		out.println("	  </table>");
		
		// print out average of all reviews by restaurant
		out.println("		<h2>Aggregate Summary of Reviews</h2>");
		out.println("		<p class=\"font-italic f-09\">Here are the aggregate reviews per restaurant.</p>");
		out.println("		<table class=\"table table-sm table-bordered table-hover\">");

		// print table header
		out.println("			<thead class=\"thead-light\">");
		out.println("				<tr>");
		for (int i = 0; i < reviewTableHeaderNames.length; i++) {
			out.println("					<th>" + reviewTableHeaderNames[i] + "</th>");
		}
		out.println("				</tr>");
		out.println("			</thead>");
		
		// print table body
		out.println("			<tbody>");
		ArrayList<String> restaurants = new ArrayList(avgReviewsMap.keySet());
		for (int i = 0; i < restaurants.size(); i++) {
			out.println("				<tr>");
			
			String restaurantName = restaurants.get(i);
			int sum = new ArrayList<Integer>(avgReviewsMap.get(restaurantName).keySet()).get(0);
			int numReviews = avgReviewsMap.get(restaurantName).get(sum);
			double average = sum / numReviews;
			
			out.println("					<td> " + restaurantName + "  </td>");
			out.println("					<td> " + average + "  </td>");
			out.println("				</tr>");
		}
		out.println("			</tbody>");
		out.println("	  </table>");
		out.println("  </body>");
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
