---
## 手撸mybatis框架 ##
### 1. mybatis解决了什么问题？
* mybaitis作为一个持久层框架，就是为了和数据库做交互,做一些crud的事情
* 传统jdbc操作数据库个人理解主要分为三部分，首先是加载数据库驱动，获取数据库连接，然后定义sql获取preparement,最后向数据库发出查询请求executeQuery查询结果集
* 很明显传统jdbc操作存在:频繁创建释放数据库连接(释放不及时，很容易造成内存泄露)、sql硬编码问题、查询结构集也存在硬编码问题(不符合开闭原则)
* mybatis就是为了简化这些操作、解耦。
### 2. 代码框架
* persistence就是mybatis框架，最后以jar形式引入到我们需要的项目中: 解析文件，执行sql,返回包装结果
* persistence_test 就是模拟我们真正项目中用的框架：写数据库连接配置文件、sql配置文件
---

