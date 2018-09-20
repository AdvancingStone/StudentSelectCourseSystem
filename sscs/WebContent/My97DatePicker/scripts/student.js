window.onload = function(e) {
	var form = document.querySelector('form');
	var name = document.querySelector('#name');
	var password = document.querySelector('#password');
	var classno = document.querySelector('#classno');
	var tel = document.querySelector('#tel');
	var birthday = document.querySelector('#birthday');
	var remark = document.querySelector('#remark');
	var span = document.querySelectorAll('span');

	// onsubmit事件
	form.onsubmit = function(e) {
		var name = checkName();
		if (!name) {
			return false;
		}
		var password = checkPassword();
		if (!password) {
			return false;
		}
		var classno = checkClassno();
		if (!classno) {
			return false;
		}
		var tel = checkTel();
		if (!tel) {
			return false;
		}
		var birthday = checkBirthday();
		if (!birthday) {
			return false;
		}
		var remark = checkRemark();
		if (!remark) {
			return false;
		}
		return true;
	};

	// onblur失去焦点事件
	name.onblur = function(e) {
		checkName();
	};
	password.onblur = function(e) {
		checkPassword();
	};
	classno.onblur = function(e) {
		checkClassno();
	};
	tel.onblur = function(e) {
		checkTel();
	};
	birthday.onblur = function(e) {
		checkBirthday();
	};
	remark.onblur = function(e) {
		checkRemark();
	};

	// ---------------------------------函数封装-------------------------------------------------------------
	// 真实姓名（2-4位汉字）
	function checkName(e) {
		if (name.value.length == 0) {
			span[0].innerText = '真实姓名不能为空';
			span[0].className = 'danger';
			return false;
		}
		var pattern = /^[\u4e00-\u9fa5]{2,4}$/;
		if (!pattern.test(name.value)) {
			span[0].innerText = '真实姓名格式错误，请重新输入';
			span[0].className = 'danger';
			return false;
		}
		span[0].innerText = '真实姓名输入正确';
		span[0].className = 'success';
		return true;
	}

	// 登录密码
	function checkPassword(e) {
		if (password.value.length == 0) {
			span[1].innerText = '密码不能为空';
			span[1].className = 'danger';
			return false;
		}
		var pattern = /^[A-Za-z0-9]{6,16}$/;
		if (!pattern.test(password.value)) {
			span[1].innerText = '6-16位的数字或字母组成';
			span[1].className = 'danger';
			return false;
		}
		span[1].innerText = '密码格式正确';
		span[1].className = 'success';
		return true;
	}

	// /////////////这是个问题，从数据查询，先写死

	// 班级
	function checkClassno(e) {
		if (classno.value == "--请选择班级--") {
			span[2].innerText = '请选择班级';
			span[2].className = 'danger';
			return false;
		}
		span[2].innerText = '已选择';
		span[2].className = 'success';
		return true;
	}

	// 手机号（）
	function checkTel(e) {
		if (tel.value.length == 0) {
			span[3].innerText = '手机号不能为空';
			span[3].className = 'danger';
			return false;
		}
		var pattern = /^1[34578]\d{9}$/;
		if (!pattern.test(tel.value)) {
			span[3].innerText = '手机号码格式错误，请重新输入';
			span[3].className = 'danger';
			return false;
		}
		span[3].innerText = '手机号输入正确';
		span[3].className = 'success';
		return true;
	}

	// 出生年月日（格式xxxx-xx-xx)
	function checkBirthday(e) {
		if (birthday.value.length == 0) {
			span[4].innerText = '出生年月日不能为空';
			span[4].className = 'danger';
			return false;
		}
		var pattern = /^[0-9]{4}\-?[0-9]{1,2}\-?[0-9]{1,2}$/;
		if (!pattern.test(birthday.value)) {
			span[4].innerText = '时间格式：xxxx-xx-xx';
			span[4].className = 'danger';
			return false;
		}
		span[4].innerText = '时间格式正确';
		span[4].className = 'success';
		return true;
	}

	// 评论
	function checkRemark(e) {
		if (remark.value == "--请选择--") {
			span[5].innerText = '请进行选择';
			span[5].className = 'danger';
			return false;
		}
		span[5].innerText = '已选择';
		span[5].className = 'success';
		return true;
	}
}