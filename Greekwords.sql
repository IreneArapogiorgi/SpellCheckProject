/*Drop table greekwords; */
/*javadics is a schema i created in the schemas section.. 
you can use any of the default schemas(sakila,sys or world) */
use javadics;
CREATE TABLE greekwords (
     id int auto_increment,
     words varchar(30) NOT NULL,
     length int,
     PRIMARY KEY (id)
);
LOAD DATA LOCAL INFILE 'C:/Users/georg/Desktop/Working Dictionaries/greek-dicupdated.txt' INTO TABLE greekwords
FIELDS TERMINATED BY '\t'
LINES TERMINATED BY '\n'(words, length);

select * from greekwords;



