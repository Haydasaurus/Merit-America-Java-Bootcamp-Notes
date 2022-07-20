package com.techelevator.security.controller.dto;

/**
 * DTO for storing a user's credentials.
 */
public class LoginDto {

   private String username;
   private String password;
   private Boolean rememberMe;

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public Boolean isRememberMe() {
      return rememberMe;
   }

   public void setRememberMe(Boolean rememberMe) {
      this.rememberMe = rememberMe;
   }

   @Override
   public String toString() {
      return "LoginVM{" +
         "username='" + username + '\'' +
         ", rememberMe=" + rememberMe +
         '}';
   }
}
