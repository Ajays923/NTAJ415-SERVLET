 
 function validate(frm) {
		// empty the form validations msg
		document.getElementById("pnameErr").innerHTML="";
		document.getElementById("paddrsErr").innerHTML="";
		document.getElementById("pageErr").innerHTML="";
		// read form data
		let name = frm.pname.value;
		let addrs = frm.paddrs.value;
		let age= frm.page.value;
		// client side validation
		let flag=true;
		if(name==""){ // required rules on name
			/* alert("Person Name is required"); */
			document.getElementById("pnameErr").innerHTML="Person Name is required";
			frm.pname.focus();
			flag = false;
		} 
		else if(addrs==""){ // required rules on addrs
			//alert("Person Addrs is required");
			document.getElementById("paddrsErr").innerHTML="Person Addrs is required";
			frm.paddrs.focus();	
			flag = false;
		}
		else if(addrs.length<10){
		//	alert("Person Addrs minimum of 10 character required");
			document.getElementById("paddrsErr").innerHTML="Person Addrs minimum of 10 character required";
			frm.paddrs.focus(); // makes text box gaining the focus
			flag = false;
		}
		
		if(age==""){
			//alert("Person age is required");
			document.getElementById("pageErr").innerHTML="Person Age is required";
			frm.page.focus();
			flag = false;
		}
		else if(isNaN(age)){
			//alert("Person age must be Numberic value");
			document.getElementById("pageErr").innerHTML="Person Age is Numberic value";
			frm.page.focus();
			flag = false;
		}
		else if(age<=0 || age > 125){
			//alert("Person age must be there 1 through 125");
			document.getElementById("pageErr").innerHTML="Person age must be there 1 through 125";
			frm.page.focus();
			flag = false;
		}
		//change hidden box value(vflag) to "yes" indicating client side for validations are done
		frm.vflag.value="yes";
		return flag;	
	}// function