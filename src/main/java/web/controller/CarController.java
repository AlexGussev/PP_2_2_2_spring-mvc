package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/askCar")
    public String printCar(@RequestParam(value = "count", required = false) String count, ModelMap modelMap) {
        if (count == null) {
            modelMap.addAttribute("cars", carService.getCar());
        } else {
        modelMap.addAttribute("cars", carService.getCarByNumber(Integer.parseInt(count)));
        }
        return "cars";
    }

}
