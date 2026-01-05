package filters;

import model.response.userPersona.UserPersonaDTO;

import java.util.*;

public class postProcessorFilter {

    public static Set<String> getUserLanguage(String type, UserPersonaDTO userPersona, Map<String, String> liveAttribute) {
        Set<String> userLangList = new HashSet<>();

        List<String> userSelectedLang = liveAttribute.containsKey("languages")
                ? List.of(liveAttribute.get("languages").split(","))
                : List.of(userPersona.getXstreamOnboardingUsl());
        List<String> dominantLang = type.startsWith("c")
                ? List.of(userPersona.getClickPersonaDominantLang().split(","))
                : List.of(userPersona.getXstreamDominantLanguageDaily().split(","));
        List<String> significantLang = type.startsWith("c")
                ? List.of(userPersona.getClickPersonaSignificantLang().split(","))
                : userPersona.getXstreamSignificantLanguageDaily();

        switch (type) {
            case "usl" -> userLangList.addAll(userSelectedLang);
            case "ucl","cucl" -> {
                userLangList.addAll(dominantLang);
                userLangList.addAll(significantLang);
            }
            case "ul","cul" -> {
                userLangList.addAll(dominantLang);
                userLangList.addAll(significantLang);
                userLangList.addAll(userSelectedLang);
            }
            case "usil", "cusil" -> userLangList.addAll(significantLang);
            case "udl", "cudl" -> userLangList.addAll(dominantLang);
            default -> Collections.emptyList();
        };

        return userLangList;

    }
}
