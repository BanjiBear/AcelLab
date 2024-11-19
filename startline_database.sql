-- Drop tables if they exist
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS company;
DROP TABLE IF EXISTS businessplan;

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
    product1 TEXT,
    price1 VARCHAR(20),
    product2 TEXT,
    price2 VARCHAR(20),
    product3 TEXT,
    price3 VARCHAR(20),
    product4 TEXT,
    price4 VARCHAR(20),
    product5 TEXT,
    price5 VARCHAR(20),
    product6 TEXT,
    price6 VARCHAR(20),
    product7 TEXT,
    price7 VARCHAR(20),
    product8 TEXT,
    price8 VARCHAR(20),
    product9 TEXT,
    price9 VARCHAR(20),
    product10 TEXT,
    price10 VARCHAR(20),
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
    number_of_investors BIGINT,
    funding_amount1 VARCHAR(20),
    funding_date1 VARCHAR(20),
    funding_amount2 VARCHAR(20),
    funding_date2 VARCHAR(20),
    funding_amount3 VARCHAR(20),
    funding_date3 VARCHAR(20),
    funding_amount4 VARCHAR(20),
    funding_date4 VARCHAR(20),
    funding_amount5 VARCHAR(20),
    funding_date5 VARCHAR(20)
);

-- Insert example data into company table
INSERT INTO company (company_name, website, logo, introduction, industry, headquarter, year_found, founders, company_size, phone, email1, email2, linkedIn_link, instagram_link, twitter_link, admin_name1, admin_position1, admin_email1, admin_name2, admin_position2, admin_email2, total_funding_rounds, total_funding_amount, number_of_investors)
VALUES 
('Tech Innovators Inc.', 'https://www.techinnovators.com', 'logo1.png', 'Leading tech company specializing in innovative solutions.', 'Technology', 'San Francisco, CA', 2005, 'John Doe, Jane Smith', '500-1000', '123-456-7890', 'info@techinnovators.com', 'support@techinnovators.com', 'https://www.linkedin.com/company/techinnovators', 'https://www.instagram.com/techinnovators', 'https://www.twitter.com/techinnovators', 'Alice Johnson', 'CEO', 'alice.johnson@techinnovators.com', 'Bob Williams', 'CTO', 'bob.williams@techinnovators.com', 5, '50M', 10),
('Green Energy Solutions', 'https://www.greenenergy.com', 'logo2.png', 'Pioneering sustainable energy solutions.', 'Energy', 'Austin, TX', 2010, 'Emily Davis, Michael Brown', '200-500', '987-654-3210', 'contact@greenenergy.com', 'info@greenenergy.com', 'https://www.linkedin.com/company/greenenergy', 'https://www.instagram.com/greenenergy', 'https://www.twitter.com/greenenergy', 'Sarah Lee', 'COO', 'sarah.lee@greenenergy.com', 'David Kim', 'CFO', 'david.kim@greenenergy.com', 3, '30M', 5);

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

-- Create user table with unique constraints
CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    company_id BIGINT,
    department VARCHAR(255),
    role VARCHAR(255),
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(255),
    linkedIn VARCHAR(255),
    isStartup BOOLEAN,
    business_plan_id INTEGER,
    FOREIGN KEY (company_id) REFERENCES company(id),
    FOREIGN KEY (business_plan_id) REFERENCES businessplan(id)
);

-- Insert example data into user table
INSERT INTO user (username, password, name, company_id, department, role, email, phone, linkedIn, isStartup, business_plan_id)
VALUES 
('tommy', 'password123', 'Tommy CHEN', 1, 'Engineering', 'Software Engineer', 'tommy@techinnovators.com', '123-456-7890', 'https://www.linkedin.com/in/test', TRUE, 1),
('jeffrey', 'password123', 'Jeffrey Kim', 1, 'Engineering', 'Software Engineer', 'jeffrey@techinnovators.com', '123-456-7890', 'https://www.linkedin.com/in/test', TRUE, 1),
('lucas', 'password456', 'Banjibear', 2, 'Marketing', 'Marketing Manager', 'lucas@greenenergy.com', '987-654-3210', 'https://www.linkedin.com/in/test', FALSE, 3);


-- $2a$10$EixZaYVK1fsbw1ZfbX3OXePaWxn96p36Zf4a2E4Zs7tq9j9S8K6eW
-- $2a$10$EixZaYVK1fsbw1ZfbX3OXePaWxn96p36Zf4a2E4Zs7tq9j9S8K6eW
-- $2a$10$7QJ8K5BPEstk7StfPuROJyPaWxn96p36Zf4a2E4Zs7tq9j9S8K6eW
