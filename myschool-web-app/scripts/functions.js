function sayHello2() {
	console.log("this is a message");
	element = document.getElementById("message1");
	element.innerHTML = "New Header....";
	document.getElementById("message2").style.color = "blue";
}

var validateFormData = function(code, name, credit) {
	if (code == null || code == "") {
		alert("Please enter course code");
		return false;
	}
	if (name == null || name == "") {
		alert("Please enter course name");
		return false;
	}
	if (credit == null || credit == "") {
		alert("Please enter course credit");
		return false;
	}

	return true;



}
function displayStudents() {



	let e = document.getElementById("courseList");
	let selectedOption = e.options[e.selectedIndex];
	let courseCode = selectedOption.value;
	axios.get(`http://localhost:8080/courses/${courseCode}/students`)
		.then(res => {
			const sList = res.data;
			printStudents(sList);
		}).catch(function(error) {
			console.log(error);
		});



}
function getInstructors() {

	axios.get("http://localhost:8080/instructors")
		.then(res => {
			const insList = res.data;
			printInstructors(insList);
		})
}

function getCourses(callback) {
	axios.get("http://localhost:8080/courses")
		.then(res => {
			const courseList = res.data;
			callback(courseList);
		})
}
function printInstructors(list) {
	var selectContent;
	for (let i = 0; i < list.length; i++) {
		selectContent += "<option value='" + list[i].id + "'>" + list[i].name + "</option>";
	}
	document.getElementById("instList").innerHTML = selectContent;
}
function printStudents(list){
	var text="<tr><th>No</th><th>Name</th><th>Program</th></tr>";
	for (let i = 0; i < list.length; i++) {
		text += "<tr><td>"+list[i].id+"</td><td>"+list[i].name+"</td><td>"+list[i].program+"</td></tr>";
	}
	
	document.getElementById("studentTable").innerHTML = text;
        
}
function printCourses(list) {
	var selectContent;
	for (let i = 0; i < list.length; i++) {
		selectContent += "<option value='" + list[i].code + "'>" + list[i].code+"-"+list[i].name + "</option>";
	}
	document.getElementById("courseList").innerHTML = selectContent;
}
function printCoursesAsTable(list) {
	var text="<table><tr><th>Code</th><th>Name</th><th>Credit</th></tr>";
	for (let i = 0; i < list.length; i++) {
		text += "<tr><td>"+list[i].code+"</td><td>"+list[i].name+"</td><td>"+list[i].credit+"</td></tr>";
	}
	text+="</table>";
	document.getElementById("courseTable").innerHTML = text;
}
function createCourse() {
	var code = document.getElementById("courseCode").value;
	var name = document.getElementById("name").value;
	var credit = document.getElementById("credit").value;

	var e = document.getElementById("instList");
	var selectedOption = e.options[e.selectedIndex];
	var instructorId = selectedOption.value;
	let validationResult = validateFormData(code, name, credit);
	if (!validationResult)
		return false;

	const course = {
		"code": code,
		"name": name,
		"credit": credit,
		"instructorId": instructorId
	}
	axios.post("http://localhost:8080/courses", course)
		.then(res => {
			const course = res.data;
			document.getElementById("message").innerHTML = "<b style='color:blue'>Course created successfully!!</b>";
			console.log("Course created successfully!!"+course);


		}).catch(function(error) {
			document.getElementById("message").innerHTML = "<b style='color:red'>An error occured!"+error+"</b>";
			
		});
	return false;
}
