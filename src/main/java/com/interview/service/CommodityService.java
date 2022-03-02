package com.interview.service;

import com.interview.dto.commodity.CommodityDTO;
import com.interview.dto.commodity.DiscountStrategyDTO;
import com.interview.customexception.CommodityNotFoundException;
import com.interview.diccount.DiscountACommodity;
import com.interview.diccount.GiftACommodity;
import com.interview.diccount.StrategyContext;
import com.interview.entity.Commodity;
import com.interview.entity.CommodityDiscountStrategy;
import com.interview.entity.StrategyTypes;
import com.interview.repository.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public  class CommodityService implements CommodityRepository {

    @Autowired
    private CommodityRepository commodityRepository;




    @Override
    public <S extends Commodity> S save(S s) {

        return commodityRepository.save(s);
    }

    @Override
    public <S extends Commodity> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    public Optional<Commodity> findById(Long aLong) {

        return commodityRepository.findById(aLong);
    }



    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Commodity> findAll() {
        return commodityRepository.findAll();
    }

    @Override
    public Commodity findByCommditiyTitle(String title) {
        Commodity commodity = commodityRepository.findByCommditiyTitle(title);
        if(Objects.isNull(commodity)) throw new CommodityNotFoundException(title,"Commodity Not Found");
        return commodity;
    }

    @Override
    public List<Commodity> findByCommditiyTitleContaining(String serachTerm) {
        return commodityRepository.findByCommditiyTitleContaining(serachTerm);
    }

    public CommodityDTO calcualtCommdityDsicounts(Commodity commodity) {
        List<DiscountStrategyDTO> strategydicuontMeets = new ArrayList<DiscountStrategyDTO>();

        Collection<CommodityDiscountStrategy> commodityDiscountStrategies = commodity.getCommodityDiscountStrategies();
        Iterator<CommodityDiscountStrategy> itr = commodityDiscountStrategies.iterator();
        while(itr.hasNext()) {
            CommodityDiscountStrategy strategy = itr.next();
            if(strategy.getDiscountStrategy().getStrategyType().equalsIgnoreCase(StrategyTypes.DISCOUNT.toString())){
                StrategyContext discountStrategy = new StrategyContext(new DiscountACommodity());
                DiscountStrategyDTO discountStrategyBean = discountStrategy.applyStrategy(commodity,strategy);
                strategydicuontMeets.add(discountStrategyBean);
            }
            if(strategy.getDiscountStrategy().getStrategyType().equalsIgnoreCase(StrategyTypes.GIFT.toString())) {
                StrategyContext giftStrategy = new StrategyContext(new GiftACommodity());
                DiscountStrategyDTO giftStrategyBean  = giftStrategy.applyStrategy(commodity,strategy);
                strategydicuontMeets.add(giftStrategyBean);
            }
        }

        CommodityDTO commodityBean = new CommodityDTO(commodity.getId(),commodity.getCommditiyTitle(),commodity.getPrice() , commodity.getPriceCurrency(),  strategydicuontMeets) ;

        return commodityBean ;
    }


    @Override
    public Iterable<Commodity> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {
        commodityRepository.deleteById(aLong);
    }

    @Override
    public void delete(Commodity commodity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Commodity> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
