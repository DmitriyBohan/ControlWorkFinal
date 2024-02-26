-- Создание базы данных
CREATE DATABASE IF NOT EXISTS HumanFriends;
USE HumanFriends;

-- Создание таблицы Animals
CREATE TABLE IF NOT EXISTS Animals (
  id INT AUTO_INCREMENT PRIMARY KEY,
  classAnimal VARCHAR(45) NOT NULL
);

-- Вставка данных в таблицу Animals
INSERT INTO Animals (classAnimal) VALUES
('Pets'),
('PackAnimals');

-- Создание таблицы Pets
CREATE TABLE IF NOT EXISTS Pets (
  id INT AUTO_INCREMENT PRIMARY KEY,
  classAnimal VARCHAR(45) NOT NULL,
  typeAnimal VARCHAR(45) NOT NULL
);

-- Вставка данных в таблицу Pets
INSERT INTO Pets (classAnimal, typeAnimal) VALUES
('Pets', 'Dog'),
('Pets', 'Cat'),
('Pets', 'Hamster');

-- Создание таблицы PackAnimals
CREATE TABLE IF NOT EXISTS PackAnimals (
  id INT AUTO_INCREMENT PRIMARY KEY,
  classAnimal VARCHAR(45) NOT NULL,
  typeAnimal VARCHAR(45) NOT NULL
);

-- Вставка данных в таблицу PackAnimals
INSERT INTO PackAnimals (classAnimal, typeAnimal) VALUES
('PackAnimals', 'Horse'),
('PackAnimals', 'Camel'),
('PackAnimals', 'Donkey');

-- Создание таблиц Dog
CREATE TABLE IF NOT EXISTS Dog (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nameAnimal VARCHAR(45) NOT NULL,
  typeAnimal VARCHAR(45) NOT NULL,
  BirthDate DATE NOT NULL,
  Commands TEXT
);

-- Вставка данных в таблицу Dog
INSERT INTO Dog (nameAnimal, typeAnimal, BirthDate, Commands) VALUES
('Fido', 'Dog', '2020-01-01', 'Sit, Stay, Fetch'),
('Buddy', 'Dog', '2018-12-10', 'Sit, Paw, Bark'),
('Bella', 'Dog', '2019-11-11', 'Sit, Stay, Roll');

-- Создание таблиц Cat
CREATE TABLE IF NOT EXISTS Cat (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nameAnimal VARCHAR(45) NOT NULL,
  typeAnimal VARCHAR(45) NOT NULL,
  BirthDate DATE NOT NULL,
  Commands TEXT
);

-- Вставка данных в таблицу Cat
INSERT INTO Cat (nameAnimal, typeAnimal, BirthDate, Commands) VALUES
('Whiskers', 'Cat', '2019-05-15', 'Sit, Pounce'),
('Smudge', 'Cat', '2020-02-20', 'Sit, Pounce, Scratch'),
('Oliver', 'Cat', '2020-06-30', 'Meow, Scratch, Jump');

-- Создание таблиц Hamster
CREATE TABLE IF NOT EXISTS Hamster (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nameAnimal VARCHAR(45) NOT NULL,
  typeAnimal VARCHAR(45) NOT NULL,
  BirthDate DATE NOT NULL,
  Commands TEXT
);

-- Вставка данных в таблицу Hamster
INSERT INTO Hamster (nameAnimal, typeAnimal, BirthDate, Commands) VALUES
('Hammy', 'Hamster', '2021-03-03', 'Roll, Hide'),
('Peanut', 'Hamster', '2021-08-01', 'Roll, Spin');


-- Создание таблиц Horse
DROP TABLE IF EXISTS Horse;
CREATE TABLE Horse (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nameAnimal VARCHAR(45) NOT NULL,
  typeAnimal VARCHAR(45) NOT NULL,
  BirthDate DATE NOT NULL,
  Commands TEXT
);

-- Вставка данных в таблицу Horse
INSERT INTO Horse (nameAnimal, typeAnimal, BirthDate, Commands) VALUES
('Thunder', 'Horse', '2015-07-21', 'Trot, Canter, Gallop'),
('Storm', 'Horse', '2014-05-05', 'Trot, Canter'),
('Blaze', 'Horse', '2016-02-29', 'Trot, Jump, Gallop');

-- Создание таблиц Camel
DROP TABLE IF EXISTS Camel;
CREATE TABLE Camel (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nameAnimal VARCHAR(45) NOT NULL,
  typeAnimal VARCHAR(45) NOT NULL,
  BirthDate DATE NOT NULL,
  Commands TEXT
);

-- Вставка данных в таблицу Camel
INSERT INTO Camel (nameAnimal, typeAnimal, BirthDate, Commands) VALUES
('Sandy', 'Camel', '2016-11-03', 'Walk, Carry Load'),
('Dune', 'Camel', '2018-12-12', 'Walk, Sit'),
('Sahara', 'Camel', '2015-08-14', 'Walk, Run');


-- Создание таблиц Donkey
DROP TABLE IF EXISTS Donkey;
CREATE TABLE Donkey (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nameAnimal VARCHAR(45) NOT NULL,
  typeAnimal VARCHAR(45) NOT NULL,
  BirthDate DATE NOT NULL,
  Commands TEXT
);

-- Вставка данных в таблицу Donkey
INSERT INTO Donkey (nameAnimal, typeAnimal, BirthDate, Commands) VALUES
('Eeyore', 'Donkey', '2017-09-18', 'Walk, Carry Load, Bray'),
('Burro', 'Donkey', '2019-01-23', 'Walk, Bray, Kick');



/** 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу. **/

DELETE FROM Camel
WHERE typeAnimal = 'Camel';

CREATE TABLE IF NOT EXISTS HorseAndDonkey AS
SELECT * FROM Horse
UNION
SELECT * FROM Donkey;


/** 11.Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице **/

CREATE TABLE IF NOT EXISTS YoungAnimals AS
SELECT * FROM Dog
WHERE TIMESTAMPDIFF(MONTH, BirthDate, NOW()) > 12 AND TIMESTAMPDIFF(MONTH, BirthDate, NOW()) < 36
UNION
SELECT * FROM Cat
WHERE TIMESTAMPDIFF(MONTH, BirthDate, NOW()) > 12 AND TIMESTAMPDIFF(MONTH, BirthDate, NOW()) < 36
UNION
SELECT * FROM Hamster
WHERE TIMESTAMPDIFF(MONTH, BirthDate, NOW()) > 12 AND TIMESTAMPDIFF(MONTH, BirthDate, NOW()) < 36
UNION
SELECT * FROM Horse
WHERE TIMESTAMPDIFF(MONTH, BirthDate, NOW()) > 12 AND TIMESTAMPDIFF(MONTH, BirthDate, NOW()) < 36
UNION
SELECT * FROM Donkey
WHERE TIMESTAMPDIFF(MONTH, BirthDate, NOW()) > 12 AND TIMESTAMPDIFF(MONTH, BirthDate, NOW()) < 36;

SELECT *, TIMESTAMPDIFF(MONTH, BirthDate, NOW()) AS AgeMonth FROM YoungAnimals;



/** 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам. **/

CREATE TABLE IF NOT EXISTS AllTypes AS
SELECT * FROM Pets
UNION
SELECT * FROM PackAnimals;

SELECT * FROM AllTypes;

CREATE TABLE IF NOT EXISTS AllAnimals AS
SELECT * FROM Dog
UNION
SELECT * FROM Cat
UNION
SELECT * FROM Hamster
UNION
SELECT * FROM Horse
UNION
SELECT * FROM Camel
UNION
SELECT * FROM Donkey;

SELECT * FROM AllAnimals
RIGHT JOIN AllTypes
ON AllAnimals.typeAnimal = AllTypes.typeAnimal;
