$("#userList").attr("class", "active");

function getLocalTime(nS) {
    var date = new Date(nS);
    Y = date.getFullYear() + '-';
    M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date
        .getMonth() + 1) + '-';
    D = date.getDate() + ' ';
    h = date.getHours() + ':';
    m = date.getMinutes();
    return Y + M + D + h + m;
}

function del(id) {
    $.ajax({
        url: 'delUser.html',
        dataType: 'json',
        data: {
            id: id
        },
        success: function(data) {
            history.go(0);
        }
    });
}

function update(id) {
    $.ajax({
        url: 'findWeb.html',
        dataType: 'json',
        data: {
            id: id
        },
        success: function(data) {
            var d = data.model.result[0];
            var urls = d.url_path.split(",");
            var _h = '';
            for (var i = 0; i < urls.length; i++) {
                _h += '<p><a href="' + urls[i] + '">' + urls[i] + '</a></p>';
            };
            $('#urlPaths').html(_h);
            $('#urlPath_list').modal();
        }
    });
}


$("#addUser").click(function() {
    $('#add_user').modal();
});

$("#btnAddUser").click(function() {
    var account = $("#userEmail").val();
    var passwd = $("#userPass").val();
    var nikename = $("#nikeName").val();
    var type = $("input[name='types']:checked").val();
    var status = $("input[name='status']:checked").val();
    $.ajax({
        url: 'addPort.html',
        type: 'POST',
        dataType: 'json',
        data: {
            account: account,
            passwd: passwd,
            nikename: nikename,
            type: type,
            status: status
        },
        success: function(data) {
            history.go(0);
        }
    });
});

$.ajax({
    url: 'queryUser.html',
    dataType: 'json',
    success: function(data) {
        var d = data.model.result;
        for (var i = 0; i < d.length; i++) {
            var create_time = getLocalTime(d[i].create_time);
            var last_login_time = getLocalTime(d[i].last_login_time);
            var _h = html(d[i].id, d[i].account, d[i].nikeName, d[i].type, d[i].status, create_time, last_login_time);
            $("#tablelist").append(_h);
        }
    }
});

function html(id, account, nikeName, type, status, create_time, last_login_time) {
    var _h = '';
    _h += '<tr>';
    _h += '<td style="text-align: center;">' + id + '</td>';
    _h += '<td style="text-align: center;">' + account + '</td>';
    _h += '<td style="text-align: center;">' + nikeName + '</td>';
    if (type == "1") {
        _h += '<td style="text-align: center;">管理员</td>';
    } else if (type == "2") {
        _h += '<td style="text-align: center;">普通 用户</td>';
    }

    if (status == "1") {
        _h += '<td style="text-align: center;">可用</td>';
    } else if (status == "2") {
        _h += '<td style="text-align: center;">禁用</td>';
    }
    _h += '<td style="text-align: center;">' + create_time + '</td>';
    _h += '<td style="text-align: center;">' + last_login_time + '</td>';
    _h += '<td style="text-align: center;"><span class="label label-danger" style=" cursor: pointer;" onclick="del(' + id + ')">delete</span></td>';
    // <span class="label label-warning" style=" cursor: pointer;" onclick="update(' + id + ')">update</span>&nbsp;&nbsp;
    _h += '</tr>';
    return _h;
}
