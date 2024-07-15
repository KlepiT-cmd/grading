CREATE SCHEMA if not exists grading;
CREATE TABLE if not exists grading.CHAPTER(
                                ID INT GENERATED ALWAYS AS IDENTITY,
                                ChapterName CHARACTER (30) not null,
                                PRIMARY KEY (ID)
);
CREATE TABLE if not exists grading.LEVEL(
                              ID INT GENERATED ALWAYS AS IDENTITY,
                              LevelName CHARACTER (30) not null,
                              PRIMARY KEY (ID)
);
CREATE TABLE if not exists grading.COLLEAGUES(
                                   ID   INT GENERATED ALWAYS AS IDENTITY,
                                   FirstName CHARACTER (30) not null ,
                                   LastName CHARACTER (30) not null ,
                                   Email CHARACTER (200) not null ,
                                   CurrentGradingLevel INT,
                                   NewGradingLevel INT,
                                   ChapterId INT,
                                   TeamLeadId INT,
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
                               ID INT generated always as IDENTITY,
                               SkillName CHARACTER (255) not null,
                               ChapterId INT not null,
                               IsCommon bool not null,
                               FOREIGN KEY (ChapterId)
                                   REFERENCES grading.CHAPTER(ID)
);