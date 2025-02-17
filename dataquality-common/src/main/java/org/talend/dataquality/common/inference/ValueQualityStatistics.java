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
package org.talend.dataquality.common.inference;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.fasterxml.jackson.annotation.JsonIgnore;

import static org.talend.dataquality.common.inference.AvroQualityAnalyzer.EMPTY_VALUE;
import static org.talend.dataquality.common.inference.AvroQualityAnalyzer.INVALID_VALUE;
import static org.talend.dataquality.common.inference.AvroQualityAnalyzer.VALID_VALUE;

/**
 * created by talend on 2015-07-28 Detailled comment.
 *
 */
public class ValueQualityStatistics implements Serializable {

    private static final long serialVersionUID = -4839915401904443142L;

    private final Set<String> invalidValues = new HashSet<>();

    private final Set<String> unknownValues = new HashSet<>();

    private long validCount;

    private long emptyCount;

    private long invalidCount;

    private long unknownCount;

    public Set<String> getInvalidValues() {
        return invalidValues;
    }

    public Set<String> getUnknownValues() {
        return unknownValues;
    }

    public long getValidCount() {
        return validCount;
    }

    public void setValidCount(long newCount) {
        validCount = newCount;
    }

    public long getEmptyCount() {
        return emptyCount;
    }

    public void setEmptyCount(long newCount) {
        emptyCount = newCount;
    }

    public long getInvalidCount() {
        return invalidCount;
    }

    public void setInvalidCount(long newCount) {
        invalidCount = newCount;
    }

    public long getUnknownCount() {
        return unknownCount;
    }

    public void setUnknownCount(long newCount) {
        unknownCount = newCount;
    }

    @JsonIgnore
    public long getCount() {
        return validCount + emptyCount + invalidCount + unknownCount;
    }

    public ValueQualityStatistics mergeCounts(ValueQualityStatistics stats) {
        validCount += stats.validCount;
        invalidCount += stats.invalidCount;
        emptyCount += stats.emptyCount;
        return this;
    }

    public Map<String, Long> toMap() {
        final Map<String, Long> map = new TreeMap<>();
        map.put(Integer.toString(INVALID_VALUE), invalidCount);
        map.put(Integer.toString(VALID_VALUE), validCount);
        map.put(Integer.toString(EMPTY_VALUE), emptyCount);
        map.put("total", invalidCount + validCount + emptyCount);
        return map;
    }

    public void incrementValid() {
        validCount++;
    }

    public void incrementEmpty() {
        emptyCount++;
    }

    public void incrementInvalid() {
        invalidCount++;
    }

    public void incrementUnknown() {
        unknownCount++;
    }

    public void appendInvalidValue(String value) {
        invalidValues.add(value);
    }

    public void appendUnknownValue(String value) {
        unknownValues.add(value);
    }

    @Override
    public String toString() {
        return "ValueQuality{" + "valid=" + validCount + ", empty=" + emptyCount + ", invalid=" + invalidCount + '}'
                + ", unknown=" + unknownCount + '}' + "InvalidValues{" + invalidValues + "}" + " UnknownValues{"
                + unknownValues + "}";
    }
}
