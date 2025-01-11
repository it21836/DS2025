package gr.hua.dit.ds.assignement.rent_express.entities;


import jakarta.persistence.*;

@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column
    private String date ;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="renter_id")
    private Renter renter;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="realty_id")
    private Realty realty;

    @Column
    private String messageToOwner;

    @Column
    @Enumerated(EnumType.STRING)
    private RequestState state;

    public Request() {
    }

    public Request(String date, Realty realty, Renter renter, String messageToOwner) {
        this.date = date;
        this.realty = realty;
        this.renter = renter;
        this.messageToOwner = messageToOwner;
    }

    public String getMessageToOwner() {
        return messageToOwner;
    }

    public void setMessageToOwner(String messageToOwner) {
        this.messageToOwner = messageToOwner;
    }

    public Realty getRealty() {
        return realty;
    }

    public void setRealty(Realty realty) {
        this.realty = realty;
    }

    public Renter getRenter() {
        return renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
    }

    public RequestState getState() {
        return state;
    }

    public void setState(RequestState state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }
}
