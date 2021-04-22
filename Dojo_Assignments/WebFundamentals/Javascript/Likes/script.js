
var count = {
    1:0,
    2:0,
    3:0
};
function like(element) {
    var countlikes = document.querySelector("#count" + element);
    count[element]++;
    countlikes.innerHTML = count[element] + " like(s) "
}
