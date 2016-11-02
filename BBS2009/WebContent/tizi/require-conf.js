/**
 * Created by suntao(suntao@smartisan.com) on 15/11/27.
 */

// var baseUrl = document.getElementById('mainScript').getAttribute('data-baseurl');

require.config({
    baseUrl: '/template/smartisan/src/js/',
    paths: {
        'jquery': 'jquery-1.11.3.min',
        'jquery-private': 'lib/jquery-private',
        'jquery.cookie': 'jquery.cookie',
        'pubsub': 'lib/pubsub'
    },
    map: {
        '*': {'jquery': 'jquery-private'},
        'jquery-private': {'jquery': 'jquery'}
    },
    shim: {
        'jquery.cookie': ['jquery']
    }

});