import React, { Component } from 'react';
import logo from './logo.svg';
import './index.css';

class Header extends Component {
  constructor(props){
    super(props);

    this.state = {
      quotes: []
    }
  }
  componentDidMount() {
    fetch('http://ron-swanson-quotes.herokuapp.com/v2/quotes')
      .then(res => res.json())
      .then(quotes => {
        console.log(quotes);
        this.setState({
          quotes,
        });
      });
  }
  render() {
    return (
      <div className="Header">
        <img src={logo} className="Header-logo" alt="logo" />
        <h2>{this.props.title}</h2>
        <h3>{this.state.quotes[0]}</h3>
      </div>
    );
  }
}


export default Header; // don't forget to export the component
