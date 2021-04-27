/*********************************************************************************
*   
*      Array Challenges - Just getting comfortable. 
*
**********************************************************************************/
//High Pass Filter - Given an array and a value cutoff,
// return a new array containing only the values larger than cutoff.
function highPass(arr, cutoff) {
    var filteredArr = [];
    // your code here
    // created a forloop to go through each element of the array
    for(var i = 0; i < arr.length; i++) {
        // if the element is greater it will be pushed to the new array.
        if(arr[i] > cutoff){
            filteredArr.push(arr[i]);
        }
    }
    return filteredArr;
}
var result = highPass([6, 8, 3, 10, -2, 5, 9], 5);
console.log(result); // we expect back [6, 8, 10, 9]



/*********************************************************************/
//Evens or Odds - Given an array, determine if the values that are odd 
// when added together are larger than the even values added together. 
// If they are equal say that they are "tied".
function evensOfOdds(arr) {
    var totalOdds = 0;
    var totalEvens = 0;
    // your code here
    // created a forloop to go through each element in the array
    for(var i = 0; i < arr.length; i++) {
        // if even add to even total
        if(arr[i] % 2 == 0){
            totalEvens += arr[i];
        }
        // if odd add to odd total
        else {
            totalOdds += arr[i];
        }
    }
    // whuch ever total is greater return the appropriate message.
    if(totalEvens > totalOdds) {
        return "evens are larger";
    }
    else {
        return "odds are larger";
    }
}
var result = evensOfOdds([6, 8, 3, 10, -2, 5, 9]);
console.log(result); // we expect back "evens are larger"


/*********************************************************************/
// Better than average - Given an array of numbers return a count of 
// how many of the numbers are larger than the average.
function betterThanAverage(arr) {
    var sum = 0;
    // created a loop to add the contents of the array.
    for(var i = 0; i < arr.length; i++){
        sum += arr[i]
    }
    // calculate the average by dividing the sum by the number of elements in the array.
    avg = sum / arr.length;
    var count = 0;
    // count how many values are greated than the average.
    for(var i = 0; i < arr.length; i++){
        // if the array element is larger than the avg increment count by 1.
        if(arr[i]>avg){
            count++;
        }
    }
    return count;
}
var result = betterThanAverage([6, 8, 3, 10, -2, 5, 9]);
console.log(result); // we expect back 4


/********************************************************************
 *  Fibonacci Array - Fibonacci numbers have been studied for years and 
 *  appear often in nature. Write a function that will return an array of 
 *  Fibonacci numbers up to a given length n. Fibonacci numbers are 
 *  calculated by adding the last two values in the sequence together.
 *  So if the 4th value is 2 and the 5th value is 3 then the next value 
 *  in the sequence is 5.
***********************************************************************/

function fibonacciArray(n) {
    // the [0, 1] are the starting values of the array to calculate the rest from
    var fibArr = [0, 1];
    // your code here
    //  we will start i at 2 because the array already has 2 elements.
    //  we will set the limit to n ( length of fibonacci array )
    for(var i = 2; i < n; i++){
        // calculate & store the next fibonacci number in temp
        var tempValue = fibArr[i-1] + fibArr[i-2];
        // add that new fibonacci number into the array.
        fibArr.push(tempValue);
    }
    return fibArr;
}
var result = fibonacciArray(10);
console.log(result); // we expect back [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]