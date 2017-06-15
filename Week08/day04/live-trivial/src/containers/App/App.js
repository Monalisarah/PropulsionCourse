import React, { Component } from 'react';
import {connect} from 'react-redux';
import logo from './logo.svg';
import './App.css';
import Question from './components/Question'
import {addResultCreator} from './store/actions'

class App extends Component {


  fetchFeed = () = {
  this.props.dispatch(fetchFeed());
  }


  componentDidMount(){
    fetch('https://opentdb.com/api.php?amount=3')
    .then (res => res.json())
    .then( data => {
      console.log(data);
      const questions = data.results.map(question => {
        const newQuestion = {...question};
        newQuestion.id = index + 1;
        return newQuestion;
      });
      questions.forEach(question => {
        const action = addQuestionCreator(question)
        this.props.dispatch
        ....
      })
      console.log(addQuestionCreator);
    })
  }

  render() {

    if (this.props.questions.length === 0){
      return <div>Fetching questions...</div>
    }

    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Welcome to React</h2>
        </div>
        <Question question = {this.props.questions[0]}/>
      </div>
    );
  }
}

const mapStateToProps = (state) => {
  const questions = Object.values(state.questions).map(question =>{
    answers = question.incorrect_answers.map(ans =>{
      return{
        id: index + 1,
        text: ans,
        isCorect: false,
      };
    });
    const correctAnd = {
      id: 4,
      text: question.correct_anwer,
      isCorrect: true,
    }

    answers.push(correctAns);
    const newQuestion = {
      id: question.id,
      text: question.question,
      answer: answers,

    }
  })
  return newQuestion;

}

export default connect(mapStateToProps) (App);
