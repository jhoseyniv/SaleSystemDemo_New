package com.interview;

import com.interview.service.CommodityService;
import com.interview.service.PriceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.interview.entity.*;
import com.interview.repository.*;
import com.interview.service.ShopingCartCommodityService;
import com.interview.service.ShopingCartService;
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
	private DiscountStrategyRepository discountStrategyRepository;

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private PriceService priceService;

	@Autowired
	private ShopingCartService shopingCartService;

	@Autowired
	private CommodityDiscountStrategyRepository commodityDiscountStrategyRepository;

	@Autowired
	private ShopingCartCommodityService shopingCartCommodityService;

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







			Customer ali = new Customer("ali","saeedi","ali_2000","12345",null);
			Customer reza = new Customer("reza","saeedi","reze_2020","12345",null);
			customerRepository.save(ali);
			customerRepository.save(reza);


			Commodity hat = new Commodity("hat",10d,"krona",null,null,null);
			Commodity shirt = new Commodity("shirt",20d,"krona",null,null,null);
			Commodity pants = new Commodity("pants",30d,"krona",null,null,null);
			Commodity shoe = new Commodity("shoe",50d,"krona",null,null,null);

			commodityService.save(hat);
			commodityService.save(shirt);
			commodityService.save(pants);
			commodityService.save(shoe);

			Price priceHat1= new Price(8d,1,"cron",false,hat);
			Price priceHat2= new Price(10d,1,"cron",false,hat);

			Price priceShirt= new Price(15d,1,"cron",false,shirt);
			Price pricePants= new Price(30d,1,"cron",false,pants);
			Price priceShoe= new Price(30d,1,"cron",false,shoe);

			priceService.save(priceHat1);
			priceService.save(priceHat2);
			priceService.save(priceShirt);
			priceService.save(pricePants);
			priceService.save(priceShoe);

			ShopingCart shopingCartAli= new ShopingCart(ali,"ALi Ordered 2 hats",createdDate,null);
			shopingCartService.save(shopingCartAli);

			ShopingCartCommodity hat_Item= new ShopingCartCommodity(hat,shopingCartAli,2L);
			shopingCartCommodityService.save(hat_Item);

			ShopingCartCommodity shoe_Item= new ShopingCartCommodity(shoe,shopingCartAli,1L);
			shopingCartCommodityService.save(shoe_Item);


			ShopingCart orderReza= new ShopingCart(reza,"Reza Ordered a Shirt and 2 pants",createdDate,null);
			shopingCartService.save(orderReza);

			ShopingCartCommodity shirt_order= new ShopingCartCommodity(shirt,orderReza,1L);
			shopingCartCommodityService.save(shirt_order);

			ShopingCartCommodity pants_order= new ShopingCartCommodity(pants,orderReza,2L);
			shopingCartCommodityService.save(pants_order);

			DiscountStrategy giftAHatStrategy = new DiscountStrategy("Gift a Hat to client if buy a shirt and a pants","GIFT",1L,null,startDate,endDate);
			DiscountStrategy giftAHatStrategyIfFiveHat = new DiscountStrategy("Gift 2 Hats to client if buy a 5 hat ","GIFT",2L,null,startDate,endDate);
			DiscountStrategy discountOnAHatStrategy = new DiscountStrategy("DisCount 20% in a Hat at this time","DISCOUNT",20L,null,startDate,endDate);
			discountStrategyRepository.save(giftAHatStrategy);
			discountStrategyRepository.save(discountOnAHatStrategy);
			discountStrategyRepository.save(giftAHatStrategyIfFiveHat);

			CommodityDiscountStrategy hatDiscountByHatStrategy= new CommodityDiscountStrategy(hat,discountOnAHatStrategy,1L);
			CommodityDiscountStrategy hatGfitByHatStrategy= new CommodityDiscountStrategy(hat,giftAHatStrategyIfFiveHat,5L);

			commodityDiscountStrategyRepository.save(hatDiscountByHatStrategy);
			commodityDiscountStrategyRepository.save(hatGfitByHatStrategy);

			CommodityDiscountStrategy shirtDiscountByGiftHatStrategy= new CommodityDiscountStrategy(shirt,giftAHatStrategy,2L);
			CommodityDiscountStrategy pantsDiscountByGiftHatStrategy= new CommodityDiscountStrategy(pants,giftAHatStrategy,1L);
			commodityDiscountStrategyRepository.save(shirtDiscountByGiftHatStrategy);
			commodityDiscountStrategyRepository.save(pantsDiscountByGiftHatStrategy);


		};
	}
		}
