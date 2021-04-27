var firstOperand = "";
var secondOperand = "";
var operator = undefined;
var total = 0;

function clr() {
    firstOperand = "";
    secondOperand = "";
    operator = undefined;
    document.getElementById("display").innerHTML = "";
}
clr();
function setOP(op) {
    operator = op;
}
function press(number) {
    if(operator == undefined) {
        firstOperand = firstOperand + number;
        document.getElementById("display").innerHTML = firstOperand;
    }
    else if ( operator != undefined) {
        secondOperand = secondOperand + number;
        document.getElementById("display").innerHTML = secondOperand;
    }
}
function calculate() {
    if(operator == '+'){
        total = parseFloat(firstOperand) + parseFloat(secondOperand);
        document.getElementById("display").innerHTML = total;
        firstOperand = total; 
        secondOperand = "";
    }
    else if(operator == '-'){
        total = parseFloat(firstOperand) - parseFloat(secondOperand);
        document.getElementById("display").innerHTML = total;
        firstOperand = total;   
        secondOperand = "";  
    }
    else if(operator == '*'){
        total = parseFloat(firstOperand) * parseFloat(secondOperand);
        document.getElementById("display").innerHTML = total;
        firstOperand = total; 
        secondOperand = "";    
    }
    else if(operator == '/'){
        total = parseFloat(firstOperand) / parseFloat(secondOperand);
        document.getElementById("display").innerHTML = total;
        firstOperand = total;
        secondOperand = "";     
    }
}
