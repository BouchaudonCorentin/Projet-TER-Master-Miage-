drop table if exists ChiffreAffaire,Achat,Location,MotClefFilm,MotClef, CompoFilm,CompoClient,CategorieFilm,CategorieClient, Film,Client CASCADE;
create table Client (
	idClient integer Primary Key,
	nomCLient varchar(20) not null,
	prenomCLient varchar(20) not null,
	email varchar(20) not null
);

create table Film(
	idFilm integer Primary Key,
	nomFilm varchar(20) not null,
	nbvue integer not null,
	nbtelechargement integer not null,
	prixAchat double not null,
	prixLocation double not null
);

create table CategorieClient (
	idCategorieClient integer primary key,
	nomCategorieClient varchar(20)	not null
);

create table CategorieFilm(
	idCategorieFilm integer primary key,
	nomCategorieFilm varchar(20) not null
);

create table CompoClient (
	idClient integer references Client,
	idCategorieClient integer references CategorieClient,
	PRIMARY KEY (idClient,idCategorieClient)
);

create table CompoFilm (
	idFilm integer references Film (idFilm),
	idCategorieFilm integer references CategorieFilm,
	nbepisode integer null,
	PRIMARY KEY (idFilm,idCategorieFilm)		
);

create table MotClef (
	idMotClef integer PRIMARY KEY,
	valeurMotClef varchar(20) not null
);

create table MotClefFilm (
	idFilm integer references Film,
	idMotClef integer references MotClef
);

create table Location (
	idClient integer references Client,
	idFilm integer references Film,
	datedebut date not null,
	datefin date not null
);
create table Achat (
	idClient integer references Client,
	idFilm integer references Film
);

create table ChiffreAffaire(
	idCA integer,
	dateCA date ,
	valeurCA integer not null,
	PRIMARY KEY (idCA,dateCA)
);

