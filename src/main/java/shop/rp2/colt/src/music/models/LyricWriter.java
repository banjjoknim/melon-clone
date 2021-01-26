package shop.rp2.colt.src.music.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "LYRIC_WRITER")
public class LyricWriter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lyric_writer_id")
    private Long lyricWriterId;

    @Column(name = "lyric_writer_name")
    private String lyricWriterName;

    @Column(name = "music_id")
    private Long musicId;

}
