import React from 'react';
import {BrowserRouter, Link, Route, Switch} from "react-router-dom";
import BoardLists from "./BoardLists";
import Deal from "./Deal";


class Board extends React.Component {


    render() {
        return(
            <div>
                <BrowserRouter>
                    <div>
                        <p style={{display : "inline-block", marginRight : "10px"}}>
                            <Link to='/board'>Заключенные заказы</Link>
                        </p>
                        <p style={{display : "inline-block", marginRight : "10px"}}>
                            <Link to='/boardCreate'>Заключить заказ</Link>
                        </p>

                    </div>
                    <Switch>
                        <Route path='/board' render={(props) => (<BoardLists/>)}/>
                        <Route path='/boardCreate' render={(props) => (<Deal/>)}/>
                    </Switch>
                </BrowserRouter>
            </div>
        );
    }
}
export default Board;