package com.hna.mapper;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.hna.model.requestFormValue.TripSearchFv;
import com.hna.model.requestRestValue.TripsSearchRv;

@Component
public class TripsSearchMapper {

    public TripsSearchRv mapper(TripSearchFv fv) {
        TripsSearchRv rv = new TripsSearchRv();
        BeanUtils.copyProperties(fv, rv);
        // leg参数
        List<String> legs = new ArrayList<String>();
        String leg = MessageFormat.format("index:0;origin:{0};originType:A;destination:{1};destinationType:A;date:{2}",
                fv.getOrigin(), fv.getDestination(), fv.getDate());
        legs.add(leg);

        if (fv.getTrip() == 1) {
            String leg1 = MessageFormat.format(
                    "index:1;origin:{0};originType:A;destination:{1};destinationType:A;date:{2}", fv.getDestination(),
                    fv.getOrigin(), fv.getReturnDate());
            legs.add(leg1);

        }
        rv.setLegs(legs);
        // traveler参数
        int adt = fv.getAdtNum().intValue();
        int cnn = fv.getCnnNum().intValue();
        int inf = fv.getInfNum().intValue();

        List<String> traveler = new ArrayList<String>();
        while (adt > 0) {
            traveler.add("code:ADT");
            adt--;
        }
        while (cnn > 0) {
            traveler.add("code:CNN");
            cnn--;
        }
        while (inf > 0) {
            traveler.add("code:INF");
            inf--;
        }
        rv.setTraveler(traveler);

        return rv;

    }

    public Map<String, Object> mapperToRequestMap(TripsSearchRv rv) {
        Map<String, Object> request = new HashMap<String, Object>();

        request.put("leg", rv.getLegs());
        request.put("traveler", rv.getTraveler());
        request.put("cabin", rv.getCabin());
        request.put("flexible", rv.getFlexible());

        return request;

    }

}
