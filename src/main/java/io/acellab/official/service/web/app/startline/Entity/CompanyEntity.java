package io.acellab.official.service.web.app.startline.Entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "company")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "icon", length = 255)
    private String icon;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "region", length = 50)
    private String region;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "team_size", length = 50)
    private String teamSize;

    @Column(name = "website", length = 255)
    private String website;

    @Column(name = "short_intro", columnDefinition = "TEXT")
    private String shortIntro;

    @Column(name = "background", columnDefinition = "TEXT")
    private String background;

    @Column(name = "field")
    private String field;

    @Column(name = "segmented_field")
    private String segmentedField;

    @Column(name = "financing_round")
    private String financingRound;

}