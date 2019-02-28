package autonomoNetwork.myApp.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Solicitud {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    @NotNull
    private Service service;
    @Column(nullable = false)
    @NotNull
    private User user;
    @Column(nullable = false)
    @NotNull
    private String serviceRequested;
    @Column(nullable = false)
    @NotNull
    private String serviceDate;
    @Column(nullable = false)
    @NotNull
    private String requestDate;
    @Column(nullable = false)
    @NotNull
    private String adress;
    @Column(nullable = false)
    @NotNull
    private double benefit;
    @Column(nullable = false)
    @NotNull
    private String state;
    @Column(nullable = false)
    @NotNull
    private String description;
}
