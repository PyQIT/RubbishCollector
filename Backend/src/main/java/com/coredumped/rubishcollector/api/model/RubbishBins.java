package com.coredumped.rubishcollector.api.model;

import com.coredumped.rubishcollector.api.model.enums.RubbishBinFraction;
import com.coredumped.rubishcollector.api.model.enums.RubbishBinState;
import com.coredumped.rubishcollector.api.model.enums.RubbishBinType;
import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rubbishBins")
@EqualsAndHashCode(callSuper = false)
public class RubbishBins {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "xcoord", nullable = false, precision = 15, scale = 6)
    @NotNull(message = "X Coordinates cannot be empty.")
    private BigDecimal xCoord;

    @Column(name = "ycoord", nullable = false, precision = 15, scale = 6)
    @NotNull(message = "Y Coordinates cannot be empty.")
    private BigDecimal yCoord;

    @Column(name = "street", nullable = false)
    @NotNull(message = "Street cannot be empty.")
    private String street;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    @Enumerated(EnumType.STRING)
    private RubbishBinState country;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private RubbishBinType type;

    @Column(name = "fraction", nullable = false)
    @Enumerated(EnumType.STRING)
    private RubbishBinFraction fraction;

    @Audited
    @LastModifiedDate
    @Column(name = "lastmodified")
    private LocalDateTime lastModified;

    @Column(name = "lastfill", nullable = false)
    @NotNull(message = "Fill cannot be empty.")
    private Integer lastFill;

    @Column(name = "fill", nullable = false)
    @NotNull(message = "Fill cannot be empty.")
    private Integer fill;
}
