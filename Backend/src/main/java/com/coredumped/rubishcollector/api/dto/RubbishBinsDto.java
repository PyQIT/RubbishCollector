package com.coredumped.rubishcollector.api.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RubbishBinsDto {

    private Long id;
    private BigDecimal xCoord;
    private BigDecimal yCoord;
    private String street;
    private LocalDateTime lastModified;
    private Integer lastFill;
    private Integer fill;
}
