let roundCount = 0;

function renumberRounds() {
  const roundTitles = document.querySelectorAll(".Financials_title");
  roundTitles.forEach((title, index) => {
    const anchorElement = title.querySelector('a');
    const imgElement = anchorElement.querySelector('img');

    // Update the text content of the title
    title.textContent = `Round ${index + 1}`;

    // Append the <a> and <img> elements back to the title
    title.appendChild(anchorElement);
    anchorElement.appendChild(imgElement);
  });
}

function addFinancialRounds() {
  roundCount++;
  const newFinanceRound = document.createElement("div");
  newFinanceRound.className = "section";
  newFinanceRound.innerHTML = `
    <br />
    <p class="Financials_title">Round ${roundCount}
      <a onclick="deleteElementByAncestor('section')">
        <img src="../images/icon/Trash.png" class="DeleteRow"/>
      </a>
    </p>
    <label for="announcedDate" class="profile_heading1">Announced Date*</label>
    <input type="date" name="announcedDate" placeholder="YYYY-MM-DD" class="filters2" required/>
    <br />
    <label for="roundInfo" class="profile_heading1">Round Info*</label>
    <select name="roundInfo" class="filters2" data-funding-id='-1'>
      <option value="">Select funding round</option>
      <option value="Accelerator Round">Accelerator Round</option>
      <option value="Pre-Seed Round">Pre-Seed Round</option>
      <option value="Seed Round">Seed Round</option>
      <option value="Pre-A Round">Pre-A Round</option>
      <option value="Series A">Series A</option>
      <option value="Series A+">Series A+</option>
      <option value="Pre-B Round">Pre-B Round</option>
      <option value="Series B">Series B</option>
      <option value="Series B+">Series B+</option>
      <option value="Series C">Series C</option>
      <option value="Series C+">Series C+</option>
      <option value="Series D">Series D</option>
      <option value="Series D+">Series D+</option>
      <option value="Series E">Series E</option>
      <option value="Series F">Series F</option>
      <option value="Series G">Series G</option>
      <option value="Series H">Series H</option>
      <option value="Late Stage Round">Late Stage Round</option>
      <option value="Mezzanine Financing">Mezzanine Financing</option>
      <option value="Bridge Round">Bridge Round</option>
      <option value="Strategic Round">Strategic Round</option>
      <option value="Follow-on Round">Follow-on Round</option>
      <option value="Extension Round">Extension Round</option>
      <option value="Parallel Round">Parallel Round</option>
      <option value="Acquisition">Acquisition</option>
      <option value="Acqui-hire">Acqui-hire</option>
      <option value="Buyout">Buyout</option>
      <option value="Takeover">Takeover</option>
      <option value="Exit">Exit</option>
      <option value="IPO">IPO</option>
      <option value="Post IPO Debt">Post IPO Debt</option>
      <option value="Post IPO Equity">Post IPO Equity</option>
      <option value="Merger & Acquisition">Merger & Acquisition</option>
      <option value="Not disclosed">Not disclosed</option>
      <option value="Convertible Note">Convertible Note</option>
      <option value="Corporate Bond">Corporate Bond</option>
      <option value="Corporate Round">Corporate Round</option>
      <option value="Crowdfunding">Crowdfunding</option>
      <option value="Debt Financing">Debt Financing</option>
      <option value="Equity">Equity</option>
      <option value="Equity Crowdfunding">Equity Crowdfunding</option>
      <option value="Grant">Grant</option>
      <option value="Initial Coin Offering (ICO)">Initial Coin Offering (ICO)</option>
      <option value="Non-equity Assistance">Non-equity Assistance</option>
      <option value="Private Equity">Private Equity</option>
      <option value="Product Crowdfunding">Product Crowdfunding</option>
      <option value="Registered Capital">Registered Capital</option>
      <option value="Secondary Market">Secondary Market</option>
      <option value="Strategic Investment">Strategic Investment</option>
      <option value="Venture - Series Unknown">Venture - Series Unknown</option>
      <option value="ICO Pre-sale">ICO Pre-sale</option>
      <option value="Regulation Crowdfunding (Reg CF)">Regulation Crowdfunding (Reg CF)</option>
      <option value="Simple Agreement for Future Equity (SAFE)">Simple Agreement for Future Equity (SAFE)</option>
      <option value="Angel Round">Angel Round</option>
    </select>
    <br />
    <label for="amountRaised" class="profile_heading1">Amount Raised*</label>
    <input type="text" name="amountRaised" placeholder="Amount raised in USD" class="filters2" required/>
    <br />
    <label for="leadInvestors" class="profile_heading1">Lead Investors*</label>
    <input type="text" name="leadInvestors" placeholder="Lead investors' names" class="filters2" required/>
    <br />
  `;
  document.getElementById("sectionsContainer").appendChild(newFinanceRound);
}

//add product
let productCount = document.getElementsByName("product_name").length;

function renumberProducts() {
  const productTitles = document.querySelectorAll(".Products_title");
  productTitles.forEach((title, index) => {
    const anchorElement = title.querySelector('a');
    const imgElement = anchorElement.querySelector('img');

    // Update the text content of the title
    title.textContent = `Product ${index + 1}`;

    // Append the <a> and <img> elements back to the title
    title.appendChild(anchorElement);
    anchorElement.appendChild(imgElement);
  });
}

function addProducts(){
  productCount++;

  const newProductRound = document.createElement("div");
  newProductRound.className = "product";
  newProductRound.innerHTML = `
      <br />
      <p class="Products_title">Product ${productCount}
        <a onclick="deleteElementByAncestor('product')">
          <img src="../images/icon/Trash.png" class="DeleteRow"/>
        </a>
      </p>
      <input type="file" id="fileInput1" name="filename1" /> <input type="file" id="fileInput2" name="filename2" />
      <br />
      <label for="product_name" class="profile_heading1">Product*</label>
      <input type="text" name="product_name" placeholder="Product Name" class="filters2" required data-product-id='-1'/>
      <br />
      <label for="product_description" style="vertical-align: top;" class="profile_heading1">Description*</label>
      <textarea name="product_description" rows="5" class="filters2" required></textarea>
      <br />
    `;

  document.getElementById("productsContainer").appendChild(newProductRound);
}

//add member
let memberCount = 0;

function renumberMembers() {
  const memberTitles = document.querySelectorAll(".Member_title");
  memberTitles.forEach((title, index) => {
    const anchorElement = title.querySelector('a');
    const imgElement = anchorElement.querySelector('img');

    // Update the text content of the title
    title.textContent = `Member ${index + 1}`;

    // Append the <a> and <img> elements back to the title
    title.appendChild(anchorElement);
    anchorElement.appendChild(imgElement);
  });
}

function addTeamMembers(){
  memberCount++;
  const newTeamMember = document.createElement("div");
  newTeamMember.className = "TeamInfo";
  newTeamMember.innerHTML = `
                <br />
                <p class="Member_title">Member ${memberCount}
                  <a onclick="deleteElementByAncestor('TeamInfo')">
                    <img src="../images/icon/Trash.png" class="DeleteRow"/>
                  </a>
                </p>
                <label for="member_name" class="profile_heading1">Name*</label>
                <input type="text" name="member_name" placeholder="Input your full name" class="filters2" required data-member-id='-1'/>
                <br />
                <label for="member_department" class="profile_heading1">Department*</label>
                <input
                  type="text"
                  name="member_department"
                  placeholder="Input the department you belong to"
                  class="filters2"
                  required
                />
                <br />
                <label for="member_position" class="profile_heading1">Position*</label>
                <input type="text" name="member_position" placeholder="Tell us your role" class="filters2" required />
                <br />
                <label for="member_email" class="profile_heading1">Contact Email*</label>
                <input type="email" name="member_email" placeholder="Input your email" class="filters2" required />
                <br />
                <label for="member_phone" class="profile_heading1">Contact Number*</label>
                <select name="member_areaCode" class="filters">
                  <option value="+1">+1</option>
                  <option value="+7">+7</option>
                  <option value="+20">+20</option>
                  <option value="+27">+27</option>
                  <option value="+30">+30</option>
                  <option value="+31">+31</option>
                  <option value="+32">+32</option>
                  <option value="+33">+33</option>
                  <option value="+34">+34</option>
                  <option value="+36">+36</option>
                  <option value="+39">+39</option>
                  <option value="+40">+40</option>
                  <option value="+41">+41</option>
                  <option value="+43">+43</option>
                  <option value="+44">+44</option>
                  <option value="+45">+45</option>
                  <option value="+46">+46</option>
                  <option value="+47">+47</option>
                  <option value="+48">+48</option>
                  <option value="+49">+49</option>
                  <option value="+51">+51</option>
                  <option value="+52">+52</option>
                  <option value="+53">+53</option>
                  <option value="+54">+54</option>
                  <option value="+55">+55</option>
                  <option value="+56">+56</option>
                  <option value="+57">+57</option>
                  <option value="+58">+58</option>
                  <option value="+60">+60</option>
                  <option value="+61">+61</option>
                  <option value="+62">+62</option>
                  <option value="+63">+63</option>
                  <option value="+64">+64</option>
                  <option value="+65">+65</option>
                  <option value="+66">+66</option>
                  <option value="+81">+81</option>
                  <option value="+82">+82</option>
                  <option value="+84">+84</option>
                  <option value="+86">+86</option>
                  <option value="+90">+90</option>
                  <option value="+91">+91</option>
                  <option value="+92">+92</option>
                  <option value="+93">+93</option>
                  <option value="+94">+94</option>
                  <option value="+95">+95</option>
                  <option value="+98">+98</option>
                  <option value="+211">+211</option>
                  <option value="+212">+212</option>
                  <option value="+213">+213</option>
                  <option value="+216">+216</option>
                  <option value="+218">+218</option>
                  <option value="+220">+220</option>
                  <option value="+221">+221</option>
                  <option value="+222">+222</option>
                  <option value="+223">+223</option>
                  <option value="+224">+224</option>
                  <option value="+225">+225</option>
                  <option value="+226">+226</option>
                  <option value="+227">+227</option>
                  <option value="+228">+228</option>
                  <option value="+229">+229</option>
                  <option value="+230">+230</option>
                  <option value="+231">+231</option>
                  <option value="+232">+232</option>
                  <option value="+233">+233</option>
                  <option value="+234">+234</option>
                  <option value="+235">+235</option>
                  <option value="+236">+236</option>
                  <option value="+237">+237</option>
                  <option value="+238">+238</option>
                  <option value="+239">+239</option>
                  <option value="+240">+240</option>
                  <option value="+241">+241</option>
                  <option value="+242">+242</option>
                  <option value="+243">+243</option>
                  <option value="+244">+244</option>
                  <option value="+245">+245</option>
                  <option value="+246">+246</option>
                  <option value="+248">+248</option>
                  <option value="+249">+249</option>
                  <option value="+250">+250</option>
                  <option value="+251">+251</option>
                  <option value="+252">+252</option>
                  <option value="+253">+253</option>
                  <option value="+254">+254</option>
                  <option value="+255">+255</option>
                  <option value="+256">+256</option>
                  <option value="+257">+257</option>
                  <option value="+258">+258</option>
                  <option value="+260">+260</option>
                  <option value="+261">+261</option>
                  <option value="+262">+262</option>
                  <option value="+263">+263</option>
                  <option value="+264">+264</option>
                  <option value="+265">+265</option>
                  <option value="+266">+266</option>
                  <option value="+267">+267</option>
                  <option value="+268">+268</option>
                  <option value="+269">+269</option>
                  <option value="+290">+290</option>
                  <option value="+291">+291</option>
                  <option value="+297">+297</option>
                  <option value="+298">+298</option>
                  <option value="+299">+299</option>
                  <option value="+350">+350</option>
                  <option value="+351">+351</option>
                  <option value="+352">+352</option>
                  <option value="+353">+353</option>
                  <option value="+354">+354</option>
                  <option value="+355">+355</option>
                  <option value="+356">+356</option>
                  <option value="+357">+357</option>
                  <option value="+358">+358</option>
                  <option value="+359">+359</option>
                  <option value="+370">+370</option>
                  <option value="+371">+371</option>
                  <option value="+372">+372</option>
                  <option value="+373">+373</option>
                  <option value="+374">+374</option>
                  <option value="+375">+375</option>
                  <option value="+376">+376</option>
                  <option value="+377">+377</option>
                  <option value="+378">+378</option>
                  <option value="+379">+379</option>
                  <option value="+380">+380</option>
                  <option value="+381">+381</option>
                  <option value="+382">+382</option>
                  <option value="+383">+383</option>
                  <option value="+385">+385</option>
                  <option value="+386">+386</option>
                  <option value="+387">+387</option>
                  <option value="+389">+389</option>
                  <option value="+420">+420</option>
                  <option value="+421">+421</option>
                  <option value="+423">+423</option>
                  <option value="+500">+500</option>
                  <option value="+501">+501</option>
                  <option value="+502">+502</option>
                  <option value="+503">+503</option>
                  <option value="+504">+504</option>
                  <option value="+505">+505</option>
                  <option value="+506">+506</option>
                  <option value="+507">+507</option>
                  <option value="+508">+508</option>
                  <option value="+509">+509</option>
                  <option value="+590">+590</option>
                  <option value="+591">+591</option>
                  <option value="+592">+592</option>
                  <option value="+593">+593</option>
                  <option value="+595">+595</option>
                  <option value="+597">+597</option>
                  <option value="+598">+598</option>
                  <option value="+599">+599</option>
                  <option value="+670">+670</option>
                  <option value="+672">+672</option>
                  <option value="+673">+673</option>
                  <option value="+674">+674</option>
                  <option value="+675">+675</option>
                  <option value="+676">+676</option>
                  <option value="+677">+677</option>
                  <option value="+678">+678</option>
                  <option value="+679">+679</option>
                  <option value="+680">+680</option>
                  <option value="+681">+681</option>
                  <option value="+682">+682</option>
                  <option value="+683">+683</option>
                  <option value="+685">+685</option>
                  <option value="+686">+686</option>
                  <option value="+687">+687</option>
                  <option value="+688">+688</option>
                  <option value="+689">+689</option>
                  <option value="+690">+690</option>
                  <option value="+691">+691</option>
                  <option value="+692">+692</option>
                  <option value="+850">+850</option>
                  <option value="+852">+852</option>
                  <option value="+853">+853</option>
                  <option value="+855">+855</option>
                  <option value="+856">+856</option>
                  <option value="+880">+880</option>
                  <option value="+886">+886</option>
                  <option value="+960">+960</option>
                  <option value="+961">+961</option>
                  <option value="+962">+962</option>
                  <option value="+963">+963</option>
                  <option value="+964">+964</option>
                  <option value="+965">+965</option>
                  <option value="+966">+966</option>
                  <option value="+967">+967</option>
                  <option value="+968">+968</option>
                  <option value="+970">+970</option>
                  <option value="+971">+971</option>
                  <option value="+972">+972</option>
                  <option value="+973">+973</option>
                  <option value="+974">+974</option>
                  <option value="+975">+975</option>
                  <option value="+976">+976</option>
                  <option value="+977">+977</option>
                  <option value="+992">+992</option>
                  <option value="+993">+993</option>
                  <option value="+994">+994</option>
                  <option value="+995">+995</option>
                  <option value="+996">+996</option>
                  <option value="+998">+998</option>
                </select>
                <input type="tel" name="member_phone" placeholder="12345678" class="filters5" required />
                <br />
                <label for="member_linkedin" class="profile_heading1">Linkedin URL</label>
                <input
                  type="url"
                  name="member_linkedin"
                  placeholder="https://linkedin.com/company/acel-lab-limited"
                  class="filters2"
                />
                <br />
            `;
  document.getElementById("TeamContainer").appendChild(newTeamMember);
}

function deleteElementByAncestor(ancestorClassName) {
  if (event.target.classList.contains('DeleteRow')) {
    const ancestorElement = event.target.closest(`.${ancestorClassName}`);
    if (ancestorElement) {
      ancestorElement.remove();

      if(ancestorClassName === 'section'){
        roundCount--;
        renumberRounds();
      } else if(ancestorClassName === 'product'){
        productCount--;
        renumberProducts();
      } else if(ancestorClassName === 'TeamInfo'){
        memberCount--;
        renumberMembers();
      }
    }
  }
}

//adding tags
// Get the tags and input elements from the DOM
const tags = document.getElementById("tags");
const input = document.getElementById("input-tag");

// Add an event listener for keydown on the input element
input.addEventListener("keydown", function (event) {
  // Check if the key pressed is 'Enter'
  if (event.key === "Enter") {
    // Prevent the default action of the keypress
    // event (submitting the form)
    event.preventDefault();

    // Create a new list item element for the tag
    const tag = document.createElement("li");

    // Get the trimmed value of the input element
    const tagContent = input.value.trim();

    // If the trimmed value is not an empty string
    if (tagContent !== "") {
      // Set the text content of the tag to
      // the trimmed value
      tag.innerText = tagContent;

      // Add a delete button to the tag
      tag.innerHTML += '<button class="delete-button">X</button>';

      // Append the tag to the tags list
      tags.appendChild(tag);

      // Clear the input element's value
      input.value = "";
    }
  }
});

// Add an event listener for click on the tags list
tags.addEventListener("click", function (event) {
  // If the clicked element has the class 'delete-button'
  if (event.target.classList.contains("delete-button")) {
    // Remove the parent element (the tag)
    event.target.parentNode.remove();
  }
});

//Contacts pop-up
function myFunction() {
  var contact_card_viewmore = document.getElementById("myPopup");
  contact_card_viewmore.classList.toggle("show");
}

//show Password
function mouseoverPass() {
  let obj = document.getElementById("pwordInput");
  obj.type = "text";
}
function mouseoutPass() {
  let obj = document.getElementById("pwordInput");
  obj.type = "password";
}

//adding tags
const tagsInput = document.getElementById("input-tag");
const tagsList = document.getElementById("tags");

tagsInput.addEventListener("keyup", function (event) {
  if (event.key === "Enter" || event.keyCode === 13) {
    const tagText = this.value.trim();
    if (tagText && tagsList.children.length < 10) {
      const tag = document.createElement("li");
      tag.textContent = tagText;
      tagsList.appendChild(tag);
      this.value = "";
    } else if (tagsList.children.length >= 10) {
      alert("You can only add up to 10 tags.");
      this.disabled = true; // Disable the input field when the tag limit is reached
    }
  }
});

tagsList.addEventListener("click", function (event) {
  if (event.target.tagName === "LI") {
    event.target.remove();
    if (tagsList.children.length < 10) {
      tagsInput.disabled = false; // Re-enable the input field when a tag is deleted and count falls below the limit
    }
  }
});
