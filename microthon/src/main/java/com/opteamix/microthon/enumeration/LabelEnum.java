/**
 * 
 */
package com.opteamix.microthon.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author smadnani
 *
 */
public enum LabelEnum {
    APPLE("apple"), ORANGE("orange"), APPLE_ORANGE("apple_orange");
    
    private static Map<String, LabelEnum> mapRepresentationOfLabel;
    private final String strLabel;
   
    private LabelEnum(final String strLabelValue) {
        this.strLabel = strLabelValue;
    }

    /**
     * @return the value
     */
    public String getStrLabel() {
        return strLabel;
    }
    
    public static LabelEnum valueOfStrLabel(final String strLabel) {
        if (mapRepresentationOfLabel == null) {
            mapRepresentationOfLabel = new HashMap<String, LabelEnum>();
            for (LabelEnum label : values()) {
                mapRepresentationOfLabel.put(label.strLabel, label);
            }
        }
        return mapRepresentationOfLabel.get(strLabel);
    }
    
}
