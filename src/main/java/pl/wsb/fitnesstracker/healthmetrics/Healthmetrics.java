package pl.wsb.fitnesstracker.healthmetrics;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.wsb.fitnesstracker.user.api.User;

@Entity
@Table(name = "Healthmetrics")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString


public class Healthmetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = true)
    private User user;

    @Column(name="user_id",nullable = false)
    private String userId;

    @Column(name="date",nullable = false)
    private String date;

    @Column(name="weight",nullable = false)
    private float weight;

    @Column(name="height",nullable = false)
    private float height;

    @Column(name="heartRate",nullable = false)
    private float heartRate;

    public Healthmetrics(
            User user,
            String userId,
            String date,
            float weight,
            float height,
            float heartRate)
    {
        this.user = user;
        this.userId = userId;
        this.date = date;
        this.weight = weight;
        this.height = height;
        this.heartRate = heartRate;
    }



}
