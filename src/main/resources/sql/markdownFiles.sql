CREATE TABLE IF NOT EXISTS `markdown_files` (
	`id` BIGINT(19) NOT NULL AUTO_INCREMENT,
	`user_id` BIGINT(19) NOT NULL DEFAULT '0',
	`title` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_general_ci',
	`content` TEXT NOT NULL COLLATE 'utf8mb4_general_ci',
	`cover_url` VARCHAR(500) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`create_time` DATETIME NULL DEFAULT NULL,
	`update_time` DATETIME NULL DEFAULT NULL,
	`shared_token` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
