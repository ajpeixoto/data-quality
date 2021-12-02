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
package org.talend.dataquality.standardization.phone;

import java.util.List;
import java.util.Locale;

/**
 * A wrapper for {@link PhoneNumberHandlerBase} that uses a default region code and a default Locale.
 */
public class PhoneNumberHandler {

    private final String defaultRegion;

    private final Locale defaultLocale;

    public PhoneNumberHandler(String defaultRegion, Locale defaultLocale) {
        this.defaultRegion = defaultRegion;
        this.defaultLocale = defaultLocale;
    }

    /**
     * Uses the system defaults i.e., {@code Locale.getDefault().getCountry()} and {@code Locale.getDefault()}
     */
    public PhoneNumberHandler() {
        this(Locale.getDefault().getCountry(), Locale.getDefault());
    }

    public Locale getDefaultLocale() {
        return defaultLocale;
    }

    public String getDefaultRegion() {
        return defaultRegion;
    }

    public boolean isValidPhoneNumber(Object data) {
        return PhoneNumberHandlerBase.isValidPhoneNumber(data, defaultRegion);
    }

    public boolean isPossiblePhoneNumber(Object data) {
        return PhoneNumberHandlerBase.isPossiblePhoneNumber(data, defaultRegion);
    }

    public String formatE164(Object data) {
        return PhoneNumberHandlerBase.formatE164(data, defaultRegion);
    }

    public String formatInternational(Object data) {
        return PhoneNumberHandlerBase.formatInternational(data, defaultRegion);
    }

    public String formatNational(Object data) {
        return PhoneNumberHandlerBase.formatNational(data, defaultRegion);
    }

    public String formatRFC396(Object data) {
        return PhoneNumberHandlerBase.formatRFC396(data, defaultRegion);
    }

    public PhoneNumberTypeEnum getPhoneNumberType(Object data) {
        return PhoneNumberHandlerBase.getPhoneNumberType(data, defaultRegion);
    }

    public List<String> getTimeZonesForNumber(Object data) {
        return PhoneNumberHandlerBase.getTimeZonesForNumber(data, defaultRegion);
    }

    public String getGeocoderDescriptionForNumber(Object data) {
        return PhoneNumberHandlerBase.getGeocoderDescriptionForNumber(data, defaultRegion, defaultLocale);
    }

    public String getCarrierNameForNumber(Object data) {
        return PhoneNumberHandlerBase.getCarrierNameForNumber(data, defaultRegion, defaultLocale);
    }
}
