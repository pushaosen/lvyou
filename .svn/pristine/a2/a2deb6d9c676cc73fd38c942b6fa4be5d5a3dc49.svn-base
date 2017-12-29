/* ----------------------- WoKit ----------------------- */
/**
 * WoKit为js通用工具类
 */
var WoKit = {};

WoKit.basePath = '/';

WoKit.mainFrameSelector = ".woMainFrame";

/**
 * cfg = { url : '', data : { key1 : val1, key2 : val2} }
 */
WoKit.loadMainFrame = function (cfg) {
	WoAjaxKit.load({
		domSelector : WoKit.mainFrameSelector,
		url : cfg.url,
		data : cfg.data,
		success : function () {
			$(WoKit.mainFrameSelector).css('display', 'block');
		}
	});
};

WoKit.destroyMainFrame = function() {
	$(WoKit.mainFrameSelector).css('display', 'none');
	$(WoKit.mainFrameSelector).html('');
};

WoKit.isEmpty = function(val) {
	return (val == undefined || val == "" || val == null);
};

/**
 * cfg = { title : '', msg : '', icon : 'icon-warning text-red'/'icon-info' }
 */
WoKit.showMenu = function(cfg) {
	var cls = '.woDropMenu';
	// 显示对话框
	$(cls).css('display', 'block');
	// 设置标题文本及样式
	// var title = $([ cls, '.dialog-head', 'strong' ].join(' '));
	// title.attr('class', cfg.icon);
	// title.text(cfg.title);
	// // 设置消息文本
	// $([ cls, '.dialog-body' ].join(' ')).text(cfg.msg);
	// 设置关闭按钮js
	var closeJs = [ "$('", cls, "').css('display', 'none')" ].join('');
	// $([ cls, 'button' ].join(' ')).attr('onclick', closeJs);
	// $([ cls, 'span' ].join(' ')).attr('onclick', closeJs);
	$(cls).attr('onclick', closeJs);
};

/**
 * cfg = { title : '', msg : '', icon : 'icon-warning text-red'/'icon-info' ,
 * type:'confirm', fn:function () {} }
 */
WoKit.showMsg = function(cfg) {
	var confirmBtn = '';
	var cancelText = '关闭';
	if (cfg.type && cfg.type == 'confirm') {
		confirmBtn = '<button class="button bg-main" id="woMsgButtonOK">确定</button>  ';
		cancelText = '取消';
	}
	var html = [
			'<div class="woErrorMessageDialog">',
			'<div class="dialog open">',
			'<div class="dialog-head">',
			'<span class="dialog-close close rotate-hover"></span><strong> '
					+ cfg.title + '</strong>', '</div>',
			'<div class="dialog-body ' + cfg.icon + '"> ' + cfg.msg + '</div>',
			'<div class="dialog-foot">', confirmBtn,
			'<button class="dialog-close button">' + cancelText + '</button>',
			'</div>', '</div>', '</div>' ].join('');
	$(html).appendTo("body");
	$(".woErrorMessageDialog").css('display', 'block');
	$(".woErrorMessageDialog").find('.dialog-close').attr('onclick',
			'WoKit.hideMsg();');
	if (cfg.fn) {
		$('#woMsgButtonOK').click(cfg.fn);
	}
};

WoKit.hideMsg = function() {
	$(".woErrorMessageDialog").remove();
};

WoKit.showConfirm = function(msg, fn) {
	WoKit.showMsg({
		title : ' 请确认',
		icon : 'icon-question-circle text-yellow',
		msg : msg,
		type : 'confirm',
		fn : fn
	});
};

WoKit.showInfo = function(msg) {
	WoKit.showMsg({
		title : ' 信息',
		icon : 'icon-info',
		msg : msg
	});
};

WoKit.showWarn = function(msg) {
	WoKit.showMsg({
		title : ' 错误',
		icon : 'icon-warning text-yellow',
		msg : msg
	});
};

WoKit.closeWindow = function(confirm) {
	var closeWin = function() {
		window.opener = null;
		window.open('', '_self');
		window.close();
	};
	if (confirm) {
		WoKit.showConfirm('确定要退出当前页面吗？', closeWin);
	} else {
		closeWin();
	}
};

WoKit.validateForm = function(domSel) {
	if (!domSel) {
		domSel = 'form';
	}
	var $hideplaceholder = function(element) {
		if ($(element).data("pintuerholder")) {
			$(element).val("");
			$(element).css("color", $(element).data("pintuerholder"));
			$(element).removeData("pintuerholder");
		}
	};
	$(domSel)
			.find(
					'input[data-validate],textarea[data-validate],select[data-validate]')
			.trigger("blur");
	$(domSel).find('input[placeholder],textarea[placeholder]').each(function() {
		$hideplaceholder($(this));
	});
	var numError = $(domSel).find('.check-error').length;
	if (numError) {
		return false;
	}
	return true;
};

WoKit.getFormData = function(domSel) {
	if (!domSel) {
		domSel = 'form';
	}
	var d = {};
	var t = $(domSel).serializeArray();
	console.log(t);
	$.each(t, function(i, field) {
		if (d[field.name]) {
			d[field.name] = d[field.name] + "," + field.value;
		} else {
			d[field.name] = field.value;
		}
	});
	return d;
};

WoKit.getListSelectedIds = function(domSelector) {
	var ids = WoKit.getFormData(domSelector)['woSelectedIds'];
	if (!ids) {
		return '';
	}
	return ids;
};

/**
 * event：点击事件对象；btn：按钮dom元素。
 */
WoKit.showDropMenu = function(event, btn) {
	event.stopPropagation();
	var menu = $(btn).next().find('.drop-menu');
	menu.css('display', 'block');
};

WoKit.hideDropMenu = function() {
	$('.drop-menu').css('display', 'none');
};

/**
 * keyVal：对应行的keyvalue值； event：点击事件对象； btn：按钮dom元素
 * 
 */
WoKit.showInLineButtons = function(keyVal, event, btn) {
	WoKit.showDropMenu(event, btn);
};

/**
 * 将newVal拼接到oldVals前面，以逗号隔开.返回结果{newVal:,
 * delVal}，newVal为最终结果，delVal为舍弃的值.返回值的最大值个数限制为valLenMax，超过的部分要舍弃掉.
 * 例如：oldVals=1,2,3,5, newVal=9,9, valLenMax=4(valLenMax的值必须为newVal值个数的整数倍),
 * 则最终结果为9,9,1,2，值3,5会被舍弃
 */
WoKit.addValue = function(oldVals, newVal, valLenMax) {
	var re = {
		newVal : newVal,
		delVal : ''
	};
	if (!oldVals || oldVals == "") {
		return re;
	}
	// value的值可能是多个逗号隔开的字符
	var valLen = newVal.split(',').length;
	var valArray = oldVals.split(",");
	// 如果newVal在oldVals中，则直接返回oldVals
	for (var i = 0; i < valArray.length / valLen; i++) {
		var oldVal = valArray.slice(i * valLen, i * valLen + valLen).toString();
		if (oldVal == newVal) {
			re.newVal = oldVals;
			return re;
		}
	}
	// 如果oldVals没有达到valLenMax限制，或者valLenMax无限制，则将newVal插入到oldVals之前并返回。
	if (valArray.length < valLenMax || !valLenMax || valLenMax < 1) {
		re.newVal = newVal + ',' + oldVals;
		return re;
	}
	// 返回oldVals最后一个值，作为舍弃值
	re.delVal = valArray.slice(valArray.length - valLen).toString();
	// 获取oldVals删除最后一个值之后的字符串
	var oldVarsDelLast = valArray.slice(0, -valLen).toString();
	if (oldVarsDelLast == "") {
		re.newVal = newVal;
	} else {
		re.newVal = newVal + ',' + oldVarsDelLast;
	}
	return re;
};

/**
 * if oldVals is 2,3,4 and newVal is 3 then return 2,4
 */
WoKit.removeValue = function(oldVals, newVal) {
	if (!oldVals || oldVals == "") {
		return '';
	}
	var vals = oldVals.toString().split(",");
	var newVals = "";
	var valLen = newVal.split(",").length;
	for (var i = 0; i < vals.length / valLen; i++) {
		var oldVal = vals.slice(i * valLen, i * valLen + valLen).toString();
		if (oldVal == newVal) {
			continue;
		}
		newVals = newVals + ',' + oldVal;
	}
	if (newVals == "") {
		return newVals;
	}
	return newVals.substring(1);
};

var WoAjaxKit = {};

/**
 * ajax请求json数据。参数描述如下： cfg = { url : '/xx/yy', data : {key1 : val1, key2 :
 * val2}, success : function (json) {}, error : function (json) {} };
 */
WoAjaxKit.requestJson = function(cfg) {
	$.ajax({
		type : "post",
		url : cfg.url,
		dataType : "json",
		data : cfg.data,
		success : function(json) {
			if (json.code == 1) {
				if (cfg.success) {
					var showMsg = cfg.success(json);
					if (!showMsg) {
						return;
					}
				}
			} else {
				if (cfg.error) {
					var showMsg = cfg.error(json);
					if (!showMsg) {
						return;
					}
				}
			}
			if (json.code == 1) {
				WoKit.showInfo(json.msg);
			} else {
				WoKit.showWarn(json.msg);
			}
		},
		error : function(XmlHttpRequest, textStatus, errorThrown) {
			var msg = "操作失败！";
			if (XmlHttpRequest.responseJSON) {
				msg = XmlHttpRequest.responseJSON.message;
			}
			if (cfg.error) {
				var showMsg = cfg.error({
					code : 0,
					msg : msg
				});
				if (!showMsg) {
					return;
				}
			}
			WoKit.showWarn(msg);
		}
	});
}

/**
 * ajax请求json数据。参数描述如下： cfg = { url : '/xx/yy', data : {key1 : val1, key2 :
 * val2}, success : function () {}, domSelector : '#id'};
 */
WoAjaxKit.load = function(cfg) {
	WoKit.showInfo('正在加载数据...');
	$(cfg.domSelector).load(cfg.url, cfg.data,
			function(responseTxt, statusTxt, xhr) {
				// 重新加载拼图js，使相应新增的dom响应预定义的事件
				pintuer();
				if (statusTxt == "error") {
					WoKit.showWarn("数据加载失败！");
				} else {
					if (cfg.success) {
						cfg.success();
					}
					WoKit.showInfo('数据加载成功！');
					setTimeout("WoKit.hideMsg();", 500);
				}
			});
};

WoAjaxKit.submitForm = function(domSel, cfg) {
	if (cfg.validateForm != false) {
		if (!WoKit.validateForm(domSel)) {
			return;
		}
	}
	// timestamp=' + new Date().getTime();
	if (cfg.data) {
		cfg.data.timestamp = new Date().getTime();
	}
	// 防止事件多次绑定，如果多次绑定，则submit时，会调用多次
	$(domSel).unbind();
	$(domSel).on('submit', function(e) {
		e.preventDefault(); // <-- important
		$(domSel).ajaxSubmit(cfg);
		return false;
	});
	$(domSel).submit();
};