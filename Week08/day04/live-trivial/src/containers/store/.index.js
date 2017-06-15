
/// 7. update store

import {createStore } from 'redux';
import reducer from
import loggingMiddleware from



const store = createStore(
  reducer,
  // the order matters!
  applyMiddleware(thunk, loggingMiddleware)
)

export default store;
