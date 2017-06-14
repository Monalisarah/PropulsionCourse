import React from 'react';
import logo from './logo.svg'
import './index.css'



class Header extends React.Component {

  constructor(props){
    super(props);
    this.state = {
      title: '...'
    }
  }

  componentDidMount(){
    fetch('http://ron-swanson-quotes.herokuapp.com/v2/quotes')
    .then(res=> res.json())
    .then(quotes =>{
      this.setState({
        title: quotes[0]
      });
    });
    console.log('in da componentDidMount');

  }

  render (){
    console.log(this.props);
    return (
      <div className="Header">
        <img src={logo} className="Header-logo" alt="logo" />
        <h2>{this.state.title}</h2>
        <p>{this.props.children}</p>
      </div>
    );
  }
}


export default Header;
