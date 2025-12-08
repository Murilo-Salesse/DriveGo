package br.com.DriveGo.drivego.core.entities;

import br.com.DriveGo.drivego.core.enums.Roles;
import java.time.LocalDateTime;


public class User {

    String id;
    String email;
    String password_hash;
    String full_name;
    Roles user_role;
    String phone;
    LocalDateTime created_at;
    LocalDateTime updated_at;
}
