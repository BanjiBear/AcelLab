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
	document.getElementById("problem_1").textContent = languagemap[language].problem_1;
	document.getElementById("problem_title_1").textContent = languagemap[language].problem_title_1;
	document.getElementById("problem_topic_low_outreach").textContent = languagemap[language].problem_topic_low_outreach;

	document.getElementById("lets_fix").textContent = languagemap[language].lets_fix;
	document.getElementById("solution").textContent = languagemap[language].solution;
	document.getElementById("solution_title").textContent = languagemap[language].solution_title;
	document.getElementById("solution_startup_slogan").textContent = languagemap[language].solution_startup_slogan;
	document.getElementById("solution_startup_content").textContent = languagemap[language].solution_startup_content;
	document.getElementById("solution_corporate_slogan").textContent = languagemap[language].solution_corporate_slogan;
	document.getElementById("solution_corporate_content").textContent = languagemap[language].solution_corporate_content;
	document.getElementById("try_startline").textContent = languagemap[language].try_startline;
	document.getElementById("how_it_works").textContent = languagemap[language].how_it_works;
	document.getElementById("how_it_works_slogan_1").textContent = languagemap[language].how_it_works_slogan_1;
	document.getElementById("how_it_works_content_1").textContent = languagemap[language].how_it_works_content_1;
	document.getElementById("how_it_works_option_1").textContent = languagemap[language].how_it_works_option_1;
	document.getElementById("how_it_works_option_content_1").textContent = languagemap[language].how_it_works_option_content_1;
	document.getElementById("how_it_works_option_2").textContent = languagemap[language].how_it_works_option_2;
	document.getElementById("how_it_works_option_content_2").textContent = languagemap[language].how_it_works_option_content_2;
	document.getElementById("how_it_works_option_3").textContent = languagemap[language].how_it_works_option_3;
	document.getElementById("how_it_works_option_content_3").textContent = languagemap[language].how_it_works_option_content_3;
	document.getElementById("how_it_works_slogan_2").textContent = languagemap[language].how_it_works_slogan_2;
	document.getElementById("how_it_works_content_2").textContent = languagemap[language].how_it_works_content_2;
	document.getElementById("how_it_works_1").textContent = languagemap[language].how_it_works_1;

	document.getElementById("how_it_works_title_integrate_languagemap").textContent = languagemap[language].how_it_works_title_integrate_languagemap;
	document.getElementById("how_it_works_content_integrate_languagemap").textContent = languagemap[language].how_it_works_content_integrate_languagemap;
	document.getElementById("how_it_works_title_processing_languagemap").textContent = languagemap[language].how_it_works_title_processing_languagemap;
	document.getElementById("how_it_works_content_processing_languagemap").textContent = languagemap[language].how_it_works_content_processing_languagemap;
	document.getElementById("how_it_works_title_creating_insights").textContent = languagemap[language].how_it_works_title_creating_insights;
	document.getElementById("how_it_works_content_creating_insights").textContent = languagemap[language].how_it_works_content_creating_insights;

	document.getElementById("how_it_works_title_integrate_languagemap_1").textContent = languagemap[language].how_it_works_title_integrate_languagemap_1;
	document.getElementById("how_it_works_content_integrate_languagemap_1").textContent = languagemap[language].how_it_works_content_integrate_languagemap_1;
	document.getElementById("how_it_works_title_processing_languagemap_1").textContent = languagemap[language].how_it_works_title_processing_languagemap_1;
	document.getElementById("how_it_works_content_processing_languagemap_1").textContent = languagemap[language].how_it_works_content_processing_languagemap_1;
	document.getElementById("how_it_works_title_creating_insights_1").textContent = languagemap[language].how_it_works_title_creating_insights_1;
	document.getElementById("how_it_works_content_creating_insights_1").textContent = languagemap[language].how_it_works_content_creating_insights_1;

	document.getElementById("how_it_works_title_integrate_languagemap_2").textContent = languagemap[language].how_it_works_title_integrate_languagemap_2;
	document.getElementById("how_it_works_content_integrate_languagemap_2").textContent = languagemap[language].how_it_works_content_integrate_languagemap_2;
	document.getElementById("how_it_works_title_processing_languagemap_2").textContent = languagemap[language].how_it_works_title_processing_languagemap_2;
	document.getElementById("how_it_works_content_processing_languagemap_2").textContent = languagemap[language].how_it_works_content_processing_languagemap_2;
	document.getElementById("how_it_works_title_creating_insights_2").textContent = languagemap[language].how_it_works_title_creating_insights_2;
	document.getElementById("how_it_works_content_creating_insights_2").textContent = languagemap[language].how_it_works_content_creating_insights_2;

	document.getElementById("how_it_works_slogan_3").textContent = languagemap[language].how_it_works_slogan_3;
	document.getElementById("why_startline_title_why_startline").textContent = languagemap[language].why_startline_title_why_startline;
	document.getElementById("why_startline_title_exceptional_languagemap_quality").textContent =
		languagemap[language].why_startline_title_exceptional_languagemap_quality;
	document.getElementById("why_startline_content_exceptional_languagemap_quality").textContent =
		languagemap[language].why_startline_content_exceptional_languagemap_quality;
	document.getElementById("why_startline_title_indepth_languagemap").textContent = languagemap[language].why_startline_title_indepth_languagemap;
	document.getElementById("why_startline_content_indepth_languagemap").textContent = languagemap[language].why_startline_content_indepth_languagemap;
	document.getElementById("why_startline_title_extensive_access").textContent = languagemap[language].why_startline_title_extensive_access;
	document.getElementById("why_startline_content_extensive_acess").textContent = languagemap[language].why_startline_content_extensive_acess;
	document.getElementById("why_startline_title_efficiency").textContent = languagemap[language].why_startline_title_efficiency;
	document.getElementById("why_startline_content_efficiency").textContent = languagemap[language].why_startline_content_efficiency;
	document.getElementById("why_startline_title_complete_solution").textContent = languagemap[language].why_startline_title_complete_solution;
	document.getElementById("why_startline_content_complete_solution").textContent = languagemap[language].why_startline_content_complete_solution;
	document.getElementById("why_startline_title_fully_automated").textContent = languagemap[language].why_startline_title_fully_automated;
	document.getElementById("why_startline_content_fully_automated").textContent = languagemap[language].why_startline_content_fully_automated;

	document.getElementById("questions").textContent = languagemap[language].questions;
	document.getElementById("questions_slogan").textContent = languagemap[language].questions_slogan;
	document.getElementById("questions_content").textContent = languagemap[language].questions_content;
	document.getElementById("questions_contact").textContent = languagemap[language].questions_contact;
	document.getElementById("footer").textContent = languagemap[language].footer;
	document.getElementById("terms").textContent = languagemap[language].terms;
	document.getElementById("privacy").textContent = languagemap[language].privacy;

	document.getElementById("problem_topic_low_outreach").textContent = languagemap[language].problem_topic_low_outreach;
	document.getElementById("problem_topic_languagemap_inaccuracy").textContent = languagemap[language].problem_topic_languagemap_inaccuracy;
	document.getElementById("problem_topic_complex_engagement").textContent = languagemap[language].problem_topic_complex_engagement;
	document.getElementById("problem_topic_lack_of_manpower").textContent = languagemap[language].problem_topic_lack_of_manpower;
	document.getElementById("problem_topic_poor_visualization").textContent = languagemap[language].problem_topic_poor_visualization;
}

document.getElementById("switchToEnglish").addEventListener("click", () => updateContent("en"));
document.getElementById("switchToKorean").addEventListener("click", () => updateContent("kr"));
document.getElementById("switchToChinese").addEventListener("click", () => updateContent("cn"));
document.getElementById("switchToJapanese").addEventListener("click", () => updateContent("jp"));
