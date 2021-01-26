package shop.rp2.colt.src.singer.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.rp2.colt.config.BaseTimeEntity;
import shop.rp2.colt.config.FlagYN;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "SINGER")
public class Singer extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "singer_id")
    private Long singerId;

    @Column(name = "singer_name")
    private String singerName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "country")
    private String country;

    @Column(name = "debut_date")
    private LocalDate debutDate;

    @Column(name = "singer_image")
    private String singerImage;

    @Column(name = "is_deleted")
    @Enumerated(EnumType.STRING)
    private FlagYN isDeleted;
}
