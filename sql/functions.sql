create or replace function emptyLocation() returns trigger as
$$
begin
    if new.shopid is NULL and new.questgiver is NULL
        then
        new.locationname = concat(text('useless '),new.locationname);
    end if;
    return new;
end;
$$
language plpgsql;

create trigger checkLocation
    before insert or update
    on location FOR EACH ROW
execute procedure emptyLocation();

create or replace function makeDeal(witcherNameIn text, questgiverName text) returns int as
$$
DECLARE
    witcherCharisma int;
    questgiverCharisma int;
    price int;
    maxprice int;
    finalprice int;
    monster text;
begin
    select charisma into witcherCharisma from witcher where witcher.witchername = witcherNameIn;
    select charisma into questgiverCharisma from questgiver where questgiver.questgiver = questgiverName;
    select startprice into price from questgiver where questgiver.questgiver = questgiverName;
    select money into maxprice from questgiver where questgiver.questgiver = questgiverName;
    select monstername into monster from questgiver where questgiver.questgiver = questgiverName;

    if witcherCharisma < questgiverCharisma then finalprice = price;
    end if;
    if witcherCharisma = questgiverCharisma then
        finalprice = price;
        update witcher set charisma = charisma + 1 where witchername = witcherNameIn;
    end if;
    if witcherCharisma > questgiverCharisma then
        finalprice = price * (witcherCharisma/questgiverCharisma);
        if finalprice > maxprice then finalprice = maxprice; end if;
        update witcher set charisma = charisma + 1 where witchername = witcherNameIn;
    end if;

    insert into board values (default, witcherNameIn, monster, finalprice, questgiverName);
    return finalprice;
end;
$$
language plpgsql;

create or replace function battle(witcherNameIn text, monsterNameIn text) returns text as
$$
DECLARE
    witcherHealth int;
    witcherAttack int;
    witcherAttackTemp int;
    witcherDefence int;
    witcherDefenceTemp int;
    attackType int;
    defenceType int;
    monsterType int;
    monsterHealth int;
    monsterAttack int;
begin
    select health into witcherHealth from witcher where witcher.witchername = witcherNameIn;
    select atack into witcherAttack from witcher join sword s on witcher.swordname = s.swordname where witcher.witchername = witcherNameIn;
    select prot into witcherDefence from witcher join armor a on a.armorname = witcher.armorname where witcher.witchername = witcherNameIn;
    select atack into witcherAttackTemp from witcher join oil o on witcher.oilname = o.oilname where witcher.witchername = witcherNameIn;
    select prot into witcherDefenceTemp from witcher join potion p on witcher.potionname = p.potionname where witcher.witchername = witcherNameIn;
    select typeid into attackType from witcher join oil o on witcher.oilname = o.oilname where witcher.witchername = witcherNameIn;
    select typeid into defenceType from witcher join potion p on witcher.potionname = p.potionname where witcher.witchername = witcherNameIn;
    select health into monsterHealth from monster where monster.monstername = monsterNameIn;
    select atack into monsterAttack from monster where monster.monstername = monsterNameIn;
    select type_id into monsterType from monster where monster.monstername = monsterNameIn;

    if attackType = monsterType then witcherAttack = witcherAttack + witcherAttackTemp; end if;
    if defenceType = monsterType then witcherDefence = witcherDefence + witcherDefenceTemp; end if;
    if monsterAttack - witcherDefence <= 0 then monsterAttack = 0;
    else monsterAttack = monsterAttack - witcherDefence; end if;

    while (witcherHealth > 0 and monsterHealth > 0) loop
            witcherHealth = witcherHealth - monsterAttack;
            monsterHealth = monsterHealth - witcherAttack;
    end loop;

    update witcher set health=witcherHealth where witcher.witchername = witcherNameIn;

    if EXISTS(select * from board where witchername=witcherNameIn and monstername=monsterNameIn) then
        update witcher set
        money=money+(select sum(price) from board where witchername=witcherNameIn and monstername=monsterNameIn)
        where witcher.witchername = witcherNameIn;
    end if;

    update monster set health=monsterHealth where monster.monstername = monsterNameIn;


    if witcherHealth > 0 then return 'Победил ведьмак';
    else return 'Ведьмак умер'; end if;

end;
$$
language plpgsql;

SELECT battle('Sasha','Monster2');

--проверить здоровье (тригер)
create or replace function zeroHealthWitcher() returns trigger as
$$
begin
    if new.health <= 0
        then
        delete from board where witchername = new.witchername;
        delete from witcher where witchername = new.witchername;
        return null;
    end if;
    return new;
end;
$$
language plpgsql;

create trigger zeroHealthWitcher
    before insert or update
    on witcher FOR EACH ROW
execute procedure zeroHealthWitcher();


create or replace function zeroHealthMonster() returns trigger as
$$
begin
    if new.health <= 0
        then
        delete from board where board.monstername = new.monstername;
        return null;
    end if;
    return new;
end;
$$
language plpgsql;

create trigger zeroHealthMonster
    before insert or update
    on monster FOR EACH ROW
execute procedure zeroHealthMonster();



