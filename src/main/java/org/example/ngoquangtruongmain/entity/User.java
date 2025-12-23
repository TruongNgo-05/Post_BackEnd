package org.example.ngoquangtruongmain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.ngoquangtruongmain.converter.UserRoleConverter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.descriptor.jdbc.CharJdbcType;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")

    @GeneratedValue(strategy = GenerationType.IDENTITY)    // C1:tự động tăng
//=============================================================================
//    @SequenceGenerator(
//            name = "post_id_generator",
//            sequenceName = "post_id_sequence",
//            initialValue = 10,// id ban đầu
//            allocationSize = 1// bước nhảy
//    )
//    @GeneratedValue(generator = "post_id_generator") // c2: theo ý mình
//================================================================================

//    @GeneratedValue(strategy = GenerationType.UUID)
//    @JdbcType(value = CharJdbcType.class) // c3: theo uuid 36 ký tự ( thay Interger thành UUID)
//================================================================================
//    @GeneratedValue(strategy = GenerationType.AUTO) //C4 TỰ ĐỘNG MAC TRONG DB
//================================================================================
//        @SequenceGenerator(
//            name = "post_id_generator",
//            type = UserRoleConverter.class;
//    )
//    @GeneratedValue(generator = "post_id_generator")  //C5: Custom
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "username", nullable = false, length = 100)
    private String username;

    @Column(name = "email", length = 50,  nullable = false, unique = true)
    private String email;
    @Column(name = "password", length = 100,  nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
//    @Enumerated(EnumType.STRING)// C1 :String
//        @Enumerated(EnumType.ORDINAL)//  C2:kieu so
@Convert(converter = UserRoleConverter.class) // C3 dùng convert
    private Role role;

    @Column(name = "create_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "update_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public enum Role {
        ADMIN, // 0
        EMPLOYEE,// 1
        MANAGER,// 2
    }
}
