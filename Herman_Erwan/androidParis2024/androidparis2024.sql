drop database if exists androidparis2024; 
create database androidparis2024; 
use androidparis2024; 

create table user (
	iduser int(3) not null auto_increment,
	nom varchar(50), 
	prenom varchar(50), 
	email varchar(100), 
	mdp varchar(255), 
	tel varchar(20), 
	primary key (iduser)
 );

create table evenement (
	idevenement int(5) not null auto_increment,
	designation varchar(100), 
	dateEvent date, 
	heureEvent time, 
	lieu varchar(50), 
	nbPlaces int(5), 
	prix float, 
	primary key (idevenement) 
);

create table inscription (
	idinscription  int(5) not null auto_increment,
	dateinscription date , 
	statut enum("confirmee", "annulee", "autre"),
	iduser int(3) not null, 
	idevenement int(3) not null, 
	primary key (idinscription), 
	foreign key(iduser) references user(iduser),
	foreign key(idevenement) references evenement(idevenement)
);

insert into user values (null,"Lassana","Mamar","a@gmail.com", 
"123", "01010101"); 

insert into user values (null, "Che", "Anne", "b@gmail.com", 
"456", "0202020202"); 

insert into evenement values (null, "Ceremonie ouverture", 
"2024-10-10", "10:30", "Stade de France", "3000", "20"), 
(null, "Presentation equipes", 
"2024-11-11", "13:30", "Parc de Princes", "2000", "30"); 

insert into inscription values (null, "2023-10-09", 
"confirmee", 1, 1), (null, "2023-10-08", "confirmee",1,2),
 (null, "2023-11-05", "confirmee",2,2); 


create view mesEvenements as (
	select e.*, u.email from 
	evenement e, user u, inscription i 
	where i.iduser = u.iduser
	and i.idevenement = e.idevenement
);
