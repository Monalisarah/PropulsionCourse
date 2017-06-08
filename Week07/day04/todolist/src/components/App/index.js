import React, { Component } from 'react';
import Header from '../Header';
import Intro from '../Intro';
import './index.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Header title="Goodbye Angular" />
        <Intro/>
      </div>
    );
  }
}

export default App;
