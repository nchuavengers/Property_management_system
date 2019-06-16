/**
 * 
 * @returns
 */
$(document).ready(function(){
	
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
	
	$(".addHouse").click(function(){
		if(window.confirm("确定要增加房屋信息吗?"))
		{	
			alert(data.msg);//显示结果
		}
	});	
});


