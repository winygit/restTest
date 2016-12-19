/**
 * 
 */
package winy.restExercise;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.hna.helper.AirLowFareSearchRSHelper;
import com.hna.tdp.model.AirLowFareSearchRSMo;
import com.hna.tdp.model.FlightItineraryPriceMo;
import com.hna.tdp.value.AirLowFareSearchRSVo;
import com.hna.util.GsonUtil;
import com.hna.util.RegexSwitch;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月9日
 */
public class GsonParseTest {

    private Gson gson = new Gson();

    public void testParese() {

        System.out.println("start test 22....");
        String jsonStr = RegexSwitch.switchForTDP(getJsonData());
        // System.out.println(jsonStr);

        JsonElement airLowFareSearchRS = (JsonElement) GsonUtil.getElement(jsonStr, "AirLowFareSearchRS");
        AirLowFareSearchRSMo rs = gson.fromJson(airLowFareSearchRS, AirLowFareSearchRSMo.class);

        System.out.println(rs.getFlightItineraryPricePoints().get("FlightItineraryPricePoint").size());

        Iterator<FlightItineraryPriceMo> iterator = rs.getFlightItineraryPricePoints().get("FlightItineraryPricePoint")
                .iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println("------------------------");
        }

        System.out.println("FareFamilyContent:" + rs.getFareFamilyContent().get("FareFamily").size());
        System.out.println(
                "FlightInformationSummary:" + rs.getFlightInformationSummary().get("FlightInformation").size());
        System.out.println("PricePoint:" + rs.getPricePointSummary().get("PricePoint").size());

        System.out.println("PricePoint:"
                + rs.getPricePointSummary().get("PricePoint").get(1).getBasedOnPTCPricing().getFare()
                        .getBaseFareAmount());// .get("BasedOnPTCPricing"));//
                                                                      // .getFare().getBaseFareAmount());

        System.out.println(gson.toJson(rs));
        // System.out.println(rs.getSelectedTrip().get("FlightItineraryPricePoints").get("FlightItineraryPricePointRef"));

        AirLowFareSearchRSHelper helper = new AirLowFareSearchRSHelper();

        AirLowFareSearchRSVo airLowFareSearchRSVo = helper.getAirLowFareSearchRSVo(rs);
        System.out.println("-------------------VO---------------------");
        System.out.println(gson.toJson(airLowFareSearchRSVo));

    }

    public String getJsonData() {
        String filename = "D://AirLowFareSearchRS.txt";
        String str = null;
        try {
            FileInputStream fos = new FileInputStream(filename);
            str = IOUtils.toString(fos, "gbk");
            fos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return str;
    }
    public static void main(String[] args) {

        GsonParseTest test = new GsonParseTest();
        test.testParese();

    }

}
