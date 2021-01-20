import React from 'react';
import {BrowserRouter, Link, Route, Switch} from "react-router-dom";
import Armors from "./Armors";
import Swords from "./Swords";
import Oils from "./Oils";
import Potions from "./Potions";

class Items extends React.Component {

    render() {
        return(
            <div>
                <BrowserRouter>
                    <div>
                        <p style={{display : "inline-block", marginRight : "10px"}}>
                            <Link to='/armor'>Броня</Link>
                        </p>
                        <p style={{display : "inline-block", marginRight : "10px"}}>
                            <Link to='/sword'>Мечи</Link>
                        </p>
                        <p style={{display : "inline-block", marginRight : "10px"}}>
                            <Link to='/potion'>Зелья</Link>
                        </p>
                        <p style={{display : "inline-block", marginRight : "10px"}}>
                            <Link to='/oil'>Масла</Link>
                        </p>

                    </div>
                    <Switch>
                        <Route  path='/armor' render={(props) => (<Armors/>)}/>
                        <Route path='/sword' render={(props) => (<Swords/>)}/>
                        <Route path='/potion' render={(props) => (<Potions/>)}/>
                        <Route path='/oil' render={(props) => (<Oils/>)}/>
                    </Switch>
                </BrowserRouter>
            </div>
        );
    }
}
export default Items;