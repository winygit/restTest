/**
 * 
 */
package com.hna.tdp.model.refund;

import java.util.List;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月14日
 */
public class GuestMo {

    private String DocNumber;
    private String DocType;
    private String Name;
    private String Phone;
    private String Type;

    private List<Pax> Paxs;

    public String getDocNumber() {
        return DocNumber;
    }

    public void setDocNumber(String docNumber) {
        DocNumber = docNumber;
    }

    public String getDocType() {
        return DocType;
    }

    public void setDocType(String docType) {
        DocType = docType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public List<Pax> getPaxs() {
        return Paxs;
    }

    public void setPaxs(List<Pax> paxs) {
        Paxs = paxs;
    }

}
