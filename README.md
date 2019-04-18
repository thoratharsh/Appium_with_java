# Appium_with_java

## Setup

1. Install Android Studio (SDK) and set path to Android_Home environment variable : [link](https://developer.android.com/studio)

2. Install JDK

3. Install NodeJS

4. Install Appium for dekstop

5. install Genymotion, download required device and start the device

6. Check device is available with below command in command prompt

`adb devices`

7. Install APK App Info on Google Play to know appPackage and appActivity of application 

[Installation Guide](https://www.guru99.com/introduction-to-appium.html)

## Important Link
Howw to get appPackage and appActivity from connected devices

1.install AppInfo

2.use below command [link](http://www.automationtestinghub.com/apppackage-and-appactivity-name/)
adb shell pm list packages

## Allure report

To Generate allure report open command prompt in project location and use below command

`
allure generate allure-result --clean
`
HTML Report will be generated in allure-Report location 
