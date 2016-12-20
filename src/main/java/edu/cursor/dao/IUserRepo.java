package edu.cursor.dao;

import edu.cursor.model.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;


public interface IUserRepo extends CrudRepository<User, Long>, JpaSpecificationExecutor<User>{

   User findByEmail( String email );
   User findByLogin( String login );


}