

/**
 * 业主设置今日车位共享时间
 * 业主取消今日共享
 */
	$(".setShareTime").click(function(){
		
		if($(this).val()=="setShareTime"){//当前按钮值value
			
			$(this).parent().siblings("th").each(function(j){//找同类元素th
				switch (j) {
					case 3:{//显示修改密码文本框
						    var is_text = $(this).find("input:datetime-local");//有文本框就获取文本框的值(情况可能格式错误)
						    if(!is_text.length){
						    	$(this).html("<input class='begin' type='datetime-local' value='"+$(this).text()+"' />");
						    }
							 break;
					}
					case 4:{//显示修改手机号/账号文本框
						var is_text = $(this).find("input:datetime-local");//有文本框就获取文本框的值(情况可能格式错误)
					    if(!is_text.length){
					    	$(this).html("<input class='end' type='datetime-local' value='"+$(this).text()+"' />");
					    	//$(this).html("<input type='text' value='"+$(this).text()+"' />");
					    }
							break;	
				    }				
				};
			});
			$(this).val("ensureModify");
			$(this).text("确定 ");
		}//ifmodify	
		else{
			alert("点击确定");
			var orderItem={};//保存表格里的值//获取owner对象
			//alert("准备获取数据");
			normStatus=1;//格式没错
		    $(this).parent().siblings("th").each(function(j){
			      switch (j) {
					case 3:{
						alert("框3");
//						var is_text = $(this).find("input:datetime-local");
//						if(is_text.length){
//							alert("找到");
//						}
						
//						orderItem.shareingBeginTime=is_text.val();	
						var is_text = $(this).find("input");
						alert("找到");
						orderItem.shareingBeginTime=is_text.val();
						alert("获取选择的日期"+orderItem.shareingBeginTime);
						break;
					}
					case 4:{
						var is_text = $(this).find("input");
						  orderItem.shareingEndingTime=is_text.val();
						break;
					}
					case 0:{
						orderItem.parkingSpaceId=$(this).text();//第0个th   id
						break;
					}
				
				};
		    });
		    if(normStatus==0){
		    	alert("请重新输入！");
		    	return;
		    }
		    else{
			    //检查格式没问题后-发送到后台验证
				    
			    alert("发送到后台ing");
			    //ajax
				$.ajax({
			        url: "/setShareTime",     
			        type : "get",
			        dataType : "json",
			        contentType : "application/json; charset=utf-8",  
			        data : {
			        	  'parkingSpaceId':orderItem.parkingSpaceId,
			    		  'shareingBeginTime':orderItem.shareingBeginTime,		
			    		  'shareingEndingTime':orderItem.shareingEndingTime
			        	  },
			        async : true,  
			        success : function(data){    //修改成功  输入框变确定显示--按钮值改为modifyOwner
			        	//提示结果-修改成功-不可修改等
			        	alert(data.msg);
				        //重新找到该节点-有文本框的就保存-前面要有个标记-是否在修改
			        	var isModify=0;//标记是否是该行;
				        $("#tb").find("tr").each(function(){  
				        	isModify=0;//默认不是该行;
		                      $(this).children('th').each(function(j){ 
		                    	  switch (j) {						
										case 3:{
											var is_text = $(this).find("input");//密码单元格下肯定含有文本框
											$(this).html(is_text.val());
											break;
										}
										case 4:{
											var is_text = $(this).find("input");//手机单元格下肯定含有文本框
											if(is_text.length){
												$(this).html(is_text.val());
												isModify=1;
											}
											break;
										}
//										
										case 7:{//修改按钮val
											var mybutton=$(this).find('button');
						                       if(isModify==1){
						                    	   mybutton.val("setShareTime");
						                    	   mybutton.text("设置共享时间 ");		                    	  
						                       };	
										   break;
										}		
		                    	  }			                      
		                      });
		             	 });
			        },  
			        error:function(jqXHR, textStatus, errorThrown) {//controller返回的data空或其他提示不存在
			        	alert("错了？");
			        }
				});
		    }
		}
	});
	
	/**
	 * 管理员-业主
	 * 重设共享时间，ajax 传入车位id,   判断是否有人占位，     成功则局部更新时间框为空
	 */
	$(".resetShareTime").click(function(){
//		if(window.confirm("车位正有人在租，\n\n是否在该乘客离开后，取消今日共享？"))//车位状态为3
	    if(window.confirm("取消共享将会影响收入\n\n确定取消今日共享？"))//车位状态为3
		{	
	    	var orderItem={};//保存表格里的值//获取owner对象
	    	 $(this).parent().siblings("th").each(function(j){
			      switch (j) {
					case 0:{
						orderItem.parkingSpaceId=$(this).text();//第0个th   id
						break;
					}
				
				};
		    });

				$.ajax({
			        url: "/resetShareTime",     
			        type : "get",
			        dataType : "json",
			        contentType : "application/json; charset=utf-8",  
			        data : {
			        	  'parkingSpaceId':orderItem.parkingSpaceId,
			        	  },
			        async : true,  
			        success : function(data){    //修改成功  输入框变确定显示--按钮值改为modifyOwner
			        	//提示结果-修改成功-不可修改等
			        	alert(data.msg);
			        	var id=data.parkingSpaceId;
				        //重新找到该节点-有文本框的就保存-前面要有个标记-是否在修改
				        $("#tb").find("tr").each(function(){  
				        	alert($(this).find("th").first().text());
				        	 if($(this).find("th").first().text()==id){//   if第一个框框的值不是id  return;

		                      $(this).children('th').each(function(j){ 
		                    	  switch (j) {					
//			                    	   case 0:{//清空时间框
////											var pakingid=$(this).text();
//											alert(id);
//											alert($.trim($(this).text()));
//											if($.trim($(this).text())==id){
//												alert("是该行");
//												isModify=1;//是该行
//											}
//											break;
//										}
										case 3:{//清空时间框
											$(this).html(" ");
											break;
										}
										case 4:{//清空时间框
												$(this).html(" ");
							                     
											break;
										}
	
		                    	  }			                      
		                      });
//		                      alert("==:"isModify);
				        	 }
		             	 });
			        },  
			        error:function(jqXHR, textStatus, errorThrown) {//controller返回的data空或其他提示不存在
			        	alert("错了？");
			        }
				});

		}
	});