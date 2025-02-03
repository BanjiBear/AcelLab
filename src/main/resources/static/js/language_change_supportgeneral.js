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

	document.getElementById("support_plan_pricing_1").textContent = languagemap[language].support_plan_pricing_1;
	document.getElementById("support_multiple_plans").textContent = languagemap[language].support_multiple_plans;

	document.getElementById("support_multiple_plans").textContent = languagemap[language].support_multiple_plans;
	document.getElementById("support_price_plan").textContent = languagemap[language].support_price_plan;
	document.getElementById("support_price_plan_startup").textContent = languagemap[language].support_price_plan_startup;
	document.getElementById("support_price_plan_startup_content").textContent = languagemap[language].support_price_plan_startup_content;
	document.getElementById("support_price_plan_startup_content_1").textContent = languagemap[language].support_price_plan_startup_content_1;
	document.getElementById("support_price_plan_corporate").textContent = languagemap[language].support_price_plan_corporate;
	document.getElementById("support_price_plan_corporate_content").textContent = languagemap[language].support_price_plan_corporate_content;
	document.getElementById("support_price_plan_content_compare").textContent = languagemap[language].support_price_plan_content_compare;
	document.getElementById("support_price_plan_table_1").textContent = languagemap[language].support_price_plan_table_1;
	document.getElementById("support_price_plan_table_startup").textContent = languagemap[language].support_price_plan_startup;
	document.getElementById("support_price_plan_table_corporate").textContent = languagemap[language].support_price_plan_corporate;
	document.getElementById("support_price_plan_table_2").textContent = languagemap[language].support_price_plan_table_2;
	document.getElementById("support_price_plan_table_3").textContent = languagemap[language].support_price_plan_table_3;
	document.getElementById("support_price_plan_table_4").textContent = languagemap[language].support_price_plan_table_4;
	document.getElementById("support_price_plan_table_5").textContent = languagemap[language].support_price_plan_table_5;
	document.getElementById("support_price_plan_table_6").textContent = languagemap[language].support_price_plan_table_6;
	document.getElementById("support_price_plan_table_7").textContent = languagemap[language].support_price_plan_table_7;
	document.getElementById("support_price_plan_table_8").textContent = languagemap[language].support_price_plan_table_8;
	document.getElementById("support_price_plan_table_9").textContent = languagemap[language].support_price_plan_table_9;
	document.getElementById("support_price_plan_table_10").textContent = languagemap[language].support_price_plan_table_10;
	document.getElementById("support_upgrade_downgrade").textContent = languagemap[language].support_upgrade_downgrade;
	document.getElementById("support_offer_monthly").textContent = languagemap[language].support_offer_monthly;
	document.getElementById("support_billing_policy").textContent = languagemap[language].support_billing_policy;
	document.getElementById("support_termination_policy").textContent = languagemap[language].support_termination_policy;
	document.getElementById("support_payment_cycle").textContent = languagemap[language].support_payment_cycle;
	document.getElementById("support_payment_cycle_content").textContent = languagemap[language].support_payment_cycle_content;
	document.getElementById("support_refunds").textContent = languagemap[language].support_refunds;
	document.getElementById("support_refunds_content").textContent = languagemap[language].support_refunds_content;
	document.getElementById("support_termination").textContent = languagemap[language].support_termination;
	document.getElementById("support_termination_content").textContent = languagemap[language].support_termination_content;
	document.getElementById("support_free").textContent = languagemap[language].support_free;
	document.getElementById("support_free_unlock_ai").textContent = languagemap[language].support_free_unlock_ai;
	document.getElementById("support_free_search_100").textContent = languagemap[language].support_free_search_100;
	document.getElementById("support_free_basic").textContent = languagemap[language].support_free_basic;

	document.getElementById("support_business").textContent = languagemap[language].support_business;
	document.getElementById("support_business_unlock_ai").textContent = languagemap[language].support_business_unlock_ai;
	document.getElementById("support_business_search_600").textContent = languagemap[language].support_business_search_600;
	document.getElementById("support_business_customized_manager").textContent = languagemap[language].support_business_customized_manager;
	document.getElementById("support_business_free_upgrade").textContent = languagemap[language].support_business_free_upgrade;
	document.getElementById("support_enterprise").textContent = languagemap[language].support_enterprise;
	document.getElementById("support_enterprise_unlock_ai").textContent = languagemap[language].support_enterprise_unlock_ai;
	document.getElementById("support_enterprise_search_unlimited").textContent = languagemap[language].support_enterprise_search_unlimited;
	document.getElementById("support_enterprise_customized_manager").textContent = languagemap[language].support_enterprise_customized_manager;
	document.getElementById("support_enterprise_consulting_service").textContent = languagemap[language].support_enterprise_consulting_service;
	document.getElementById("support_enterprise_free_upgrade").textContent = languagemap[language].support_enterprise_free_upgrade;
	document.getElementById("support_enterprise_collaborate_account").textContent = languagemap[language].support_enterprise_collaborate_account;
	document.getElementById("support_enterprise_collaborate_account_content").textContent =
		languagemap[language].support_enterprise_collaborate_account_content;
	document.getElementById("support_enterprise_collaborate_account_admin").textContent =
		languagemap[language].support_enterprise_collaborate_account_admin;
	document.getElementById("support_plan_considering").textContent = languagemap[language].support_plan_considering;
	document.getElementById("support_previous").textContent = languagemap[language].support_previous;
	document.getElementById("support_previous_startline_support").textContent = languagemap[language].support_previous_startline_support;
	document.getElementById("support_next").textContent = languagemap[language].support_next;
	document.getElementById("support_next_creating_account").textContent = languagemap[language].support_next_creating_account;
	document.getElementById("support_create_account_1").textContent = languagemap[language].support_create_account_1;
	document.getElementById("support_create_account_1_content").textContent = languagemap[language].support_create_account_1_content;
	document.getElementById("support_create_account_1_question").textContent = languagemap[language].support_create_account_1_question;
	document.getElementById("support_create_account_1_answer").textContent = languagemap[language].support_create_account_1_answer;
	document.getElementById("support_create_account_signup").textContent = languagemap[language].support_create_account_signup;
	document.getElementById("support_pw_policy").textContent = languagemap[language].support_pw_policy;
	document.getElementById("support_pw_uppercase").textContent = languagemap[language].support_pw_uppercase;
	document.getElementById("support_pw_lowercase").textContent = languagemap[language].support_pw_lowercase;
	document.getElementById("support_pw_special_char").textContent = languagemap[language].support_pw_special_char;
	document.getElementById("support_pw_one_digit").textContent = languagemap[language].support_pw_one_digit;
	document.getElementById("support_select_plan").textContent = languagemap[language].support_select_plan;
	document.getElementById("support_create_complete").textContent = languagemap[language].support_create_complete;
	document.getElementById("support_next_setup_profile").textContent = languagemap[language].support_next_setup_profile;
	document.getElementById("support_previous_1").textContent = languagemap[language].support_previous_1;
	document.getElementById("support_previous_1_plan_price").textContent = languagemap[language].support_previous_1_plan_price;
	document.getElementById("support_next_1").textContent = languagemap[language].support_next_1;
	document.getElementById("support_next_1_setting_account").textContent = languagemap[language].support_next_1_setting_account;
	document.getElementById("support_setting_up_account").textContent = languagemap[language].support_setting_up_account;
	document.getElementById("support_setting_up_account_content").textContent = languagemap[language].support_setting_up_account_content;
	document.getElementById("support_setting_up_account_verify").textContent = languagemap[language].support_setting_up_account_verify;
	document.getElementById("support_setting_up_account_verify_how").textContent = languagemap[language].support_setting_up_account_verify_how;
	document.getElementById("support_startup").textContent = languagemap[language].support_startup;
	document.getElementById("support_corporate").textContent = languagemap[language].support_corporate;
	document.getElementById("support_startup_content").textContent = languagemap[language].support_startup_content;
	document.getElementById("support_startup_profile").textContent = languagemap[language].support_startup_profile;
	document.getElementById("support_startup_ceo").textContent = languagemap[language].support_startup_ceo;
	document.getElementById("support_startup_ceo_content").textContent = languagemap[language].support_startup_ceo_content;
	document.getElementById("support_startup_basic").textContent = languagemap[language].support_startup_basic;
	document.getElementById("support_startup_basic_content").textContent = languagemap[language].support_startup_basic_content;
	document.getElementById("support_startup_team").textContent = languagemap[language].support_startup_team;
	document.getElementById("support_startup_team_content").textContent = languagemap[language].support_startup_team_content;
	document.getElementById("support_startup_product").textContent = languagemap[language].support_startup_product;
	document.getElementById("support_startup_product_content").textContent = languagemap[language].support_startup_product_content;
	document.getElementById("support_startup_financials").textContent = languagemap[language].support_startup_financials;
	document.getElementById("support_startup_financials_content").textContent = languagemap[language].support_startup_financials_content;
	document.getElementById("support_startup_financials_choose").textContent = languagemap[language].support_startup_financials_choose;
	document.getElementById("support_startup_content_save").textContent = languagemap[language].support_startup_content_save;
	document.getElementById("support_startup_verify_complete").textContent = languagemap[language].support_startup_verify_complete;
	document.getElementById("support_corporate_content").textContent = languagemap[language].support_corporate_content;
	document.getElementById("support_corporate_profile").textContent = languagemap[language].support_corporate_profile;
	document.getElementById("support_corporate_ceo").textContent = languagemap[language].support_corporate_ceo;
	document.getElementById("support_corporate_ceo_content").textContent = languagemap[language].support_corporate_ceo_content;
	document.getElementById("support_corporate_basic").textContent = languagemap[language].support_corporate_basic;
	document.getElementById("support_corporate_basic_content").textContent = languagemap[language].support_corporate_basic_content;
	document.getElementById("support_corporate_team").textContent = languagemap[language].support_corporate_team;
	document.getElementById("support_corporate_team_content").textContent = languagemap[language].support_corporate_team_content;
	document.getElementById("support_corporate_product").textContent = languagemap[language].support_corporate_product;
	document.getElementById("support_corporate_product_content").textContent = languagemap[language].support_corporate_product_content;
	document.getElementById("support_corporate_financials").textContent = languagemap[language].support_corporate_financials;
	document.getElementById("support_corporate_financials_content").textContent = languagemap[language].support_corporate_financials_content;
	document.getElementById("support_corporate_save").textContent = languagemap[language].support_corporate_save;
	document.getElementById("support_corporate_additional").textContent = languagemap[language].support_corporate_additional;
	document.getElementById("support_corporate_multiple_account").textContent = languagemap[language].support_corporate_multiple_account;
	document.getElementById("support_corporate_team").textContent = languagemap[language].support_corporate_team;
	document.getElementById("support_corporate_team_content").textContent = languagemap[language].support_corporate_team_content;
	document.getElementById("support_corporate_search").textContent = languagemap[language].support_corporate_search;
	document.getElementById("support_corporate_search_content").textContent = languagemap[language].support_corporate_search_content;
	document.getElementById("support_corporate_complete").textContent = languagemap[language].support_corporate_complete;
	document.getElementById("support_previous_2").textContent = languagemap[language].support_previous_2;
	document.getElementById("support_previous_2_create_account").textContent = languagemap[language].support_previous_2_create_account;
	document.getElementById("support_next_2").textContent = languagemap[language].support_next_2;
	document.getElementById("support_next_2_features").textContent = languagemap[language].support_next_2_features;
}

document.getElementById("switchToEnglish").addEventListener("click", () => updateContent("en"));
document.getElementById("switchToKorean").addEventListener("click", () => updateContent("kr"));
document.getElementById("switchToChinese").addEventListener("click", () => updateContent("cn"));
document.getElementById("switchToJapanese").addEventListener("click", () => updateContent("jp"));
