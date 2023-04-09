$(document).ready(function(){
	
	const vote = {question: {id: getQuestionID()}, poll: null};
	
	$('input[type=radio][name=option]').change(function() {
	    vote.poll = {id: this.value};
		insertVote(vote);
	});
	
	
});

function insertVote(vote){
	$.ajax({
	    url: '/questions/vote',
	    type: 'POST',
	    data: JSON.stringify(vote),
	    contentType: 'application/json; charset=utf-8',
	    dataType: 'json',
	})
	.done(function(data){
		if(data.code!=0){
/*			$("#message").html("Question added succecfully");
			$("#message").show();*/
			console.log(data);
			disableRadios();
		}
	})
	.fail(function(data){
		if(data.status==401){ //unauthorized
			$("#message").empty();
			$("#message").removeClass("alert-success alert-danger").addClass("alert-danger");
			$("#message").html("Please, Login to cast vote");
			$("#message").show();
			clearRadios();
		}
	});
}

function getQuestionID(){
	return $("#questionId").val();
}
function clearRadios(){
	$('input[name="option"]').prop('checked', false);
}
function disableRadios(){
	$('input[name="option"]').prop('disabled', true);
}
