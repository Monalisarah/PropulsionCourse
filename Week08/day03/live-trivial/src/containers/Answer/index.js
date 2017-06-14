import React, {Component} from 'react';
import {withRouter} from 'react-router-dom';
import {addResultCreator} from '../../store/actions';
import {connect} from 'react-redux';
import

class AnswerItem extends Component{

  checkAnswer = () =>{
    // this.props.answer.isCorrect ? alert('yay'): alert('boo')
    // console.log('checking answer');
    // console.log(this.props);
      // this.props.dispatch(action);

    const action = addResultCreater(this.props.answer.isCorrect);
    this.props.history.push('/result');


  }

  render(){
    const {answer} = this.props;


    //const answer = this.props.answer
    return <li onClick = {this.checkAnswer}>{answer.text}</li>
  }
}


export default connect() (withRouter(AnswerItem));
