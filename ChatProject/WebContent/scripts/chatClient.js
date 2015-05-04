var user = prompt("What's your name?");
var started = false;
var poolIt = function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/ChatProject/rest/chat/" + user,
        dataType: "text",
        success: function (message) {
            $("#messages").append("<li>" + message + "</li>");
            poolIt();
        }
    });
}

// When the submit button is clicked;
$("#datasend").click(function () {

	// if it is the first time ;
    if (!started) { 
    	started = true;
        poolIt();
    }
	$("#messages").append("<li>YOU:" + $("#data").val() + "</li>");
    $.ajax({
        type: "POST", // HTTP POST request
        url: "http://localhost:8080/ChatProject/rest/chat/" + user,// access to the sendMessage(..) method.
        dataType: "text", // Incoming data type -> text
        data: $("#data").val(), // Chat message to send
        contentType: "text/plain", // The type of the sent message
        success: function (data) {
        }
    });
    $.ajax({
		type: 'POST',
		url: "http://localhost:8080/ChatProject/rest/history/post",
		data: JSON.stringify({
			id:1,
			name: user,
			data: $("#data").val(),
		}),
		dataType: "json",
		contentType: "application/json",

	})
});