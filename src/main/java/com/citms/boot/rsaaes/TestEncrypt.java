package com.citms.boot.rsaaes;
/**
 * 类TestEncrypt的实现描述：TODO 类实现描述 
 * @author DELL 2020/5/22 14:05
 */

public class TestEncrypt {
    public static void main(String[] args) throws Exception {
//        String key = AESUtils.generateKey();
        String key = "f0be5488f61b45ea";
        String name = "wujj";
        String idCard = "444200002939402";
        String encryptName = AESUtils.encryptData(key, name);
        String encryptCard = AESUtils.encryptData(key, idCard);
        String encryptKey = RSAUtils.encryptByPublicKey(key);
        System.out.println("使用RSA加密后的AES密钥： " + encryptKey);
        System.out.println("使用AES加密后的Name " + encryptName + "  使用AES加密后的Card :" + encryptCard);
    }
}
