function hammingDistance(x: number, y: number): number {
  return (x ^ y).toString(2).split('0').join('').length
};
