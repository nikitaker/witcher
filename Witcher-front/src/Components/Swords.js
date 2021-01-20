import React from 'react';
import {BrowserRouter, Link, Route, Switch} from "react-router-dom";
import Sword from "./Sword";

class Swords extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            data : [],
            name : ""
        };
    }

    componentDidMount() {
        fetch("http://localhost:8080/sword")
            .then(res => res.json())
            .then(response => {
                this.setState({data : response})
            });
    }

    componentDidUpdate(prevProps) {
        if (prevProps.house !== this.props.house){
            fetch("http://localhost:8080/sword")
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
                        <Route path='/sword' render={(props) => <Sword array={this.state.data} name={this.state.name} /> }/>
                    </Switch>
                </BrowserRouter>
            </div>
        );
    }

}

export default Swords;