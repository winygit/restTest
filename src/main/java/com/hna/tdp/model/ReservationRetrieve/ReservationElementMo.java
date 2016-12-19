/**
 * 
 */
package com.hna.tdp.model.ReservationRetrieve;

import java.util.List;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月13日
 */
public class ReservationElementMo {

    private String Status;

    private BookingReferenceMo bookingReferenceMo;

    private List<DocumentMo> Document;

    private AirMo Air;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public BookingReferenceMo getBookingReferenceMo() {
        return bookingReferenceMo;
    }

    public void setBookingReferenceMo(BookingReferenceMo bookingReferenceMo) {
        this.bookingReferenceMo = bookingReferenceMo;
    }

    public List<DocumentMo> getDocument() {
        return Document;
    }

    public void setDocument(List<DocumentMo> document) {
        Document = document;
    }

    public AirMo getAir() {
        return Air;
    }

    public void setAir(AirMo air) {
        Air = air;
    }



}
