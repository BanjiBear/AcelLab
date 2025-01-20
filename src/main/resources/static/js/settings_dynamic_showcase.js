//Change content for settings support page
function showContent(type) {
	const accountSetting = document.getElementById("accountSetting");
	const teamSetting = document.getElementById("teamSetting");
	const bookmarkSetting = document.getElementById("bookmarkSetting");
	const planSetting = document.getElementById("planSetting");

	if (type === "account") {
		accountSetting.style.display = "block";
		teamSetting.style.display = "none";
		bookmarkSetting.style.display = "none";
		planSetting.style.display = "none";
	} else if (type === "team") {
		accountSetting.style.display = "none";
		teamSetting.style.display = "block";
		bookmarkSetting.style.display = "none";
		planSetting.style.display = "none";
	} else if (type === "bookmark") {
		accountSetting.style.display = "none";
		teamSetting.style.display = "none";
		bookmarkSetting.style.display = "block";
		planSetting.style.display = "none";
	} else if (type === "plan") {
		accountSetting.style.display = "none";
		teamSetting.style.display = "none";
		bookmarkSetting.style.display = "none";
		planSetting.style.display = "block";
	}
}