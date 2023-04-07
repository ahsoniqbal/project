$(document).ready(function(){
	
	let pollSize = 3;
	$("#addOption").on('click', (e)=>{
		e.preventDefault();
		if(pollSize<=6){
			
			let pollHTML = 
			`<div class="form-group">
		    	<label for="poll${pollSize}">Option ${pollSize}</label>
		    	<input type="text" th:field="*{polls[${pollSize-1}].body}" name="polls[${pollSize-1}]" id="poll${pollSize}" class="form-control polls" />
		  	</div>`
			$("#polls").append(pollHTML);
			console.log(pollSize);
			pollSize++;
		}else{
			$('.alert').show()
		}
	
	});
	
	var arr = { name: $("#name").val(), age: $("#age").val(), phone: $("#phone").val()};
		$.ajax({
		    url: '/register',
		    type: 'POST',
		    data: JSON.stringify(arr),
		    contentType: 'application/json; charset=utf-8',
		    dataType: 'json',
		})
		.done(function(data){
			console.log(data);
		});
	
});