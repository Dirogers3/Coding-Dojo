// var example = "I'm the example!";
// console.log(example);

// let example = "I'm the example!";
// console.log(example);

// var hello = 'world';
// console.log(hello);

// var needle = 'haystack';
// function test() {
//     var needle = 'magnet';
//     console.log(needle);
// }
// test();

// var brendan = 'super cool';
// function print(){ //doesn't ever call this function so it will not print anything
//     brendan = 'only okay';
//     console.log(brendan);
// }
// console.log(brendan);

// var food = 'chicken';
// console.log(food);
// function eat(){
//     food = 'half-chicken';
//     console.log(food);
//     var food = 'gone';
// }
// eat();//moved this down to the bottom so it will be called

// mean(); // function will not work unless it is after the declaration of the function
// console.log(food); // all of the console.logs out of the function will not work. food is not in the global scope.
// var mean = function () {
//     food = "chicken";
//     console.log(food);
//     var food = "fish";
//     console.log(food);
// }
// console.log(food);

// var mean = function () {
//     food = "chicken";
//     console.log(food);
//     var food = "fish";
//     console.log(food);
// }
// mean();

// console.log(genre);//nothing to console.log
// var genre = "disco";
// rewind();
// function rewind() {
//     genre = "rock";
//     console.log(genre); // prints rock
//     var genre = "r&b";
//     console.log(genre); // prints r&b and will stay in the scope
// }
// console.log(genre); // prints disco;


// var genre = "disco";
// rewind();
// function rewind() {
//     genre = "rock";
//     console.log(genre);
//     var genre = "r&b";
//     console.log(genre);
// }
// console.log(genre);


// dojo = "san jose";
// console.log(dojo); // prints san jose
// learn();
// function learn() {
//     dojo = "seattle";
//     console.log(dojo);
//     var dojo = "burbank";
//     console.log(dojo);
// }
// console.log(dojo);

// dojo = "san jose";
// function learn() {
//     dojo = "seattle";
//     console.log(dojo);
//     var dojo = "burbank";
//     console.log(dojo);
// }
// learn();
// console.log(dojo);

console.log(makeDojo("Chicago", 65));
console.log(makeDojo("Berkeley", 0));
function makeDojo(name, students) {
    const dojo = {};
    dojo.name = name;
    dojo.students = students;
    if (dojo.students > 50) {
        dojo.hiring = true;
    }
    else if (dojo.students <= 0) {
        //dojo = "closed for now"; // dojo is const, we will not be able to change it
        console.log("closed for now");
    }
    return dojo;
}

