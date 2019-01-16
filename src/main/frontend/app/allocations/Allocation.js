import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import AllocationRow from './AllocationRow';
import {FormControl, FormGroup, HelpBlock, Form, ControlLabel, Button, Col} from 'react-bootstrap';
import {Link, Route, BrowserRouter} from 'react-router-dom';
import CreateAllocation from './CreateAllocation';


export default class Allocation extends Component {

constructor(props){
  super(props);
  this.state = {
   allocations: [],
   referrer: '',
  };
}

componentWillReceiveProps (nextProps) {
   console.log(nextProps);
}

 componentDidMount() {
  fetch('/api/allocations')
      .then(response => {
        if(response.ok) return response.json();
        throw new Error('Request failed.');
      })
      .then(data => {
      console.log(data);
            console.log(data.length);
        this.setState({allocations: data });
      })
      .catch(error => {
        console.log(error);
      });
  }

   tabRow(){
        return this.state.allocations.map(function(object, i){
            return <AllocationRow obj={object} key={i} />;
        });
      }

   render() {
     return (
               <BrowserRouter>
        <div>
        <Form inline>
        <FormGroup controlId="formAllocationList">
            <ControlLabel>Allocations List</ControlLabel>{' '}
          </FormGroup>{' '}
            <Link to={this.props.match.url + '/create'} className="btn btn-default">Create</Link>
        </Form>
          <table className="table table-striped" style={{ marginTop: 20 }}>
            <thead>
              <tr>
                <th>Shortcut</th>
                <th>Shortcut Description</th>
                <th>Allocation Percentage</th>
                <th colSpan="2">Action</th>
              </tr>
            </thead>
            <tbody>
              { this.tabRow() }
            </tbody>
          </table>

           <Route path={this.props.match.path + '/create'} component={CreateAllocation}/>
           </div>
        </BrowserRouter>

      );
    }
  }