package com.simos.util;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by l2h on 18-5-8.
 * Desc: AES_128_CBC_PSC5Padding
 */
public class AESUtil {
    /**
     * 算法
     */
    private static final String KEY_ALGORITHM = "AES";
    /**
     * 向量值
     */
    private static final  String IV = "1234567890123456";
    /**
     * 密钥
     */
    private static final String key = "1234567890123456";
    /**
     * 加密/解密算法 / 工作模式 / 填充方式
     * Java 6支持PKCS5Padding填充方式
     * Bouncy Castle支持PKCS7Padding填充方式
     */
    private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";

    /**
     * 加密
     * @param source
     * @return
     * @throws Exception
     */
    public static String encrypt(String source) throws Exception {
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), KEY_ALGORITHM),ivParameterSpec);
        byte[] decryptedBytes = cipher.doFinal(source.getBytes());
        String decrypted = new String(Base64.encodeBase64(decryptedBytes));
        return decrypted;
    }

    /**
     * 解密
     * @param source
     * @return
     * @throws Exception
     */
    public static String decrypt(String source) throws Exception {
        byte[] decode = Base64.decodeBase64(source);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), KEY_ALGORITHM),ivParameterSpec);
        byte[] decrypted = cipher.doFinal(decode);
        return new String(decrypted);
    }
}
