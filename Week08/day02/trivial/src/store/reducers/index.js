
const initialState =  {
  id: 1,
  text: "Which is the best city in the world?",
  answers : [
        {id: 1, text: 'Barcelona', isCorrect: false},
        {id: 2, text: 'Sidney', isCorrect: false},
        {id: 3, text: 'Zurich', isCorrect: true},
        {id: 4, text: 'Stockholm', isCorrect: false}
  ]
}



const reducer = (state = initialState, action) => {
  switch (action.type) {
    default:
    return state;
  }
}


export default reducer;
