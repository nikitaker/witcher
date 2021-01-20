import React from 'react';

class QuestGiver extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            monster : [],
            questGiver : "",
            questGiverNames : [],
            monsterName : "",
            questGiverName : "",
            startPrice : "",
            money : "",
            charisma : ""
        }

        this.changeMonster = this.changeMonster.bind(this);
        this.changeQuestGiver = this.changeQuestGiver.bind(this);
        this.changeCharisma= this.changeCharisma.bind(this);
        this.changeMoney= this.changeMoney.bind(this);
        this.changeStartPrice= this.changeStartPrice.bind(this);
        this.handleOnSubmit = this.handleOnSubmit.bind(this);
    }


    componentWillMount() {
        fetch("http://localhost:8080/monster")
            .then(res => res.json())
            .then(response => {
                this.setState({monster : response})
            });
        fetch("http://localhost:8080/questgiver")
            .then(res => res.json())
            .then(response => {
                this.setState({questGiver : response})
                response.forEach((elem, index) => {
                    this.state.questGiverNames.push(elem.questGiver);});
            });

    }


    changeMonster(event) {
        this.setState({
            monsterName : event.target.value
        })
    }

    changeQuestGiver(event) {
        if(this.state.questGiverNames.indexOf(event.target.value) === -1){
        this.setState({
            questGiverName : event.target.value
        })
    }}

    changeStartPrice(event) {
        if(event.target.validity.valid && (parseInt(this.state.money,10) >= parseInt(event.target.value,10))){
        this.setState({
            startPrice : event.target.value
        })
    }}

    changeMoney(event) {
        if(event.target.validity.valid){
        this.setState({
            money : event.target.value
        })
    }}

    changeCharisma(event) {
        if(event.target.validity.valid){
        this.setState({
            charisma : event.target.value
        })
    }}


    handleOnSubmit(e){
        if (this.state.monsterName !== "" && this.state.questGiverName !== ""){
            fetch("http://localhost:8080/newquestgiver?questgiverName=" + this.state.questGiverName +
            "&monsterName=" + this.state.monsterName +
            "&startPrice=" + this.state.startPrice +
            "&money=" + this.state.money +
            "&charisma=" + this.state.charisma)
                .then(res => res.json())
                .then(response => {
                    this.setState({questGiver : response})
                });
        }
        e.preventDefault();
    }


    render() {
        return(
            <div>
                <form onSubmit={this.handleOnSubmit}>

                    <input type="text" placeholder="Имя" value={this.state.questGiverName} onChange={this.changeQuestGiver} />

                    <select onClick={this.changeMonster} onChange={this.changeMonster}>
                        <option value="" disabled selected>Монстр</option>
                        {this.state.monster.map((elem, index) => {
                            return(<option value={elem.monsterName}>{elem.monsterName}</option> );
                        })}
                    </select>
                    <input type="text" placeholder="Начальная цена" pattern="[0-9]*" value={this.state.startPrice} onChange={this.changeStartPrice} />

                    <input type="text" placeholder="Деньги" pattern="[0-9]*" value={this.state.money} onChange={this.changeMoney} />

                    <input type="text" placeholder="Харизма" pattern="[0-9]*" value={this.state.charisma} onChange={this.changeCharisma} />

                    <input className="button" type="submit" value="Добавить заказчика"/>
                </form>
                {this.state.questGiver !== "" && <p>{JSON.stringify(this.state.questGiver)}</p>}
            </div>
        );
    }

}

export default QuestGiver;
