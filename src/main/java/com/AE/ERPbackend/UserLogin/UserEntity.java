
package com.AE.ERPbackend.UserLogin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users", schema = "authentication")
@Data
@Getter
@Setter
@EqualsAndHashCode
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    // BCrypt hashed password
    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 30)
    private String role;

    @Column(nullable = false)
    private boolean enabled = true;

    /*
     * public Long getId() {
     * return id;
     * }
     * 
     * public String getUsername() {
     * return username;
     * }
     * 
     * public String getPassword() {
     * return password;
     * }
     * 
     * public String getRole() {
     * return role;
     * }
     * 
     * public boolean isEnabled() {
     * return enabled;
     * }
     * 
     * public void setUsername(String username) {
     * this.username = username;
     * }
     * 
     * public void setPassword(String password) {
     * this.password = password;
     * }
     * 
     * public void setRole(String role) {
     * this.role = role;
     * }
     * 
     * public void setEnabled(boolean enabled) {
     * this.enabled = enabled;
     * }
     */
}
