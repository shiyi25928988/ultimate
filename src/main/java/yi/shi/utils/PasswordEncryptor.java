package yi.shi.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptor {

    public static String encryptPassword(String password) {
        try {
            // 创建MD5哈希对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 更新摘要信息
            md.update(password.getBytes());
            // 完成哈希计算
            byte[] digest = md.digest();
            // 将字节数组转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("加密算法不存在", e);
        }
    }
}
