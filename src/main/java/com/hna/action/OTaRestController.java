package com.hna.action;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.hna.helper.AirLowFareSearchRSHelper;
import com.hna.helper.ReservationInfoHelper;
import com.hna.helper.TripCalculationRSHelper;
import com.hna.model.OtaConfig;
import com.hna.model.requestFormValue.TripSearchFv;
import com.hna.response.ServiceResult;
import com.hna.rest.model.ReservationListInfo;
import com.hna.service.ConfigSevice;
import com.hna.service.HttpService;
import com.hna.tdp.model.AirLowFareSearchRSMo;
import com.hna.tdp.model.TripMo;
import com.hna.tdp.model.ReservationRetrieve.ReservationInfoMo;
import com.hna.tdp.model.refund.OrderMo;
import com.hna.tdp.value.AirLowFareSearchRSVo;
import com.hna.util.GsonUtil;
import com.hna.util.RegexSwitch;
import com.hna.view.TripCalculation;
import com.hna.view.TripSegment;

@RequestMapping(value = { "/app", "/api" })
@Controller
public class OTaRestController {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AirLowFareSearchRSHelper airSearchhelper;
    @Autowired
    private TripCalculationRSHelper tripCalHelper;
    @Autowired
    private ReservationInfoHelper reservationInfoHelper;
    @Autowired
    private ConfigSevice configSevice;
    @Autowired
    private HttpService httpService;

    private Gson gson = new Gson();

    @RequestMapping(value = { "/searchLowFareTrips", "/search-low-fare-trips" })
    public ModelAndView airLowFareSearch(HttpServletRequest request, ModelAndView mav, TripSearchFv fv) {

        // TripsSearchRv rv = tripsSearchMapper.mapper(fv);
        // Map<String, Object> requestParams =
        // tripsSearchMapper.mapperToRequestMap(rv);
        //
        // ServiceResult serviceResult = getJsonData(request, requestParams,
        // configSevice.getOtaConfig("UAT", "mobile"));

        ServiceResult serviceResult = getJsonData(request);
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


    @RequestMapping("/{method}")
    public ModelAndView invokeRest(HttpServletRequest request, ModelAndView mav, @PathVariable String method) {

        //// log.debug("-------invokeRest--{}-------", method);
        // 1.获取json 数据
        ServiceResult serviceResult = getJsonData(request);
        // 2.在页面显示
        mav.addObject("serviceResult", serviceResult);
        mav.setViewName("result");
        return mav;

        }

    @RequestMapping("/main")
    public ModelAndView backmain(ModelAndView mav) {
        mav.setViewName("ticketRest");
        return mav;
    }

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, ModelAndView mav) {

        /*
         * 设置环境
         */
        String env = "uat";
        String otaCode = "mobile";
        if (!StringUtils.isEmpty(request.getParameter("env"))) {
            env = request.getParameter("env").trim();
        }
        if (!StringUtils.isEmpty(request.getParameter("otaCode"))) {
            otaCode = request.getParameter("otaCode").trim();
        }
        // log.debug("env:{} ota: {}", env, otaCode);

        OtaConfig config = configSevice.getOtaConfig(env, otaCode);

        /*
         * 登录
         */
        try {
        String username = request.getParameter("username").trim();

        // ServiceResult serviceResult = getJsonDataNew(request,
        // configSevice.getLoginOtaConfig(env, otaCode));
        ServiceResult serviceResult = getJsonData(request);
        String jsonStr = RegexSwitch.switchForTDP(serviceResult.getResult());

                if (!StringUtils.isEmpty(jsonStr)) {
                JsonElement rs = (JsonElement) GsonUtil.getElement(jsonStr, "success");
                if (rs.getAsBoolean()) {
                    // 登录成功
                    String login = GsonUtil.getValue(GsonUtil.getElement(jsonStr, "ticket"));
                    String userId = GsonUtil.getValue(GsonUtil.getElement(jsonStr, "userId"));
                    // 放入session
                    request.getSession(true).setAttribute("otaconfig", config);
                    request.getSession(true).setAttribute("login", login);
                    request.getSession(true).setAttribute("userId", userId);
                    request.getSession(true).setAttribute("userName", username);
                    request.getSession(true).setAttribute("env", env);
                    request.getSession(true).setAttribute("ota", otaCode);

                    log.debug("userId:{} ,userName {}", userId, username);
                    log.debug("otaconfig:{} ,login {}", config, login);
                    // mav.setViewName("APPticketUAT");

                    mav.setViewName("ticketRest");
                    // mav.setViewName("ticket/flightSearch");
                    return mav;

                }
            }
        } catch (Exception e) {
            // log.debug("登录处理异常！ {}", e.getMessage());
            mav.addObject("loginRs", "登录错误!");
            mav.setViewName("login");

            return mav;
        }

        mav.addObject("loginRs", "登录名或者账号错误!");

        // mav.setViewName("APPticketUAT");
        mav.setViewName("login");
        // mav.setViewName("mainGs");
        return mav;

    }

    @RequestMapping("/login2")
    public ModelAndView loginNoTest(HttpServletRequest request, ModelAndView mav) {
        String env = "uat";
        String otaCode = "mobile";
        if (!StringUtils.isEmpty(request.getParameter("env"))) {
            env = request.getParameter("env").trim();
        }
        if (!StringUtils.isEmpty(request.getParameter("otaCode"))) {
            otaCode = request.getParameter("otaCode").trim();
        }
        // log.debug("env:{} ota: {}", env, otaCode);

        OtaConfig config = configSevice.getOtaConfig(env, otaCode);

        // 放入session
        request.getSession(true).setAttribute("otaconfig", config);
        request.getSession(true).setAttribute("userId", "admin");
        request.getSession(true).setAttribute("userName", "admin");
        request.getSession(true).setAttribute("env", env);
        request.getSession(true).setAttribute("ota", otaCode);

        mav.setViewName("ticketRest");

        return mav;
    }

    @RequestMapping(value = { "/calculateTrip", "/calculate-trip" })
    public ModelAndView TripCalculation(HttpServletRequest request, ModelAndView mav) {
        // 1.获取json数据
        ServiceResult serviceResult = getJsonData(request);
        String jsonStr = RegexSwitch.switchForTDP(serviceResult.getResult());
        mav.addObject("serviceResult", serviceResult);
        mav.setViewName("result");
        // 未返回正确的数据
        if (!jsonStr.contains("TripCalculationRS")) {
            return mav;
        }
        // 2.获取model对象
        JsonElement trip = (JsonElement) GsonUtil.getElement(jsonStr, "TripCalculationRS", "Trip");
        TripMo rs = gson.fromJson(trip, TripMo.class);

        // 3.转换成value对象
        tripCalHelper.getTripCalculationVo(rs);
        // 4.转换成view对象
        TripCalculation tripCalculation = tripCalHelper.geTripCalculationData(rs);
        // 5.放入model
        serviceResult.setData(tripCalculation);
        serviceResult.setResultJsp("tripCalculation.jsp");

        mav.addObject("trip", rs);
        mav.addObject("tripCalculation", tripCalculation);
        serviceResult.setResultJsp("tripCalculation.jsp");

        // mav.setViewName("tripCalculation");
        // mav.addObject("serviceResult", serviceResult);
        // mav.setViewName("result");

        return mav;

    }

    @RequestMapping("/queryOrder")
    public ModelAndView reservationList(HttpServletRequest request, ModelAndView mav) {

        // // 1.获取json数据
        // String filename = "D://TripCalculationRS.txt";
        // String jsonStr = RegexSwitch.switchForTDP(getJsonData(filename));

        // 1.获取json数据
        // serviceResult result = getJsonData(request, "queryOrder");
        ServiceResult serviceResult = getJsonData(request);
        String jsonStr = RegexSwitch.switchForTDP(serviceResult.getResult());
        mav.addObject("serviceResult", serviceResult);
        mav.setViewName("result");
        // 未返回正确的数据
        if (!jsonStr.contains("ArrayList")) {
            return mav;
        }
        // 2.获取model对象
        JsonElement trip = (JsonElement) GsonUtil.getElement(jsonStr, "ArrayList");
        Type type = new TypeToken<List<ReservationListInfo>>() {
        }.getType();

        List<ReservationListInfo> orderList = gson.fromJson(trip, type);

        // 5.放入model （不需要转换）

        serviceResult.setResultJsp("orderList.jsp");
        mav.addObject("orders", orderList);
        mav.addObject("num", orderList.size());
        // mav.addObject("serviceResult", serviceResult);
        // mav.setViewName("orderList");
        // mav.setViewName("result");

        return mav;
    }

    @RequestMapping(value = { "/get-reservation", "/get-entire-reservation" })
    public ModelAndView getReservation(HttpServletRequest request, ModelAndView mav) {

        // // 1.获取json数据
        // String filename = "D://TripCalculationRS.txt";
        // String jsonStr = RegexSwitch.switchForTDP(getJsonData(filename));

        // 1.获取json数据
        ServiceResult serviceResult = getJsonData(request);
        // log.debug("json : {}", serviceResult.getResult());
        String jsonStr = RegexSwitch.switchForTDP(serviceResult.getResult());

        mav.addObject("serviceResult", serviceResult);
        mav.setViewName("result");
        // 未返回正确的数据
        if (!jsonStr.contains("ReservationRetrieveRS")) {
            return mav;
        }
        // 2.获取model对象
        JsonElement order = (JsonElement) GsonUtil.getElement(jsonStr, "ReservationRetrieveRS", "Reservation");
        ReservationInfoMo orderInfo = gson.fromJson(order, ReservationInfoMo.class);
        // log.debug("model in json: {}", gson.toJson(orderInfo));

        // 3.转换成value对象
        reservationInfoHelper.getReservationInfo(orderInfo);
        // log.debug("value in json: {}", gson.toJson(orderInfo));

        // 4.转成view对象
        // System.out.println(orderInfo.getCustomer().get(0).getEmail().get(0).getEmailAddress());

        // 5.放入model （不需要转换）
        serviceResult.setData(orderInfo);
        serviceResult.setResultJsp("orderInfo.jsp");

        // mav.addObject("serviceResult", serviceResult);
        // mav.setViewName("result");

        return mav;
    }

    @RequestMapping(value = { "/refundDetail", "/refund-detail" })
    public ModelAndView refundDetail(HttpServletRequest request, ModelAndView mav) {
        // 1.获取数据
        ServiceResult serviceResult = getJsonData(request);
        // 2.转成model
        // System.out.println(serviceResult.getResult());
        String jsonStr = RegexSwitch.switchForTDP(serviceResult.getResult());
        mav.addObject("serviceResult", serviceResult);
        mav.setViewName("result");

        // 未返回正确的数据
        if (!jsonStr.contains("RefundDetailRS")) {
            return mav;
        }

        JsonElement issuccess = (JsonElement) GsonUtil.getElement(jsonStr, "RefundDetailRS", "Success");
        if (issuccess.getAsBoolean() == false) {
            // mav.addObject("serviceResult", serviceResult);
            // mav.setViewName("result");
            return mav;
        }

        // 3.转成value
        JsonElement jElement = (JsonElement) GsonUtil.getElement(jsonStr, "RefundDetailRS", "Data", "Order");

        OrderMo orderMo = gson.fromJson(jElement, OrderMo.class);

        // System.out.println("----------orderMo------------");
        // System.out.println(gson.toJson(orderMo));
        // 3.在页面显示
        serviceResult.setData(orderMo);
        serviceResult.setResultJsp("refundDetail.jsp");
        // mav.addObject("serviceResult", serviceResult);
        // mav.setViewName("result");
        return mav;
    }



    // 获取json数据。
    public ServiceResult getJsonData(HttpServletRequest request) {

        OtaConfig otaConfig = (OtaConfig) request.getSession().getAttribute("otaconfig");

        String method = request.getServletPath().replace("/new", "").substring(1);
        if (method.contains("login")) {
            // 如果是生产环境
            if ("pro".equalsIgnoreCase(request.getParameter("env"))) {
                otaConfig = configSevice.getOtaConfig("pro", "mobile");
            } else {
                otaConfig = configSevice.getOtaConfig("uat", "mobile");
            }
        }
        String url = otaConfig.getRestUrl() + method;

        ServiceResult serviceResult = httpService.sendPost(url, request, otaConfig);
        serviceResult.setMethod(method);
        return serviceResult;
    }

}
