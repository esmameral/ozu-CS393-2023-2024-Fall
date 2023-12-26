function sayHello2() {
    console.log("this is a message");
    element = document.getElementById("message1");
    element.innerHTML = "New Header....";
    document.getElementById("message2").style.color = "blue";
}

var validate = function(){
    var courseCode=document.getElementById("courseCode").value;
   
  

   
}

function printInstructors(){
    var insList =[
        {"id":"123","name":"Ali Sozer","office":"781"},
        {"id":"567","name":"Olcay Yildiz","office":"871"},
        {"id":"981","name":"Reyhan Kara","office":"654"}
    ]

    var selectContent;
    for(let i=0;i<insList.length;i++){
        selectContent+="<option value='"+i+"'>"+insList[i].name+"</option>";
    }
   
    document.getElementById("instList").innerHTML=selectContent;
      

}
