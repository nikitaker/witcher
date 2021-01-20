import React from 'react';

class Deal extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            witcher : [],
            questGiver : [],
            deal : "",
            witcherName : "",
            questGiverName : ""
        }

        this.changeWitcher = this.changeWitcher.bind(this);
        this.changeQuestGiver = this.changeQuestGiver.bind(this);
        this.handleOnSubmit = this.handleOnSubmit.bind(this);
    }


    componentWillMount() {
        fetch("http://localhost:8080/witcher")
            .then(res => res.json())
            .then(response => {
                this.setState({witcher : response})
            });
        fetch("http://localhost:8080/questgiver")
            .then(res => res.json())
            .then(response => {
                this.setState({questGiver : response})
            });
    }

    changeWitcher(event) {
        this.setState({
            witcherName : event.target.value
        })

    }

    changeQuestGiver(event) {
        this.setState({
            questGiverName : event.target.value
        })

    }

    handleOnSubmit(e){
        if (this.state.witcherName !== "" && this.state.questGiverName !== ""){
            fetch("http://localhost:8080/makeDeal?witcherName=" + this.state.witcherName
                + "&otherName=" + this.state.questGiverName)
                .then(res => res.json())
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
                        <nobr> пытается торговаться с </nobr>
                    <select onClick={this.changeQuestGiver} onChange={this.changeQuestGiver}>
                        <option value="" disabled selected>Заказчик</option>
                        {this.state.questGiver.map((elem, index) => {
                            return(<option value={elem.questGiver}>{elem.questGiver}</option> );
                        })}
                    </select>
                    <input className="button" type="submit" value="Совершить сделку"/>
                </form>
                {this.state.deal !== "" && <p>Сделка состоялась за {this.state.deal}</p>}
            </div>
        );
    }

}

export default Deal;
