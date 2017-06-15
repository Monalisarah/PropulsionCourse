import React, {Component} from 'react';
import {connect} from 'react-redux';
import loginUser from '../../store/actions.js';

class Login extends Component {

  constructor(props) {

    //it also has access to its parents props
    super(props);

    this.state = {
      email: '',
      password: ''
    }
  }

  handleSubmit = (e) => {
    e.preventDefault();
    // 1. dispatch this.props is an Object
    this.props.dispatch(loginUser(this.state.email, this.state.password))

    //
    // const body = {
    //   email: this.state.email,
    //   password: this.state.password
    // };
    //
    // const header = new Headers({'Content-Type': 'application/json'});
    //
    // const config = {
    //   method: 'POST',
    //   headers: header,
    //   body: JSON.stringify(body)
    // };
    //
    // fetch('https://propulsion-blitz.herokuapp.com/api/login', config)
    // .then(res => res.json())
    // .then(user => {
    //
    // })
  };

  // fake19@email.com
  // password
  // do the fetch
  // method: POST
  // body: send email and password, with JSON.stringify
  // header -> 'Content-Type': 'application/json'
  // res.json()
  // recieve a user
  // store this user in redux state:
  // create an action
  // dispatch the action
  // handle the action in the reducer

  handleEmail = (e) => {
    const email = e.currentTarget.value;
    this.setState({email: email});
  }

  handlePassword = (e) => {
    const password = e.currentTarget.value;
    this.setState({password: password});
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <br></br>
        <br></br>
        <input type="text" placeholder="enter your email" value={this.state.email} onChange={this.handleEmail}/>
        <input type="password" placeholder="password" value={this.state.password} onChange={this.handlePassword}/>
        <input type="submit" value="Login"/>
      </form>
    );
  }
}

export default connect()(Login)
