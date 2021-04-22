var countlikes = document.querySelector("#count");
var count = 0;
function like() {
    count++;
    countlikes.innerHTML = count + " like(s) "
}
var count2 = 0;
function like2() {
    count2++;
    document.getElementById("count2").innerHTML= count2 + " like(s)";
}
var count3 = 0;
function like3() {
    count3++;
    document.getElementById("count3").innerHTML= count3 + " like(s)";
}