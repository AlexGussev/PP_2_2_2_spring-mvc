package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String printCar(HttpServletRequest httpServletRequest, ModelMap modelMap) {
        if (httpServletRequest.getParameter("count") == null) {
            modelMap.addAttribute("cars", carService.getCar());
        } else {
        int count = Integer.parseInt(httpServletRequest.getParameter("count"));
        modelMap.addAttribute("cars", carService.getCarByNumber(count));
        }
        return "cars";
    }

}
