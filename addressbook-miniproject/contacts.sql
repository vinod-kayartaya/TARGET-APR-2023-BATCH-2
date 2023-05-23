drop table if exists contacts;

create table contacts (
	id INT primary key auto_increment,
	first_name VARCHAR(50) not null,
	last_name VARCHAR(50),
	email VARCHAR(50) unique,
	phone VARCHAR(50) unique,
	city VARCHAR(50) default 'Bangalore',
	birth_date DATE
);
insert into contacts (id, first_name, last_name, email, phone, city, birth_date) values (1, 'Vanni', 'Forth', 'vforth0@skyrock.com', '969-488-8280', 'Nong Yasai', '2016-01-11');
insert into contacts (id, first_name, last_name, email, phone, city, birth_date) values (2, 'Verene', 'Spaxman', 'vspaxman1@netvibes.com', '788-188-0432', 'Polanka Wielka', '1997-04-11');
insert into contacts (id, first_name, last_name, email, phone, city, birth_date) values (3, 'Millicent', 'Given', 'mgiven2@t.co', '189-365-0309', 'Tamianglayang', '1999-05-16');
insert into contacts (id, first_name, last_name, email, phone, city, birth_date) values (4, 'Wallis', 'Slocum', 'wslocum3@soup.io', '370-679-9421', 'San Carlos de Bolívar', '2017-04-21');
insert into contacts (id, first_name, last_name, email, phone, city, birth_date) values (5, 'Carolyn', 'Iacovacci', 'ciacovacci4@europa.eu', '214-217-8302', 'Garland', '1990-05-19');
insert into contacts (id, first_name, last_name, email, phone, city, birth_date) values (6, 'Tandi', 'Oakenfield', 'toakenfield5@odnoklassniki.ru', '220-780-8484', 'Karvia', '1974-03-11');
insert into contacts (id, first_name, last_name, email, phone, city, birth_date) values (7, 'Murial', 'Grissett', 'mgrissett6@photobucket.com', '983-514-4188', 'Gerong', '2017-05-14');
insert into contacts (id, first_name, last_name, email, phone, city, birth_date) values (8, 'Gradeigh', 'Haszard', 'ghaszard7@spotify.com', '774-986-5162', 'Guanghai', '1975-07-02');
insert into contacts (id, first_name, last_name, email, phone, city, birth_date) values (9, 'Kingston', 'Sharrard', 'ksharrard8@latimes.com', '960-774-1793', 'Kāshān', '1988-10-23');
insert into contacts (id, first_name, last_name, email, phone, city, birth_date) values (10, 'Briney', 'Georges', 'bgeorges9@addtoany.com', '738-490-0937', 'Monjarás', '1967-08-23');
insert into contacts (id, first_name, last_name, email, phone, city, birth_date) values (11, 'Ulises', 'Wheway', 'uwhewaya@state.tx.us', '864-931-5489', 'Suban', '1983-09-21');
insert into contacts (id, first_name, last_name, email, phone, city, birth_date) values (12, 'Tiebout', 'Trobe', 'ttrobeb@imageshack.us', '609-519-9277', 'Trąbki', '1988-04-08');
insert into contacts (id, first_name, last_name, email, phone, city, birth_date) values (13, 'Ellerey', 'Smart', 'esmartc@vkontakte.ru', '398-458-3272', 'Porto Feliz', '1966-02-20');
insert into contacts (id, first_name, last_name, email, phone, city, birth_date) values (14, 'Gracie', 'Whatmough', 'gwhatmoughd@tumblr.com', '654-527-0049', 'Da’ao', '1996-10-29');
insert into contacts (id, first_name, last_name, email, phone, city, birth_date) values (15, 'Candida', 'Heeron', 'cheerone@yolasite.com', '884-158-6725', 'Kalugmanan', '1973-11-17');
