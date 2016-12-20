package edu.cursor.model;

import com.google.gson.Gson;
import edu.cursor.constants.Defined;
import edu.cursor.dao.Identifiable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = Defined.Tables.USERS)
public class User extends Identifiable {

   public static final Gson GSON = new Gson();

//   @Column(name = "login", unique = true)
//   private String login;

   @Column(name = "password")
   private String password;

   @Column(name = "email", unique = true)
   private String email;

   private String role;

   /* specific column definition for authentication bug Between Hibernate and Spring security*/
   @Column(columnDefinition="BIT(1) default 0")
   private int enabled;


   // API

   @Override
   public String toString() {
      return GSON.toJson(this);
   }

   public static Gson getGSON() {
      return GSON;
   }

   public String getPassword() {
      return password;
   }

   public User setPassword(String password) {
      this.password = password;
      return this;
   }

   public String getEmail() {
      return email;
   }

   public User setEmail(String email) {
      this.email = email;
      return this;
   }

   public String getRole() {
      return role;
   }

   public User setRole(String role) {
      this.role = role;
      return this;
   }

   public int getEnabled() {
      return enabled;
   }

   public User setEnabled(boolean enabled) {
      this.enabled = enabled ? 1 : 0;
      return this;
   }
}