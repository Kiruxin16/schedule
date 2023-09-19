package threeoceans.fitness.ru.schedule.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "halls")
@Data
@NoArgsConstructor
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;


    @Column(name = "trigger")
    private String trigger;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "hall",cascade = CascadeType.PERSIST)
    List<ClubEvent> events;


}
