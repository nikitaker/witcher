import React from 'react';

const divStyle = {
    width: '40%',
    border: '2px #000',
    borderRadius: '10px'
};

class Potion extends React.Component {

    render() {
        return(
            <div style={divStyle}>
                {this.props.array.map((elem) => {
                    //if (elem.armorName === this.props.name)
                        return (
                            <div>
                                <table>
                                    <tr>
                                        <td>Название - {elem.name}</td>
                                        <td>Защита - {elem.prot}</td>
                                        <td>Цена - {elem.price}</td>
                                        <td>Монстр - {elem.monsterType.name}</td>
                                    </tr>
                                </table>
                            </div>);
                })}
            </div>
        );
    }

}

export default Potion;