// Count repetitions
console.log("Count repetitions exercice");
// only bracket notation works with variables!

function countRepetitions(arrayOfStrings){
  var repetitions = {};
  //console.log(repetitions[arrayOfStrings[0]);
  for (var i = 0; i < arrayOfStrings.length; i++){
    if (!repetitions[arrayOfStrings[i]]){
      repetitions[arrayOfStrings[i]] = 1;
    } else {
      repetitions[arrayOfStrings[i]] ++;
    }

    }
    return repetitions;
  }


console.log(countRepetitions(['kerouac', 'fante', 'fante', 'buk', 'hemingway', 'hornby', 'kerouac', 'buk', 'fante']));
