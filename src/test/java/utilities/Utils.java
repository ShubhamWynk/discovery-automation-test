package utilities;

import io.cucumber.datatable.DataTable;

import java.io.IOException;
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

    public static String jsonToBody(String jsonPath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(jsonPath)));
    }

    public static List<Map<String, String>> convertDataTableToMap(DataTable dataTable) throws IOException {
        return dataTable.asMaps(String.class, String.class);
    }
}
