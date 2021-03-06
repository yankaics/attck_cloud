$("#scan").attr("class", "active");
$("#web").attr("class", "active");

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
        url: 'delWeb.html',
        dataType: 'json',
        data: {
            id: id
        },
        success: function(data) {
            history.go(0);
        }
    });
}

function see(id) {
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


$("#addWeb").click(function() {
    $('#modal_id').modal();
});


$("#startWeb").click(function() {
    var url = $("#webUrl").val();
    $.ajax({
        url: 'addWeb.html',
        dataType: 'json',
        data: {
            url: url
        },
        success: function(data) {
            console.log(data);
            history.go(0);
        }
    });
});

$.ajax({
    url: 'queryWeb.html',
    dataType: 'json',
    success: function(data) {
        var d = data.model.result;
        for (var i = 0; i < d.length; i++) {
            var time = getLocalTime(d[i].create_time);
            var _h = html(d[i].id, d[i].url, time);
            $("#tablelist").append(_h);
        }
    }
});

function html(id, url, time, port) {
    var _h = '';
    _h += '<tr>';
    _h += '<td style="text-align: center;">' + id + '</td>';
    _h += '<td style="text-align: center;">' + url + '</td>';
    _h += '<td style="text-align: center;">' + time + '</td>';
    _h += '<td style="text-align: center;"><span style="cursor: pointer;color: #3C8DBC; font-weight: bold;" onclick="see(' + id + ')">点击查看</span></td>';
    _h += '<td style="text-align: center;"><span class="label label-danger" style=" cursor: pointer;" onclick="del(' + id + ')">delete</span></td>';
    _h += '</tr>';
    return _h;
}
