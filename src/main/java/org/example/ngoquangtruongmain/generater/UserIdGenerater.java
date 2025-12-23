package org.example.ngoquangtruongmain.generater;

import lombok.AllArgsConstructor;
import org.example.ngoquangtruongmain.entity.User;
import org.example.ngoquangtruongmain.repositoty.UserRepository;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
// khóa chính các 5 : custom
@AllArgsConstructor
public class UserIdGenerater implements IdentifierGenerator {
private UserRepository userRepository;
    @Override
    public Object generate(
            SharedSessionContractImplementor session,
            Object object
    ) {
        // cach 1: truy vấn bằng hql
        // cách 2 : truy vấn trong repository dùng @Quert để triển khai
        var user =(User) object;
        var role = user.getRole();
//        long count = userRepository.countByRole(role);
//        //%c: ký tự | %d : số
//        return String.format("%c-%d",role.toString().charAt(0)) + count+1;
//
        var hql = "SELECT COUNT(*) FROM User WHERE role = :role";

        long count = session
                .createSelectionQuery(hql, Long.class)
                .setParameter("role", role)
                .uniqueResult();

        return String.format("%c-%d", role.toString().charAt(0), count + 1);
    }
}
