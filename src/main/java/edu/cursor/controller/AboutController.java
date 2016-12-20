package edu.cursor.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AboutController {

   @RequestMapping(value = "/about", method = RequestMethod.GET)
   public String about(Model model){
      model.addAttribute("msg1", "Here's message ONE!");
      return "about";
   }

//   @RequestMapping(value = "/about", method = RequestMethod.GET)
//   public ModelAndView about(){
//      ModelAndView mav = new ModelAndView("about");
//      mav.addObject("msg1", "Here's message ONE!");
//      return mav;
//   }

}