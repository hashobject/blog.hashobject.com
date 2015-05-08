module.exports = {
  entry: "./public/js/App.js",
  output: {
    filename: "./public/button/bundle.js"
  },
  module: {
    loaders: [
      {test: /\.js$/, loader: 'jsx-loader'}
    ]
  }
};