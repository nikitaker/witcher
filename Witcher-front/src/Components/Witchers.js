import React from 'react';
import {BrowserRouter, Link, Route, Switch} from "react-router-dom";
import Witcher from "./Witcher";

class Witchers extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            data : [],
            name : ""
        };
    }

    componentDidMount() {
        fetch("http://localhost:8080/witcher")
            .then(res => res.json())
            .then(response => {
                this.setState({data : response})
            });
    }


    render() {
        return(
            <div>
                <BrowserRouter>
                    <Switch>
                        <Route path='/witchers' render={(props) => <Witcher array={this.state.data} name={this.state.name} /> }/>
                    </Switch>
                </BrowserRouter>
            </div>
        );
    }

}

export default Witchers;