package com.mohamedaabdallah.egyptianid;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EgyptianIDValidatorTest {

    @Test void testEmptyID() { assertNull(EgyptianIDValidator.validate("")); }
    @Test void testNonNumericID() { assertNull(EgyptianIDValidator.validate("abc")); }
    @Test void testTooShortID() { assertNull(EgyptianIDValidator.validate("3001224019993")); }
    @Test void testTooLongID() { assertNull(EgyptianIDValidator.validate("300122401999371")); }
    @Test void testInvalidCharID() { assertNull(EgyptianIDValidator.validate("3001224019X930")); }
    @Test void testNullID() { assertNull(EgyptianIDValidator.validate(null)); }

    @Test void testInvalidChecksum() {
        assertNull(EgyptianIDValidator.validate("30012240199930"));
    }

    @Test void testInvalidCentury1() { assertNull(EgyptianIDValidator.validate("00012240199930")); }
    @Test void testInvalidCentury2() { assertNull(EgyptianIDValidator.validate("10012240199939")); }
    @Test void testInvalidCentury3() { assertNull(EgyptianIDValidator.validate("40012240199936")); }

    @Test void testMonth00() { assertNull(EgyptianIDValidator.validate("30000240199930")); }
    @Test void testMonth13() { assertNull(EgyptianIDValidator.validate("30013240199936")); }
    @Test void testMonth99() { assertNull(EgyptianIDValidator.validate("30099240199932")); }

    @Test void testDay00() { assertNull(EgyptianIDValidator.validate("30001320199935")); }

    @Test void testInvalidGovernorate() { assertNull(EgyptianIDValidator.validate("30012249999930")); }

    @Test void testInvalidUniqueNumber() { assertNull(EgyptianIDValidator.validate("30012240000035")); }
}
