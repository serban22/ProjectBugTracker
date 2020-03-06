create schema projectTracker;
create table projectTracker.status
(
    statusId   int(5) unsigned auto_increment primary key,
    statusName varchar(30) not null
);

create table projectTracker.type
(
    typeId   int(5) unsigned auto_increment primary key,
    typeName varchar(30) not null
);

create table projectTracker.project
(
    projectId          int(5) unsigned auto_increment primary key,
    projectName        varchar(60)         not null,
    shortName          varchar(12) unique  not null,
    projectDescription varchar(250) unique not null,
    statusId           int(5) unsigned,
    foreign key (statusId) references projectTracker.status (statusId)
);

create table projectTracker.item
(
    itemId          int(5) unsigned auto_increment primary key,
    itemTitle       varchar(60) unique  not null,
    itemDescription varchar(250) unique not null,
    statusId        int(5) unsigned,
    typeId          int(5) unsigned,
    foreign key (typeId) references projectTracker.type (typeId),
    foreign key (statusId) references projectTracker.status (statusId)
);

create table projectTracker.comment
(
    commentId   int(5) unsigned auto_increment primary key,
    commentText varchar(2500) not null,
    itemId      int(5) unsigned,
    foreign key (itemId) references projectTracker.item (itemId)
);

insert into projectTracker.type(typeName)
values ('Bug');
insert into projectTracker.type(typeName)
values ('Issue');
insert into projectTracker.type(typeName)
values ('Defect');
insert into projectTracker.type(typeName)
values ('Glitch');
insert into projectTracker.type(typeName)
values ('Problem');
insert into projectTracker.status(statusName)
values ('Open');
insert into projectTracker.status(statusName)
values ('Closed');
insert into projectTracker.status(statusName)
values ('Fixed');
insert into projectTracker.status(statusName)
values ('Slightly fixed');
insert into projectTracker.status(statusName)
values ('Not fixed');
insert into projectTracker.project(projectName, shortName, projectDescription, statusId)
values ('Counter Strike: Planetar Offensive', 'CS PO', 'Shittiest game ever.', 1);
insert into projectTracker.project(projectName, shortName, projectDescription, statusId)
values ('The Secrets of Laura', 'TSOL', 'Best game ever.', 2);
insert into projectTracker.project(projectName, shortName, projectDescription, statusId)
values ('Klaus Iohannis and Co.', 'KI&Co.', 'Stage the death of the Romanian president', 4);
insert into projectTracker.project(projectName, shortName, projectDescription, statusId)
values ('Bombing Coronavirus', 'BC', 'Destroy the world.', 3);
insert into projectTracker.project(projectName, shortName, projectDescription, statusId)
values ('School Inc.', 'SI', 'Live the school adventure.', 5);
insert into projectTracker.item(itemTitle, itemDescription, statusId, typeId)
values ('Drogangeala', 'Ecstasy, cocaina si prenadez.', 2, 1);
insert into projectTracker.item(itemTitle, itemDescription, statusId, typeId)
values ('Pungasareala', 'Pentru cei ce prefera aurolacul.', 4, 2);
insert into projectTracker.item(itemTitle, itemDescription, statusId, typeId)
values ('Pompiereala', 'Pentru baietii cu apa.', 3, 3);
insert into projectTracker.item(itemTitle, itemDescription, statusId, typeId)
values ('Programareala', 'Pentru calculatoare.', 5, 4);
insert into projectTracker.item(itemTitle, itemDescription, statusId, typeId)
values ('Sorineala', 'Pentru bombardieri.', 1, 5);
insert into projectTracker.comment(commentText, itemId)
values ('Cele mai bune droguri.', 1);
insert into projectTracker.comment(commentText, itemId)
values ('Costume nebune pentru interlopii mei.', 3);
insert into projectTracker.comment(commentText, itemId)
values ('Satisfactia lui Sorin este 100%.', 5);
insert into projectTracker.comment(commentText, itemId)
values ('Java best language evur.', 4);
insert into projectTracker.comment(commentText, itemId)
values ('Bruce Lee regele canalelor pe aurolac.', 2);