package org.example.ngoquangtruongmain.repositoty;

import org.example.ngoquangtruongmain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {
    // admin , employye,  manager
//    A-1;
//    A-2;
//    A-1;
//    A-1;
//    A-2;
    @Query()
    Integer countByRole(User.Role role);
}
