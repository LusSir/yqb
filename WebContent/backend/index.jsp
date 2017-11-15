<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>宜启邦后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="index.css">
<script src="../date_util.js"></script>
<script src="../jQuery/jquery-3.2.1.min.js"></script>
<script src="../bootstrap/dist/js/bootstrap.js"></script>
<script type="text/javascript" charset="utf-8"
	src="../ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="../ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="../ueditor/lang/zh-cn/zh-cn.js"></script>
<script>
	$(function() {
		getAllNews();
		getAllType();
	});
	function getAllNews() {
		$.getJSON(
			"/yqb/NewsServlet",
			{
				action : "getAllNews"
			},
			function(data) {
				showNewsData(data);
		});
	}
	
	function showNewsData(data){
	if (data.retMsg) {
		console.log(data);
		$("#news").html("");
		var list = data.retData;
		for (var i = 0; i < list.length; i++) {
			var news = list[i];
			$("#news").append('<tr align="center">'
				+ "<td>"+ (i + 1)+ "</td>"
				+ "<td>"+ "<div>"+ news.title+ "</div>"+ "</td>"
				+ "<td>"+ news.author+ "</td>"
				+ "<td>"+ news.source+ "</td>"
				+ "<td id='type"+i+"'>"+ news.type+ "</td>"
				+ "<td>"+ "<div>"+ news.content+ "</div>"+ "</td>"
				+ "<td>"+ "viedo"+ "</td>"
				+ "<td>"+ news.readCount+ "</td>"
				+ "<td>"+ news.commCount+ "</td>"
				+ "<td>"+ news.shareCount+ "</td>"
				+ "<td>"+ getStrDate(news.creatTime.time)+ "</td>"
				+ "<td>"+ (news.hot ? "是": "否")+ "</td>"
				+ "<td>"+ '<span id="updateBtn'+ i+ '" class="updateBtn"><img src="../img/xiugai.png"></span>'
				+ '<span id="deleteBtn'+ i+ '" onclick="deleteNews('+ news.id+ ')"><img src="../img/shanchu.png"> </span>'+ "</td>" + "</tr>"),
				getTypeById(news.type, i)
				}
		$(".updateBtn").each(function(index) {
			$("#updateBtn" + index).click(function() {
			var news= list[index];
			//1.把模态框放出来
			$("#addnews").modal('show');
			//2.将模态框里面显示的数据变成news对象里面的数据
			$("#addnews #myModalLabel").text("修改新闻");//修改模态框标题
			$("#addnews #typeid").val(news.type);
			$("#addnews #title").val(news.title);
			$("#addnews #source").val(news.source);
			$("#addnews #author").val(news.author);
			$("#id").val(news.id);
			//3.修改确定按钮 事件
			var ue = UE.getEditor('editor',{ 
				initialFrameWidth : 700,
        		initialFrameHeight : 300,
			});
/* 			ue.focus(); */
			ue.setContent(news.content);
			if (news.hot) {
				$("#yes").attr("checked", true);
				$("#no").removeAttr("checked");
			} else {
				$("#yes").removeAttr("checked");
				$("#no").attr("checked", true);
			}
			});
		});
		}
	}

	/*根据id删除新闻*/
	function deleteNews(newsId) {
		$.ajax({
			url : "/yqb/NewsServlet",//请求url地址
			data : { //请求参数对象
				action : "deleteNews",
				id : newsId
			},
			timeout : 5000,//请求超时时间，以ms为单位
			type : "post",//请求方式
			success : function(data) {//请求成功回掉函数
				var objData = JSON.parse(data);
				if (objData.retCode == 0) {
					getAllNews();
				}
			},
			error : function(e) {//请求失败回掉函数
				alert("类型获取异常" + e);
			},
		});
	}
	

	function getAllType() {
		$.ajax({
			url : "/yqb/TypeServlet",
			data : {
				action : "getAllType"
			},
			type : "get",
			timeout : 5000,
			success : function(data) {
				var jsData = JSON.parse(data);
				$("#typeid").html("");
				for (var i = 0; i < jsData.retData.length; i++) {
					var type = jsData.retData[i];
					$("#typeid").append(
							'<option value="'+type.id+'">' + type.name+ '</option>');
				}
			},
			error : function(e) {
				alert("上传失败");
			},
		})
	}

	function getTypeById(typeId, index) {
		$.ajax({
			url : "/yqb/TypeServlet",
			data : {
				action : "getTypeById",
				id : typeId
			},
			timeout : 5000,
			type : "get",
			success : function(data) {
				var objData = JSON.parse(data);//将字符串对象转化为js的Object对象
				if (objData.retCode == 0) {
					$("#type" + index).text(objData.retData.name);
				}
			},
			error : function(e) {//请求失败回掉函数
				alert("类型获取异常" + e);
			},
		})
	}
 	function addNewsBtn(){
		$("#addnews").modal('show');
		$("#addnews #myModalLabel").text("添加新闻");//修改模态框标题
		$("#addnews #typeid").val("1");
		$("#addnews #title").val("");
		$("#addnews #source").val("");
		$("#addnews #author").val("");
		$("#addnews #yes").checked;
		//3.修改确定按钮 事件
		var ue = UE.getEditor('editor',{ 
			initialFrameWidth : 700,
    		initialFrameHeight : 300,
		});
/* 			ue.focus(); */
		ue.setContent("");
	} 
	//添加新闻按钮点击事件
	function addNewsSure() {
		var title = $("#title").val();
		var source = $('#source').val();
		var author = $("#author").val();
		var content = ue.getContent();
		var type = $("#typeid").val();
		var ifHot = $("#yes").prop("checked") ? true : false;
		var modal_title = $("#addnews #myModalLabel").text();
		if (title == "" || source == "" || author == "" || content == "") {
			alert("请输入内容");
		} else {
			var data= {
					title : title,
					typeid : type,
					content : content,
					source : source,
					author : author,
					ifHot : ifHot
				}
			if(modal_title=="修改新闻"){		
				data.id=$("#id").val();
				data.action="updateNews";
			}else{
				data.action="insertNews";
			}
			$.ajax({
				url : "/yqb/NewsServlet",
				data : data,
				type : "post",
				timeout : 5000,
				success : function(data) {
					var jsData = JSON.parse(data);
					if (jsData.retCode == 0) {
						$("#addnews").modal('hide');
						getAllNews();
					}
				},
				error : function(e) {
					alert("上传失败");
				},
			});
		}
	}
</script>
</head>
<body>
	<div class="container_fluid">
		<div class="header">
			<div class="row">
				<div class="col-sm-2 tx">
					<img src="../img/touxiang.png" alt="">鲁家星
				</div>
				<div class="col-sm-2 col-sm-offset-4 sxgb">
					<img src="../img/zhuxiao.jpg" alt=""
						style="width: 55px; height: 30px">
				</div>
			</div>
		</div>
		<div class="content">
			<div>
				<!-- Nav tabs -->
				<ul class="nav nav-tabs left" role="tablist">
					<li role="presentation" class="active"><a href="#home"
						aria-controls="home" role="tab" data-toggle="tab"><img
							src="../img/yonghuguanli.png" alt=""><span>用户管理</span><img
							src="../img/cebianlan-sanjiaoxing.png" alt="" class="sanjiao"></a></li>
					<li role="presentation"><a href="#profile"
						aria-controls="profile" role="tab" data-toggle="tab"><img
							src="../img/xinwenguuanli.png" alt=""><span>新闻管理</span><img
							src="../img/cebianlan-sanjiaoxing.png" alt="" class="sanjiao"></a>
					</li>
					<li role="presentation"><a href="#messages"
						aria-controls="messages" role="tab" data-toggle="tab"><img
							src="../img/pinglunguanli.png" alt=""><span>评论管理</span><img
							src="../img/cebianlan-sanjiaoxing.png" alt="" class="sanjiao"></a>
					</li>
					<li role="presentation"><a href="#settings"
						aria-controls="settings" role="tab" data-toggle="tab"><img
							src="../img/xinwenpachong.png" alt=""><span>新闻爬虫</span><img
							src="../img/cebianlan-sanjiaoxing.png" alt="" class="sanjiao"></a>
					</li>
					<li role="presentation"><a href="#xwflgl"
						aria-controls="settings" role="tab" data-toggle="tab"><img
							src="../img/xinwenguanlfenlei.png" alt=""><span>新闻分类管理</span><img
							src="../img/cebianlan-sanjiaoxing.png" alt="" class="sanjiao"></a>
					</li>
					<li class="logo"><img src="../img/logo1.png" alt=""></li>
				</ul>
				<!-- Tab panes -->
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="home">
						<!--<div>-->

						<!-- Nav tabs -->
						<ul class="nav nav-tabs top" role="tablist">
							<li role="presentation" class="active"><a href="#hy"
								aria-controls="home" role="tab" data-toggle="tab">会员</a></li>
							<li role="presentation"><a href="#gly"
								aria-controls="profile" role="tab" data-toggle="tab">管理员</a></li>
							<li class="yhss">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="序号/用户名">
									<span class="input-group-btn">
										<button class="btn btn-primary" type="button">
											<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
										</button>
									</span>
								</div>
							</li>
							<li><button type="button" class="btn btn-default addbtn"
									data-toggle="modal" data-target="#adduser">
									<img src="../img/jixutianjia.png" alt="">添加
								</button></li>
						</ul>

						<!-- Tab panes -->
						<div class="tab-content table1">
							<div role="tabpanel" class="tab-pane active" id="hy">

								<table class="table table-bordered">
									<thead>
										<tr>
											<th width="3%">序号</th>
											<th width="5%">用户名</th>
											<th width="5%">昵称</th>
											<th width="3%">性别</th>
											<th width="8%">生日</th>
											<th width="10%">地址</th>
											<th width="8%">手机号</th>
											<th width="3%">状态</th>
											<th width="5%">创建时间</th>
											<th width="5%">修改时间</th>
											<th width="5%">登陆时间</th>
											<th width="3%">头像</th>
											<th width="5%">备注</th>
											<th width="7%">设为管理员</th>
											<th width="5%">操作</th>
										</tr>
									</thead>
									<tbody>

									</tbody>
								</table>

							</div>
							<div role="tabpanel" class="tab-pane" id="gly">
								<table class="table table-bordered">
									<thead>
										<tr>
											<th width="7%">序号</th>
											<th width="7%">级别</th>
											<th width="7%">状态</th>
											<th width="7%">用户名</th>
											<th width="10%">添加时间</th>
											<th width="10%">操作</th>
										</tr>
									</thead>
									<tbody>

									</tbody>
								</table>
							</div>
						</div>

					</div>

					<div role="tabpanel" class="tab-pane" id="profile">
						<div class="top ">
							<div class="input-group wxss">
								<input type="text" class="form-control" placeholder="请输入搜索内容">
								<span class="input-group-btn">
									<button class="btn btn-primary" type="button">
										<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									</button>
								</span>
							</div>
							<button type="button" class="btn btn-default add" onclick="addNewsBtn()">
								<!-- data-toggle="modal" data-target="#addnews" -->
								<img src="../img/jixutianjia.png" alt="">添加
							</button>
						</div>
						<table class="table table-bordered"
							style="height: 50px; table-layout: fixed">
							<thead>
								<tr>
									<th width="3%">序号</th>
									<th width="8%">标题</th>
									<th width="3%">作者</th>
									<th width="3%">来源</th>
									<th width="3%">分类</th>
									<th width="25%">内容</th>
									<th width="5%">视频</th>
									<th width="4%">浏览量</th>
									<th width="4%">评论量</th>
									<th width="4%">分享量</th>
									<th width="5%">创建时间</th>
									<th width="3%">热推</th>
									<th width="5%">操作</th>
								</tr>
							</thead>
							<tbody id="news">
							</tbody>
						</table>
						<div class="text-center  foot">
							<nav aria-label="Page navigation">
								<ul class="pagination">
									<li class="disabled"><a href="#" aria-label="Previous"><span
											aria-hidden="true">&laquo;</span></a></li>
									<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
									<li><a href="#">2<span class="sr-only">(current)</span></a></li>
									<li><a href="#">3<span class="sr-only">(current)</span></a></li>
									<li><a href="#">4<span class="sr-only">(current)</span></a></li>
									<li><a href="#">5<span class="sr-only">(current)</span></a></li>
									<li><a href="#" aria-label="Next"> <span
											aria-hidden="true">&raquo;</span>
									</a></li>
								</ul>
							</nav>
						</div>
					</div>
					<div role="tabpanel" class="tab-pane" id="messages">
						<div class="top ">
							<div class="input-group wxss">
								<input type="text" class="form-control" placeholder="请输入搜索内容">
								<span class="input-group-btn">
									<button class="btn btn-primary" type="button">
										<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									</button>
								</span>
							</div>
							<button class="btn btn-default add">
								<img src="../img/jixutianjia.png" alt="">添加
							</button>
						</div>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th width="3%">序号</th>
									<th width="8%">评论新闻</th>
									<th width="5%">评论用户</th>
									<th width="3%">类型</th>
									<th width="3%">评分</th>
									<th width="7%">评论内容</th>
									<th width="3%">状态</th>
									<th width="5%">是否删除</th>
									<th width="8%">评论时间</th>
									<th width="5%">操作</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
					<div role="tabpanel" class="tab-pane" id="settings">
						<div class="top ">
							<div class="input-group wxss">
								<input type="text" class="form-control" placeholder="请输入搜索内容">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">
										<img src="../img/fangdajing.png" alt="">
									</button>
								</span>
							</div>
							<button class="btn btn-default add">
								<img src="../img/jixutianjia.png" alt="">添加
							</button>
						</div>
						<!-- <table class="table table-bordered" style="heigth:100px !important">
							<thead>
								<tr>
									<th width="3%">序号</th>
									<th width="8%">标题</th>
									<th width="5%">来源</th>
									<th width="3%">分类</th>
									<th width="5%">浏览数量</th>
									<th width="5%">评论数量</th>
									<th width="5%">图片1</th>
									<th width="5%">图片2</th>
									<th width="5%">图片3</th>
									<th width="5%">视频</th>
									<th width="5%">创建时间</th>
									<th width="5%">修改时间</th>
									<th width="10%">内容</th>
									<th width="5%">操作</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table> -->
					</div>
					<div role="tabpanel" class="tab-pane" id="xwflgl">
						<div class="top ">
							<div class="input-group wxss">
								<input type="text" class="form-control" placeholder="请输入搜索内容">
								<span class="input-group-btn">
									<button class="btn btn-primary" type="button">
										<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									</button>
								</span>
							</div>
							<button class="btn btn-default add">
								<img src="../img/jixutianjia.png" alt="">添加
							</button>
						</div>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th width="3%">序号</th>
									<th width="3%">名称</th>
									<th width="5%">创建时间</th>
									<th width="3%">操作</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
				</div>

			</div>

		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="adduser" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">添加用户</h4>
				</div>
				<div class="modal-body">...</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="addnews" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">添加新闻</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="addNewsForm"
						action="/java_web_pro/NewsServlet?action=adminInsertNews"
						method="post">
						<div class="form-group">
							<label class="col-sm-2 control-label">类型</label>
							<div class="col-sm-8">
								<select id="typeid" name="typeid" class="form-control">
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">标题</label>
							<div class="col-sm-8">
								<input type="hidden" id="id" name="id" value="-1"> <input
									type="text" class="form-control" id="title" name="title"
									placeholder="标题" value="">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">来源</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="source"
									name="source" placeholder="来源" value="">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">作者</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="author"
									name="author" placeholder="作者" value="">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">内容</label>
							<div class="col-sm-9">
								<div>
									<script id="editor" type="text/plain"></script>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">热点</label>
							<div class="col-sm-8">
								<label class="radio-inline"> <input type="radio"
									name="ifHot" id="yes" value="true">是
								</label> <label class="radio-inline"> <input type="radio"
									name="ifHot" id="no" value="false" checked> 否
								</label>

							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						onclick="addNewsSure()">保存</button>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	/* 	$("#myModal").modal('show'); */

	//实例化编辑器
	var ue = UE.getEditor('editor', {
		//focus时自动清空初始化时的内容
		autoClearinitialContent : true,
		//关闭字数统计
		wordCount : false,
		//关闭elementPath
		elementPathEnabled : false,
		//默认的编辑区域高度
		initialFrameWidth : 700,
		initialFrameHeight : 300,
		focus:true
	//更多其他参数，请参考ueditor.config.js中的配置项
	});
</script>
</html>