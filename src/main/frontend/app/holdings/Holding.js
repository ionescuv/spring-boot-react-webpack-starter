import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import HoldingRow from './HoldingRow';

export default class Holding extends Component {
constructor(){
  super();
  this.state = {
   holdings: []
  };
}
 componentDidMount() {
  fetch('/api/holdings')
      .then(response => {
        if(response.ok) return response.json();
        throw new Error('Request failed.');
      })
      .then(data => {
      console.log(data);
            console.log(data.length);
        this.setState({holdings: data });
      })
      .catch(error => {
        console.log(error);
      });
  }

   tabRow(){
        return this.state.holdings.map(function(object, i){
            return <HoldingRow obj={object} key={i} />;
        });
      }

   render() {

     return (
        <div>
          <h3 align="center">Holdings List</h3>
          <table className="table table-striped" style={{ marginTop: 20 }}>
            <thead>
              <tr>
                <th>Shortcut</th>
                <th>Shortcut Description</th>
                <th>Holding Amount</th>
                <th colSpan="2">Action</th>
              </tr>
            </thead>
            <tbody>
              { this.tabRow() }
            </tbody>
          </table>
        </div>
      );
    }
  }
