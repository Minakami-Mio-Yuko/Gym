	       
				function onload_ajax_rent(){
					$.ajax({
						type: "post",
						url: "users_equi/rent_query",
						dataType: "json", //返回数据类型
						success: function(data){
							var str=document.getElementById("rent_tb").innerHTML;
					    	   for(var i=0;i<data.list.length;i++){
								   var list=data.list[i];
							
				    		   str+='<tr>';
				    	       str+='<td><input name="orderListId"             type="text"  value='+list.orderListId+         ' readonly="readonly"/></td>';
				    		   str+='<td><input name="equName"          type="text"  value='+data.equList[i+1]+      ' readonly="readonly"/></td>';
				    		   str+='<td><input name="resDeposit"                 type="text"  value='+list.resDeposit+             ' readonly="readonly"/></td> ';
				    		   str+='<td><input name="resTime"                 type="text"  value='+list.resTime+            ' readonly="readonly"/></td> ';
				    		   str+='<td><input name="rentTotalPrice"          type="text"  value='+list.rentTotalPrice+      ' readonly="readonly"/></td>';
				    		   str+='<td><input name="rentTime"                 type="text"  value='+list.rentTime+             ' readonly="readonly"/></td> ';
				    		   str+='<td><input name="returnDate"                 type="text"  value='+list.returnDate+            ' readonly="readonly"/></td> ';
				    		   str+='<td><input type="checkbox" onclick="count_money()" /></td>';
				   			   str+='</tr>' ;
					    	   }
					    	   console.log("aaa");
					    	   str+='<tr class="navbar-fixed-bottom lead"  style= "background-color:white">  ' ;
					    	   str+='<td style="float: right;"><input type="button" class="btn btn-primary" onclick="rent()" value=租用    /></td>'; 
					    	   str+='<td style="float: right;">总租金 :  <input id="rent_total_price" type="text" value="0" style= "background-color:transparent;border:0; width:100px" readonly="readonly"/>元</td>';
					    	   document.getElementById("rent_tb").innerHTML=str;
					    	   
						},
					    error: function(data){
						console.log("error");
					}
					}); 
				}
				
				
			

				function rent(){
					var rentTotalPrice=parseFloat($("#rent_total_price").val());
					var orderListId=[];
					var i=0
					$("#rent_tb tr").each(
									function(){
										if($(this).children("td").eq(7).find("input:checkbox").prop("checked")){    
											orderListId[i] = $(this).children("td").eq(0).find("input").val();
											i++;
										};})
										var a=is_valid_input(orderListId);
			                        		if(a==0){
		                                            return false;
					                         }
										$.ajax({
											type: "post",
											url:"users_equi/lend",
											data: {"orderListId":orderListId}, 
											dataType: "json", //返回数据类型
											traditional: true,
											success: function(data){
												window.parent.location.href ="/equipmentmanager//qcdd/order_list"
											},
											error: function(data){
												console.log("error");
											}
										});
				}
        
				function count_money(){
					var rent_price=0;
					var rent_total_price=0;
					$("#rent_tb tr").each(
							function(){
								if($(this).children("td").eq(7).find("input:checkbox").prop("checked")){   
									//租金
									rent_price=parseFloat($(this).children("td").eq(4).find("input").val());
									rent_total_price=rent_total_price+rent_price;
								};})
					$("#rent_total_price").val(rent_total_price);
				}
				

