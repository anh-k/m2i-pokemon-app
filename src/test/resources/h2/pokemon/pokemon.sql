create table if not exists `testdb.pokemon`
(
    `id` integer not null,
    `name` varchar(255),
    `baseexp` integer not null,
    primary key(id)
    );