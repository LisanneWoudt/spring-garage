package nl.appli.garage.model;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String brand;
    private String numberPlate;
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    private Owner owner;

    public Car(){};

    public Car(String brand, String numberPlate, String status, Owner owner) {
        this.brand = brand;
        this.numberPlate = numberPlate;
        this.status = status;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", numberPlate='" + numberPlate + '\'' +
                ", status='" + status + '\'' +
                ", owner=" + owner +
                '}';
    }
}
