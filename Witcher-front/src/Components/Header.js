import React from "react";

import {Switch, Route, Link, BrowserRouter} from "react-router-dom";
import Items from "./Items";
import Board from "./Board";
import WitcherBoard from "./WitcherBoard";
import QuestGiver from "./QuestGiver";


export const ACTION_CHANGE_HOUSE = "ACTION_CHANGE_HOUSE";
export const ACTION_CHANGE_GOLD = "ACTION_CHANGE_GOLD";
export const ACTION_CHANGE_DATA_ARMY = "ACTION_CHANGE_DATA_ARMY";
export const ACTION_CHANGE_CAPTIVE_DATA = "ACTION_CHANGE_CAPTIVE_DATA";
export const ACTION_CHANGE_ENEMY_COUNTRY = "ACTION_CHANGE_ENEMY_COUNTRY";
export const ACTION_HISTORY = "ACTION_HISTORY";
export const ACTION_CHANGE_RESERVES = "ACTION_CHANGE_RESERVES"
export const ACTION_CHANGE_FREECOUNTRY = "ACTION_CHANGE_FREECOUNTRY";
export const ACTION_CHANGE_MESSAGE = "ACTION_CHANGE_MESSAGE";

const pStyle = {
    display : "inline-block",
    marginRight : "10px"
};


class Header extends React.Component{

    render(){
        return(
            <div>
                <div>
                    <BrowserRouter>
                        <div>
                            <p style={pStyle}>
                                <Link to='/items'>Все предметы</Link>
                            </p>
                            <p style={pStyle}>
                                <Link to='/witchers'>Ведьмаки</Link>
                            </p>
                            <p style={pStyle}>
                                <Link to='/questgiver'>Заказчик</Link>
                            </p>
                            <p style={pStyle}>
                                <Link to='/board'>Доска заказов</Link>
                            </p>
                        </div>
                        <Switch>
                            <Route path='/items' render={(p) => (<Items/>)}/>
                            <Route path='/witchers' render={(p) => (<WitcherBoard/>)}/>
                            <Route path='/questgiver' render={(p) => (<QuestGiver/>)}/>
                            <Route path='/board' render={(p) => (<Board/>)}/>
                        </Switch>
                    </BrowserRouter>
                </div>
            </div>
        );
    }
}


export default Header;

