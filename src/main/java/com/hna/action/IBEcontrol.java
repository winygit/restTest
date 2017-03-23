/**
 * 
 */
package com.hna.action;

import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hna.util.RegexSwitch;
import com.travelsky.ibe.client.AV;
import com.travelsky.ibe.client.AVReq;
import com.travelsky.ibe.client.AvResult;
import com.travelsky.ibe.client.pnr.DETR;
import com.travelsky.ibe.client.pnr.RT;
import com.travelsky.ibe.client.pnr.RTResult;


/**
 * <p>
 * IBE指令查询控制器
 * </p>
 * 
 * @author winy
 * @date 2017年3月15日
 */
@RequestMapping(value = { "api" })
@Controller
public class IBEcontrol {

    private Logger log = LoggerFactory.getLogger(OTaRestController.class);

    // 当前航司
    private String airlineNow = "GS";
    /*
     * 查询pnr信息
     */
    @RequestMapping("/pnrinfo")
    public void PNRinfo(String pnrno, String his, Writer writer, HttpServletRequest request) {

        try {
            if (StringUtils.isEmpty(pnrno)) {
                writer.write("请输入PNR号...");
                return;
            }

            RT rt = new RT();
            RTResult result = null;

            if ("true".equalsIgnoreCase(his)) {
                result = rt.retrieveCompletely(pnrno);
                String rs = result.getOringinalRT();
                writer.write(RegexSwitch.switchForIBEPnrHis(rs));
                // writer.write(rs);

            } else {
                result = rt.retrieve(pnrno);
                log.debug("Id[{}] 用户名[{}] : 查询PNR[{}]信息。", request.getSession().getAttribute("userId"),
                        request.getSession().getAttribute("userName"), pnrno);
                writer.write(result.toString());
            }
        } catch (Exception e) {
            try {
                writer.write(e.toString());
            } catch (IOException e1) {
                throw new RuntimeException(e1.getMessage());
            }

        }
    }


    /*
     * 查询 电子客票信息
     */
    @RequestMapping("/tktinfo")
    public void detrTkt(String tktNo, String his, Writer writer, HttpServletRequest request) {

        try {
            if (StringUtils.isEmpty(tktNo)) {
                writer.write("请输入客票号...");
                return;
            }

            DETR detr = new DETR();
            Object result = null;
            if ("true".equalsIgnoreCase(his)) {
                result = detr.getTicketHistoryByTktNo(tktNo);
            } else {
                result = detr.getTicketInfoByTktNo(tktNo);
            }
            log.debug("Id[{}] 用户名[{}] : 查询票号[{}]信息。", request.getSession().getAttribute("userId"),
                    request.getSession().getAttribute("userName"), tktNo);
            writer.write(result.toString());
        } catch (Exception e) {
            try {
                writer.write(e.toString());
            } catch (IOException e1) {
                throw new RuntimeException(e1.getMessage());
            }
        }
    }


    /*
     * 查询开仓情况
     */
    @RequestMapping("/AVinfo")
    public void AVinfo(String org, String dst, String dateStr, Boolean nowAirline, Boolean isdirect,
            Writer writer, HttpServletRequest request)
            throws Exception {

        // 检查参数
        if (StringUtils.isEmpty(org) || StringUtils.isEmpty(dst) || StringUtils.isEmpty(dateStr)) {
            writer.write("参数输入不完整....");
            return;
        }

        AV av = new AV();
        AVReq avreq = new AVReq();

        avreq.setOrg(org);
        avreq.setDst(dst);
        avreq.setDirect(isdirect);
         if (nowAirline)
         {
            avreq.setAirline(this.airlineNow);
        } else {
            avreq.setAirline("ALL");
         }
        
        // avreq.setAirline("ALL");
        

        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = localSimpleDateFormat.parse(dateStr);
            avreq.setDateOfFlight(date);
        } catch (ParseException e1) {
            writer.write("日期格式不正确！请输入yyyy-MM-dd格式日期信息。\n");
            return;
        }

        try {
            AvResult avResult = av.getAvailability(avreq);
            log.debug("Id[{}] 用户名[{}] : 查询[{},{}] AV信息。", request.getSession().getAttribute("userId"),
                    request.getSession().getAttribute("userName"), org, dst);
            writer.write(avResult.toString());
        } catch (Exception e) {
            writer.write(e.toString());
        }
    }


}
