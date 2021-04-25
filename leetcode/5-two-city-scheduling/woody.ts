function twoCitySchedCost(costs: number[][]): number {
  const sorted = costs.sort((a, b) => (a[0] - a[1]) - (b[0] - b[1]))

  const halfLength = costs.length / 2
  let result = 0

  for (let i = 0; i < halfLength; i++) {
    result += sorted[i][0]
  }

  for (let i = halfLength; i < costs.length; i++) {
    result += sorted[i][1]
  }

  return result
}
