## 下载、安装、运行es先
像Tomcat一样下载zip，运行bin/elasticsearch.bat
测试：浏览器访问http://localhost:9200/
没有浏览器，就 curl 这个网址

---
## 前言
版本
6.8.7过时了，这里采用es7.x
客户端
elasticsearch-rest-high-level-client
这是官方推荐的客户端，支持最新的es
> 注意本例带有中文字符，确保项目+所有java文件都是UTF_8的编码格式，否则查询节点总是null

## 1-依赖

## 2-配置
es-config

## 3-封装 Client
config/RestHighLevelClientConfig

## 4-封装 ES 常用操作
service/RestHighLevelClientService

## 5-创建索引
TEST/DemoSearchApplicationTests.createIdx()
* settings是设置索引是否设置复制节点、设置分片个数
* mappings就和数据库中的表结构一样，用来指定各个字段的类型，同时也可以设置字段是否分词（我们这里使用ik中文分词器）、采用什么分词方式。
> 分词技巧：“索引时最小分词，搜索时最大分词”
>> 例如"Java知音"索引时分词包含Java、知音、音、知等，最小粒度分词可以让我们匹配更多的检索需求，
但是我们搜索时应该设置最大分词，用“Java”和“知音”去匹配索引库，得到的结果更贴近我们的目的，
对分词字段同时也设置keyword，便于后续排查错误时可以精确匹配搜索，快速定位。

## 测试：导入样本数据
items.json
> 十万条淘宝双11活动数据

TEST/DemoSearchApplicationTests.importAll()
## 测试：查询目标数据
TEST/DemoSearchApplicationTests.search()


## 扩展性思考
* 商品搜索权重扩展，我们可以利用多种收费方式智能为不同店家提供增加权重，增加曝光度适应自身的营销策略。同时我们经常发现淘宝搜索前列的商品许多为我们之前查看过的商品，这是通过记录用户行为，跑模型等方式智能为这些商品增加权重。
* 分词扩展，也许因为某些商品的特殊性，我们可以自定义扩展分词字典，更精准、人性化的搜索。
* 高亮功能，es提供highlight高亮功能，我们在淘宝上看到的商品展示中对搜索关键字高亮，就是通过这种方式来实现。