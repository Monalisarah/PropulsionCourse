// is an action Creator a function that returns an Object with a type
// returns an action (Object) in this case returns a fuction which we pass to the redux thunk
// is a function which takes two parameters (email, password) and returns another function which also expects two parameters (dispatch, getState)
// we pass the email and password when calling the function,
// dispatch, getState is from the middleware thunk (like .map(element, index)) it takes two parameters
const loginUser = (email, password) => (dispatch, getState) => {

  const body = {
    email: email,
    password: password
  };

  const header = new Headers({
    'Content-Type': 'application/json'
  });

  const config = {
    method: 'POST',
    headers: header,
    body: JSON.stringify(body)
  };

  fetch('https://propulsion-blitz.herokuapp.com/api/login', config)
    .then(res => res.json())
    .then(user => {
      console.log('in da user', user);
      // 2. dispatch save the information of the user to the redux state
      dispatch({
        type: 'GETUSER',
        user: user,
      })
    })
}


export default loginUser;
