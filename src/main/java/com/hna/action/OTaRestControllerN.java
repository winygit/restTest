package com.hna.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.hna.helper.AirLowFareSearchRSHelper;
import com.hna.mapper.CreateReservationMapper;
import com.hna.mapper.TripsSearchMapper;
import com.hna.model.OtaConfig;
import com.hna.model.requestFormValue.CreateReservationFv;
import com.hna.model.requestFormValue.TripSearchFv;
import com.hna.model.requestRestValue.CreateReservationRv;
import com.hna.model.requestRestValue.TripsSearchRv;
import com.hna.response.ServiceResult;
import com.hna.service.HttpService;
import com.hna.tdp.model.AirLowFareSearchRSMo;
import com.hna.tdp.value.AirLowFareSearchRSVo;
import com.hna.util.GsonUtil;
import com.hna.util.RegexSwitch;
import com.hna.view.TripSegment;

@RequestMapping(value = { "/new/app", "/new/api" })
@Controller
public class OTaRestControllerN {

    private Logger log = LoggerFactory.getLogger(OTaRestControllerN.class);
    @Autowired
    private AirLowFareSearchRSHelper airSearchhelper;


    @Autowired
    private TripsSearchMapper tripsSearchMapper;
    @Autowired
    private CreateReservationMapper createReservationMapper;
    @Autowired
    private HttpService httpService;


    private Gson gson = new Gson();


    @RequestMapping(value = { "/searchLowFareTrips", "/search-low-fare-trips" })
    public ModelAndView airLowFareSearchN(HttpServletRequest request, ModelAndView mav, TripSearchFv fv) {

        ServiceResult serviceResult = new ServiceResult();
        OtaConfig otaConfig = (OtaConfig) request.getSession().getAttribute("otaconfig");
        if (otaConfig == null) {
            mav.setViewName("login");
            return mav;
        }
        // 1.获取数据
        if (request.getMethod().equals("POST")) {
            TripsSearchRv rv = tripsSearchMapper.mapper(fv);
            Map<String, Object> requestParams = tripsSearchMapper.mapperToRequestMap(rv);
            // 将某些数据放入session
            // 成人乘机人数
            request.getSession().setAttribute("adtNum", fv.getAdtNum());
            // 儿童乘机人数
            request.getSession().setAttribute("cnnNum", fv.getCnnNum());
            // 婴儿乘机人数
            request.getSession().setAttribute("infNum", fv.getInfNum());
            serviceResult = getJsonData(request, requestParams, otaConfig);
        } else {
            serviceResult = getJsonDataByRequest(request, otaConfig);
        }

        // ServiceResult serviceResult = getJsonData(request);
        String jsonStr = RegexSwitch.switchForTDP(serviceResult.getResult());

        mav.addObject("serviceResult", serviceResult);
        mav.setViewName("result");
        // 未返回正确的数据
        if (!jsonStr.contains("AirLowFareSearchRS")) {
            return mav;
        }
        // 2.获取 AirLowFareSearchRSMo
        JsonElement airLowFareSearchRS = (JsonElement) GsonUtil.getElement(jsonStr, "AirLowFareSearchRS");
        AirLowFareSearchRSMo airLowFareSearchRSMo = gson.fromJson(airLowFareSearchRS, AirLowFareSearchRSMo.class);

        // 3.转化成 AirLowFareSearchRSVo
        AirLowFareSearchRSVo airLowFareSearchRSVo = airSearchhelper.getAirLowFareSearchRSVo(airLowFareSearchRSMo);

        // 4.转化成View,便于显示。
        List<TripSegment> tripsDatas = airSearchhelper.getTripsData(airLowFareSearchRSVo, 1);
        // 5.放入model
        mav.addObject("airLowFareSearchRSVo", airLowFareSearchRSVo);
        mav.addObject("tripsDatas", tripsDatas);

        serviceResult.setResultJsp("airLowFareSearchRS.jsp");
        return mav;
    }



    @RequestMapping(value = { "/create-reservation", "/createReservation" })
    public ModelAndView createReservationN(HttpServletRequest request, ModelAndView mav, CreateReservationFv fv) {

        // 1.获取数据
        OtaConfig otaConfig = (OtaConfig) request.getSession().getAttribute("otaconfig");
        if (otaConfig == null) {
            mav.setViewName("login");
            return mav;
        }
        ServiceResult serviceResult = new ServiceResult();
        if (request.getMethod().equals("POST")) {
            CreateReservationRv rv = createReservationMapper.mapper(fv);
            Map<String, Object> requestParams = createReservationMapper.mapperToRequestMap(rv);
            serviceResult = getJsonData(request, requestParams, otaConfig);
        } else {
            serviceResult = getJsonDataByRequest(request, otaConfig);
        }

        // 2.在页面显示
        mav.addObject("serviceResult", serviceResult);
        mav.setViewName("result");
        return mav;

    }




    public ServiceResult getJsonDataByRequest(HttpServletRequest request, OtaConfig otaConfig) {
        String method = request.getServletPath().replace("/new", "").substring(1);
        String url = otaConfig.getRestUrl() + method;
        ServiceResult serviceResult = httpService.sendPost(url, request, otaConfig);
        serviceResult.setMethod(method);

        return serviceResult;
    }

    public ServiceResult getJsonData(HttpServletRequest request, Map<String, Object> params, OtaConfig otaConfig) {
        // String method = request.getServletPath().substring(1);
        // ServiceResult serviceResult = httpservice.sendPostRequestNew(request,
        // method, otaConfig);
        // serviceResult.setMethod(method);
        String method = request.getServletPath().replace("/new", "").substring(1);
        String url = otaConfig.getRestUrl() + method;
        ServiceResult serviceResult = httpService.sendPost(url, params, otaConfig);
        serviceResult.setMethod(method);
        // ServiceResult serviceResult2 = httpService.sendPost(url,
        // request.getParameterMap(), otaConfig);
        return serviceResult;
    }
}
