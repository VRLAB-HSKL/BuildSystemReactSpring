import React, {Component} from 'react';
import {Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import {Link} from 'react-router-dom';

class UnitProjectList extends Component {

    constructor(props) {
        super(props);
        this.state = {unityprojects: [], isLoading: true};
        //this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        this.setState({isLoading: true});
    
        fetch('api/getallunityprojects')
          .then(response => response.json())
          .then(data => this.setState({unityprojects: data, isLoading: false}));
          console.log(this.state.unityprojects.ID)
      }

    //todo delete Method

    render() {

        const {unityprojects, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const projectsList = unityprojects.map(project => {
            const name = `${project.unityProjectName || ''} `;
            return <tr key={project.ID}>
                <td style={{whiteSpace: 'nowrap'}}>{project.ID}</td>
                <td>{name}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/unityprojects"}>Edit</Button>
                        <Button size="sm" color="danger" /* delete stuff to do */>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>

        });


        return (
            <div>
                <AppNavbar/>
                    <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/unityprojects/new">Add Project</Button>
                    </div>
                    <h3>Project Management</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="20%">ID</th>
                            <th width="20%">Name</th>
                            <th>Events</th>
                            <th width="10%">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                            {projectsList}
                        </tbody>
                    </Table>
                    </Container>
            </div>
        );
    }
}

export default UnitProjectList;