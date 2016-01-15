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
						<button class="btn btn-block btn-primary" style="width: 74px;">Add
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
						<table class="table table-hover">
							<tr>
								<th style="width: 1%; text-align: center;">#</th>
								<th style="width: 20%; text-align: center;">Url</th>
								<th style="width: 19%; text-align: center;">Time</th>
								<th style="width: 15%; text-align: center;">Status</th>
								<th style="width: 27%; text-align: center;">Detail</th>
								<th style="text-align: center;">Operation</th>
							</tr>
							<tr>
								<td style="text-align: center;">1</td>
								<td style="text-align: center;">www.baidu.com</td>
								<td style="text-align: center;">2016-01-02 22:24</td>
								<td style="text-align: center;"><span
									class="label label-success">Loding ...</span></td>
								<td style="text-align: center;"><span
									style="color: #3C8DBC; font-weight: bold;">点击查看</span></td>
								<td style="text-align: center;"><span
									class="label label-danger">delete</span></td>
							</tr>
							<tr>
								<td style="text-align: center;">2</td>
								<td style="text-align: center;">www.hackcode.com</td>
								<td style="text-align: center;">2016-01-02 10:12</td>
								<td style="text-align: center;"><span
									class="label label-warning">Success</span></td>
								<td style="text-align: center;"><span
									style="color: #3C8DBC; font-weight: bold;">点击查看</span></td>
								<td style="text-align: center;"><span
									class="label label-danger">delete</span></td>
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
<%@ include file="../public/footer.jsp"%>
<script src="<%=basePath%>mod/scan/web.js"></script>
