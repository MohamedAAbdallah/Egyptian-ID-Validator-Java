package com.mohamedaabdallah.egyptianid;

public class EgyptianIDValidator {
    public static boolean validate(String id) {
        // TODO: Integrate format check, checksum, component parsing
        return id != null && !id.isEmpty();
    }
}
