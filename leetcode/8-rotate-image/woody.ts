/**
 Do not return anything, modify matrix in-place instead.
 */
function rotate(matrix: number[][]): void {
  const mLength = matrix.length
  const lastIndex = mLength - 1

  for (let i = 0; i < mLength / 2; i++) {
    for (let j = i; j < mLength - i - 1; j++) {
      [
        matrix[i][j],
        matrix[j][lastIndex - i],
        matrix[lastIndex - i][lastIndex - j],
        matrix[lastIndex - j][i]
      ] = [
          matrix[lastIndex - j][i],
          matrix[i][j],
          matrix[j][lastIndex - i],
          matrix[lastIndex - i][lastIndex - j]
        ]
    }
  }
}
