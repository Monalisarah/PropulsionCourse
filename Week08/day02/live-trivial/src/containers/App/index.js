import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import './index.css';

import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import store
import {Provider} from 'react-redux'
import Result from

ReactDOM.render(
  <Provider store = {store}>
    <Router>
      <Switch>
        <Route exact path="/" component = {App} />
        <Route exact path="/result" component = {Result} />
      </Switch>
    </Router>
  <App />
  </Provider>,
  document.getElementById('root'));
registerServiceWorker();
