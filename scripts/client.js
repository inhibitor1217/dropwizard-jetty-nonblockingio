const baseUrl = 'http://localhost:8080'
const wait = '/ping/wait'
const nowait = '/ping/nowait'

async function main() {
  for (var i = 0; i < 10; i += 1) {
    const loopId = i
    console.log(`Request ${loopId}`)
    fetch(`${baseUrl}${wait}`)
      .then(res => console.log(`wait from ${loopId}: ${res.status}`))
      .catch(err => console.log(`wait from ${loopId}: ${err}`))
  }

  fetch(`${baseUrl}${nowait}`)
    .then(res => console.log(`nowait: ${res.status}`))
    .catch(err => console.log(`nowait: ${err}`))
}

main()
