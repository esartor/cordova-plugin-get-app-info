/* eslint-disable */
var exec = require('cordova/exec');

var PLUGIN_NAME = 'GetAppInfo';

var GetAppInfo = {
  getAppIcon: function(packageName, cb, ecb) {
    exec(cb, ecb, PLUGIN_NAME, 'getAppIcon', [packageName]);
  },
  getAppLabel: function(packageName, cb, ecb) {
    exec(cb, ecb, PLUGIN_NAME, 'getAppLabel', [packageName]);
  }
};

module.exports = GetAppInfo;
