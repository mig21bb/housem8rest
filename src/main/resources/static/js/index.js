/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function myFunction(p1, p2) {
    return p1 * p2;              // The function returns the product of p1 and p2
}

function introNew(obj){
    $('#new_'+obj).show();
    $('#new_element').prop('disabled', true);
    
}

function cancelNew(obj){
    $('#new_'+obj).hide();
    $('#new_element').prop('disabled', false);
}

$('form[id=newCostForm]').submit(function(event){

	event.preventDefault();
	var amount = $(this).find("input[name='amount']").val()
	$(this).find("input[name='amount']").val(amount.replace(',','.'));
	console.log("submitting newCostForm");
	$.ajax({
			method: "POST",
			url: "/newCost",
			data: $(this).serialize(),		
			error: function(xhr,error){
		   	console.log("error on ajax call: "+xhr);
		   },
		   success:function(response){
		   	console.log(response);
		   		if(response>0){
		   			location.reload();
		   		}else{
		   			alert("Error al crear el nuevo gasto.")
		   		}
		   	
		   }
		   
		   
	});
	

});

$('form[id=newHouseForm]').submit(function(event){

	event.preventDefault();		
	console.log("submitting newHouseForm");
	$.ajax({
			method: "POST",
			url: "/newHouse",
			data: $(this).serialize(),		
			error: function(xhr,error){
		   	console.log("error on ajax call: "+xhr);
		   },
		   success:function(response){
		   	console.log(response);
		   		if(response>0){
		   			location.reload();
		   		}else{
		   			alert("Error al crear el nuevo gasto.")
		   		}
		   	
		   }
		   
		   
	});
	

});

$('#newCommerce').click(function(){
	$('#newCommerceDiv').show();
});

function introNew(obj){
    $('#new_'+obj).show();
    $('#new_element').prop('disabled', true);
    
}

$('form[id=newCommerceForm]').find('input[name="name"]').focusout(function(){
	$('#iconList').empty();
	var search = "https://www.googleapis.com/customsearch/v1?key=AIzaSyAuEqf3JOyr0sLDB4dVJOFHFThIl22BpvQ&cx=011400033356399962413:n4tvoyv9ghi&searchType=image&q="+$(this).val()+"%2Blogo&oq";
	$.ajax({
			method: "GET",
			url: search,			
			error: function(xhr,error){
		   	console.log("error on ajax call: "+xhr);
		   },
		   success:function(response){
		   	
		   		console.log(response.items);
		   		
		   	
		   },
		   complete:function(response){
		   	if(response.responseJSON.items.length>0){
			   		for(var i=0;i<5;i++){

			   			$('#iconList').append('<li class="mdl-menu__item"><img style="height: inherit" src="'+response.responseJSON.items[i].image.thumbnailLink+'"/></li>');
			   		}
			   	}
			   	$('#iconList li').click(function(){
					console.log($(this).find("img").attr("src"));
					$('form[id=newCommerceForm]').find('input[name="logo"]').val($(this).find("img").attr("src"));
					$('#newCommerceHeader').attr("src",$(this).find("img").attr("src"));
				});

		   }
		   
		   
	});
});


$('form[id=newCommerceForm]').submit(function(event){

	event.preventDefault();	
	//AIzaSyAuEqf3JOyr0sLDB4dVJOFHFThIl22BpvQ
	//https://www.googleapis.com/customsearch/v1?key=AIzaSyAuEqf3JOyr0sLDB4dVJOFHFThIl22BpvQ&cx=011400033356399962413:n4tvoyv9ghi&q=simply
	$.ajax({
			method: "POST",
			url: "/newCommerce",
			data: $(this).serialize(),		
			error: function(xhr,error){
		   	console.log("error on ajax call: "+xhr);
		   },
		   success:function(response){
		   	console.log(response);
		   	$('#newCommerceDiv').hide();
		   		$('#newCostForm select[name=commerce]').empty();
		   		$('#newCostForm select[name=commerce]').append(response);
		   }
		   
		   
	});
	

});

