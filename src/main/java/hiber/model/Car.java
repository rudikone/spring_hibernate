package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @OneToOne(mappedBy = "userCar", cascade = CascadeType.ALL)
    private User user;

    @Id
    private String model;

    @Column(name = "series")
    private int series;

    public Car() {

    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "\nCar{" +
                "user=" + user +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
