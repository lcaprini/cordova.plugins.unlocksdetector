//
//  UnlocksDetector.h
//  Copyright (c) 2014 Lee Crossley - http://ilee.co.uk
//

#import "Foundation/Foundation.h"
#import "Cordova/CDV.h"

@interface UnlocksDetector : CDVPlugin

- (void) isJailbroken:(CDVInvokedUrlCommand*)command;

@end
