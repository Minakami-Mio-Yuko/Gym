       function is_valid_input(data){
    	   if(data==null||data.length==0){
    			   $("#tips").text("输入/操作不合法");
    			   $("#tips_content").text("请认真检查是否还有没有输入的数据或数据/操作是否合法");		   
    			     $("#mymodal").modal();
        	return false;
    	   }
    	   return true;
       }
       function success_output(){
    			   $("#tips").text("操作成功");
    			   $("#tips_content").text("操作成功");
    			     $("#mymodal").modal();
       }

       function ajax(){
			var data = $("#form").serialize();
            if (/=(&|$)/.test(data)) {
            	$("#tips").text("输入不合法");
            	$("#tips_content").text("请认真检查是否还有没有输入的数据或数据/操作是否合法");
            	 $("#mymodal").modal("toggle");
            	return false;
            	}
			var url=document.getElementById("form").name;
			
			
			
			
			$.ajax({
				type: "post",
				url: url,
				data: data, 
				dataType: "json", //返回数据类型
				success: function(data){
					success_output();
				},
				error: function(data){
					console.log("error");
				}
				
			}); 
		};
	
		function orderCondition(a){
		           if(a==0){
			           	var b="预约审核中";
			           	return b;
			           }
		           if(a==1){
			           	var b="已预约";
			           	return b;
			           }
		           if(a==2){
			           	var b="租用审核中";
			           	return b;
			           }
		           if(a==3){
			           	var b="已租用";
			           	return b;
			           }
		           if(a==4){
			           	var b="归还审核中";
			           	return b;
			           }
		           if(a==5){
			           	var b="已归还";
			           	return b;
			           }
		           if(a==6){
			           	var b="退订审核中";
			           	return b;
			           }
		           if(a==7){
			           	var b="已退订";
			           	return b;
			           }
		        }		       

        function brokenCondition(a){
	           if(a==0){
		           	var b="完好";
		           	return b;
		           }
	           if(a==1){
		           	var b="损坏可维护";
		           	return b;
		           }
	           if(a==2){
		           	var b="已移除";
		           	return b;
		           }
	           if(a==3){
		           	var b="正在维护";
		           	return b;
		           }
	        }
        
        
