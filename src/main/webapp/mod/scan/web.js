$("#scan").attr("class", "active");
$("#web").attr("class", "active");

function getLocalTime(nS) {
	var date = new Date(nS);
	Y = date.getFullYear() + '-';
	M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date
			.getMonth() + 1)
			+ '-';
	D = date.getDate() + ' ';
	h = date.getHours() + ':';
	m = date.getMinutes();
	return Y + M + D + h + m;
}

$("#addWeb").click(function() {
	$('#modal_id').modal();
});

$("#cktd").click(function() {
	alert("x");
	$('#urlPath_list').modal();
});

$("#startWeb").click(function() {
	var url = $("#webUrl").val();
	$.ajax({
		url : 'addWeb.html',
		dataType : 'json',
		data : {
			url : url
		},
		success : function(data) {
			console.log(data);
			history.go(0);
		}
	});
});

$.ajax({
	url : 'queryWeb.html',
	dataType : 'json',
	success : function(data) {
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
	_h += '<td style="text-align: center;" class="cktd"><span class="ckDetail" style=" cursor: pointer;color: #3C8DBC; font-weight: bold;" data-id="'
			+ id + '">点击查看</span></td>';
	_h += '<td style="text-align: center;"><span class="label label-danger">delete</span></td>';
	_h += '</tr>';
	return _h;
}
