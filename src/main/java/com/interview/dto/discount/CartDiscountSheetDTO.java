package com.interview.dto.discount;


import java.time.ZonedDateTime;
import java.util.List;

public class CartDiscountSheetDTO {
    private String title;
    private String description;
    private ZonedDateTime createdDate;
    private List<CartCommodityDiscountItemDTO>  cartCommodityDiscountItems;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public List<CartCommodityDiscountItemDTO> getCartCommodityDiscountItems() {
        return cartCommodityDiscountItems;
    }

    public void setCartCommodityDiscountItems(List<CartCommodityDiscountItemDTO> cartCommodityDiscountItems) {
        this.cartCommodityDiscountItems = cartCommodityDiscountItems;
    }

    public CartDiscountSheetDTO() {
    }

    public CartDiscountSheetDTO(String title, String description, ZonedDateTime createdDate, List<CartCommodityDiscountItemDTO> cartCommodityDiscountItems) {
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.cartCommodityDiscountItems = cartCommodityDiscountItems;
    }
}
