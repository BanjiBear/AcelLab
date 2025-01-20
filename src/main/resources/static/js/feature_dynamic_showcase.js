//Change content for settings
function FeatureContent(type) {
	const Personalization = document.getElementById("Personalization");
	const TechnologyTagging = document.getElementById("TechnologyTagging");
	const DailyRecommendations = document.getElementById("DailyRecommendations");
	const Search = document.getElementById("Search");
	const MultiAccount = document.getElementById("MultiAccount");
	const CreateCompanyCard = document.getElementById("CreateCompanyCard");
	const LocationIdentifier = document.getElementById("LocationIdentifier");

	if (type === "personalization") {
		Personalization.style.display = "block";
		TechnologyTagging.style.display = "none";
		DailyRecommendations.style.display = "none";
		Search.style.display = "none";
		MultiAccount.style.display = "none";
		CreateCompanyCard.style.display = "none";
		LocationIdentifier.style.display = "none";
	} else if (type === "technologytagging") {
		Personalization.style.display = "none";
		TechnologyTagging.style.display = "block";
		DailyRecommendations.style.display = "none";
		Search.style.display = "none";
		MultiAccount.style.display = "none";
		CreateCompanyCard.style.display = "none";
		LocationIdentifier.style.display = "none";
	} else if (type === "dailyrecommendations") {
		Personalization.style.display = "none";
		TechnologyTagging.style.display = "none";
		DailyRecommendations.style.display = "block";
		Search.style.display = "none";
		MultiAccount.style.display = "none";
		CreateCompanyCard.style.display = "none";
		LocationIdentifier.style.display = "none";
	} else if (type === "search") {
		Personalization.style.display = "none";
		TechnologyTagging.style.display = "none";
		DailyRecommendations.style.display = "none";
		Search.style.display = "block";

		MultiAccount.style.display = "none";
		CreateCompanyCard.style.display = "none";
		LocationIdentifier.style.display = "none";
	} else if (type === "multiaccount") {
		Personalization.style.display = "none";
		TechnologyTagging.style.display = "none";
		DailyRecommendations.style.display = "none";
		Search.style.display = "none";
		MultiAccount.style.display = "block";
		CreateCompanyCard.style.display = "none";
		LocationIdentifier.style.display = "none";
	} else if (type === "createcompanycard") {
		Personalization.style.display = "none";
		TechnologyTagging.style.display = "none";
		DailyRecommendations.style.display = "none";
		Search.style.display = "none";
		MultiAccount.style.display = "none";
		CreateCompanyCard.style.display = "block";
		LocationIdentifier.style.display = "none";
	} else if (type === "locationidentifier") {
		Personalization.style.display = "none";
		TechnologyTagging.style.display = "none";
		DailyRecommendations.style.display = "none";
		Search.style.display = "none";
		MultiAccount.style.display = "none";
		CreateCompanyCard.style.display = "none";
		LocationIdentifier.style.display = "block";
	}
}