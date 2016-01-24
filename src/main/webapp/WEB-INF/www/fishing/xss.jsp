<%@ include file="../public/header.jsp"%>
<%@ include file="../public/nav.jsp"%>
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			XSS平台 <small>XSS Platform</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">XSS平台</li>
		</ol>
	</section>
	<section class="content">

		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-header">
						<button class="btn btn-block btn-primary" id="addXss"
							style="width: 74px;">Add +</button>
						<div class="box-tools">
							<div class="input-group" style="width: 150px;">
								<input type="text" name="table_search"
									class="form-control input-sm pull-right" placeholder="Search">
								<div class="input-group-btn">
									<button class="btn btn-sm btn-default">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
						</div>
					</div>
					<!-- /.box-header -->
					<div class="box-body table-responsive no-padding">
						<table class="table table-hover" id="tablelist">
							<tr>
								<th style="width: 1%; text-align: center;">#</th>
								<th style="width: 10%; text-align: center;">Name</th>
								<th style="width: 20%; text-align: center;">Desc</th>
								<th style="width: 10%; text-align: center;">Type</th>
								<th style="width: 10%; text-align: center;">Num</th>
								<th style="width: 20%; text-align: center;">Detail</th>
								<th style="width: 20%; text-align: center;">Time</th>
								<th style="text-align: center;">Operation</th>
							</tr>
						</table>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<div class="box box-solid">
					<div class="box-header with-border">
						<i class="fa fa-text-width"></i>
						<h3 class="box-title">XSS Platform Redname</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<blockquote>
							<p>关于XSS平台</p>
							<small>目前只支持Cookies获取</small>
						</blockquote>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->
			</div>
		</div>
	</section>
</div>
<div class="modal fade" id="modal_id">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">XSS平台</h4>
			</div>
			<div class="modal-body">
				<p>
					<input type="text" class="form-control" id="xssTitle"
						placeholder="请输入项目名">
				</p>
				<p>
					<textarea class="form-control" rows="3" id="xssDesc"
						placeholder="描述"></textarea>
				</p>

				<p>
					<label class="radio-inline"> <input type="radio"
						name="types" value="1" checked="checked">cookies盗取
					</label>
					<!--  <label class="radio-inline"> <input type="radio"
						name="types" value="2">基础认证钓鱼
					</label> <label class="radio-inline"> <input type="radio"
						name="types" value="3">浏览器明文密码
					</label> -->
				</p>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" id="addXsss">添加</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<div class="modal fade" id="xssInfo_list">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">XSS Info</h4>
			</div>
			<div class="modal-body" id="xssInfo_lists">

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<div class="modal fade" id="xssConfigInfo">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">XSS Config</h4>
			</div>
			<div class="modal-body" id="xssConfigInfos"><p>代码：</p></div>
						
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->
<input id='urlPath' type=hidden value="<%=basePath%>">
<input id='user_id' type=hidden value="${sessionScope.id}">
<%@ include file="../public/footer.jsp"%>
<script src="<%=basePath%>mod/fishing/xss.js"></script>
