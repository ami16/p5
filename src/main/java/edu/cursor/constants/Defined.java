package edu.cursor.constants;


public final class Defined {

   public static final String BASE_URL = "/spring-library";

   public static class Mappings {
      public static final String PROFILE = BASE_URL + "/user-profile";
      public static final String UPLOAD = BASE_URL + "/upload.do";
      public static final String REGISTRATION = BASE_URL + "/registration";
      public static final String CONFIRM_REGISTRATION = BASE_URL + "/confirmregistration";
      public static final String USERS = BASE_URL + "/users";
      public static final String REGISTER_ACCOUNT = BASE_URL + "/register";
      public static final String LOGIN = BASE_URL + "/login";
      public static final String LOGOUT = BASE_URL + "/logout";
   }

   public static class Pages {
      public static final String PROFILE = BASE_URL + "/user-profile";
      public static final String ERROR = BASE_URL + "/error";
      public static final String LOGIN = BASE_URL + "/login-dev";
      public static final String USERS = BASE_URL + "/users";
      public static final String REGISTER = BASE_URL + "/register";
      public static final String EDIT = BASE_URL + "/edit-profile";
   }

   public class Tables {
      public static final String USERS = "users";
      public static final String BOOKS = "books";
      public static final String REGISTRATION_TOKEN = "registration_token";
   }

}