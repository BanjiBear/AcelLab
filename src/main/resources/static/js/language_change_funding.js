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

	document.getElementById("support_choose_funding_rnd").textContent = languagemap[language].support_choose_funding_rnd;
	document.getElementById("support_choose_funding_rnd_content_1").textContent = languagemap[language].support_choose_funding_rnd_content_1;
	document.getElementById("support_choose_funding_rnd_content_2").textContent = languagemap[language].support_choose_funding_rnd_content_2;
	document.getElementById("support_funding_accelerator").textContent = languagemap[language].support_funding_accelerator;
	document.getElementById("support_funding_accelerator_content").textContent = languagemap[language].support_funding_accelerator_content;
	document.getElementById("support_funding_pre_seed").textContent = languagemap[language].support_funding_pre_seed;
	document.getElementById("support_funding_pre_seed_content").textContent = languagemap[language].support_funding_pre_seed_content;
	document.getElementById("support_funding_seed").textContent = languagemap[language].support_funding_seed;
	document.getElementById("support_funding_seed_content").textContent = languagemap[language].support_funding_seed_content;
	document.getElementById("support_funding_pre_a").textContent = languagemap[language].support_funding_pre_a;
	document.getElementById("support_funding_pre_a_content").textContent = languagemap[language].support_funding_pre_a_content;
	document.getElementById("support_funding_series_a").textContent = languagemap[language].support_funding_series_a;
	document.getElementById("support_funding_series_a_content").textContent = languagemap[language].support_funding_series_a_content;
	document.getElementById("support_funding_series_a_plus").textContent = languagemap[language].support_funding_series_a_plus;
	document.getElementById("support_funding_series_a_plus_content").textContent = languagemap[language].support_funding_series_a_plus_content;
	document.getElementById("support_funding_pre_b").textContent = languagemap[language].support_funding_pre_b;
	document.getElementById("support_funding_pre_b_content").textContent = languagemap[language].support_funding_pre_b_content;
	document.getElementById("support_funding_series_b").textContent = languagemap[language].support_funding_series_b;
	document.getElementById("support_funding_series_b_content").textContent = languagemap[language].support_funding_series_b_content;
	document.getElementById("support_funding_series_b_plus").textContent = languagemap[language].support_funding_series_b_plus;
	document.getElementById("support_funding_series_b_plus_content").textContent = languagemap[language].support_funding_series_b_plus_content;
	document.getElementById("support_funding_series_c").textContent = languagemap[language].support_funding_series_c;
	document.getElementById("support_funding_series_c_content").textContent = languagemap[language].support_funding_series_c_content;
	document.getElementById("support_funding_series_c_plus").textContent = languagemap[language].support_funding_series_c_plus;
	document.getElementById("support_funding_series_c_plus_content").textContent = languagemap[language].support_funding_series_c_plus_content;
	document.getElementById("support_funding_series_d").textContent = languagemap[language].support_funding_series_d;
	document.getElementById("support_funding_series_d_content").textContent = languagemap[language].support_funding_series_d_content;
	document.getElementById("support_funding_series_d_plus").textContent = languagemap[language].support_funding_series_d_plus;
	document.getElementById("support_funding_series_d_plus_content").textContent = languagemap[language].support_funding_series_d_plus_content;
	document.getElementById("support_funding_series_e").textContent = languagemap[language].support_funding_series_e;
	document.getElementById("support_funding_series_e_content").textContent = languagemap[language].support_funding_series_e_content;
	document.getElementById("support_funding_series_f").textContent = languagemap[language].support_funding_series_f;
	document.getElementById("support_funding_series_f_content").textContent = languagemap[language].support_funding_series_f_content;
	document.getElementById("support_funding_series_g").textContent = languagemap[language].support_funding_series_g;
	document.getElementById("support_funding_series_g_content").textContent = languagemap[language].support_funding_series_g_content;
	document.getElementById("support_funding_series_h").textContent = languagemap[language].support_funding_series_h;
	document.getElementById("support_funding_series_h_content").textContent = languagemap[language].support_funding_series_h_content;
	document.getElementById("support_funding_late_stage").textContent = languagemap[language].support_funding_late_stage;
	document.getElementById("support_funding_late_stage_content").textContent = languagemap[language].support_funding_late_stage_content;
	document.getElementById("support_funding_mezzanine_financing").textContent = languagemap[language].support_funding_mezzanine_financing;
	document.getElementById("support_funding_mezzanine_financing_content").textContent =
		languagemap[language].support_funding_mezzanine_financing_content;
	document.getElementById("support_funding_bridge_round").textContent = languagemap[language].support_funding_bridge_round;
	document.getElementById("support_funding_bridge_round_content").textContent = languagemap[language].support_funding_bridge_round_content;
	document.getElementById("support_funding_strategic_rnd").textContent = languagemap[language].support_funding_strategic_rnd;
	document.getElementById("support_funding_strategic_rnd_content").textContent = languagemap[language].support_funding_strategic_rnd_content;
	document.getElementById("support_funding_follow_on").textContent = languagemap[language].support_funding_follow_on;
	document.getElementById("support_funding_follow_on_content").textContent = languagemap[language].support_funding_follow_on_content;
	document.getElementById("support_funding_extension").textContent = languagemap[language].support_funding_extension;
	document.getElementById("support_funding_extension_content").textContent = languagemap[language].support_funding_extension_content;
	document.getElementById("support_funding_parallel").textContent = languagemap[language].support_funding_parallel;
	document.getElementById("support_funding_parallel_content").textContent = languagemap[language].support_funding_parallel_content;
	document.getElementById("support_funding_acquisition").textContent = languagemap[language].support_funding_acquisition;
	document.getElementById("support_funding_acquisition_content").textContent = languagemap[language].support_funding_acquisition_content;
	document.getElementById("support_funding_acqihire").textContent = languagemap[language].support_funding_acqihire;
	document.getElementById("support_funding_acqihire_content").textContent = languagemap[language].support_funding_acqihire_content;
	document.getElementById("support_funding_buyout").textContent = languagemap[language].support_funding_buyout;
	document.getElementById("support_funding_buyout_content").textContent = languagemap[language].support_funding_buyout_content;
	document.getElementById("support_funding_takeover").textContent = languagemap[language].support_funding_takeover;
	document.getElementById("support_funding_takeover_content").textContent = languagemap[language].support_funding_takeover_content;
	document.getElementById("support_funding_exit").textContent = languagemap[language].support_funding_exit;
	document.getElementById("support_funding_exit_content").textContent = languagemap[language].support_funding_exit_content;
	document.getElementById("support_funding_ipo").textContent = languagemap[language].support_funding_ipo;
	document.getElementById("support_funding_ipo_content").textContent = languagemap[language].support_funding_ipo_content;
	document.getElementById("support_funding_post_ipo_dept").textContent = languagemap[language].support_funding_post_ipo_dept;
	document.getElementById("support_funding_post_ipo_dept_content").textContent = languagemap[language].support_funding_post_ipo_dept_content;
	document.getElementById("support_funding_post_ipo_equity").textContent = languagemap[language].support_funding_post_ipo_equity;
	document.getElementById("support_funding_post_ipo_equity_content").textContent = languagemap[language].support_funding_post_ipo_equity_content;
	document.getElementById("support_funding_not_disclosed").textContent = languagemap[language].support_funding_not_disclosed;
	document.getElementById("support_funding_not_disclosed_content").textContent = languagemap[language].support_funding_not_disclosed_content;
	document.getElementById("support_funding_convertible").textContent = languagemap[language].support_funding_convertible;
	document.getElementById("support_funding_convertible_content").textContent = languagemap[language].support_funding_convertible_content;
	document.getElementById("support_funding_corporate_bond").textContent = languagemap[language].support_funding_corporate_bond;
	document.getElementById("support_funding_corporate_bond_content").textContent = languagemap[language].support_funding_corporate_bond_content;
	document.getElementById("support_funding_corporate_rnd").textContent = languagemap[language].support_funding_corporate_rnd;
	document.getElementById("support_funding_corporate_rnd_content").textContent = languagemap[language].support_funding_corporate_rnd_content;
	document.getElementById("support_funding_crowdfunding").textContent = languagemap[language].support_funding_crowdfunding;
	document.getElementById("support_funding_crowdfunding_content").textContent = languagemap[language].support_funding_crowdfunding_content;
	document.getElementById("support_funding_debt_financing").textContent = languagemap[language].support_funding_debt_financing;
	document.getElementById("support_funding_debt_financing_content").textContent = languagemap[language].support_funding_debt_financing_content;
	document.getElementById("support_funding_debt_financing_equity").textContent = languagemap[language].support_funding_debt_financing_equity;
	document.getElementById("support_funding_debt_financing_equity_content").textContent =
		languagemap[language].support_funding_debt_financing_equity_content;
	document.getElementById("support_funding_equity_crowdfunding").textContent = languagemap[language].support_funding_equity_crowdfunding;
	document.getElementById("support_funding_equity_crowdfunding_content").textContent =
		languagemap[language].support_funding_equity_crowdfunding_content;
	document.getElementById("support_funding_grant").textContent = languagemap[language].support_funding_grant;
	document.getElementById("support_funding_grant_content").textContent = languagemap[language].support_funding_grant_content;
	document.getElementById("support_funding_ico").textContent = languagemap[language].support_funding_ico;
	document.getElementById("support_funding_ico_content").textContent = languagemap[language].support_funding_ico_content;
	document.getElementById("support_funding_non_equity_assistance").textContent = languagemap[language].support_funding_non_equity_assistance;
	document.getElementById("support_funding_non_equity_assistance_content").textContent =
		languagemap[language].support_funding_non_equity_assistance_content;
	document.getElementById("support_funding_private_equity").textContent = languagemap[language].support_funding_private_equity;
	document.getElementById("support_funding_private_equity_content").textContent = languagemap[language].support_funding_private_equity_content;
	document.getElementById("support_funding_product_crowdfunding").textContent = languagemap[language].support_funding_product_crowdfunding;
	document.getElementById("support_funding_product_crowdfunding_content").textContent =
		languagemap[language].support_funding_product_crowdfunding_content;
	document.getElementById("support_funding_registered_capital").textContent = languagemap[language].support_funding_registered_capital;
	document.getElementById("support_funding_registered_capital_content").textContent =
		languagemap[language].support_funding_registered_capital_content;
	document.getElementById("support_funding_secondary_mkt").textContent = languagemap[language].support_funding_secondary_mkt;
	document.getElementById("support_funding_secondary_mkt_content").textContent = languagemap[language].support_funding_secondary_mkt_content;
	document.getElementById("support_funding_series_unknown").textContent = languagemap[language].support_funding_series_unknown;
	document.getElementById("support_funding_series_unknown_content").textContent = languagemap[language].support_funding_series_unknown_content;
	document.getElementById("support_funding_strategic_investment").textContent = languagemap[language].support_funding_strategic_investment;
	document.getElementById("support_funding_strategic_investment_content").textContent =
		languagemap[language].support_funding_strategic_investment_content;
	document.getElementById("support_funding_venture").textContent = languagemap[language].support_funding_venture;
	document.getElementById("support_funding_venture_content").textContent = languagemap[language].support_funding_venture_content;
	document.getElementById("support_funding_ico_pre_scale").textContent = languagemap[language].support_funding_ico_pre_scale;
	document.getElementById("support_funding_ico_pre_scale_content").textContent = languagemap[language].support_funding_ico_pre_scale_content;
	document.getElementById("support_funding_reg_cf").textContent = languagemap[language].support_funding_reg_cf;
	document.getElementById("support_funding_reg_cf_content").textContent = languagemap[language].support_funding_reg_cf_content;
	document.getElementById("support_funding_safe").textContent = languagemap[language].support_funding_safe;
	document.getElementById("support_funding_safe_content").textContent = languagemap[language].support_funding_safe_content;
	document.getElementById("support_funding_angel").textContent = languagemap[language].support_funding_angel;
	document.getElementById("support_funding_angel_content").textContent = languagemap[language].support_funding_angel_content;
}

document.getElementById("switchToEnglish").addEventListener("click", () => updateContent("en"));
document.getElementById("switchToKorean").addEventListener("click", () => updateContent("kr"));
document.getElementById("switchToChinese").addEventListener("click", () => updateContent("cn"));
document.getElementById("switchToJapanese").addEventListener("click", () => updateContent("jp"));
