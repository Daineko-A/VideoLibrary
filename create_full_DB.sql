CREATE DATABASE video_library;
USE video_library;

/*Create USER*/
CREATE TABLE user_role (id INT AUTO_INCREMENT, role VARCHAR(60) UNIQUE NOT NULL, PRIMARY KEY(id));
CREATE TABLE user (id INT AUTO_INCREMENT, name VARCHAR(60) UNIQUE NOT NULL, pass VARCHAR(60) NOT NULL, email VARCHAR(60) UNIQUE NOT NULL, user_role_id INT  NOT NULL,
						PRIMARY KEY(id), FOREIGN KEY (user_role_id) REFERENCES user_role(id) );

/*Create MUVIES*/                    
CREATE TABLE country (id INT AUTO_INCREMENT, country VARCHAR(60) UNIQUE NOT NULL, PRIMARY KEY(id));
CREATE TABLE genre (id INT AUTO_INCREMENT, genre VARCHAR(60) UNIQUE NOT NULL, PRIMARY KEY(id));
CREATE TABLE movies (id INT AUTO_INCREMENT, title VARCHAR(60) UNIQUE NOT NULL, description VARCHAR(2000), release_date DATE NOT NULL, country_id INT NOT NULL, genre_id INT NOT NULL,
		PRIMARY KEY(id), FOREIGN KEY(country_id) REFERENCES country(id), FOREIGN KEY(genre_id) REFERENCES genre(id));

CREATE TABLE roles (id INT AUTO_INCREMENT, role VARCHAR(45) UNIQUE NOT NULL, PRIMARY KEY(id));
CREATE TABLE members (id INT AUTO_INCREMENT, first_name VARCHAR(60) NOT NULL, last_name VARCHAR(60) NOT NULL, birthday DATE NOT NULL, PRIMARY KEY(id));
CREATE TABLE movies_members_roles (movie_id INT NOT NULL, member_id INT NOT NULL, role_id INT NOT NULL,
		FOREIGN KEY(movie_id) REFERENCES movies(id), FOREIGN KEY(member_id) REFERENCES members(id), FOREIGN KEY(role_id) REFERENCES roles(id));

/*Create review*/
CREATE TABLE review (id INT AUTO_INCREMENT, text VARCHAR(1000) NOT NULL, date DATETIME NOT NULL, stars INT NOT NULL, user_id  INT NOT NULL, movie_id INT NOT NULL,
						PRIMARY KEY(id), FOREIGN KEY(user_id) REFERENCES user(id), FOREIGN KEY(movie_id) REFERENCES movies(id));
                        
/*first vales*/
INSERT INTO user_role (role) VALUES ('admin');
INSERT INTO user_role (role) VALUES ('user');
INSERT INTO user_role (role) VALUES ('editor');

INSERT INTO user (name, pass, email, user_role_id) VALUES ('admin', 'admin', 'admin@deadline.com', '1');

/*DROP DATABASE video_library;*/
/*DROP TABLE review;*/

USE video_library;

SELECT * FROM user_role;
SELECT * FROM user;
SELECT * FROM movies;
SELECT * FROM country;

SELECT * FROM user WHERE name LIKE 'ti%' ;

INSERT INTO country (country) VALUES ('Россия');
INSERT INTO genre (genre) VALUES ('приключения');
INSERT INTO genre (genre) VALUES ('фантастика');
INSERT INTO movies (title, release_date) VALUES ('Время первых', '2017-05-06', 1, 1);
INSERT INTO movies (title, release_date) VALUES ('Марсианин', '2015-09-11', 1, 1);
INSERT INTO movies (title, release_date) VALUES ('Прибытие', '2016-09-01', 1, 1);
INSERT INTO movies (title, release_date) VALUES ('Интерстеллар', '2016-10-06', 1, 1);
INSERT INTO movies (title, release_date) VALUES ('Стражи Галактики', '2014-08-21', 1, 1);
INSERT INTO movies (title, release_date) VALUES ('Назад в будущее', '1985-08-03', 1, 1);
INSERT INTO movies (title, release_date) VALUES ('Чужой: Завет', '2017-06-10', 1, 1);

UPDATE movies SET release_date = '2017-05-06' WHERE id = 1;

INSERT INTO review (text, date, stars, user_id, movie_id) VALUES ('Хороший фильм про космонавтов. Рассказывает историю космонавтов, экипаж "Восхода-2, 
Беляева и Леонова. Леонов выходит в открытый космос и сталкивается с множеством нештатных ситуаций. При возвращении сходят с орбиты под неправильным
 углом и приземляются с большим отклонением от места приземления. К счастью спасательная операция была успешна. Об этой ситуации очень часто рассказывал 
 космонавт Леонов в своих интерьвью', localtime , 9, 1, 1);
 
/*SELECT res.id, res.name AS res_name, d.id AS dish_id, d.name AS dish_name, 
    rev.id AS rev_id, rev.text FROM restaurants AS res 
    LEFT JOIN restaurants_dishes AS rd ON res.id = rd.restaurant_id 
    LEFT JOIN dishes AS d ON d.id = rd.dish_id 
    LEFT JOIN reviews AS rev ON res.id = rev.restaurant_id 
    WHERE res.id = 1;*/
    
/*SELECT movies.id, movies.title, movies.release_date, genre.genre, country.country FROM movies
	LEFT JOIN genre ON movies.genre_id = genre.id
    LEFT JOIN country ON movies.country_id = country.id
    WHERE movies.id = 1;
    
    
SELECT movies.id, movies.title, movies.release_date, genre.genre, country.country FROM movies
						LEFT JOIN genre ON movies.genre_id = genre.id
                                LEFT JOIN country ON movies.country_id = country.id
                                WHERE movies.id = 1*/
                                
SELECT * FROM movies ORDER BY release_date DESC;
SELECT * FROM movies WHERE title LIKE '%а%';

SELECT * FROM movies where release_date Like '2017%';

SELECT * FROM members;