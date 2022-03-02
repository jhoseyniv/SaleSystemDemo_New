package com.interview.api;

import com.interview.entity.Commodity;
import com.interview.dto.commodity.CommodityDTO;
import com.interview.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/commodities")
public class CommodityConroller {

    @Autowired
    private CommodityService commodityService;


    @GetMapping("/")
    public List<Commodity> getCommodities(Model model) {
        List<Commodity> commodities = commodityService.findAll();
        return commodities;
    }

    @RequestMapping(value = "/ids/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Commodity> getCommodityById(@PathVariable Long id) {
        Optional<Commodity> commodity = commodityService.findById(id);

        return commodity;
    }

    @GetMapping( "/titles/{title}")
    public CommodityDTO getCommodityByTitle(@PathVariable String title) {
        Commodity commodity = commodityService.findByCommditiyTitle(title);
        CommodityDTO commodityBean= commodityService.calcualtCommdityDsicounts(commodity);
        return commodityBean;
    }




}