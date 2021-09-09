package com.geekseat.witch.saga.controller;

import com.geekseat.witch.saga.util.VillagerHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomePageController {

    private final List<String> result = new ArrayList<>();

    @Resource(name = "villagerHelper")
    private VillagerHelper villagerHelper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String averageResultPost(Model model) {
        result.add("0");
        model.addAttribute("average", result.get(0));
        return "witchVillagers";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String averageResultGet(int personA1, int personA2, int personB1, int personB2) {
        double average = villagerHelper.averageKilledPeople(
                personA1, personA2, personB1, personB2);
        DecimalFormat df = new DecimalFormat("###.#");
        result.set(0, df.format(average));
        return "redirect:/";
    }
}
