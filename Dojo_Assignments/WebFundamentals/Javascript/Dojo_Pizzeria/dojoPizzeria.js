// This function will take ingredients and put it in the pizza objects and return pizza.
function pizzeria(dough, sauce, cheese, toppings) {
    var pizza = {};
    pizza.dough = dough;
    pizza.sauce = sauce;
    pizza.cheese = cheese;
    pizza.toppings = toppings;
    return pizza;
}
// This function will generate a randome pizza from the 4 different types of pizzas below
function randomPizzaGen(){
    console.log("Random pizza is: ")
    var randomNumber = Math.floor(Math.random()*4+1);
    if(randomNumber === 1){
        console.log(pizza1);
    }
    if(randomNumber === 2){
        console.log(pizza2);
    }
    if(randomNumber === 3){
        console.log(pizza3);
    }
    if(randomNumber === 4){
        console.log(pizza4);
    }
}

//These lines of code will input pizza ingredients into each object and display it as a string.
console.log("pizza1:");
var pizza1 = pizzeria("deep dish", "traditional", ["mozzarella"], ["pepperoni","sausage"]);
console.log(pizza1);

console.log("pizza2:");
var pizza2 = pizzeria("hand tossed", "marinara", ["mozzarella","feta"], ["mushrooms", "olives", "onions"])
console.log(pizza2);

console.log("pizza3:");
var pizza3 = pizzeria("regular", "tomato sauce", ["mozzarella"], ["mushrooms", "olives", "sausage", "pepporoni", "bacon"])
console.log(pizza3);

console.log("pizza4:");
var pizza4 = pizzeria("hand tossed", "tomato sauce", ["mozzarella"], ["ham", "pineapple"])
console.log(pizza4);

randomPizzaGen();
