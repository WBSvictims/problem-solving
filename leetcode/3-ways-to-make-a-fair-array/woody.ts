const isEven = (i) => i % 2 === 0

function waysToMakeFair(nums: number[]): number {
  const numLength = nums.length
  let result = 0
  let evenSum = 0
  let oddSum = 0
  let evenAcc = 0
  let oddAcc = 0

  for (let i = 0; i < numLength; i++) {
    if (isEven(i)) {
      evenSum += nums[i]
    } else {
      oddSum += nums[i]
    }
  }

  for (let i = 0; i < numLength; i++) {
    if (isEven(i)) {
      evenSum -= nums[i]
    } else {
      oddSum -= nums[i]
    }

    if ((evenSum + oddAcc) === (oddSum + evenAcc)) {
      result++
    }

    if (isEven(i)) {
      evenAcc += nums[i]
    } else {
      oddAcc += nums[i]
    }
  }

  return result
}