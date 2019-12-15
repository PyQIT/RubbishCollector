import React, { Component } from 'react';
import axios from "axios";

class MyNewComponent extends Component {

    state = {Tab: []};

    componentDidMount() {
        axios.get('https://jsonplaceholder.typicode.com/todos/1').then((res, req) => {
            this.setState({Tab: res.data});
        });
    }

    render() {

let  rubbishBinDateJSON = localStorage.setItem('rubbishBinDateJSON', JSON.stringify(this.state.Tab))
        return (
            <div ></div>
        );
    }
}

export default MyNewComponent;