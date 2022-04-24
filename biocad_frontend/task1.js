var matrixExample = [
    [1, 2, 3, 4],
    [4, 5, 6, 5],
    [7, 8, 9, 7],
    [7, 8, 9, 7]
];

function sumUpDiagonals(matrix) {
    let sum_pr = 0;
    let sum_dop = 0;
    for (let i = 0; i < matrix.length; i++) {
        sum_pr += matrix[i][i];
        sum_dop += matrix[i][matrix.length - i - 1]
    }
    return sum_pr + sum_dop;
}

console.log(sumUpDiagonals(matrixExample))