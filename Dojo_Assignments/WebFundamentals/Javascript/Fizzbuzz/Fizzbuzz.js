/*********************************************************************************
*   Write a short program that prints each number from 1 to 100 on a new line. 
*   For each multiple of 3, print "Fizz" instead of the number. 
*   For each multiple of 5, print "Buzz" instead of the number. 
*   For numbers which are multiples of both 3 and 5, print "FizzBuzz" instead of the number.
**********************************************************************************/

for (var i = 1; i <= 100; i++) {
    //this checks if the number is divisible by both 3 & 5 and if true it will print "FizzBuzz"
    if(i % 3 == 0 && i % 5 == 0) {
        console.log("FizzBuzz")
    }
    // This checks if the number is divisible by 3 and if true it will print "Fizz"
    else if(i % 3 == 0) {
        console.log("Fizz")
    }
    // This checks if the number is divisible by 5 and if true it will print "Buzz"
    else if(i % 5 == 0) {
        console.log("Buzz")
    }
    // if the number doesn't fit into any of the if statements above it will come here 
    // and just print the number directly to the console.
    else{
        console.log(i)
    }
}