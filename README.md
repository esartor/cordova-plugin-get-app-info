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

## Using with Ionic Framework

In order for the plugin to be injectable into your providers/components and to use it the same way you use Ionic Native plugins, follow these steps:

1. Install the plugin as described in the _Install_ section.

2. Create a Ionic Native wrapper for `cordova-plugin-get-app-info`. A reasonable location for the wrapper is `src/plugins/get-app-info/get-app-info.ts`:

    ```
    import { Injectable } from '@angular/core';
    import { Plugin, Cordova, IonicNativePlugin } from '@ionic-native/core';
    
    @Plugin({
      pluginName: 'GetAppInfo',
      plugin: 'cordova-plugin-get-app-info',
      pluginRef: 'cordova.plugins.GetAppInfo',
      repo: 'https://github.com/esartor/cordova-plugin-get-app-info',
      platforms: ['Android']
    })
    @Injectable()
    export class GetAppInfo extends IonicNativePlugin {
      @Cordova()
      getAppIcon(packageName: string): Promise<string> {
        return;
      }
    
      @Cordova()
      getAppLabel(packageName: string): Promise<string> {
        return;
      }
    }
    ```

    Read [this guide](https://github.com/ionic-team/ionic-native/blob/master/DEVELOPER.md) for a full explanation on how to wrap Cordova plugins with Ionic Native.

3. Inject the plugin into your providers/components and access the `getAppLabel` and `getAppIcon` methods which will return a promise. Example code:

    ```
    import { Injectable } from '@angular/core';
    import { Platform } from 'ionic-angular';
    import { GetAppInfo } from '../../plugins/get-app-info/get-app-info';


    @Injectable()
    export class MyProvider {

      constructor(
        private platform: Platform,
        private getAppInfo: GetAppInfo
      ) {}

      myMethod() {
        if (this.platform.is(CORDOVA_PLATFORM)) {
          getAppInfo.getAppIcon('random.package.id');
        }
      }
    }
    ```

## Supported platforms

* Android

## License
MIT
