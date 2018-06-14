# 二手交易平台
###  SpringBoot+Spring-Data-JPA


#API描述
    
**简要描述：** 

- 返回首页需要的数据 热门和最新商品

**请求URL：** 
- ` https://2.fanfpy.top/xianyu/api/goods/new/list `
  
**请求方式：**
- GET 

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
			"describle": "描述：一面科技一面艺术",
			"goodsImg":[
				{
					"img":"https:xxx.caom/xxx.jpg",
				},
				{
					"img":"https:xxx.caom/xxx.jpg",
				},
				{
					"img":"https:xxx.caom/xxx.jpg",
				}
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
			"describle": "两千万柔光双摄，照亮你的美",
			"goodsImg":[
				{
					"img":"https:xxx.caom/xxx.jpg",
				},
				{
					"img":"https:xxx.caom/xxx.jpg",
				},
				{
					"img":"https:xxx.caom/xxx.jpg",
				}
			]
		}
	]
}
```

**简要描述：** 
- 商品详细页

**请求url**

- `https://2.fanfpy.top/xianyu/api/goods/{id}`

**请求类型**

- GET

返回示例

```json
{
	"code":0,
	"msg":"成功",
	"data":{
		"userId":1,
		"goodsId":1,
		"userImg":"https://xxx.com/xxx.jpg",
		"userName":"fanfpy",
		"updateTime":"2018-05-04 09:40:06",
		"describle" :"商品描述， 商品描述， 商品描述， 商品描述， 商品描述， 商品描述， 商品描述， 商品描述， 商品描述， 商品描述， 商品描述， 商品描述， 商品描述， 商品描述， 商品描述， 商品描述， 商品描述， 商品描述。",
		"goodImg":[
			{
				"img":"https://xxx.com/xxx.jpg"
			},
			{
				"img":"https://xxx.com/xxx.jpg"
			},
			{
				"img":"https://xxx.com/xxx.jpg"
			},
			{
				"img":"https://xxx.com/xxx.jpg"
			},
			{
				"img":"https://xxx.com/xxx.jpg"
			}
		],
		"goodsComments":[
			{
				"commentsUserId":1,
				"commentsUserName":"fanfpy",
				"comments":"评论内容",
				"commentsTime" : "2018-05-03 22:40:14"
			},
			{
				"commentsUserId":1,
				"commentsUserName":"fanfpy",
				"comments":"评论内容",
				"commentsTime" : "2018-05-03 22:40:14"
			}
		]
	}
}
```



