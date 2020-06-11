	       
		       
				function onload_ajax_approval(){
					   var url=document.getElementById("form").name;   
					   var url1=document.getElementById("form1").name; 
					   var url2=document.getElementById("form2").name; 
					   var url3=document.getElementById("form3").name; 
					   var url4=document.getElementById("form4").name; 
					   
					   ajax_approval(url,"res_approval_tb","通过预约审批");
					   ajax_approval(url1,"rent_approval_tb","通过租用审批");
					   ajax_approval(url2,"return_approval_tb","通过归还审批");
					   ajax_approval(url3,"unsubscribe_approval_tb","通过退订审批");
					   ajax_approval(url4,"all_order_tb","查看");
				}
				
				
				function ajax_approval(url,table_name,button_name){
					url0="admin_equi/"+url;
					$.ajax({
						type: "post",
						url: url0,
						dataType: "json", //返回数据类型
						success: function(data){
					    	   var str=document.getElementById(table_name).innerHTML;
					    	   for(var i=0;i<data.list.length;i++){
								   var list=data.list[i];
							
				    		   str+='<tr>';
				    	       str+='<td><input name="orderListId"             type="text"  value='+list.orderListId+         ' readonly="readonly"/></td>';
				    		   str+='<td><input name="userId"                type="text"  value='+list.userId+              ' readonly="readonly"/></td>';
				    		   str+='<td><input name="equName"          type="text"  value='+data.equList[i+1]+      ' readonly="readonly"/></td>';
				    		   str+='<td><input name="resDeposit"                 type="text"  value='+list.resDeposit+             ' readonly="readonly"/></td> ';
				    		   str+='<td><input name="resTime"                 type="text"  value='+list.resTime+            ' readonly="readonly"/></td> ';
				    		   str+='<td><input name="rentTotalPrice"          type="text"  value='+list.rentTotalPrice+      ' readonly="readonly"/></td>';
				    		   str+='<td><input name="rentTime"                 type="text"  value='+list.rentTime+             ' readonly="readonly"/></td> ';
				    		   str+='<td><input name="returnDate"                 type="text"  value='+list.returnDate+            ' readonly="readonly"/></td> ';
				    		   str+='<td><input type="checkbox" /></td>';
				   			   str+='</tr>' ;
					    	   }
					    	   if(url!="all_order"){
					    		   str+='<tr>' ;
						    	   str+='<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>'
						    	   str+='<td><input id="submitBtn" type="button" class="btn btn-primary" onclick="equ_approval(&apos;'+url+'&apos;)" value='+button_name+'  /></td>';
						    	   str+='</tr>' ; 
					    	   }
					    	   
					    	   document.getElementById(table_name).innerHTML=str;
						},
					    error: function(data){
						console.log("error");
					}
					}); 
				}
		
        
				
				function equ_approval(sign){
					var orderListId=[];
					var i=0
					url="admin_equi/"+"equ_"+sign;

					$("#"+sign+"_tb tr").each(
									function(){
										if($(this).children("td").eq(8).find("input:checkbox").prop("checked")){    
											orderListId[i] = $(this).children("td").eq(0).find("input").val();
											i++;
										};})
										var a=is_valid_input(orderListId);
					                  if(a==0){
						                   return false;
					                            }
					  					$.ajax({
											type: "post",
											url:url,
											data: {"orderListId":orderListId}, 
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
