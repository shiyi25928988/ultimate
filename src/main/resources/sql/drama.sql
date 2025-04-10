CREATE TABLE IF NOT EXISTS `drama` (
    `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
    `drama_name` VARCHAR(100) NOT NULL COLLATE 'utf8mb4_general_ci',
    `drama_desc` VARCHAR(2000) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
    `cover_url` VARCHAR(500) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
    `director` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
    `release_year` INT NULL DEFAULT NULL,
    `genre` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
    `create_time` DATETIME NULL DEFAULT NULL,
    `actors` TEXT NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
    `like_count` INT NULL DEFAULT NULL, // 添加点赞数字段
    `update_time` DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP, // 添加更新时间字段
    PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;