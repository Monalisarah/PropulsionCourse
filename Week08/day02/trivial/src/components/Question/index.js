import React, {Component} from 'react';
import AnswerItem from '../AnswerItem'
import {connect} from 'react-redux';

class Question extends Component{

  render(){
    const questions =  {
      id: 1,
      text: "Which is the best city in the world?",
      answers : [
            {id: 1, text: 'Barcelona', isCorrect: false},
            {id: 2, text: 'Sidney', isCorrect: false},
            {id: 3, text: 'Zurich', isCorrect: true},
            {id: 4, text: 'Stockholm', isCorrect: false}
      ]
    }

    console.log(questions);


      return(
        <div>
          <h4>{questions.text}</h4>
          <ul>
            {
              questions.answers.map((answer, index) => {
                return <AnswerItem key={index} answer={answer} />;
                })
            }

          </ul>
        </div>
      );
  }
}


export default connect() (Question);
