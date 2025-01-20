const problemText = document.getElementById("problemText");

const problems = {
	lowOutreachText: {
		English:
			"Innovators struggle to find effective channels to showcase their products, while corporations face difficulty in discovering innovative solutions for their business needs.",
		Korean:
			"스타트업은 새로운 제품을 홍보 할 채널을 찾는 데 어려움을 겪으며, 기업은 필요한 혁신 솔루션을 발견하는 데 어려움을 겪고 있습니다",
		Japanese:
			"スタートアップは製品を展示するための効果的なチャネルを見つけるのに苦労し、企業はビジネスニーズに合った革新的なソリューションを見つけるのが難しいです。",
		Chinese: "初创企业在寻找有效渠道展示其产品方面面临困难，而大型企业则难以发现满足其业务需求的创新解决方案。",
	},
	DataInaccuracyText: {
		English:
			"Outdated and unverified data hampers the ability to find relevant solutions or accurately identify corporate needs, leading to unreliable searches.",
		Korean:
			"오래되고 검증되지 않은 데이터는 요구 사항을 정확하게 식별하여 관련 솔루션을 찾는데 어려움을 발생 시켜 신뢰할 수 없는 검색 결과를 제공합니다.",
		Japanese:
			"古くて未確認のデータは、関連するソリューションを見つけたり、企業のニーズを正確に特定したりする能力を妨げ、信頼できない検索結果をもたらします。",
		Chinese: "过时和未经验证的数据妨碍了用户精准识别企业需求的能力，导致搜索结果不可靠。",
	},
	ComplexEngagementText: {
		English:
			"Corporates and innovators often have prolonged engagement processes, as each party struggles to fully understand the other's need and expectations.",
		Korean: "기업과 스타트업은 종종 서로의 요구사항을 완전히 이해하는데 많은 시간을 소비하게 하여 기술 선별 과정을 복잡하게 만듭니다.",
		Japanese:
			"大企業とスタートアップの間では、相手のニーズや期待を完全に理解するのに苦労するため、エンゲージメントプロセスが長引くことがあります。",
		Chinese: "大型企业和初创企业之间的互动过程往往较长，因为双方都难以完全理解对方的需求和期望。",
	},
	LackofManpowerText: {
		English: "There are insufficient resources and manpower to maintain strong connections between innovator and corporations.",
		Korean: "스타트업과 기업 간의 원활한 소통을 유지하기 위한 충분한 자원과 인력이 부족합니다",
		Japanese: "スタートアップと企業の間で強固な関係を維持するためのリソースと人手が不足しています。",
		Chinese: "维持初创企业与大型企业之间强大联系的资源和人力不足。",
	},
	PoorVisualizationText: {
		English:
			"Poorly structured interfaces and lack of personalization makes it challenging for users to efficiently find critical information.",
		Korean: "복잡한 데이터 정리와 부족한 사용자 맞춤화로 사용자가 중요 정보를 효율적으로 찾기 어렵습니다",
		Japanese:
			"構造が不十分なインターフェースとパーソナライズの欠如により、ユーザーが重要な情報を効率的に見つけることが難しくなっています。",
		Chinese: "结构不良的界面和缺乏个性化使用户难以高效找到关键信息。",
	},
};

let selectedLanguageId = localStorage.getItem("selectedLanguageId") || "English";

document.querySelectorAll(".problemIcon").forEach((button) => {
	button.addEventListener("click", function () {
		const id = button.id + "Text";
		problemText.textContent = problems[id][selectedLanguageId];
	});
});

const languageButtons = document.querySelectorAll("button[id^='switchTo']");

languageButtons.forEach((button) => {
	button.addEventListener("click", () => {
		selectedLanguageId = button.id.slice(8); // Extract language from button id
		localStorage.setItem("selectedLanguageId", selectedLanguageId);
		console.log("selectedLanguageId: " + selectedLanguageId);
	});
});

const sections = document.querySelectorAll(".howitworks4_1");

const observer = new IntersectionObserver(
	(entries, observer) => {
		entries.forEach((entry) => {
			if (entry.isIntersecting) {
				entry.target.classList.remove("fade-out");
			} else {
				entry.target.classList.add("fade-out");
			}
		});
	},
	{ threshold: 0.5 }
);

sections.forEach((section) => {
	observer.observe(section);
});