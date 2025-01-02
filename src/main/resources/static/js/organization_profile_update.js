function updateOrganizationFormSubmit(elementId){
	document.getElementById(elementId).addEventListener('submit', function(event) {
		//Prevent default form submission
		event.preventDefault();

		let dataMap = new Map();
		dataMap.set("Name", document.getElementById("organization_name").value);
		dataMap.set("Introduction", document.getElementById("organization_introduction").value);
		dataMap.set("Email", document.getElementById("organization_email").value);
		dataMap.set("Phone", document.getElementById("organization_areacode").value + '-' + document.getElementById("organization_phone").value);
		dataMap.set("Website", document.getElementById("organization_website").value);
		dataMap.set("Size", document.getElementById("organization_size").value);
		dataMap.set("Year", document.getElementById("organization_foundedyear").value);
		dataMap.set("Industry", document.getElementById("organization_industry").value);
		dataMap.set("Headquarter", document.getElementById("organization_headquarter").value);

		let ul = document.getElementById("tags");
		if (ul) {
			let li = ul.getElementsByTagName("li");
			for (var i = 0; i < li.length; i++) {
				dataMap.set("tag" + i, li[i].firstChild.nodeValue.trim());
			}
		}

		let productName = document.getElementsByName("product_name");
		if (productName) {
			for (var i = 0; i < productName.length; i++) {
				dataMap.set("Product Name " + (i + 1), productName[i].value);
				dataMap.set("Product ID " + (i + 1), productName[i].getAttribute("data-product-id"));
			}
		}
		let productDesc = document.getElementsByName("product_description");
		if (productDesc) {
			for (var i = 0; i < productDesc.length; i++) {
				dataMap.set("Product Desc " + (i + 1), productDesc[i].value);
			}
		}

		let fundingDates = document.getElementsByName("announcedDate");
		if (fundingDates) {
			for (var i = 0; i < fundingDates.length; i++) {
				dataMap.set("Funidng Date " + (i + 1), fundingDates[i].value);
			}
		}
		let rounds = document.getElementsByName("roundInfo");
		if (rounds) {
			for (var i = 0; i < rounds.length; i++) {
				dataMap.set("Round " + (i + 1), rounds[i].value);
				dataMap.set("Funding ID " + (i + 1), rounds[i].getAttribute("data-funding-id"));
			}
		}
		let amounts = document.getElementsByName("amountRaised");
		if (amounts) {
			for (var i = 0; i < amounts.length; i++) {
				dataMap.set("Amount " + (i + 1), amounts[i].value);
			}
		}
		let investors = document.getElementsByName("leadInvestors");
		if (investors) {
			for (var i = 0; i < investors.length; i++) {
				dataMap.set("Investors " + (i + 1), investors[i].value);
			}
		}

		let memberName = document.getElementsByName("member_name");
		if (memberName) {
			for (var i = 0; i < memberName.length; i++) {
				dataMap.set("Member Name " + (i + 1), memberName[i].value);
				dataMap.set("Member ID " + (i + 1), memberName[i].getAttribute("data-member-id"));
			}
		}
		let memberDept = document.getElementsByName("member_department");
		if (memberDept) {
			for (var i = 0; i < memberDept.length; i++) {
				dataMap.set("Member Dept " + (i + 1), memberDept[i].value);
			}
		}
		let memberPos = document.getElementsByName("member_position");
		if (memberPos) {
			for (var i = 0; i < memberPos.length; i++) {
				dataMap.set("Member Pos " + (i + 1), memberPos[i].value);
			}
		}
		let memberEmail = document.getElementsByName("member_email");
		if (memberEmail) {
			for (var i = 0; i < memberEmail.length; i++) {
				dataMap.set("Member Email " + (i + 1), memberEmail[i].value);
			}
		}
		let memberCode = document.getElementsByName("member_areaCode");
		let memberPhone = document.getElementsByName("member_phone");
		if (memberPhone) {
			for (var i = 0; i < memberPhone.length; i++) {
				dataMap.set("Member Phone " + (i + 1), memberCode[i].value + '-' + memberPhone[i].value);
			}
		}
		let memberLinkedIn = document.getElementsByName("member_linkedin");
		if (memberLinkedIn) {
			for (var i = 0; i < memberLinkedIn.length; i++) {
				dataMap.set("Member LinkedIn " + (i + 1), memberLinkedIn[i].value);
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
}

function addInputValidation(elementId, regex) {
	document.getElementById(elementId).addEventListener('input', function(event) {
		const inputValue = event.target.value;

		let sanitizedValue = '';
		for (let i = 0; i < inputValue.length; i++) {
			if (regex.test(inputValue[i])) {
				sanitizedValue += inputValue[i];
			}
		}

		if (sanitizedValue !== inputValue) {
			event.target.value = sanitizedValue;
		}
	});
}
addInputValidation("organization_name", /^[\p{L}\s]*$/u);
addInputValidation("organization_phone", /^\d*$/);
addInputValidation("organization_size", /^[\d-]+$/);

const fieldsToTestOnlyUnicodeAndDigits = ['product_name', 'amountRaised', 'member_position'];
const fieldsToTestOnlyUnicodeAndComma = ['leadInvestors'];
const fieldsToTestOnlyUnicode = ['member_name', 'member_department'];
const fieldsToTestOnlyDigits = ['member_phone'];
function handleInputEvent(event) {
	const target = event.target;
	const inputValue = target.value;
	
	function isValidInput(regex) {
		let sanitizedValue = '';
		for (let i = 0; i < inputValue.length; i++) {
			if (regex.test(inputValue[i])) {
				sanitizedValue += inputValue[i];
			}
		}
		target.value = sanitizedValue;
	}
	
	if (target.tagName === 'INPUT' && fieldsToTestOnlyUnicode.includes(target.name)) {
		const regex = /^[\p{L}\s]*$/u;
		isValidInput(regex);
	} else if(target.tagName === 'INPUT' && fieldsToTestOnlyUnicodeAndDigits.includes(target.name)){
		const regex = /^[\p{L}\p{N}\s]*$/u;
		isValidInput(regex);
	} else if(target.tagName === 'INPUT' && fieldsToTestOnlyUnicodeAndComma.includes(target.name)){
		const regex = /^[\p{L}\s,]*$/u;
		isValidInput(regex);
	} else if(target.tagName === 'INPUT' && fieldsToTestOnlyDigits.includes(target.name)){
		const regex = /^\d*$/;
		isValidInput(regex);
	}
}
// Event delegation for TeamContainer, productsContainer, sectionsContainer
document.getElementById('TeamContainer').addEventListener('input', handleInputEvent);
document.getElementById('productsContainer').addEventListener('input', handleInputEvent);
document.getElementById('sectionsContainer').addEventListener('input', handleInputEvent);