# Get App Info Cordova Plugin

A Cordova plugin to get the icon and label of an app based on its package name.


## Install

```
cordova plugin add cordova-plugin-get-app-info
```

## Usage


Get app label:

```
cordova.plugins.GetAppInfo.getAppLabel(function(label) {
    console.log(label);
}, function(error) {
    console.error(error);
});
```

Get app icon in Base64 string format:

```
cordova.plugins.GetAppInfo.getAppIcon(function(base64Icon) {
    console.log(base64Icon);
}, function(error) {
    console.error(error);
});
```

## Supported platforms

* Android

## License
MIT
