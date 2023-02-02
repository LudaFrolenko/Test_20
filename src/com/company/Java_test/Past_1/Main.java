package com.company.Java_test.Past_1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public Main() {
    }

    public static void main(String[] args) {
        String[] arrNumbers = new String[]{"89017453425", "79017453425", "8(901)7453425", "7(901)7453425", "8-901-745-34-25", "7(901)7453-4-25", "4017453425", "74917453425", "6(901)7453425", "4(901)7453425", "8908745-34-25", "8(900)745-34-25"};
        String[] var2 = arrNumbers;
        int var3 = arrNumbers.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String number = var2[var4];
            System.out.println(checkPhoneNumberRF(number));
        }

    }

    static boolean checkPhoneNumberRF(String phoneNumber) {
        String regex = "(7|8)(\\(?(9)\\d{2}\\)?)(\\d{3})[\\- ]?(\\d{2})[\\- ]?(\\d{2})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
