## Jailbroken/Rooted Device Detector Plugin for Apache Cordova

## Install

### Locally

```
cordova plugin add https://github.com/lcaprini/it.lcaprini.cordova.plugins.unlocksdetector.git
```

This Cordova plugin architecture will add a new object called `unlocksDetector` to your root automatically when you build.

## Usage

### isJailbroken (iOS only)
Inspired from Lee Crossley's cordova-plugin-jailbreak-detection plugin (https://github.com/leecrossley/cordova-plugin-jailbreak-detection)

```js
unlocksDetector.isJailbroken(successCallback, failureCallback);
```

- => `successCallback` is called with true if the device is Jailbroken, otherwise false
- => `failureCallback` is called if there was an error determining if the device is Jailbroken

### isRooted (Android only)
Inspired from Jimmy Liao's cordova-plugin-device-detection plugin (https://github.com/jimmyliao/cordova-plugin-device-detection)

```js
unlocksDetector.isRooted(successCallback, failureCallback);
```

- => `successCallback` is called with true if the device is Rooted, otherwise false
- => `failureCallback` is called if there was an error determining if the device is Rooted

## Platform Support

- iOS
- Android

## License

[MIT License](http://ilee.mit-license.org)
