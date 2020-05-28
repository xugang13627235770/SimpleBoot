package com.citms.boot.jdk8;

/**
 * 类TestJava的实现描述：TODO 类实现描述 
 * @author DELL 2020/1/10 17:19
 */
public class TestJava {


    public static void main(String[] args) {
        String str = "";
        String[] strs = str.split("dataDictionary");
        StringBuilder result = new StringBuilder();
        for(int i=0;i<strs.length;i++){
            int nameStart = strs[i].indexOf("<name>");
            if(nameStart<0){
                continue;
            }
            int nameEnd = strs[i].indexOf("</name>");
            String name = strs[i].substring(nameStart+6,nameEnd);

            int valueStart = strs[i].indexOf("<value>");
            int valueEnd = strs[i].indexOf("</value>");
            String value = strs[i].substring(valueStart+7,valueEnd);
            result.append(value).append(":").append(name).append(";");
        }
        System.out.println(result);
    }
}
