
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sales_order_line
-- ----------------------------
DROP TABLE IF EXISTS `sales_order_line`;
CREATE TABLE `sales_order_line` (
  `id` bigint NOT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `created_date_time` datetime(6) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `last_modified_by` varchar(64) DEFAULT NULL,
  `last_modified_date_time` datetime(6) DEFAULT NULL,
  `name` varchar(64) NOT NULL,
  `tenant_id` varchar(255) DEFAULT NULL,
  `version` int DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `sequence` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;
