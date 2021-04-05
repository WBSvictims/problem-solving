function reconstructMatrix(upper: number, lower: number, colsum: number[]): number[][] {
  if (colsum.reduce((sum, n) => sum + n, 0) !== upper + lower) {
    return []
  }

  const unknownIdx = []
  const result = [[], []]
  let upperSum = 0
  let lowerSum = 0

  for (let i = 0, l = colsum.length; i < l; i++) {
    switch (colsum[i]) {
      case 1:
        unknownIdx.push(i)
        break
      case 0:
        result[0][i] = 0
        result[1][i] = 0
        break
      case 2:
        result[0][i] = 1
        result[1][i] = 1

        upperSum++
        lowerSum++
        break
    }
  }

  for (let i = 0, l = unknownIdx.length; i < l; i++) {
    if (upperSum > upper || lowerSum > lower) {
      return []
    } else if (upperSum < upper) {
      result[0][unknownIdx[i]] = 1
      result[1][unknownIdx[i]] = 0
      upperSum++
    } else if (lowerSum < lower) {
      result[0][unknownIdx[i]] = 0
      result[1][unknownIdx[i]] = 1
      lowerSum++
    }
  }

  return result
}
