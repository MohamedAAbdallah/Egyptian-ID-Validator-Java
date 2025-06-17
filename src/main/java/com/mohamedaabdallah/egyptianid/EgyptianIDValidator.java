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
        return switch (code) {
            case 1 -> "Cairo";
            case 2 -> "Alexandria";
            case 3 -> "Port Said";
            case 4 -> "Suez";
            case 11 -> "Damietta";
            case 12 -> "Dakahlia";
            case 13 -> "Sharqia";
            case 14 -> "Qalyubia";
            case 15 -> "Kafr El Sheikh";
            case 16 -> "Gharbia";
            case 17 -> "Monufia";
            case 18 -> "Beheira";
            case 19 -> "Ismailia";
            case 21 -> "Giza";
            case 22 -> "Beni Suef";
            case 23 -> "Faiyum";
            case 24 -> "Minya";
            case 25 -> "Asyut";
            case 26 -> "Sohag";
            case 27 -> "Qena";
            case 28 -> "Aswan";
            case 29 -> "Luxor";
            case 31 -> "Red Sea";
            case 32 -> "New Valley";
            case 33 -> "Matruh";
            case 34 -> "North Sinai";
            case 35 -> "South Sinai";
            case 88 -> "Foreigners";
            default -> throw new IllegalArgumentException("Unknown governorate code: " + code);
        };
    }
}
