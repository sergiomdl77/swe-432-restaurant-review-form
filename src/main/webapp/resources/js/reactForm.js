class Form extends React.Component {
        render() {
             return( 
        <div className="text-center">
            <h1>Rate Restaurants on Campus</h1>
            <p className="f-09">Form by Tanya Howard and Sergio Delgado</p>
            <form id="restaurantForm" method="post" action="restaurantForm2">
                <fieldset className="centerFieldset">
                    <legend>Personal Information</legend>
                    <div>
                        <p className="font-italic f-09">Please provide some information about yourself.</p>
                        <div>
                            <label htmlFor="pName">Name:</label>
                            <input type="text" id="pName" name="pName" maxLength="20" className="input-box" required/>
                            <label htmlFor="pAge">Age:</label>
                            <input type="number" id="pAge" name="pAge" min="1" max="200" maxLength="4" className="input-box" required/>
                            <div className="radio-button-div"> 
                                <label>Gender: </label>
                                <input type="radio" name="pGender" id="genderMale" value="male" required/><label htmlFor="genderMale">Male</label>
                                <input type="radio" name="pGender" id="genderFemale" value="female" required/><label htmlFor="genderFemale">Female</label>
                                <input type="radio" name="pGender" id="genderOther" value="other" required/><label htmlFor="genderOther">Other</label>
                                <input type="text" id="pOtherGender" name="pOtherGender" placeholder="Other gender" maxLength="15" className="input-box"/>
                            </div>
                        </div>
                    </div>
                </fieldset>

                <fieldset>
                    <legend>Restaurant Information</legend>
                    <div>
                        <p className="font-italic f-09">Please provide information about the restaurant you visited on campus.</p>
                        <div>
                            <label htmlFor="rName">Name:</label>
                            <input type="text" id="rName" name="rName" maxLength="20" className="input-box" required/>
                            <label htmlFor="rVisit">Date of Visit:</label>
                            <input type="date" id="rVisit" name="rVisit" className="input-box" min="2000-01-01" max="2020-12-31" required/>
                            <div className="radio-button-div"> 
                                <label>Time of Visit: </label>
                                <input type="radio" name="vTime" id="timeBreakfast" value="Breakfast" required/><label htmlFor="timeBreakfast">Breakfast</label>
                                <input type="radio" name="vTime" id="timeLunch" value="Lunch" required/><label htmlFor="timeLunch">Lunch</label>
                                <input type="radio" name="vTime" id="timeDinner" value="Dinner" required/><label htmlFor="timeDinner">Dinner</label>
                            </div>
                        </div>
                    </div>
                </fieldset>
                <fieldset>
                    <legend>Review</legend>
                    <div>
                        <p className="font-italic f-09">Please rate each category from 1 to 5 based on your experience (1 being the worst rating, 5 being the best rating).</p>
                        <div>
                            <input type="button" id="greatButton" value="Everything was great!"/>
                            <p className="f-09">Rate everything as a 5.</p>
                        </div>
                        <div className="d-flex">
                            <div className="col-3"></div>
                            <div className="col-3">
                                <p>Customer Service: </p>
                            </div>
                            <div className="col-3 text-nowrap">
                                <input type="radio" name="customerService" id="cust1" value="1" required/><label htmlFor="cust1">1</label>
                                <input type="radio" name="customerService" id="cust2" value="2" required/><label htmlFor="cust2">2</label>
                                <input type="radio" name="customerService" id="cust3" value="3" required/><label htmlFor="cust3">3</label>
                                <input type="radio" name="customerService" id="cust4" value="4" required/><label htmlFor="cust4">4</label>
                                <input type="radio" name="customerService" id="cust5" value="5" required/><label htmlFor="cust5">5</label>
                            </div>
                            <div className="col-3"></div>
                        </div>
                        <div className="d-flex">
                            <div className="col-3"></div>
                            <div className="col-3">
                                <p>Speed of Service: </p>
                            </div>
                            <div className="col-3 text-nowrap">
                                <input type="radio" name="speed" id="speed1" value="1" required/><label htmlFor="speed1">1</label>
                                <input type="radio" name="speed" id="speed2" value="2" required/><label htmlFor="speed2">2</label>
                                <input type="radio" name="speed" id="speed3" value="3" required/><label htmlFor="speed3">3</label>
                                <input type="radio" name="speed" id="speed4" value="4" required/><label htmlFor="speed4">4</label>
                                <input type="radio" name="speed" id="speed5" value="5" required/><label htmlFor="speed5">5</label>
                            </div>
                            <div className="col-3"></div>
                        </div>
                        <div className="d-flex">
                            <div className="col-3"></div>
                            <div className="col-3">
                                <p>Quality of Food: </p>
                            </div>
                            <div className="col-3 text-nowrap">
                                <input type="radio" name="quality" id="quality1" value="1" required/><label htmlFor="quality1">1</label>
                                <input type="radio" name="quality" id="quality2" value="2" required/><label htmlFor="quality2">2</label>
                                <input type="radio" name="quality" id="quality3" value="3" required/><label htmlFor="quality3">3</label>
                                <input type="radio" name="quality" id="quality4" value="4" required/><label htmlFor="quality4">4</label>
                                <input type="radio" name="quality" id="quality5" value="5" required/><label htmlFor="quality5">5</label>
                            </div>
                            <div className="col-3"></div>
                        </div>
                        <div className="d-flex">
                            <div className="col-3"></div>
                            <div className="col-3">
                                <p>Price: </p>
                            </div>
                            <div className="col-3 text-nowrap">
                                <input type="radio" name="price" id="price1" value="1" required/><label htmlFor="price1">1</label>
                                <input type="radio" name="price" id="price2" value="2" required/><label htmlFor="price2">2</label>
                                <input type="radio" name="price" id="price3" value="3" required/><label htmlFor="price3">3</label>
                                <input type="radio" name="price" id="price4" value="4" required/><label htmlFor="price4">4</label>
                                <input type="radio" name="price" id="price5" value="5" required/><label htmlFor="price5">5</label>
                            </div>
                            <div className="col-3"></div>
                        </div>
                        <div className="d-flex">
	                        <div className="col-3"></div>
	                        <div className="col-3">
	                            <p>Menu Variety: </p>
	                        </div>
	                        <div className="col-3 text-nowrap">
	                            <input type="radio" name="variety" id="variety1" value="1" required/><label htmlFor="variety1">1</label>
	                            <input type="radio" name="variety" id="variety2" value="2" required/><label htmlFor="variety2">2</label>
	                            <input type="radio" name="variety" id="variety3" value="3" required/><label htmlFor="variety3">3</label>
	                            <input type="radio" name="variety" id="variety4" value="4" required/><label htmlFor="variety4">4</label>
	                            <input type="radio" name="variety" id="variety5" value="5" required/><label htmlFor="variety5">5</label>
	                        </div>
	                        <div className="col-3"></div>
	                    </div>
                        <div className="d-flex">
                            <div className="col-12">
                                <label className="d-block">Other Comments (optional): </label>
                                <textarea name="comments" className="w-50 mb-3" rows="5"></textarea>
                            </div>
                        </div>
                    </div>
                </fieldset>
                
                <input type="reset" id="resetButton" className="mr-3" value="Clear Answers"/>
                <input type="submit" id="submitButton" value="Submit Review"/>
            </form>
        </div>
		  
            );
        }
    }
    ReactDOM.render(
        <Form />,
        document.getElementById('root')
    );
    
    var form;

    (function() {
        form = document.getElementById("restaurantForm");
        focusOnFirstInput();
        addGreatButtonListener();
    })();

    function focusOnFirstInput() {
        document.getElementById("pName").focus(); // focus on first input element
    }
    function addGreatButtonListener() {
        document.getElementById("greatButton").addEventListener("click", rateEverything);
    }
    function rateEverything() {
        document.getElementById("cust5").checked = true;
        document.getElementById("speed5").checked = true;
        document.getElementById("quality5").checked = true;
        document.getElementById("price5").checked = true;
        document.getElementById("variety5").checked = true;
    }