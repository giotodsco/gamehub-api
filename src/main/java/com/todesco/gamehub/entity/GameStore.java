package com.todesco.gamehub.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gamestore")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GameStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;
}
