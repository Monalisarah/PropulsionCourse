import React, {Component} from 'react';
import {connect }from 'react-redux';




class Login extends Component {

  constructor(props){
    super(props);
    this.state = {
      username: '',
      password: '',
    }
handleEmailChange  = (e) => {
  const email = e.currentTarget.value;
  this.setState({email})
}

handlePassChange  = (e) => {
  const email = e.currentTarget.value;
  this.setState({password})
}

login = (e) => {
  e.preventDefault();
  const loginAction = loginCreator(this.state.email, this.state.password);
  this.props.dispatch( loginAction)
  this.props.setState({
    email:'',
    passoword: '',
  })
}

  }
  render () {
    retrun (
      <form>
      <input
        type= "text"
        onChange = {this.handleEmailChange}
        value= {this.state.email}/>
      <input
        type= "password"
        value= {this.state.handlePassChange}
        placeholder = "password" value= {this.state.password}/>
      <input type= "submit" value= "Login"/>
      </form>
    )
  }
}
