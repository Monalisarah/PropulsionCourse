
import { combineReducers } from 'redux';
import currentUser from './currentUser';
import feedReducer from './feedReducer';

// create new feedReducer
// handle the action
export default combineReducers({
  currentUser,
  feedReducer,
})
