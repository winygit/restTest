/**
 * 
 */
package com.hna.tdp.model;

import java.util.List;
import java.util.Map;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月9日
 */
public class FareFamilyMo {


    private String ID;
    public List<Map<String, List<EntryMo>>> Attribute;

    private Map<String, List<EntryMo>> Name;

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }


    public List<Map<String, List<EntryMo>>> getAttribute() {
        return Attribute;
    }

    public void setAttribute(List<Map<String, List<EntryMo>>> attribute) {
        Attribute = attribute;
    }

    public Map<String, List<EntryMo>> getName() {
        return Name;
    }

    public void setName(Map<String, List<EntryMo>> name) {
        Name = name;
    }

}
