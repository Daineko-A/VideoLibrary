CREATE DATABASE video_library;
USE video_library;

/*Create USER*/
CREATE TABLE user_role (id INT AUTO_INCREMENT, role VARCHAR(60) UNIQUE NOT NULL, PRIMARY KEY(id));
CREATE TABLE user (id INT AUTO_INCREMENT, name VARCHAR(60) UNIQUE NOT NULL, pass VARCHAR(60) NOT NULL, email VARCHAR(60) UNIQUE NOT NULL, user_role_id INT  NOT NULL,
						PRIMARY KEY(id), FOREIGN KEY (user_role_id) REFERENCES user_role(id) );

/*Create MUVIES*/                    
CREATE TABLE country (id INT AUTO_INCREMENT, country VARCHAR(60) UNIQUE NOT NULL, PRIMARY KEY(id));
CREATE TABLE genre (id INT AUTO_INCREMENT, genre VARCHAR(60) UNIQUE NOT NULL, PRIMARY KEY(id));
CREATE TABLE movies (id INT AUTO_INCREMENT, title VARCHAR(60) UNIQUE NOT NULL, release_date DATE NOT NULL, country_id INT NOT NULL, genre_id INT NOT NULL,
						PRIMARY KEY(id), FOREIGN KEY(country_id) REFERENCES country(id), FOREIGN KEY(genre_id) REFERENCES genre(id));

CREATE TABLE roles (id INT AUTO_INCREMENT, role VARCHAR(45) UNIQUE NOT NULL, PRIMARY KEY(id));
CREATE TABLE members (id INT AUTO_INCREMENT, first_name VARCHAR(60) NOT NULL, last_name VARCHAR(60) NOT NULL, birthday DATE NOT NULL, PRIMARY KEY(id));
CREATE TABLE movies_members_roles (movie_id INT NOT NULL, member_id INT NOT NULL, role_id INT NOT NULL,
											FOREIGN KEY(movie_id) REFERENCES movies(id), FOREIGN KEY(member_id) REFERENCES members(id), FOREIGN KEY(role_id) REFERENCES roles(id));

/*Create review*/
CREATE TABLE review (id INT AUTO_INCREMENT, text VARCHAR(2000) NOT NULL, date DATE NOT NULL, stars INT NOT NULL, user_id  INT NOT NULL, movie_id INT NOT NULL,
						PRIMARY KEY(id), FOREIGN KEY(user_id) REFERENCES user(id), FOREIGN KEY(movie_id) REFERENCES movies(id));