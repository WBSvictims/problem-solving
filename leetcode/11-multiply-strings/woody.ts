const parseNumArray = (num) => num.split('').map((n) => +n)

function multiply(num1: string, num2: string): string {
  if (num1 === "0" || num2 === "0") {
    return "0"
  }

  const num1Arr = parseNumArray(num1)
  const num2Arr = parseNumArray(num2)
  const l = num1.length + num2.length
  const a = Array(l)

  for (let i = 0; i < num1Arr.length; i++) {
    for (let j = 0; j < num2Arr.length; j++) {
      a[i + j] = (a[i + j] || 0) + num1Arr[i] * num2Arr[j]
    }
  }

  a.reverse()

  for (let i = 0; i < a.length; i++) {
    const firstNum = Math.floor(a[i] / 10)
    const lastNum = a[i] % 10

    a[i] = lastNum

    if (firstNum > 0) {
      a[i + 1] = (a[i + 1] || 0) + firstNum
    }
  }

  while (isNaN(a[0])) a.shift()

  return a.reverse().join('')
}
