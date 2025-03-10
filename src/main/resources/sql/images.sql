CREATE TABLE IF NOT EXISTS `images` (
	`id` BIGINT(19) NOT NULL AUTO_INCREMENT,
	`album_id` BIGINT(19) NOT NULL,
	`image_url` VARCHAR(500) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`owner_id` BIGINT(19) NOT NULL,
	`create_time` DATETIME NULL DEFAULT NULL,
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
