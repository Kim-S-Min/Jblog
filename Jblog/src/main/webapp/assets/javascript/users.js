function checkForm(frm) {
	console.log(frm);
	
	var username = frm.username.value.trim();
	var id = frm.id.value.trim();
	var password = frm.password.value.trim();
	var check = frm.chech.value;
	var agree = document.getElementsByName('agree');
	
	if (username.length == 0) {
		alert("이름을 입력해주세요");
		frm.username.focus();
	} else if (id.length == 0) {
		alert("아이디를 입력해주세요");
		frm.id.focus();
	} else if (check.value != "t") {
		alert("아이디 중복체크를 해주세요");
	} else if (password.length == 0) {
		alert("비밀번호를 입력해주세요");
		frm.password.focus();
	} else if (!agree[0].checked) {
		alert("약관에 동의해 주세요.");
	} else {
		return true;
	}
	
	return false;
}

function checkid(idfiel, url) {
	console.log("id field:", idfield.value);
	
	$.ajax({
		url: url,
		type: "GET",
		dataType: "json",
		data: {
			id: idfield.value.trim()
		},
		succuss: function(result) {
			console.log("Result:", result);
			if (result.data == true) {
				idField.form.check.value = "f";
				document.getElementsByName("msg_id").textContext="다른 아이디로 가입해 주세요";
			} else {
				idField.form.check.value = "t";
				document.getElementsByName("msg_id").textContext="사용할 수 있는 아이디 입니다";
			}
		},
		error: function(xhr, status, error) {
		console.error("Status:", status);
		cnosole.error("Response:", xhr);
		console.error("Error:", error);
		
		idfield.form.check.value = "f";
		}
	});
}