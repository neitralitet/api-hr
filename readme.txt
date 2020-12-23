!!!!!!!!!!!!РЕАЛИЗАЦИЯ API с помощью патерна Repository!!!!!!!!!!!!


В БД необходимо создать две таблицы: Отделы и Сотрудники.
БД должна заполняться тестовыми данными.
Для отделов хранить название отдела.
Для сотрудников хранить: отдел, ФИО сотрудника, дату его рождения и его зарплату.
Написать (и уметь публиковать «руками» на сервер Tomcat) Web-сервис (RESTful) для доступа к данным, который будет выбирать данные из БД и сохранять/изменять/удалять данные в БД.
Написать (и так же уметь публиковать «руками» на сервер Tomcat) простое Web-приложение для работы с отделами и сотрудниками отделов. Данное приложение для работы с БД должно использовать Web-сервис указанный выше.
Web - приложение должно позволять:
· посмотреть список отделов и среднюю зарплату (рассчитывается автоматически) по этим отделам;
· список сотрудников в отделах с указанием зарплаты для каждого сотрудника и полем поиска для поиска сотрудников родившихся в определенную дату или в период между датами (вторая списочная форма);
· изменять (добавлять/редактировать/удалять) вышеуказанные данные.

Результат сборки приложения - 2 WAR файла:
· WAR файл для приложения REST-service;
o model
o dao
o services < - > rest
· WAR файл для приложения c WEB – интерфейсом.
o model
o services < - > rest
o web



бд скрипт

create table department (
id bigserial PRIMARY KEY NOT NULL,
departament_name   varchar(255) NOT NULL
);
CREATE INDEX ON department (id);

create table employee (
id bigserial PRIMARY KEY NOT NULL,
department_id bigserial  NOT NULL,
name varchar(255),
second_name varchar(255),
patronymic_name varchar(255),
date_of_birth DATE,
salary NUMERIC,
foreign key (department_id) REFERENCES  department (id)
);
CREATE INDEX ON employee (id);
insert into department(departament_name) VALUES ('первый');
insert into employee VALUES (1,1,'Владимир','Фамвладимир','Владимирович','1998-09-08','99999');