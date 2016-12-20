package edu.cursor.controller;

import edu.cursor.dao.IBookRepo;
import edu.cursor.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


@Controller
@Service
public class BooksController {

   @Autowired
   private IBookRepo bookRepository;

   @CrossOrigin
   @RequestMapping(value="/getBooks", method = RequestMethod.GET)
   @ResponseBody
   @Secured("ROLE_ADMIN")
   public List<Book> getBooks(){
      return bookRepository.findAll();
   }

}