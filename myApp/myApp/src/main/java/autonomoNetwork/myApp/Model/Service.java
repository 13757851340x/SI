package autonomoNetwork.myApp.Model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Service {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    @NotNull
    private String name;
    @Column(nullable = false)
    @NotNull
    private String description;
    @Column(nullable = false)
    @NotNull
    private String category;
    @Column(nullable = false)
    @NotNull
    private int estimateTime;
    @Column(nullable = false)
    @NotNull
    private double cost;
    @Column(nullable = false)
    @NotNull
    private User user;
}
