/**
 * 
 */
package com.hna.helper;

import org.springframework.stereotype.Component;

import com.hna.tdp.model.TripMo;
import com.hna.tdp.model.ReservationRetrieve.AirTripMo;
import com.hna.tdp.model.ReservationRetrieve.DocumentMo;
import com.hna.tdp.model.ReservationRetrieve.FlightFareMo;
import com.hna.tdp.model.ReservationRetrieve.FlightReMo;
import com.hna.tdp.model.ReservationRetrieve.ReservationElementMo;
import com.hna.tdp.model.ReservationRetrieve.ReservationInfoMo;
import com.hna.tdp.model.ReservationRetrieve.TravelerMo;
import com.hna.view.ReservationFo;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月13日
 */
@Component
public class ReservationInfoHelper {

    public void getReservationInfo(ReservationInfoMo reservationInfo) {
        for (ReservationElementMo resEleMo : reservationInfo.getReservationElement()) {

            /**
             * Document 信息中 traveler
             */
            if (resEleMo.getDocument() != null) {
            for (DocumentMo document : resEleMo.getDocument()) {
                String travelerId = document.getTravelerReference();

                for (TravelerMo travelerMo : reservationInfo.getTraveler()) {
                    if (travelerId.equals(travelerMo.getID())) {
                        document.setTraveler(travelerMo);
                    }
                }

            }
            }

            AirTripMo airTripMo = resEleMo.getAir().getAirTrip();

            /*
             * TripPricing. 直接复用 计算税费的Helper。
             */
            TripCalculationRSHelper triphelper = new TripCalculationRSHelper();
            TripMo tripMo = new TripMo();
            tripMo.setTripPricing(airTripMo.getTripPricing());
            tripMo.setTaxFeeContent(airTripMo.getTaxFeeContent());
            triphelper.getTripCalculationVo(tripMo);
            airTripMo.setTripPricing(tripMo.getTripPricing());

            /*
             * FlightFare
             */

            for (FlightFareMo flightFareMo : airTripMo.getFlightFare()) {
                String fsId = flightFareMo.getFlightSegments().getFlightSegmentRef();

                for (FlightReMo flightReMo : airTripMo.getFlightInformation().get("Flight")) {
                    if (fsId.equals(flightReMo.getFlightSegment().getID())) {
                        flightFareMo.setFlightSegmentMo(flightReMo.getFlightSegment());
                    }
                }

            }

        }

    }

    public ReservationFo getReservationFo(ReservationInfoMo reservationInfo) {
        ReservationFo reservationFo = new ReservationFo();

        return reservationFo;
    }

}
