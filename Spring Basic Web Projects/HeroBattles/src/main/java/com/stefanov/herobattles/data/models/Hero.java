package com.stefanov.herobattles.data.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "heroes")
public class Hero extends BaseEntity {
    @Column
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column
    private int level;
    @Column
    private int stamina;
    @Column
    private int strength;
    @Column
    private int attack;
    @Column
    private int defence;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "hero_items",
            joinColumns =
    @JoinColumn(name = "hero_id",referencedColumnName = "id"), inverseJoinColumns =
    @JoinColumn(name = "item_id", referencedColumnName = "id"))
    private List<Item> items;
    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
}
