/**
 * 
 */

/** ************************公共部分***************************** */


/** **********************登录******************************* */
function login() {


	// 校验输入信息
	if (checkLogin()) {

		var formId = "loginForm";
		var url = "/login";

		httpPost(formId, url, function(data) {

			window.location.href = BASE_PATH + "/bench";

		}, function(data) {

			// 返回码
			var returnCode = data.returnCode;

			var returnMsg = data.returnMsg;


		});
	}

}

// 校验登录信息
checkLogin = function() {

	var username = $("#username").val();
	var password = $("#password").val();

	if (!username) {
		Dialog.alertInfo("用户名不能为空!")
		return false;
	}

	if (!password) {
		Dialog.alertInfo("密码不能为空!")
		return false;
	} 


	return true;
};

/** **********************公共部分******************************* */
