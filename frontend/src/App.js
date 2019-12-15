import React,{Component} from 'react';
import MapboxMap from "./MapboxMap";
import AnalysEvent from "./AnalysEvent";
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";
import DataAnalyst from "./DataAnalyst";

class App extends Component {
    render(){
        return (
            <div className="App">
                <Router>
                    <Route path='/new' component={AnalysEvent}/>

                    <Route exact path='/' component={MapboxMap}/>

                    <Route exact path='/data' component={DataAnalyst}/>

                </Router>
                {/*<MapboxMap></MapboxMap>*/}

            </div>

        )}
}

export default App;
