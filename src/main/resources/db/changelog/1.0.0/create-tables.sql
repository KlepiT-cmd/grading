CREATE SCHEMA if not exists grading;
CREATE extension if not exists "uuid-ossp";
CREATE TABLE if not exists grading.CHAPTER(
                                ID uuid DEFAULT uuid_generate_v4(),
                                ChapterName VARCHAR (30) not null UNIQUE,
                                PRIMARY KEY (ID)
);
CREATE TABLE if not exists grading.LEVEL(
                              ID uuid DEFAULT uuid_generate_v4(),
                              LevelName VARCHAR (2000) not null UNIQUE,
                              PRIMARY KEY (ID)
);
CREATE TABLE if not exists grading.COLLEAGUES(
                                   ID uuid DEFAULT uuid_generate_v4(),
                                   FirstName VARCHAR (30) not null ,
                                   LastName VARCHAR (30) not null ,
                                   Email VARCHAR (200) not null UNIQUE,
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
                               ID uuid DEFAULT uuid_generate_v4(),
                               SkillName VARCHAR (255) not null,
                               ChapterId uuid not null,
                               IsCommon bool not null,
                               IsSoftSkill bool not null,
                               CompetencyID VARCHAR (30) not null,
                               CompetencyName VARCHAR (2000) not null,
                               CompetencyLevel uuid not null,
                               ANAFocus VARCHAR (30) not null,
                               FOREIGN KEY (ChapterId)
                                   REFERENCES grading.CHAPTER(ID)
);
CREATE TABLE if not exists grading.GRADING(
                                             ID uuid DEFAULT uuid_generate_v4(),
                                             ColleagueID uuid not null,
                                             GradingLevelId uuid not null,
                                             FOREIGN KEY (ColleagueID)
                                                 REFERENCES grading.COLLEAGUES(ID),
                                             FOREIGN KEY (GradingLevelId)
                                                 REFERENCES grading.LEVEL(ID)
);
CREATE TABLE if not exists grading.DOCUMENTS(
                                             ID uuid DEFAULT uuid_generate_v4(),
                                             ColleagueId uuid not null,
                                             DocumentData VARCHAR (2000) not null UNIQUE,
                                             Year INTEGER not null,
                                             FOREIGN KEY (ColleagueId)
                                                 REFERENCES grading.COLLEAGUES(ID)
);
insert into grading.LEVEL values (uuid_generate_v4(), 'Junior0');
insert into grading.LEVEL values (uuid_generate_v4(), 'Junior1');
insert into grading.LEVEL values (uuid_generate_v4(), 'Junior2');
insert into grading.LEVEL values (uuid_generate_v4(), 'Medior1');
insert into grading.LEVEL values (uuid_generate_v4(), 'Medior2');
insert into grading.LEVEL values (uuid_generate_v4(), 'Senior1');
insert into grading.LEVEL values (uuid_generate_v4(), 'Senior2');
insert into grading.LEVEL values (uuid_generate_v4(), 'Expert');
insert into grading.CHAPTER values (uuid_generate_v4(), 'ANALYST');
insert into grading.CHAPTER values (uuid_generate_v4(), 'BACKEND_DEVELOPER');
insert into grading.CHAPTER values (uuid_generate_v4(), 'FRONTEND_DEVELOPER');
insert into grading.CHAPTER values (uuid_generate_v4(), 'QA');
