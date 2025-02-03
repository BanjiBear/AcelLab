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

	document.getElementById("support_welcome").textContent = languagemap[language].support_welcome;
	document.getElementById("support_startline_support").textContent = languagemap[language].support_startline_support;
	document.getElementById("support_getting_started").textContent = languagemap[language].support_getting_started;
	document.getElementById("support_plan_and_pricing").textContent = languagemap[language].support_plan_and_pricing;
	document.getElementById("support_creating_an_account").textContent = languagemap[language].support_creating_an_account;
	document.getElementById("support_setting_up_an_account").textContent = languagemap[language].support_setting_up_an_account;
	document.getElementById("support_features").textContent = languagemap[language].support_features;
	document.getElementById("support_personalization").textContent = languagemap[language].support_personalization;
	document.getElementById("support_technologytagging").textContent = languagemap[language].support_technologytagging;
	document.getElementById("support_daily_recommendations").textContent = languagemap[language].support_daily_recommendations;
	document.getElementById("support_search").textContent = languagemap[language].support_search;
	document.getElementById("support_multi_account").textContent = languagemap[language].support_multi_account;
	document.getElementById("support_create_company_card").textContent = languagemap[language].support_create_company_card;
	document.getElementById("support_location_identifier").textContent = languagemap[language].support_location_identifier;
	document.getElementById("support_settings").textContent = languagemap[language].support_settings;
	document.getElementById("support_account_settings").textContent = languagemap[language].support_account_settings;
	document.getElementById("support_team_settings").textContent = languagemap[language].support_team_settings;
	document.getElementById("support_bookmark_settings").textContent = languagemap[language].support_bookmark_settings;
	document.getElementById("support_plan_settings").textContent = languagemap[language].support_plan_settings;
	document.getElementById("support_frequently_asked_questions").textContent = languagemap[language].support_frequently_asked_questions;
	document.getElementById("support_choose_a_funding_round_i_belong").textContent = languagemap[language].support_choose_a_funding_round_i_belong;
	document.getElementById("support_how_to_verify_my_account").textContent = languagemap[language].support_how_to_verify_my_account;

	document.getElementById("support_startline_support").textContent = languagemap[language].support_startline_support;
	document.getElementById("support_welcome_to_our_help_center").textContent = languagemap[language].support_welcome_to_our_help_center;
	document.getElementById("support_get_started").textContent = languagemap[language].support_get_started;
	document.getElementById("support_guides_setup_product").textContent = languagemap[language].support_guides_setup_product;
	document.getElementById("support_plan_pricing").textContent = languagemap[language].support_plan_pricing;
}

document.getElementById("switchToEnglish").addEventListener("click", () => updateContent("en"));
document.getElementById("switchToKorean").addEventListener("click", () => updateContent("kr"));
document.getElementById("switchToChinese").addEventListener("click", () => updateContent("cn"));
document.getElementById("switchToJapanese").addEventListener("click", () => updateContent("jp"));
