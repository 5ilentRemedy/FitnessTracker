package pl.wsb.fitnesstracker.event;

import jakarta.persistence.*;
import lombok.*;
import pl.wsb.fitnesstracker.user.api.User;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "user_event")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserEvent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;


    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;


    public UserEvent(User user, Event event, LocalDate registrationDate) {
        this.user = user;
        this.event = event;
        this.registrationDate = registrationDate;
    }

    public UserEvent(User user, Event event) {
        this.user = user;
        this.event = event;
        this.registrationDate = LocalDate.now(); // domyślna data rejestracji
    }
}