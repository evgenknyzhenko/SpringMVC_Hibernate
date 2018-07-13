package app.controller;

import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView vm = new ModelAndView();
        vm.setViewName("login");
        vm.addObject("user", new User());
        return vm;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("user") User user) {
        ModelAndView vm = new ModelAndView();
        vm.addObject("user", userService.getByEmail(user));
        vm.setViewName("welcome");

        return vm;
    }

    //
    /*@RequestMapping(path = "/sigUp", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("user") User user) {
        ModelAndView vm = new ModelAndView();
        vm.addObject("user", userService.getByEmail(user));
        vm.setViewName("welcome");

        return vm;
    }*/
}
