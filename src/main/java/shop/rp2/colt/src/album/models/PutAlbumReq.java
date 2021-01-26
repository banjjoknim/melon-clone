package shop.rp2.colt.src.album.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PutAlbumReq {

    private String albumImage;
    private String albumTitle;
    private Long genreId;
    private String albumIntro;
    private String soundQuality;
}
