drop table if exists ChiffreAffaire,Achat,Location,MotClefVideo,MotClef, CompoVideo,CompoClient,CategorieVideo,CategorieClient, Video,Client CASCADE;
create table Client (
	idClient integer Primary Key,
	nomCLient varchar(20) not null,
	prenomCLient varchar(20) not null,
    pseudo varchar(20)not null,
    mdp varchar(20)not null,
	email varchar(20) not null
);

create table Video(
	idVideo integer Primary Key,
	nomVideo varchar(20) not null,
    groupeVideo varchar(20),
    numEpisode integer,
	nbvue integer not null check (nbvue>=0),
	nbtelechargement integer not null check (nbtelechargement>=0),
	prixAchat double not null check (prixAchat > 0),
	prixLocation double not null check (prixLocation > 0)
);

create table CategorieClient (
	idCategorieClient integer primary key,
	nomCategorieClient varchar(20)	not null
);

create table CategorieVideo(
	idCategorieVideo integer primary key,
	nomCategorieVideo varchar(20) not null
);

create table CompoClient (
	idClient integer references Client,
	idCategorieClient integer references CategorieClient,
	PRIMARY KEY (idClient,idCategorieClient)
);

create table CompoVideo (
	idVideo integer references Video (idVideo),
	idCategorieVideo integer references CategorieVideo,
	PRIMARY KEY (idVideo,idCategorieVideo)		
);

create table MotClef (
	idMotClef integer PRIMARY KEY,
	valeurMotClef varchar(20) not null
);

create table MotClefVideo (
	idVideo integer references Video,
	idMotClef integer references MotClef
);

create table Location (
	idClient integer references Client,
	idVideo integer references Video,
	datedebut date not null,
	datefin date not null
);
create table Achat (
	idClient integer references Client,
	idVideo integer references Video
);

create table ChiffreAffaire(
	idCA integer,
	dateCA date ,
	valeurCA integer not null check (valeurCA >=0),
	PRIMARY KEY (idCA,dateCA)
);

