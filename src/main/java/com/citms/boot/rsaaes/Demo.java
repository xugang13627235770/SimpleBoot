package com.citms.boot.rsaaes;

public class Demo {
    public static void main(String[] args) throws Exception {
//        String encryptKey = "W9KbxUg4SeZdqP7GczBXjadgh7Pf8W/W3vZ7C+ZLNqzdQe4h9Gw4KoUw00EeWVBwybnH7FS1h8OI7WJ3NYzJcqWvrNELPuMYs+y7VpWORSYAVzxN6BaCAC4EzqRU9Lkq6leBbGlLb3F2UxKHUh7KklZDy9aNfnZa2K900WBRswo=";
        String encryptName = "CVo0Y/vd9b8j/JzGCI8/ag==";
        String encryptCard = "VB4FwySqkJaKYAnFGDSv3Q==";
        //解密
//        String key = RSAUtils.decryptByPrivateKey(encryptKey);
        String key = "f0be5488f61b45ea";
        String name = AESUtils.decryptData(key,encryptName);
        String idCard = AESUtils.decryptData(key,encryptCard);
        System.out.println("使用RSA解密后的AES密钥： " + key);
        System.out.println("使用AES解密后的Name " + name + "  使用AES解密后的Card :" + idCard);

    }
}
