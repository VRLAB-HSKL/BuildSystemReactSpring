import React, {Component} from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import './ProjectData.css';

interface IProps {

}

interface IState {
    isLoading: boolean,
    error: boolean,
    unityProjects : [{
        index : number;
        projectName : string;
    }] 
}

class UnityProjects extends Component<IProps, IState> {

    constructor(props: IProps) {
        super(props);

        this.state = {
            isLoading: true,
            error: false,
            unityProjects : [{
                index : 0,
                projectName : "",
            }]
        }
    }

    componentDidMount() {
        this.setState({isLoading: true});
    
        //fetch('/api/persons/getallpersons')
        //.then(response => response.json())
        //.then(data => this.setState({persons: data, isLoading: false}));
    
        fetch('/api/unity/getplatformconfigurationprojectnames')
        .then(response => response.json())
        .then(data => this.setState({unityProjects: data, isLoading: false}))
        .catch(error => this.setState({
          isLoading: false,
          error: true
        }));
       
      }


    render() {
        const {unityProjects} = this.state;
        const unityProjectsList = unityProjects.map(unityProject => {
        const index = unityProject.index;
        const projectName = unityProject.projectName;
        return <tr key={index}>
        <td style={{whiteSpace: 'nowrap'}}>{index}</td>
        <td>{projectName}</td>
       
        
        <td>
            <ButtonGroup>
                <Button size="sm" color="primary" tag={Link} to={"/unityconfigs/" + projectName}>Show</Button>
            </ButtonGroup>
        </td>
        </tr>
        });

        return (
            <div>
        <AppNavbar/>
            <Container fluid>
            <div className="float-right">
                <Button color="success" tag={Link} to="/">Back</Button>
            </div>
            <h3>Unity Projects</h3>
            <Table className="mt-4">
                <thead>
                <tr>
                    <th id="index"> Index </th>
                    <th id="name"> Project Name </th>
                </tr>
                </thead>
                <tbody>
                    {unityProjectsList}
                </tbody>
            </Table>
            </Container>
      </div>
        ); 
    }

}

export default UnityProjects;