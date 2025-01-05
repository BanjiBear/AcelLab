document.getElementById("savecollabinfo").addEventListener('submit', function(event) {
	let dataMap = new Map();
	let members = document.getElementsByClassName('member');
	let roles = document.getElementsByName('role');
	let statuses = document.getElementsByName('status');

	if (members) {
		for (var i = 0; i < members.length; i++) {
			dataMap.set("Name " + (i + 1), members[i].textContent);
			dataMap.set("Role " + (i + 1), roles[i].value);
			dataMap.set("Status " + (i + 1), statuses[i].value);
		}
	}

	let dataObject = Object.fromEntries(dataMap);
	let hiddenInput = document.createElement('input');
	hiddenInput.type = 'hidden';
	hiddenInput.name = 'dataMap';
	hiddenInput.value = JSON.stringify(dataObject);

	this.appendChild(hiddenInput);
	this.submit();
});