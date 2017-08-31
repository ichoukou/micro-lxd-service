/** ************************公共部分***************************** */
$(function() {

	// 初始化

	// 绑定回车事件
	enterSubmit('#loginForm', function() {
		Login.login();
	});

});

/** **********************登录******************************* */
Login = function() {
	showMsg: document.getElementById("showMsg");
};

// 用户登录
Login.login = function() {

	systemLoading('#loginForm', true);

	// 校验输入信息
	if (checkLogin()) {

		var formId = "loginForm";
		var url = "/login";

		httpPost(formId, url, function(data) {

			window.location.href = "/bench";

		}, function(data) {

			// 返回码
			var returnCode = data.returnCode;

			var returnMsg = data.returnMsg;

			$("#msgTip").empty().html(returnMsg).show();

			systemLoaded('#loginForm');
		});
	} else {
		systemLoaded('#loginForm');
	}
	// 解除loading
	// systemLoaded('', false);

};

// 校验登录信息
checkLogin = function() {

	var username = $("#username").val();
	var password = $("#password").val();

	if (!username) {
		$("#msgTip").empty().html("用户名不能为空!").show();
		return false;
	} else {
		$(".error-text text-left").hide();
	}

	if (!password) {
		$("#msgTip").empty().html("密码不能为空!").show();
		return false;
	} else {
		$(".error-text text-left").hide();
	}


	return true;
};

/** **********************公共部分******************************* */
/**
 * 绑定回车提交
 * 
 * @param formId
 * @param callback
 */
function enterSubmit(form, callback) {
	// 绑定回车
	$('body').bind(
			'keydown',
			function() {
				var keyCode = event.keyCode ? event.keyCode
						: event.which ? event.which : event.charCode;
				if (keyCode == '13') {
					Login.login();
					if (callback) {
						callback();
					}
				}
			});
}