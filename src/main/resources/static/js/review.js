
function allReviews() {

var city=$('#ccity').val();
var name=$('#cname').val();
localStorage.setItem("city",city);
localStorage.setItem("name",name);
  window.location.href='http://127.0.0.1:8082/reviewsdata.html';
 //window.open('http://127.0.0.1:8082/reviewsdata.html');
 $(".reviewhome")[0].reset();        					
}
	
	


// function reviewsdata(){
// 	localStorage.clear();
// }

function allCoachings(){

var city=$('#mycitysearch').val();
var type=$('#type :selected').text(); 
localStorage.setItem("city",city);
localStorage.setItem("type",type);
 window.location.href='http://127.0.0.1:8082/detaildata.html';
// window.open('http://127.0.0.1:8082/detaildata.html');
 $("#coachingsearch")[0].reset();   

}

function sendMail(){
    
    
    var to=localStorage.getItem("to");
    console.log(to);
    var url="http://127.0.0.1:8082/sendMail/chakresh@acis.io";
    var obj={
        "name":$('#name').val(),
        "from":$('#email').val(),
        "mno":$('#phnno').val(),
        "query":$('#query').val()    
    }
    console.log(obj);
    $.ajax({
            url :url,
            type : "POST",
            contentType: 'application/json; charset=utf-8',
            //dataType: 'text json',
            data: JSON.stringify(obj),
            success : function(data) {
                console.log("success");
                alert("Information Submittedt Thank You !");

        },
			error : function(jqXHR, textStatus, errorThrown) {
                alert("Information Submittedt Thank You !");
				console.log(' Error in processing! ' + textStatus);
			}
        });
            
		//https://myaccount.google.com/lesssecureapps	
    localStorage.clear();
    $("#contactusform")[0].reset();
  }
