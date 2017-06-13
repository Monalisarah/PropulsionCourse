import React, {Component } from 'react':
import AnswerItem from
import link... from react-redux
import './index.css'


const styles = {
  wrapper: {
    textAlign: "left",
    width: 30%
    margin: 20px auto,
  }
  list: {

  }
}

export default ({question}) =>
<div style= {styles.wrapper}>
  <h4>{question.text}</h4>
  <Link to ="/result">Go to result</Link>
  <ul>
    {
      question.answers.map(answer =>)
      <li key = {answer.id} onClick = { () => {this.isCorrect? alert('yay') : alert('buuuh')}>{answer}</li>
      <AnswerItem key = {answer.id} answer = {answer}/>
    }
  </ul>
</div>


class Question extends Component {

  addAnswer = () => {
    console.log('in da click');
  }

  render() {
    const {question } = this.props;
    // const question = {
    //   id: 1,
    //   text:: 'Best sity in the world'
    //   answers: [
    //     {id: 1, text: 'Barcelona', isCorrect: false}
    //     {id: 2, text: 'Sidney', isCorrect: false}
    //     {id: 3, text: 'Zurich', isCorrect: false}
    //     {id: 4, text: 'Stockholm', isCorrect: false}
    //   ]
    };
  }
  render() {
    return (
      <div style = {styles.wrapper}>
      <h4> Best city in the world </h4>
      <ul style = {styles.list}>
        <li onClick= {this.addAnswer}>Barcelona</li>
        <li onClick= {this.addAnswer}>Sydney</li>
        <li onClick= {this.addAnswer}>Zurich</li>
        <li onClick= {this.addAnswer}>Stockholm</li>
      </ul>
      </div>
    )
  }
}


export default Question;
