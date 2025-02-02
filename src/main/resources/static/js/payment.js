//Only allow selection of 1 plan
function updateCheck(checkboxId) {
	var checkboxes = ["startup", "free", "business", "enterprise"];

	checkboxes.forEach(function (item) {
		if (item !== checkboxId) {
			document.getElementById(item).checked = false;
		}
	});
}

const form = document.getElementById('priceform');
form.addEventListener('submit', function(event) {
	event.preventDefault();

	let plans = ["startup", "free", "business", "enterprise"];
	let hasplan = false;
	let plan = undefined;
	plans.forEach(function (item) {
		element = document.getElementById(item);
		if(element){
			if(element.checked){
				hasplan = true;
				plan = element.value;
			}
		}
	});

	if(!hasplan){
		alert("Please select a membership option.");
	} else{
		let hiddenInput = document.createElement('input');
		hiddenInput.type = 'hidden';
		hiddenInput.name = 'plan';
		hiddenInput.value = plan;

		this.appendChild(hiddenInput);
		this.submit();
	}
});