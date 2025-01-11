package gr.hua.dit.ds.assignement.rent_express.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Realty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    private String address;

    @Enumerated(EnumType.STRING)
    private TypeOfRealty typeOfRealty;

    @Column
    private int storey;

    @Column
    private double m2;

    @Column
    private int noOfBedrooms;

    @Column
    private boolean hasKitchen;

    @Column
    private boolean hasBathroom;

    @Column
    private boolean hasBalconies;

    @Column
    private boolean isFurnished;

    @Column
    private double rentPrice;

    @Column
    private boolean availability;

    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="owner_id")
    private Owner owner;

    @OneToMany(mappedBy = "realty",cascade = CascadeType.ALL)
    private List<Request> rentRequests;

    public Realty (){}

    public Realty(String address, boolean availability, boolean hasBalconies, boolean hasBathroom, boolean hasKitchen, boolean isFurnished, double m2, int noOfBedrooms, double rentPrice, int storey, TypeOfRealty typeOfRealty) {
        this.address = address;
        this.availability = availability;
        this.hasBalconies = hasBalconies;
        this.hasBathroom = hasBathroom;
        this.hasKitchen = hasKitchen;
        this.isFurnished = isFurnished;
        this.m2 = m2;
        this.noOfBedrooms = noOfBedrooms;
        this.rentPrice = rentPrice;
        this.storey = storey;
        this.typeOfRealty = typeOfRealty;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean isHasBalconies() {
        return hasBalconies;
    }

    public void setHasBalconies(boolean hasBalconies) {
        this.hasBalconies = hasBalconies;
    }

    public boolean isHasBathroom() {
        return hasBathroom;
    }

    public void setHasBathroom(boolean hasBathroom) {
        this.hasBathroom = hasBathroom;
    }

    public boolean isHasKitchen() {
        return hasKitchen;
    }

    public void setHasKitchen(boolean hasKitchen) {
        this.hasKitchen = hasKitchen;
    }

    public boolean isFurnished() {
        return isFurnished;
    }

    public void setFurnished(boolean furnished) {
        isFurnished = furnished;
    }

    public double getM2() {
        return m2;
    }

    public void setM2(double m2) {
        this.m2 = m2;
    }

    public int getNoOfBedrooms() {
        return noOfBedrooms;
    }

    public void setNoOfBedrooms(int noOfBedrooms) {
        this.noOfBedrooms = noOfBedrooms;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
    }

    public TypeOfRealty getTypeOfRealty() {
        return typeOfRealty;
    }

    public void setTypeOfRealty(TypeOfRealty typeOfRealty) {
        this.typeOfRealty = typeOfRealty;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Request> getRentRequests() {
        return rentRequests;
    }

    public void setRentRequests(List<Request> rentRequests) {
        this.rentRequests = rentRequests;
    }

    @Override
    public String toString() {
        return "Realty{" +
                "address='" + address + '\'' +
                ", id=" + id +
                ", typeOfRealty=" + typeOfRealty +
                ", storey=" + storey +
                ", m2=" + m2 +
                ", noOfBedrooms=" + noOfBedrooms +
                ", hasKitchen=" + hasKitchen +
                ", hasBathroom=" + hasBathroom +
                ", hasBalconies=" + hasBalconies +
                ", isFurnished=" + isFurnished +
                ", rentPrice=" + rentPrice +
                ", availability=" + availability +
                ", owner=" + owner +
                ", rentRequests=" + rentRequests +
                '}';
    }
}
