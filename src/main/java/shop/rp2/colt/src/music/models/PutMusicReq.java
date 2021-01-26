package shop.rp2.colt.src.music.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PutMusicReq {

    private String musicTitle;
    private String lyrics;
    private String playtime;
}
