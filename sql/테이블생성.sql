-- auto-generated definition
create table t_configurationA
(
    seq         int auto_increment
        primary key,
    category    varchar(64)                         not null,
    code        varchar(30)                         not null,
    description varchar(100)                        null,
    enabled     bit       default b'0'              not null,
    create_time timestamp default CURRENT_TIMESTAMP null,
    update_time timestamp default CURRENT_TIMESTAMP null
);

create index t_configurationA_create_time_index
    on t_configurationA (create_time);



-- auto-generated definition
create table t_configurationB
(
    seq         int auto_increment
        primary key,
    category    varchar(64)                         not null,
    code        varchar(30)                         not null,
    description varchar(100)                        null,
    enabled     bit       default b'0'              not null,
    create_time timestamp default CURRENT_TIMESTAMP null,
    update_time timestamp default CURRENT_TIMESTAMP null
);

create index t_configurationB_create_time_index
    on t_configurationB (create_time);



-- auto-generated definition
create table t_configurationC
(
    seq         int auto_increment
        primary key,
    category    varchar(64)                         not null,
    code        varchar(30)                         not null,
    description varchar(100)                        null,
    enabled     bit       default b'0'              not null,
    create_time timestamp default CURRENT_TIMESTAMP null,
    update_time timestamp default CURRENT_TIMESTAMP null
);

create index t_configurationC_create_time_index
    on t_configurationC (create_time);




/* update*/
ALTER TABLE t_configurationA MODIFY update_time timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
ALTER TABLE t_configurationB MODIFY update_time timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
ALTER TABLE t_configurationC MODIFY update_time timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP