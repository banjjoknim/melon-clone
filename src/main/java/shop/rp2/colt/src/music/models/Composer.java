package shop.rp2.colt.src.music.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "COMPOSER")
public class Composer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "composer_id")
    private Long composerId;

    @Column(name = "composer_name")
    private String composerName;

    @Column(name = "music_id")
    private Long musicId;
}
