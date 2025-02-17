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
package org.talend.survivorship.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import org.talend.survivorship.model.Attribute;
import org.talend.survivorship.model.DataSet;

/**
 * This is the frequency service to use in rules.
 */
public class FrequencyService extends AbstractService {

    protected HashMap<String, HashMap<Object, Integer>> frequencyMaps = new HashMap<>();

    protected HashMap<String, Integer> maxOccurence = new HashMap<>();

    protected HashMap<String, Integer> secondMaxOccurence = new HashMap<>();

    /**
     * FrequencyService constructor.
     * 
     * @param dataset
     */
    public FrequencyService(DataSet dataset) {
        super(dataset);
    }

    /**
     * Put attribute values into the frequencyMap of a given column.
     * 
     * @param column
     * @param ignoreBlanks
     * @return
     */
    public HashMap<Object, Integer> putAttributeValues(String column, boolean ignoreBlanks) {
        HashMap<Object, Integer> valueToFreq = new HashMap<>();
        frequencyMaps.put(column, valueToFreq);

        for (Attribute attr : dataset.getAttributesByColumn(column)) {
            if (attr.isAlive()) {
                Object value = attr.getValue();
                if (value == null || (ignoreBlanks == true && "".equals(value.toString().trim()))) { //$NON-NLS-1$
                    continue;
                }

                if (valueToFreq.get(value) == null) {
                    // add value to map
                    valueToFreq.put(value, 1);
                } else {
                    // already exists: increment number of occurrences
                    valueToFreq.put(value, valueToFreq.get(value) + 1);
                }
            }
        }

        int max = 0;
        int second = 0;
        for (Entry<Object, Integer> entry : valueToFreq.entrySet()) {
            int freq = entry.getValue();
            if (freq > max) {
                second = max;
                max = freq;
            } else if (freq < max && freq > second) {
                second = freq;
            }
        }
        maxOccurence.put(column, max);
        secondMaxOccurence.put(column, second);
        return valueToFreq;
    }

    /**
     * Retrieve the most common value of a given column.
     * 
     * @param column
     * @param ignoreBlanks
     * @return
     */
    public HashSet<Object> getMostCommonValue(String column, boolean ignoreBlanks) {

        HashMap<Object, Integer> valueToFreq = frequencyMaps.get(column);

        if (valueToFreq == null) {
            valueToFreq = putAttributeValues(column, ignoreBlanks);
        }
        int max = maxOccurence.get(column);
        HashSet<Object> mostFrequentValues = new HashSet<Object>();

        for (Entry<Object, Integer> entry : valueToFreq.entrySet()) {
            Object obj = entry.getKey();
            int count = entry.getValue();
            if (count == max) {
                mostFrequentValues.add(obj);
            }
        }

        return mostFrequentValues;
    }

    /**
     * Retrieve the second most common value of a given column.
     * 
     * @param column
     * @param ignoreBlanks
     * @return
     */
    public HashSet<Object> getSecondMostCommonValue(String column, boolean ignoreBlanks) {

        HashMap<Object, Integer> valueToFreq = frequencyMaps.get(column);

        if (valueToFreq == null) {
            valueToFreq = putAttributeValues(column, ignoreBlanks);
        }
        int second = secondMaxOccurence.get(column);
        HashSet<Object> secondMostFrequentValues = new HashSet<Object>();

        for (Entry<Object, Integer> entry : valueToFreq.entrySet()) {
            Object obj = entry.getKey();
            int count = entry.getValue();
            if (count == second) {
                secondMostFrequentValues.add(obj);
            }
        }

        return secondMostFrequentValues;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.survivorship.services.AbstractService#init()
     */
    @Override
    public void init() {
        frequencyMaps.clear();
        maxOccurence.clear();
        secondMaxOccurence.clear();
    }

}
