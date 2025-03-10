CREATE TABLE IF NOT EXISTS `user_account` (
	`id` BIGINT(19) NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_general_ci',
	`passwd` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_general_ci',
	`nick_name` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`email` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`phone` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`address` TEXT NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`avatar` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`token` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`create_time` DATETIME NULL DEFAULT NULL,
	`update_time` DATETIME NULL DEFAULT NULL,
	`last_login_time` DATETIME NULL DEFAULT NULL,
	`last_login_ip` VARCHAR(45) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`role` VARCHAR(200) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`is_lock` TINYINT(1) NULL DEFAULT NULL,
	`is_deleted` TINYINT(1) NULL DEFAULT NULL,
	`is_online` TINYINT(1) NULL DEFAULT NULL,
	`theme_color` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
