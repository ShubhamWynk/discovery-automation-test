package model.constant;

import lombok.Data;


import java.util.*;

@Data
public class Sku {

    private static final Map<String, String> packMap = new LinkedHashMap<>();

    static {

        // Prime Lite Mappings
        packMap.put("amazon_prime:claimed", "amazon_prime");
        packMap.put("amazon_prime:claim_in_progress", "amazon_prime");
        packMap.put("amazon_prime:pending_activation", "amazon_prime");

        packMap.put("jiohotstar:claimed", "hotstar_dth");
        packMap.put("jiohotstar:claim_in_progress", "hotstar_dth");
        packMap.put("jiohotstar:pending_activation", "hotstar_dth");

        // Zee Mappings
        packMap.put("zeefive:claimed", "zeefive");
        packMap.put("zeefive:claim_in_progress", "zeefive");
        packMap.put("zeefive:pending_activation", "zeefive");

        // Xstream Premium (Standard) Mappings
        packMap.put("xstreampremium:claimed", "standard");
        packMap.put("xstreampremium:claim_in_progress", "standard");
        packMap.put("xstreampremium:pending_activation", "standard");

        // Netflix Mappings
        packMap.put("netflix:claimed", "netflix");
        packMap.put("netflix:claim_in_progress", "netflix");
        packMap.put("netflix:pending_activation", "netflix");

        // Old - Xstream Premium (Standard) Mappings
        packMap.put("xstreampremium_paid", "standard");
        packMap.put("xstreampremium_telco_paid", "standard");
    }

    private static final List<String> STANDARD_CONTENT_PARTNERS =
            Arrays.asList(
                    "livetv",
                    "distrotv",
                    "sonyliv_vod",
                    "sunnxt",
                    "fancode",
                    "manoramamax",
                    "epicon",
                    "playflix",
                    "erosnow",
                    "shemaroome",
                    "hungama",
                    "minitv",
                    "lionsgateplay",
                    "hoichoi",
                    "chaupal",
                    "aha",
                    "klikk",
                    "rajtv",
                    "stage",
                    "docubay",
                    "altbalaji",
                    "ultra",
                    "dollywood",
                    "shortstv",
                    "nammaflix",
                    "kancchalanka",
                    "xstreamads",
                    "creator",
                    "mwtv",
                    "addatimes",
                    "vrott",
                    "chanajor"
            );


//    public static List<String> getCpFromPackId(List<String> packId) {
//        if (CollectionUtils.isEmpty(packId)) {
//            return Collections.emptyList();
//        }
//        List<String> packids =
//                packId.stream()
//                        .filter(StringUtils::hasLength)
//                        .flatMap(i -> Arrays.stream(i.split(",")))
//                        .map(String::trim)
//                        .map(String::toLowerCase)
//                        .toList();
//        HashSet<String> enabledCps = new HashSet<String>();
//        packids.forEach(
//                i -> {
//                    String product = packMap.get(i);
//                    if (StringUtils.hasLength(product)) {
//                        if ("standard".equalsIgnoreCase(product)) {
//                            enabledCps.addAll(STANDARD_CONTENT_PARTNERS);
//                        } else {
//                            enabledCps.add(product);
//                        }
//                    }
//                });
//        return new ArrayList<>(enabledCps);
//    }
}
