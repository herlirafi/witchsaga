package com.geekseat.witch.saga.controller;

import com.geekseat.witch.saga.util.VillagerHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.DecimalFormat;

/**
 * The Class HomePageController
 *
 * @author rafi.saeful.rahman
 */
@Controller
public class HomePageController {

    @Resource(name = "villagerHelper")
    private VillagerHelper villagerHelper;

    private double saveValue;
    public double getSaveValue() {
        return saveValue;
    }
    public void setSaveValue(double saveValue) {
        this.saveValue = saveValue;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        double average = getSaveValue();
        DecimalFormat df = new DecimalFormat("###.#");
        model.addAttribute("average", df.format(average));
        return "html/witchVillagers";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void getAjaxValue(
            @RequestParam("personA1") final int personA1,
            @RequestParam("personA2") final int personA2,
            @RequestParam("personB1") final int personB1,
            @RequestParam("personB2") final int personB2
    ) {
        setSaveValue(villagerHelper.averageKilledPeople(personA1, personA2, personB1, personB2));
    }
}
