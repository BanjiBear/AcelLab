-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- 主機： localhost
-- 產生時間： 2024 年 08 月 29 日 17:37
-- 伺服器版本： 10.4.28-MariaDB
-- PHP 版本： 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `acel_lab_official_db`
--

-- --------------------------------------------------------

--
-- 資料表結構 `company`
--

CREATE TABLE `company` (
  `id` int(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `region` varchar(50) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `team_size` varchar(50) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `short_intro` text DEFAULT NULL,
  `background` text DEFAULT NULL,
  `field` enum('PropTech','Smart City','FinTech','Health Tech','Carbon Neutral') DEFAULT NULL,
  `segmented_field` enum('Carbon Capture','BIM','Construction Robots','Digital Twins','Modular Construction','Green Materials','Smart Office','Waste Management','Smart Parking','GIS','CIM','Smart Industry Park','Smart Security','Emergency Management','Supply Chain Finance','Anti-Fraud','Intelligent Risk Control','Robo-Advisors','Intelligent Auditing','Insurtech','Biotechnology','Medical Devices','Tele-Medicine','Medical Information','AI Analytics','Health Monitoring','Chronic Disease','Smart Detection','Embodied Carbon Calculations','Emission Management','Carbon Trading','Distributed Energy') DEFAULT NULL,
  `financing_round` enum('Grant','Pre-Seed Round','Seed Round','Pre-A Round','A Round','B Round','C Round or Above','Convertible Bonds','Others') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `company`
--

INSERT INTO `company` (`id`, `name`, `email`, `icon`, `address`, `region`, `country`, `team_size`, `website`, `short_intro`, `background`, `field`, `segmented_field`, `financing_round`) VALUES
(1, 'TechInno Co.', 'info@techinno.com', 'https://example.com/techlogo.png', '123 Tech St, San Francisco, CA', 'Abroad', 'United States', '50-100', 'https://techinno.com', 'Innovative tech solutions', 'Founded in 2015, TechInno is a leader in AI solutions.', 'FinTech', 'AI Analytics', 'B Round');

-- --------------------------------------------------------

--
-- 資料表結構 `companyMembers`
--

CREATE TABLE `companyMembers` (
  `companyId` int(255) NOT NULL,
  `userId` int(255) NOT NULL,
  `CompanyPosition` varchar(255) NOT NULL,
  `Permission` enum('Admin','Member') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `companyMembers`
--

INSERT INTO `companyMembers` (`companyId`, `userId`, `CompanyPosition`, `Permission`) VALUES
(1, 55, 'CEO', 'Admin'),
(1, 52, 'Staff', 'Member'),
(1, 54, 'Staff', 'Member');

-- --------------------------------------------------------

--
-- 資料表結構 `crm_user`
--

CREATE TABLE `crm_user` (
  `id` int(11) NOT NULL,
  `username` varchar(100) DEFAULT '',
  `passwd` varchar(60) DEFAULT NULL,
  `roleid` int(11) DEFAULT 0,
  `enterprise_roleid` int(11) DEFAULT 0 COMMENT '企业帐号角色',
  `startup_roleid` int(11) DEFAULT 0 COMMENT '初创企业角色id',
  `avatar` varchar(255) DEFAULT '',
  `nickname` varchar(50) DEFAULT '' COMMENT '昵称',
  `email` varchar(255) DEFAULT '' COMMENT '邮箱',
  `email2` varchar(255) DEFAULT '',
  `phone` varchar(255) DEFAULT '',
  `job` varchar(50) DEFAULT '',
  `website` varchar(255) DEFAULT '' COMMENT '公司官网',
  `linkedin` varchar(255) DEFAULT '' COMMENT '领英链接',
  `description` text DEFAULT NULL COMMENT '简介',
  `create_userid` int(11) DEFAULT 0 COMMENT '创建者userid',
  `cancel` int(11) DEFAULT 0 COMMENT '注销/取消时间（不能登录）',
  `status` tinyint(4) DEFAULT 0 COMMENT '状态，0=正常，1=停用',
  `last_action` int(11) DEFAULT 0 COMMENT '最后操作时间',
  `mtime` int(11) DEFAULT 0,
  `time` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='用户表';

--
-- 傾印資料表的資料 `crm_user`
--

INSERT INTO `crm_user` (`id`, `username`, `passwd`, `roleid`, `enterprise_roleid`, `startup_roleid`, `avatar`, `nickname`, `email`, `email2`, `phone`, `job`, `website`, `linkedin`, `description`, `create_userid`, `cancel`, `status`, `last_action`, `mtime`, `time`) VALUES
(51, 'samtest', '$2a$10$ESbonm/1TmAmHgYxsdu1tONJo.xam4zMowCfbW44pFYfTGbAkkYGm', 1, 0, 0, '', '', 'test@gmail.com', '', '', '', '', '', NULL, 0, 0, 0, 0, 0, 0),
(52, 'samtest2', '$2a$10$6cvVaClPTsJlAEufgrYciu0X96N/Hv.jzFy.KdYbPfTVSjTAmdfzC', 2, 0, 0, '', '', 'test2@gmail.com', '', '', '', '', '', NULL, 0, 0, 0, 0, 0, 0),
(54, 'samtest4', '$2a$10$0/aoevMFAHbMTKPSlOkohOlqz7lW0aU53JFT2jlLVHKD9NBuNfxxy', 1, 0, 0, '', '', 'samtest4@gmail', '', '', '', '', '', NULL, 0, 0, 0, 0, 0, 0),
(55, 'companyUser', '$2a$10$ycsEsTMHMXzvH.Mqq8dxd.wTI.XLLIZ9BC99McvnJqwNt.5S5/47C', 2, 0, 0, '', '', 'companyUser@gmail', '', '', '', '', '', NULL, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- 資料表結構 `role`
--

CREATE TABLE `role` (
  `Id` int(11) NOT NULL,
  `permission` enum('startup_user','company_user') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `role`
--

INSERT INTO `role` (`Id`, `permission`) VALUES
(1, 'startup_user'),
(2, 'company_user');

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `companyMembers`
--
ALTER TABLE `companyMembers`
  ADD KEY `companyId` (`companyId`),
  ADD KEY `userId` (`userId`);

--
-- 資料表索引 `crm_user`
--
ALTER TABLE `crm_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username_unique_Constraint` (`username`),
  ADD UNIQUE KEY `email_unique_constraint` (`email`),
  ADD KEY `username` (`username`) USING BTREE,
  ADD KEY `email` (`email`) USING BTREE,
  ADD KEY `roleid` (`roleid`);

--
-- 資料表索引 `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`Id`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `company`
--
ALTER TABLE `company`
  MODIFY `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `crm_user`
--
ALTER TABLE `crm_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `role`
--
ALTER TABLE `role`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 已傾印資料表的限制式
--

--
-- 資料表的限制式 `companyMembers`
--
ALTER TABLE `companyMembers`
  ADD CONSTRAINT `companymembers_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `crm_user` (`id`);

--
-- 資料表的限制式 `crm_user`
--
ALTER TABLE `crm_user`
  ADD CONSTRAINT `crm_user_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `role` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
