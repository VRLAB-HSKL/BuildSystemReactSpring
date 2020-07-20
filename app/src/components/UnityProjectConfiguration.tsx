import React, {Component} from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { RouteComponentProps, Link, withRouter } from 'react-router-dom';


interface IProps extends RouteComponentProps<any> {

    projectName: string;
}

interface IState {
  platformConfig: [{
      id : number;
      configurationName : string;
      sceneName : string;
      projectName : string;
      description : string;
      viu : boolean;
      gvr : boolean;
      wavevr : boolean;
      middlevr : boolean;
      buildTargetGroup : string;
      buildTarget : string;
      index : number;
  }]
}

/**
 * This class represents the available platform configurations.
 */
class UnityProjectConfiguration extends Component<IProps, IState>{

    constructor(props: IProps) {
        super(props);

        this.state = {
            platformConfig : [{
                id : 0,
                configurationName : "",
                sceneName : "",
                projectName : "",
                description : "",
                viu : false,
                gvr : false,
                wavevr : false,
                middlevr : false,
                buildTargetGroup : "",
                buildTarget : "",
                index : 0,
            }]
        }
    }

    async componentDidMount() {
        console.log('/api/unity/getplatformconfigurationbyprojectname/'+ this.props.match.params.projectName)
        const data = await (await fetch(`/api/unity/getplatformconfigurationbyprojectname?projectName=${this.props.match.params.projectName}`)).json();
          this.setState({platformConfig: data});
    }

    render() {
        const {platformConfig} = this.state;
        const platformConfigList = platformConfig.map(config => {
            const id = config.id;
            const configurationName = config.configurationName;
            const sceneName = config.sceneName;
            const projectName = config.projectName;
            const description = config.description;
            const buildTargetGroup = config.buildTargetGroup;
            const buildTarget = config.buildTarget;
            const index = config.index;
            let viu = "";
            let gvr = "";
            let wavevr = "";
            let middlevr = "";

            if(config.viu) {
                viu = "yes";
            } else {
                viu = "no";
            }

            if(config.gvr) {
                gvr = "yes";
            } else {
                gvr = "no";
            }

            if(config.wavevr) {
                wavevr = "yes";
            } else {
                wavevr = "no";      
            }

            if(config.middlevr) {
                middlevr= "yes";
            } else {
                middlevr = "no";           
            }

            return <tr key={id}>
                <td style={{whiteSpace: 'nowrap'}}>{id}</td>
                <td>{configurationName}</td>
                <td>{sceneName}</td>
                <td>{projectName}</td>
                <td>{description}</td>
                <td>{viu}</td>
                <td>{gvr}</td>
                <td>{wavevr}</td>
                <td>{middlevr}</td>
                <td>{buildTargetGroup}</td>
                <td>{buildTarget}</td>
                
                </tr>
        });
        return(
            <div>
            <AppNavbar/>
                <Container fluid>
                <div className="float-right">
                    <Button color="success" tag={Link} to="/unityprojects">Back</Button>
                </div>
                <h3>Unity Project Configurations</h3>
                <Table className="mt-4">
                    <thead>
                    <tr>
                        <th id="id"> ID </th>
                        <th id="name"> Config. Name </th>
                        <th id="sceneName">Scene Name</th>
                        <th id="projName">Project Name</th>
                        <th id="desc"> Description </th>
                        <th id="viu"> VIU </th>
                        <th id="gvr"> GVR </th>
                        <th id="wave"> WaveSDK </th>
                        <th id="MiddleVR"> MiddleVR </th>
                        <th id="platform"> Platform </th>
                        <th id="buildtarget"> Buildtarget </th>
                        
                    </tr>
                    </thead>
                    <tbody>
                        {platformConfigList}
                    </tbody>
                </Table>
                </Container>
          </div>
        );
    }
}

export default withRouter(UnityProjectConfiguration);