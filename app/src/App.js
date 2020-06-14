import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {

  state = {
    isLoading: true,
    unityprojects: [{
        unityScenes: []
    }] 
  };

  async componentDidMount() {
    const response = await fetch('/api/getallunityprojects');
    const body = await response.json();
    this.setState({ unityprojects: body, isLoading: false})
  }

  render() {

    const {unityprojects, isLoading} = this.state;


    if (isLoading) {
      return <p>Loading...</p>
    }

    console.log(unityprojects.unityScenes)

  return (
    <div className = "App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <div className="App-intro">
          <h2>Loaded UnityProjects</h2>
          {unityprojects.map(unityproject => 
            <div key={unityproject.ID}>
               {unityproject.unityProjectName}
              
            </div>
            )}
        </div>
      </header>
    
    </div>
  );
  }
}

export default App;
