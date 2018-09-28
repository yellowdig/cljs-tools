# cljs-tools

`cljs-tools` is a javascript package which exposes various useful clojurescript functions and utilities. `cljs-tools` provides a commonjs module with the following exported namespaces:

- `edn`
	- `encode()`
	- `decode()`


clojurescript version: `1.10.238`


### EDN 

#### encode/decode


```js
encode(jsData, <keywordize?>)
decode(jsData, <keywordize?>)
```

```js
const { encode, decode } = require('@yellowdig/cljs-tools').edn

encode({ foo: ':bar'})
=> {"foo" ":bar"}


encode({ foo: ':bar'}, true)
=> {"foo" :bar}

```

© Yellowdig 2018 // [yellowdig.com](https://yellowdig.com)