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






