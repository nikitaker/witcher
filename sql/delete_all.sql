drop table if exists MonsterType,
                     Armor,
                     Sword,
                     Potion,
                     Oil,
                     Monster,
                     Shop,
                     QuestGiver,
                     Location,
                     Witcher,
                     Board;
                     
CREATE TABLE MonsterType
(
    typeId SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);
CREATE TABLE Armor
(
    armorName TEXT PRIMARY KEY,
    price INT NOT NULL CHECK (price > 0),
    prot INT NOT NULL CHECK (prot > 0)
);
CREATE TABLE Sword
(
    swordName TEXT PRIMARY KEY,
    price INT NOT NULL CHECK (price > 0),
    atack INT NOT NULL CHECK (atack > 0)
);
CREATE TABLE Potion
(
    potionName TEXT PRIMARY KEY,
    price INT NOT NULL CHECK (price > 0),
    prot INT NOT NULL CHECK (prot > 0),
    typeId SMALLINT REFERENCES MonsterType on delete cascade on update cascade
);
CREATE TABLE Oil
(
    oilName TEXT PRIMARY KEY,
    price INT NOT NULL CHECK (price > 0),
    atack INT NOT NULL CHECK (atack > 0),
    typeId SMALLINT REFERENCES MonsterType on delete cascade on update cascade
);
CREATE TABLE Monster
(
    monsterName TEXT PRIMARY KEY,
    type_id SMALLINT REFERENCES,
    color TEXT,
    height INT CHECK (height > 0 and height < 500),
    armsNum SMALLINT CHECK (armsNum > 0 and armsNum < 20),
    atack INT NOT NULL CHECK (atack > 0),
    health INT NOT NULL
);
CREATE TABLE Shop
(
    shopId  SERIAL PRIMARY KEY,
    name TEXT,
    type TEXT,
    markup INT
);
CREATE TABLE QuestGiver
(
    questGiver TEXT PRIMARY KEY,
    monsterName TEXT REFERENCES Monster on delete cascade on update cascade,
    startPrice INT NOT NULL CHECK (startPrice > 0),
    money INT NOT NULL CHECK (money > 0),
    charisma INT NOT NULL
);
CREATE TABLE Location
(
    locationName TEXT PRIMARY KEY,
    country TEXT NOT NULL,
    questGiver TEXT REFERENCES QuestGiver on delete cascade on update cascade,
    shopId INT REFERENCES Shop
);
CREATE TABLE Witcher
(
    witcherName TEXT PRIMARY KEY,
    armorName TEXT NOT NULL REFERENCES Armor on delete cascade on update cascade,
    swordName TEXT NOT NULL REFERENCES Sword on delete cascade on update cascade,
    potionName TEXT REFERENCES Potion on delete cascade on update cascade,
    oilName TEXT REFERENCES Oil on delete cascade on update cascade,
    health INT NOT NULL,
    money INT NOT NULL,
    charisma INT NOT NULL,
    locationName TEXT REFERENCES Location
);
CREATE TABLE Board
(
    boardId  SERIAL PRIMARY KEY,
    witcherName TEXT NOT NULL REFERENCES Witcher,
    monsterName TEXT NOT NULL REFERENCES Monster,
    price INT NOT NULL CHECK (price > 0),
    questGiver TEXT NOT NULL REFERENCES QuestGiver
);

insert into MonsterType values (1, 'Vampire');
insert into MonsterType values (2, 'Goul');
insert into MonsterType values (3, 'Ghost');

insert into Armor values ('Chest1', 10, 20);
insert into Armor values ('Chest2', 20, 30);
insert into Armor values ('Chest3', 30, 40);

insert into Sword values ('Sword1', 10, 20);
insert into Sword values ('Sword2', 20, 30);
insert into Sword values ('Sword3', 30, 40);

insert into Potion values ('Potion1', 10, 20, 1);
insert into Potion values ('Potion2', 20, 30, 2);
insert into Potion values ('Potion3', 30, 40, 3);

insert into Oil values ('Oil1', 10, 20, 1);
insert into Oil values ('Oil2', 20, 30, 2);
insert into Oil values ('Oil3', 30, 40, 3);

insert into Monster values ('Monster1', 1, 'Red', 20, 4, 10, 10);
insert into Monster values ('Monster2', 2, 'White', 20, 4, 20, 10);
insert into Monster values ('Monster3', 3, 'Red', 20, 4, 10, 30);

insert into Shop values (1, 'Sword1', 'Sword', 5);
insert into Shop values (2, 'Chest2', 'Armor', 10);
insert into Shop values (3, 'Oil3', 'Oil', 10);

insert into QuestGiver values ('Semen', 'Monster1', 10, 1000, 3);
insert into QuestGiver values ('Vika', 'Monster1', 20, 1000, 3);
insert into QuestGiver values ('L', 'Monster2', 10, 1000, 3);

insert into Location values ('Mid', 'Temeria', 'Vika', 1);
insert into Location values ('Up', 'Temeria', 'Vika', 1);
insert into Location values ('Bot', 'Nig');

insert into Witcher values ('Boris', 'Chest2', 'Sword3', 'Potion3', 'Oil2', 100, 20, 5, 'Up');
insert into Witcher values ('Viktor', 'Chest2', 'Sword3', 'Potion3', 'Oil2', 100, 20, 5, 'Bot');
insert into Witcher values ('Sasha', 'Chest1', 'Sword1', 'Potion1', 'Oil1', 100, 20, 5, 'Up');

insert into Board values (default, 'Viktor', 'Monster2', 22, 'Vika');
insert into Board values (default, 'Sasha', 'Monster2', 22, 'Vika');
insert into Board values (default, 'Sasha', 'Monster1', 22, 'L');

