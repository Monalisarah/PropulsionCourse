import React from 'react';
import ReactDOM from 'react-dom';
import App from './components/App';
import registerServiceWorker from './registerServiceWorker';
import './index.css';

import { Provider } from 'react-redux';
import store from './store';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Feed from './components/Feed';


// console.log('logging store:' , store);

ReactDOM.render(
  <Provider store={store}>
    <Router>
      <Switch>
        <Route exact path="/" component={App} />
        <Route exact path="/feed" component={Feed} />
      </Switch>
    </Router>
  </Provider>,
  document.getElementById('root'));
registerServiceWorker();
