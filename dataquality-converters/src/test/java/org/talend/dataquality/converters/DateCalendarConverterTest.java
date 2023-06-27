// ============================================================================
//
// Copyright (C) 2006-2021 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.dataquality.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.Month;
import java.time.chrono.Chronology;
import java.time.chrono.HijrahChronology;
import java.time.chrono.IsoChronology;
import java.time.chrono.JapaneseChronology;
import java.time.chrono.JapaneseEra;
import java.time.chrono.MinguoChronology;
import java.time.chrono.ThaiBuddhistChronology;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test for class {@link DateCalendarConverter}.
 * 
 * @author msjian
 * @version 2017.02.08
 */
public class DateCalendarConverterTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateCalendarConverterTest.class);

    private static final String PATTERN = "yyyy-MM-dd"; //$NON-NLS-1$

    private static final String ISO_STR = "1996-10-29"; //$NON-NLS-1$

    private static final String ISO_STR_1 = "2019-04-30"; //$NON-NLS-1$

    private static final String ISO_STR_2 = "2019-05-01"; //$NON-NLS-1$

    private static final String HIJRAH_STR = "1417-06-16"; //$NON-NLS-1$

    private static final String JAPANESE_STR = "0008-10-29";//$NON-NLS-1$

    private static final String JAPANESE_STR_1 = "0031-04-30";//$NON-NLS-1$

    private static final String JAPANESE_STR_2 = "0001-05-01";//$NON-NLS-1$

    private static final String JAPANESE_DATE_WITH_ERA = "0008-10-29 平成"; //$NON-NLS-1$

    private static final String JAPANESE_DATE_WITH_ERA_1 = "0031-04-30 平成"; //$NON-NLS-1$

    private static final String JAPANESE_DATE_WITH_ERA_2 = "0001-05-01 令和"; //$NON-NLS-1$

    private static final String JAPANESE_DATE_WITH_ERA_3 = "0031-05-01 平成"; //$NON-NLS-1$

    private static final String JAPANESE_DATE_WITH_ERA_4 = "0001-04-30 令和"; //$NON-NLS-1$

    private static final String MINGUO_STR = "0085-10-29"; //$NON-NLS-1$

    private static final String THAIBUDDHIST_STR = "2539-10-29"; //$NON-NLS-1$

    private static final String PATTERN1 = "yyyy/MM/dd"; //$NON-NLS-1$

    private static final String ISO_STR1 = "1996/10/29"; //$NON-NLS-1$

    private static final String HIJRA_STR1 = "1417/06/16"; //$NON-NLS-1$

    private static final String JAPANESE_STR1 = "0008/10/29";//$NON-NLS-1$

    private static final String MINGUO_STR1 = "0085/10/29"; //$NON-NLS-1$

    private static final String THAIBUDDHIST_STR1 = "2539/10/29"; //$NON-NLS-1$

    private static final String PATTERN2 = "yy/MM/dd"; //$NON-NLS-1$

    private static final String ISO_STR2 = "96/10/29"; //$NON-NLS-1$

    private static final String PATTERN3 = "MM/dd/yyyy"; //$NON-NLS-1$

    private static final String ISO_STR3 = "10/29/1996"; //$NON-NLS-1$

    private static final String PATTERN4 = "yyyyMMdd"; //$NON-NLS-1$

    private static final String ISO_STR4 = "19961029"; //$NON-NLS-1$

    private static final String PATTERN5 = "M/d/yyyy GGGGG"; //$NON-NLS-1$

    private static final String ISO_STR5 = "10/29/1996 A"; //$NON-NLS-1$

    private static final String HIJRAH_STR5_JAVA8 = "6/16/1417 1"; //$NON-NLS-1$

    private static final String HIJRAH_STR5 = "6/16/1417 AH"; //$NON-NLS-1$

    private static final String JAPANESE_STR5 = "10/29/0008 H";//$NON-NLS-1$

    private static final String MINGUO_STR5_JAVA8 = "10/29/0085 1"; //$NON-NLS-1$

    private static final String MINGUO_STR5 = "10/29/0085 Minguo"; //$NON-NLS-1$

    private static final String THAIBUDDHIST_STR5_JAVA8 = "10/29/2539 B.E."; //$NON-NLS-1$

    private static final String THAIBUDDHIST_STR5 = "10/29/2539 BE"; //$NON-NLS-1$

    private static final String PATTERN6 = "yyyy MM dd"; //$NON-NLS-1$

    private static final String HIJRAH_STR2 = "1417 06 16"; //$NON-NLS-1$

    private static final String PATTERN_ENGLISH_DATE = "dd/MMM/yyyy"; //$NON-NLS-1$

    private static final String PATTERN_FRENCH_DATE = "dd/MMM/yyyy"; //$NON-NLS-1$

    private static final String PATTERN_CHINESE_DATE = "dd MMM yyyy"; //$NON-NLS-1$

    private static final String ENGLISH_DATE = "01/Sep/2015"; //$NON-NLS-1$

    private static final String FRENCH_DATE = "01/sept./2015"; //$NON-NLS-1$

    private static final String EXPECT_CHINESE_DATE_JAVA8 = "01 九月 0104"; //$NON-NLS-1$

    private static final String EXPECT_CHINESE_DATE = "01 9月 0104"; //$NON-NLS-1$

    private static final String PATTERN_WITH_G = "yyyy-MM-dd G"; //$NON-NLS-1$

    private static boolean isReiwaEraSupported() {
        try {
            JapaneseEra.valueOf("Reiwa");
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    @BeforeClass
    public static void init() {
        Locale.setDefault(new Locale("en", "US")); //$NON-NLS-1$ //$NON-NLS-2$
    }

    @Test
    public void testConvert_IsoDateTo() {
        assertEquals(HIJRAH_STR,
                new DateCalendarConverter(IsoChronology.INSTANCE, HijrahChronology.INSTANCE).convert(ISO_STR));
        assertEquals(JAPANESE_STR,
                new DateCalendarConverter(IsoChronology.INSTANCE, JapaneseChronology.INSTANCE).convert(ISO_STR));
        assertEquals(JAPANESE_STR_1,
                new DateCalendarConverter(IsoChronology.INSTANCE, JapaneseChronology.INSTANCE).convert(ISO_STR_1));
        if (isReiwaEraSupported()) {
            assertEquals(JAPANESE_STR_2,
                    new DateCalendarConverter(IsoChronology.INSTANCE, JapaneseChronology.INSTANCE).convert(ISO_STR_2));
        }
        assertEquals(MINGUO_STR,
                new DateCalendarConverter(IsoChronology.INSTANCE, MinguoChronology.INSTANCE).convert(ISO_STR));
        assertEquals(THAIBUDDHIST_STR,
                new DateCalendarConverter(IsoChronology.INSTANCE, ThaiBuddhistChronology.INSTANCE).convert(ISO_STR));

        assertEquals(ISO_STR2,
                new DateCalendarConverter(PATTERN, PATTERN2, IsoChronology.INSTANCE, IsoChronology.INSTANCE)
                        .convert(ISO_STR));
        assertEquals(ISO_STR3,
                new DateCalendarConverter(PATTERN, PATTERN3, IsoChronology.INSTANCE, IsoChronology.INSTANCE)
                        .convert(ISO_STR));
        assertEquals(ISO_STR4,
                new DateCalendarConverter(PATTERN, PATTERN4, IsoChronology.INSTANCE, IsoChronology.INSTANCE)
                        .convert(ISO_STR));
        assertEquals(ISO_STR5,
                new DateCalendarConverter(PATTERN, PATTERN5, IsoChronology.INSTANCE, IsoChronology.INSTANCE)
                        .convert(ISO_STR));

        assertEquals(HIJRA_STR1,
                new DateCalendarConverter(PATTERN, PATTERN1, IsoChronology.INSTANCE, HijrahChronology.INSTANCE)
                        .convert(ISO_STR));
        assertEquals(HIJRA_STR1,
                new DateCalendarConverter(PATTERN1, PATTERN1, IsoChronology.INSTANCE, HijrahChronology.INSTANCE)
                        .convert(ISO_STR1));
        assertEquals(HIJRAH_STR,
                new DateCalendarConverter(PATTERN1, PATTERN, IsoChronology.INSTANCE, HijrahChronology.INSTANCE)
                        .convert(ISO_STR1));
        final String convertedHijrahDate =
                new DateCalendarConverter(PATTERN1, PATTERN5, IsoChronology.INSTANCE, HijrahChronology.INSTANCE)
                        .convert(ISO_STR1);
        assertTrue(HIJRAH_STR5_JAVA8.equals(convertedHijrahDate) || HIJRAH_STR5.equals(convertedHijrahDate));

        assertEquals(JAPANESE_STR1,
                new DateCalendarConverter(PATTERN, PATTERN1, IsoChronology.INSTANCE, JapaneseChronology.INSTANCE)
                        .convert(ISO_STR));
        assertEquals(JAPANESE_STR1,
                new DateCalendarConverter(PATTERN1, PATTERN1, IsoChronology.INSTANCE, JapaneseChronology.INSTANCE)
                        .convert(ISO_STR1));
        assertEquals(JAPANESE_STR,
                new DateCalendarConverter(PATTERN1, PATTERN, IsoChronology.INSTANCE, JapaneseChronology.INSTANCE)
                        .convert(ISO_STR1));

        assertEquals(MINGUO_STR1,
                new DateCalendarConverter(PATTERN, PATTERN1, IsoChronology.INSTANCE, MinguoChronology.INSTANCE)
                        .convert(ISO_STR));
        assertEquals(MINGUO_STR1,
                new DateCalendarConverter(PATTERN1, PATTERN1, IsoChronology.INSTANCE, MinguoChronology.INSTANCE)
                        .convert(ISO_STR1));
        assertEquals(MINGUO_STR,
                new DateCalendarConverter(PATTERN1, PATTERN, IsoChronology.INSTANCE, MinguoChronology.INSTANCE)
                        .convert(ISO_STR1));

        assertEquals(THAIBUDDHIST_STR1,
                new DateCalendarConverter(PATTERN, PATTERN1, IsoChronology.INSTANCE, ThaiBuddhistChronology.INSTANCE)
                        .convert(ISO_STR));
        assertEquals(THAIBUDDHIST_STR1,
                new DateCalendarConverter(PATTERN1, PATTERN1, IsoChronology.INSTANCE, ThaiBuddhistChronology.INSTANCE)
                        .convert(ISO_STR1));
        assertEquals(THAIBUDDHIST_STR,
                new DateCalendarConverter(PATTERN1, PATTERN, IsoChronology.INSTANCE, ThaiBuddhistChronology.INSTANCE)
                        .convert(ISO_STR1));
    }

    @Test
    public void testConvert_withLocale() {
        final String convertedChineseDateFromEnglish =
                new DateCalendarConverter(PATTERN_ENGLISH_DATE, PATTERN_CHINESE_DATE, IsoChronology.INSTANCE,
                        MinguoChronology.INSTANCE, Locale.US, Locale.CHINESE).convert(ENGLISH_DATE);
        assertTrue(EXPECT_CHINESE_DATE_JAVA8.equals(convertedChineseDateFromEnglish)
                || EXPECT_CHINESE_DATE.equals(convertedChineseDateFromEnglish));
        assertEquals(ENGLISH_DATE,
                new DateCalendarConverter(PATTERN_CHINESE_DATE, PATTERN_ENGLISH_DATE, MinguoChronology.INSTANCE,
                        IsoChronology.INSTANCE, Locale.CHINESE, Locale.US).convert(EXPECT_CHINESE_DATE));
        final String convertedChineseDateFromFrench =
                new DateCalendarConverter(PATTERN_FRENCH_DATE, PATTERN_CHINESE_DATE, IsoChronology.INSTANCE,
                        MinguoChronology.INSTANCE, Locale.FRANCE, Locale.CHINESE).convert(FRENCH_DATE);
        assertTrue(EXPECT_CHINESE_DATE_JAVA8.equals(convertedChineseDateFromFrench)
                || EXPECT_CHINESE_DATE.equals(convertedChineseDateFromFrench));
        assertEquals(FRENCH_DATE,
                new DateCalendarConverter(PATTERN_CHINESE_DATE, PATTERN_FRENCH_DATE, MinguoChronology.INSTANCE,
                        IsoChronology.INSTANCE, Locale.CHINESE, Locale.FRANCE).convert(EXPECT_CHINESE_DATE));
    }

    @Test
    public void testConvert_HijrahDateTo() {
        assertEquals(ISO_STR,
                new DateCalendarConverter(HijrahChronology.INSTANCE, IsoChronology.INSTANCE).convert(HIJRAH_STR));
        assertEquals(JAPANESE_STR,
                new DateCalendarConverter(HijrahChronology.INSTANCE, JapaneseChronology.INSTANCE).convert(HIJRAH_STR));
        assertEquals(MINGUO_STR,
                new DateCalendarConverter(HijrahChronology.INSTANCE, MinguoChronology.INSTANCE).convert(HIJRAH_STR));
        assertEquals(THAIBUDDHIST_STR,
                new DateCalendarConverter(HijrahChronology.INSTANCE, ThaiBuddhistChronology.INSTANCE)
                        .convert(HIJRAH_STR));

        assertEquals(JAPANESE_STR1,
                new DateCalendarConverter(PATTERN, PATTERN1, HijrahChronology.INSTANCE, JapaneseChronology.INSTANCE)
                        .convert(HIJRAH_STR));
        assertEquals(MINGUO_STR,
                new DateCalendarConverter(PATTERN6, PATTERN, HijrahChronology.INSTANCE, MinguoChronology.INSTANCE)
                        .convert(HIJRAH_STR2));
        final String convertedHijrahDate = new DateCalendarConverter(PATTERN, PATTERN5, HijrahChronology.INSTANCE,
                ThaiBuddhistChronology.INSTANCE, Locale.US, Locale.US).convert(HIJRAH_STR);
        assertTrue(
                THAIBUDDHIST_STR5_JAVA8.equals(convertedHijrahDate) || THAIBUDDHIST_STR5.equals(convertedHijrahDate));
    }

    @Test
    /**
     * 
     * After TDQ-14421,We use ResolverStyle.STRICT to parse a date. for JapaneseChronology,it must be with Era such as
     * "0008-10-29 Heisei" with pattern "yyyy-MM-dd G"
     */
    public void testConvert_JapaneseDateTo() {
        assertEquals(ISO_STR, new DateCalendarConverter(PATTERN_WITH_G, null, JapaneseChronology.INSTANCE,
                IsoChronology.INSTANCE, Locale.JAPAN, Locale.US).convert(JAPANESE_DATE_WITH_ERA));
        assertEquals(ISO_STR_1, new DateCalendarConverter(PATTERN_WITH_G, null, JapaneseChronology.INSTANCE,
                IsoChronology.INSTANCE, Locale.JAPAN, Locale.US).convert(JAPANESE_DATE_WITH_ERA_1));
        if (isReiwaEraSupported()) {
            assertEquals(ISO_STR_2, new DateCalendarConverter(PATTERN_WITH_G, null, JapaneseChronology.INSTANCE,
                    IsoChronology.INSTANCE, Locale.JAPAN, Locale.US).convert(JAPANESE_DATE_WITH_ERA_2));
            assertEquals(StringUtils.EMPTY, new DateCalendarConverter(PATTERN_WITH_G, null, JapaneseChronology.INSTANCE,
                    IsoChronology.INSTANCE, Locale.JAPAN, Locale.US).convert(JAPANESE_DATE_WITH_ERA_3));
        } else {
            assertEquals(StringUtils.EMPTY, new DateCalendarConverter(PATTERN_WITH_G, null, JapaneseChronology.INSTANCE,
                    IsoChronology.INSTANCE, Locale.JAPAN, Locale.US).convert(JAPANESE_DATE_WITH_ERA_4));
        }
        assertEquals(HIJRAH_STR, new DateCalendarConverter(PATTERN_WITH_G, null, JapaneseChronology.INSTANCE,
                HijrahChronology.INSTANCE, Locale.JAPAN, Locale.US).convert(JAPANESE_DATE_WITH_ERA));
        assertEquals(MINGUO_STR, new DateCalendarConverter(PATTERN_WITH_G, null, JapaneseChronology.INSTANCE,
                MinguoChronology.INSTANCE, Locale.JAPAN, Locale.US).convert(JAPANESE_DATE_WITH_ERA));
        assertEquals(THAIBUDDHIST_STR, new DateCalendarConverter(PATTERN_WITH_G, null, JapaneseChronology.INSTANCE,
                ThaiBuddhistChronology.INSTANCE, Locale.JAPAN, Locale.US).convert(JAPANESE_DATE_WITH_ERA));
        final String convertedJapaneseDate =
                new DateCalendarConverter(PATTERN_WITH_G, PATTERN5, JapaneseChronology.INSTANCE,
                        MinguoChronology.INSTANCE, Locale.JAPAN, Locale.US).convert(JAPANESE_DATE_WITH_ERA);
        assertTrue(MINGUO_STR5_JAVA8.equals(convertedJapaneseDate) || MINGUO_STR5.contentEquals(convertedJapaneseDate));
        assertEquals(ISO_STR, new DateCalendarConverter(PATTERN_WITH_G, null, JapaneseChronology.INSTANCE,
                IsoChronology.INSTANCE, Locale.US, Locale.US).convert("0008-10-29 Heisei"));
        Assert.assertFalse(ISO_STR.equals(new DateCalendarConverter(null, null, JapaneseChronology.INSTANCE,
                IsoChronology.INSTANCE, Locale.US, Locale.US).convert(JAPANESE_STR)));
    }

    @Test
    public void testConvert_MinguoDateTo() {
        assertEquals(ISO_STR,
                new DateCalendarConverter(MinguoChronology.INSTANCE, IsoChronology.INSTANCE).convert(MINGUO_STR));
        assertEquals(HIJRAH_STR,
                new DateCalendarConverter(MinguoChronology.INSTANCE, HijrahChronology.INSTANCE).convert(MINGUO_STR));
        assertEquals(JAPANESE_STR,
                new DateCalendarConverter(MinguoChronology.INSTANCE, JapaneseChronology.INSTANCE).convert(MINGUO_STR));
        assertEquals(THAIBUDDHIST_STR,
                new DateCalendarConverter(MinguoChronology.INSTANCE, ThaiBuddhistChronology.INSTANCE)
                        .convert(MINGUO_STR));

        assertEquals(JAPANESE_STR5,
                new DateCalendarConverter(PATTERN, PATTERN5, MinguoChronology.INSTANCE, JapaneseChronology.INSTANCE)
                        .convert(MINGUO_STR));
    }

    @Test
    public void testConvert_ThaiBuddhistDateTo() {
        assertEquals(ISO_STR, new DateCalendarConverter(ThaiBuddhistChronology.INSTANCE, IsoChronology.INSTANCE)
                .convert(THAIBUDDHIST_STR));
        assertEquals(HIJRAH_STR, new DateCalendarConverter(ThaiBuddhistChronology.INSTANCE, HijrahChronology.INSTANCE)
                .convert(THAIBUDDHIST_STR));
        assertEquals(JAPANESE_STR,
                new DateCalendarConverter(ThaiBuddhistChronology.INSTANCE, JapaneseChronology.INSTANCE)
                        .convert(THAIBUDDHIST_STR));
        assertEquals(MINGUO_STR, new DateCalendarConverter(ThaiBuddhistChronology.INSTANCE, MinguoChronology.INSTANCE)
                .convert(THAIBUDDHIST_STR));

        assertEquals(ISO_STR5,
                new DateCalendarConverter(PATTERN, PATTERN5, ThaiBuddhistChronology.INSTANCE, IsoChronology.INSTANCE)
                        .convert(THAIBUDDHIST_STR));
    }

    @Test
    public void testConvert_SpecialCases() {
        // test when the input is blank
        assertEquals("", new DateCalendarConverter(HijrahChronology.INSTANCE, JapaneseChronology.INSTANCE).convert("")); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(" ", new DateCalendarConverter(IsoChronology.INSTANCE, HijrahChronology.INSTANCE).convert(" ")); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals(null,
                new DateCalendarConverter(HijrahChronology.INSTANCE, ThaiBuddhistChronology.INSTANCE).convert(null));

        // test when the input is not a date
        assertEquals("", new DateCalendarConverter(HijrahChronology.INSTANCE, HijrahChronology.INSTANCE).convert("aa")); //$NON-NLS-1$ //$NON-NLS-2$
        assertEquals("", new DateCalendarConverter( //$NON-NLS-1$
                PATTERN1, PATTERN, HijrahChronology.INSTANCE, HijrahChronology.INSTANCE).convert("aa")); //$NON-NLS-1$

        // test when the pattern is null
        assertEquals(ISO_STR5,
                new DateCalendarConverter(null, PATTERN5, ThaiBuddhistChronology.INSTANCE, IsoChronology.INSTANCE)
                        .convert(THAIBUDDHIST_STR));
        assertEquals(ISO_STR,
                new DateCalendarConverter(PATTERN, null, ThaiBuddhistChronology.INSTANCE, IsoChronology.INSTANCE)
                        .convert(THAIBUDDHIST_STR));
        assertEquals(ISO_STR,
                new DateCalendarConverter(null, null, ThaiBuddhistChronology.INSTANCE, IsoChronology.INSTANCE)
                        .convert(THAIBUDDHIST_STR));
    }

    @Test
    public void testParseStringToDate_formatDateToString() {
        // convert an ISO-based date to a date in another chronology
        LocalDate date = LocalDate.of(2011, Month.AUGUST, 19);// LocalDate.from(jdate)
        // JapaneseDate jdate = JapaneseDate.from(date);
        // HijrahDate hdate = HijrahDate.from(date);
        // MinguoDate mdate = MinguoDate.from(date);
        // ThaiBuddhistDate tdate = ThaiBuddhistDate.from(date);

        LocalDate parseDateString = new DateCalendarConverter(PATTERN4, PATTERN4).parseStringToDate("20110819"); //$NON-NLS-1$
        assertEquals(date, parseDateString);
        assertEquals("2011-08-19", new DateCalendarConverter().formatDateToString(parseDateString));//$NON-NLS-1$

        LocalDate parseDateString1 = new DateCalendarConverter().parseStringToDate("2011-08-19"); //$NON-NLS-1$
        assertEquals(date, parseDateString1);
        assertEquals("2011-08-19", new DateCalendarConverter().formatDateToString(parseDateString1)); //$NON-NLS-1$

        LocalDate parseDateString2 = new DateCalendarConverter(PATTERN6, PATTERN6).parseStringToDate("2011 08 19"); //$NON-NLS-1$
        assertEquals(date, parseDateString2);
        assertEquals("2011 08 19", new DateCalendarConverter(PATTERN6, PATTERN6).formatDateToString(parseDateString2)); //$NON-NLS-1$

        LocalDate parseDateString3 = new DateCalendarConverter(PATTERN4, PATTERN4).parseStringToDate("20110819"); //$NON-NLS-1$
        assertEquals(date, parseDateString3);
        assertEquals("0023 08 19", //$NON-NLS-1$
                new DateCalendarConverter(null, PATTERN6, null, JapaneseChronology.INSTANCE)
                        .formatDateToString(parseDateString3));

        LocalDate parseDateString4 =
                new DateCalendarConverter(PATTERN_WITH_G, null, JapaneseChronology.INSTANCE, null, Locale.US, Locale.US)
                        .parseStringToDate("0023-08-19 Heisei"); //$NON-NLS-1$
        assertEquals(date, parseDateString4);
        assertEquals("0023-08-19", //$NON-NLS-1$
                new DateCalendarConverter(null, PATTERN, null, JapaneseChronology.INSTANCE)
                        .formatDateToString(parseDateString4));

        LocalDate parseDateString5 = new DateCalendarConverter(PATTERN6, null).parseStringToDate("2011 08 19");//$NON-NLS-1$
        assertEquals(date, parseDateString5);
        assertEquals("0023/08/19", //$NON-NLS-1$
                new DateCalendarConverter(null, PATTERN1, null, JapaneseChronology.INSTANCE)
                        .formatDateToString(parseDateString5));
    }

    /**
     * measure the execution time of the current implementation with 100 000 dates to convert.
     */
    @Test
    public void testConvert_MeasureTheExecutionTime() {
        Chronology[] chronologys = { IsoChronology.INSTANCE, HijrahChronology.INSTANCE, JapaneseChronology.INSTANCE,
                MinguoChronology.INSTANCE, ThaiBuddhistChronology.INSTANCE };

        for (Chronology sourceChronology : chronologys) {
            for (Chronology targetChronology : chronologys) {
                DateCalendarConverter dateCalendarConverter =
                        new DateCalendarConverter("dd-MM-yyyy", PATTERN, sourceChronology, //$NON-NLS-1$
                                targetChronology);

                InputStream dateStream = this.getClass().getResourceAsStream("dateList.txt"); //$NON-NLS-1$
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new InputStreamReader(dateStream, "UTF-8")); //$NON-NLS-1$ //for Hindi
                                                                                         // language
                                                                                         // Double-byte type
                } catch (UnsupportedEncodingException e) {
                    LOGGER.error(e.getMessage(), e);
                    Assert.fail(e.getMessage());
                }
                try {
                    long startTime = System.currentTimeMillis();
                    String line;
                    while ((line = br.readLine()) != null) {
                        dateCalendarConverter.convert(line);
                    }
                    long endTime = System.currentTimeMillis();
                    System.out.println("the execution time of " + sourceChronology.getId() + "-->" //$NON-NLS-1$ //$NON-NLS-2$
                            + targetChronology.getId() + " : " + (endTime - startTime) + "ms"); //$NON-NLS-1$ //$NON-NLS-2$
                } catch (FileNotFoundException e) {
                    LOGGER.error(e.getMessage(), e);
                    Assert.fail(e.getMessage());
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                    Assert.fail(e.getMessage());
                } finally {
                    try {
                        br.close();
                    } catch (IOException e) {
                        LOGGER.error(e.getMessage(), e);
                        Assert.fail(e.getMessage());
                    }
                }
            }
        }

    }

    @Test
    /**
     * 
     * Test invalid date such as 2017-02-30,it should not be parsed.
     */
    public void testConvertDateWithResolverStyleStrict() {
        String ISODateValid = "2017-02-28"; //$NON-NLS-1$
        String ISODateInValid = "2017-02-30"; //$NON-NLS-1$
        assertEquals("", //$NON-NLS-1$
                new DateCalendarConverter(IsoChronology.INSTANCE, ThaiBuddhistChronology.INSTANCE)
                        .convert(ISODateInValid));
        assertEquals("", //$NON-NLS-1$
                new DateCalendarConverter(IsoChronology.INSTANCE, MinguoChronology.INSTANCE).convert("2017-04-32")); //$NON-NLS-1$
        assertEquals("", //$NON-NLS-1$
                new DateCalendarConverter("yyyy-MM-dd G", PATTERN, IsoChronology.INSTANCE, //$NON-NLS-1$
                        ThaiBuddhistChronology.INSTANCE).convert("2017-02-30 AD")); //$NON-NLS-1$

        assertEquals(ISODateValid, new DateCalendarConverter(ThaiBuddhistChronology.INSTANCE, IsoChronology.INSTANCE)
                .convert("2560-02-28")); //$NON-NLS-1$
        assertEquals("", //$NON-NLS-1$
                new DateCalendarConverter(ThaiBuddhistChronology.INSTANCE, IsoChronology.INSTANCE)
                        .convert("2560-02-30")); //$NON-NLS-1$

        assertEquals(ISODateValid,
                new DateCalendarConverter(MinguoChronology.INSTANCE, IsoChronology.INSTANCE).convert("0106-02-28")); //$NON-NLS-1$
        assertEquals("", //$NON-NLS-1$
                new DateCalendarConverter(MinguoChronology.INSTANCE, IsoChronology.INSTANCE).convert("0106-02-30")); //$NON-NLS-1$
        assertEquals("", //$NON-NLS-1$
                new DateCalendarConverter(JapaneseChronology.INSTANCE, IsoChronology.INSTANCE).convert("0029-02-28")); //$NON-NLS-1$
        assertEquals(ISODateValid, new DateCalendarConverter(PATTERN_WITH_G, null, JapaneseChronology.INSTANCE,
                IsoChronology.INSTANCE, Locale.US, Locale.US).convert("0029-02-28 Heisei")); //$NON-NLS-1$
    }
}
