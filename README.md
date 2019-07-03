# 中国软件杯
## 基于追溯处理机制的运维服务大数据的安全与共享
## 说明
> 数据共享后缺乏有效的监管手段，需要针对共享方在数据中增加特定的水印来保障数据的可追溯性，在共享方非法出售数据后，通过数据中的水印判别出售者的身份，便于追溯。

### 赛题业务场景
> 1.从A设备中选取不少于1万条数据进行分析，取得分析结果，分析内容可自行确定。
>
> 2.对选取得数据集进行增加水印处理
>
> 3.把增加水印后得数据集导入B设备
>
> 4.把B设备导入的数据进行分析，取得结果
>
> 5.对B设备中的数据集中选取部分数据子集，从数据子集中对水印进行提取追溯

### 功能性需求
> * 水印与共享方身份唯一绑定
> *  水印的增加无法被共享方人为或通过分析工具剔除
> * 水印不影响整体数据的分析结果
> * 通过水印可鉴别和追溯

### 非功能性需求
>简单的方式展示数据的分析结果、水印、以及水印提取追溯结果

## 实现思路
>首先题目要求的是用关系型数据库，需要在数据库表中插入水印数据或者将数据按照某种规则重新排列。
>题目要求可以删除部分数据后提取出水印内容，这里采用了`分组`的概念，每个分组以同样的规律的嵌入`标记`，规律是按照每组的`主键`或`字符长度`计算哈希值，按照哈希值查找相应的`行` ，`列`，以同样的规律提取水印。

## 核心代码阅读顺序
>`Sort`-->`Embed`-->`Extract`

# 详细内容
>### 数据集样式（截取部分）
>![alt text](https://github.com/Feithle/RuanJianBei/blob/master/src/main/webapp/img/readmeimg/1.jpg)
￼
>### 数据说明：
>       本数据是景区评价文本数据
>
>### 嵌入水印：
>`输入详细内容`
￼>![alt text](https://github.com/Feithle/RuanJianBei/blob/master/src/main/webapp/img/readmeimg/2.jpg)
>`等待`

￼ 
>
￼

>### 插入数据后的表现（数据库）
>       与插入前无异
>![alt text](https://github.com/Feithle/RuanJianBei/blob/master/src/main/webapp/img/readmeimg/1.jpg)
￼
>### 插入数据前后的数据分析结果（情感分析)
>![alt text](https://github.com/Feithle/RuanJianBei/blob/master/src/main/webapp/img/readmeimg/1.gif)
￼
>
>        文本型数据库数据表中插入了'回车'与‘换行’对情感分析并没有影响
>
>### 解析水印
>![alt text](https://github.com/Feithle/RuanJianBei/blob/master/src/main/webapp/img/readmeimg/3.jpg)
￼>![alt text](https://github.com/Feithle/RuanJianBei/blob/master/src/main/webapp/img/readmeimg/4.jpg)

￼

>### 删除部分数据集
>
>       提取结果与上述相同，具体原理下面介绍。
# 原理
>* 针对文本型数据库的水印嵌入技术，嵌入水印要向文本行中插入不影响文本使用的的不可见字符；
>* 可用的不可见字符有`\n`,`\r`
>* 转义：汉字、字符、字母组合-->`\n`,`\r`组合
>* 插入过程：按照规律插入，也要按照相同的规律提取，满足删除数据仍可以提取水印。对每行进行哈希值计算（具体计算依据查看代码），用哈希值对行进行优先级排序，根据用户输入的密钥与水印内容对排序后的行进行分组，每组插入含义相同的元码，这样如果不知将其中一组或多组删内的行全部删除，则不会影响数据的提取。
