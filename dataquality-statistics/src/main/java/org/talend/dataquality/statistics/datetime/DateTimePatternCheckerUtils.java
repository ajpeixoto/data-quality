package org.talend.dataquality.statistics.datetime;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility functions to recognize date, time, and datetime (timestamp) pattens.
 * <p>
 * /!\ This class's logic is not compatible with {@link org.talend.dataquality.statistics.type.DataTypeEnum} as both
 * Date and DateTime are represented as {@link org.talend.dataquality.statistics.type.DataTypeEnum#DATE} type.
 */
public class DateTimePatternCheckerUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateTimePatternCheckerUtils.class);

    private static final Set<String> dateTimePattens;

    private static final Set<String> datePattens;

    private static final Set<String> timePattens;

    static {
        Set<String> dateAndDateTimePattens = readDateTimeFormats("DateFormats.txt");
        datePattens = dateAndDateTimePattens
                .stream()
                .filter(DateTimePatternCheckerUtils::isDateOnlyPattern)
                .collect(Collectors.toSet());
        dateTimePattens = dateAndDateTimePattens
                .stream()
                .filter(DateTimePatternCheckerUtils::isDateTimeOnlyPattern)
                .collect(Collectors.toSet());

        timePattens = readDateTimeFormats("TimeFormats.txt");

        LOGGER.debug("{} patterns have been registered for Date type", datePattens.size());
        LOGGER.debug("{} patterns have been registered for Time type", timePattens.size());
        LOGGER.debug("{} patterns have been registered for DateTime type", dateTimePattens.size());
    }

    /**
     * Determines if the provided pattern is a valid date pattern. Valid date patterns include only the date part.
     * <p>
     * <b>ATTENTION:</b> this function is not compatible with {@link SystemDateTimePatternManager#isDate}
     *
     * @param pattern the pattern to be checked
     * @return {@code true} if the provided pattern is a valid date pattern, {@code false} otherwise.
     */
    public static boolean isValidDatePattern(String pattern) {
        return datePattens.contains(pattern);
    }

    /**
     * Determines if the provided pattern is a valid time pattern. Valid time patterns include only the time part.
     *
     * @param pattern the pattern to be checked
     * @return {@code true} if the provided pattern is a valid time pattern, {@code false} otherwise.
     */
    public static boolean isValidTimePattern(String pattern) {
        return timePattens.contains(pattern);
    }

    /**
     * Determines if the provided pattern is a valid datetime (timestamps) pattern. Valid datetime (timestamps)
     * patterns include only the datetime part.
     *
     * @param pattern the pattern to be checked
     * @return {@code true} if the provided pattern is a valid datetime pattern, {@code false} otherwise.
     */
    public static boolean isValidDateTimePattern(String pattern) {
        return dateTimePattens.contains(pattern);
    }

    private static Set<String> readDateTimeFormats(String resourceName) {
        try (InputStream inputStream =
                Objects.requireNonNull(DateTimePatternCheckerUtils.class.getResourceAsStream(resourceName))) {
            return IOUtils
                    .readLines(inputStream, StandardCharsets.UTF_8)
                    .stream()
                    .map(line -> line.split("\t")[1])
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            return Collections.emptySet();
        }
    }

    private static boolean isDateOnlyPattern(String pattern) {
        // To distinguish Date patterns from those of DateTime, we check the existence of 'h' or 'H'
        return !pattern.contains("h") && !pattern.contains("H");
    }

    private static boolean isDateTimeOnlyPattern(String pattern) {
        return !isDateOnlyPattern(pattern);
    }
}
