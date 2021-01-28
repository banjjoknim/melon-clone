package shop.rp2.colt.src.user.models.history;

import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.rp2.colt.config.BaseTimeEntity;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "MUSIC_HISTORY")
public class SongHistory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MUSIC_HISTORY_ID")
    private Long songHistoryId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "music_id")
    private Long musicId;
}
