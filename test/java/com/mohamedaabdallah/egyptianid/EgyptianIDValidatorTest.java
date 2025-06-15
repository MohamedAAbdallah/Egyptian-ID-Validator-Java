package com.mohamedaabdallah.egyptianid;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EgyptianIDValidatorTest {

    @Test
    void testValidate() {
        assertTrue(EgyptianIDValidator.validate("12345678901234"));
    }
}
