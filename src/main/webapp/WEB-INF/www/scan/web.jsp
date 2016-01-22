<%@ include file="../public/header.jsp"%>
<%@ include file="../public/nav.jsp"%>
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			网站扫描 <small>Web Scan</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">WebScan</li>
		</ol>
	</section>
	<section class="content">

		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-header">
						<button class="btn btn-block btn-primary"  id="addWeb" style="width: 74px;">Add
							+</button>
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
								<th style="width: 20%; text-align: center;">Url</th>
								<th style="width: 19%; text-align: center;">Time</th>
								<th style="width: 27%; text-align: center;">Detail</th>
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
						<h3 class="box-title">Web Scan Redname</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<blockquote>
							<p>关于网站扫描</p>
							<small>可能带WWW 和 不带WWW 不是一个网站</small>
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
				<h4 class="modal-title">web扫描</h4>
			</div>
			<div class="modal-body">
				<p>
					<input type="text" class="form-control" id="webUrl"
						placeholder="请输入URL">
				</p>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" id="startWeb">开始扫描</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<div class="modal fade" id="urlPath_list">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">web扫描存在路径</h4>
			</div>
			<div class="modal-body">
						
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" id="startWeb">开始扫描</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<%@ include file="../public/footer.jsp"%>
<script src="<%=basePath%>mod/scan/web.js"></script>
