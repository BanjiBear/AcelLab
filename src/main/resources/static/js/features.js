//Getting Started Support Page Dynamic Change
function GettingStartedContent(elementId) {
  const element = document.getElementById(elementId);

  if (element) {
    let elementList = [
      "PlanAndPricing",
      "CreatingAnAccount",
      "SettingUpAccount",
      "Personalization",
      "TechnologyTagging",
      "DailyRecommendations",
      "Search",
      "MultiAccount",
      "CreateCompanyCard",
      "LocationIdentifier",
      "accountSetting",
      "teamSetting",
      "bookmarkSetting",
      "planSetting",
    ];
    elementList.forEach(function (id) {
      var ele = document.getElementById(id);
      if (ele) {
        ele.style.display = "none";
      }
    });
    element.style.display = "block";
  }
}