/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     05/01/2023 01:44:16                          */
/*==============================================================*/


drop table if exists APPARTEMENT;

drop table if exists AVOCAT;

drop table if exists CLIENT;

drop table if exists CONTRAT;

drop table if exists DESISTEMENT;

drop table if exists DIRECTEUR;

drop table if exists IMMEUBLE;

drop table if exists PROCESVERBAL;

drop table if exists PROMESSE;

drop table if exists SOCIETE;

drop table if exists VISITER;

/*==============================================================*/
/* Table: APPARTEMENT                                           */
/*==============================================================*/
create table APPARTEMENT
(
   IDAPPARTEMENT        int not null,
   IDIMMEUBLE           int,
   NUMERO               int not null,
   SUPERFICIE           float not null,
   PRIX_PREVISIONNEL    float not null,
   NBRE_CHAMBRE         int not null,
   primary key (IDAPPARTEMENT)
);

/*==============================================================*/
/* Table: AVOCAT                                                */
/*==============================================================*/
create table AVOCAT
(
   IDAVOCAT             int not null,
   NOMA                 varchar(191) not null,
   PRENOMA              varchar(191) not null,
   ADRESSAA             varchar(191) not null,
   TELEPHONEA           varchar(191) not null,
   NUMEROAUTORISATION   varchar(191) not null,
   primary key (IDAVOCAT)
);

/*==============================================================*/
/* Table: CLIENT                                                */
/*==============================================================*/
create table CLIENT
(
   IDCLIENT             int not null,
   NUMERO_CNI           varchar(191) not null,
   NOM                  varchar(191) not null,
   PRENOM               varchar(191) not null,
   ADRESSEC             varchar(191) not null,
   TELEPHONE            varchar(191) not null,
   PROFESSION           varchar(191) not null,
   primary key (IDCLIENT)
);

/*==============================================================*/
/* Table: CONTRAT                                               */
/*==============================================================*/
create table CONTRAT
(
   IDCONTRAT            int not null,
   IDDIRECTEUR          int,
   IDCLIENT             int,
   IDAPPARTEMENT        int,
   TYPEPAIEMENT         varchar(191) not null,
   DATESIGNATURE        date not null,
   primary key (IDCONTRAT)
);

/*==============================================================*/
/* Table: DESISTEMENT                                           */
/*==============================================================*/
create table DESISTEMENT
(
   IDDESISTEMENT        int not null,
   IDPROMESSE           int,
   IDDIRECTEUR          int,
   IDCLIENT             int,
   IDAVOCAT             int,
   NUMERO               int not null,
   DATE                 date not null,
   CAUSES               text not null,
   ISVALIDER            bool not null,
   primary key (IDDESISTEMENT)
);

/*==============================================================*/
/* Table: DIRECTEUR                                             */
/*==============================================================*/
create table DIRECTEUR
(
   IDDIRECTEUR          int not null,
   IDSOCIETE            int not null,
   NOMDIRECTEUR         varchar(191) not null,
   primary key (IDDIRECTEUR)
);

/*==============================================================*/
/* Table: IMMEUBLE                                              */
/*==============================================================*/
create table IMMEUBLE
(
   IDIMMEUBLE           int not null,
   IDSOCIETE            int not null,
   ADRESSE              varchar(191) not null,
   NOMIMMEUBLE          varchar(191) not null,
   primary key (IDIMMEUBLE)
);

/*==============================================================*/
/* Table: PROCESVERBAL                                          */
/*==============================================================*/
create table PROCESVERBAL
(
   IDPROCESVERBAL       int not null,
   IDDIRECTEUR          int,
   IDCLIENT             int,
   DATEREMISE           date,
   primary key (IDPROCESVERBAL)
);

/*==============================================================*/
/* Table: PROMESSE                                              */
/*==============================================================*/
create table PROMESSE
(
   IDAPPARTEMENT        int not null,
   IDCLIENT             int not null,
   IDAVOCAT             int,
   IDDIRECTEUR          int,
   STATUT               bool not null,
   ISSIGNER             bool not null,
   DATESIGNATURE        date not null,
   IDPROMESSE           int not null,
   PRIX_VENTE           float not null,
   AVANCE               float not null,
   primary key (IDPROMESSE)
);

/*==============================================================*/
/* Table: SOCIETE                                               */
/*==============================================================*/
create table SOCIETE
(
   IDSOCIETE            int not null,
   NOMSOCIETE           varchar(191) not null,
   primary key (IDSOCIETE)
);

/*==============================================================*/
/* Table: VISITER                                               */
/*==============================================================*/
create table VISITER
(
   IDAPPARTEMENT        int not null,
   IDCLIENT             int not null,
   DATEVISITE           date not null,
   REMARQUES            text not null,
   IDVISITER            int not null,
   primary key (IDVISITER)
);

alter table APPARTEMENT add constraint FK_RELATIONSHIP_7 foreign key (IDIMMEUBLE)
      references IMMEUBLE (IDIMMEUBLE) on delete restrict on update restrict;

alter table CONTRAT add constraint FK_RELATIONSHIP_11 foreign key (IDDIRECTEUR)
      references DIRECTEUR (IDDIRECTEUR) on delete restrict on update restrict;

alter table CONTRAT add constraint FK_RELATIONSHIP_12 foreign key (IDCLIENT)
      references CLIENT (IDCLIENT) on delete restrict on update restrict;

alter table CONTRAT add constraint FK_RELATIONSHIP_13 foreign key (IDAPPARTEMENT)
      references APPARTEMENT (IDAPPARTEMENT) on delete restrict on update restrict;

alter table DESISTEMENT add constraint FK_RELATIONSHIP_10 foreign key (IDPROMESSE)
      references PROMESSE (IDPROMESSE) on delete restrict on update restrict;

alter table DESISTEMENT add constraint FK_RELATIONSHIP_16 foreign key (IDDIRECTEUR)
      references DIRECTEUR (IDDIRECTEUR) on delete restrict on update restrict;

alter table DESISTEMENT add constraint FK_RELATIONSHIP_17 foreign key (IDCLIENT)
      references CLIENT (IDCLIENT) on delete restrict on update restrict;

alter table DESISTEMENT add constraint FK_RELATIONSHIP_18 foreign key (IDAVOCAT)
      references AVOCAT (IDAVOCAT) on delete restrict on update restrict;

alter table DIRECTEUR add constraint FK_ASSOCIATION_1 foreign key (IDSOCIETE)
      references SOCIETE (IDSOCIETE) on delete restrict on update restrict;

alter table IMMEUBLE add constraint FK_ASSOCIATION_2 foreign key (IDSOCIETE)
      references SOCIETE (IDSOCIETE) on delete restrict on update restrict;

alter table PROCESVERBAL add constraint FK_RELATIONSHIP_14 foreign key (IDDIRECTEUR)
      references DIRECTEUR (IDDIRECTEUR) on delete restrict on update restrict;

alter table PROCESVERBAL add constraint FK_RELATIONSHIP_15 foreign key (IDCLIENT)
      references CLIENT (IDCLIENT) on delete restrict on update restrict;

alter table PROMESSE add constraint FK_PROMESSE foreign key (IDCLIENT)
      references CLIENT (IDCLIENT) on delete restrict on update restrict;

alter table PROMESSE add constraint FK_PROMESSE2 foreign key (IDAPPARTEMENT)
      references APPARTEMENT (IDAPPARTEMENT) on delete restrict on update restrict;

alter table PROMESSE add constraint FK_RELATIONSHIP_8 foreign key (IDAVOCAT)
      references AVOCAT (IDAVOCAT) on delete restrict on update restrict;

alter table PROMESSE add constraint FK_RELATIONSHIP_9 foreign key (IDDIRECTEUR)
      references DIRECTEUR (IDDIRECTEUR) on delete restrict on update restrict;

alter table VISITER add constraint FK_VISITER foreign key (IDCLIENT)
      references CLIENT (IDCLIENT) on delete restrict on update restrict;

alter table VISITER add constraint FK_VISITER2 foreign key (IDAPPARTEMENT)
      references APPARTEMENT (IDAPPARTEMENT) on delete restrict on update restrict;

