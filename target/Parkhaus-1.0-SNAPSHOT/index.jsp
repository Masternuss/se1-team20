<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<body>

<br>
<h1>Tomcat Parkhaus 9.1.9</h1>
<br/>

<script src='https://ccmjs.github.io/mkaul-components/parkhaus/versions/ccm.parkhaus-9.1.9.js'>

</script><ccm-parkhaus-9-1-9
        key='{
		    "name":"CarHome",
		    "server_url":"http://localhost:8080/Parkhaus_war_exploded/ParkhausServlet",
		    "extra_buttons":[
			    {
				    "extra_class":"total_revenue",
				    "extra_inner":"Total Revenue",
				    "extra_popup_title":"Total revenue"
			    },
			    {
				    "extra_class":"average_revenue",
				    "extra_inner":"Average Revenue",
				    "extra_popup_title":"Average revenue per car"
			    },
			    {
			        "extra_class":"total_cars",
				    "extra_inner":"Total Cars",
				    "extra_popup_title":"How many cars visited the Parkhaus"
				},
				{
				    "extra_class":"get_bill",
				    "extra_inner":"Your Bill",
				    "extra_popup":"Show hwo much you have to pay"
				}
		    ],
		    "extra_charts":[
		    ]
	    }
'>
</ccm-parkhaus-9-1-9>

</body>
</html>