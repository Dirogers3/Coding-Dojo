var elem = document.getElementById("cookie-remove");

var degrees =   {fahrenheit:[   {todayhigh:"75°F",   todaylow:"65°F"},
                                {tomorrowhigh:"80°F",   tomorrowlow:"66°F"},
                                {fridayhigh:"69°F",     fridaylow:"61°F"},
                                {saturdayhigh:"78°F",   saturdaylow:"70°F"}
                            ],
                    celsius:[   {todayhigh:"23.9°C",    todaylow:"18.3°C"},
                                {tomorrowhigh:"26.7°C", tomorrowlow:"18.9°C"},
                                {fridayhigh:"20.6°C",   fridaylow:"16.1°C"},
                                {saturdayhigh:"25.6°C", saturdaylow:"21.1°C"}
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
