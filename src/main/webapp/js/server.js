/**
 * 
 * 
 */
function serve(){
	$.ajax({
		type:"POST",
		dataType:"JSON",
		url: 'QServlet',
		data:{
			"method":"getbase",
		},
		success: function(r){ 
			//console.log(r.length);
			var table=document.getElementById("table");
			for(var i=0;i<r.length;i++ ){
				var tr=document.createElement("tr");
				var td1=document.createElement("td");
				td1.innerHTML=r[i].id;
				var td2=document.createElement("td");
				td2.innerHTML=r[i].content;
				tr.appendChild(td1);
				tr.appendChild(td2);
				table.appendChild(tr);
			}
			//var classVal=document.getElementById("id").getAttribute("class");
			//var tr=document.createElement("tr");
			//for(var i=0;i<r.rengongzhineng.length;i++){
//			var li=document.createElement("li");
//			ul.appendChild(li);
//			var a=document.createElement("a");
//			a.setAttribute("class", "slide-item");
//			
//			li.appendChild(a);
//			var span=document.createElement("span");
//			span.innerHTML=r.rengongzhineng[i];
//			a.appendChild(span);
//			a.setAttribute("href", encodeURI("Servlet/SearchServlet?key="+span.innerHTML+""));
	//		}
				}
		}
	);
}