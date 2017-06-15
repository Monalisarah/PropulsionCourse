import {combineReducers} from 'redux';
import questions from
import result from './result';


const reducer = combineReducers({
  questions: questions,
})


export default reducer;
