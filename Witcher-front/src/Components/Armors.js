import React from 'react';
import {BrowserRouter, Link, Route, Switch} from "react-router-dom";
import Armor from "./Armor";

class Armors extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            data : [],
            name : ""
        };
    }

    componentDidMount() {
        fetch("http://localhost:8080/armor")
            .then(res => res.json())
            .then(response => {
                this.setState({data : response})
            });
    }

    componentDidUpdate(prevProps) {
        if (prevProps.house !== this.props.house){
            fetch("http://localhost:8080/armor")
                .then(res => res.json())
                .then(response => {
                    this.setState({data : response})
                });
        }
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
                        <Route path='/armor' render={(props) => <Armor array={this.state.data} name={this.state.name} /> }/>
                    </Switch>
                </BrowserRouter>
            </div>
        );
    }

}

export default Armors;