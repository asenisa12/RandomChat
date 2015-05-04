$(document).ready(function() {
	"use strict"
	$.get("http://localhost:8080/ChatProject/rest/history/get").then(function(response){
		$(".jumbotron").html();
	});
});