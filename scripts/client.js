const baseUrl = 'http://localhost:8080'
const wait = '/ping/wait'
const nowait = '/ping/nowait'

async function main() {
  for (var i = 0; i < 100_000; i += 1) {
    const loopId = i
    if (loopId % 1000 === 0) {
      console.log(`loopId: ${loopId}`)
    }
    fetch(`${baseUrl}${wait}`)
      .catch(err => console.log(`wait from ${loopId}: ${err}`))
  }

  fetch(`${baseUrl}${nowait}`)
    .then(res => console.log(`nowait: ${res.status}`))
    .catch(err => console.log(`nowait: ${err}`))
}

main()
