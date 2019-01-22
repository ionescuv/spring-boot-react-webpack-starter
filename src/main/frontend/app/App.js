import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import './App.css';
import queryString from 'query-string';
import Symbol from './symbol/Symbol';
import Holding from './holdings/Holding';
import Quote from './quotes/Quote';
import Allocation from './allocations/Allocation';

class App extends Component {
  constructor() {
    super()
    this.state = {
      accessToken: ''
    }
  }

  componentDidMount() {
    let parsed = queryString.parse(window.location.search);
    let accessToken = parsed.access_token;
    if (!accessToken) return
    this.setState({
      accessToken: accessToken
    })
  }
  render() {
    return (
      <div>
        {this.state.accessToken ?
          <Router>
            <div className="container">
              <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <Link to={'/'} className="navbar-brand">Holdings Maintainance</Link>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                  <ul className="navbar-nav mr-auto">
                    <li className="nav-item">
                      <Link to={'/symbols'} className="nav-link">Symbols</Link>
                    </li>
                    <li className="nav-item">
                      <Link to={'/holdings'} className="nav-link">Holdings</Link>
                    </li>
                    <li className="nav-item">
                      <Link to={'/allocations'} className="nav-link">Allocations</Link>
                    </li>
                    <li className="nav-item">
                      <Link to={'/quotes'} className="nav-link">Quotes</Link>
                    </li>
                  </ul>
                </div>
              </nav> <br />
              <Switch>
                <Route exact path="/holdings" component={Holding} />
                <Route path="/quotes" component={Quote} />
                <Route path="/allocations" component={Allocation} />
                <Route path="/symbols" component={Symbol} />
              </Switch>
            </div>
          </Router>
          : <Router><Link to={'/login'} className="btn btn-primary">Log In</Link></Router>
        }
      </div>
    );
  }
}
export default App;