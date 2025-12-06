
package model.response.pothunter.candidate;

import lombok.Data;

import java.util.List;


@Data
public class SourceContent {
    private List<SUGGESTDOWNLOADSSIMILARSONG> DOWNLOAD_SONGS;
    private List<SUGGESTDOWNLOADSSIMILARSONG> MOST_PLAYED_SONG;
}
