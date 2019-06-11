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






