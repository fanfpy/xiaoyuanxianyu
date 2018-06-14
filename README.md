# 二手交易平台
###  SpringBoot+Spring-Data-JPA


#API描述
    

    
**简要描述：** 

- 返回首页需要的数据 热门和最新商品

**请求URL：** 
- ` https://2.fanfpy.top/xianyu/api/goods/new/{num} `

##### 热门商品同例

- `https://2.fanfpy.top/xianyu/api/goods/hot/{num}`
  
**请求方式：**
- GET 

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|num |是  |Integer |列表数量   |


**返回示例**

```
{
	"code":0,
	"msg":"成功",
	"data":[
		{
			"goodsId": 1,
			"userId": 1,
			"userName":"fanfpy",
			"userImg":"https:xxx.caom/xxx.jpg",
			"goodsTitlie":"小米mix2s",
			"price" : 2999.0,
			"date" "2018-05-03 22:39:26"
			"status":0,
			"pageView":2,
			"describle": "描述：一面科技一面艺术",
			"goodsImg":[
				"img":"https:xxx.caom/xxx.jpg",
				"img":"https:xxx.caom/xxx.jpg",
				"img":"https:xxx.caom/xxx.jpg",
			]
		},
		{
			"goodsId": 2,
			"userId": 1,
			"userName":"fanfpy",
			"userImg":"https:xxx.caom/xxx.jpg",
			"goodsTitlie":"vivoX20",
			"price" : 3999.0,
			"date" "2018-05-03 14:22:16"
			"status":0,
			"pageView":2,
			"describle": "两千万柔光双摄，照亮你的美",
			"goodsImg":[
				"img":"https:xxx.caom/xxx.jpg",
				"img":"https:xxx.caom/xxx.jpg",
				"img":"https:xxx.caom/xxx.jpg",
			]
		}
	]
}
```

**简要描述：** 
- 商品详细页

**请求url**

- `https://2.fanfpy.top/xianyu/api/goods/id/{id}`

**请求类型**

- GET

返回示例

```json
{
	"code":0,
	"msg":"成功",
	"data":{
		 "goodsId": 1,
            "userId": 1,
            "userName":"fanfpy",
            "userImg":"https:xxx.caom/xxx.jpg",
            "goodsTitlie":"小米mix2s",
            "price" : 2999.0,
            "date" "2018-05-03 22:39:26"
            "status":0,
			"pageView":2,
            "describle": "描述：一面科技一面艺术",
            "goodsImg":[
                "img":"https:xxx.caom/xxx.jpg",
                "img":"https:xxx.caom/xxx.jpg",
                "img":"https:xxx.caom/xxx.jpg",
            ]
	}
}
```

**通过分类id返回商品列表**


**请求URL：** 
- ` http://2.fanfpy.top/xianyu/api/goods/class/{classId} `
  
**请求方式：**
- GET 

**参数：** 

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|classId |是  |Integer |分类id   |


 **返回示例**

```
{
	"code" :0,
	"msg":"成功",
	"data":[
		{
			"goodsId": 2,
			"userId": 1,
			"userName":"fanfpy",
			"userImg":"https:xxx.caom/xxx.jpg",
			"goodsTitlie":"vivoX20",
			"price" : 3999.0,
			"date" "2018-05-03 14:22:16"
			"status":0,
			"pageView":2,
			"describle": "两千万柔光双摄，照亮你的美",
			"goodsImg":[
				"img":"https:xxx.caom/xxx.jpg",
				"img":"https:xxx.caom/xxx.jpg",
				"img":"https:xxx.caom/xxx.jpg",
			]
		},
		{
			"goodsId": 2,
			"userId": 1,
			"userName":"fanfpy",
			"userImg":"https:xxx.caom/xxx.jpg",
			"goodsTitlie":"vivoX20",
			"price" : 3999.0,
			"date" "2018-05-03 14:22:16"
			"status":0,
			"pageView":2,
			"describle": "两千万柔光双摄，照亮你的美",
			"goodsImg":[
				"img":"https:xxx.caom/xxx.jpg",
				"img":"https:xxx.caom/xxx.jpg",
				"img":"https:xxx.caom/xxx.jpg",
			]
		}
	]
}
}
```

**添加商品**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|userId |是  |Integer |用户id   |
|classification |是  |Integer |分类id   |
|commentNum |是  |Integer |评论数 默认为空   |
|describle |是  |String |商品描述   |
|name |是  |String |价格   |
|status |是  |Integer | 商品状态0为上架 1为下架   |
|pageView |是  |Integer |查看数 默认为0   |

**添加图片**

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|goodsId |是  |Integer |商品id   |
|file |是  |file |上传的图片   |


