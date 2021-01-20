import React from 'react';

class Batte extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            witcher : [],
            monster : [],
            deal : "",
            witcherName : "",
            monsterName : ""
        }

        this.changeWitcher = this.changeWitcher.bind(this);
        this.changeMonster = this.changeMonster.bind(this);
        this.handleOnSubmit = this.handleOnSubmit.bind(this);
    }


    componentWillMount() {
        fetch("http://localhost:8080/witcher")
            .then(res => res.json())
            .then(response => {
                this.setState({witcher : response})
            });
        fetch("http://localhost:8080/monster")
            .then(res => res.json())
            .then(response => {
                this.setState({monster : response})
            });
    }

    changeWitcher(event) {
        this.setState({
            witcherName : event.target.value
        })

    }

    changeMonster(event) {
        this.setState({
            monsterName : event.target.value
        })

    }

    handleOnSubmit(e){
        if (this.state.witcherName !== "" && this.state.monsterName !== ""){
            fetch("http://localhost:8080/battle?witcherName=" + this.state.witcherName
                + "&monsterName=" + this.state.monsterName)
                .then(res => res.text())
                .then(response => {
                    this.setState({deal : response})
                });
        }
        e.preventDefault();
    }


    render() {
        return(
            <div>
                <form onSubmit={this.handleOnSubmit}>

                    <select onClick={this.changeWitcher} onChange={this.changeWitcher}>
                        <option value="" disabled selected>Ведьмак</option>
                        {this.state.witcher.map((elem, index) => {
                            return(<option value={elem.witcherName}>{elem.witcherName}</option> );
                        })}
                    </select>
                        <nobr> будет биться с </nobr>
                    <select onClick={this.changeMonster} onChange={this.changeMonster}>
                        <option value="" disabled selected>Монстр</option>
                        {this.state.monster.map((elem, index) => {
                            return(<option value={elem.monsterName}>{elem.monsterName}</option> );
                        })}
                    </select>
                    <input className="button" type="submit" value="БОЙ"/>
                </form>
                {this.state.deal !== "" && <p> и {this.state.deal}</p>}
            </div>
        );
    }

}

export default Batte;
