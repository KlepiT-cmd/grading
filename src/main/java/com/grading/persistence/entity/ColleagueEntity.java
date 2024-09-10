package com.grading.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ColleagueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String firstname;
    private String lastname;
    private String email;
    private UUID currentGradingLevel;
    private UUID newGradingLevel;

    @ManyToOne
    @JoinColumn(name = "chapter_id", referencedColumnName = "id")
    private ChapterEntity chapter;

    @ManyToOne
    @JoinColumn(name = "teamlead_id", referencedColumnName = "id")
    private ColleagueEntity teamlead;

    @Column(name = "IsCEO")
    private boolean isceo;

    @OneToMany(mappedBy = "colleague", cascade = CascadeType.ALL)
    private List<SkillsEntity> skills;

}
