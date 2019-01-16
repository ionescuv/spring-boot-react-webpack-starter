import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class AllocationRow extends Component {
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
            {this.props.obj.percentage}%
           </td>
           <td>
            <Link to={"/edit/"+this.props.obj.symbol} className="btn btn-primary">Edit</Link>
           </td>
           <td>
             <Link to={"/delete/"+this.props.obj.symbol} className="btn btn-primary">Delete</Link>
           </td>
        </tr>
    );
  }
}

export default AllocationRow;