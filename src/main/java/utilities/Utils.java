package utilities;

import model.constant.ContentType;
import io.cucumber.datatable.DataTable;

import java.io.IOException;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Utils {

    public static long calculateDateDifference(String dateStr) {
        return ChronoUnit.DAYS.between(
                LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                LocalDate.now()
        );
    }

    public static Map<String, String[]> convertMapOfStringToMapOfList(Map<String, String> data) {
        Map<String, String[]> data2 = new HashMap<>();

        for (Map.Entry<String, String> entry : data.entrySet()) {
            data2.put(entry.getKey(), entry.getValue().split(", "));
        }
        return data2;
    }

    public static Map<String, List<String>> convertIntoParamsObject(String data) {
        List<String> paramsList = List.of(data.split("&"));
        Map<String, List<String>> data2 = new HashMap<>();
        for (String s : paramsList) {
            String[] param = s.split("=");
            data2.put(param[0].trim(), List.of(param[1].trim().split(",")));
        }
        return data2;
    }

    public static ContentType contentType(String contentId) {
        return (contentId.startsWith("tlxsta")) ? ContentType.valueOf("TILE")
                : (contentId.startsWith("tlxaut")) ? ContentType.valueOf("DYNAMIC_TILE")
                : (contentId.startsWith("axaut")) ? ContentType.valueOf("AUTOMATED")
                : (contentId.startsWith("axsta")) ? ContentType.valueOf("STATIC")
                : (contentId.startsWith("axhyb")) ? ContentType.valueOf("HYBRID")
                :ContentType.valueOf("OTHER") ;
    }

    public static Map<String, String> getParams(String url) throws Exception {

        URI uri = new URI(url);
        String query = uri.getQuery();  // everything after '?'

        Map<String, String> map = new HashMap<>();

        if (query == null || query.isEmpty()) {
            return map;
        }

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

    public static List<String> getUnsubscribedCP(String partnerStatus) {
        List<String> unSubscribedCP = new ArrayList<>();
        return unSubscribedCP;
    }
}
