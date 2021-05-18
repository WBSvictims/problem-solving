function findJudge(n: number, trust: number[][]): number {
  if (n === 1) {
    return 1
  }

  let result = -1
  const counter = new Map()
  const general = new Set()

  for (let [a, b] of trust) {
    counter.set(b, (counter.get(b) || 0) + 1)
    general.add(a)
  }

  for (let [person, count] of counter) {
    if (count == n - 1 && !general.has(person)) {
      result = person
    }
  }

  return result
}
