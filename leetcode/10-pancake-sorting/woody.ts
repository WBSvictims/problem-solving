const getMaxIndex = (arr, endIndex) => {
  let max = -1
  let maxIndex = -1

  for (let i = 0; i < endIndex; i++) {
    if (max < arr[i]) {
      max = arr[i]
      maxIndex = i
    }
  }

  return maxIndex
}

const flip = (arr, index) => {
  const head = arr.slice(0, index)
  const tail = arr.slice(index)

  return head.reverse().concat(tail)
}

function pancakeSort(arr: number[]): number[] {
  let size = arr.length
  const result = []

  while (size > 1) {
    const maxIndex = getMaxIndex(arr, size) + 1
    const flipSize = (maxIndex === 0) ? arr.length : maxIndex
    arr = flip(arr, flipSize)
    arr = flip(arr, size)
    if (flipSize !== 1) result.push(flipSize)
    if (size !== 1) result.push(size)
    --size
  }

  return result
}
