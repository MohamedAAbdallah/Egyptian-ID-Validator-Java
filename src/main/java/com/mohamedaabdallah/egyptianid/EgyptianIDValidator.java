package com.mohamedaabdallah.egyptianid;

import com.mohamedaabdallah.egyptianid.components.*;
import com.mohamedaabdallah.egyptianid.internal.*;

public class EgyptianIDValidator {
    public static boolean validate(String id) {
        // TODO: Integrate format check, checksum, component parsing
        return id != null && !id.isEmpty();
    }
}
