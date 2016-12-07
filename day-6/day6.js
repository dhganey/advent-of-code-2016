const getPasswordWithColumnCounts = function(columnCountArr, max) {
    password = [];
    columnCountArr.forEach(columnCount => {
        password.push(Object.keys(columnCount)
            .reduce((a, b) => {
                if (columnCount[a] > columnCount[b]) {
                    return (max ? a : b);
                } else {
                    return (max ? b : a);
                }
            })
        );
    });

    return password;
}

const processFile = function(err, contents) {
    const lines = contents.split('\n')
    const first = lines[0];
    const length = first.length;

    let columnCountArr = [];
    for (let i = 0; i < length; i++) {
        columnCountArr.push({});
    }

    lines.forEach(line => {
        for (let i = 0; i < length; i++) {
            if (line[i]) {
                if (columnCountArr[i][line[i]]) {
                    columnCountArr[i][line[i]] = columnCountArr[i][line[i]] + 1;
                } else {
                    columnCountArr[i][line[i]] = 1
                }
            }
        }
    });

    password = getPasswordWithColumnCounts(columnCountArr, true /*max*/);

    console.log('part1', password);

    secondPassword = getPasswordWithColumnCounts(columnCountArr, false);

    console.log('part2', secondPassword)
}

const fs = require('fs');
fs. readFile('input.txt', 'utf8', processFile);