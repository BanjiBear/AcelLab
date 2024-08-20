-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- 主機： localhost
-- 產生時間： 2024 年 08 月 20 日 07:05
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
  `company` varchar(100) DEFAULT '' COMMENT '公司',
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

INSERT INTO `crm_user` (`id`, `username`, `passwd`, `roleid`, `enterprise_roleid`, `startup_roleid`, `avatar`, `nickname`, `email`, `email2`, `phone`, `company`, `job`, `website`, `linkedin`, `description`, `create_userid`, `cancel`, `status`, `last_action`, `mtime`, `time`) VALUES
(1, 'admin', '989b02217f3ea92af4760642c639e652', 1, 0, 0, 'https://propxtech.azurewebsites.net/static/image/default-avatar.jpg', 'superuser', 'testabc@gmail.com', '', '', '', '', '', '', '', 0, 0, 0, 1715130048, 1660638719, 1655975671),
(5, 'dev01', '098e64d8c197199caf7b1d7f69fd6a5e', 2, 0, 0, 'https://propxtech.azurewebsites.net/static/image/default-avatar.jpg', 'dev01', 'dev01@propxtech.azurewebsites.net', 'dev02@propxtech.azurewebsites.net', '', 'itjuyuan.com', 'acc', 'itjuyuan.com', 'linkedln.com/dev01', 'test', 0, 0, 0, 1659192144, 1660638736, 1656407447),
(6, 'test1', '41b69e8986cb9fffbfec8518aa36a735', 1, 0, 0, '', 'test1', 'test1', '', '', 'test1', '', 'test1', 'test1', 'test1', 5, 0, 0, 1658896891, 0, 1657947367),
(7, 'test2', '543e835c44ecb801d59cde15cee3db01', 5, 0, 0, '', 'test2', 'test2', '', '', 'test2', '', 'test2', 'test2', 'test2', 5, 0, 0, 1706345293, 0, 1657967261),
(8, 'test3x', 'b081ee02e329a5982db7c3f1846bd246', 2, 0, 0, 'https://propxtech.azurewebsites.net/uploads/image/220720/JrRlwvaFKxUky.png', 'test3x', 'test3@asdsdfsdsdf.com', '', '', 'test3', '', 'test3', 'test3', 'test3', 5, 0, 0, 0, 1658320045, 1657967469),
(9, 'test4', 'b17a87fe604d2c1b3604d78885a053bd', 3, 0, 0, 'https://propxtech.azurewebsites.net/static/image/default-avatar.jpg', 'test4', 'test4@dsdf.com', '', '', 'test4', '', 'test4', 'test4', 'test4', 5, 0, 1, 1658897644, 1658591021, 1657967843),
(10, 'testing', '51be70461351f32c3be5eeeb8867623d', 3, 0, 0, 'https://propxtech.azurewebsites.net/static/image/default-avatar.jpg', 'testing', 'jack@propxtech.com', '', '', 'HKL', '', '', '', '', 1, 0, 0, 0, 1699500748, 1660204424),
(11, '222222', 'b742a447f5faf292caabea96c9b178f6', 4, 0, 0, '', '', 'fengtuyouxi@163.com', '', '', '', '', '', '', '', 0, 0, 0, 0, 0, 1688707494),
(13, '234324234', '8e9d6104e65e88a3320529a0afb2e79b', 4, 0, 0, 'http://crm.my/static/image/default-avatar.jpg', '11', '666@111.com', '', '', '33', '7777', '44', '55', '8888', 0, 0, 0, 0, 1690127303, 1688708903),
(14, '777777', '36a89186220b732c274bad9d4c121c9d', 4, 0, 0, '', '', '222', '', '', '', '', '', '', '', 0, 0, 0, 0, 0, 1688708923),
(15, '44444', 'a2cb3e4e9cdc5baa7c011c22aa446425', 4, 0, 0, '', '', '4444', '', '', '', '', '', '', '', 0, 0, 0, 0, 0, 1688709031),
(16, '123456', '3bbf2aab39d897626eaea854d0296c46', 4, 0, 0, '', '', 'fengtuyouxi@163.com1', '', '', '', '', '', '', '', 0, 0, 0, 1690271723, 1688821072, 1688744407),
(17, 'propxtech', 'd69aab0f7c0982ddac3c6cb4af814c09', 4, 0, 0, '', '', 'ghostgate@111.com', '', '', '', '', '', '', '', 0, 0, 0, 0, 0, 1688834260),
(51, 'samtest', '$2a$10$ESbonm/1TmAmHgYxsdu1tONJo.xam4zMowCfbW44pFYfTGbAkkYGm', 0, 0, 0, '', '', 'test@gmail.com', '', '', '', '', '', '', NULL, 0, 0, 0, 0, 0, 0),
(52, 'samtest2', '$2a$10$6cvVaClPTsJlAEufgrYciu0X96N/Hv.jzFy.KdYbPfTVSjTAmdfzC', 0, 0, 0, '', '', 'test2@gmail.com', '', '', '', '', '', '', NULL, 0, 0, 0, 0, 0, 0);

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `crm_user`
--
ALTER TABLE `crm_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username_unique_Constraint` (`username`),
  ADD UNIQUE KEY `email_unique_constraint` (`email`),
  ADD KEY `username` (`username`) USING BTREE,
  ADD KEY `email` (`email`) USING BTREE;

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `crm_user`
--
ALTER TABLE `crm_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
