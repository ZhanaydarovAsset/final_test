# Информация о проекте

Необходимо организовать систему учета для питомника, в котором живут домашние и вьючные животные.

# Задание

1. Используя команду cat в терминале операционной системы Linux, создать
два файла Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животными заполнив файл (Лошадьми, верблюдами и
ослы), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).

![Alt text](images\image-1.png)

2. Создать директорию, переместить файл туда.

![Alt text](images\image-1.png)

3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория.

![Alt text](images\image-2.png)
![Alt text](images\image-3.png)
![Alt text](images\image-4.png)

4. Установить и удалить deb-пакет с помощью dpkg.

![Alt text](images\image-5.png)
![Alt text](images\image-6.png)
![Alt text](images\image-7.png)

5. Выложить историю команд в терминале ubuntu

asset_zh@DESKTOP-QAFSKRR:~$ history

   21  ls -al
  
  22  cat > "Домашние_животные" <<EOF
Собаки
Кошки
Хомяки
EOF

   23  ls -al
   
   24  nano Домашние_животные
   
   25  cat > "Вьючные_животные" <<EOF
Лошади
Верблюды
Ослы
EOF

   26  nano Вьючные_животные
   
   27  cat Домашние_животные Вьючные_животные > animals
   
   28  ls -al
   
   29  nano animals
   
   30  mv animals mans_friends
   
   31  ls -ali
   
   32  cd mans_friends
   
   33  nano mans_friends
   
   36  mkdir animals
   
   37  mv mans_friends animals/
   
   38  ls -l
   
   39  cd animals
   
   40  ls -l
   
   41  sudo apt-get update
   
   42  sudo apt-get install software-properties-common
   
   43  sudo add-apt-repository -y ppa:mysql/mysql-server
   
   44  sudo add-apt-repository -y ppa:http://dev.mysql.com/
   
   45  sudo wget https://dev.mysql.com/get/mysql-apt-config_0.8.23-1_all.deb
   
   46  sudo dpkg -i mysql-apt-config_0.8.23-1_all.deb
   
   47  sudo apt-get update
   
   48  sudo apt-get install mysql-server
   
   49  cd ~
   
   50  sudo wget https://download.docker.com/linux/ubuntu/dists/jammy/pool/stable/amd64/docker-ce-cli_20.10.13~3-0~ubuntu-jammy_amd64.deb
   
   51  sudo dpkg -i docker-ce-cli_20.10.133-0ubuntu-jammy_amd64.deb
   
   61  sudo dpkg -i docker-ce-cli_20.10.133-0ubuntu-jammy_amd64.deb
   
   62  sudo wget https://download.docker.com/linux/ubuntu/dists/jammy/pool/stable/amd64/docker-ce-cli_20.10.13~3-0~ubuntu-jammy_amd64.deb
   
   63  ls -l
   
   64  sudo dpkg -i docker-ce-cli_20.10.133-0ubuntu-jammy_amd64.deb.1
   
   65  mv docker-ce-cli_20.10.13~3-0~ubuntu-jammy_amd64.deb ddocker.deb
   
   66  ls -l
   
   70  sudo dpkg -P docker-ce-cli
   
   71  history

6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние
животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы.

[Диаграма](\final_test\diagramm.drawio)

7. В подключенном MySQL репозитории создать базу данных “Друзья
человека”
```sql
CREATE DATABASE IF NOT EXISTS friends_of_man;
USE friends_of_man;
```

8. Создать таблицы с иерархией из диаграммы в БД

```sql
CREATE TABLE IF NOT EXISTS animals(
	Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    class_name VARCHAR(20)
);

INSERT INTO animals(class_name) VALUES
	("pets"),
    ("pack_animals");

CREATE TABLE pets
(
	Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Genus_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pets (Genus_name, Class_id)
VALUES
	('Кошки', 1),
	('Собаки', 1),  
	('Хомяки', 1);

CREATE TABLE pack_animals
(
	Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Genus_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
    
INSERT INTO pack_animals (Genus_name, Class_id)
VALUES
	('Лошади', 2),
	('Ослы', 2),  
	('Верблюды', 2); 


```
9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения
```sql
CREATE TABLE cats 
(       
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO cats (Name, Birthday, Commands, Genus_id)
VALUES ('Мурка', '2022-01-01', 'кс-кс-кс', 1),
('Барсик', '2019-01-01', "кушать!", 1),  
('Тьма', '2020-01-01', "прыс", 1); 

CREATE TABLE dogs 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO dogs (Name, Birthday, Commands, Genus_id)
VALUES ('Док', '2020-01-01', 'ко мне, лежать, лапу, голос', 2),
('Граф', '2021-06-12', "сидеть, лежать, лапу", 2),  
('Шарик', '2018-05-01', "сидеть, лежать, лапу, след, фас", 2), 
('Барбос', '2021-05-10', "сидеть, лежать, фу, место", 2);

CREATE TABLE hamsters 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO hamsters (Name, Birthday, Commands, Genus_id)
VALUES ('Малой', '2020-10-12', '', 3),
('Медведь', '2021-03-12', "атака сверху", 3),  
('Ниндзя', '2022-07-11', NULL, 3), 
('Бурый', '2022-05-10', NULL, 3);

CREATE TABLE horses 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO horses (Name, Birthday, Commands, Genus_id)
VALUES ('Гром', '2020-01-12', 'бегом, шагом', 1),
('Каражал', '2017-03-12', "бегом, шагом, хоп", 1),  
('Аргымак', '2016-07-12', "бегом, шагом, хоп, брр", 1), 
('Молния', '2020-11-10', "бегом, шагом, хоп", 1);

CREATE TABLE donkeys 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO donkeys (Name, Birthday, Commands, Genus_id)
VALUES ('Первый', '2019-04-10', NULL, 2),
('Второй', '2020-03-12', "", 2),  
('Третий', '2021-07-12', "", 2), 
('Четвертый', '2022-12-10', NULL, 2);

CREATE TABLE camels 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO camels (Name, Birthday, Commands, Genus_id)
VALUES ('Горбатый', '2022-04-10', 'вернись', 3),
('Самец', '2019-03-12', "остановись", 3),  
('Туйе', '2015-07-12', "повернись", 3), 
('Нар', '2022-12-10', "улыбнись", 3);
```
10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
```sql
SET SQL_SAFE_UPDATES = 0;
DELETE FROM camels;

SELECT Name, Birthday, Commands FROM horses
UNION SELECT  Name, Birthday, Commands FROM donkeys;
```

11. Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице
```sql
CREATE TEMPORARY TABLE animals AS 
SELECT *, 'Лошади' as genus FROM horses
UNION SELECT *, 'Ослы' AS genus FROM donkeys
UNION SELECT *, 'Собаки' AS genus FROM dogs
UNION SELECT *, 'Кошки' AS genus FROM cats
UNION SELECT *, 'Хомяки' AS genus FROM hamsters;

CREATE TABLE yang_animal AS
SELECT Name, Birthday, Commands, genus, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS Age_in_month
FROM animals WHERE Birthday BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);
 
SELECT * FROM yang_animal;
```
12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.
```sql
SELECT h.Name, h.Birthday, h.Commands, pa.Genus_name, ya.Age_in_month 
FROM horses h
LEFT JOIN yang_animal ya ON ya.Name = h.Name
LEFT JOIN packed_animals pa ON pa.Id = h.Genus_id
UNION 
SELECT d.Name, d.Birthday, d.Commands, pa.Genus_name, ya.Age_in_month 
FROM donkeys d 
LEFT JOIN yang_animal ya ON ya.Name = d.Name
LEFT JOIN packed_animals pa ON pa.Id = d.Genus_id
UNION
SELECT c.Name, c.Birthday, c.Commands, ha.Genus_name, ya.Age_in_month 
FROM cats c
LEFT JOIN yang_animal ya ON ya.Name = c.Name
LEFT JOIN home_animals ha ON ha.Id = c.Genus_id
UNION
SELECT d.Name, d.Birthday, d.Commands, ha.Genus_name, ya.Age_in_month 
FROM dogs d
LEFT JOIN yang_animal ya ON ya.Name = d.Name
LEFT JOIN home_animals ha ON ha.Id = d.Genus_id
UNION
SELECT hm.Name, hm.Birthday, hm.Commands, ha.Genus_name, ya.Age_in_month 
FROM hamsters hm
LEFT JOIN yang_animal ya ON ya.Name = hm.Name
LEFT JOIN home_animals ha ON ha.Id = hm.Genus_id;
```






