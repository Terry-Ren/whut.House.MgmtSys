<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	pageContext.setAttribute("API_Path", request.getContextPath());
%>
<link
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script src="http://cdn.static.runoob.com/libs/jquery/2.0.0/jquery.js"></script>
<script	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript"
	src="${API_Path }/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	//选项卡
	$(function() {
		$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
			// Get the name of active tab
			var activeTab = $(e.target).text();
			// Get the name of previous tab
			var previousTab = $(e.relatedTarget).text();
			$(".active-tab span").html(activeTab);
			$(".previous-tab span").html(previousTab);
		});
	});

	//模拟Get请求
	function ajaxRequestGet(uri) {
		//alert("${API_Path }/" + uri);
		$.ajax({
			url : uri,
			type : "get",
			contentType : 'application/json',
			dataType : 'json',
			success : function(response) {
				console.log(response);
			},
			error : function() {
				console.log('Ajax请求失败！');
			}
		});
	}

	//模拟Post类请求
	function ajaxRequestPostType(uri, method, data) {
		//alert("${API_Path }/" + uri);
		$.ajax({
			type : method,
			contentType : 'application/json;charset=UTF-8',
			dataType : 'json',
			data : JSON.stringify(data),
			url : uri,
			success : function(response) {
				console.log(response);
			},
			error : function() {
				console.log('Ajax请求失败！');
			}
		});
	}

	//房屋参数
	$(function() {
		
		$("#houseTypeParamGet").click(function() {
			ajaxRequestGet("houseParam/getHouseParamId/2");

		})
		
		$("#houseParamGet").click(function() {
			ajaxRequestGet("houseParam/get/1");
		})
		
		$("#houseParamGetWithoutPage").click(function() {
			ajaxRequestGet("houseParam/getWithoutPage/1");
		})

		$("#houseParamDelete").click(function() {
			ajaxRequestPostType("houseParam/delete/3", "DELETE", null);
		})

		$("#houseParamAdd").click(function() {
			var data = {
				'houseParamName' : '测试房1',
				'paramTypeId' : 1,
				'paramTypeName' : '住房类型'
			};
			ajaxRequestPostType("houseParam/add", "POST", data);
		})

		$("#houseParamModify").click(function() {
			var data = {
				'houseParamId' : 8,
				'houseParamName' : '修改测试',
				'paramTypeId' : 2,
				'paramTypeName' : '户型'
			};
			ajaxRequestPostType("houseParam/modify", "PUT", data);
		})
	})

	//维修参数
	$(function() {
		$("#fixParamGet").click(function() {
			ajaxRequestGet("fixParam/get/16");
		})

		$("#fixParamDelete").click(function() {
			ajaxRequestPostType("fixParam/delete/3", "DELETE", null);
		})

		$("#fixParamAdd").click(function() {
			var data = {
				'fixParamName' : '测试维修',
				'paramTypeId' : 16,
				'paramTypeName' : '维修内容'
			};
			ajaxRequestPostType("fixParam/add", "POST", data);
		})

		$("#fixParamModify").click(function() {
			var data = {
				'fixParamId' : 1,
				'fixParamName' : '修改测试',
				'paramTypeId' : 16,
				'paramTypeName' : '维修内容'
			};
			ajaxRequestPostType("fixParam/modify", "PUT", data);
		})
	})

	//租金参数
	$(function() {
		$("#rentalParamGet").click(function() {
			ajaxRequestGet("rentalParam/get");
		})

		$("#rentalParamModify").click(function() {
			var data = {
				//可以不设置rentalTypeId
				'rentalParamId' : 189,
				'rentalTimeDiv' : 2,
				'rentalOldDct' : '0.3',
				'rentalNewDctYear' : 5,
				'rentalNewDct' : '0.4'
			};
			ajaxRequestPostType("rentalParam/modify", "PUT", data);
		})
	})

	//地区
	$(function() {
		$("#regionGet").click(function() {
			ajaxRequestGet("region/get/1");
			//ajaxRequestGet("region/get?page=1&size=10"); 不带参数的才能加page和size 带参数的时候只获取一个 不能加
		})
		
		$("#getRegionWithBuildings").click(function() {
			ajaxRequestGet("region/getRegionWithBuildings/1");
			//ajaxRequestGet("region/get?page=1&size=10"); 
		})

		$("#regionDelete").click(function() {
			ajaxRequestPostType("region/delete/12", "DELETE", null);
		})

		$("#regionAdd").click(function() {
			var data = {
				'name' : "北冰洋",
				'description' : '南湖大草原'
			};
			ajaxRequestPostType("region/add", "POST", data);
		})

		$("#regionModify").click(function() {
			var data = {
				'id' : 1,
				'name' : '北湖de南边',
				'description' : '北湖大草原'
			};
			ajaxRequestPostType("region/modify", "PUT", data);
		})
	})
	
	//楼栋
	$(function() {
		$("#buildingGet").click(function() {
			ajaxRequestGet("building/get/1");
			//ajaxRequestGet("building/get?page=1&size=10"); 不带参数的才能加page和size 带参数的时候只获取一个，不能加page和size
		})
		
		$("#getBuildingByRegionId").click(function() {
			ajaxRequestGet("building/getAllByRegionId/1");
			//不带page=1&size=10默认不分页
		})

		$("#buildingDelete").click(function() {
			ajaxRequestPostType("building/delete/162", "DELETE", null);
		})

		$("#buildingAdd").click(function() {
			var data = {
				'name' : "南湖",
				'description' : '南湖大草原',
				'finishTime' : '2017-11-4',
				'floorArea' : '41.4',
				'usedArea' : '41.22',
				'floorCount' : '66',
				'regionId' : 1
			};
			ajaxRequestPostType("building/add", "POST", data);
		})

		$("#buildingModify").click(function() {
			var data = {
				'id' : 3,
				'name' : "2栋",
				'description' : '南湖大草原',
				'finishTime' : '2017-11-4',
				'floorArea' : '41.4',
				'usedArea' : '41.22',
				'floorCount' : '66',
				'regionId' : 2
			};
			ajaxRequestPostType("building/modify", "PUT", data);
		})
	})
	
	//房屋
	$(function() {
		$("#houseGet").click(function() {
			ajaxRequestGet("house/get/1");
			//ajaxRequestGet("house/get?page=1&size=10"); 不带参数的才能加page和size 带参数的时候只获取一个，不能加page和size
		})
		
		$("#houseGetAll").click(function() {
			ajaxRequestGet("house/get");
			//ajaxRequestGet("house/get?page=1&size=10"); 不带参数的才能加page和size 带参数的时候只获取一个，不能加page和size
		})
		
		$("#getViewHouseByRegionId").click(function() {
			ajaxRequestPostType("house/getViewHousesByRegionId/1");
			//不带page=1&size=10默认不分页
		})
		
		$("#getViewHouseByBuildingId").click(function() {
			ajaxRequestPostType("house/getViewHousesByBuildingId/5?page=1&size=10");
			//不带page=1&size=10默认不分页
		})

		$("#houseDelete").click(function() {
			ajaxRequestPostType("house/delete/12", "DELETE", null);
		})

		$("#houseAdd").click(function() {
			var data = {
				'no' : 576,
				'type' : 77,
				'layout' : 19,
				'struct' : 29,
				'buildArea' : 66,
				'usedArea' : 66,
				'basementArea' : 66,
				'address' : '水立方',
				'buildingId' : 5,
				'image':null,
				'proId' : '66',
				'remark':'凤梨酥',
				'rental':'26.9',
				'finishTime':new Date(),
				'recordStatus':1
			};
			ajaxRequestPostType("house/add", "POST", data);
		})

		$("#houseModify").click(function() {
			var data = {
					'id':7,
					'no' : 5776,
					'type' : 6,
					'layout' : 19,
					'struct' : 29,
					'buildArea' : 66,
					'usedArea' : 66,
					'basementArea' : 66,
					'address' : '水方',
					'buildingId' : 5,
					'image':null,
					'proId' : '66',
					'remark':'凤梨酥',
					'rental':'26.9',
					'finishTime':new Date(),
					'recordStatus':1
			};
			ajaxRequestPostType("house/modify", "PUT", data);
		})
	})
	
	//权限right&class
	$(function() {
		$("#rightGet").click(function() {
			ajaxRequestGet("right/getClassWithRights/2");
		})

		$("#getAllClassWithRight").click(function() {
			ajaxRequestGet("right/get");
		})
	})

	//角色
	$(function() {
		$("#roleGet").click(function() {
			ajaxRequestGet("role/get");
		})
		
		
	})
	
	//登陆
	$(function() {
		$("#login1").click(function() {
			var data ={
					'no':'8',
					'password':'123',
					'roleId':3,
					'token':'111',
					'lastLoginTime':'2018-01-05T18:54:05'
			};
			ajaxRequestPostType("login/user", "POST", data);
		})
		
		$("#login2").click(function() {
			var data ={
					'no':'8',
					'password':'123',
					'roleId':3,
					'token':'',
					'lastLoginTime':''
			};
			ajaxRequestPostType("login/user", "POST", data);
		})
		
		$("#login3").click(function() {
			var data ={
					'no':'8',
					'password':'123',
					'roleId':3,
					'token':'1111',
					'lastLoginTime':'2018-01-05T18:54:05'
			};
			ajaxRequestPostType("login/user", "POST", data);
		})
		
		$("#login4").click(function() {
			var data ={
					'no':'8',
					'password':'123',
					'roleId':3,
					'token':'111',
					'lastLoginTime':'2018-01-04T18:54:05'
			};
			ajaxRequestPostType("login/user", "POST", data);
		})
		
		$("#login5").click(function() {
			var data ={
					'no':'8',
					'password':'124',
					'roleId':3,
					'token':'',
					'lastLoginTime':''
			};
			ajaxRequestPostType("login/user", "POST", data);
		})
	})
	
	//下拉列表
	$(function() {
		$("#building_regionDown").click(function() {
			ajaxRequestGet("building/getList");
		})
	})
</script>

</head>
<body>


	<hr>
	<hr>
	<ul id="myTab" class="nav nav-tabs">
		<li class="active"><a href="#houseParam" data-toggle="tab">houseParam</a></li>
		<li><a href="#fixParam" data-toggle="tab">fixParam</a></li>
		<li><a href="#rentalParam" data-toggle="tab">rentalParam</a></li>
		<li><a href="#region" data-toggle="tab">region</a></li>
		<li><a href="#building" data-toggle="tab">building</a></li>
		<li><a href="#house" data-toggle="tab">house</a></li>
		<li><a href="#right" data-toggle="tab">right</a></li>
		<li><a href="#role" data-toggle="tab">role</a></li>
		<li><a href="#login" data-toggle="tab">login</a></li>
		
	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="houseParam">
			<input class="btn btn-info btn-lg" type="button" value="Get" id="houseParamGet" /> <br>
			<input class="btn btn-info btn-lg" type="button" value="GetHouseType" id="houseTypeParamGet" /> <br>
			<input class="btn btn-info btn-lg" type="button" value="houseParamGetWithoutPage" id="houseParamGetWithoutPage" /><br>
			<input class="btn btn-info btn-lg"type="button" value="Delete" id="houseParamDelete" /><br>
			<input class="btn btn-info btn-lg"type="button" value="Add" id="houseParamAdd" /> <br>
			<input class="btn btn-info btn-lg"type="button" value="Modify" id="houseParamModify" />
			<br>
		</div>
		<div class="tab-pane fade" id="fixParam">
			<input class="btn btn-info btn-lg" type="button" value="FixParamGet" id="fixParamGet" /> <br>
			<input class="btn btn-info btn-lg" type="button" value="FixParamDelete" id="fixParamDelete" /> <br>
			<input class="btn btn-info btn-lg" type="button" value="FixParamAdd" id="fixParamAdd" /> <br>
			<input class="btn btn-info btn-lg" type="button" value="FixParamModify" id="fixParamModify" /> <br>
		</div>
		<div class="tab-pane fade" id="rentalParam">
			<input class="btn btn-info btn-lg" type="button" value="RentalParamGet" id="rentalParamGet" /> <br>
			<input class="btn btn-info btn-lg" type="button" value="RentalParamModify" id="rentalParamModify" /><br>
		</div>
		<div class="tab-pane fade" id="region">
			<input class="btn btn-info btn-lg" type="button" value="RegionGet" id="regionGet" /> <br> 
			<input class="btn btn-info btn-lg" type="button" value="GetRegionWithBuildings" id="getRegionWithBuildings" /> <br> 
			<input class="btn btn-info btn-lg" type="button" value="RegionDelete" id="regionDelete" /> <br> 
			<input class="btn btn-info btn-lg" type="button" value="RegionAdd" id="regionAdd" /> <br> 
			<input class="btn btn-info btn-lg" type="button" value="RegionModify" id="regionModify" /> <br>
		</div>
		<div class="tab-pane fade" id="building">
			<input class="btn btn-info btn-lg" type="button" value="BuildingGet" id="buildingGet" /> <br> 
			<input class="btn btn-info btn-lg" type="button" value="GetBuildingByRegionId" id="getBuildingByRegionId" /> <br> 
			<input class="btn btn-info btn-lg" type="button" value="BuildingDelete" id="buildingDelete" /> <br> 
			<input class="btn btn-info btn-lg" type="button" value="BuildingAdd" id="buildingAdd" /> <br> 
			<input class="btn btn-info btn-lg" type="button" value="BuildingModify" id="buildingModify" /> <br>
		</div>
		<div class="tab-pane fade" id="house">
		            根据house的id获取一个house <br>
			<input class="btn btn-info btn-lg" type="button" value="HouseGet" id="houseGet" /> <br> <br>
			不传参获取全部的house，默认不分页<br>
			<input class="btn btn-info btn-lg" type="button" value="HouseGetAll" id="houseGetAll" /> <br><br>
			根据regionId获取一个地区的全部house，默认不分页<br>
			<input class="btn btn-info btn-lg" type="button" value="getViewHouseByRegionId" id="getViewHouseByRegionId" /> <br><br> 
			根据buildingId获取一个楼栋中的全部house，默认不分页<br>
			<input class="btn btn-info btn-lg" type="button" value="getViewHouseByBuildingId" id="getViewHouseByBuildingId" /> <br><br> 
			删除一个house<br>
			<input class="btn btn-info btn-lg" type="button" value="HouseDelete" id="houseDelete" /> <br> <br>
			增加一个house<br>
			<input class="btn btn-info btn-lg" type="button" value="HouseAdd" id="houseAdd" /> <br> <br>
			修改一个house<br>
			<input class="btn btn-info btn-lg" type="button" value="HouseModify" id="houseModify" /> <br><br>
		</div>
		<div class="tab-pane fade" id="right">
			<input class="btn btn-info btn-lg" type="button" value="获取带right的class" id="rightGet" /> <br> 
			<input class="btn btn-info btn-lg" type="button" value="获取全部带right的class" id="getAllClassWithRight" /> <br> 
			
		</div>
		<div class="tab-pane fade" id="role">
			<input class="btn btn-info btn-lg" type="button" value="role" id="roleGet" /> <br> 
			<input class="btn btn-info btn-lg" type="button" value="roleAdd" id="roleAdd" /> <br> 
		</div>
		<div class="tab-pane fade" id="login">
			<div>令牌登陆 <br>
			<input class="btn btn-info btn-lg" type="button" value="登陆" id="login1" /> <br> <br></div>
			<div>不用令牌登陆 <br>
			<input class="btn btn-info btn-lg" type="button" value="登陆" id="login2" /> <br> <br></div>
			<div>错误的令牌信息登陆 <br>
			<input class="btn btn-info btn-lg" type="button" value="登陆" id="login3" /> <br> <br></div>
			<div>超时但账号密码信息正确 <br>
			<input class="btn btn-info btn-lg" type="button" value="登陆" id="login4" /> <br> <br></div>
			<div>无令牌切账号密码错误 <br>
			<input class="btn btn-info btn-lg" type="button" value="登陆" id="login5" /> <br> <br></div>
			
		</div>
		
	</div>



</body>
</html>