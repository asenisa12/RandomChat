$(document).ready(function() {
	"use strict"
	
	var host = "http://private-d606-chatapi8.apiary-mock.com/notes";
		
		
	$.get(host).then(function(response){
		$(".jumbotron").append("<p>"+ response["title"]+"</p>");
	});
		


});