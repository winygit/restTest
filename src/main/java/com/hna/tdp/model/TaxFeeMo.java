/**
 * 
 */
package com.hna.tdp.model;

import java.util.List;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月11日
 */
public class TaxFeeMo {

    private String ID;
    private List<TaxFeeEntryMo> Entry;

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public List<TaxFeeEntryMo> getEntry() {
        return Entry;
    }

    public void setEntry(List<TaxFeeEntryMo> entry) {
        Entry = entry;
    }

}
