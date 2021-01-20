import React from 'react';

const divStyle = {
    width: '40%',
    border: '2px #000',
    borderRadius: '10px'
};

class BoardList extends React.Component {

    render() {
        return(
            <div style={divStyle}>
                <table border="1px">
                {this.props.array.map((elem) => {
                        return (
                                    <tr>
                                        <td>Имя : {elem.witcherName.witcherName}</td>
                                        <td>Здоровье : {elem.witcherName.health}</td>
                                        <td>Монстр : {elem.monsterName.monsterName}</td>
                                        <td>Цена : {elem.price}</td>
                                        <td>Выдал : {elem.questGiver.questGiver}</td>
                                    </tr>
                        );
                })}
                </table>
            </div>
        );
    }

}

export default BoardList;