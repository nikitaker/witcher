import React from 'react';
import {BrowserRouter, Link, Route, Switch} from "react-router-dom";
import Oil from "./Oil";
import BoardList from "./BoardList";

class BoardLists extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            data : [],
            name : ""
        };
    }

    componentDidMount() {
        fetch("http://localhost:8080/board")
            .then(res => res.json())
            .then(response => {
                this.setState({data : response})
            });
    }


    setName(name){
        this.setState({
            name : name
        });
    }

    render() {
        return(
            <div>
                <BrowserRouter>
                    <Switch>
                        <Route path='/board' render={(props) => <BoardList array={this.state.data} name={this.state.name} /> }/>
                    </Switch>
                </BrowserRouter>
            </div>
        );
    }

}

export default BoardLists;