package postageapp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import junit.framework.TestCase;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: stephanleroux
 * Date: 2012-11-28
 * Time: 7:57 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class ModelTestCase extends TestCase {
    protected String loadModelFixture(String fixturePath) {
        InputStream jsonStream = getClass().getClassLoader().getResourceAsStream(fixturePath);
        assertNotNull(jsonStream);

        String jsonString = null;
        try {
            jsonString = IOUtils.toString(jsonStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    protected Map<String, ?> getDataFromResponse(String jsonString) {
        Gson gson = new Gson();

        Type mapType = new TypeToken<Map<String, ?>>() {
        }.getType();
        Map<String, ?> responseMap = gson.fromJson(jsonString, mapType);

        return (Map<String, ?>) responseMap.get("data");
    }

}
