package com.FSBTech.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;

import java.io.Serializable;

@Entity(name ="Game")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game implements Serializable {
    private static final long serialVersionUID = 7156526077883281623L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gameId;
    @Column(length=128, unique=true)
    @NotNull
    private String name;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private String dateOfCreation;
    private boolean active;
}
