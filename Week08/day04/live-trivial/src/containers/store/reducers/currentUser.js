const currentUser = (state = {}, action) =>{
  switch (action.type) {
    case 'setCurrentUser'
    return {...action.user}
    //....
    default:
    return state;

  }
}
