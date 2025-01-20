//Only allow selection of 1 plan
function updateCheck(checkboxId) {
	var checkboxes = ["startup", "free", "business", "corporate"];

	checkboxes.forEach(function (item) {
		if (item !== checkboxId) {
			document.getElementById(item).checked = false;
		}
	});
}

function pay() {
	if (
		document.getElementById("startup").checked ||
		document.getElementById("free").checked ||
		document.getElementById("business").checked ||
		document.getElementById("corporate").checked
	) {
		document.getElementById("pay").style.display = "block";
	} else {
		alert("Please select a membership option.");
	}
}