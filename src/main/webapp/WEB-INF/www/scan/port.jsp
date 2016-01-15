<%@ include file="../public/header.jsp"%>
<%@ include file="../public/nav.jsp"%>
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			端口扫描 <small>Port Scan</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">PortScan</li>
		</ol>
	</section>
	<section class="content">

		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-header">
						<button class="btn btn-block btn-primary" id="addPort"
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
								<th style="width: 10%; text-align: center;">Ip</th>
								<th style="width: 11%; text-align: center;">Time</th>
								<th style="width: 67%; text-align: center;">Port</th>
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
						<h3 class="box-title">Port redname</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<blockquote>
							<p>关于端口扫描</p>
							<small>端口,计算机端口</small>
						</blockquote>
						<dl class="dl-horizontal">
							<dt>80/8080/3128/8081/9080</dt>
							<dd>HTTP协议代理服务器常用端口号</dd>
							<dt>1080</dt>
							<dd>SOCKS代理协议服务器常用端口号</dd>
							<dt>21</dt>
							<dd>FTP（文件传输）协议代理服务器常用端口号</dd>
							<dt>22</dt>
							<dd>SSH（安全登录）、SCP（文件传输）、端口重定向，默认的端口号</dd>
							<dt>23</dt>
							<dd>Telnet（远程登录）协议代理服务器常用端口</dd>
							<dt>80/tcp</dt>
							<dd>HTTP服务器，默认的端口号（木马Executor开放此端口）</dd>
							<dt>443/tcp 443/udp</dt>
							<dd>HTTPS（securely transferring web pages）服务器，默认的端口</dd>
							<dt>23/tcp</dt>
							<dd>Telnet（不安全的文本传送），默认端口号为（木马Tiny Telnet Server所开放的端口）</dd>
							<dt>21/tcp</dt>
							<dd>FTP，默认的端口（木马Doly Trojan、Fore、Invisible
								FTP、WebEx、WinCrash和Blade Runner所开放的端口）</dd>
							<dt>69/udp</dt>
							<dd>TFTP（Trivial File Transfer Protocol ），默认的端口号；</dd>
							<dt>22/tcp</dt>
							<dd>SSH（安全登录）、SCP（文件传输）、端口重定向，默认的端口</dd>
							<dt>25/tcp</dt>
							<dd>SMTP Simple Mail Transfer Protocol
								(E-mail)，默认的端口号（木马Antigen、Email Password Sender、Haebu
								Coceda、Shtrilitz Stealth、WinPC、WinSpy都开放这个端口）</dd>
							<dt>110/tcp</dt>
							<dd>POP3 Post Office Protocol (E-mail) ，默认的端口号</dd>
							<dt>7001</dt>
							<dd>WebLogic，默认的端口号</dd>
							<dt>9080</dt>
							<dd>WebSphere应用程序，默认的端口号</dd>
							<dt>9090</dt>
							<dd>WebSphere管理工具，默认的端口号</dd>
							<dt>8080</dt>
							<dd>JBOSS，默认的端口号，tomcat默认端口</dd>
							<dt>3389</dt>
							<dd>WIN2003远程登陆，默认的端口号</dd>
							<dt>8081</dt>
							<dd>Symantec AV/Filter for MSE ,默认端口</dd>
							<dt>1521</dt>
							<dd>Oracle 数据库，默认的端口号</dd>
							<dt>1158</dt>
							<dd>ORACLE EMCTL，默认的端口号</dd>
							<dt>8080</dt>
							<dd>Oracle XDB（ XML 数据库），默认的端口</dd>
							<dt>2100</dt>
							<dd>Oracle XDB FTP服务，默认的端口</dd>
							<dt>1433/tcp 1433/udp</dt>
							<dd>MS SQL*SERVER数据库server，默认的端口</dd>
							<dt>1434/tcp 1434/udp</dt>
							<dd>MS SQL*SERVER数据库monitor，默认的端口</dd>
							<dt>1080/udp</dt>
							<dd>QQ，默认的端口号</dd>
							<dt>3306</dt>
							<dd>Mysql，默认的端口号</dd>
						</dl>
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
				<h4 class="modal-title">端口扫描</h4>
			</div>
			<div class="modal-body">
				<p>
					<input type="text" class="form-control" id="portIp"
						placeholder="请输入IP  列如：127.0.0.1">
				</p>
				<p>
					<input type="text" class="form-control" id="ports"
						value="80,8080,8081,8082,3306,22,21">
				</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" id="startPort">开始扫描</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->
<%@ include file="../public/footer.jsp"%>
<script src="<%=basePath%>mod/scan/port.js"></script>
