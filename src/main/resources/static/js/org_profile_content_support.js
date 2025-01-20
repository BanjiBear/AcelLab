let profiles = ['startupContent', 'corporateContent']

function accountContent(profile_type_id) {
	const profileContent = document.getElementById(profile_type_id);
	if(profileContent){
		profiles.forEach(function (profile) {
			element = document.getElementById(profile);
			if(element){
				element.style.display = "none";
			}
		});
		profileContent.style.display = "block";
	}
}