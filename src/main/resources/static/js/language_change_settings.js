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

	document.getElementById("support_settings").textContent = languagemap[language].support_settings;
	document.getElementById("support_settings_1").textContent = languagemap[language].support_settings_1;
	document.getElementById("support_settings_content_1").textContent = languagemap[language].support_settings_content_1;
	document.getElementById("support_settings_content_2").textContent = languagemap[language].support_settings_content_2;
	document.getElementById("support_settings_account").textContent = languagemap[language].support_settings_account;
	document.getElementById("support_settings_team").textContent = languagemap[language].support_settings_team;
	document.getElementById("support_settings_bookmark").textContent = languagemap[language].support_settings_bookmark;
	document.getElementById("support_settings_plan").textContent = languagemap[language].support_settings_plan;
	document.getElementById("support_settings_account_title").textContent = languagemap[language].support_settings_account_title;
	document.getElementById("support_settings_account_content_1").textContent = languagemap[language].support_settings_account_content_1;
	document.getElementById("support_settings_account_content_2").textContent = languagemap[language].support_settings_account_content_2;
	document.getElementById("support_settings_account_profile_img").textContent = languagemap[language].support_settings_account_profile_img;
	document.getElementById("support_settings_account_profile_img_content").textContent =
		languagemap[language].support_settings_account_profile_img_content;
	document.getElementById("support_settings_account_name").textContent = languagemap[language].support_settings_account_name;
	document.getElementById("support_settings_account_name_content").textContent = languagemap[language].support_settings_account_name_content;
	document.getElementById("support_settings_account_dept").textContent = languagemap[language].support_settings_account_dept;
	document.getElementById("support_settings_account_dept_content").textContent = languagemap[language].support_settings_account_dept_content;
	document.getElementById("support_settings_account_role").textContent = languagemap[language].support_settings_account_role;
	document.getElementById("support_settings_account_role_content").textContent = languagemap[language].support_settings_account_role_content;
	document.getElementById("support_settings_account_email").textContent = languagemap[language].support_settings_account_email;
	document.getElementById("support_settings_account_email_content").textContent = languagemap[language].support_settings_account_email_content;
	document.getElementById("support_settings_account_num").textContent = languagemap[language].support_settings_account_num;
	document.getElementById("support_settings_account_num_content").textContent = languagemap[language].support_settings_account_num_content;
	document.getElementById("support_settings_account_linkedin").textContent = languagemap[language].support_settings_account_linkedin;
	document.getElementById("support_settings_account_linkedin_content").textContent =
		languagemap[language].support_settings_account_linkedin_content;
	document.getElementById("support_settings_account_username").textContent = languagemap[language].support_settings_account_username;
	document.getElementById("support_settings_account_username_content").textContent =
		languagemap[language].support_settings_account_username_content;
	document.getElementById("support_settings_account_pw").textContent = languagemap[language].support_settings_account_pw;
	document.getElementById("support_settings_account_pw_content").textContent = languagemap[language].support_settings_account_pw_content;
	document.getElementById("support_settings_team_title").textContent = languagemap[language].support_settings_team_title;
	document.getElementById("support_settings_team_content_1").textContent = languagemap[language].support_settings_team_content_1;
	document.getElementById("support_settings_team_content_2").textContent = languagemap[language].support_settings_team_content_2;
	document.getElementById("support_settings_team_content_3").textContent = languagemap[language].support_settings_team_content_3;
	document.getElementById("support_settings_team_profile").textContent = languagemap[language].support_settings_team_profile;
	document.getElementById("support_settings_team_profile_content").textContent = languagemap[language].support_settings_team_profile_content;
	document.getElementById("support_settings_team_permission").textContent = languagemap[language].support_settings_team_permission;
	document.getElementById("support_settings_team_permission_content").textContent = languagemap[language].support_settings_team_permission_content;
	document.getElementById("support_settings_team_status").textContent = languagemap[language].support_settings_team_status;
	document.getElementById("support_settings_team_status_content").textContent = languagemap[language].support_settings_team_status_content;
	document.getElementById("support_settings_bookmark_title").textContent = languagemap[language].support_settings_bookmark_title;
	document.getElementById("support_settings_bookmark_content_1").textContent = languagemap[language].support_settings_bookmark_content_1;
	document.getElementById("support_settings_bookmark_content_2").textContent = languagemap[language].support_settings_bookmark_content_2;
	document.getElementById("support_settings_bookmark_content_3").textContent = languagemap[language].support_settings_bookmark_content_3;
	document.getElementById("support_settings_bookmark_content_4").textContent = languagemap[language].support_settings_bookmark_content_4;
	document.getElementById("support_settings_plan_title").textContent = languagemap[language].support_settings_plan_title;
	document.getElementById("support_settings_plan_content_1").textContent = languagemap[language].support_settings_plan_content_1;
	document.getElementById("support_settings_plan_content_2").textContent = languagemap[language].support_settings_plan_content_2;
	document.getElementById("support_settings_plan_content_3").textContent = languagemap[language].support_settings_plan_content_3;
	document.getElementById("support_settings_plan_content_4").textContent = languagemap[language].support_settings_plan_content_4;
}

document.getElementById("switchToEnglish").addEventListener("click", () => updateContent("en"));
document.getElementById("switchToKorean").addEventListener("click", () => updateContent("kr"));
document.getElementById("switchToChinese").addEventListener("click", () => updateContent("cn"));
document.getElementById("switchToJapanese").addEventListener("click", () => updateContent("jp"));
