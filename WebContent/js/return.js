	       
				function onload_ajax_return(){
					$.ajax({
						type: "post",
						url: "users_equi/return_query",
						dataType: "json", //返回数据类型
						success: function(data){
							sessionStorage.setItem("totalList",JSON.stringify(data.totalList));
							var str=document.getElementById("return_tb").innerHTML;
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
				    		   str+='<td><input type="radio" name="select" value='+i+1+' /></td>';
				   			   str+='</tr>' ;
					    	   }
					    	   console.log("aaa");
					    	   str+='<tr class="navbar-fixed-bottom lead"  style= "background-color:white">  ' ;
					    	   str+='<td style="float: right;"><input type="button" class="btn btn-primary" onclick="equReturnConfirm()" value=归还    /></td>'; 
					    	   str+='</tr>';
					    	   document.getElementById("return_tb").innerHTML=str;
					    	   
						},
					    error: function(data){
						console.log("error");
					}
					}); 
				}
				
				
			

				function equReturnConfirm(){
					var orderListId;
					var i=0
					$("#return_tb tr").each(
									function(){
										if($(this).children("td").eq(7).find("input:radio").prop("checked")){    
											orderListId = $(this).children("td").eq(0).find("input").val();
											i++;
										};})
										
				     var a=is_valid_input(orderListId);
	                 if(a==0){
		                    return false;
	                         }
					
					
					   $("#confirm_tips").text("请输入各器材情况");
					   
					   var totalList=JSON.parse(sessionStorage.getItem("totalList"));
					   var str='';
					   var equId=[];
					   var j=0;
					   str+='<table>';
					   for(var i=0;i<totalList.length;i++){
						   if(totalList[i].orderListId==orderListId){
								   if(i%2==0){
									   str+='<tr>'; 
								   }
								   equId[j]=totalList[i].equId;
								   str+='<td>';
								   str+=totalList[i].equName+"(id:"+totalList[i].equId+")";
								   str+='<td><select id="select'+j+'">  ';
								   str+='<option selected="selected" value="0">完好</option>';
								   str+='<option value="1">损坏</option>' ;
								   str+='<option value="2">遗失</option>'    ;
						           str+='</td></select>'   ;
								   str+='</td>';
								   if(i%2==1||i==totalList.length-1){
									   str+='</tr>'; 
								   }
								   j++;
						   }
					   }
					   sessionStorage.setItem("equId",JSON.stringify(equId));
					   
					   
					   str+='</table>';
					   str+='<table style="margin-top:12px"><tr ><td>备注:</td><td><textarea style="width:400px" id="remark"></textarea></td></tr></table>';
	    			   document.getElementById("confirm_modal_body").innerHTML=str;
	    			   
	    			   //模态框添加按钮
	    			   str1='<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>';
	    			   str1+='<button type="button" class="btn btn-primary" onclick="equReturn('+orderListId+')">确认归还</button>'
	    			   document.getElementById("confirm_model_button").innerHTML=str1;   
	    			   $("#confirm_modal").modal();

				}
				
				function equReturn(orderListId){
					    var equId=JSON.parse(sessionStorage.getItem("equId"));
					    var remark=$("#remark").val();
                        var returnCondition=[];
                        var i=0;
                        for(var i=0;i<equId.length;i++){
                        	returnCondition[i]=$("#select"+i).val();
                        	console.log(returnCondition[i]);
                        }

									
					    var a=is_valid_input(equId);
					    var b=is_valid_input(returnCondition);
					    var c=is_valid_input(orderListId);
					    if(a==0||b==0||c==0){
		                    return false;
	                         }
									
						$.ajax({
							type: "post",
							url:"users_equi/back",
							data: {"orderListId":orderListId,"remark":remark,"equId":equId,"returnCondition":returnCondition}, 
							dataType: "json", //返回数据类型
							traditional: true,
							success: function(data){
								window.parent.location.href ="/equipmentmanager//qcdd/order_list"
							},
							error: function(data){
								console.log("error");
							}
						}
               )
				
				
				
				
				
				}
        
				

