document.addEventListener("DOMContentLoaded", function () {
  const scrollElement = document.getElementById("scrollElement");

  const images = [...scrollElement.getElementsByTagName("img")];
  const cloneImages = images.map((img) => img.cloneNode(true));

  cloneImages.forEach((clone) => scrollElement.appendChild(clone));
});