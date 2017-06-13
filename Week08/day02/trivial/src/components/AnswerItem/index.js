import React, { Component} from 'react';


class AnswerItem extends Component {

  handleClick = () => {
    console.log('in da click');
  }

  render(){
    const answer = this.props.answer;

    return(
      <li onClick = {this.handleClick}>{answer.text}</li>
    )}
}


export default AnswerItem;
