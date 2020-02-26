const t = require('transit-js')

const opts = {
  mapBuilder: {
    init: function() {
      return {}
    },
    add: function(m, k, v) {
      m[k] = v
      return m
    },
    finalize: function(m) {
      return m
    }
  },

  arrayBuilder: {
    init: function() {
      return []
    },
    add: (ret, val, node) => {
      // this is how keywords are defined, not sure why
      if (val._name) {
        ret.push(`:${val._name}`)
      } else {
        ret.push(val)
      }
      return ret
    },
    finalize: (ret, node) => {
      return ret
    }
  },

  handlers: {
    set: rep => {
      return rep
    },
    list: rep => {
      return rep
    }
  }
}

const r = t.reader('json', opts)

module.exports = transitStr => {
  return r.read(transitStr)
}
