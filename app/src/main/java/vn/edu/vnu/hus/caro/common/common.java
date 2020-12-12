package vn.edu.vnu.hus.caro.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class common
{

    //Hàm kiểm tra một số có phải là số điện thoại hay ko
    public static boolean isPhoneNumberValid(String phoneNumber)
    {
        boolean valid = true;
        String regex = "^(?:009|\\+84|0)[0-9][0-9]{9}";

        if(!phoneNumber.matches(regex))
        {
            valid = false;
        }
        return valid;
    }

    //Khai báo các Hằng số
    public static final int RANH_ROI = 0;
    public static final int CHO_CHOI = 1;
    public static final int DANG_CHOI = 2;

    //Định nghĩa các hằng số cho việc vẽ bàn cờ.
    public static final int CHIEU_RONG = 30;
    public static final int CHIEU_CAO = 20;

    //Hàm mã hóa MD5
    public static String md5(String str){
        String result = "";
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(str.getBytes());
            BigInteger bigInteger = new BigInteger(1,digest.digest());
            result = bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
}
