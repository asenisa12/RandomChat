$(document).ready(function() {
	"use strict"
	
	var host = "http://private-d606-chatapi8.apiary-mock.com/contact";
		
		
	$.get(host).then(function(response){
		$("#name").append("<p>"+ response["name"]+"</p>");
		$("#mail").append("<p>"+ response["mail"]+"</p>");
		$("#phone").append("<p>"+ response["phone"]+"</p>");
	});
		


});