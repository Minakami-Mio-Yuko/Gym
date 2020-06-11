       
			function onload_ajax_update(){
					$.ajax({
						type: "post",
						url: "admin_equi/equ_undelete",
						dataType: "json", //返回数据类型
						success: function(data){

					    	   var str=document.getElementById("update_tr").innerHTML;
					    	   for(var i=0;i<data.list.length;i++){
								   var list=data.list[i];
								   list.brokenCondition=brokenCondition(list.brokenCondition);
				    		   str+='<tr>';
				    	       str+='<td><input name="equId"             type="text"  value='+list.equId+         ' readonly="readonly"/></td>';
				    		   str+='<td><input name="equName"                type="text"  value='+list.equName+              ' readonly="readonly"/></td>';
				    		   str+='<td><select>  '
				    			   if(list.brokenCondition=="完好"){
						    		   str+='<option selected="selected">完好</option>'
							    	   str+='<option>损坏可维护</option>' 
				    			   }else{
						    		   str+='<option >完好</option>'
								       str+='<option selected="selected">损坏可维护</option>'
				    			   }
				               str+='</td></select>'
				    		   str+='<td><input name="reservationPrice"     type="number"  value='+list.reservationPrice+ '  readonly="readonly" /></td>';
				    		   str+='<td><input name="rentPrice"                 type="number"  value='+list.rentPrice+             ' readonly="readonly" /></td>';
				    		   str+='<td><input name="maintenancePrice"                 type="number"  value='+list.maintenancePrice+             ' oninput = "value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,&apos&apos)" onkeypress="if(/\.\d\d{1}$/.test(value))event.returnValue=false" /></td> ';
				    		   str+='<td><input name="buyPrice"                 type="number"  value='+list.buyPrice+            ' oninput = "value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,&apos&apos)" onkeypress="if(/\.\d\d{1}$/.test(value))event.returnValue=false" /></td> ';
				    		   str+='<td><input id="submitBtn2" type="checkbox" onclick="" /></td>';
				    		   str+='</tr>' ;
					    	   }
					    	   str+='<tr>' ;
					    	   str+='<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>'
					    	   str+='<td><input id="submitBtn2" type="button" class="btn btn-primary" onclick="update()" value=修改    /></td>';
					    	   str+='</tr>' ;
					    	   document.getElementById("update_tb").innerHTML=str;
						}
					}); 
				$.ajax({
					type: "post",
					url: "admin_equi/equ_undelete_group",
					dataType: "json", //返回数据类型
					success: function(data){

			    	   var str=document.getElementById("update_group_tr").innerHTML;
			    	   for(var i=0;i<data.list.length;i++){
						   var list=data.list[i];
						   list.brokenCondition=brokenCondition(list.brokenCondition);
		    		   str+='<tr>';
		    		   str+='<td><input name="equName"                type="text"  value='+list.equName+              ' readonly="readonly"/></td>';
		    		   str+='<td><input name="reservationPrice"     type="number"  value='+list.reservationPrice+ '  oninput = "value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,&apos&apos)" onkeypress="if(/\.\d\d{1}$/.test(value))event.returnValue=false" /></td>';
		    		   str+='<td><input name="rentPrice"                 type="number"  value='+list.rentPrice+             ' oninput = "value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,&apos&apos)" onkeypress="if(/\.\d\d{1}$/.test(value))event.returnValue=false" /></td>';
		    		   str+='<td><input name="quantity"                type="text"  value='+list.quantity+              ' readonly="readonly"/></td>';
		    		   str+='<td><input  type="checkbox"  /></td>';
		    		   str+='</tr>' ;
			    	   }
			    	   str+='<tr>' ;
			    	   str+='<td></td><td></td><td></td><td></td>'
			    	   str+='<td><input id="submitBtn2" type="button" class="btn btn-primary" onclick="update_group()" value=修改    /></td>';
			    	   str+='</tr>' ;
			    	   document.getElementById("update_group_tb").innerHTML=str;
				}
			}); 
					
					
			}
		       function update(){
					var equId=[];
					var maintenancePrice=[];
					var buyPrice=[];
					var brokenCondition=[];
					var i=0;
					$("#update_tb tr").each(
									function(){
										if($(this).children("td").eq(7).find("input:checkbox").prop("checked")){    
											equId[i] = $(this).children("td").eq(0).find("input").val();
											if($(this).children("td").eq(2).find("select").val()=="完好"){
												brokenCondition[i] = 0;
											}else{
												brokenCondition[i] = 1;
											}
											maintenancePrice[i] = $(this).children("td").eq(5).find("input").val();
											buyPrice[i] = $(this).children("td").eq(6).find("input").val();
											i++;
										};})
                                       var a=is_valid_input(equId);
	                        	       var b=is_valid_input(maintenancePrice);
	                        	       var c=is_valid_input(buyPrice);
	                        	       if(a==0||b==0||c==0){
						                   return false;
									}
										$.ajax({
											type: "post",
											url:"admin_equi/change",
											data: {"equId":equId,"maintenancePrice":maintenancePrice,"buyPrice":buyPrice,"brokenCondition":brokenCondition}, 
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
		       
		       function update_group(){
					var equName=[];
					var reservationPrice=[];
					var rentPrice=[];
					var i=0;
					$("#update_group_tb tr").each(
									function(){
										if($(this).children("td").eq(4).find("input:checkbox").prop("checked")){    
											equName[i] = $(this).children("td").eq(0).find("input").val();
											reservationPrice[i] = $(this).children("td").eq(1).find("input").val();
											rentPrice[i] = $(this).children("td").eq(2).find("input").val();
											i++;
										};})
                                       var a=is_valid_input(equName);
	                          	       var b=is_valid_input(reservationPrice);
	                    	           var c=is_valid_input(rentPrice);
	                        	       if(a==0||b==0||c==0){
						                   return false;
									}
	                            	is_valid_input(equName);
	                            	is_valid_input(reservationPrice);
	                            	is_valid_input(rentPrice);
										$.ajax({
											type: "post",
											url:"admin_equi/equ_update_group",
											data: {"equName":equName,"reservationPrice":reservationPrice,"rentPrice":rentPrice}, 
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

        
