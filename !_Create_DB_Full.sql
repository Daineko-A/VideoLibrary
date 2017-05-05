DROP DATABASE video_library;
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

USE video_library;

INSERT INTO country (country) VALUES ('Россия');
INSERT INTO genre (genre) VALUES ('приключения');
INSERT INTO genre (genre) VALUES ('фантастика');
INSERT INTO movies (title, description, release_date, country_id, genre_id) VALUES ('Время первых', '60-е. Разгар холодной войны. Две супердержавы, СССР и США бьются за первенство в космической гонке. Пока СССР впереди, на очереди — выход человека в открытый космос.

За две недели до старта взрывается тестовый корабль. Времени на выявление причин нет. И пусть риски огромны, мы не можем уступить лидерство.

Опытный военный летчик Павел Беляев и его напарник Алексей Леонов, необстрелянный и горячий, мечтающий о подвиге, — два человека, готовые шагнуть в неизвестность. Но никто не мог даже предположить всего, с чем им предстояло столкнуться в полете. В этой миссии все, что только можно, пошло не так…', '2017-05-06', 1, 1);
INSERT INTO movies (title, description, release_date, country_id, genre_id) VALUES ('Марсианин', 'Марсианская миссия «Арес-3» в процессе работы была вынуждена экстренно покинуть планету из-за надвигающейся песчаной бури. Инженер и биолог Марк Уотни получил повреждение скафандра во время песчаной бури. Сотрудники миссии, посчитав его погибшим, эвакуировались с планеты, оставив Марка одного.

Очнувшись, Уотни обнаруживает, что связь с Землёй отсутствует, но при этом полностью функционирует жилой модуль. Главный герой начинает искать способ продержаться на имеющихся запасах еды, витаминов, воды и воздуха ещё 4 года до прилёта следующей миссии «Арес-4».', '2015-09-11', 1, 1);
INSERT INTO movies (title, description, release_date, country_id, genre_id) VALUES ('Прибытие', 'Неожиданное появление неопознанных летающих объектов в разных точках планеты повергает мир в трепет. Намерения пришельцев не ясны — вооруженные силы всего мира приведены в полную боевую готовность, а лучшие умы человечества пытаются понять, как разговаривать с непрошенными гостями. Правительство обращается за помощью к лингвисту Луизе Бэнкс и физику Яну Доннели, чтобы предотвратить глобальную катастрофу и найти общий язык с пришельцами. Отныне судьба человечества находится в их руках.', '2016-09-01', 1, 1);
INSERT INTO movies (title, description, release_date, country_id, genre_id) VALUES ('Интерстеллар', 'Когда засуха приводит человечество к продовольственному кризису, коллектив исследователей и учёных отправляется сквозь червоточину (которая предположительно соединяет области пространства-времени через большое расстояние) в путешествие, чтобы превзойти прежние ограничения для космических путешествий человека и переселить человечество на другую планету.', '2016-10-06', 1, 1);
INSERT INTO movies (title, description, release_date, country_id, genre_id) VALUES ('Стражи Галактики', 'Отважному путешественнику Питеру Квиллу попадает в руки таинственный артефакт, принадлежащий могущественному и безжалостному злодею Ронану, строящему коварные планы по захвату Вселенной. Питер оказывается в центре межгалактической охоты, где жертва — он сам.

Единственный способ спасти свою жизнь — объединиться с четверкой нелюдимых изгоев: воинственным енотом по кличке Ракета, человекоподобным деревом Грутом, смертельно опасной Гаморой и одержимым жаждой мести Драксом, также известным как Разрушитель. Когда Квилл понимает, какой силой обладает украденный артефакт и какую опасность он представляет для вселенной, одиночка пойдет на все, чтобы сплотить случайных союзников для решающей битвы за судьбу галактики.', '2014-08-21', 1, 1);
INSERT INTO movies (title, description, release_date, country_id, genre_id) VALUES ('Назад в будущее', 'Подросток Марти с помощью машины времени, сооруженной его другом профессором доком Брауном, попадает из 80-х в далекие 50-е. Там он встречается со своими будущими родителями, еще подростками, и другом-профессором, совсем молодым.', '1985-08-03', 1, 1);
INSERT INTO movies (title, description, release_date, country_id, genre_id) VALUES ('Чужой: Завет', 'Во время обследования удаленной планеты, расположенной на другой стороне галактики, экипаж колониального корабля «Завет» обнаруживает, что то, что они изначально приняли за неизведанный рай, на самом деле — тёмный и опасный мир. Его единственный житель — синтетический андроид Дэвид, оставшийся в живых после обреченной экспедиционной миссии «Прометей».', '2017-06-10', 1, 1);

INSERT INTO review (text, date, stars, user_id, movie_id) VALUES ('Хороший фильм про космонавтов. Рассказывает историю космонавтов, экипаж "Восхода-2, 
Беляева и Леонова. Леонов выходит в открытый космос и сталкивается с множеством нештатных ситуаций. При возвращении сходят с орбиты под неправильным
 углом и приземляются с большим отклонением от места приземления. К счастью спасательная операция была успешна. Об этой ситуации очень часто рассказывал 
 космонавт Леонов в своих интерьвью', localtime , 9, 1, 1);
 
INSERT INTO members (first_name, last_name, birthday) VALUES ('Евгений', 'Миронов', '1966-11-29');
INSERT INTO members (first_name, last_name, birthday) VALUES ('Константин', 'Хабенский', '1972-01-11');
INSERT INTO members (first_name, last_name, birthday) VALUES ('Владимир', 'Ильин', '1946-11-16');

INSERT INTO roles (role) VALUES ('актер');

INSERT INTO movies_members_roles (movie_id, member_id, role_id) VALUES (1, 1, 1);
INSERT INTO movies_members_roles (movie_id, member_id, role_id) VALUES (1, 2, 1);
INSERT INTO movies_members_roles (movie_id, member_id, role_id) VALUES (1, 3, 1);