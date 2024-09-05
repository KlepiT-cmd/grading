CREATE SCHEMA if not exists grading;
CREATE TABLE if not exists grading.CHAPTER(
                                ID uuid GENERATED ALWAYS AS IDENTITY,
                                ChapterName CHARACTER (30) not null,
                                PRIMARY KEY (ID)
);
CREATE TABLE if not exists grading.LEVEL(
                              ID uuid GENERATED ALWAYS AS IDENTITY,
                              LevelName CHARACTER (2000) not null,
                              PRIMARY KEY (ID)
);
CREATE TABLE if not exists grading.COLLEAGUES(
                                   ID   uuid GENERATED ALWAYS AS IDENTITY,
                                   FirstName CHARACTER (30) not null ,
                                   LastName CHARACTER (30) not null ,
                                   Email CHARACTER (200) not null ,
                                   CurrentGradingLevel uuid,
                                   NewGradingLevel uuid,
                                   ChapterId uuid,
                                   TeamLeadId uuid,
                                   IsCEO bool,
                                   PRIMARY KEY (ID),
                                   FOREIGN KEY (ChapterId)
                                       REFERENCES grading.CHAPTER(ID),
                                   FOREIGN KEY (CurrentGradingLevel)
                                       REFERENCES grading.LEVEL(ID),
                                   FOREIGN KEY (NewGradingLevel)
                                       REFERENCES grading.LEVEL(ID),
                                   FOREIGN KEY (TeamLeadId)
                                       REFERENCES grading.COLLEAGUES(ID)
);
CREATE TABLE if not exists grading.SKILLS(
                               ID uuid generated always as IDENTITY,
                               SkillName CHARACTER (255) not null,
                               ChapterId uuid not null,
                               IsCommon bool not null,
                               IsSoftSkill bool not null,
                               CompetencyID CHARACTER (30) not null,
                               CompetencyName CHARACTER (2000) not null,
                               CompetencyLevel uuid not null,
                               ANAFocus CHARACTER (30) not null,
                               FOREIGN KEY (ChapterId)
                                   REFERENCES grading.CHAPTER(ID)
);