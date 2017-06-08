import React, { Component } from 'react';
import logo from './logo.svg';
import './index.css';

class Header extends Component {
  render() {
    return (
      <div className="Header">
        <img src={logo} className="Header-logo" alt="logo" />
        <h2>{this.props.children}</h2>
      </div>
    );
  }
}

export default Header; // don't forget to export the component
