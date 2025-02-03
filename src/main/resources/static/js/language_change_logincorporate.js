import languagemap from "./languagemap.js";

function updateContent(language) {
  switch (language) {
    case "cn":
      document.body.style.fontFamily = "Noto Sans TC, sans-serif";
      break;
    case "jp":
      document.body.style.fontFamily = "Noto Sans JP, sans-serif";
      break;
    case "kr":
      document.body.style.fontFamily = "Noto Sans KR, sans-serif";
      break;
    case "en":
    default:
      document.body.style.fontFamily = "Carlito, sans-serif";
      break;
  }
  const inputText = {
    en: ["At least 12 characters"],
    kr: ["12자 이상 입력 해주세요"],
    cn: ["至少12个字符"],
    jp: ["12文字以上"],
  };

  document.getElementById("nav_bar_aboutus").textContent = languagemap[language].nav_bar_aboutus;
  document.getElementById("nav_bar_price").textContent = languagemap[language].nav_bar_price;
  document.getElementById("nav_bar_resources").textContent = languagemap[language].nav_bar_resources;
  document.getElementById("nav_bar_support").textContent = languagemap[language].nav_bar_support;
  document.getElementById("nav_bar_contact").textContent = languagemap[language].nav_bar_contact;
  document.getElementById("nav_bar_login").textContent = languagemap[language].nav_bar_login;
  document.getElementById("nav_bar_register").textContent = languagemap[language].nav_bar_register;
  document.getElementById("login_startup").textContent = languagemap[language].login_startup;
  document.getElementById("login_corporate").textContent = languagemap[language].login_corporate;
  document.getElementById("login_welcome_back").textContent = languagemap[language].login_welcome_back;
  document.getElementById("login_corporate_slogan").textContent = languagemap[language].login_corporate_slogan;
  document.getElementById("login_work_email").textContent = languagemap[language].login_work_email;
  document.getElementById("login_password").textContent = languagemap[language].login_password;
  document.getElementById("pwordInput").placeholder = inputText[language][0];
  document.getElementById("login_remember").textContent = languagemap[language].login_remember;
  document.getElementById("login_forgot_pwd").textContent = languagemap[language].login_forgot_pwd;
  document.getElementById("login_sign_in").textContent = languagemap[language].login_sign_in;
  document.getElementById("login_sign_up").textContent = languagemap[language].login_sign_up;

  document.getElementById("footer").textContent = languagemap[language].footer;
  document.getElementById("terms").textContent = languagemap[language].terms;
  document.getElementById("privacy").textContent = languagemap[language].privacy;
}

document.getElementById("switchToEnglish").addEventListener("click", () => updateContent("en"));
document.getElementById("switchToKorean").addEventListener("click", () => updateContent("kr"));
document.getElementById("switchToChinese").addEventListener("click", () => updateContent("cn"));
document.getElementById("switchToJapanese").addEventListener("click", () => updateContent("jp"));
