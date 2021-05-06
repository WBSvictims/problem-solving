function findMinArrowShots(points: number[][]): number {
  let result = 0
  let cursor = Number.MIN_SAFE_INTEGER

  points = points.sort((a, b) => a[1] - b[1])

  for (let i = 0; i < points.length; i++) {
    if (cursor >= points[i][0]) {
      continue
    }

    cursor = points[i][1]
    ++result
  }

  return result
}
