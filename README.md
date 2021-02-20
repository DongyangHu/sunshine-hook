# Sunshine-Hook
![java](https://img.shields.io/badge/java-1.8-brightgreen)
&nbsp;
![spring-boot](https://img.shields.io/badge/spring--boot-2.3.8.RELEASE-green)

一个WebHook监听程序，接收Git的WebHook事件，触发执行指定脚本

|类型|是否支持|备注|
|:----|:----|:----|
|GitHub|√||
|Gitee|×|TODO|
|GitLab|×|TODO|

## 快速使用
自行打包或下载[releases](https://github.com/DongyangHu/sunshine-hook/releases)版本
### 启动
```shell script
命令: java -jar ${path}/sunshine-hook-web-${version}.jar [config...]
示例: java -jar ./sunshine-hook-web-1.0.0-RELEASE.jar
```
接口地址: `http://localhost:10000/sunshine-hook/event`

### 配置说明
可直接修改项目配置文件，也可使用SpringBoot命令行参数配置
- 格式: `--${key}=${value}`
- 示例: `java -jar ./sunshine-hook-web-1.0.0-RELEASE.jar --sunshine-hook.config.branch-filter=master`

|配置|描述|默认值|示例|必填|
|:----|:----|:----|:----|:----|
|server.port|服务端口|10000|8080|×|
|sunshine-hook.config.branch-filter|数组,需要监听的分支|master|b1,b2|×|
|sunshine-hook.config.event-filter|数组,需要监听的事件类型|push|push,commit|×|
|sunshine-hook.config.script-path|事件触发后执行的脚本路径|-|./trigger.sh|√|
|sunshine-hook.config.secret-key|WebHook请求签名秘钥|123456|abc123|×|
|sunshine-hook.config.consume-delay|事件处理频率,单位:s|10|5|×|
|sunshine-hook.config.max-size|事件缓冲区队列大小|100|50|×|

## LICENSE
[MIT](https://github.com/DongyangHu/sunshine-hook/blob/master/LICENSE)