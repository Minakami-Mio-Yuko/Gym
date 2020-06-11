				function onload_ajax_order(){
					var url=document.getElementById("form").name;
					var condition;
					$.ajax({
						type: "post",
						url: url,
						dataType: "json", //返回数据类型
						success: function(data){
					    	   var str=document.getElementById("order_tb").innerHTML;
					    	   for(var i=0;i<data.list.length;i++){
								   var list=data.list[i];
								   lcondition=orderCondition(list.orderCondition);
				    		   str+='<tr>';
				    	       str+='<td><input name="orderListId"             type="text"  value='+list.orderListId+         ' readonly="readonly"/></td>';
				    		   str+='<td><input name="equName"                type="text"  value='+data.equList[i+1]+              ' readonly="readonly"/></td>';
				    		   str+='<td><input name="resDeposit"          type="text"  value='+list.resDeposit+      ' readonly="readonly"/></td>';
				    		   str+='<td><input name="resTime"                 type="text"  value='+list.resTime+             ' readonly="readonly"/></td> ';
				    		   str+='<td><input name="rentTotalPrice"                 type="text"  value='+list.rentTotalPrice+            ' readonly="readonly"/></td> ';
				    		   str+='<td><input name="rentTime"             type="text"  value='+list.rentTime+         ' readonly="readonly"/></td>';
				    		   str+='<td><input name="returnDate"             type="text"  value='+list.returnDate+         ' readonly="readonly"/></td>';
				    		   str+='<td><input name="orderCondition"             type="text"  value='+lcondition+         ' readonly="readonly"/></td>';
				    		   if(list.orderCondition==0){
					    		   str+='<td><input type="checkbox" onclick="count_total()" /></td>';	   
				    		   }

				   			   str+='</tr>' ;
					    	   }
					    	   
					    	   str+='<tr class="navbar-fixed-bottom lead"  style= "background-color:white">  ' ;
					    	   str+='<td style="float: right;"><input type="button" class="btn btn-primary" onclick="order_unsubscribe()" value=退订   /></td>';
					    	   str+='<td style="float: right;"><textarea id="remark" style="height:35px" placeholder="请输入退订原因"></textarea></td></tr>'
					    	   console.log("aaa");
					    	   document.getElementById("order_tb").innerHTML=str;
						},
					    error: function(data){
						console.log("error");
					}
				});	
				}


				
				function order_unsubscribe(){
					var orderListId=[];
					var remark=$("#remark").val();
					var i=0
					$("#order_tb tr").each(
									function(){
										if($(this).children("td").eq(8).find("input:checkbox").prop("checked")){    
											orderListId[i] = $(this).children("td").eq(0).find("input").val();
											i++;
										};})
										var a=is_valid_input(orderListId);
					                    var b=is_valid_input(remark);
										if(a==0||b==0){
							                   return false;
										}
										$.ajax({
											type: "post",
											url:"users_equi/order_unsubscribe",
											data: {"orderListId":orderListId,"remark":remark}, 
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
				

