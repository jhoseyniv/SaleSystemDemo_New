package com.interview;

import com.interview.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.interview.entity.*;
import com.interview.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@SpringBootApplication
public class SaleSystemDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaleSystemDemoApplication.class, args);
	}
	@Autowired
	private DiscountStrategyService discountStrategyService;

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private PriceService priceService;

	@Autowired
	private CartStatusService cartStatusService;
	@Autowired
	private CartService cartService;

	@Autowired
	private CommodityDiscountStrategyService commodityDiscountStrategyService;

	@Autowired
	private CartCommodityService cartCommodityService;

	@Autowired
	private CustomerRepository customerRepository;



	@Autowired
	private Environment environment;

	private static final Logger log = LoggerFactory.getLogger(SaleSystemDemoApplication.class);

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			;
			log.info("Start Application...Tassk Management");
			System.out.println("Let's inspect the beans provided by Spring Boot:");

			ZoneId zoneId = ZoneId.of("Europe/London").getRules().getOffset(Instant.now());
			ZonedDateTime startDate = ZonedDateTime.now();
			ZonedDateTime endDate = ZonedDateTime.of(2022, 3, 30, 23, 45, 59, 1234, zoneId);

			ZonedDateTime  createdDate= ZonedDateTime.now();

			CartStatus cartStatusDraft = new CartStatus("Draft");
			CartStatus cartStatusFinal = new CartStatus("Final");
			cartStatusService.save(cartStatusDraft);
			cartStatusService.save(cartStatusFinal);


			Customer ali = new Customer("ali","saeedi","ali_2000","12345",null);
			Customer reza = new Customer("reza","saeedi","reze_2020","12345",null);
			customerRepository.save(ali);
			customerRepository.save(reza);


			Commodity hat = new Commodity("hat",10d,"krona",null,null,null);
			Commodity shirt = new Commodity("shirt",20d,"krona",null,null,null);
			Commodity pants = new Commodity("pants",30d,"krona",null,null,null);
			Commodity shoe = new Commodity("shoe",50d,"krona",null,null,null);
			Commodity mobile = new Commodity("mobile",500d,"krona",null,null,null);
			Commodity tablet = new Commodity("tablet",600d,"krona",null,null,null);
			Commodity tv = new Commodity("television",600d,"krona",null,null,null);

			commodityService.save(hat);
			commodityService.save(shirt);
			commodityService.save(pants);
			commodityService.save(shoe);
			commodityService.save(mobile);
			commodityService.save(tablet);
			commodityService.save(tv);


			Cart shopingCartAli= new Cart(ali,"cart100","ALi Ordered 2 hats",createdDate,null, cartStatusDraft,null);
			cartService.save(shopingCartAli);

			CartCommodity hatItem= new CartCommodity(hat,shopingCartAli,1L);
			cartCommodityService.save(hatItem);

			CartCommodity shoeItem= new CartCommodity(shoe,shopingCartAli,2L);
			cartCommodityService.save(shoeItem);


			Cart orderReza= new Cart(reza,"cart200","Reza Ordered a Shirt and 2 pants",createdDate,null, cartStatusDraft,null);
			cartService.save(orderReza);

			CartCommodity shirtItem= new CartCommodity(shirt,orderReza,1L);
			cartCommodityService.save(shirtItem);

			CartCommodity pantsItem= new CartCommodity(pants,orderReza,2L);
			cartCommodityService.save(pantsItem);

			CartCommodity shoeItem2= new CartCommodity(shoe,orderReza,6L);
			cartCommodityService.save(shoeItem2);

			CartCommodity hatItem2= new CartCommodity(hat,orderReza,10L);
			cartCommodityService.save(hatItem2);

//			CartCommodity mobileItem= new CartCommodity(hat,orderReza,10L);
//			cartCommodityService.save(mobileItem);

			DiscountStrategy giftAHatStrategy = new DiscountStrategy("Gift a Hat to client if buy 1 shirt and 2 pants",StrategyTypes.GIFT.toString(),1L,null,startDate,endDate);
			DiscountStrategy giftAHatStrategyIfFiveHat = new DiscountStrategy("Gift 2 Hats to client if buy a 5 hat ",StrategyTypes.GIFT.toString(),2L,null,startDate,endDate);
			DiscountStrategy discountOnAHatStrategy = new DiscountStrategy("DisCount 20% in a Hat at this time",StrategyTypes.DISCOUNT.toString(),20L,null,startDate,endDate);
			discountStrategyService.save(giftAHatStrategy);
			discountStrategyService.save(discountOnAHatStrategy);
			discountStrategyService.save(giftAHatStrategyIfFiveHat);

			CommodityDiscountStrategy hatDiscountByHatStrategy= new CommodityDiscountStrategy(hat,discountOnAHatStrategy,1L);
			CommodityDiscountStrategy hatGfitByHatStrategy= new CommodityDiscountStrategy(hat,giftAHatStrategyIfFiveHat,5L);

			commodityDiscountStrategyService.save(hatDiscountByHatStrategy);
			commodityDiscountStrategyService.save(hatGfitByHatStrategy);

			CommodityDiscountStrategy shirtDiscountByGiftHatStrategy= new CommodityDiscountStrategy(shirt,giftAHatStrategy,1L);
			CommodityDiscountStrategy pantsDiscountByGiftHatStrategy= new CommodityDiscountStrategy(pants,giftAHatStrategy,2L);
			commodityDiscountStrategyService.save(shirtDiscountByGiftHatStrategy);
			commodityDiscountStrategyService.save(pantsDiscountByGiftHatStrategy);


		};


	}
}
