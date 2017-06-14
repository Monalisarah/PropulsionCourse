import React, { Component } from 'react';
import logo from './logo.svg';
import './index.css';
import {connect} from 'react-redux';



class App extends Component {
  render() {
    console.log('App store log:', this.props);
    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Welcome to React</h2>
        </div>
      </div>
    );
  }
}

const mapStateToProps = (state) => {
 // write map function and return the part of the state that you need eg. state.questions
 return state;
}
export default connect(mapStateToProps)(App);
