package com.fs.cardapio.entity;

import com.fs.cardapio.entity.dto.FoodRequestDTO;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "food")
@Entity(name = "food")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String image;
    
    private Integer price;

    public Food(FoodRequestDTO data){
        this.title = data.title();
        this.image = data.image();
        this.price = data.price();
    }

}
