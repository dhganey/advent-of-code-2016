const moves = {
    "1": {
        "R": "2",
        "D": "4"
    },
    "2": {
        "L": "1",
        "R": "3",
        "D": "5"
    },
    "3": {
        "L": "2",
        "D": "6"
    },
    "4": {
        "U": "1",
        "R": "5",
        "D": "7"
    },
    "5": {
        "U": "2",
        "D": "8",
        "L": "4",
        "R": "6"
    },
    "6": {
        "L": "5",
        "D": "9"
    },
    "7": {
        "U": "4",
        "R": "8"
    },
    "8": {
        "U": "5",
        "L": "7",
        "R": "9"
    },
    "9": {
        "L": "8",
        "U": "6"
    }
}

const complexKeypadMoves = {
    "1": {
        "D": "3"
    },
    "2": {
        "R": "3",
        "D": "6"
    },
    "3": {
        "U": "1",
        "L": "2",
        "R": "4",
        "D": "7"
    },
    "4": {
        "L": "3",
        "D": "8"
    },
    "5": {
        "R": "6"
    },
    "6": {
        "L": "5",
        "R": "7",
        "U": "2",
        "D": "A",
    },
    "7": {
        "U": "3",
        "D": "B",
        "L": "6",
        "R": "8"
    },
    "8": {
        "L": "7",
        "R": "9",
        "U": "4",
        "D": "C"
    },
    "9": {
        "L": "8"
    },
    "A": {
        "U": "6",
        "R": "B"
    },
    "B": {
        "L": "A",
        "R": "C",
        "U": "7",
        "D": "D"
    },
    "C": {
        "L": "B",
        "U": "8"
    },
    "D": {
        "U": "B"
    }
}

const findNewCurrentButton = function(currentButton, move) {
    if (complexKeypadMoves[currentButton][move]) {
        return complexKeypadMoves[currentButton][move];
    } else {
        return currentButton;
    }
}

const findButton = function(instruction, currentButton) {
    for (var i = 0; i < instruction.length; i++) {
        const move = instruction[i];
        currentButton = findNewCurrentButton(currentButton, move);
    }

    return currentButton;
}

const processContents = function(err, contents) {
    var instructionsArray = contents.split("\n");
    if (instructionsArray[instructionsArray.length - 1].length == 0) {
        instructionsArray = instructionsArray.splice(0, instructionsArray.length - 1);
    }

    bathroomCode = [];
    currentButton = "5";
    for (var i = 0; i < instructionsArray.length; i++) {
        bathroomCode[i] = findButton(instructionsArray[i], currentButton);
        currentButton = bathroomCode[i];
    }

    console.log(bathroomCode);
}

const fs = require('fs');
fs. readFile('input.txt', 'utf8', processContents);