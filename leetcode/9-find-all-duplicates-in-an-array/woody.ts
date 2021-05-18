function findDuplicates(nums: number[]): number[] {
  const numSet = new Set(nums)

  for (let n of nums) {
    if (numSet.has(n)) {
      numSet.delete(n)
    } else {
      numSet.add(n)
    }
  }

  return [...numSet]
}
