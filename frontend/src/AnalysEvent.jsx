import React, {Component} from 'react';
import {Button, Form, Alert} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

class AnalysEvent extends Component {

    state = {Toggle: false}

    onOffClick = () => {
        this.setState({Toggle: !this.state.Toggle})
    }

    render() {
        return (
            <div className="AnalysEvent">
                <div className={"navDiv"}></div>
                <Form.Group controlId="formBasicEmail">
                    <Form.Label className={"formLabel"}>Typ:</Form.Label>
                    <Form.Control className={"formControl"} disabled type="email" placeholder="110 l"/>
                    <Form.Label className={"formLabel"}>Rodzaj śmieci:</Form.Label>
                    <Form.Control className={"formControl"} disabled type="email" placeholder="Mieszane"/>
                    <Form.Label className={"formLabel"}>Miasto:</Form.Label>
                    <Form.Control className={"formControl"} disabled type="email" placeholder="Kielce"/>
                    <Form.Label className={"formLabel"}>Ulica:</Form.Label>
                    <Form.Control className={"formControl"} disabled type="email" placeholder="Ściegiennego"/>
                </Form.Group>
                <Button className={"button"} variant="info" onClick={this.onOffClick}>Zgłoś</Button>
                {this.state.Toggle && <Alert variant={"success"}>
                    Dziękujemy za zgłoszenie.
                </Alert>}

            </div>
        )
    }


}

export default AnalysEvent;