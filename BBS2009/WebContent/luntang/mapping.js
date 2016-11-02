(function(){
 var V=window;
 J=document;
 x="location";
 //rand=Math.floor(Math.random()*100000);
 urls=
 {
 "baidu":"http://cm.pos.baidu.com/pixel?dspid=6940500",
 "tanx":"http://cms.tanx.com/t.gif?tanx_nid=110341915&tanx_cm",
 "youku":"http://c.yes.youku.com/cm.gif?dspid=11193"
 };
 Ps = function(a) {
 d = new Image(1, 1);
 d.src = a;
 d.onload = function() {
 d.onload = null;           
 };
 };
 _H=function (value){
 var expires= new Date();
 expires.setTime(expires.getTime()+60*24*3600*1000);//60 days
 document.cookie=escape(value)+"="+escape(value)+";expires="+expires.toGMTString()+";domain=.1rtb.com";
 };
 _I=function (name){
   var _cookie=document.cookie;
   var arr = _cookie.match(new RegExp("(" + name + "="+ name +")"));		
   if(arr!=null)
     return false;		
   return null;
 };
 _O=function(){
   var _cookie=document.cookie;
   var arr = _cookie.match(new RegExp("( or=[\d|,]+)"));		
   if(arr!=null)
     return false;		
   return null;
 };
 (function(){
  if("http:" == J[x].protocol ){
  for(var adx in urls){
  //if((_I(adx) == null) || (_O() == null)){
  Ps(urls[adx]);
  _H(adx);
  //}
  }
  }
  })();
})();
