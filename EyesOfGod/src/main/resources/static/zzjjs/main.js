/**
 *----162021班第10组----
 * 小区物业管理系统-车位管理模块-业主管理模块
 * @author:16202132-周张俊 
 * date:2019-5-28
 * 主要功能说明：
 * 包含三个页面需要的js文件：
 * 1.保安登录首页：
 *   实现功能：使用jquery 局部更新；
 *          分页展示；
 *          变更div格式；
 *          展示隐藏信息：如鼠标停在车位图上展示车位信息。
 *          ......
 * 2.业主登录首页
 *   实现功能：
 *         ......
 * 3.业主页面
 *   实现功能：增删查改的局部更新
 *         ......
 * 4.车位管理页面
 *   实现功能：增删查改的局部更新
 *         ......        
 */
$(document).ready(function(){

	function add(){
		alert("add来了");//显示结果
		var orderItem={};//保存表格里的值//获取owner对象
		orderItem.ownerId=parseInt($("#ownerId").val());
		orderItem.houseId=parseInt($("#houseId").val());
		//都存在插入
		alert(orderItem.ownerId+"   "+orderItem.houseId);//显示结果
		$.ajax({
			url: "/addOwnerHouse",    
	        type : "get",
	        dataType : "json",
	        contentType : "application/json; charset=utf-8",  
	        data : {
	    		  'ownerId':orderItem.ownerId,	
	    		  'houseId':orderItem.houseId,
	        	  },
	        async : true,  
		}).then(function(data) { 
	    	alert(data.msg);//显示结果

	    });
	};
	
	
//	//判断房屋是否存在
	function isExistedHouse(){
	$.ajax({
        url: "/isExistedHouse/"+$("#houseId").val()      
    }).then(function(data) {
//    	   alert(data.msg);//显示结果
    		if(data.status=="fail"){
    			alert(data.msg);//显示结果
    			return;
    		}
    		add();//都存在	
    });
	};
	/**
	 * 管理员-新增业主房屋信息
	 */
	$(".addOwnerHouse").click(function(){
//        //判断业主是否存在
		
		$.ajax({
	        url: "/isExistedOwner/"+$("#ownerId").val()      
	    }).then(function(data) {
//	    	   alert(data.msg);//显示结果
	    		if(data.status=="fail"){
	    			 alert(data.msg);//显示结果
	    			return;
	    		}
	    		isExistedHouse();
	    });
//	


	});
	/**
	 * 管理员-业主信息管理页面
	 * 修改业主信息：重置密码与修改联系方式
	 */
	$(".modifyOwner").click(function(){
		
		if($(this).val()=="modifyOwner"){//当前按钮值value为modifyOwner,进入修改
			
			$(this).parent().siblings("th").each(function(j){//找同类元素th
				switch (j) {
					case 3:{//显示修改密码文本框
						    var is_text = $(this).find("input:text");//有文本框就获取文本框的值(情况可能格式错误)
						    if(!is_text.length){
						    	$(this).html("<input type='text'  value='"+$(this).text()+"' required />");
						    }
//						    else{//存在文本框不表
//						    	
//						    }
							 break;
					}
					case 8:{//显示修改手机号/账号文本框
						var is_text = $(this).find("input:text");//有文本框就获取文本框的值(情况可能格式错误)
					    if(!is_text.length){
					    	$(this).html("<input type='text'  value='"+$(this).text()+"'  />");
					    }
							break;	
				    }				
				};
			});
			$(this).val("ensureModify");
			$(this).text("确定 ");
		}//ifmodify	
		else{//当前按钮值value为ensureModify,用户已输入修改内容，
			//判断重置密码6位数字，手机号11位
			//-到后台判断结果-然后显示该值-提示修改成功
			//如果都与之前相同，提示，尚未修改;
			var orderItem={};//保存表格里的值//获取owner对象
			//alert("准备获取数据");
			normStatus=1;//格式没错
		    $(this).parent().siblings("th").each(function(j){
			      switch (j) {
					case 3:{
						var is_text = $(this).find("input:text");//密码单元格下肯定含有文本框
						var ret = /^[0-9|]{6}$/;
					      if(ret.test(is_text.val())){
					       // alert('ok');
					      }else{
					        alert('密码为统一6位数字，请符合规范！');
					        normStatus=0;//格式有问题
					        return;
					      }
						orderItem.ownerPassword=is_text.val();	
						break;
					}
					case 8:{
						var is_text = $(this).find("input:text");//联系电话单元格下肯定含有文本框
					      var ret = /^[0-9|]{11}$/;
					      if(ret.test(is_text.val())){
					       // alert('ok');
					      }else{
					        alert('手机号高级！居然不是11位？');
					        normStatus=0;//格式有问题
					        return;
					      }
						orderItem.ownerPhoneNumber=is_text.val();
						break;
					}
					case 0:{
						orderItem.ownerId=$(this).text();//第0个th   id
						break;
					}
					case 1:{
						orderItem.ownerName=$(this).text();//第1个th  姓名
						break;
					}
					case 2:{ 
						orderItem.ownerSex=$(this).text();//第2个th   密码
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
				    
			    //alert("发送到后台ing");
			    //ajax
				$.ajax({
			        url: "/updateOwner",     //重定向？url并没有变化，只是js请求服务器获取json数据，更新
			        type : "get",
			        dataType : "json",
			        contentType : "application/json; charset=utf-8",  
			        data : {
			        	  'ownerId':orderItem.ownerId,
			    		  'ownerName':orderItem.ownerName,		
			    		  'ownerPhoneNumber':orderItem.ownerPhoneNumber,
			    		  'ownerSex':orderItem.ownerSex,
			    		  'ownerPassword':orderItem.ownerPassword
			        	  },
			        async : true,  
			        success : function(data){    //修改成功  输入框变确定显示--按钮值改为modifyOwner
			        	//提示结果-修改成功-不可修改等
			        	alert(data.msg);
			        	if(data.status=="fail"){
			        		return;
			        	}
				        //重新找到该节点-有文本框的就保存-前面要有个标记-是否在修改
			        	var isModify=0;//标记是否是该行;
				        $("#tb").find("tr").each(function(){  
				        	isModify=0;//默认不是该行;
		                      $(this).children('th').each(function(j){ 
		                    	  switch (j) {						
										case 3:{
											var is_text = $(this).find("input:text");//密码单元格下肯定含有文本框
											$(this).html(is_text.val());
											break;
										}
										case 8:{
											var is_text = $(this).find("input:text");//手机单元格下肯定含有文本框
											if(is_text.length){
												$(this).html(is_text.val());
												isModify=1;
											}
											break;
										}
//										
										case 9:{//修改按钮val
											var mybutton=$(this).find('button');
						                       if(isModify==1){
						                    	   mybutton.val("modifyOwner");
						                    	   mybutton.text("修改 ");		                    	  
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
	 * 管理员-业主信息管理页面
	 * 删除业主信息：提示这将删除该业主所有相关记录：他的房屋关系，缴费信息，车位信息等
	 */
	$(".deleteOwner").click(function(){
		if(window.confirm("这将删除该业主所有相关记录：他的房屋关系，缴费信息，车位信息等\n\n您确定要删除数据吗?"))
		{	
			//获取该tr 业主id
			var orderItem={};//保存表格里的值//获取ownerId
		    $(this).parent().siblings("th").each(function(j){
			      switch (j) {
					case 0:{
						orderItem.ownerId=$(this).text();//第0个th   id
						break;
					}
				};
		    });
			//传入id
			$.ajax({
		        url: "/deleteOwner/"+orderItem.ownerId      /*重定向？url并没有变化，只是js请求服务器获取json数据，更新*/
		    }).then(function(data) {
//		    	JSON.stringify(obj)将JSON转为字符串。JSON.parse(string)将字符串转为JSON格式；
//		    	var jsondata =JSON.stringify(data.status);
//		    	if($.trim("succcessful") == $.trim(jsondata)){//结果状态字段为successful-删除成功。
		    		alert(data.msg);//显示结果
//		    	}
		    });
			
			$(this).parent().parent().remove();//局部删除
		}
	});
	
	/**
	 * 管理员-业主信息管理页面
	 * 添加业主信息：在所有业主表格中最后一列添加一行tr记录
	 */	
	$("#addOwner").click(function(){//id选择符只有一个该按钮
	
		//获取所有输入
		var orderItem={};//保存表格里的值//获取ownerId
	    $(this).parent().siblings("th").each(function(j){
		      switch (j) {
				case 0:{
					var is_text = $(this).find("input:text");
					orderItem.ownerName=is_text.val();//第0个th   姓名
					break;
				}
				case 1:{//二选框
					is_text = $(this).find("input:text");
					orderItem.ownerSex=is_text.val();//第1个th   性别
					break;
				}
				case 2:{//11位数
					is_text = $(this).find("input:text");
					orderItem.ownerPhoneNumber=is_text.val();//第2个th   手机号
					break;
				}
				case 3:{//6位数
					is_text = $(this).find("input:text");
					orderItem.ownerPassword=is_text.val();//第3个th   密码
					break;
				}
			};
	    });
       //传入id
	    var newid;
		$.ajax({
			url: "/addOwner",     //重定向？url并没有变化，只是js请求服务器获取json数据，更新
	        type : "get",
	        dataType : "json",
	        contentType : "application/json; charset=utf-8",  
	        data : {
	    		  'ownerName':orderItem.ownerName,		
	    		  'ownerPhoneNumber':orderItem.ownerPhoneNumber,
	    		  'ownerSex':orderItem.ownerSex,
	    		  'ownerPassword':orderItem.ownerPassword
	        	  },
	        async : true,  
	    }).then(function(data) {
	    	if($.trim("succcessful") == $.trim(data.status)){
	    		alert(data.msg);//显示结果
                //获取自增长的id
	    		newid=data.ownerId;

	    		
	    		
//	    		   var targetTbody= $("#tb");
//	    		    //获取#tbl表格的最后一行
//	    		    var tr = targetTbody.children("tr:last");
//	    		    //复制到#addTable表格最后
//	    		    var tr2=$("#tb").children("tr:last");
//	    		    tr2.after(tr[0].outerHTML);
	    		
	    		     
	    		   
	    		
	    		
	    		
	    		//成功表格最后一行新增记录,样式触发事件触发不成功
//				alert("添加tr"); 
//				
//				var	bt1Html='<button type="button" value="modifyOwner" class="modifyOwner" >修改</button>';
//				bt1Html.addClass("modifyOwner ");
//				
//				$("#tb").append('<tr>'                                         //<tr data-index="${idx.index }" data-id="${em.id }">
//						+'<th>'+newid+'</th>'
//						+'<th>'+orderItem.ownerName+'</th>' 
//						+'<th>'+orderItem.ownerSex+'</th>'
//						+'<th>'+orderItem.ownerPassword+'</th>'
//						+'<th></th>'
//						+'<th></th>'
//						+'<th></th>'
//						+'<th></th>'
//						+'<th>'+orderItem.ownerPhoneNumber+'</th> '
//						+'<th>'+bt1Html+'</th>'
//                        +'<th><button  type="button"  class="deleteOwner" style="color: blue">删除</button></th>'
//						+'</td>'
//						+'</tr>');
//				

	    		
//	    		 $("p:first").addClass("intro note");
	    		 
	    		 
	    		 
	    		 
	    		 
	    		 
	    		 
	    		 
	    		 
//				$tr.after(trHtml);
		        //渲染样式
//		        $.parser.parse("#tb");
		        
//				 var trHtml="<tr>" +
//				 		"<th>"+newid+"</th>"+
//				 		"<th>"+orderItem.ownerName+"</th>" +
//				 		"<th>"+orderItem.ownerSex+"</th>" +
//				 		"<th>"+orderItem.ownerPassword+"</th>" +
//		 				"<th></th>" +
//		 				"<th></th>" +
//		 				"<th></th>" +
//		 				"<th></th>" +
//		 				"<th>"+orderItem.ownerPhoneNumber+"</th> " +
//		 				"<th><button value="modifyOwner" class="modifyOwner" style="color: blue" th:text="修改" > </button></th>" +      
//				        "<th><button class="deleteOwner" style="color: blue" th:text="删除" >  </button></th>" +   
// 						"</tr>";
// 						
//				$("#tb").append(trHtml);

	    	}
	    });
		
		
        //$(this).parent().parent().remove();//局部删除
		
	});
	
	
	
	
	
	/**
	 * 保安页面内锚点跳转
	 */	
	$("#tosecurityVistor").click(function(){ /*id选择符,click事件 等价于 jsp onclick();*/

		document.getElementById("securityVistor").scrollIntoView();//js触发业内锚点显示
   });
    $("#tosecurityAllDayShare").click(function(){ /*id选择符,click事件 等价于 jsp onclick();*/
		document.getElementById("securityAllDayShare").scrollIntoView();//js触发业内锚点显示
   });
    $("#tosecurityTempParkingSpace").click(function(){ /*id选择符,click事件 等价于 jsp onclick();*/
		document.getElementById("securityTempParkingSpace").scrollIntoView();//js触发业内锚点显示
   });
    $("#tosecurityAddVisitor").click(function(){ /*id选择符,click事件 等价于 jsp onclick();*/
		document.getElementById("securityAddVisitor").scrollIntoView();//js触发业内锚点显示
    });
    $("#tosecurityFindCar").click(function(){ /*id选择符,click事件 等价于 jsp onclick();*/
		document.getElementById("securityFindCar").scrollIntoView();//js触发业内锚点显示
   });
    $("#tosecurityAnnouncement").click(function(){ 
		document.getElementById("securityAnnouncement").scrollIntoView();
    });
	
});


//$(document).ready(function(){
//	alert("111");
//	
//	$("#finishedOnce").click(function(){ /*id选择符,click事件 等价于 jsp onclick();*/
//	//获取输入
//	var value = $("#upc").val(); // 获取值
//    value = $.trim(value); // 用jQuery的trim方法删除前后空格
//    if (value == '') {// 判断是否是空字符串，而不是null
//        alert("upc不能为空!");
//        return false;
//    };
//	value = $("#qty").val(); // 获取值
//    value = $.trim(value); // 用jQuery的trim方法删除前后空格
//    if (value == '') {// 判断是否是空字符串，而不是null
//        alert("数量不能为空!");
//        return false;
//    };
//    
//	$.ajax({
//        url: "/addLineItem/"+$("#upc").val()+"/"+$("#qty").val()      /*重定向？url并没有变化，只是js请求服务器获取json数据，更新*/
//    }).then(function(data) {
//    	 var strHTML = "";
//// 	   	resultMap.put("description",description);
////	   	resultMap.put("price",price);
////	   	resultMap.put("qty",qty);
////	   	resultMap.put("subtotal",subtotal);
//
//    	 $("#table1").append("<tr><td>+"+data.description+"</td><td>"+data.price+"</td><td>"+data.qty+"</td><td>"+data.subtotal+"</td></tr>");
//    	$("#databaseTip").append(strHTML);
//    	 
//
//		$("#systemTip").append("添加了项目");
//		$("#databaseTip").append("");
//    
//    
//    
//    });
//	});
//	/* 结束扫描*/
//	$("#endSale").click(function(){ /*id选择符,click事件 等价于 jsp onclick();*/
//	    
//		$.ajax({
//	        url: "/endSale"     
//	    }).then(function(data) {
//
//	    	 $("#table1").append("共计"+data.amount);
//	    	
//			$("#systemTip").append("添加了项目");
//			$("#databaseTip").append("");
//	    
//	    });
//		});
//	/* 支付*/
////	aliPay
//	$("#cashPay").click(function(){ /*id选择符,click事件 等价于 jsp onclick();*/
//	    
//		$.ajax({
//	        url: "/pay/"+"PaymentServiceImplCash"     
//	    }).then(function(data) {
//
//	    	 $("#table2").append("<tr><td>+"+data.amount+"</td><td>"+data.paid+"</td><td>"+data.blaance+"</td><td>"+data.type+"</td></tr>");
//	   
//	 		$("#systemTip").append("添加了订单");
//			$("#databaseTip").append("订单插入到数据库");
//	    
//	    });
//		});
//	
//
///* 阿里支付  如果是输入就不用改客户端*/
//$("#aliPay").click(function(){ /*id选择符,click事件 等价于 jsp onclick();*/
//    
//	$.ajax({
//        url: "/pay/"+"PaymentServiceImplAli"     
//    }).then(function(data) {
//
//    	 $("#table2").append("<tr><td>+"+data.amount+"</td><td>"+data.paid+"</td><td>"+data.blaance+"</td><td>"+data.type+"</td></tr>");
//   
//		$("#systemTip").append("添加了订单");
//		$("#databaseTip").append("订单插入到数据库");
//    
//    });
//	});
//
//});
//	    });
//	}); 
//});




//		 


//	$("#finishedOnce").click(function(){ 
//		/*ajax获取数据*/
//			$.ajax({
//				alert("111");
//		        url: "/addLineItem"     /*重定向？url并没有变化，只是js请求服务器获取json数据，更新*/
//		    }).then(function(data){
////		    	alert("111");
////				/*追加表格内容saleLineItem*/
////				$("#table1").append("<tr><td>+"+data.storeService.getStore().getStoreId()+"</td><td>2</td><td>3</td><td>4</td></tr>");
//				/*追加提示内容*/
//				$("#systemTip").append("添加了项目");
//				$("#databaseTip").append("");
//			    });
//	}); 

//strHTML +=" <tr><td>"+100+"</td><td>"+100+" </td><td>"+100+" </td><td>"+100+"</td></tr>
//	    	table1
/*追加表格内容saleLineItem*/
//		$("#table1").append("<tr><td>1</td><td>2</td><td>3</td><td>4</td></tr>");
//		data.storeService.getStore().getStoreId()

/*追加提示内容*/
//strHTML +=" <tr><td>"+descp+"</td><td>"+price+" </td><td>"+qty+" </td><td>"+subtitle+"</td></tr>






