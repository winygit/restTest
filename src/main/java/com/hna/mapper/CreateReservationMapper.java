/**
 * 
 */
package com.hna.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.hna.model.requestFormValue.CreateReservationFv;
import com.hna.model.requestFormValue.TravelerInfo;
import com.hna.model.requestRestValue.CreateReservationRv;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月26日
 */
@Component
public class CreateReservationMapper {


    public CreateReservationRv mapper(CreateReservationFv fv) {
        CreateReservationRv rv = new CreateReservationRv();
        BeanUtils.copyProperties(fv, rv);

        List<String> traveler = new ArrayList<String>();
        for (TravelerInfo tra : fv.getTraveler()) {
            traveler.add(tra.toString());
        }
        rv.setTraveler(traveler);

        rv.setCustomer(fv.getCustomer().toString());

        return rv;
    }

    public Map<String, Object> mapperToRequestMap(CreateReservationRv rv) {
        Map<String, Object> params = new HashMap<String, Object>();

        params.put("login", rv.getLogin());
        params.put("tripOptionId", rv.getTripOptionId());
        params.put("traveler", rv.getTraveler());
        params.put("customer", rv.getCustomer());

        return params;

    }
}
