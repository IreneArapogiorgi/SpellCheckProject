/*dictionary is a schema created in the schemas section.. 
-----  create schema `dictionary` default CHAR SET utf8;  ----*/
use dictionary;
DROP table IF EXISTS `greekwords`;
CREATE TABLE greekwords (
	 id int auto_increment,
     words varchar(27) NOT NULL,
     length int,
     PRIMARY KEY (id)
); 

/* drop index WordIndex ON GreekWords; */
LOAD DATA LOCAL INFILE 'C:/Users/georg/Desktop/Working Dictionaries/greekdictionary.txt' INTO TABLE greekwords
CHARACTER SET utf8
FIELDS TERMINATED BY '\t'
LINES TERMINATED BY '\n'(words, length);
CREATE INDEX  WordIndex ON GreekWords (length,words);

/*procedure existsindictionary searches the dictionary in 
order to check the spelling of the word given when called, 
and returns the id of the given word*/
DROP procedure IF EXISTS `existsindictionary`;
DELIMITER $$
USE `dictionary`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `existsindictionary`(IN word varchar(27))
BEGIN
	declare wlen int;
	SET wlen = CHAR_LENGTH(word);
	SELECT id 
    FROM greekwords
    WHERE wlen = length and binary word =words ;
END$$
DELIMITER ;

/*function levesteindist returns the levenstein distance of two strings
acccording to the relative levenshtein distance algorithm*/
DELIMITER $$
DROP FUNCTION IF EXISTS levenshteindist $$
USE `dictionary`$$
CREATE FUNCTION levenshteindist(w1 VARCHAR(27), w2 VARCHAR(27))
  RETURNS INT
  DETERMINISTIC
  BEGIN
    DECLARE w1len, w2len, d, i, j, temp, cost INT;
    DECLARE w1char CHAR;
    DECLARE cv0, cv1 VARBINARY(28);
    SET w1len = CHAR_LENGTH(w1),
        w2len = CHAR_LENGTH(w2),
        j = 1,
        i = 1,
        d = 0;
    WHILE (j <= w2len) DO
      SET cv1 = CONCAT(cv1, CHAR(j)),
          j = j + 1;
    END WHILE;
    WHILE (i <= w1len) DO
      SET w1char = SUBSTRING(w1, i, 1),
          d = i,
          cv0 = CHAR(i),
          j = 1;
      WHILE (j <= w2len) DO
        SET d = d + 1,
            cost = IF(w1char = SUBSTRING(w2, j, 1), 0, 1);
        SET temp = ORD(SUBSTRING(cv1, j, 1)) + cost;
        IF (d > temp) THEN
          SET d = temp;
        END IF;
        SET temp = ORD(SUBSTRING(cv1, j+1, 1)) + 1;
        IF (d > temp) THEN
          SET d = temp;
        END IF;
        SET cv0 = CONCAT(cv0, CHAR(d)),
            j = j + 1;
      END WHILE;
      SET cv1 = cv0,
          i = i + 1;
    END WHILE;
    RETURN (d);
  END $$
DELIMITER ;

/*procedure findsuggestions returns the three closer suggestions
 to the word given when called using the levenshteindist fuction
 that was created above*/
drop procedure IF EXISTS `findsuggestions`;
DELIMITER $$
USE `dictionary`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `findsuggestions`(IN word varchar(28))
BEGIN
declare wlen int;
SET wlen = CHAR_LENGTH(word);
select words  
from greekwords
where  length = wlen
order by levenshteindist(word, words)
limit 1,3;
END$$
DELIMITER ; 