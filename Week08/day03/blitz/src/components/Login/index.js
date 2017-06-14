import React, { Component } from 'react';
import {connect} from 'react-redux';


class Login extends Component {

  constructor(props){

  //it also has access to its parents props
    super(props);

    this.state = {
      email: '',
      password: '',
    }
  }

handleSubmit = () => {}

handleEmail = (e) => {
  const email = e.currentTarget.value;
  this.setState({
    email: email
  });
}

handlePassword = (e) => {
  const password = e.currentTarget.value;
  this.setState({
    password: password
  });
}



  render () {
    return(
      <form onSubmit={this.handleSubmit}>
        <br></br>
        <br></br>
        <input
          type="text"
          placeholder= "enter your email"
          value = {this.state.email}
          onChange = {this.handleEmail}/>
        <input
          type="password"
          placeholder= "password"
          value = {this.state.password}
          onChange = {this.handlePassword}/>
        <input type="submit" value="Login"/>
      </form>
    );
  }
}



export default connect() (Login)
