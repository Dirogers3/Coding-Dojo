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
    console.log(op);
}

function calculate() {
    if(operator == '+'){
        total = parseInt(firstOperand) + parseInt(secondOperand);
        document.getElementById("display").innerHTML = total;
        firstOperand = total; 
    }
    else if(operator == '-'){
        total = parseInt(firstOperand) - parseInt(secondOperand);
        document.getElementById("display").innerHTML = total;
        firstOperand = total;     
    }
    else if(operator == '*'){
        total = parseInt(firstOperand) * parseInt(secondOperand);
        document.getElementById("display").innerHTML = total;
        firstOperand = total;     
    }
    else if(operator == '/'){
        total = parseInt(firstOperand) / parseInt(secondOperand);
        document.getElementById("display").innerHTML = total;
        firstOperand = total;     
    }
    
}

function press(number) {
    if(operator == undefined) {
        firstOperand = firstOperand + number;
        console.log(firstOperand);
        document.getElementById("display").innerHTML = firstOperand;
    }
    else if ( operator != undefined) {
        secondOperand = secondOperand + number;
        console.log(secondOperand);
        document.getElementById("display").innerHTML = secondOperand;
    }
    
}
