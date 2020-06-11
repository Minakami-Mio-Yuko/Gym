
		function onload_ajax_delete(){
				   var url=document.getElementById("form").name;
				   all_list(url,"undelete_tb","删除","undelete_tr");  
				   var url1=document.getElementById("form1").name;
				   all_list(url1,"undelete_tb1","撤消删除","undelete_tr1");
			}
		
		function all_list(url,HTML_insert_location,button_name,list_name){
			$.ajax({
				type: "post",
				url: url,
				dataType: "json", //返回数据类型
				success: function(data){

			    	   var str=document.getElementById(list_name).innerHTML;
			    	   for(var i=0;i<data.list.length;i++){
						   var list=data.list[i];	
						   list.brokenCondition=brokenCondition(list.brokenCondition);
					
		    		   str+='<tr>';
		    	       str+='<td><input name="equId"             type="text"  value='+list.equId+         ' readonly="readonly"/></td>';
		    		   str+='<td><input name="equName"                type="text"  value='+list.equName+              ' readonly="readonly"/></td>';
		    		   str+='<td><input name="brokenCondition"          type="text"  value='+list.brokenCondition+      ' readonly="readonly"/></td>';
		    		   str+='<td><input name="reservationPrice"     type="text"  value='+list.reservationPrice+ ' readonly="readonly"/></td>';
		    		   str+='<td><input name="rentPrice"                 type="text"  value='+list.rentPrice+             ' readonly="readonly"/></td>';
		    		   str+='<td><input name="maintenancePrice"                 type="text"  value='+list.maintenancePrice+             ' readonly="readonly"/></td> ';
		    		   str+='<td><input name="buyPrice"                 type="text"  value='+list.buyPrice+            ' readonly="readonly"/></td> ';
		    		   str+='<td><input id="submitBtn2" type="checkbox" onclick="" /></td>';
/*			    		   str+='<td><input id="submitBtn2" type="button" onclick="" value='+'编辑或删除'+   ' /></td>';*/
		   			   str+='</tr>' ;
			    	   }
			    	   str+='<tr>' ;
			    	   str+='<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>'
			    	   str+='<td><input id="submitBtn2" type="button" class="btn btn-primary" onclick="delete_list(&apos;'+HTML_insert_location+'&apos;)" value='+button_name+'    /></td>';
			    	   str+='</tr>' ;
			    	   document.getElementById(HTML_insert_location).innerHTML=str;
				}
			}); 
		}
 
	       
	       
	       function delete_list(delete_tb){
			var equId=[];
			var i=0;
			console.log("#"+delete_tb+" tr");
			$("#"+delete_tb+" tr").each(
							function(){
								if($(this).children("td").eq(7).find("input:checkbox").prop("checked")){
                                    
									equId[i] = $(this).children("td").eq(0).find("input").val();
									i++;
								};})
								console.log(equId);
								var a=is_valid_input(equId);
								if(a==0){
					                   return false;
								}
								$.ajax({
									type: "post",
									url:"admin_equi/delete",
									data: {"equId":equId,"choseType":delete_tb}, 
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
	       
	       
			