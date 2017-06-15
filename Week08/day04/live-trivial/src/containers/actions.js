




const setCurrentUser = (user) => ({
  type: 'setCurentUser',
  user,
})

export const fetchFeed = (despatch, getState)=> {
  const currentUser = getState().currentUser;
  const headers = new Headers ({
    Authorisation : 'Bearer ${currentUser.token}',
  })
  const config = {
    headers: headers,
  }
  fetch('http..')
}

export const loginCreator = (email, passoword) => (dispatch, getState) => {
  const header = new Headers ({
    'Content-Type': 'application/json'
  });

  const body = {
    email: email,
    password: password,
  }
  const config = {
    headers: headers,
    method: 'POST'
    body: JSON.stringify(body)
  };

  // 2. add return before fetch
  return fetch('...url', config)
    .then(res => res.json())
    .then(user => {
      const action = setCurrentUser(user);
      dispatch(action);
      console.log(user);
  // 4. save the token in the localStorage
      localStorage.setItem('token', user.token)
    })
    .catch (err => {
      console.log('in da error');
      console.log(err);

    })
}
