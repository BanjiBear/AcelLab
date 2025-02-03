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
	document.getElementById("nav_bar_aboutus").textContent = languagemap[language].nav_bar_aboutus;
	document.getElementById("nav_bar_price").textContent = languagemap[language].nav_bar_price;
	document.getElementById("nav_bar_resources").textContent = languagemap[language].nav_bar_resources;
	document.getElementById("nav_bar_support").textContent = languagemap[language].nav_bar_support;
	document.getElementById("nav_bar_contact").textContent = languagemap[language].nav_bar_contact;
	document.getElementById("nav_bar_login").textContent = languagemap[language].nav_bar_login;
	document.getElementById("nav_bar_register").textContent = languagemap[language].nav_bar_register;
	document.getElementById("join1_title").textContent = languagemap[language].join1_title;
	document.getElementById("join1_select").textContent = languagemap[language].join1_select;
	document.getElementById("join1_faq_1").textContent = languagemap[language].join1_faq_1;
	document.getElementById("join1_faq_ans_1").textContent = languagemap[language].join1_faq_ans_1;
	document.getElementById("join1_faq_2").textContent = languagemap[language].join1_faq_2;
	document.getElementById("join1_faq_ans_2").textContent = languagemap[language].join1_faq_ans_2;
	document.getElementById("join1_startup").textContent = languagemap[language].join1_startup;
	document.getElementById("join1_startup_content").textContent = languagemap[language].join1_startup_content;
	document.getElementById("join1_corporate_free_title").textContent = languagemap[language].join1_corporate_free_title;
	document.getElementById("join1_corporate_free_price").textContent = languagemap[language].join1_corporate_free_price;
	document.getElementById("join1_corporate_free_content").textContent = languagemap[language].join1_corporate_free_content;
	document.getElementById("join1_corporate_business_title").textContent = languagemap[language].join1_corporate_business_title;
	document.getElementById("join1_corporate_business_price").textContent = languagemap[language].join1_corporate_business_price;
	document.getElementById("join1_corporate_business_content").textContent = languagemap[language].join1_corporate_business_content;
	document.getElementById("join1_corporate_enterprise_title").textContent = languagemap[language].join1_corporate_enterprise_title;
	document.getElementById("join1_corporate_enterprise_price").textContent = languagemap[language].join1_corporate_enterprise_price;
	document.getElementById("join1_corporate_enterprise_content").textContent = languagemap[language].join1_corporate_enterprise_content;
	document.getElementById("join1_pay").textContent = languagemap[language].join1_pay;

	document.getElementById("footer").textContent = languagemap[language].footer;
	document.getElementById("terms").textContent = languagemap[language].terms;
	document.getElementById("privacy").textContent = languagemap[language].privacy;
}

document.getElementById("switchToEnglish").addEventListener("click", () => updateContent("en"));
document.getElementById("switchToKorean").addEventListener("click", () => updateContent("kr"));
document.getElementById("switchToChinese").addEventListener("click", () => updateContent("cn"));
document.getElementById("switchToJapanese").addEventListener("click", () => updateContent("jp"));
