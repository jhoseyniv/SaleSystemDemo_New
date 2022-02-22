package com.interview.api;

import com.interview.entity.Commodity;
import com.interview.beans.CommodityBean;
import com.interview.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/commodity")
public class CommodityConroller {

    @Autowired
    private CommodityService commodityService;


    @GetMapping("/list")
    public List<Commodity> getCommodities(Model model) {
        List<Commodity> commodities = commodityService.findAll();
        return commodities;
    }

    @RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Commodity> getCommodityById(@PathVariable Long id) {
        Optional<Commodity> commodity = commodityService.findById(id);

        return commodity;
    }

    @GetMapping( "/find/title/{title}")
    public CommodityBean getCommodityByTitle(@PathVariable String title) {
        Commodity commodity = commodityService.findByCommditiyTitle(title);
        CommodityBean commodityBean= commodityService.calcualtCommdityDsicounts(commodity);
        return commodityBean;
    }

    @GetMapping( "/find/intext/{intext}")
    public List<Commodity> getCommodityContainByTitle(@PathVariable String intext) {
        List<Commodity> commodities = commodityService.findByCommditiyTitleContaining(intext);
        return commodities;
    }



}