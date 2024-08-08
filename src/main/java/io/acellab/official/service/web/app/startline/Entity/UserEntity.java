package io.acellab.official.service.web.app.startline.Entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "crm_user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;

    @Column(name = "username", nullable = true, length = 100)
    private String username;

    @Column(name = "passwd", nullable = true, length = 32)
    private String password;

    @Column(name = "roleid", nullable = true)
    private Integer roleId;

    @Column(name = "enterprise_roleid", nullable = true)
    private Integer enterpriseRoleId;

    @Column(name = "startup_roleid", nullable = true)
    private Integer startupRoleId;

    @Column(name = "avatar", nullable = true, length = 255)
    private String avatar;

    @Column(name = "nickname", nullable = true, length = 50)
    private String nickname;

    @Column(name = "email", nullable = true, length = 255)
    private String email;

    @Column(name = "email2", nullable = true, length = 255)
    private String email2;

    @Column(name = "phone", nullable = true, length = 255)
    private String phone;

    @Column(name = "company", nullable = true, length = 100)
    private String company;

    @Column(name = "job", nullable = true, length = 50)
    private String job;

    @Column(name = "website", nullable = true, length = 255)
    private String website;

    @Column(name = "linkedin", nullable = true, length = 255)
    private String linkedin;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "create_userid", nullable = true)
    private Integer createUserId;

    @Column(name = "cancel", nullable = true)
    private Integer cancel;

    @Column(name = "status", nullable = true)
    private Integer status;

    @Column(name = "last_action", nullable = true)
    private Integer lastAction;

    @Column(name = "mtime", nullable = true)
    private Integer mtime;

    @Column(name = "time", nullable = true)
    private Integer time;
}