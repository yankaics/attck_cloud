<%@ include file="../public/header.jsp"%>
<%@ include file="../public/nav.jsp"%>
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			用户列表 <small>User List</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">用户列表</li>
		</ol>
	</section>
	<section class="content">
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-header">
						<button class="btn btn-block btn-primary" id="addUser"
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
								<th style="width: 18%; text-align: center;">帐号</th>
								<th style="width: 15%; text-align: center;">昵称</th>
								<th style="width: 10%; text-align: center;">类型</th>
								<th style="width: 10%; text-align: center;">状态</th>
								<th style="width: 20%; text-align: center;">注册时间</th>
								<th style="width: 20%; text-align: center;">登陆时间</th>
								<th style="text-align: center;">操作</th>
							</tr>
						</table>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->
			</div>
		</div>
	</section>
</div>
<div class="modal fade" id="add_user">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">添加用户</h4>
			</div>
			<div class="modal-body">
				<p>
					<input type="text" class="form-control" id="userEmail"
						placeholder="请输入邮箱帐号">
				</p>
				<p>
					<input type="password" class="form-control" id="userPass"
						placeholder="请输入密码">
				</p>

				<p>
					<input type="text" class="form-control" id="nikeName"
						placeholder="请输入昵称">
				</p>

				<p>类型：
					<label class="radio-inline"> <input type="radio"
						name="types" value="1">管理员
					</label> <label class="radio-inline"> <input type="radio"
						name="types" value="2" checked="checked">普通用户 
				</p>

				<p>状态：
					<label class="radio-inline"> <input type="radio"
						name="status" value="1" checked="checked">显示
					</label> <label class="radio-inline"> <input type="radio"
						name="status" value="2">关闭 
				</p>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" id="btnAddUser">添加用户</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<div class="modal fade" id="update_user">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">修改用户</h4>
			</div>
			<div class="modal-body">
				<p>
					<input type="text" class="form-control" id="userEmails"
						placeholder="请输入邮箱帐号">
				</p>
				<p>
					<input type="password" class="form-control" id="userPasss"
						placeholder="请输入密码">
				</p>

				<p>
					<input type="text" class="form-control" id="nikeNames"
						placeholder="请输入昵称">
				</p>

				<p>
					<label class="radio-inline"> <input type="radio"
						name="typess" value="1">管理员
					</label> <label class="radio-inline"> <input type="radio"
						name="typess" value="2" checked="checked">普通用户 
				</p>

				<p>
					<label class="radio-inline"> <input type="radio"
						name="statuss" value="1" checked="checked">可用
					</label> <label class="radio-inline"> <input type="radio"
						name="statuss" value="2">禁用 
				</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" id="btnUpdateUser">确定修改</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<%@ include file="../public/footer.jsp"%>
<script src="<%=basePath%>mod/user/index.js"></script>

