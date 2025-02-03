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
	document.getElementById("pricing_1").textContent = languagemap[language].pricing_1;
	document.getElementById("pricing_slogan").textContent = languagemap[language].pricing_slogan;
	document.getElementById("pricing_free").textContent = languagemap[language].pricing_free;
	document.getElementById("pricing_free_price").textContent = languagemap[language].pricing_free_price;
	document.getElementById("pricing_free_tag").textContent = languagemap[language].pricing_free_tag;
	document.getElementById("pricing_free_feature_1").textContent = languagemap[language].pricing_free_feature_1;
	document.getElementById("pricing_free_feature_2").textContent = languagemap[language].pricing_free_feature_2;
	document.getElementById("pricing_free_feature_3").textContent = languagemap[language].pricing_free_feature_3;
	document.getElementById("pricing_business").textContent = languagemap[language].pricing_business;
	document.getElementById("pricing_business_price").textContent = languagemap[language].pricing_business_price;
	document.getElementById("pricing_business_tag_1").textContent = languagemap[language].pricing_business_tag_1;
	document.getElementById("pricing_business_tag_2").textContent = languagemap[language].pricing_business_tag_2;
	document.getElementById("pricing_business_feature_1").textContent = languagemap[language].pricing_business_feature_1;
	document.getElementById("pricing_business_feature_2").textContent = languagemap[language].pricing_business_feature_2;
	document.getElementById("pricing_business_feature_3").textContent = languagemap[language].pricing_business_feature_3;
	document.getElementById("pricing_business_feature_4").textContent = languagemap[language].pricing_business_feature_4;
	document.getElementById("pricing_enterprise").textContent = languagemap[language].pricing_enterprise;
	document.getElementById("pricing_enterprise_price").textContent = languagemap[language].pricing_enterprise_price;
	document.getElementById("pricing_enterprise_tag_1").textContent = languagemap[language].pricing_enterprise_tag_1;
	document.getElementById("pricing_enterprise_tag_2").textContent = languagemap[language].pricing_enterprise_tag_2;
	document.getElementById("pricing_enterprise_tag_3").textContent = languagemap[language].pricing_enterprise_tag_3;
	document.getElementById("pricing_enterprise_feature_1").textContent = languagemap[language].pricing_enterprise_feature_1;
	document.getElementById("pricing_enterprise_feature_2").textContent = languagemap[language].pricing_enterprise_feature_2;
	document.getElementById("pricing_enterprise_feature_3").textContent = languagemap[language].pricing_enterprise_feature_3;
	document.getElementById("pricing_enterprise_feature_4").textContent = languagemap[language].pricing_enterprise_feature_4;
	document.getElementById("pricing_enterprise_feature_5").textContent = languagemap[language].pricing_enterprise_feature_5;
	document.getElementById("pricing_enterprise_feature_6").textContent = languagemap[language].pricing_enterprise_feature_6;
	document.getElementById("pricing_price_usd").textContent = languagemap[language].pricing_price_usd;
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
