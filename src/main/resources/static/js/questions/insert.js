$(document).ready(function(){
	
	let pollSize = 3;
	$("#addOption").on('click', (e)=>{
		e.preventDefault();
		if(pollSize<=6){
			
			let pollHTML = 
			`<div class="form-group">
		    	<label for="poll${pollSize}">Option ${pollSize}</label>
		    	<input type="text" name="polls[${pollSize-1}]" id="poll${pollSize}" class="form-control polls" />
		  	</div>`
			$("#polls").append(pollHTML);
			console.log(pollSize);
			pollSize++;
		}else{
			$('.alert').show()
		}
	});
	
	$("#btnInsert").on('click', (e)=>{
		e.preventDefault();
		const que = getQuestionValues();	
		addQuestion(que);
	});
});

// getting object of question with options
function getQuestionValues(){
	let polls = []
	$(".polls").each(function(i, poll){
		polls.push({body: poll.value}); 
	});
	
	let question = { 
		question: $("#question").val(),
		polls: polls
	};
	return question;
}

//clear input fileds
function clearFileds(){
	$("#question").val('');
	$(".polls").each(function(i, poll){
		poll.value = '';
	});
	
	return question;
}

function addQuestion(question){
	$.ajax({
	    url: '/questions',
	    type: 'POST',
	    data: JSON.stringify(question),
	    contentType: 'application/json; charset=utf-8',
	    dataType: 'json',
	})
	.done(function(data){
		if(data.code!=0){
			$("#message").html("Question added succecfully");
			$("#message").show();
			clearFileds();
		}
	})
	.fail(function(data){
		console.log(data);
	});
}


