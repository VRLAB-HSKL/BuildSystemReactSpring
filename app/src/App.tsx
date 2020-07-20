import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ProjectDataList from './components/ProjectDataList';
import EditProjectData from './components/EditProjectData';
import UnityProjects from './components/UnityProjects';
import UnityConfigs from './components/UnityProjectConfiguration';

/*
 * This class provides the routing between unity Project information and unity platform configurations
 */
class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/projectdata' exact={true} component={ProjectDataList}/>
          <Route path='/projectdata/:id' component={EditProjectData}/>
          <Route path='/unityprojects' component={UnityProjects}/>
          <Route path='/unityconfigs/:projectName' component={UnityConfigs}/>
        </Switch>
      </Router>
    )
  }
}

export default App;