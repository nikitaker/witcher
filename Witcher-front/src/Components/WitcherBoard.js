import React from 'react';
import {BrowserRouter, Link, Route, Switch} from "react-router-dom";
import Witchers from "./Witchers";
import Battle from "./Battle";

class WitcherBoard extends React.Component {


    render() {
        return(
            <div>
                <BrowserRouter>
                    <div>
                        <p style={{display : "inline-block", marginRight : "10px"}}>
                            <Link to='/witchers'>Ведьмаки</Link>
                        </p>
                        <p style={{display : "inline-block", marginRight : "10px"}}>
                            <Link to='/battle'>Сражение</Link>
                        </p>

                    </div>
                    <Switch>
                        <Route path='/witchers' render={(props) => (<Witchers/>)}/>
                        <Route path='/battle' render={(props) => (<Battle/>)}/>
                    </Switch>
                </BrowserRouter>
            </div>
        );
    }
}
export default WitcherBoard;