/*********************************************************************************
*   Print odds 1-20 - Using a loop write code that will console.
*       log all of the odd values from 1 up to 20.
*   Print the sequence - Using a loop write code that will console.
*       log the values in this sequence 4, 2.5, 1, -0.5, -2, -3.5.
*   Sigma - Write code that will add all of the values from 1-100 onto
*        some variable sum and at the end console.log the result
*        1 + 2 + 3 + ... + 98 + 99 + 100. We should get back 5050 
*        in the end.
*   Factorial - Write code that will multiply values from 1 to some value 
*        n until the variable product is larger than 1 billion (1e8 for short).
*        At the end console.log that value of n.
**********************************************************************************/

console.log("Print odds 1-20")
for(var i = 0; i <= 20; i++) {
    // this checks to see if the number is odd, If true it will console.log it.
    if(i % 2 != 0) {
        console.log(i);
    }
}

console.log("Print the sequence 4, 2.5, 1, -0.5, -2, -3.5")
// I set the limits of this loop to increment by -1.5 to get all the right numbers.
for(var i = 4; i >= -3.5; i-=1.5) {
    console.log(i);
}

console.log("Sigma 1 - 100 and should get 5050")
//initialized sum so I can use it to store numbers in the loop.
var sum = 0;
for(var i = 1; i <= 100; i++) {
    //this will add i to the sum and save sum after the operation.
    sum += i;
}
console.log(sum);

console.log("Factorial until product is larger than 1e8")
var product = 1;
var n = 0;
while(product < 100000000) {
    n++;
    product = product * n;
}
console.log(n);
console.log(product);