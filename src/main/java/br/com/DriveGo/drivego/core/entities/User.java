package br.com.DriveGo.drivego.core.entities;

import br.com.DriveGo.drivego.core.enums.Roles;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


public class User {

    private UUID id;
    private String email;
    private String password_hash;
    private String full_name;
    private Roles user_role;
    private String phone;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public User(UUID id, String email, String password_hash, String full_name, Roles user_role, String phone, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.email = email;
        this.password_hash = password_hash;
        this.full_name = full_name;
        this.user_role = user_role;
        this.phone = phone;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Roles getUser_role() {
        return user_role;
    }

    public void setUser_role(Roles user_role) {
        this.user_role = user_role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(password_hash, user.password_hash) && Objects.equals(full_name, user.full_name) && user_role == user.user_role && Objects.equals(phone, user.phone) && Objects.equals(created_at, user.created_at) && Objects.equals(updated_at, user.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password_hash, full_name, user_role, phone, created_at, updated_at);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password_hash='" + password_hash + '\'' +
                ", full_name='" + full_name + '\'' +
                ", user_role=" + user_role +
                ", phone='" + phone + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
