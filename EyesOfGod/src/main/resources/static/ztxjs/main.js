/**
 * 
 * @returns
 */
$(document).ready(function(){
	
	/**
	 * 公共设施
	 */
	$(".modifyFacility").click(function(){
		
		if($(this).val()=="modifyFacility"){//当前按钮值value为modifyOwner,进入修改
			
			$(this).parent().siblings("th").each(function(j){//找同类元素th
				switch (j) {
					case 4:{//显示修改维修师傅信息文本框
						    var is_text = $(this).find("input:text");//有文本框就获取文本框的值(情况可能格式错误)
						    if(!is_text.length){
						    	$(this).html("<input type='text' value='"+$(this).text()+"' />");
						    }
							 break;
					}
					case 5:{//显示修改维修金额文本框
						var is_text = $(this).find("input:text");//有文本框就获取文本框的值(情况可能格式错误)
					    if(!is_text.length){
					    	$(this).html("<input type='text' value='"+$(this).text()+"' />");
					    }
							break;	
				    }				
				};
			});
			$(this).val("ensureModify");
			$(this).text("确定 ");
		}//ifmodify	
		else{
			var orderItem={};//保存表格里的值//获取owner对象
			normStatus=1;//格式没错
		    $(this).parent().siblings("th").each(function(j){
			      switch (j) {
					case 4:{
						var is_text = $(this).find("input:text");//密码单元格下肯定含有文本框
						orderItem.repairerInfomation=is_text.val();	
						break;
					}
					case 5:{
						var is_text = $(this).find("input:text");//联系电话单元格下肯定含有文本框
//					      var ret = /^[0-9|]{}$/;
//					      if(ret.test(is_text.val())){
//					        alert('shuzi');
//					      }else{
//					        alert('请输入数字！');
//					        normStatus=0;//格式有问题
//					        return;
//					      }
						orderItem.repairMoney=parseInt(is_text.val());
						break;
					}
					case 0:{
						orderItem.publicUtilityId=$(this).text();//第0个th   id
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
				$.ajax({
			        url: "/doRepair",     //重定向？url并没有变化，只是js请求服务器获取json数据，更新
			        type : "get",
			        dataType : "json",
			        contentType : "application/json; charset=utf-8",  
			        data: {
			        	  'publicUtilityId':orderItem.publicUtilityId,
			    		  'repairerInfomation':orderItem.repairerInfomation,		
			    		  'repairMoney':orderItem.repairMoney,
			        	  },
			        async : true,  
			        success : function(data){    //修改成功  输入框变确定显示--按钮值改为modifyOwner
			        	//提示结果-修改成功-不可修改等
			        	alert(data.msg);
			        	var date=data.date;
				        //重新找到该节点-有文本框的就保存-前面要有个标记-是否在修改
			        	var isModify=0;//标记是否是该行;
				        $("#facilityTb").find("tr").each(function(){  
				        	isModify=0;//默认不是该行;
		                      $(this).children('th').each(function(j){ 
		                    	  switch (j) {						
										case 4:{
											var is_text = $(this).find("input:text");//密码单元格下肯定含有文本框
											$(this).html(is_text.val());
											break;
										}
										case 5:{
											var is_text = $(this).find("input:text");//手机单元格下肯定含有文本框
											if(is_text.length){
												$(this).html(is_text.val());
												isModify=1;
											}
											break;
										}
										case 6:{
										
											$(this).html(date);
										}
										break;
									

										case 7:{//修改按钮val
											var mybutton=$(this).find('button');
						                       if(isModify==1){
						                    	   mybutton.val("modifyFacility");
						                    	   mybutton.text("申请维修");		                    	  
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
	 * 管理员删除房屋信息
	 */
	$(".deleteHouse").click(function(){
		if(window.confirm("这将删除该房屋信息等\n\n您确定要删除数据吗?"))
		{	
			//获取该tr 房屋id
			var houseItem={};//保存表格里的值//获取houseID
		    $(this).parent().siblings("th").each(function(j){
			      switch (j) {
					case 0:{
						houseItem.houseId=$(this).text();//第0个th   id
						break;
					}
				};
		    });
			//传入id
			$.ajax({
		        url: "/deleteHouse/"+houseItem.houseId      /*重定向？url并没有变化，只是js请求服务器获取json数据，更新*/
		    }).then(function(data) {
		    		alert(data.msg);//显示结果
		    });
			$(this).parent().parent().remove();//局部删除
		}
	});	
	/*
	 * 管理员缴费-》改消费记录
	 */
	$(".payBt").click(function(){
		if(window.confirm("确定缴费吗?"))
		{	
			//获取该tr 业主id
			var expenseItem={};//保存表格里的值//获取houseID
		    $(this).parent().siblings("th").each(function(j){
			      switch (j) {
					case 0:{
						expenseItem.expenseId=$(this).text();//第0个th   id
						break;
					}
				};
		    });
			//传入id
			$.ajax({
		        url: "/doPayment/"+expenseItem.expenseId      /*重定向？url并没有变化，只是js请求服务器获取json数据，更新*/
		    }).then(function(data) {
		    		alert(data.msg);//显示结果
		    });
			//$(this).parent().parent().remove();//局部删除
		}
	});	
	
	
	/*
	 * 增加房屋信息
	 */
	$(".addHouse").click(function(){
		if(window.confirm("确定要增加房屋信息吗?"))
		{	
			alert(data.msg);//显示结果
		}
	});	
});


