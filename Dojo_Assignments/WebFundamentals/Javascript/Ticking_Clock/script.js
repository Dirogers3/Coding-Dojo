function getSecondsSinceStartOfDay() {
    return new Date().getSeconds() + 
    new Date().getMinutes() * 60 + 
    new Date().getHours() * 3600;
}

setInterval( function() {
    var time = getSecondsSinceStartOfDay();
    console.log(time);
        document.getElementById("seconds").style.transform = "rotate(" + ((((getSecondsSinceStartOfDay()%60)/60)*360)+180) + "deg)";
        document.getElementById("minutes").style.transform = "rotate(" + (((((getSecondsSinceStartOfDay()/60)%60)/60)*360)+180) + "deg)";
        document.getElementById("hour").style.transform = "rotate(" + ((((getSecondsSinceStartOfDay()/3600%12)/12)*360)+180) + "deg)";
}, 1000);