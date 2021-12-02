// ============================================================================
//
// Copyright (C) 2006-2021 qiongli Inc. - www.qiongli.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.qiongli.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to qiongli SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.dataquality.standardization.phone;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberToCarrierMapper;
import com.google.i18n.phonenumbers.PhoneNumberToTimeZonesMapper;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;

/**
 * A generic Phone number utility class.
 */
public class PhoneNumberHandlerBase {

    private static final Logger LOG = LoggerFactory.getLogger(PhoneNumberHandlerBase.class);

    private static final PhoneNumberUtil GOOGLE_PHONE_UTIL = PhoneNumberUtil.getInstance();

    /**
     * Parses a string or number and returns it in proto buffer format.
     *
     * @param data the phone number, as String or Number.
     * @param regionCode the expected region code of the number. This is only used if the number being parsed is not
     * written in international format. The country_code for the number in this case would be stored as that of the
     * default region supplied. If the number is guaranteed to start with a '+' followed by the country calling code,
     * then "ZZ" or null can be supplied. like as "+86 12345678912"
     * @return an instance of {@link PhoneNumber}
     */
    public static PhoneNumber parseToPhoneNumber(Object data, String regionCode) {
        if (data == null || StringUtils.isBlank(data.toString())) {
            return null;
        }
        try {
            return GOOGLE_PHONE_UTIL.parse(data.toString(), regionCode);
        } catch (NumberParseException e) {
            LOG.info("Phone number parsing exception: " + e.getMessage());
            LOG.debug("Phone number parsing exception with input data: " + data);
            return null;
        }
    }

    /**
     * Tests whether a phone number is valid for a certain region.
     * 
     * @param data the phone number, as String or Number.
     * @param regionCode the regionCode that we want to validate the phone number from
     * @return {@code true} if it's a valid phone number, {@code false} otherwise
     */
    public static boolean isValidPhoneNumber(Object data, String regionCode) {
        PhoneNumber phonenumber = parseToPhoneNumber(data, regionCode);
        if (phonenumber == null) {
            return false;
        }
        return GOOGLE_PHONE_UTIL.isValidNumberForRegion(phonenumber, regionCode);
    }

    /**
     * Checks whether the input parameter is a possible phone number, given the region where
     * the number could be dialed from.
     *
     * @param data the phone number, as String or Number.
     * @param regionCode the expected region code of the number.
     * @return {@code true} if it's a possible phone number, {@code false} otherwise.
     */
    public static boolean isPossiblePhoneNumber(Object data, String regionCode) {
        if (data == null || StringUtils.isBlank(data.toString())) {
            return false;
        }
        return GOOGLE_PHONE_UTIL.isPossibleNumber(data.toString(), regionCode);
    }

    /**
     * Returns the E164 format of a phone number. Example: "+12423651234"
     *
     * @param data the phone number, as String or Number.
     * @param regionCode the expected region code of the number.
     * @return the formatted phone number, or an empty string if it is invalid.
     */
    public static String formatE164(Object data, String regionCode) {
        PhoneNumber phoneNumber = parseToPhoneNumber(data, regionCode);
        if (phoneNumber == null) {
            return StringUtils.EMPTY;
        }
        return GOOGLE_PHONE_UTIL.format(phoneNumber, PhoneNumberFormat.E164);
    }

    /**
     * Returns the International format of a phone number. Example: "+1 242-365-1234"
     *
     * @param data the phone number, as String or Number.
     * @param regionCode the expected region code of the number.
     * @return the formatted phone number, or an empty string if it is invalid.
     */
    public static String formatInternational(Object data, String regionCode) {
        PhoneNumber phoneNumber = parseToPhoneNumber(data, regionCode);
        if (phoneNumber == null) {
            return StringUtils.EMPTY;
        }
        return GOOGLE_PHONE_UTIL.format(phoneNumber, PhoneNumberFormat.INTERNATIONAL);
    }

    /**
     * Returns the National format of a phone number. Example: "(242) 365-1234"
     *
     * @param data the phone number, as String or Number.
     * @param regionCode the expected region code of the number.
     * @return the formatted phone number, or an empty string if it is invalid.
     */
    public static String formatNational(Object data, String regionCode) {
        PhoneNumber phoneNumber = parseToPhoneNumber(data, regionCode);
        if (phoneNumber == null) {
            return StringUtils.EMPTY;
        }
        return GOOGLE_PHONE_UTIL.format(phoneNumber, PhoneNumberFormat.NATIONAL);
    }

    /**
     * Returns the RFC3966 format of a phone number. Example: "tel:+1-242-365-1234"
     *
     * @param data the phone number, as String or Number.
     * @param regionCode the expected region code of the number.
     * @return the formatted phone number, or an empty string if it is invalid.
     */
    public static String formatRFC396(Object data, String regionCode) {
        PhoneNumber phoneNumber = parseToPhoneNumber(data, regionCode);
        if (phoneNumber == null) {
            return StringUtils.EMPTY;
        }
        return GOOGLE_PHONE_UTIL.format(phoneNumber, PhoneNumberFormat.RFC3966);
    }

    public static Set<String> getSupportedRegions() {
        return GOOGLE_PHONE_UTIL.getSupportedRegions();
    }

    public static int getCountryCodeForRegion(String regionCode) {
        return GOOGLE_PHONE_UTIL.getCountryCodeForRegion(regionCode);
    }

    public static int getCountryCodeForPhoneNumber(PhoneNumber number) {
        return number.getCountryCode();
    }

    public static PhoneNumberTypeEnum getPhoneNumberType(Object data, String regionCode) {
        return getPhoneNumberType(parseToPhoneNumber(data, regionCode));
    }

    public static PhoneNumberTypeEnum getPhoneNumberType(PhoneNumber number) {
        if (number != null) {
            PhoneNumberType numberType = GOOGLE_PHONE_UTIL.getNumberType(number);
            switch (numberType) {
            case FIXED_LINE:
                return PhoneNumberTypeEnum.FIXED_LINE;
            case MOBILE:
                return PhoneNumberTypeEnum.MOBILE;
            case FIXED_LINE_OR_MOBILE:
                return PhoneNumberTypeEnum.FIXED_LINE_OR_MOBILE;
            case PAGER:
                return PhoneNumberTypeEnum.PAGER;
            case PERSONAL_NUMBER:
                return PhoneNumberTypeEnum.PERSONAL_NUMBER;
            case TOLL_FREE:
                return PhoneNumberTypeEnum.TOLL_FREE;
            case PREMIUM_RATE:
                return PhoneNumberTypeEnum.PREMIUM_RATE;
            case SHARED_COST:
                return PhoneNumberTypeEnum.SHARED_COST;
            case UAN:
                return PhoneNumberTypeEnum.UAN;
            case VOICEMAIL:
                return PhoneNumberTypeEnum.VOICEMAIL;
            case VOIP:
                return PhoneNumberTypeEnum.VOIP;
            default:

            }
        }
        return PhoneNumberTypeEnum.UNKNOWN;
    }

    /**
     * Checks whether a phone number contains a valid region.
     * 
     * @param data a phone number String or number. the data string must be guaranteed to start with a '+' followed by
     * the country calling code. like as "+1 242-365-1234" or "+12423651234"
     * @return {@code true} if it contains a valid region, {@code false} otherwise.
     */
    public static boolean containsValidRegionCode(Object data) {
        String regionCode = extractRegionCode(data);
        return regionCode != null && getSupportedRegions().contains(regionCode);
    }

    /**
     * Gets a region code from a phone number.
     * 
     * @param phoneData a phone number String or number. the data string must be guaranteed to start with a '+' followed
     * by the country calling code. like as "+1 242-365-1234" or "+12423651234"
     * @return the region code, the empty string if it's invalid.
     */
    public static String extractRegionCode(Object phoneData) {
        return extractRegionCode(phoneData, null);
    }

    /**
     * Gets a region code from a phone number.
     *
     * @param phoneData a phone number String or number.
     * @return the region code, the empty string if it's invalid.
     */
    public static String extractRegionCode(Object phoneData, String regionCode) {
        return extractRegionCode(parseToPhoneNumber(phoneData, regionCode));
    }

    /**
     * Gets a region code from a phone number.
     *
     * @param phoneNumber a phone number String or number.
     * @return the region code, the empty string if it's invalid.
     */
    public static String extractRegionCode(PhoneNumber phoneNumber) {
        if (phoneNumber != null) {
            return GOOGLE_PHONE_UTIL.getRegionCodeForNumber(phoneNumber);
        }
        return StringUtils.EMPTY;
    }

    /**
     * Gets a country code from a phone number.
     * 
     * @param phoneData a phone number String or number. the data string must be guaranteed to start with a '+' followed
     * by the country calling code. like as "+1 242-365-1234" or "+12423651234"
     * @return the country code, or zero if it's invalid.
     */
    public static int extractCountrycode(Object phoneData) {
        PhoneNumber phoneNumber = parseToPhoneNumber(phoneData, null);
        if (phoneNumber != null) {
            return phoneNumber.getCountryCode();
        }
        return 0;
    }

    /**
     * Returns a text description for the given phone number, in the language provided. The description might consist of
     * the name of the country where the phone number is from, or the name of the geographical area the phone number is
     * from if more detailed information is available.
     * 
     * @param data a phone number String or number.
     * @param regionCode the regionCode that we are expecting the number to be dialed from
     * @param languageCode the language code for which the description should be written.
     * @return a textual description for the given phone number
     */
    public static String getGeocoderDescriptionForNumber(Object data, String regionCode, Locale languageCode) {
        return getGeocoderDescriptionForNumber(parseToPhoneNumber(data, regionCode), languageCode);
    }

    /**
     * Returns a text description for the given phone number, in the language provided. The description might consist of
     * the name of the country where the phone number is from, or the name of the geographical area the phone number is
     * from if more detailed information is available.
     *
     * @param number the phone number
     * @param languageCode the language code for which the description should be written.
     * @return a textual description for the given phone number
     */
    public static String getGeocoderDescriptionForNumber(PhoneNumber number, Locale languageCode) {
        if (number != null) {
            return PhoneNumberOfflineGeocoder.getInstance().getDescriptionForNumber(number, languageCode);
        }
        return StringUtils.EMPTY;
    }

    /**
     * Gets the name of the carrier for the given phone number, in the language provided. The carrier name is the one the
     * number was originally allocated to, however if the country supports mobile number portability the number might
     * not belong to the returned carrier anymore. If no mapping is found an empty string is returned.
     * 
     * @param data the phone number for which we want to get a carrier name
     * @param regionCode the regionCode that we are expecting the number to be dialed from
     * @param languageCode the language code for which the description should be written.
     * @return the carrier name for the given phone number
     */
    public static String getCarrierNameForNumber(Object data, String regionCode, Locale languageCode) {
        return getCarrierNameForNumber(parseToPhoneNumber(data, regionCode), languageCode);
    }

    /**
     * Gets the name of the carrier for the given phone number, in the language provided. The carrier name is the one the
     * number was originally allocated to, however if the country supports mobile number portability the number might
     * not belong to the returned carrier anymore. If no mapping is found an empty string is returned.
     *
     * @param number the phone number for which we want to get a carrier name
     * @param languageCode the language code for which the description should be written.
     * @return the carrier name for the given phone number
     */
    public static String getCarrierNameForNumber(PhoneNumber number, Locale languageCode) {
        if (number == null) {
            return StringUtils.EMPTY;
        }
        return PhoneNumberToCarrierMapper.getInstance().getNameForNumber(number, languageCode);
    }

    /**
     * Returns a list of time zones to which a phone number belongs. When the PhoneNumber is invalid, returns UNKNOWN TIME
     * ZONE;when the PhoneNumberType is NOT FIXED_LINE,MOBILE,FIXED_LINE_OR_MOBILE, returns the list of time zones
     * corresponding to the country calling code; or else, return the list of corresponding time zones
     * 
     * @param data the phone number for which we want to get a list of Time zones
     * @param regionCode the expected region code of the number.
     * @return a list of time zones, UNKNOWN TIME ZONE, when the PhoneNumber is invalid.
     */
    public static List<String> getTimeZonesForNumber(Object data, String regionCode) {
        return getTimeZonesForNumber(parseToPhoneNumber(data, regionCode));
    }

    /**
     * Returns a list of time zones to which a phone number belongs. When the PhoneNumber is invalid, returns UNKNOWN TIME
     * ZONE;when the PhoneNumberType is NOT FIXED_LINE,MOBILE,FIXED_LINE_OR_MOBILE, returns the list of time zones
     * corresponding to the country calling code; or else, return the list of corresponding time zones.
     *
     * @param number the phone number for which we want to get a list of Time zones
     * @return a list of time zones, UNKNOWN TIME ZONE, when the PhoneNumber is invalid.
     */
    public static List<String> getTimeZonesForNumber(PhoneNumber number) {
        if (number == null) {
            return Collections.singletonList(PhoneNumberToTimeZonesMapper.getUnknownTimeZone());
        }
        return PhoneNumberToTimeZonesMapper.getInstance().getTimeZonesForNumber(number);
    }

    public static List<String> getTimeZonesForNumber(Object data, String regionCode, boolean withUnknownTimeZone) {
        return getTimeZonesForNumber(parseToPhoneNumber(data, regionCode), withUnknownTimeZone);
    }

    public static List<String> getTimeZonesForNumber(PhoneNumber phoneNumber, boolean withUnknownTimeZone) {
        List<String> timezones = getTimeZonesForNumber(phoneNumber);
        if (withUnknownTimeZone || !timezones.contains(PhoneNumberToTimeZonesMapper.getUnknownTimeZone())) {
            return timezones;
        }
        return Collections.emptyList();
    }

}
