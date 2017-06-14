import React, { Component } from 'react';
import {connect} from 'react-redux';


class Login extends Component {
  render () {
    return(
      <form>
        <input type="text" placeholder= "enter your email" name="email"/>
        <input type="password" placeholder= "password"name="password"/>
        <input type="submit" value="Login"/>
      </form>
    );
  }
}



export default connect() (Login)
