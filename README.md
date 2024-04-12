# [cordova-plugin-android-update](https://github.com/azhengyongqin/cordova-plugin-android-update)

App updater for Cordova/PhoneGap

本插件在[ cordova-plugin-app-update](https://github.com/azhengyongqin/cordova-plugin-android-update) 的基础上修改的，主要修改内容：
> 1. 增加是否强制更新, 在原插件配置文件中加入了 `<force>1</force>` 标签，来配置是否强制更新
> 2. 修复下载进度没有反应。
> 3. 修复APK下载后, 软件包解析出现问题。
> 4. 更新到androidx库。


# Demo
Try it yourself:

Just clone and install this demo. [cordova-plugin-app-update-DEMO](https://github.com/vaenow/cordova-plugin-app-update-demo) :tada:

 * 如果喜欢它，请别忘了给我一颗鼓励的星
 * Support me a `Star` if it is necessary.  :+1:

# Preview
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190121181415373.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzIzMTc5MDc1,size_16,color_FFFFFF,t_70)

# 

![在这里插入图片描述](https://img-blog.csdnimg.cn/2019012118143088.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzIzMTc5MDc1,size_16,color_FFFFFF,t_70)

# Install

### Latest published version on npm (with Cordova CLI >= 5.0.0) 

> `"cordova-android": "6.3.0"`

`cordova plugin add https://github.com/jajazhou/cordova-plugin-android-update --save`

### ionic + angular capacitor 安装
npm install https://github.com/jajazhou/cordova-plugin-android-update
npx cap sync

# Usage

- Simple:
```js
var updateUrl = "http://192.168.0.1/version.xml";
window.AppUpdate.checkAppUpdate(onSuccess, onFail, updateUrl);
```

- Verbose
```js
var appUpdate = cordova.require('cordova-plugin-app-update.AppUpdate');
var updateUrl = "http://192.168.0.1/version.xml";
appUpdate.checkAppUpdate(onSuccess, onFail, updateUrl);
```

- Auth download  [MORE](https://github.com/vaenow/cordova-plugin-app-update/pull/62)
```js
appUpdate.checkAppUpdate(onSuccess, onFail, updateUrl, {
    'authType' : 'basic',
    'username' : 'test',
    'password' : 'test'
})
```

- Skip dialog boxes
```js
appUpdate.checkAppUpdate(onSuccess, onFail, updateUrl, {
    'skipPromptDialog' : true,
    'skipProgressDialog' : true
})
```
### ionic + angular 下启动自动检测
- app.component.ts:

declare let window: any;
...
  checkUpdate() {
    this.wxtimer = setInterval(() => {
      this.innerCheckUpdate(false);
    }, 30000);//30秒
  }
  innerCheckUpdate(show: any) {
    const updateUrl = 'https://www.yours.com/apk/version.xml';
    window.AppUpdate.checkAppUpdate((es) => {
      //if (show && es.code === 202) { this.showNotify('已是最新版本!', 'success'); }
    }, (ex) => {
      //this.showNotify('onFail', 'error');
    }, updateUrl);
  }

- build.gradle(app)  添加 (更新到androidx库):
dependencies {
    ...
  implementation 'androidx.appcompat:appcompat:1.0.0-alpha1'
  implementation 'androidx.constraintlayout:constraintlayout:1.1.2'

### versionCode

You can simply get the versionCode from typing those code in `Console`

```js
var versionCode = AppVersion.build
console.log(versionCode)  // 302048
```


versionName | versionCode
------- | ----------------
0.0.1  | 18
0.3.4  | 3048  
3.2.4   | 302048
12.234.221  | 1436218

### server version.xml file

```xml
<update>
    <force>1</force>
    <version>10200</version>
    <name>1.2.0</name>
    <remark>1.加入自动升级功能\n2.修复了一些bug\n3.不用扫描下载了</remark>
    <url>http://http://192.168.0.1/android.apk</url>
</update>
```

在原插件配置文件中加入了 `<force>1</force>` 标签，来配置是否强制更新。
点击窗口外部, 0: 窗口消失; 1: 窗口不消失, 必须点击升级更新.

### `checkAppUpdate` code

```java
    /**
     * 对比版本号
     */
    int VERSION_NEED_UPDATE = 201; //检查到需要更新； need update
    int VERSION_UP_TO_UPDATE = 202; //软件是不需要更新；version up to date
    int VERSION_UPDATING = 203; //软件正在更新；version is updating

    /**
     * 版本解析错误
     */
    int VERSION_RESOLVE_FAIL = 301; //版本文件解析错误 version-xml file resolve fail
    int VERSION_COMPARE_FAIL = 302; //版本文件对比错误 version-xml file compare fail

    /**
     * 网络错误
     */
    int REMOTE_FILE_NOT_FOUND = 404;
    int NETWORK_ERROR = 405;

    /**
     * 没有相应的方法
     */
    int NO_SUCH_METHOD = 501;

    /**
     * Permissions
     */
    int PERMISSION_DENIED = 601;

    /**
     * 未知错误
     */
    int UNKNOWN_ERROR = 901;
```
# Languages
* 🇨🇳 zh
* 🇺🇸 en 
* 🇩🇪 de 
* 🇫🇷 fr 
* 🇵🇹 pt 
* 🇧🇩 bn 
* 🇵🇱 pl 
* 🇮🇹 it 
* 🇪🇸 es
* 🇷🇺 ru
* 🇰🇷 ko

# Platforms
Android only

# License
MIT

# :snowflake: :beers:

* Please let me know if you have any questions.
* [cordova-plugin-android-update](https://github.com/jajazhou/cordova-plugin-android-update)

