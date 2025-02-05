CREATE TABLE `borrow_history` (
	`id` BIGINT(19) NOT NULL AUTO_INCREMENT,
	`book_id` BIGINT(19) NOT NULL,
	`borrower_id` BIGINT(19) NOT NULL,
	`borrow_time` DATETIME NULL DEFAULT NULL,
	`return_time` DATETIME NULL DEFAULT NULL,
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
