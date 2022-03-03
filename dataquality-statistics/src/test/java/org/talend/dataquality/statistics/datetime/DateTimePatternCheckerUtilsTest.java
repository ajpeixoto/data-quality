package org.talend.dataquality.statistics.datetime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DateTimePatternCheckerUtilsTest {

    @Test
    public void testValidDatePatterns() {
        shouldBeValidDatePattern("dd-MM-yy");
        shouldBeValidDatePattern("dd-MM-yyyy");
        shouldBeValidDatePattern("MM-dd-yyyy");
        shouldBeValidDatePattern("dd/MM/yyyy");
        shouldBeValidDatePattern("d/M/yyyy");
        shouldBeValidDatePattern("yyyy-MM-dd");
    }

    @Test
    public void testValidTimePatterns() {
        shouldBeValidTimePattern("HH:mm:ss");
        shouldBeValidTimePattern("HH:mm:ssZ");
        shouldBeValidTimePattern("HH.mm.ssZ");
        shouldBeValidTimePattern("h:mm:ss a");
    }

    @Test
    public void testValidDateTimePatterns() {
        shouldBeValidDateTimePattern("yyyy-MM-dd HH:mm:ss");
        shouldBeValidDateTimePattern("yyyy-MM-dd HH:mm:ss.SSS");
        shouldBeValidDateTimePattern("yyyy-MM-dd HH:mm:ssZ");
        shouldBeValidDateTimePattern("yyyy.MM.dd HH:mm:ss");
    }

    @Test
    public void testInvalidPatterns() {
        shouldNotBeAValidPattern(null);
        shouldNotBeAValidPattern("");
        shouldNotBeAValidPattern("   ");
        shouldNotBeAValidPattern("not-a-date");
    }

    private void shouldBeValidDatePattern(String pattern) {
        assertTrue(DateTimePatternCheckerUtils.isValidDatePattern(pattern));
        assertFalse(DateTimePatternCheckerUtils.isValidTimePattern(pattern));
        assertFalse(DateTimePatternCheckerUtils.isValidDateTimePattern(pattern));
    }

    private void shouldBeValidTimePattern(String pattern) {
        assertFalse(DateTimePatternCheckerUtils.isValidDatePattern(pattern));
        assertTrue(DateTimePatternCheckerUtils.isValidTimePattern(pattern));
        assertFalse(DateTimePatternCheckerUtils.isValidDateTimePattern(pattern));
    }

    private void shouldBeValidDateTimePattern(String pattern) {
        assertFalse(DateTimePatternCheckerUtils.isValidDatePattern(pattern));
        assertFalse(DateTimePatternCheckerUtils.isValidTimePattern(pattern));
        assertTrue(DateTimePatternCheckerUtils.isValidDateTimePattern(pattern));
    }

    private void shouldNotBeAValidPattern(String pattern) {
        assertFalse(DateTimePatternCheckerUtils.isValidDatePattern(pattern));
        assertFalse(DateTimePatternCheckerUtils.isValidTimePattern(pattern));
        assertFalse(DateTimePatternCheckerUtils.isValidDateTimePattern(pattern));
    }
}