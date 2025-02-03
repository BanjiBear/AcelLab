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
		en: ["Frist Name", "Last Name", "Company Name", "Phone Number", "Email", "Message"],
		kr: ["성함", "성", "회사명", "전화번호", "이메일", "내용"],
		cn: ["名字", "姓氏", "公司名称", "电话", "电子邮件", "信息"],
		jp: ["名前", "姓", "会社名", "電話", "メール", "メッセージ"],
	};

	const submitText = {
		en: ["Submit"],
		kr: ["문의하기"],
		cn: ["提交"],
		jp: ["提出"],
	};
	document.getElementById("nav_bar_aboutus").textContent = languagemap[language].nav_bar_aboutus;
	document.getElementById("nav_bar_price").textContent = languagemap[language].nav_bar_price;
	document.getElementById("nav_bar_resources").textContent = languagemap[language].nav_bar_resources;
	document.getElementById("nav_bar_support").textContent = languagemap[language].nav_bar_support;
	document.getElementById("nav_bar_contact").textContent = languagemap[language].nav_bar_contact;
	document.getElementById("nav_bar_login").textContent = languagemap[language].nav_bar_login;
	document.getElementById("nav_bar_register").textContent = languagemap[language].nav_bar_register;
	document.getElementById("contact").textContent = languagemap[language].contact;
	document.getElementById("contact_question_1").textContent = languagemap[language].contact_question_1;
	document.getElementById("contact_question_2").textContent = languagemap[language].contact_question_2;
	document.getElementById("contact_question_3").textContent = languagemap[language].contact_question_3;
	document.getElementById("contact_question_4").textContent = languagemap[language].contact_question_4;
	document.getElementById("contact_question_5").textContent = languagemap[language].contact_question_5;
	document.getElementById("contact_question_6").textContent = languagemap[language].contact_question_6;
	document.getElementById("contact_fname").placeholder = inputText[language][0];
	document.getElementById("contact_lname").placeholder = inputText[language][1];
	document.getElementById("contact_company_name").placeholder = inputText[language][2];
	document.getElementById("contact_phone").placeholder = inputText[language][3];
	document.getElementById("contact_email").placeholder = inputText[language][4];
	document.getElementById("contact_message").placeholder = inputText[language][5];
	document.getElementById("contact_submit").value = submitText[language][0];
	document.getElementById("price_ready_to_start").textContent = languagemap[language].price_ready_to_start;
	document.getElementById("price_kickstart_innovation").textContent = languagemap[language].price_kickstart_innovation;
	document.getElementById("price_try_startline_now").textContent = languagemap[language].price_try_startline_now;

	document.getElementById("footer").textContent = languagemap[language].footer;
	document.getElementById("terms").textContent = languagemap[language].terms;
	document.getElementById("privacy").textContent = languagemap[language].privacy;
}

document.getElementById("switchToEnglish").addEventListener("click", () => updateContent("en"));
document.getElementById("switchToKorean").addEventListener("click", () => updateContent("kr"));
document.getElementById("switchToChinese").addEventListener("click", () => updateContent("cn"));
document.getElementById("switchToJapanese").addEventListener("click", () => updateContent("jp"));
