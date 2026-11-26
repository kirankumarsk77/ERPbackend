package com.AE.ERPbackend.UserLogin;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@EqualsAndHashCode
public class UserDTO {

    @NotBlank(message = "username is required")
    private String username;

    @NotBlank(message = "password is required")
    private String password;

    /*
     * public String getUsername() {
     * return username;
     * }
     * 
     * public String getPassword() {
     * return password;
     * }
     * 
     * public void setUsername(String username) {
     * this.username = username;
     * }
     * 
     * public void setPassword(String password) {
     * this.password = password;
     * 
     * 
     * }
     */

}
