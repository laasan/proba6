USE test;
DROP TABLE IF EXISTS part;
CREATE TABLE part(
id INT(11) NOT NULL AUTO_INCREMENT,
type varchar(255) not null,
name varchar(255) not null,
need boolean,
amount int,
PRIMARY KEY (id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
INSERT INTO part (type, name, need, amountpart) VALUES ("mon", "monitor1", true, 2),
("mon", "monitor2", true, 2),
("mon", "monitor3", true, 1),
("proc", "proc1", true, 2),
("proc", "proc2", true, 1),
("proc", "proc3", true, 1),
("proc", "proc4", true, 1),
("proc", "proc5", true, 1),
("mother", "ma1", true, 3),
("mother", "ma2", true, 10),
("mother", "ma3", true, 5),
("soundcard", "sound1", false, 2),
("soundcard", "sound2", false, 3),
("memory", "mem1", true, 10),
("memory", "mem2", true, 5),
("memory", "mem3", true, 4),
("ssd", "ssd1", true, 1),
("ssd", "ssd2", true, 2),
("ssd", "ssd3", true, 2),
("hdd", "hdd1", false, 5),
("hdd", "hdd2", false, 10),
("corpus", "tower1", true, 3),
("corpus", "tower2", true, 4),
("lights", "light1", false, 15),
("lights", "light2", false, 10)
;