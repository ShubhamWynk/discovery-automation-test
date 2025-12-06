package model.Common;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import model.response.arsenalCollection.ArsenalCollectionRes;

import java.util.Map;

@Data
public class UserInfo {
    public static JsonNode userPersona, watchHistory, experiment, userLogs;
    public static ArsenalCollectionRes userEncounter;
    public static Map<String,String> liveAttribute;

}
