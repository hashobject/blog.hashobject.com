module.exports = function(grunt) {

  // Project configuration.
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    aws: grunt.file.readJSON('grunt-aws.json'), // for S3

    stylus: {
      compile: {
        options: {
          paths: ['styl'], // folder, where files to be imported are located
          urlfunc: 'url', // use embedurl('test.png') in our code to trigger Data URI embedding
          'include css': true
        },
        files: {
          '../resources/public/css/app.css': 'styl/app.styl' // 1:1 compile
        }
      }
    },

    s3: {
      key: '<%= aws.key %>',
      secret: '<%= aws.secret %>',
      bucket: '<%= aws.bucket %>',
      access: 'public-read',
      encodePaths: true,
      //debug: true,

      // Files to be uploaded.
      upload: [
        {
          src: '../resources/public/index.html',
          dest: 'index.html',
          gzip: true
        },
        {
          src: '../resources/public/clojure-webapp-with-https-support-on-amazon-beanstalk/index.html',
          dest: 'clojure-webapp-with-https-support-on-amazon-beanstalk/index.html',
          gzip: true
        },
        {
          src: '../resources/public/tips-for-running-clojure-webapp-on-amazon-beanstalk/index.html',
          dest: 'tips-for-running-clojure-webapp-on-amazon-beanstalk/index.html',
          gzip: true
        },
        {
          src: '../resources/public/make-static-site-with-clojure-and-host-on-amazon/index.html',
          dest: 'make-static-site-with-clojure-and-host-on-amazon/index.html',
          gzip: true
        },
        {
          src: '../resources/public/payments-api-for-collaborative-consumption-apps/index.html',
          dest: 'payments-api-for-collaborative-consumption-apps/index.html',
          gzip: true
        },
        {
          src: '../resources/public/website-launch-checklist/index.html',
          dest: 'website-launch-checklist/index.html',
          gzip: true
        },
        {
          src: '../resources/public/product-launch-on-betalist/index.html',
          dest: 'product-launch-on-betalist/index.html',
          gzip: true
        },
        {
          src: '../resources/public/install-postgresql-9.2-on-ubuntu-13.04/index.html',
          dest: 'install-postgresql-9.2-on-ubuntu-13.04/index.html',
          gzip: true
        },
        {
          src: '../resources/public/upstart-configuration-for-clojure-apps/index.html',
          dest: 'upstart-configuration-for-clojure-apps/index.html',
          gzip: true
        },
        {
          src: '../resources/public/clojure-webapp-on-ubuntu-13.04/index.html',
          dest: 'clojure-webapp-on-ubuntu-13.04/index.html',
          gzip: true
        },
        {
          src: '../resources/public/css/app.css',
          dest: 'css/app.css',
          gzip: true
        },
        {
          src: '../resources/public/images/*.png',
          dest: 'images/',
          rel: '../resources/public/images'
        },
        {
          src: '../resources/public/google235235bcbf7ddb0d.html',
          dest: 'google235235bcbf7ddb0d.html'
        },
        {
          src: '../resources/public/robots.txt',
          dest: 'robots.txt'
        },
        {
          src: '../resources/public/humans.txt',
          dest: 'humans.txt'
        },
        {
          src: '../resources/public/sitemap.xml',
          dest: 'sitemap.xml'
        },
        {
          src: '../resources/public/favicon.ico',
          dest: 'favicon.ico'
        }
      ]
    },

    watch: {
      src: {
        files: ['styl/*.styl'],
        tasks: ['build']
      }
    }

  });

  grunt.loadNpmTasks('grunt-contrib-stylus');
  grunt.loadNpmTasks('grunt-s3');
  grunt.loadNpmTasks('grunt-contrib-watch');

  grunt.registerTask('build', ['stylus:compile']);
  grunt.registerTask('deploy', ['stylus:compile', 's3:upload']);

};
