package app.controller;

import app.ajax.AjaxResponceBody;
import app.ajax.EmailPayLoad;
import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(path = "/signup", method = RequestMethod.GET)
    public ModelAndView signupGet() {
        ModelAndView vm = new ModelAndView();
        vm.addObject("user", new User());
        vm.setViewName("signup");
        return vm;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView signupPost(@ModelAttribute User user) {
        ModelAndView vm = new ModelAndView();
        vm.addObject("user", userService.addUser(user));
        System.out.println(user.getFirstName());
        vm.setViewName("welcome");
        return vm;
    }

    @RequestMapping(value = "activation/{token}", method = RequestMethod.GET)
    public ModelAndView activation(@PathVariable String token) {
        ModelAndView vm = new ModelAndView();
        return vm;
    }

    @ResponseBody
    @RequestMapping(value = "/email", method = RequestMethod.GET)
    public AjaxResponceBody emailCheck(@RequestBody EmailPayLoad email){
        AjaxResponceBody resp = new AjaxResponceBody();
        User user = new User();
        user.setEmail(email.getEmail());

        if(userService.getByEmail(user) !=null){
            resp.setMsg("NOK");
            resp.setResult("false");
        } else {
            resp.setMsg("OK");
            resp.setResult("true");
        }
        return resp;
    }
}
