import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import UnityProjectList from './components/UnityProjectList';

class App extends Component {

  render() {

    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/projectmanagement' exact={true} component={UnityProjectList}/>
        </Switch>
      </Router>
    )
  }
}

export default App;