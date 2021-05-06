function numIdenticalPairs(nums: number[]): number {
  let result = 0

  for (let i = 0, l = nums.length; i < l; i++) {
    for (let j = i + 1; j < l; j++) {
      if (nums[i] === nums[j]) {
        result++
      }
    }
  }

  return result
}
