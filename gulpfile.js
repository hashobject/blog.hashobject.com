'use strict';
var gulp = require('gulp');
var path = require('path');
var fs   = require('fs');
var awspublish = require('gulp-awspublish');

var aws = JSON.parse(fs.readFileSync('./aws.json'));

gulp.task('deploy', function() {

  // create a new publisher
  var publisher = awspublish.create(aws);

  // define custom headers
  var headers = {
    'Cache-Control': 'max-age=315360000, no-transform, public'
  };

  return gulp.src('./target/public/**/*.*')
    // gzip, Set Content-Encoding headers and add .gz extension
    // .pipe(awspublish.gzip({ ext: '.gz' }))

    // publisher will add Content-Length, Content-Type and  headers specified above
    // If not specified it will set x-amz-acl to public-read by default
    .pipe(publisher.publish(headers))

    // create a cache file to speed up consecutive uploads
    .pipe(publisher.cache())

     // print upload updates to console
    .pipe(awspublish.reporter());
});

var watcher = gulp.watch('src/**/*.*', ['build']);
watcher.on('change', function(ev) {
  console.log('File ' + ev.path + ' was ' + ev.type + ', running tasks...');
});
