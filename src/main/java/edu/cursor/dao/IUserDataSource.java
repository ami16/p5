package edu.cursor.dao;

import edu.cursor.model.User;
import java.util.Collection;
import java.util.Map;

/**
 *
 */
public interface IUserDataSource {

   Collection<User> loadUsers();
   User findByLogin( String login );
   Map<String, User> getUsersMap() ;

}