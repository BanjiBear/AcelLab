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

	document.getElementById("support_faq_verify").textContent = languagemap[language].support_faq_verify;
	document.getElementById("support_faq_verify_content_1").textContent = languagemap[language].support_faq_verify_content_1;
	document.getElementById("support_faq_verify_content_2").textContent = languagemap[language].support_faq_verify_content_2;
	document.getElementById("support_faq_verify_how_1").textContent = languagemap[language].support_faq_verify_how_1;
	document.getElementById("support_faq_verify_how_2").textContent = languagemap[language].support_faq_verify_how_2;
	document.getElementById("support_faq_verify_how_3").textContent = languagemap[language].support_faq_verify_how_3;
	document.getElementById("support_faq_verify_how_4").textContent = languagemap[language].support_faq_verify_how_4;
	document.getElementById("support_faq_verify_how_5").textContent = languagemap[language].support_faq_verify_how_5;
	document.getElementById("support_faq_verify_doc_list").textContent = languagemap[language].support_faq_verify_doc_list;
	document.getElementById("support_faq_verify_doc_1").textContent = languagemap[language].support_faq_verify_doc_1;
	document.getElementById("support_faq_verify_doc_2").textContent = languagemap[language].support_faq_verify_doc_2;
	document.getElementById("support_faq_verify_doc_3").textContent = languagemap[language].support_faq_verify_doc_3;
	document.getElementById("support_faq_verify_doc_4").textContent = languagemap[language].support_faq_verify_doc_4;
	document.getElementById("support_faq_verify_doc_5").textContent = languagemap[language].support_faq_verify_doc_5;
	document.getElementById("support_faq_verify_doc_6").textContent = languagemap[language].support_faq_verify_doc_6;
	document.getElementById("support_faq_verify_doc_7").textContent = languagemap[language].support_faq_verify_doc_7;
	document.getElementById("support_faq_verify_doc_8").textContent = languagemap[language].support_faq_verify_doc_8;
	document.getElementById("support_faq_verify_doc_9").textContent = languagemap[language].support_faq_verify_doc_9;
	document.getElementById("support_faq_verify_doc_10").textContent = languagemap[language].support_faq_verify_doc_10;
	document.getElementById("support_faq_verify_doc_11").textContent = languagemap[language].support_faq_verify_doc_11;
	document.getElementById("support_faq_verify_doc_12").textContent = languagemap[language].support_faq_verify_doc_12;
	document.getElementById("support_faq_verify_doc_13").textContent = languagemap[language].support_faq_verify_doc_13;
	document.getElementById("support_faq_verify_doc_14").textContent = languagemap[language].support_faq_verify_doc_14;
	document.getElementById("support_faq_verify_doc_15").textContent = languagemap[language].support_faq_verify_doc_15;
	document.getElementById("support_faq_verify_doc_16").textContent = languagemap[language].support_faq_verify_doc_16;
	document.getElementById("support_faq_verify_doc_17").textContent = languagemap[language].support_faq_verify_doc_17;
	document.getElementById("support_faq_verify_doc_18").textContent = languagemap[language].support_faq_verify_doc_18;
	document.getElementById("support_faq_verify_doc_19").textContent = languagemap[language].support_faq_verify_doc_19;
	document.getElementById("support_faq_verify_doc_20").textContent = languagemap[language].support_faq_verify_doc_20;
	document.getElementById("support_faq_verify_doc_21").textContent = languagemap[language].support_faq_verify_doc_21;
	document.getElementById("support_faq_verify_doc_22").textContent = languagemap[language].support_faq_verify_doc_22;
	document.getElementById("support_faq_verify_content_3").textContent = languagemap[language].support_faq_verify_content_3;
	document.getElementById("support_faq_verify_company").textContent = languagemap[language].support_faq_verify_company;
	document.getElementById("support_faq_verify_general").textContent = languagemap[language].support_faq_verify_general;
	document.getElementById("support_faq_verify_company_domain").textContent = languagemap[language].support_faq_verify_company_domain;
	document.getElementById("support_faq_verify_company_domain_content_1").textContent =
		languagemap[language].support_faq_verify_company_domain_content_1;
	document.getElementById("support_faq_verify_company_domain_content_2").textContent =
		languagemap[language].support_faq_verify_company_domain_content_2;
	document.getElementById("support_faq_verify_general_domain").textContent = languagemap[language].support_faq_verify_general_domain;
	document.getElementById("support_faq_verify_general_domain_content_1").textContent =
		languagemap[language].support_faq_verify_general_domain_content_1;
	document.getElementById("support_faq_verify_general_domain_content_2").textContent =
		languagemap[language].support_faq_verify_general_domain_content_2;
}

document.getElementById("switchToEnglish").addEventListener("click", () => updateContent("en"));
document.getElementById("switchToKorean").addEventListener("click", () => updateContent("kr"));
document.getElementById("switchToChinese").addEventListener("click", () => updateContent("cn"));
document.getElementById("switchToJapanese").addEventListener("click", () => updateContent("jp"));
