document.getElementById("savecollabinfo").addEventListener('submit', function(event) {
	let dataMap = new Map();
	let members = document.getElementsByClassName('member');
	let roles = document.getElementsByName('role');
	let statuses = document.getElementsByName('status');

	let hasAdmin = false;
	let hasActive = false;

	if (members) {
		for (var i = 0; i < members.length; i++) {
			if(roles[i].value == "admin"){
				hasAdmin = true;
			}
			if(statuses[i].value == "Active"){
				hasActive = true;
			}
			dataMap.set("Name " + (i + 1), members[i].textContent);
			dataMap.set("Role " + (i + 1), roles[i].value);
			dataMap.set("Status " + (i + 1), statuses[i].value);
		}
	}

	if(!hasAdmin){
		alert("You must at least have an admin among your account collaborators!")
	}
	if(!hasActive){
		alert("You must at least have one active account among your account collaborators!")
	}

	let dataObject = Object.fromEntries(dataMap);
	let hiddenInput = document.createElement('input');
	hiddenInput.type = 'hidden';
	hiddenInput.name = 'dataMap';
	hiddenInput.value = JSON.stringify(dataObject);

	this.appendChild(hiddenInput);
	this.submit();
});