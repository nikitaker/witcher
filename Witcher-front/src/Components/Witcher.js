import React from 'react';

const divStyle = {
    width: '800px',
    border: '2px #000',
    borderRadius: '10px'
};

class Witcher extends React.Component {

    constructor(props) {
        super(props);
    }

    render() {
        return(
            <div style={divStyle}>
                <table border="1px">
                {this.props.array.map((elem) => {
                    return (
                        <tr>
                            <td>Имя : {elem.witcherName}</td>
                            <td>Здоровье : {elem.health}</td>
                            <td>Деньги : {elem.money}</td>
                            <td>Меч : {elem.swordName}</td>
                            <td>Броня : {elem.armorName}</td>
                            <td>Харизма : {elem.charisma}</td>
                            <td>Локация : {elem.locationName}</td>
                        </tr>
                    );})}
                </table>
            </div>
        );
    }

}

export default Witcher;