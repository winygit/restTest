/**
 * 
 */
package winy.restExercise;

import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.hna.helper.TripCalculationRSHelper;
import com.hna.tdp.model.TripMo;
import com.hna.util.GsonUtil;
import com.hna.util.RegexSwitch;
import com.hna.view.TripCalculation;

/**
 *<p>
 *
 *</p>
 * @author winy  
 * @date 2016年12月9日
 */
public class GsonParseVerify {

    private Gson gson = new Gson();

    public void testParese() {

        System.out.println("start test verify....");
        String jsonStr = RegexSwitch.switchForTDP(getJsonData());
        System.out.println(jsonStr);

        JsonElement trip = (JsonElement) GsonUtil.getElement(jsonStr, "TripCalculationRS", "Trip");
        TripMo rs = gson.fromJson(trip, TripMo.class);

        System.out.println(gson.toJson(rs));

        TripCalculationRSHelper helper = new TripCalculationRSHelper();

        helper.getTripCalculationVo(rs);
        System.out.println("------------VO-------------");
        System.out.println(gson.toJson(rs));

        System.out.println("------------View-------------");
        TripCalculation tripCalculation = helper.geTripCalculationData(rs);
        System.out.println(gson.toJson(tripCalculation));


    }

    public String getJsonData() {
        String filename = "D://TripCalculationRS.txt";// TripCalculationRS
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

        GsonParseVerify test = new GsonParseVerify();
        test.testParese();

    }

}
