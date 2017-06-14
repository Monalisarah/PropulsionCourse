import React, { Component } from 'react';
import './App.css';
import Header from './components/Header/header';
import TodoList from './TodoList/';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Header title = "Goodbye jQuery"/>
        <Header>
          <em>Godbye jQuery</em>
        </Header>
        <TodoList />
      </div>
    );
  }
}

export default App;
