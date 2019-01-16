import React, { Component } from 'react';

class HoldingRow extends Component {
  render() {
    return (
        <tr>
          <td>
            {this.props.obj.symbol}
          </td>
          <td>
            {this.props.obj.symbolDescription}
          </td>
           <td>
            {this.props.obj.amount}
           </td>
           <td>
            <button className="btn btn-primary">Edit</button>
           </td>
           <td>
             <button className="btn btn-danger">Delete</button>
           </td>
        </tr>
    );
  }
}

export default HoldingRow;