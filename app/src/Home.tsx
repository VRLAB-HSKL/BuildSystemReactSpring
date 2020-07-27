import React, { Component } from 'react';
import './App.css';
import AppNavbar from './components/AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

/**
 * This class provides two buttons that refer to the Unity Project information and unity platform configurations
 */
class Home extends Component {
  render() {
    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <Button color="link"><Link to="/projectdata">Project Manager</Link></Button>
          <Button color="link"><Link to="/unityprojects">Unity Project Configurations</Link></Button>
        </Container>
      </div>
    );
  }
}

export default Home;