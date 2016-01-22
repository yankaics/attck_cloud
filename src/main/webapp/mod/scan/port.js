$("#scan").attr("class", "active");
$("#port").attr("class", "active");

function getLocalTime(nS) {
    var date = new Date(nS);
    Y = date.getFullYear() + '-';
    M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
    D = date.getDate() + ' ';
    h = date.getHours() + ':';
    m = date.getMinutes();
    return Y + M + D + h + m;
}

$("#addPort").click(function() {
    $('#modal_id').modal();
});

$("#startPort").click(function() {
    var ip = $("#portIp").val();
    var ports = $("#ports").val();
    $.ajax({
        url: 'addPort.html',
        dataType: 'json',
        data: {
            ip: ip,
            ports: ports
        },
        success: function(data) {
            console.log(data);
            history.go(0);
        }
    });
});

$.ajax({
    url: 'queryPort.html',
    dataType: 'json',
    success: function(data) {
        var d = data.model.result;
        for (var i = 0; i < d.length; i++) {
            var time = getLocalTime(d[i].create_time);
            var _h = html(d[i].id, d[i].ip, time, d[i].port);
            $("#tablelist").append(_h);
        }
    }
});

function html(id, ip, time, port) {
    var _h = '';
    _h += '<tr>';
    _h += '<td style="text-align: center;">' + id + '</td>';
    _h += '<td style="text-align: center;">' + ip + '</td>';
    _h += '<td style="text-align: center;">' + time + '</td>';
    _h += '<td style="text-align: center;">' + port + '</td>';
    _h += '<td style="text-align: center;"><span class="label label-danger">delete</span></td>';
    _h += '</tr>';
    return _h;
}
