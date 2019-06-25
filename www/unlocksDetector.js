
var exec = require("cordova/exec");

var UnlocksDetector = function () {
    this.name = "UnlocksDetector";
};

UnlocksDetector.prototype.isJailbroken = function (successCallback, failureCallback) {
    exec(successCallback, failureCallback, "UnlocksDetector", "isJailbroken", []);
};

UnlocksDetector.prototype.isRooted = function (successCallback, failureCallback) {
    exec(successCallback, failureCallback, "UnlocksDetector", "isRooted", []);
};

module.exports = new UnlocksDetector();
