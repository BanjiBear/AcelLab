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
	document.getElementById("index_title").textContent = languagemap[language].index_title;
	document.getElementById("index_slogan").textContent = languagemap[language].index_slogan;
	document.getElementById("index_context").textContent = languagemap[language].index_context;
	document.getElementById("join_now").textContent = languagemap[language].join_now;
	document.getElementById("weekly_startline").textContent = languagemap[language].weekly_startline;
	document.getElementById("our_product").textContent = languagemap[language].our_product;
	document.getElementById("product_slogan").textContent = languagemap[language].product_slogan;
	document.getElementById("feature_title_1").textContent = languagemap[language].feature_title_1;
	document.getElementById("feature_slogan_1").textContent = languagemap[language].feature_slogan_1;
	document.getElementById("feature_content_1").textContent = languagemap[language].feature_content_1;
	document.getElementById("learn_more_1").textContent = languagemap[language].learn_more_1;
	document.getElementById("feature_title_2").textContent = languagemap[language].feature_title_2;
	document.getElementById("feature_slogan_2").textContent = languagemap[language].feature_slogan_2;
	document.getElementById("feature_content_2").textContent = languagemap[language].feature_content_2;
	document.getElementById("learn_more_2").textContent = languagemap[language].learn_more_2;
	document.getElementById("feature_title_3").textContent = languagemap[language].feature_title_3;
	document.getElementById("feature_slogan_3").textContent = languagemap[language].feature_slogan_3;
	document.getElementById("feature_content_3").textContent = languagemap[language].feature_content_3;
	document.getElementById("learn_more_3").textContent = languagemap[language].learn_more_3;
	document.getElementById("simeff").textContent = languagemap[language].simeff;
	document.getElementById("simeff_title").textContent = languagemap[language].simeff_title;
	document.getElementById("simeff_content").textContent = languagemap[language].simeff_content;
	document.getElementById("simeff_demo").textContent = languagemap[language].simeff_demo;
	document.getElementById("partners_clients").textContent = languagemap[language].partners_clients;
	document.getElementById("whatwedo").textContent = languagemap[language].whatwedo;
	document.getElementById("whatwedo_slogan").textContent = languagemap[language].whatwedo_slogan;
	document.getElementById("whatwedo_content").textContent = languagemap[language].whatwedo_content;
	document.getElementById("get_started").textContent = languagemap[language].get_started;
	document.getElementById("questions").textContent = languagemap[language].questions;
	document.getElementById("questions_slogan").textContent = languagemap[language].questions_slogan;
	document.getElementById("questions_content").textContent = languagemap[language].questions_content;
	document.getElementById("questions_contact").textContent = languagemap[language].questions_contact;
	document.getElementById("footer").textContent = languagemap[language].footer;
	document.getElementById("terms").textContent = languagemap[language].terms;
	document.getElementById("privacy").textContent = languagemap[language].privacy;
}

document.getElementById("switchToEnglish").addEventListener("click", () => updateContent("en"));
document.getElementById("switchToKorean").addEventListener("click", () => updateContent("kr"));
document.getElementById("switchToChinese").addEventListener("click", () => updateContent("cn"));
document.getElementById("switchToJapanese").addEventListener("click", () => updateContent("jp"));
