import languagemap from "./languagemap.js";

function updateContent(language) {
	switch (language) {
		case "cn":
			document.body.style.fontFamily = "Noto Sans TC, sans-serif";
			break;
		case "jp":
			document.body.style.fontFamily = "Noto Sans JP, sans-serif";
			break;
		case "kr":
			document.body.style.fontFamily = "Noto Sans KR, sans-serif";
			break;
		case "en":
		default:
			document.body.style.fontFamily = "Carlito, sans-serif";
			break;
	}
	const inputText = {
		en: ["This is how you'll appear to others", "At least 12 characters", "First Name", "Last Name", "Input your work email"],
		kr: ["아이디", "12자 이상 입력해 주십십시오", "이름", "성", "회사 이메일을 입력해 주십시오"],
		cn: ["输入您的用户名", "至少12个字符", "名字", "姓氏", "工作邮箱"],
		jp: ["ユーザー名を入力してください", "12文字以", "名前", "姓", "仕事用メール"],
	};

	document.getElementById("nav_bar_aboutus").textContent = languagemap[language].nav_bar_aboutus;
	document.getElementById("nav_bar_price").textContent = languagemap[language].nav_bar_price;
	document.getElementById("nav_bar_resources").textContent = languagemap[language].nav_bar_resources;
	document.getElementById("nav_bar_support").textContent = languagemap[language].nav_bar_support;
	document.getElementById("nav_bar_contact").textContent = languagemap[language].nav_bar_contact;
	document.getElementById("nav_bar_login").textContent = languagemap[language].nav_bar_login;
	document.getElementById("nav_bar_register").textContent = languagemap[language].nav_bar_register;
	document.getElementById("join_title").textContent = languagemap[language].join_title;
	document.getElementById("join_slogan").textContent = languagemap[language].join_slogan;
	document.getElementById("join_username").textContent = languagemap[language].join_username;
	document.getElementById("join__input_username").placeholder = inputText[language][0];
	document.getElementById("join_pwd").textContent = languagemap[language].join_pwd;
	document.getElementById("join_input_pwd").placeholder = inputText[language][1];
	document.getElementById("join_name").textContent = languagemap[language].join_name;
	document.getElementById("join_input_first_name").placeholder = inputText[language][2];
	document.getElementById("join_input_last_name").placeholder = inputText[language][3];
	document.getElementById("join_work_email").textContent = languagemap[language].join_work_email;
	document.getElementById("join_work_email").placeholder = inputText[language][4];
	document.getElementById("join_input_work_email").placeholder = inputText[language][4];

	document.getElementById("join_remember").textContent = languagemap[language].join_remember;
	document.getElementById("join_forgot_pwd").textContent = languagemap[language].join_forgot_pwd;
	document.getElementById("join_tc_pp_content").textContent = languagemap[language].join_tc_pp_content;
	document.getElementById("join_sign_up").textContent = languagemap[language].join_sign_up;
	document.getElementById("join_sign_in").textContent = languagemap[language].join_sign_in;

	document.getElementById("footer").textContent = languagemap[language].footer;
	document.getElementById("terms").textContent = languagemap[language].terms;
	document.getElementById("privacy").textContent = languagemap[language].privacy;
}

document.getElementById("switchToEnglish").addEventListener("click", () => updateContent("en"));
document.getElementById("switchToKorean").addEventListener("click", () => updateContent("kr"));
document.getElementById("switchToChinese").addEventListener("click", () => updateContent("cn"));
document.getElementById("switchToJapanese").addEventListener("click", () => updateContent("jp"));
