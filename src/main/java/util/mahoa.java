package util;
import org.apache.tomcat.util.codec.binary.Base64;

import java.security.MessageDigest;


public class mahoa {
    public static String toSHA1(String str ){
        String salt="sdfnnasj";
        String result= null;
        str=str+ salt;
        try {
            byte[] dataBytes= str.getBytes("UTF-8");
            MessageDigest md= MessageDigest.getInstance("SHA-1");
            result= Base64.encodeBase64String(md.digest(dataBytes));
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(toSHA1("123456"));
    }
}
