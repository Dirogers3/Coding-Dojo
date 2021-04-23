var elem = document.getElementById("cookie-remove");

var degrees =   {fahrenheit:[   {todayhigh:"75°",   todaylow:"65°"},
                                {tomorrowhigh:"80°",   tomorrowlow:"66°"},
                                {fridayhigh:"69°",     fridaylow:"61°"},
                                {saturdayhigh:"78°",   saturdaylow:"70°"}
                            ],
                    celsius:[   {todayhigh:"23.9°",    todaylow:"18.3°"},
                                {tomorrowhigh:"26.7°", tomorrowlow:"18.9°"},
                                {fridayhigh:"20.6°",   fridaylow:"16.1°"},
                                {saturdayhigh:"25.6°", saturdaylow:"21.1°"}
                            ]
                }
function remove() {
    elem.remove();
}

function change(element) {
    var temp = degrees[element.value];
    for(let t of temp) {
        var keys = Object.keys(t);
        console.log(keys);
        document.getElementById(keys[0]).innerHTML = t[keys[0]];
        document.getElementById(keys[1]).innerHTML = t[keys[1]];
    }
}
