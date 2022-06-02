create schema if not exists testdb;

create table if not exists `testdb.pokemon`
(
    `id` integer not null,
    `name` varchar(255),
    `baseexp` integer not null,
    primary key(id)
    );

create table if not exists `testdb.team` (
    `id` integer not null,
    `name` varchar(255),
    primary key(id)
    );

create table if not exists `testdb.user` (
    `id` integer not null,
    `userid` varchar(255),
    `firstname` varchar(255),
    `lastname` varchar(255),
    `username` varchar (255),
    `password` varchar(255),
    `email` varchar(255),
    `profileimageurl` varchar(255),
    `lastlogindate` integer ,
    `lastlogindatedisplay` date,
    `joindate` date,
    `role` varchar(255),
    `authorities` varchar(255),
    `isActive` bit,
    `isNotLocked` bit,
    primary key(id)
    );