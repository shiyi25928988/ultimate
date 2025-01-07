package yi.shi.utils;

import java.util.Base64;

public class KeyUtil {

    private static final String XOR_KEY = "abcABC123"; // 用于XOR操作的密钥

    /**
     * 混淆API密钥
     * @param apiKey 原始API密钥
     * @return 混淆后的API密钥
     */
    public static String obfuscateApiKey(String apiKey) {
        byte[] apiKeyBytes = apiKey.getBytes();
        byte[] xorKeyBytes = XOR_KEY.getBytes();
        byte[] obfuscatedBytes = new byte[apiKeyBytes.length];

        for (int i = 0; i < apiKeyBytes.length; i++) {
            obfuscatedBytes[i] = (byte) (apiKeyBytes[i] ^ xorKeyBytes[i % xorKeyBytes.length]);
        }

        return Base64.getEncoder().encodeToString(obfuscatedBytes);
    }

    /**
     * 恢复API密钥
     * @param obfuscatedApiKey 混淆后的API密钥
     * @return 原始API密钥
     */
    public static String deobfuscateApiKey(String obfuscatedApiKey) {
        byte[] obfuscatedBytes = Base64.getDecoder().decode(obfuscatedApiKey);
        byte[] xorKeyBytes = XOR_KEY.getBytes();
        byte[] apiKeyBytes = new byte[obfuscatedBytes.length];

        for (int i = 0; i < obfuscatedBytes.length; i++) {
            apiKeyBytes[i] = (byte) (obfuscatedBytes[i] ^ xorKeyBytes[i % xorKeyBytes.length]);
        }

        return new String(apiKeyBytes);
    }

}
