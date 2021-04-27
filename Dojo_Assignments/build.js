var sidelength = (Math.floor(Math.random()*30)+10);
var map = [];
console.log("this is working");

function buildMap(){
console.log(sidelength);
// this will loop through each row
// i[j,j,j,j,j,j] i=0
// i[j,j,j,j,j,j]
// i[j,j,j,j,j,j]
// i[j,j,j,j,j,j]
// i[j,j,j,j,j,j] i= sidelength

    for(var i = 0; i <= sidelength; i++){
        if (i===0 | i===sidelength){
            for(var j = 0; j <= sidelength; j++){
                map[i].push(1);
            }
        }
        else if (i!==0 & i!==sidelength){
            for(var j = 0; j <= sidelength; j++){
                if(j===0 | j ===sidelength){
                    map.push(1);
                }
                else if (j!= 0 & j!== sidelength){
                    map.push(Math.floor(Math.random()*3)+2);
                }
            }
        }
    }
}
console.log(map);

buildMap();