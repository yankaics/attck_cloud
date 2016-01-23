      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="<%=basePath%>libs/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
              <p>${sessionScope.loginName}</p>
              <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
          </div>
          <!-- search form -->
          <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </form>
          <!-- /.search form -->
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <li id="home" class="home">
              <a href="<%=basePath%>home/index.html">
                <i class="fa fa-dashboard"></i> <span>攻云主页</span> 
              </a>
            </li>
			
        <li id="scan" class="treeview">
              <a href="#">
                <i class="fa fa-pie-chart"></i>
                <span>扫描模块</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li id="port"><a href="<%=basePath%>scan/port.html"><i class="fa fa-circle-o"></i> 端口扫描</a></li>
                <li id="web"><a href="<%=basePath%>scan/web.html"><i class="fa fa-circle-o"></i> 网站扫描</a></li>
                <!-- <li><a href="<%=basePath%>scan/web.html"><i class="fa fa-circle-o"></i> IP 扫描</a></li> -->
                <!-- <li><a href="<%=basePath%>scan/web.html"><i class="fa fa-circle-o"></i> 指纹扫描</a></li> -->
              </ul>
            </li>

           <li id="fishing" class="treeview">
              <a href="#">
                <i class="fa fa-pie-chart"></i>
                <span>钓鱼模块</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
               <li id="xss"><a href="<%=basePath%>fishing/xss.html"><i class="fa fa-circle-o"></i> xss平台</a></li>
                <!-- <li><a href="pages/charts/chartjs.html"><i class="fa fa-circle-o"></i> 网页钓鱼</a></li> -->
              </ul>
            </li>

            <!-- <li class="treeview">
              <a href="#">
                <i class="fa fa-pie-chart"></i>
                <span>社工模块</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="pages/charts/chartjs.html"><i class="fa fa-circle-o"></i> 搜索</a></li>
              </ul>
            </li>

            <li class="treeview">
              <a href="#">
                <i class="fa fa-pie-chart"></i>
                <span>注入模块</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="pages/charts/chartjs.html"><i class="fa fa-circle-o"></i> 注入扫描</a></li>
                <li><a href="pages/charts/morris.html"><i class="fa fa-circle-o"></i> 字典配置</a></li>
              </ul>
            </li>


            <li class="treeview">
              <a href="#">
                <i class="fa fa-pie-chart"></i>
                <span>木马模块</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="pages/charts/chartjs.html"><i class="fa fa-circle-o"></i> 添加木马</a></li>
                <li><a href="pages/charts/morris.html"><i class="fa fa-circle-o"></i> 后端管理</a></li>
              </ul>
            </li>



            <li class="treeview">
              <a href="#">
                <i class="fa fa-pie-chart"></i>
                <span>密码模块</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="pages/charts/chartjs.html"><i class="fa fa-circle-o"></i> 密码加密</a></li>
                <li><a href="pages/charts/morris.html"><i class="fa fa-circle-o"></i> MD5破解</a></li>
                <li><a href="pages/charts/morris.html"><i class="fa fa-circle-o"></i> 高级算法</a></li>
              </ul>
            </li>

            <li class="treeview">
              <a href="#">
                <i class="fa fa-pie-chart"></i>
                <span>漏洞模块</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="pages/charts/chartjs.html"><i class="fa fa-circle-o"></i> 漏洞预警</a></li>
                <li><a href="pages/charts/morris.html"><i class="fa fa-circle-o"></i> 漏洞利用</a></li>
                <li><a href="pages/charts/morris.html"><i class="fa fa-circle-o"></i> 高级算法</a></li>
              </ul>
            </li>

            <li class="treeview">
              <a href="#">
                <i class="fa fa-pie-chart"></i>
                <span>XSS平台</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="pages/charts/chartjs.html"><i class="fa fa-circle-o"></i> JS模块</a></li>
                <li><a href="pages/charts/morris.html"><i class="fa fa-circle-o"></i> 任务列表</a></li>
              </ul>
            </li>

            <li class="treeview">
              <a href="#">
                <i class="fa fa-pie-chart"></i>
                <span>WEBSHELL</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="pages/charts/chartjs.html"><i class="fa fa-circle-o"></i> 添加新站</a></li>
                <li><a href="pages/charts/morris.html"><i class="fa fa-circle-o"></i> shell管理</a></li>
              </ul>
            </li> -->

            <li class="header">LABELS</li>
            <!-- <li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>云空间</span></a></li> -->
            <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>通知</span></a></li>
            <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>个人设置</span></a></li>
          </ul>
        </section>
        <!-- /.sidebar -->
      </aside>