package model.Common;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import model.Common.arsenalCollection.ArsenalCollection;

import java.util.Map;

@Data
public class UserInfo {
    public static JsonNode userPersona, watchHistory, experiment, userLogs;
    public static ArsenalCollection userEncounter;
    public static Map<String,String> liveAttribute;
    public static Map<String, Map<String,Map<String,Integer>>> slotPersona;

}
