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

	document.getElementById("support_features_1").textContent = languagemap[language].support_features_1;
	document.getElementById("support_features_1_content").textContent = languagemap[language].support_features_1_content;
	document.getElementById("support_features_personalization").textContent = languagemap[language].support_features_personalization;
	document.getElementById("support_features_technology_tagging").textContent = languagemap[language].support_features_technology_tagging;
	document.getElementById("support_features_daily_recommendation").textContent = languagemap[language].support_features_daily_recommendation;
	document.getElementById("support_features_search").textContent = languagemap[language].support_features_search;
	document.getElementById("support_features_multi_account").textContent = languagemap[language].support_features_multi_account;
	document.getElementById("support_features_create_card").textContent = languagemap[language].support_features_create_card;
	document.getElementById("support_features_location").textContent = languagemap[language].support_features_location;
	document.getElementById("support_features_personalization_1").textContent = languagemap[language].support_features_personalization_1;
	document.getElementById("support_features_personalization_content_1").textContent =
		languagemap[language].support_features_personalization_content_1;
	document.getElementById("support_features_personalization_content_2").textContent =
		languagemap[language].support_features_personalization_content_2;
	document.getElementById("support_features_personalization_content_3").textContent =
		languagemap[language].support_features_personalization_content_3;
	document.getElementById("support_features_personalization_content_4").textContent =
		languagemap[language].support_features_personalization_content_4;
	document.getElementById("support_features_technology_tagging_1").textContent = languagemap[language].support_features_technology_tagging_1;
	document.getElementById("support_features_technology_tagging_content_1").textContent =
		languagemap[language].support_features_technology_tagging_content_1;
	document.getElementById("support_features_technology_tagging_content_2").textContent =
		languagemap[language].support_features_technology_tagging_content_2;
	document.getElementById("support_features_technology_tagging_content_3").textContent =
		languagemap[language].support_features_technology_tagging_content_3;
	document.getElementById("support_features_technology_tagging_content_4").textContent =
		languagemap[language].support_features_technology_tagging_content_4;
	document.getElementById("support_features_daily_recommendation_1").textContent = languagemap[language].support_features_daily_recommendation_1;
	document.getElementById("support_features_daily_recommendation_content_1").textContent =
		languagemap[language].support_features_daily_recommendation_content_1;
	document.getElementById("support_features_daily_recommendation_content_2").textContent =
		languagemap[language].support_features_daily_recommendation_content_2;
	document.getElementById("support_features_daily_recommendation_content_3").textContent =
		languagemap[language].support_features_daily_recommendation_content_3;
	document.getElementById("support_features_daily_recommendation_content_4").textContent =
		languagemap[language].support_features_daily_recommendation_content_4;
	document.getElementById("support_features_daily_recommendation_content_5").textContent =
		languagemap[language].support_features_daily_recommendation_content_5;
	document.getElementById("support_features_daily_recommendation_content_6").textContent =
		languagemap[language].support_features_daily_recommendation_content_6;
	document.getElementById("support_features_search_1").textContent = languagemap[language].support_features_search_1;
	document.getElementById("support_features_search_content_1").textContent = languagemap[language].support_features_search_content_1;
	document.getElementById("support_features_search_content_2").textContent = languagemap[language].support_features_search_content_2;
	document.getElementById("support_features_search_content_3").textContent = languagemap[language].support_features_search_content_3;
	document.getElementById("support_features_search_basic_info").textContent = languagemap[language].support_features_search_basic_info;
	document.getElementById("support_features_search_product").textContent = languagemap[language].support_features_search_product;
	document.getElementById("support_features_search_finance").textContent = languagemap[language].support_features_search_finance;
	document.getElementById("support_features_search_contacts").textContent = languagemap[language].support_features_search_contacts;
	document.getElementById("support_features_search_basic_info_title").textContent = languagemap[language].support_features_search_basic_info_title;
	document.getElementById("support_features_search_basic_info_content").textContent =
		languagemap[language].support_features_search_basic_info_content;
	document.getElementById("support_features_search_product_title").textContent = languagemap[language].support_features_search_product_title;
	document.getElementById("support_features_search_product_content").textContent = languagemap[language].support_features_search_product_content;
	document.getElementById("support_features_search_finance_title").textContent = languagemap[language].support_features_search_finance_title;
	document.getElementById("support_features_search_finance_content").textContent = languagemap[language].support_features_search_finance_content;
	document.getElementById("support_features_search_contacts_title").textContent = languagemap[language].support_features_search_contacts_title;
	document.getElementById("support_features_search_contacts_content").textContent = languagemap[language].support_features_search_contacts_content;
	document.getElementById("support_features_multi_account_1").textContent = languagemap[language].support_features_multi_account_1;
	document.getElementById("support_features_multi_account_content_1").textContent = languagemap[language].support_features_multi_account_content_1;
	document.getElementById("support_features_multi_account_content_2").textContent = languagemap[language].support_features_multi_account_content_2;
	document.getElementById("support_features_create_card_1").textContent = languagemap[language].support_features_create_card_1;
	document.getElementById("support_features_create_card_content_1").textContent = languagemap[language].support_features_create_card_content_1;
	document.getElementById("support_features_create_card_content_2").textContent = languagemap[language].support_features_create_card_content_2;
	document.getElementById("support_features_create_card_content_3").textContent = languagemap[language].support_features_create_card_content_3;
	document.getElementById("support_features_create_card_content_green").textContent =
		languagemap[language].support_features_create_card_content_green;
	document.getElementById("support_features_location_1").textContent = languagemap[language].support_features_location_1;
	document.getElementById("support_features_location_content_1").textContent = languagemap[language].support_features_location_content_1;
}

document.getElementById("switchToEnglish").addEventListener("click", () => updateContent("en"));
document.getElementById("switchToKorean").addEventListener("click", () => updateContent("kr"));
document.getElementById("switchToChinese").addEventListener("click", () => updateContent("cn"));
document.getElementById("switchToJapanese").addEventListener("click", () => updateContent("jp"));
