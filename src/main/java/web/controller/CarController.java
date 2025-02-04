package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String countOfCars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        if (count >= carService.listCar().size()) {
            model.addAttribute("cars", carService.listCar());
        } else {
            model.addAttribute("cars", carService.listCar(count));
        }
        return "cars";
    }
}
