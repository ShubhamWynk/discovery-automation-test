
package model.request.zion.postTileIntoCollection;

import java.util.List;


import lombok.Data;

@Data
public class PostTileIntoCollectionReq {
    private Artworks artworks;
    private int minContentCount;
    private Object mixerMetaList;
    private Long refreshFrequencyDay;
    private Long refreshFrequencyDayOfWeek;
    private String sortStrategy;
    private Long availableFrom;
    private Long availableTill;
    private Long duration;
    private String category;
    private String description;
    private String subtitle;
    private List<Content> contents;
    private List<String> languages;
    private String realm;
    private List<String> regions;
    private List<String> tags;
    private String title;
    private String type;
    private String userId;
    private Zbrew zbrew;
}
