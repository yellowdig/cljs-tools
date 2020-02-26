
const fs = require('fs')

const str = fs.readFileSync('bench.edn').toString()

const { decode } = require('../package/index').edn

var runs = 100
const times = []

while (runs--) {
  const start = Date.now()
  const res = decode(str, true)
  const end = Date.now()
  const ms = end - start
  console.log(ms)
  times.push(ms)
}

const sum = times.reduce((x, y) => x + y)
const avg = sum / times.length

console.log(avg)







