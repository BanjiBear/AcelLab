// FAQ Verify Account Page Dynamic Change
function verifyContent(type) {
	const CompanyDomainUser = document.getElementById("CompanyDomainUser");
	const GeneralUser = document.getElementById("GeneralUser");

	if (type === "companydomainuser") {
		CompanyDomainUser.style.display = "block";
		GeneralUser.style.display = "none";
	} else if (type === "generaluser") {
		CompanyDomainUser.style.display = "none";
		GeneralUser.style.display = "block";
	}
}