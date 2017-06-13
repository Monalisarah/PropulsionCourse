
export const addQuestionCrator = (question) => {
 return {
   type = 'addQuestion',
   question,
 }
}

export const addResultCreator = (isCorrect) => {
  return {
    type: 'addResult',
    isCorrect: isCorrect,
  }
  };
}
