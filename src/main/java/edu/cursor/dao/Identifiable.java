package edu.cursor.dao;

import javax.persistence.*;

@MappedSuperclass
public abstract class Identifiable {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   private String login;

   @Column(name = "name", length = 255)
   private String name;


   public String getLogin() {
      return login;
   }
   public void setLogin(String login) {
      this.login = login;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

}