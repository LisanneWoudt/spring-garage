package nl.appli.garage.controllers;

import nl.appli.garage.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import nl.appli.garage.services.CarService;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex() {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/car/{id}", method = RequestMethod.GET)
    public Car getCar(@PathVariable Integer id, Model model) {
        Car car = carService.getCar(id);
        model.addAttribute("car", car);
        return car;
    }

    @ResponseBody
    @RequestMapping(value = "/new_car", method = RequestMethod.POST)
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @ResponseBody
    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public List<Car> getAllCars() {
        List<Car> cars = carService.getAllCars();
        return cars;
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable Integer id) {
        carService.deleteCar(id);
    }

    @ResponseBody
    @RequestMapping(value = "/filter/{filter}", method = RequestMethod.GET)
    public List<Car> getFilteredCars(@PathVariable String filter) {
        return carService.getFilteredCars(filter);
    }

    @ResponseBody
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Car updateStatus(@PathVariable Integer id, @RequestBody String status) {
        return carService.updateStatus(id, status);
    }
}





