package pl.wsb.fitnesstracker.achievement;

import jakarta.persistence.*;
import lombok.*;
import pl.wsb.fitnesstracker.user.api.User;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "achievement")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Achievement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "earned_at", nullable = false)
    private LocalDateTime earnedat;

    @Column(name = "achievement_name", nullable = false)
    private String achievementName;

    @Column(name = "achievement_description",nullable = false)
    private String achievementDescription;

    @Column(name = "rarity",nullable = false)
    private String rarity;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public Achievement(String name, LocalDateTime earnedat, User user, String achievementName, String achievementDescription, String rarity) {
        this.name = name;
        this.earnedat = earnedat;
        this.achievementName = name;
        this.achievementDescription = name;
        this.rarity = name;
        this.user = user;
    }
}