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
    type_id SMALLINT REFERENCES MonsterType,
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
