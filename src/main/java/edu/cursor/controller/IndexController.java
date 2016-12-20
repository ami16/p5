package edu.cursor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class IndexController {


   @RequestMapping(value={
       "",
       "/",
       "/sping-library",
       "index",
       "main"
   }, method = RequestMethod.GET)
   public String index(){
      return "index";
   }

}