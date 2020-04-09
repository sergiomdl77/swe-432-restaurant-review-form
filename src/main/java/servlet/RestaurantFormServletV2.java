package servlet;

import java.io.IOException;
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
	static String resultsPage = "/resources/restaurantForm/results.jsp";
	
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
		
		// set parameters to be forwarded to the results.jsp page
		while (requestParameters.hasMoreElements()) {
			String parameterName = requestParameters.nextElement();
			String parameterValue = request.getParameter(parameterName);
			
			request.setAttribute(parameterName, parameterValue);
	    }
		
		RequestDispatcher view = request.getRequestDispatcher(resultsPage);
        view.forward(request, response); 
	}
}


    /** *****************************************************
     *  Prints the <head> of the HTML page, no <body>.
    ********************************************************* */
    private void PrintHead (PrintWriter out, HttpServletRequest request)
    {
       String context = request.getContextPath();
        
       out.println("<html>");
       out.println("");
       out.println("    <head>");
       out.println("        <title>Rate Restaurants on Campus</title>");
       out.println("        <link rel=\"stylesheet\" type=\"text/css\" href=\"" + context + formStyles + "\">");
       out.println("        <link rel=\"stylesheet\" type=\"text/css\" href=\"" + context + bootstrapStyles + "\">");
       out.println("        <link rel=\"stylesheet\" type=\"text/css\" href=\"" + context + bootstrapGridStyles + "\">");
	    
       out.println("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/react/15.4.2/react.js\" charset="utf-8"></script>");
       out.println("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/react/15.4.2/react-dom.js\" charset="utf-8"></script>");
       out.println("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/babel-standalone/6.21.1/babel.min.js\" charset=\"utf-8\"></script>");

       out.println("        <script type=\"text/babel\">              ");
       out.println("class Form extends React.Component {              ");
       out.println("    render() {                                    ");
       out.println("       return (                                   ");

       out.println("        <div className\"text-center\">");
       out.println("            <h1>Rate Restaurants in Campus</h1>");
       out.println("            <p className\"f-09\">Form by Tanya Howard and Sergio Delgado</p>");
       out.println("            <form id=\"restaurantForm\" method=\"post\" action=\"" + Path + Servlet + "\">");
       out.println("                <fieldset className\"centerFieldset\">");
       out.println("                    <legend>Personal Information</legend>");
       out.println("                    <div>");
       out.println("                        <p className\"font-italic f-09\">Please provide some information about yourself.</p>");
       out.println("                        <div>");
       out.println("                            <label for=\"pName\">Name:</label>");
       out.println("                            <input type=\"text\" id=\"pName\" name=\"pName\" maxlength=\"20\" className\"input-box\" required />");
       out.println("                            <label for=\"pAge\">Age:</label>");
       out.println("                            <input type=\"number\" id=\"pAge\" name=\"pAge\" max=\"200\" maxlength=\"4\" className\"input-box\" required />");
       out.println("                            <div className\"radio-button-div\"> ");
       out.println("                                <label>Gender: </label>");
       out.println("                                <input type=\"radio\" name=\"pGender\" id=\"genderMale\" value=\"male\" required /><label for = \"genderMale\">Male</label>");
       out.println("                                <input type=\"radio\" name=\"pGender\" id=\"genderFemale\" value=\"female\" required /><label for = \"genderFemale\">Female</label>");
       out.println("                                <input type=\"radio\" name=\"pGender\" id=\"genderOther\" value=\"other\" required /><label for = \"genderOther\">Other</label>");
       out.println("                                <input type=\"text\"  id=\"pOtherGender\" name=\"pOtherGender\" placeholder=\"Other gender\" maxlength=\"15\" className\"input-box\" />");
       out.println("                            </div>");
       out.println("                        </div>");
       out.println("                    </div>");
       out.println("                </fieldset>");
       out.println("");
       out.println("                <fieldset>");
       out.println("                    <legend>Restaurant Information</legend>");
       out.println("                    <div>");
       out.println("                        <p className\"font-italic f-09\">Please provide information about the restaurant you visited on campus.</p>");
       out.println("                        <div>");
       out.println("                            <label for=\"rName\">Name:</label>");
       out.println("                            <input type=\"text\" id=\"rName\" name=\"rName\" maxlength=\"20\" className\"input-box\" required />");
       out.println("                            <label for=\"rVisit\">Date of Visit:</label>");
       out.println("                            <input type=\"date\" id=\"rVisit\" name=\"rVisit\" className\"input-box\" min=\"2000-01-01\" max=\"2020-12-31\" required />");
       out.println("                            <div className\"radio-button-div\"> ");
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
       out.println("                        <p className\"font-italic f-09\">Please rate each category from 1 to 5 based on your experience (1 being the worst rating, 5 being the best rating).</p>");
       out.println("                        <div>");
       out.println("                            <input type=\"button\" id=\"greatButton\" value=\"Everything was great!\" />");
       out.println("                            <p className\"f-09\">Rate everything as a 5.</p>");
       out.println("                        </div>");
       out.println("                        <div className\"d-flex\">");
       out.println("                            <div className\"col-3\"></div>");
       out.println("                            <div className\"col-3\">");
       out.println("                                <p>Customer Service: </p>");
       out.println("                            </div>");
       out.println("                            <div className\"col-3 text-nowrap\">");
       out.println("                                <input type=\"radio\" name=\"customerService\" id=\"cust1\" value=\"1\" required /><label for=\"cust1\">1</label>");
       out.println("                                <input type=\"radio\" name=\"customerService\" id=\"cust2\" value=\"2\" required /><label for=\"cust2\">2</label>");
       out.println("                                <input type=\"radio\" name=\"customerService\" id=\"cust3\" value=\"3\" required /><label for=\"cust3\">3</label>");
       out.println("                                <input type=\"radio\" name=\"customerService\" id=\"cust4\" value=\"4\" required /><label for=\"cust4\">4</label>");
       out.println("                                <input type=\"radio\" name=\"customerService\" id=\"cust5\" value=\"5\" required /><label for=\"cust5\">5</label>");
       out.println("                            </div>");
       out.println("                            <div className\"3\"></div>");
       out.println("                        </div>");
       out.println("                        <div className\"d-flex\">");
       out.println("                            <div className\"col-3\"></div>");
       out.println("                            <div className\"col-3\">");
       out.println("                                <p>Speed of Service: </p>");
       out.println("                            </div>");
       out.println("                            <div className\"col-3 text-nowrap\">");
       out.println("                                <input type=\"radio\" name=\"speed\" id=\"speed1\" value=\"1\" required /><label for=\"speed1\">1</label>");
       out.println("                                <input type=\"radio\" name=\"speed\" id=\"speed2\" value=\"2\" required /><label for=\"speed2\">2</label>");
       out.println("                                <input type=\"radio\" name=\"speed\" id=\"speed3\" value=\"3\" required /><label for=\"speed3\">3</label>");
       out.println("                                <input type=\"radio\" name=\"speed\" id=\"speed4\" value=\"4\" required /><label for=\"speed4\">4</label>");
       out.println("                                <input type=\"radio\" name=\"speed\" id=\"speed5\" value=\"5\" required /><label for=\"speed5\">5</label>");
       out.println("                            </div>");
       out.println("                            <div className\"3\"></div>");
       out.println("                        </div>");
       out.println("                        <div className\"d-flex\">");
       out.println("                            <div className\"col-3\"></div>");
       out.println("                            <div className\"col-3\">");
       out.println("                                <p>Quality of Food: </p>");
       out.println("                            </div>");
       out.println("                            <div className\"col-3 text-nowrap\">");
       out.println("                                <input type=\"radio\" name=\"quality\" id=\"quality1\" value=\"1\" required /><label for=\"quality1\">1</label>");
       out.println("                                <input type=\"radio\" name=\"quality\" id=\"quality2\" value=\"2\" required /><label for=\"quality2\">2</label>");
       out.println("                                <input type=\"radio\" name=\"quality\" id=\"quality3\" value=\"3\" required /><label for=\"quality3\">3</label>");
       out.println("                                <input type=\"radio\" name=\"quality\" id=\"quality4\" value=\"4\" required /><label for=\"quality4\">4</label>");
       out.println("                                <input type=\"radio\" name=\"quality\" id=\"quality5\" value=\"5\" required /><label for=\"quality5\">5</label>");
       out.println("                            </div>");
       out.println("                            <div className\"3\"></div>");
       out.println("                        </div>");
       out.println("                        <div className\"d-flex\">");
       out.println("                            <div className\"col-3\"></div>");
       out.println("                            <div className\"col-3\">");
       out.println("                                <p>Price: </p>");
       out.println("                            </div>");
       out.println("                            <div className\"col-3 text-nowrap\">");
       out.println("                                <input type=\"radio\" name=\"price\" id=\"price1\" value=\"1\" required /><label for=\"price1\">1</label>");
       out.println("                                <input type=\"radio\" name=\"price\" id=\"price2\" value=\"2\" required /><label for=\"price2\">2</label>");
       out.println("                                <input type=\"radio\" name=\"price\" id=\"price3\" value=\"3\" required /><label for=\"price3\">3</label>");
       out.println("                                <input type=\"radio\" name=\"price\" id=\"price4\" value=\"4\" required /><label for=\"price4\">4</label>");
       out.println("                                <input type=\"radio\" name=\"price\" id=\"price5\" value=\"5\" required /><label for=\"price5\">5</label>");
       out.println("                            </div>");
       out.println("                            <div className\"3\"></div>");
       out.println("                        </div>");
       out.println("                        <div className\"d-flex\">");
       out.println("                            <div className\"col-12\">");
       out.println("                                <label className\"d-block\">Other Comments (optional): </label>");
       out.println("                                <textarea name=\"comments\" className\"w-50 mb-3\" rows=\"5\"></textarea>");
       out.println("                            </div>");
       out.println("                        </div>");
       out.println("                    </div>");
       out.println("                </fieldset>");
       out.println("");                
       out.println("                <input type=\"reset\" id=\"resetButton\" className\"mr-3\" value=\"Clear Answers\" />");
       out.println("                <input type=\"submit\" id=\"submitButton\" value=\"Submit Review\" />");
       out.println("       </form>");
       out.println("        </div>");
       out.println("");
       out.println("        <!-- put script at the bottom of the body so it can run after the page is instantiated -->");
       out.println("        <script type=\"text/javascript\" src=\"" + context + formJs + "\"></script> ");

       out.println("       )                                          ");
       out.println("    }                                             ");
       out.println("    ReactDOM.render(                              ");
       out.println("       <Form />,  document.getElementById('root') ");
       out.println("    );                                            ");
       out.println("}                                                  ")
    

       out.println("        </script>                                  ")

       out.println("    </head>");
       out.println("");



    private void PrintBody (PrintWriter out, HttpServletRequest request)
    {
       String context = request.getContextPath();
       
            out.println("    <body class=\"container\">");
            out.println("       <div id="root"></div>");
            out.println("    </body>");
    }
    
    
