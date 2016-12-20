package edu.cursor.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OthersAngularController {

   /*
    *  Don't mind this ;)
    *  That's for Angular
    */
   @RequestMapping(value = {"main", "books", "collection"})
   public String redirectAllToIndex(){
      return "index";
   }

}