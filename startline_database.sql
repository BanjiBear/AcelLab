-- Drop tables if they exist
DROP TABLE IF EXISTS bookmark;
DROP TABLE IF EXISTS user;

DROP TABLE IF EXISTS companyproducts;
DROP TABLE IF EXISTS companyfundings;
DROP TABLE IF EXISTS company;

DROP TABLE IF EXISTS startupteam;
DROP TABLE IF EXISTS startupproducts;
DROP TABLE IF EXISTS startupfundings;
DROP TABLE IF EXISTS startup;
DROP TABLE IF EXISTS corporate;

DROP TABLE IF EXISTS businessplan;

-- DROP TABLE IF EXISTS startup;
-- DROP TABLE IF EXISTS corporate;

-- Create company table
CREATE TABLE company (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    company_name VARCHAR(255) NOT NULL,
    website VARCHAR(255) NOT NULL,
    logo VARCHAR(255),
    introduction TEXT,
    industry VARCHAR(255),
    headquarter VARCHAR(255),
    location1 TEXT,
    location2 TEXT,
    location3 TEXT,
    location4 TEXT,
    location5 TEXT,
    year_found INTEGER,
    founders VARCHAR(255),
    company_size VARCHAR(50),
    solution TEXT,
    tag0 VARCHAR(30),
    tag1 VARCHAR(30),
    tag2 VARCHAR(30),
    tag3 VARCHAR(30),
    tag4 VARCHAR(30),
    tag5 VARCHAR(30),
    tag6 VARCHAR(30),
    tag7 VARCHAR(30),
    tag8 VARCHAR(30),
    tag9 VARCHAR(30),
    phone VARCHAR(255),
    email1 VARCHAR(255),
    email2 VARCHAR(255),
    linkedIn_link VARCHAR(255),
    instagram_link VARCHAR(255),
    twitter_link VARCHAR(255),
    admin_name1 VARCHAR(255),
    admin_position1 VARCHAR(255),
    admin_email1 VARCHAR(255),
    admin_name2 VARCHAR(255),
    admin_position2 VARCHAR(255),
    admin_email2 VARCHAR(255),
    total_funding_rounds BIGINT,
    total_funding_amount VARCHAR(20),
    number_of_investors BIGINT
);

-- Create companyproducts table
CREATE TABLE companyproducts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    company_id BIGINT,
    product_name VARCHAR(50),
    product_description TEXT,
    FOREIGN KEY (company_id) REFERENCES company(id)
);

-- Create companyfundings table
CREATE TABLE companyfundings (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    company_id BIGINT,
    funding_round VARCHAR(100),
    funding_amount VARCHAR(50),
    funding_date DATE,
    funding_investors VARCHAR(150),
    FOREIGN KEY (company_id) REFERENCES company(id)
);


-- Insert example data into company table
INSERT INTO company (company_name, website, logo, introduction, industry, headquarter, location1, location2, location3, location4, location5, year_found, founders, company_size, solution, tag0, tag1, tag2, tag3, tag4, tag5, tag6, tag7, tag8, tag9, phone, email1, email2, linkedIn_link, instagram_link, twitter_link, total_funding_rounds, total_funding_amount)
VALUES 
('10x banking', 
    'https://www.10xbanking.com', 
    'logo1.png', 
    'The 10x Banking platform offers the best of both worlds, driving a generational leap forward in core banking technology; the world’s first “meta core”. Its modular, highly scalable and customizable core uniquely allows banks to build hyper-personalized products at high-speed and low-cost, using a combination of configuration and coding, supporting any programming language.<br/>So far, true core banking transformation has been held back by the compromise between fast-to-market but inflexible "configuration" neo cores on one hand, and flexible but highly complex and costly "framework" neo cores on the other.<br/>The 10x Banking platform offers the best of both worlds, driving a generational leap forward in core banking technology; the world’s first “meta core”. Its modular, highly scalable and customizable core uniquely allows banks to build hyper-personalized products at high-speed and low-cost, using a combination of configuration and coding, supporting any programming language.<br/>Proven across transformational deployments including Chase UK, Old Mutual and Westpac, 10x Banking offers Retail, SME and Corporate/Commercial banks an accelerated, de-risked pathway to full cloud-native transformation.', 
    'Software Development', 
    'London, England', 
    'Suite A, 5th Floor, 33 Holborn, London EC1N 2HT, United Kingdom', 
    'Sydney Austrailia', 
    '', 
    '', 
    '', 
    2016, 
    'Antony Jenkins, Brad Goodall', 
    '201-500 employees', 
    '10X Banking specialize in providing financial and banking services for customers, banks, and society', 
    '#fintech', 
    '#banking transformation', 
    '#core banking', 
    '#cloud-native', 
    '#digital banking', 
    '', 
    '', 
    '', 
    '', 
    '', 
    '0000-0000', 
    'Info@10xbanking.com', 
    '',
    'https://www.linkedin.com/company/10x-banking', 
    'https://instagram.com/lifeat10xbanking', 
    'https://twitter.com/10xbanking', 
    4, 
    '$35MUSD'),
('2C2P', 
    'https://www.2c2p.com', 
    'logo2.png', 
    '2C2P is a global payments platform helping businesses securely accept payments across online, mobile and in-store channels. The company is headquartered in Singapore and operates across Southeast Asia and Hong Kong. It is the preferred payments platform provider of regional airlines, travel companies and global retailers. ', 
    'Financial Services', 
    'Singapore', 
    '', 
    '', 
    '', 
    '', 
    '', 
    2003, 
    'Andy Hidayat, Aung Kyaw Moe, Piyachart Ratanaprasartporn', 
    '501-1,000 employees', 
    '', 
    '#payment processing', 
    '#e-commerce', 
    '#3dsecure', 
    '',
    '', 
    '', 
    '', 
    '', 
    '', 
    '', 
    '6566109106', 
    'contact@2c2p.com', 
    '',
    'https://sg.linkedin.com/company/2c2p', 
    NULL, 
    'https://twitter.com/2c2p?lang=en', 
    8, 
    '$35MUSD'),
('Züs', 'https://zus.network/?v=1', 'logo3.png', 
    'AI-Ready Secure Distributed Storage.<br/>Protect against internal breach, exceed GDPR compliance, and simplify secure collaboration with shared drives.<br/><br/>Performance and Scalability for Cloud Native Apps<br/>● Scalable data speeds increase with the number of Züs instances, delivering near wire-speed performance<br/>● Fast query responses under 100ms, even with billions of files. No database required<br/>● Support for unlimited file sizes<br/>● Support fast content searches across all text files<br/><br/>Management<br/>● Deployable in minutes with a user-friendly, UI-driven configuration process<br/>● Effortlessly view, share, and manage files, including encrypted files, with ease<br/>● Intuitive, Dropbox-like UI for effortless file viewing and sharing<br/>● Streamlined management requiring just one IT manager to configure and deploy in minutes, enhancing productivity<br/><br/>Security<br/>● Near 100% protection with split-key signatures and data fragmentation, ensuring that even in the event of a server breach, neither the key nor the full content is compromised<br/>● Encrypted file sharing with near-perfect privacy via proxy re-encryption, allowing secure sharing of encrypted file URLs in public—accessible only by the intended recipient<br/>● Total Control: You have full control over data availability and location<br/>● Privacy by Design: No one, including cloud providers or the government can access your data<br/><br/>Cost<br/>● Significant cost savings of 25-50% compared to AWS EBS, EFS, and S3 storage options<br/>● Scale-out storage for both ephemeral and persistent data across VMs, containers, servers<br/>● No egress or API fees, regardless of whether the on-prem is shared, dedicated, or rented<br/>● Built-in, always-on data recovery ensures near 100% availability, eliminating the need for backups or disaster recovery solutions<br/><br/>Sustainability<br/>● 25-50% CO2 reduction due to less disk and power usage with Züs\' efficient architecture, compared to traditional replication methods.', 
    'IT Services and IT Consulting', 'Cupertino, CA', 'Cupertino, Cupertino, CA 95014, US', '', '', '', '', 2017, '', '11-50 employees', 'IT solution', '#privacy', '#GDPR', '#data protection', '#secured sharing', '#private sharing', '#web3', '#blockchain', '#multicloud', '#cloud storage', '#decentralized', NULL, NULL, NULL, 'https://www.linkedin.com/company/zusnetwork/', NULL, 'https://twitter.com/zus_network', NULL, NULL);

-- Insert example data into companyproducts table
INSERT INTO companyproducts (company_id, product_name, product_description)
VALUES 
(1, 'SuperCore', 'A cloud-native core banking platform designed to modernize core banking systems, enabling banks to launch digital banks and integrate with existing tech ecosystems.'),
(1, 'Managed Service', 'A SaaS-managed service ensuring the resilience and availability of the core banking platform, including 24x7 SecOps and hands-on support throughout the project lifecycle.'),
(1, 'Bank Manager', 'A no-code product builder that allows banks to design, test, and launch banking products quickly.'),
(1, 'API-first and Event-driven Architecture', 'Facilitates the integration of real-time banking data with a bank\'s existing technology stack, enhancing the ability to provide a unified customer view.'),
(1, 'Cloud Migration Support', 'Support for banks in migrating to the cloud, including a phased approach to migration, reconciliation processes, and real-time monitoring for continuous service.'),
(2, 'Eco-Friendly Water Bottle', 'A reusable water bottle made from sustainable materials, designed to keep your drinks cold for up to 24 hours and hot for up to 12 hours.'),
(2, 'Wireless Earbuds', 'High-quality wireless earbuds with noise-cancellation technology, offering up to 8 hours of playtime on a single charge and a compact charging case.'),
(3, 'Smart Home Hub', 'A central hub for all your smart home devices, allowing you to control lights, thermostats, and security systems with voice commands or a mobile app.'),
(3, 'Organic Cotton T-Shirt', 'A soft and comfortable t-shirt made from 100% organic cotton, available in various colors and sizes, perfect for everyday wear.'),
(3, 'Portable Solar Charger', 'A lightweight and portable solar charger that can charge your devices on the go, featuring multiple USB ports and a durable, weather-resistant design.');

-- Insert example data into companyfundings table
INSERT INTO companyfundings (company_id, funding_round, funding_amount, funding_date, funding_investors)
VALUES 
(1, 'Seed Round', '$1M', '2020-01-15', 'Investor A'),
(1, 'Series A', '$5M', '2021-06-20', 'Investor B'),
(2, 'Series B', '$10M', '2022-03-10', 'Investor C'),
(3, 'Series C', '$15M', '2023-07-25', 'Investor D'),
(3, 'Series D', '$20M', '2024-11-05', 'Investor E');


-- Create businessplan table
CREATE TABLE businessplan (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    plan_name VARCHAR(255) NOT NULL,
    price INTEGER NOT NULL,
    description1 VARCHAR(255),
    description2 VARCHAR(255),
    description3 VARCHAR(255),
    description4 VARCHAR(255),
    description5 VARCHAR(255),
    description6 VARCHAR(255),
    description7 VARCHAR(255),
    description8 VARCHAR(255),
    description9 VARCHAR(255),
    description10 VARCHAR(255)
);

-- Insert example data into businessplan table
INSERT INTO businessplan (plan_name, price, description1, description2, description3, description4, description5, description6, description7, description8, description9, description10)
VALUES 
('Free', 0, 'Basic support', 'Access to community forums', 'Monthly updates', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('Business', 49, 'Basic support', 'Access to community forums', 'Monthly updates', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('Enterprise', 199, 'Priority support', 'Access to premium content', 'Weekly updates', 'Dedicated account manager', NULL, NULL, NULL, NULL, NULL, NULL);

-- Create startup table
CREATE TABLE startup (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    startup_name VARCHAR(255) NOT NULL,
    website VARCHAR(255) NOT NULL,
    logo VARCHAR(255),
    introduction TEXT,
    industry VARCHAR(255),
    headquarter VARCHAR(255),
    location1 TEXT,
    location2 TEXT,
    location3 TEXT,
    location4 TEXT,
    location5 TEXT,
    year_found INTEGER,
    founders VARCHAR(255),
    startup_size VARCHAR(50),
    solution TEXT,
    tag0 VARCHAR(30),
    tag1 VARCHAR(30),
    tag2 VARCHAR(30),
    tag3 VARCHAR(30),
    tag4 VARCHAR(30),
    tag5 VARCHAR(30),
    tag6 VARCHAR(30),
    tag7 VARCHAR(30),
    tag8 VARCHAR(30),
    tag9 VARCHAR(30),
    phone VARCHAR(255),
    email1 VARCHAR(255),
    email2 VARCHAR(255),
    linkedIn_link VARCHAR(255),
    instagram_link VARCHAR(255),
    twitter_link VARCHAR(255),
    admin_name1 VARCHAR(255),
    admin_position1 VARCHAR(255),
    admin_email1 VARCHAR(255),
    admin_name2 VARCHAR(255),
    admin_position2 VARCHAR(255),
    admin_email2 VARCHAR(255),
    total_funding_rounds BIGINT,
    total_funding_amount VARCHAR(20),
    number_of_investors BIGINT
);

-- Create startupteam table
CREATE TABLE startupteam (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    startup_id BIGINT NOT NULL,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(255),
    role VARCHAR(255),
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255),
    linkedIn VARCHAR(255),
    FOREIGN KEY (startup_id) REFERENCES startup(id)
);

-- Create startupproducts table
CREATE TABLE startupproducts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    startup_id BIGINT NOT NULL,
    product_name VARCHAR(50),
    product_description TEXT,
    FOREIGN KEY (startup_id) REFERENCES startup(id)
);

-- Create startupfundings table
CREATE TABLE startupfundings (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    startup_id BIGINT NOT NULL,
    funding_round VARCHAR(100),
    funding_amount VARCHAR(50),
    funding_date DATE,
    funding_investors VARCHAR(150),
    FOREIGN KEY (startup_id) REFERENCES startup(id)
);

-- Create startup table
CREATE TABLE corporate (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    company_name VARCHAR(255) NOT NULL,
    website VARCHAR(255) NOT NULL,
    logo VARCHAR(255),
    introduction TEXT,
    industry VARCHAR(255),
    headquarter VARCHAR(255),
    location1 TEXT,
    location2 TEXT,
    location3 TEXT,
    location4 TEXT,
    location5 TEXT,
    year_found INTEGER,
    founders VARCHAR(255),
    company_size VARCHAR(50),
    solution TEXT,
    tag0 VARCHAR(30),
    tag1 VARCHAR(30),
    tag2 VARCHAR(30),
    tag3 VARCHAR(30),
    tag4 VARCHAR(30),
    tag5 VARCHAR(30),
    tag6 VARCHAR(30),
    tag7 VARCHAR(30),
    tag8 VARCHAR(30),
    tag9 VARCHAR(30),
    phone VARCHAR(255),
    email1 VARCHAR(255),
    email2 VARCHAR(255),
    linkedIn_link VARCHAR(255),
    instagram_link VARCHAR(255),
    twitter_link VARCHAR(255),
    admin_name1 VARCHAR(255),
    admin_position1 VARCHAR(255),
    admin_email1 VARCHAR(255),
    admin_name2 VARCHAR(255),
    admin_position2 VARCHAR(255),
    admin_email2 VARCHAR(255),
    total_funding_rounds BIGINT,
    total_funding_amount VARCHAR(20),
    number_of_investors BIGINT
);


-- Create user table with unique constraints
CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    startup_id BIGINT,
    corporate_id BIGINT,
    department VARCHAR(255),
    role VARCHAR(255),
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(255),
    linkedIn VARCHAR(255),
    isStartup BOOLEAN NOT NULL,
    business_plan_id INTEGER NOT NULL,
    FOREIGN KEY (startup_id) REFERENCES startup(id),
    FOREIGN KEY (corporate_id) REFERENCES corporate(id),
    FOREIGN KEY (business_plan_id) REFERENCES businessplan(id)
);

-- Create bookmark table to store bookmarks of users with different companies
CREATE TABLE bookmark (
    user_id BIGINT,
    company_id BIGINT,
    PRIMARY KEY (user_id, company_id),
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (company_id) REFERENCES company(id)
);



