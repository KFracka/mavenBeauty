create database WiezienieDB
go

create table Wiezien(
PESEL numeric(11) primary key,
imie varchar(25),
nazwisko varchar(25),
dataUrodzenia date,
plec bit
)

create table Wiezienie(
nazwaOddzialu varchar(30) primary key,
numerOddzialu numeric(5)
-- wypisani Wiezniowie
-- iloscWiezinow
)

create table Psycholog(
idPsychologa numeric(10) primary key,
haslo varchar(25),
imie varchar(25),
nazwisko varchar(25),
specjalizacja varchar(25),
nazwaOddzialu varchar(30), foreign key (nazwaOddzialu) references Wiezienie(nazwaOddzialu)
)

create table HistoriaTerapii(
id numeric(20) primary key,
PESEL numeric(11), foreign key (PESEL) references Wiezien(pesel),
choroba varchar(40),
dataPrzyjecia date,
dataWypisu date,
idPsychologa numeric(10), foreign key (idPsychologa) references Psycholog(idPsychologa),
nazwaOddzialu varchar(30), foreign key (nazwaOddzialu) references Wiezienie(nazwaOddzialu)
)

insert into Wiezienie values
('Traumy', 1),
('Grupowa', 2),
('Uzaleznienia', 3),
('Fobie', 4),
('Dewiacje', 5)

insert into Psycholog values 
(11541, '193haslo', 'Beata', 'Nowakowska', 'Więzienny', 'Fobie'),
(71419, 'haselko', 'Marian', 'Kowalczyk', 'Resocjalizacyjny', 'Grupowa'),
(97241, 'mojehaselko', 'Katarzyna', 'Filipczak', 'Seksuolog', 'Dewiacje'),
(51714, 'hasielko', 'Norbert', 'Majewski', 'Resocjalizacyjny', 'Grupowa'),
(54561, 'haseleczko', 'Dawid', 'Norbert','Więzienny', 'Fobie'),
(17456, 'trudnehaslo', 'Wiesław', 'Baletek', 'Sądowy', 'Uzaleznienia'),
(66690, 'has193lo', 'Kazimierz', 'Kazimierski','Sądowy', 'Grupowa'),
(11968, '193haslo193' , 'Sylwester', 'Nowobramski', 'Seksuolog', 'Dewiacje')

insert into Wiezien values 
(80223000020,'Anita','Konar','2000-03-22',1),
(08200228002,'Łukasz','Jarema','2008-02-20',1),
(02800280002,'Beata','Luft','2002-01-08',1),
(02800002820,'Kamil','Mikulski','2002-02-23',1),
(03028220083,'Mateusz','Kanał','2003-02-01',1),
(00223082202,'Bartosz','Bąbul','2000-02-02',1),
(00203200020,'Rafał','Walczak','2000-01-22',1),
(00380020280,'Jan','Norwid','2000-01-03',1),
(00020200002,'Patryk','Borek','2000-02-01',1),
(80222022800,'Grzegorz','Płuniewski','2000-12-20',1),
(02223388000,'Andrzej','Chowak','2002-12-22',1),
(00223000830,'Monika','Tyrol','2000-02-02',1),
(02308022002,'Karol','Wilczek','2002-03-20',1),
(00020200282,'Artur','Robak','2000-02-01',1)
