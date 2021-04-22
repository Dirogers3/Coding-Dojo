var notificationCount = 2;
var connectionCount = 24;
function edit(){
    document.getElementById("username").innerHTML = "Jane Doe";
}

function remove(){
    notificationCount--;
    document.getElementById("user1").remove();
    document.getElementById("notification_count").innerHTML = notificationCount;
}

function remove2(){
    notificationCount--;
    document.getElementById("user2").remove();
    document.getElementById("notification_count").innerHTML = notificationCount;
}

function add(){
    notificationCount--;
    connectionCount++;
    document.getElementById("user1").remove();
    document.getElementById("connection_count").innerHTML = connectionCount;
    document.getElementById("notification_count").innerHTML = notificationCount;
}

function add2(){
    notificationCount--;
    connectionCount++;
    document.getElementById("user2").remove();
    document.getElementById("connection_count").innerHTML = connectionCount;
    document.getElementById("notification_count").innerHTML = notificationCount;
}