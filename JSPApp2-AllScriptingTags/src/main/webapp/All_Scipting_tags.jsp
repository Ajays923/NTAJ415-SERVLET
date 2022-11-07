<%!
		public String generateWishMessage(String user){
		// get system date and time
		java.time.LocalDateTime ltd = java.time.LocalDateTime.now();
		// get system hour
		int hour = ltd.getHour();
		// generate wish message
		if(hour<12)
			return "Good Morning: "+user;
		else if(hour<16)
			return "Good Afternoon: "+user;
		else if(hour<20)
			return "Good Evening: "+user;
		else 
			return "Good Night : "+user;
		}

%>

<h1 style="color:red;text-align:center">Welcome to Java Server Pages</h1>
<br><br>
<h1><b style="color:green">Date and Time is :: <%=new java.util.Date() %> </b>
</h1><br><br>
<% String name = "Ajay"; %>
<b>Wish Message is :: <%=generateWishMessage(name) %></b>