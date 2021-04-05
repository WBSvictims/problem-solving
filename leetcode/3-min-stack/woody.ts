class MinStack {
    stack: number[]
    index: number

    constructor() {
        this.stack = []
        this.index = 0
    }

    push(val: number): void {
        this.stack[this.index++] = val
    }

    pop(): void {
        this.stack.length--
        this.index--
    }

    top(): number {
        return this.stack[this.stack.length - 1]
    }

    getMin(): number {
        return this.stack.reduce((s, v) => s < v ? s : v)
    }
}
