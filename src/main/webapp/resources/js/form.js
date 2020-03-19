// put javascript here
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
}