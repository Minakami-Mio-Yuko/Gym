       
				function onload_ajax_maintenance(){
					   var url=document.getElementById("form").name;   
					$.ajax({
						type: "post",
						url: url,
						dataType: "json", //返回数据类型
						success: function(data){
					    	   var str=document.getElementById("maintenance_tb").innerHTML;
					    	   for(var i=0;i<data.list.length;i++){
								   var list=data.list[i];
								   list.brokenCondition=brokenCondition(list.brokenCondition);
							
				    		   str+='<tr>';
				    	       str+='<td><input name="equId"             type="text"  value='+list.equId+         ' readonly="readonly"/></td>';
				    		   str+='<td><input name="equName"                type="text"  value='+list.equName+              ' readonly="readonly"/></td>';
				    		   str+='<td><input name="brokenCondition"          type="text"  value='+list.brokenCondition+      ' readonly="readonly"/></td>';
				    		   str+='<td><input name="maintenancePrice"                 type="text"  value='+list.maintenancePrice+             ' readonly="readonly"/></td> ';
				    		   str+='<td><input name="buyPrice"                 type="text"  value='+list.buyPrice+            ' readonly="readonly"/></td> ';
				    		   str+='<td><input type="checkbox" onclick="count_total()" /></td>';
				   			   str+='</tr>' ;
					    	   }
					    	   console.log("aaa");
					    	   str+='<tr class="navbar-fixed-bottom lead"  style= "background-color:white">  ' ;
					    	   str+='<td style="float: left;"><input type="button" class="btn btn-primary" onclick="maintenance_complete()" value=完成维护    /></td>';
					    	   str+='<td style="float: right;"><input type="button" class="btn btn-primary" onclick="maintenance()" value=生成维护单    /></td>';
					    	   str+='<td style="float: right;">总价格 :  <input id="count" type="text" value="   0   元" style= "background-color:transparent;border:0; width:100px" readonly="readonly"/></td>';
					    	   str+='<td style="float: right;"><textarea id="mai_reason" style="height:35px" placeholder="请输入维护原因"></textarea></td></tr>'
					    	   document.getElementById("maintenance_tb").innerHTML=str;
						},
					    error: function(data){
						console.log("error");
					}
					}); 
					
					var url=document.getElementById("form1").name;
					$.ajax({
						type: "post",
						url: url,
						dataType: "json", //返回数据类型
						success: function(data){
					    	   var str=document.getElementById("maintenancing_tb").innerHTML;
					    	   for(var i=0;i<data.list.length;i++){
								   var list=data.list[i];
								   list.brokenCondition=brokenCondition(list.brokenCondition);
							
				    		   str+='<tr>';
				    	       str+='<td><input name="maiId"             type="text"  value='+list.maiId+         ' readonly="readonly"/></td>';
				    		   str+='<td><input name="equName"                type="text"  value='+data.equList[i+1]+              ' readonly="readonly"/></td>';
				    		   str+='<td><input name="maiCost"          type="text"  value='+list.maiCost+      ' readonly="readonly"/></td>';
				    		   str+='<td><input name="maiStartDate"                 type="text"  value='+list.maiStartDate+             ' readonly="readonly"/></td> ';
				    		   str+='<td><input name="maintenanceReason"                 type="text"  value='+list.maintenanceReason+            ' readonly="readonly"/></td> ';
				    		   str+='<td><input name="approverId"             type="text"  value='+list.approverId+         ' readonly="readonly"/></td>';
				    		   str+='<td><input type="checkbox" onclick="count_total()" /></td>';
				   			   str+='</tr>' ;
					    	   }
					    	   console.log("aaa");
					    	   document.getElementById("maintenancing_tb").innerHTML=str;
						},
					    error: function(data){
						console.log("error");
					}
				});	
				}
				

				
				function count_total(){
					var count=0;
					$("#maintenance_tb tr").each(
							function(){
								if($(this).children("td").eq(5).find("input:checkbox").prop("checked")){    
									count=count+parseInt($(this).children("td").eq(3).find("input").val());
								};})
					$("#count").val("   "+count+"   元");
					
				}

				function maintenance(){
					var equId=[];
					var maiCost=parseInt($("#count").val());
					var maintenanceReason=$("#mai_reason").val();
					var i=0
					console.log();
					$("#maintenance_tb tr").each(
									function(){
										if($(this).children("td").eq(5).find("input:checkbox").prop("checked")){    
											equId[i] = $(this).children("td").eq(0).find("input").val();
											i++;
										};})
										var a=is_valid_input(maintenanceReason);
					                    var b=is_valid_input(equId);
					                    if(a==0||b==0){
							                   return false;
										}
										$.ajax({
											type: "post",
											url:"admin_equi/fix",
											data: {"equId":equId,"maiCost":maiCost,"maintenanceReason":maintenanceReason}, 
											dataType: "json", //返回数据类型
											traditional: true,
											success: function(data){
												success_output();
												window.location.reload();
											},
											error: function(data){
												console.log("error");
											}
										});
				}
        
				
				function maintenance_complete(){
					var maiId=[];
					var i=0
					console.log();
					$("#maintenancing_tb tr").each(
									function(){
										if($(this).children("td").eq(6).find("input:checkbox").prop("checked")){    
											maiId[i] = $(this).children("td").eq(0).find("input").val();
											i++;
										};})
										var a=is_valid_input(maiId);
                                            if(a==0){
		                                           return false;
					                                }
										$.ajax({
											type: "post",
											url:"admin_equi/maintenancing_complete",
											data: {"maiId":maiId}, 
											dataType: "json", //返回数据类型
											traditional: true,
											success: function(data){
												window.location.reload();
											},
											error: function(data){
												console.log("error");
											}
										});
				}
