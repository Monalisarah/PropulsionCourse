import React, {Component} from 'react';
import {connect} from 'react-redux';
import {loginUser, getFeed} from '../../store/actions.js';
import {withRouter} from 'react-router';


//Login is a child of App
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
    .then(() => {
      this.props.history.push('/feed');
    })
    // .then(() => {
    //   this.props.dispatch(getFeed())
    //   });
  };


    // loginUser now in actions.js
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

export default withRouter(connect()(Login));
// withRouter is connecting the login component to the route
