package com.interview.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.ZonedDateTime;

import java.util.List;

@Entity
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
    private List<CommodityDiscountStrategy> commodity_discountStrategies;

    @OneToMany(mappedBy = "discountStrategy",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CartDiscountStrategy> cartDiscountStrategies;

    public List<CartDiscountStrategy> getCartDiscountStrategies() {
        return cartDiscountStrategies;
    }

    @DateTimeFormat(pattern = "dd-mmm-yyyy hh:mm:ss.s")
    private ZonedDateTime startDate;


    @DateTimeFormat(pattern = "dd-mmm-yyyy hh:mm:ss.s")
    private ZonedDateTime endDate;

    public DiscountStrategy(String strategyTitle, String strategyType, Long strategyAchivement,
                                List<CommodityDiscountStrategy> commodity_discountStrategies,
                                        ZonedDateTime startDate, ZonedDateTime endDate) {
        this.strategyTitle = strategyTitle;
        this.strategyType = strategyType;
        this.strategyAchivement = strategyAchivement;
        this.commodity_discountStrategies = commodity_discountStrategies;
        this.endDate = endDate;
        this.startDate = startDate;
    }

    public DiscountStrategy() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStrategyTitle() {
        return strategyTitle;
    }

    public void setStrategyTitle(String strategyTitle) {
        this.strategyTitle = strategyTitle;
    }

    public String getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(String strategyType) {
        this.strategyType = strategyType;
    }

    public Long getStrategyAchivement() {
        return strategyAchivement;
    }

    public void setStrategyAchivement(Long strategyAchivement) {
        this.strategyAchivement = strategyAchivement;
    }

    public List<CommodityDiscountStrategy> getCommodity_discountStrategies() {
        return commodity_discountStrategies;
    }

    public void setCommodity_discountStrategies(List<CommodityDiscountStrategy> commodity_discountStrategies) {
        this.commodity_discountStrategies = commodity_discountStrategies;
    }

    public void setCartDiscountStrategies(List<CartDiscountStrategy> cartDiscountStrategies) {
        this.cartDiscountStrategies = cartDiscountStrategies;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(ZonedDateTime endDate) {
        this.endDate = endDate;
    }
}
