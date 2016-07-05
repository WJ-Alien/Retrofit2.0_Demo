package com.example.zenglb.retrofittest.http;

import com.example.zenglb.retrofittest.response.BaseResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 花落的那一天，消失的下雨天，好像再淋一遍。
 * 
 *
 * @author anylife.zlb@gmail.com
 */
public  class HttpCall<T> {

	private static String TAG=HttpCall.class.getSimpleName();  //调试TAG

	/**
	 * 只有这个方法对外暴露
	 *
	 * Call<T> call, Response<T> response  Call<ResponseBody>
	 */
	public  void call(final Call<BaseResponse> call, final HttpCallback httpCallback) {

		call.enqueue(new Callback<BaseResponse>() {
			@Override
			public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
				if(response.isSuccessful()){                        // code:[200,300）
                    int responseCode=response.body().getCode();     //这个code才是应用层的Code,进行进一步的数据和事件分发!
                    if(responseCode==HttpClient.HTTP_SUCCESS){
						httpCallback.onSuccess(response.body());
                    }else{
						httpCallback.onFailure(responseCode,response.body().getError());
                    }
                }else{
//                    try {
//                        textView.setText(TextUtils.convertUnicode(response.errorBody().string()+"@@@@"+response.code())); //try 的很是烦人
//                        Log.e(TAG,TextUtils.convertUnicode(response.errorBody().string()+"#####"+response.code()));
//                    }catch (IOException e){
//                        e.printStackTrace();
//                    }
                }
			}

			@Override
			public void onFailure(Call<BaseResponse> call, Throwable t) {

			}
		});


	} //httpCall function end。



}
