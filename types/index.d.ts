// Type definitions for cordova.plugins.unlocksdetector 0.2.3
// Project: https://github.com/lcaprini/cordova.plugins.unlocksdetector
// Definitions by: Luca Caprini <https://github.com/lcaprini>

/**
 * This plugin defines a global device object, which exposes two methods to detect if device is Jailbroken or Rooted
 * Although the object is in the global scope, it is not available until after the deviceready event.
 */
// eslint-disable-next-line @typescript-eslint/class-name-casing
interface unlocksDetector {

    /**
     * Inspired from Lee Crossley's cordova-plugin-jailbreak-detection plugin (https://github.com/leecrossley/cordova-plugin-jailbreak-detection)
     * @param  {(isJailbroken:boolean)=>void} success?
     * @param  {(error:any)=>void} error?
     * @returns void
     */
    isJailbroken(onSuccess?: (isJailbroken: boolean)  => void, onError?: (error: any)  => void): void;

    /**
     * Inspired from Jimmy Liao's cordova-plugin-device-detection plugin (https://github.com/jimmyliao/cordova-plugin-device-detection)
     * @param  {(isRooted:boolean)=>void} success?
     * @param  {(error:any)=>void} error?
     * @returns void
     */
    isRooted(onSuccess?: (isRooted: boolean)  => void, onError?: (error: any)  => void): void;
}

declare module 'unlocksdetector' {
    export = unlocksDetector;
}
