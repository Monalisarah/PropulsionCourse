// const initialState
// ...copy questions...

//file ok



const questions = (state = {}, action ) =>{
  switch (action.type) {
    case 'addQuestion':
      const newState = {...state};
      const questionId = action.question.id;
      newState[questionId] = action.question;
      return newState;
    default:
    return state;
  }
}

export default questions;
