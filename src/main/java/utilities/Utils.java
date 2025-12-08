package utilities;

import io.cucumber.datatable.DataTable;

import java.io.IOException;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    public static Map<String,String[]> convertMapOfStringToMapOfList(Map<String,String> data){
        Map<String, String[]> data2 = new HashMap<>();

        for (Map.Entry<String, String> entry : data.entrySet()) {
            data2.put(entry.getKey(),  entry.getValue().split(", ") );
        }
        return data2;
    }

    public static Map<String, String> getParams(String url) throws Exception {

        URI uri = new URI(url);
        String query = uri.getQuery();  // everything after '?'

        Map<String, String> map = new HashMap<>();

        if (query == null || query.isEmpty()) { return map; }

        String[] params = query.split("&");

        for (String param : params) {
            String[] pair = param.split("=", 2);

            String key = URLDecoder.decode(pair[0], StandardCharsets.UTF_8.name());
            String value = "";

            if (pair.length > 1) {
                value = URLDecoder.decode(pair[1], StandardCharsets.UTF_8.name());
            }
            map.put(key, value);
        }

        return map;
    }

    public static String jsonToBody(String jsonPath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(jsonPath)));
    }

    public static List<Map<String, String>> convertDataTableToMap(DataTable dataTable) throws IOException {
        return dataTable.asMaps(String.class, String.class);
    }
}
