package xo.andrey.autopark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import xo.andrey.autopark.model.Car;
import xo.andrey.autopark.service.AutoparkService;

import java.util.List;

@Controller
public class AutoparkController {

    private AutoparkService service;
    @Autowired
    public void setService(AutoparkService service){ this.service = service; }

    @GetMapping(value = "/")
    public ModelAndView allCars(){
        List<Car> cars = service.allCars();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("autopark");
        modelAndView.addObject("carsList", cars);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") int id){
        Car car = service.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("car", car);
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView editCar(@ModelAttribute("car") Car car){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        service.edit(car);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }
    @PostMapping("/add")
    public ModelAndView addCar(@ModelAttribute("car") Car car){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        service.add(car);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteCar(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Car car = service.getById(id);
        service.delete(car);
        return modelAndView;
    }


}
