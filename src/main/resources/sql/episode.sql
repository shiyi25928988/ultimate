CREATE TABLE IF NOT EXISTS `episode` (
    `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
    `drama_id` BIGINT(19) NOT NULL,
    `episode_name` VARCHAR(100) NOT NULL COLLATE 'utf8mb4_general_ci',
    `episode_desc` VARCHAR(2000) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
    `magnet_link` TEXT NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
    `create_time` DATETIME NULL DEFAULT NULL,
    `update_time` DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;