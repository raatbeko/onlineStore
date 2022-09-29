package online.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import online.dto.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_id")
    private Long basketId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProductCard> productCards;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    private String fullName;

    private String number;

    private String address;

    private String comment;

    public void clear() {
        productCards.removeIf(books -> true);
    }
}