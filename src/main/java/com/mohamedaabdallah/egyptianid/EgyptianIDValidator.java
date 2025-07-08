package com.mohamedaabdallah.egyptianid;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EgyptianIDValidator {

    private static final Pattern ID_PATTERN = Pattern.compile(
            "^(?<century>[23])" +
            "(?<year>\\d{2})" +
            "(?<month>0[1-9]|1[0-2])" +
            "(?<day>0[1-9]|[12]\\d|3[01])" +
            "(?<governorate>0[1-9]|[1-3]\\d|88)" +
            "(?<uniqueNumber>(?!000)\\d{3})" +
            "(?<gender>\\d)" +
            "(\\d)$"
    );

    public static Map<String, String> validate(String id) {
        if (id == null || !id.matches("\\d+")) return null;

        if (id.length() != 14 || !validateChecksum(id)) return null;

        Matcher matcher = ID_PATTERN.matcher(id);
        if (!matcher.matches()) return null;

        String century = matcher.group("century");
        String year = matcher.group("year");
        String month = matcher.group("month");
        String day = matcher.group("day");
        String governorateCode = matcher.group("governorate");
        String genderDigit = matcher.group("gender");

        int fullYear = (century.equals("2") ? 1900 : 2000) + Integer.parseInt(year);
        String gender = (Integer.parseInt(genderDigit) % 2 == 0) ? "F" : "M";

        String governorate;
        try {
            governorate = getGovernorateName(Integer.parseInt(governorateCode));
        } catch (Exception e) {
            return null;
        }

        Map<String, String> result = new HashMap<>();
        result.put("Year", String.valueOf(fullYear));
        result.put("Month", month);
        result.put("Day", day);
        result.put("Governorate", governorate);
        result.put("Gender", gender);

        return result;
    }

    private static boolean validateChecksum(String id) {
        int[] weights = {2, 7, 6, 5, 4, 3, 2, 7, 6, 5, 4, 3, 2};
        int sum = 0;
        for (int i = 0; i < 13; i++) {
            sum += Character.getNumericValue(id.charAt(i)) * weights[i];
        }
        int k = 11 - (sum % 11);
        k = (k == 10) ? 0 : (k == 11) ? 1 : k;
        return k == Character.getNumericValue(id.charAt(13));
    }

    private static String getGovernorateName(int code) {
        switch (code) {
            case 1:
                return "Cairo";
            case 2:
                return "Alexandria";
            case 3:
                return "Port Said";
            case 4:
                return "Suez";
            case 11:
                return "Damietta";
            case 12:
                return "Dakahlia";
            case 13:
                return "Sharqia";
            case 14:
                return "Qalyubia";
            case 15:
                return "Kafr El Sheikh";
            case 16:
                return "Gharbia";
            case 17:
                return "Monufia";
            case 18:
                return "Beheira";
            case 19:
                return "Ismailia";
            case 21:
                return "Giza";
            case 22:
                return "Beni Suef";
            case 23:
                return "Faiyum";
            case 24:
                return "Minya";
            case 25:
                return "Asyut";
            case 26:
                return "Sohag";
            case 27:
                return "Qena";
            case 28:
                return "Aswan";
            case 29:
                return "Luxor";
            case 31:
                return "Red Sea";
            case 32:
                return "New Valley";
            case 33:
                return "Matruh";
            case 34:
                return "North Sinai";
            case 35:
                return "South Sinai";
            case 88:
                return "Foreigners";
            default:
                throw new IllegalArgumentException("Unknown governorate code: " + code);
        }
    }
}
