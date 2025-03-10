CREATE TABLE `books` (
	`id` BIGINT(19) NOT NULL AUTO_INCREMENT,
	`book_name` VARCHAR(100) NOT NULL COLLATE 'utf8mb4_general_ci',
	`isbn` VARCHAR(100) NOT NULL COLLATE 'utf8mb4_general_ci',
	`digest` VARCHAR(2000) NOT NULL COLLATE 'utf8mb4_general_ci',
	`author` VARCHAR(200) NOT NULL COLLATE 'utf8mb4_general_ci',
	`about_author` VARCHAR(1000) NOT NULL COLLATE 'utf8mb4_general_ci',
	`price` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`cover_url` VARCHAR(500) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`owner_id` BIGINT(19) NOT NULL,
	`holder_id` BIGINT(19) NULL DEFAULT NULL,
	`create_time` DATETIME NULL DEFAULT NULL,
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
