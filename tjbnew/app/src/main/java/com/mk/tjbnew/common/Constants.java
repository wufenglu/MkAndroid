package com.mk.tjbnew.common;


/**
 * 公共的值
 *
 */
public class Constants {

	//文件夹名字
	public static final String COMPRESSBEFORE_FILEPATH = "tijianbaoapp";//图片压缩之前缓存目录
	public static final String COMPRESSAFTER_FILEPATH = "tijianbaoappimage";//图片压缩之后缓存目录

//	/**上传文件地址**/
//	public static final String FILE_PATH = "http://darlingwallet.com:8080/";
	/** 微信appid */
	public static final String WEIXIN_APP_ID ="wxfb2f14b966c014cd";
	/** 微信 secret id */
	public static final String WEIXIN_SECRET_ID ="251a27e500f51e8824b9ed33e3c9a56e";
	/** qq appid */
	public static final String QQ_APP_ID ="1105366784";
	//	public static final String QQ_APP_ID ="1104892046";//钱包
	//微博
	public static final String WEIBO_APP_KEY = "3945263816";
	public static final String CACHE_PATH="/tijianbaoapp/";

	public static final float aspectRatio=1.5f;
//	public static final String WEIBO_APP_KEY = "1025048455";

//	/** 测试服务器地址 */
//	public static String SERVER_PATH ="http://dev.darlingwallet.com/";
//	public static String SERVER_SHOPPING_PATH = "http://tourdev.darlingwallet.com";//cheyupin服务器地址


	/** 网络标识值 */
	public static class NetValue{

		public static final int STATUS_NO_NETWORK =1;
		public static final int STATUS_TIMEOUT =2;
		public static final int STATUS_UNKNOWN =3;
		public static final String TIP_NO_NETWORK ="网络不给力";
		public static final String TIP_TIMEOUT ="连不上服务器";
		public static final String TIP_UNKNOWN ="服务器错误";
	}

	/** 微信信息 */
	public static class WECHAT_INFO{
		public static final String WECHAT_OPENID ="wechat_openid";
		public static final String WECHAT_NAME ="wechat_name";
		public static final String WECHAT_TOKEN ="wechat_token";
	}

	/** weibo信息 */
	public static class WEIBO_INFO{
		public static final String WEIBO_OPENID ="wechat_openid";
		public static final String WEIBO_NAME ="wechat_name";
		public static final String WEIBO_TOKEN ="wechat_token";
	}

	/** qq信息 */
	public static class QQ_INFO{
		public static final String QQ_OPENID ="wechat_openid";
		public static final String QQ_NAME ="wechat_name";
		public static final String QQ_TOKEN ="wechat_token";
	}





}
