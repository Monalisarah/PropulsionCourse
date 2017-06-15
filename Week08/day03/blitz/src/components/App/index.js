import React, { Component } from 'react';
import logo from './logo.svg';
import './index.css';
import {connect} from 'react-redux';
import Login from '../Login'



class App extends Component {
  render() {
    // console.log('connection to state in App (each component has a this.props):', this.props);
    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Blitz Assignment</h2>
        </div>
        <div>
            <Login></Login>
        </div>
      </div>
    );
  }
}

const mapStateToProps = (state) => {
 // write map function and return the part of the state that you need eg. state.questions
 return state;
}

// the dispatch property (in this.props) is available when you connect:
// export default connect()(App);
// if we also want to read from the Redux state we have to connect in this way:
export default connect(mapStateToProps)(App);
