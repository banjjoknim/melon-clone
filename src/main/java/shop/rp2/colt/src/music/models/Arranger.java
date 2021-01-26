package shop.rp2.colt.src.music.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "ARRANGER")
public class Arranger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "arranger_id")
    private Long arrangerId;

    @Column(name = "arranger_name")
    private String arrangerName;

    @Column(name = "music_id")
    private Long musicId;
}
