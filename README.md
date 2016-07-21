# Retrofit2.0_Demo

假如你的api和github API 一样，请忽视以下内容，关掉本页面。but 假如你的服务器返回的数据格式如下,请往下看：

        {
            "code": 0,
                "error": "",
                "result": {
            "access_token": "TYzoqRfQHREwJTqJilISD2pL6tsGAO",
                    "token_type": "Bearer",
                    "expires": "2016-01-12 17:13:13",
                    "refresh_token": "7zVkOEYimZoRkx4WdZuiLAiramBAHN",
                    "scopes": "all"
        }
        }


Retrofit2.0 练习使用，依托Retrofit2.0（+okhttp3） 的强大,根据服务器的api再次封装一下。更加简洁的Http请求处理.http 包和newhttp是两种封装样式，个人推荐下面的简洁访问样式（在 newhttp 包下面）

如果你喜欢，give me A Star,thx


        //1.登录提交的参数
        LoginParams loginParams=new LoginParams();
        loginParams.setClient_id("43244444444443214321");
        loginParams.setClient_secret("4444444432222143214321");
        loginParams.setGrant_type("password");
        loginParams.setUsername("1882656xxxx");
        loginParams.setPassword("dddddd");

        //2.实例化Http的请求。泛型语法比较晦涩，然而我感觉很精简
        Call<HttpResponse<LoginResult>> checkMobileCall = xHttpCall.getApiService(this).goLogin(loginParams); //尝试登陆
        checkMobileCall.enqueue(new HttpCallBack<HttpResponse<LoginResult>>() {
            @Override
            public void onSuccess(HttpResponse<LoginResult> loginResultHttpResponse) {
                Log.e(TAG, loginResultHttpResponse.getResult());
                textView.setText(loginResultHttpResponse.getResult());
            }

            @Override
            public void onFailure(int code,String message) {
                textView.setText(code+"@@@@"+message);

            }
        });

More：any question,please contact me at anylife.zlb@gmail.com
