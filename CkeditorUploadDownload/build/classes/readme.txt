struts2+ckeditor + ckfinder

1、拷贝工程（struts2）
2、拷贝ckeditor
3、拷贝ckfinder
4、引入jar
5、引入ckeditor里的config.xml修改 
	enabled = true
	<baseDir></baseDir>
	<baseURL>/ckscxz/userfiles/</baseURL>
6、修改web.xml
    配置CKEditor的servlet等信息
    struts2拦截 /* ,ckeditor的servlet优先被struts2拦截
	二种方式：
	1、修改struts2拦截设置 将/* 修改为*.action或*.do
	2、自定义CKeditor的过滤器,让它来继承Struts2的过滤器FilterDispatcher
	   获得完整的http url的地址,然后判断URL地址中是否包含CKEditor的servlet
	   拦截规则"/ckfinder/core/connector/java /*/",
	   若包含,struts2就不拦截该URL请求,而直接转发,交给CKEditor的servlet来处理;
	   若不包含，则拦截器拦截该URL请求,由struts2来处理

7、ckeditor config.js配置
	config.language =  "zh-cn" ; 
	config.image_previewText = ' ';

	config.filebrowserBrowseUrl =  '/ckscxz/ckfinder/ckfinder.html' ;  
    config.filebrowserImageBrowseUrl =  '/ckscxz/ckfinder/ckfinder.html?type=Images' ;  
    config.filebrowserFlashBrowseUrl =  '/ckscxz/ckfinder/ckfinder.html?type=Flash' ;  
    config.filebrowserUploadUrl =  '/ckscxz/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files' ;  
    config.filebrowserImageUploadUrl =  '/ckscxz/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images' ;  
    config.filebrowserFlashUploadUrl =  '/ckscxz/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash' ;  
    config.filebrowserWindowWidth = '1000';  
    config.filebrowserWindowHeight = '700';  
    
    ---------------关于破解------------------
    --图片预览文字替换ckeditor/config.js
    config.image_previewText = " ";
    -----------------------------------
    --ckfinder/ckfinder.js
	--浏览服务器左下角信息不展示   下面代码注释 
    if (!D) this.dV().getChild(0).appendHtml(A || B || y != 4 ? t: u + "\x3c\142\x3e" + k.htmlEncode(a.ed) + "\x3c\057\142\x3e\x3c\x2f\x64\151\166\x3e");
    -----------------------------------
    --隐藏版权信息
    找到<h4 class='message_content'>
    改为<h4 style='display:none;' class='message_content'>
    
	 -----------------------------------
     --避免上传文件乱码，将上传文件名以时间戳命名
    解决办法：修改源码FileUploadCommand.class  getFileItemName方法
    
    