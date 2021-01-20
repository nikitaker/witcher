import React from 'react';

const divStyle = {
    width: '300px',
    border: '2px #000',
    borderRadius: '10px'
};

class Armor extends React.Component {


    render() {
        return(
            <div style={divStyle}>
                {this.props.array.map((elem) => {
                    //if (elem.armorName === this.props.name)
                        return (
                            <div>
                                <table>
                                    <tr>
                                <td>Название - {elem.armorName}</td>
                                <td>Защита - {elem.prot}</td>
                                <td>Цена - {elem.price}</td>
                                    </tr>
                                </table>
                            </div>);
                })}
            </div>
        );
    }

}

export default Armor;