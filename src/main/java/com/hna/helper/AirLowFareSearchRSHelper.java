/**
 * 
 */
package com.hna.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.hna.tdp.model.AirLowFareSearchRSMo;
import com.hna.tdp.model.FareFamilyMo;
import com.hna.tdp.model.FlightInformationAttributeMo;
import com.hna.tdp.model.FlightInformationMo;
import com.hna.tdp.model.FlightItineraryPriceMo;
import com.hna.tdp.model.FlightMo;
import com.hna.tdp.model.FlightSegmentMo;
import com.hna.tdp.model.PriceMo;
import com.hna.tdp.value.AirLowFareSearchRSVo;
import com.hna.tdp.value.FlightInformationAttributeVo;
import com.hna.tdp.value.FlightItineraryPriceVo;
import com.hna.tdp.value.PriceVo;
import com.hna.view.TripSegment;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月10日
 */
@Component
public class AirLowFareSearchRSHelper {

    // model-->value
    public AirLowFareSearchRSVo getAirLowFareSearchRSVo(AirLowFareSearchRSMo model) {
        AirLowFareSearchRSVo value = new AirLowFareSearchRSVo();

        BeanUtils.copyProperties(model, value);
        List<FlightItineraryPriceVo> fipVos = new ArrayList<FlightItineraryPriceVo>();

        for (FlightItineraryPriceMo fipMo : model.getFlightItineraryPricePoints().get("FlightItineraryPricePoint")) {

            /*
             * 主要有4个引用的替换:FlightInformationRef,PricePointRef,
             * PriceMo中的FareFamilyRef,
             * FlightInformationAttributesMo中的FlightSegmentRef.
             */
            // 0.定义Vo变量
            FlightItineraryPriceVo fipVo = new FlightItineraryPriceVo();

            // 1.基本属性全拷贝
            BeanUtils.copyProperties(fipMo, fipVo);
            // 2.FlightInformationRef引用替换
            String FlightInformationRef=fipMo.getFlightInformationRef();
            List<FlightInformationMo> flightinfolist = model.getFlightInformationSummary().get("FlightInformation");
            for (FlightInformationMo fiMo : flightinfolist)
            {
                if (FlightInformationRef.equals(fiMo.getID())) {
                    // 航班信息替换
                    fipVo.setFlightInformationVo(fiMo);
                }
            }
            // 3.PricePointRef引用替换
            PriceVo priceVo = new PriceVo();
            String pricePointRef = fipMo.getPricePointRef();
            List<PriceMo> pricelist = model.getPricePointSummary().get("PricePoint");
            for (PriceMo priceMo : pricelist) {
                if (pricePointRef.equals(priceMo.getID())) {
                    BeanUtils.copyProperties(priceMo, priceVo);
                    // 4. PriceMo中的FareFamilyRef
                    String fareFamilyRef = priceMo.getFareFamilyRef();
                    List<FareFamilyMo> ffList = model.getFareFamilyContent().get("FareFamily");
                    for (FareFamilyMo familyMo : ffList) {
                        if (familyMo.getID().equals(fareFamilyRef)) {
                            priceVo.setFareFamily(familyMo);
                        }
                    }
                    // PriceMo中的FareFamilyRef
                }
            }
            fipVo.setPriceVo(priceVo);
            
            // 5.FlightInformationAttributesMo中的FlightSegmentRef
           List<FlightInformationAttributeVo> fiAttrs=new ArrayList<FlightInformationAttributeVo>();
            List<FlightInformationAttributeMo> flightInformationAttributes = fipMo.getFlightInformationAttributes();
            for(FlightInformationAttributeMo flightInformationAttributeMo:flightInformationAttributes)
            {
                String flightSegmentRef = flightInformationAttributeMo.getFlightSegmentRef();
                for(FlightMo flightMo: fipVo.getFlightInformationVo().getFlight())
                {
                    for(FlightSegmentMo flightSegmentMo:flightMo.getFlightSegment())
                    {
                        if (flightSegmentRef.equals(flightSegmentMo.getID()))
                                {
                                       FlightInformationAttributeVo finfo=new FlightInformationAttributeVo();
                                       BeanUtils.copyProperties(flightInformationAttributeMo, finfo);
                                       finfo.setFlightSegment(flightSegmentMo);
                                       fiAttrs.add(finfo);
                            
                                }
                    }
                }
               
                fipVo.setFlightInformationAttributes(fiAttrs);
            }
            fipVos.add(fipVo);
        }
        value.setFlightItineraryPricesVos(fipVos);
        return value;
    }

    // value-->view

    public List<TripSegment> getTripsData(AirLowFareSearchRSVo value, int in) {
        List<TripSegment> tripSegments = new ArrayList<TripSegment>();

        // int in = 0;// 0:英文; 1:中文
        for (FlightItineraryPriceVo flightItineraryPriceVo : value.getFlightItineraryPricesVos()) {

            TripSegment tripSegment = new TripSegment();
            // 航程号
            tripSegment.setLeg(flightItineraryPriceVo.getLeg());
            // 航段号
            tripSegment.setIndex(flightItineraryPriceVo.getIndex());

            // 产品名
            FareFamilyMo ffMo=flightItineraryPriceVo.getPriceVo().getFareFamily();
            tripSegment.setFarefamilyName(ffMo.getName().get("Entry").get(in).getValue());
            // 退改规则
            // StringBuffer ffBuffer = new StringBuffer();
            // List<Map<String, List<EntryMo>>> attributes =
            // ffMo.getAttribute();
            // for (Map<String, List<EntryMo>> attr : attributes)
            // {
            // ffBuffer.append(attr.get("Entry").get(in).getValue());//
            // .append("<br/>");
            //
            // }
            
            // tripSegment.setFfAttribute(ffBuffer.toString().replace("\'",
            // "").replace("\"", ""));

            // 票面价
            tripSegment.setBaseFareAmount(
                    flightItineraryPriceVo.getPriceVo().getBasedOnPTCPricing().getFare().getBaseFareAmount());
            // 总价
            tripSegment.setTotalFareAmount(
                    flightItineraryPriceVo.getPriceVo().getBasedOnPTCPricing().getFare().getTotalFareAmount());
            // Y舱全价
            tripSegment.setFullYFareAmount(
                    flightItineraryPriceVo.getPriceVo().getBasedOnPTCPricing().getFare().getFullYFareAmount());

            // 出发时间
            /*
             * 考虑一个flightInformation只有一个Flight,一个Flight下只有一个FlightSegment。(
             * 不考虑中转)
             */
            FlightSegmentMo flightSegmentMo = flightItineraryPriceVo.getFlightInformationVo().getFlight().get(0)
                    .getFlightSegment().get(0);
            tripSegment.setDepartureDate(flightSegmentMo.getDepartureDate());
            tripSegment.setArrivalDate(flightSegmentMo.getArrivalDate());
            tripSegment.setEquipmentCode(flightSegmentMo.getEquipmentCode());
            tripSegment.setFlightNumber(flightSegmentMo.getMarketingAirline() + flightSegmentMo.getFlightNumber());
            tripSegment.setTotalFlightDuration(flightSegmentMo.getTotalFlightDuration());

            /*
             * 考虑只有一个航段
             */
            tripSegment
                    .setBookingClass(flightItineraryPriceVo.getFlightInformationAttributes().get(0).getBookingClass());
            tripSegment.setCabinClass(flightItineraryPriceVo.getFlightInformationAttributes().get(0).getCabinClass());
            tripSegment.setSeatsAvailable(
                    flightItineraryPriceVo.getFlightInformationAttributes().get(0).getSeatsAvailable());

            tripSegments.add(tripSegment);

        }
        return tripSegments;
    }
}
