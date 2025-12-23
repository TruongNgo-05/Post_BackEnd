package org.example.ngoquangtruongmain.converter;

import jakarta.persistence.AttributeConverter;
import org.example.ngoquangtruongmain.entity.User;

// cách 3 ; enum theo ký tự
public class UserRoleConverter implements AttributeConverter<User.Role, Character> {
    @Override
    public Character convertToDatabaseColumn(User.Role role) {
        return role.toString().charAt(0);
    }

    @Override
    public User.Role convertToEntityAttribute(Character code) {
        if (code == 'A') {
            return User.Role.ADMIN;
        }

        if (code == 'E') {
            return User.Role.EMPLOYEE;
        }

        return User.Role.MANAGER;
    }
}
