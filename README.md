# 基于 t-io 的WebSocket demo

## use

准备：

  1. 安装mysql并导入sql脚本，然后修改配置文件用户名和密码等mysql相关信息
  
  2. 安装好mongodb，默认端口, 创建数据库，命名为："test"


接口如下，根据userId来区分用户和绑定用户组：

    ws://127.0.0.1:9326?userId=1

发送消息体格式：

    {"code":2,
        "wsMessage":{
            "fromId":1,
            "toId":3,
            "content":"bW9uZ29kYiB0ZXN0",
            "sendType":0,
            "msgType":1	
        }
    }

在线测试链接：http://easyswoole.com/wstool.html

