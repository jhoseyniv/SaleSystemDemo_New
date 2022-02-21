package com.interview.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.ZonedDateTime;
import lombok.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor

public class DiscountStrategy implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "{strategy_type.notempty}")
    @Size(min = 5, message = "{strategy_type.length}")
    @Column(unique = true)
    private String strategyTitle;

    @NotEmpty(message = "{strategy_type.notempty}")
    @Size(min = 1, message = "{strategy_type.length}")
    @Column(unique = false)
    private String strategyType;

    @Column(unique = true)
    private Long strategyAchivement;

    @OneToMany(mappedBy = "discountStrategy",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<CommodityDiscountStrategy> commodity_discountStrategies;

    @DateTimeFormat(pattern = "dd-mmm-yyyy hh:mm:ss.s")
    private ZonedDateTime startDate;


    @DateTimeFormat(pattern = "dd-mmm-yyyy hh:mm:ss.s")
    private ZonedDateTime endDate;

    public DiscountStrategy(String strategyTitle, String strategyType, Long strategyAchivement,
                                Set<CommodityDiscountStrategy> commodity_discountStrategies,
                                        ZonedDateTime startDate, ZonedDateTime endDate) {
        this.strategyTitle = strategyTitle;
        this.strategyType = strategyType;
        this.strategyAchivement = strategyAchivement;
        this.commodity_discountStrategies = commodity_discountStrategies;
        this.endDate = endDate;
        this.startDate = startDate;
    }


}
