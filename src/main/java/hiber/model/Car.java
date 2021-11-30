package hiber.model;

import javax.persistence.*;

@Entity
@Table(name= "car")
public class Car {
    @Id
    @Column(name = "user_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name= "model")
    private String model;

    @Column(name= "series")
    private int series;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
