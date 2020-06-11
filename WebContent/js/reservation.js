  
		       
				function ajax_reservation_query(){
					   var date=$("#date").val();   
					   var time=$("#time").val(); 
					   sessionStorage.setItem("date",date);
					   sessionStorage.setItem("time",time);
					   var a=is_valid_input(date);
					   var b=is_valid_input(time);
					   if(a==0||b==0){
						   return false;
					   }
					$.ajax({
						type: "post",
						url: "users_equi/res_query",
						data:{"date":date,"time":time},
						dataType: "json", //返回数据类型
						success: function(data){
					    	   var str='<tr id="reservation_tr">';
                                str+=document.getElementById("reservation_tr").innerHTML
                                str+='</tr>'
					    	   for(var i=0;i<data.list.length;i++){
								   var list=data.list[i];	
				    		   str+='<tr>';
				    	       str+='<td><input name="equName"             type="text"  value='+list.equName+         ' readonly="readonly"/></td>';
				    		   str+='<td><input name="reservationPrice"                type="text"  value='+list.reservationPrice+              ' readonly="readonly"/></td>';
				    		   str+='<td><input name="rentPrice"          type="text"  value='+list.rentPrice+      ' readonly="readonly"/></td>';
				    		   str+='<td><input name="maintenancePrice"                 type="text"  value='+list.maintenancePrice+             ' readonly="readonly"/></td> ';
				    		   str+='<td><input name="buyPrice"                 type="text"  value='+list.buyPrice+            ' readonly="readonly"/></td> ';
				    		   str+='<td><input name="remainderQuantity"                 type="text"  value='+list.quantity+            ' readonly="readonly"/></td> ';
				    		   str+='<td><input name="resQuantity" oninput = "value=value.replace(/[^\\d]/g,&apos;&apos;);count_money()" type="number" min="0"  max='+list.quantity+' value="0"/></td> ';
				    		   str+='<td><input type="checkbox" onclick="count_money()" /></td>';
				   			   str+='</tr>' ;
					    	   }
					    	   str+='<tr class="navbar-fixed-bottom lead"  style= "background-color:white">  ' ;
					    	   str+='<td style="float: right;"><input type="button" class="btn btn-primary" onclick="reservation()" value=预约    /></td>'; 
					    	   str+='<td style="float: right;">总押金 :  <input id="count_deposit" type="text" value="0" style= "background-color:transparent;border:0; width:100px" readonly="readonly"/>元</td>';
					    	   str+='<td style="float: right;">总租金 :  <input id="rent_total_price" type="text" value="0" style= "background-color:transparent;border:0; width:100px" readonly="readonly"/>元</td>';
					    	   document.getElementById("reservation_tb").innerHTML=str;
					    	   
						},
					    error: function(data){
						console.log("error");
					}
					}); 
				}
				
				
				function onload_ajax_reservation(){
					var url=document.getElementById("form1").name;
					$.ajax({
						type: "post",
						url: url,
						dataType: "json", //返回数据类型
						success: function(data){
					    	   var str=document.getElementById("reservation_tb").innerHTML;
					    	   for(var i=0;i<data.list.length;i++){
								   var list=data.list[i];
							
				    		   str+='<tr>';
				    	       str+='<td><input name="orderListId"             type="text"  value='+list.orderListId+         ' readonly="readonly"/></td>';
				    		   str+='<td><input name="equName"                type="text"  value='+data.equName[i+1]+              ' readonly="readonly"/></td>';
				    		   str+='<td><input name="resDeposit"          type="text"  value='+list.resDeposit+      ' readonly="readonly"/></td>';
				    		   str+='<td><input name="resTime"                 type="text"  value='+list.resTime+             ' readonly="readonly"/></td> ';
				    		   str+='<td><input name="rentTotalPrice"                 type="text"  value='+list.rentTotalPrice+            ' readonly="readonly"/></td> ';
				    		   str+='<td><input name="rentTime"             type="text"  value='+list.rentTime+         ' readonly="readonly"/></td>';
				    		   str+='<td><input name="returnDate"             type="text"  value='+list.returnDate+         ' readonly="readonly"/></td>';
				    		   str+='<td><input name="orderCondition"             type="text"  value='+list.orderCondition+         ' readonly="readonly"/></td>';
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
			

				function reservation(){
					var date=sessionStorage.getItem("date");   
					var time=sessionStorage.getItem("time"); 
					var equName=[];
					var quantity=[];
					var resCost=parseFloat($("#count_deposit").val());
					var rentTotalPrice=parseFloat($("#rent_total_price").val());
					
					var i=0
					console.log(resCost);
					$("#reservation_tb tr").each(
									function(){
										if($(this).children("td").eq(7).find("input:checkbox").prop("checked")){    
											equName[i] = $(this).children("td").eq(0).find("input").val();
											quantity[i]=$(this).children("td").eq(6).find("input").val();
											i++;
										};})
										
										is_valid_input(quantity);
										$.ajax({
											type: "post",
											url:"users_equi/book",
											data: {"equName":equName,"resCost":resCost,"quantity":quantity,"date":date,"time":time,"rentTotalPrice":rentTotalPrice}, 
											dataType: "json", //返回数据类型
											traditional: true,
											success: function(data){
												if(data.msg=="success"){
													window.parent.location.href ="/equipmentmanager//qcdd/order_list"	
												}else{
									    			   $("#tips").text("错误");
									    			   $("#tips_content").text("预约失败，请刷新页面重试");		   
									    			   $("#mymodal").modal();
												}    
											},
											error: function(data){
												console.log("error");
											}
										});
				}
        
				function count_money(){
					var deposit=0;
					var quantity=0;
					var count_deposit=0;
					var rent_price=0;
					var rent_total_price=0;
					$("#reservation_tb tr").each(
							function(){
								if($(this).children("td").eq(7).find("input:checkbox").prop("checked")){   
									//押金
									deposit=$(this).children("td").eq(1).find("input").val();
									quantity=$(this).children("td").eq(6).find("input").val();
									count_deposit=count_deposit+deposit*quantity;
									//租金
									rent_price=$(this).children("td").eq(2).find("input").val();
									rent_total_price=rent_total_price+rent_price*quantity;
								};})
					$("#count_deposit").val(count_deposit);
					$("#rent_total_price").val(rent_total_price);
				}
				

