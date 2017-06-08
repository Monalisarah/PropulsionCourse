import React, { Component } from 'react';
import Header from '../Header';
import TodoList from '../TodoList';
import './index.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Header/>
        <TodoList/>
      </div>
    );
  }
}

export default App;
