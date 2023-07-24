package com.FSBTech.application.dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;

@Data
public class GameDto {
    @NotNull
    private String name;
    private String dateofCreation;
    private boolean active;
}
