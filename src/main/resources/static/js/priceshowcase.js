//Pricing maintain leveling of bubbles
document.addEventListener("DOMContentLoaded", function () {
	const pricing2_3Elements = document.querySelectorAll(".pricing2_3");

	pricing2_3Elements.forEach((element) => {
		if (element.innerHTML.trim() === "") {
			element.style.visibility = "hidden";
		}
	});
});
