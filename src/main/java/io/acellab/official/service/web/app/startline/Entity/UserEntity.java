package io.acellab.official.service.web.app.startline.Entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "crm_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;

    @Column(name = "username", nullable = true)
    private String username;

    @Column(name = "passwd", nullable = true)
    private String password;

    @Column(name = "salt", nullable = true)
    private String passwordSalt;

    @Column(name = "nickname", nullable = true)
    private String nickname;




}
