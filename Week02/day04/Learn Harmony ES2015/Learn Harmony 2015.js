// var person = {
//     first: 'Marsellus',
//     last: 'Wallace'
// };
//
// let {first, last} = person;
// console.log(first, last);
//
// let {first: fn, last: ln} = person;
// console.log(fn, ln);


function getResult() {
    return {
        result: 1234,
        error: null
    };
}

let {result, error} = getResult();


function doHTTP({host, port, path}) {
    console.log(host, port, path);
}

doHTTP({
    host: 'learnharmony.org',
    port: 80,
    path: '/'
});


let person1 = {
    first: 'Marsellus',
    last: 'Wallace',
    spouse: {
        first: 'Mia',
        last: 'Wallace'
    }
};

let {first: husband, last, spouse: { first: wife } } = person1;
console.log(wife, husband, last);



let a = 1, b = 2;
[b, a] = [a, b];
console.log({a, b});

let [,,third] = [1, 2, 3];
console.log({third});


let [first, ...remaining] = [1, 2, 3, 4, 5];
console.log(first);
console.log(remaining);



function makeParent(first, last) {
    return {first, last, isParent: true};
}
console.log(makeParent('Darth', 'Vader'));



let piecesPerPie = 6;
let numberOfPies = 3;
console.log(`There are ${numberOfPies} pies, so we have ${piecesPerPie * numberOfPies} pieces.`);
