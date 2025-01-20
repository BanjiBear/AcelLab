//Change content for Company Card content support page
function CompanyContentInfo(type) {
	const basicinfo = document.getElementById("basicinfo");
	const productinfo = document.getElementById("productinfo");
	const financeinfo = document.getElementById("financeinfo");
	const contactinfo = document.getElementById("contactinfo");

	if (type === "basic") {
		basicinfo.style.display = "block";
		productinfo.style.display = "none";
		financeinfo.style.display = "none";
		contactinfo.style.display = "none";
	} else if (type === "product") {
		basicinfo.style.display = "none";
		productinfo.style.display = "block";
		financeinfo.style.display = "none";
		contactinfo.style.display = "none";
	} else if (type === "finance") {
		basicinfo.style.display = "none";
		productinfo.style.display = "none";
		financeinfo.style.display = "block";
		contactinfo.style.display = "none";
	} else if (type === "contact") {
		basicinfo.style.display = "none";
		productinfo.style.display = "none";
		financeinfo.style.display = "none";
		contactinfo.style.display = "block";
	}
}