package com.coredumped.rubishcollector.api.dto;

import com.coredumped.rubishcollector.api.model.enums.RubbishBinFraction;
import com.coredumped.rubishcollector.api.model.enums.RubbishBinType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RubbishBinsDto {

    private Long id;
    private BigDecimal xCoord;
    private BigDecimal yCoord;
    private String street;
    private String city;
    private RubbishBinType type;
    private RubbishBinFraction fraction;
    private LocalDateTime lastModified;
    private Integer lastFill;
    private Integer fill;
}
