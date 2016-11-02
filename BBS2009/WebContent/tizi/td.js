(function(){
var _window=window,
    _document=document,
    x="location",
    Md = "https:" == _document.location.protocol ? "https://cm.1rtb.com": "http://cm.1rtb.com",
    Md1 = "https:" == _document.location.protocol ? "https://cm1.1rtb.com": "http://cm1.1rtb.com",
    Pd = function(url) {
        var host = Md + "/track",
        img = new Image(1, 1);
        img.src = host + url;
        img.onload = function() {
            loadJS("/html/mapping.html");           
        };
    },
    parm=function(){
        var _mdsp=_window._mdsp;
        var url = "";
        var ro = _window.ro;
        for(var s=0;s<_mdsp.length;s++){
          for(var i=0;i<_mdsp[s].length;i++){
            //console.log(_mdsp[s][i]);
            url=url + _mdsp[s][i];
          }
        }
        var rs=Math.random();
        
        url = url + "&r="+rs;
        url = url + "&src="+encodeURIComponent(window.location.href);
        if(ro){
        	url = url + "&ro=" + encodeURIComponent(ro);
        }
        Pd(url);
    },
    loadJS = function (path) {
        var mtd = document.createElement('iframe'); mtd.async = true;
        mtd.src = ('https:' == document.location.protocol ? 'https://d.1rtb.com' : 'http://d.1rtb.com') + path;
        mtd.width = 0; mtd.height = 0; mtd.setAttribute("frameborder","0",0);
        mtd.style.display = "none";
        var s = document.getElementsByTagName('body')[0]; s.parentNode.insertBefore(mtd, s);
        
    };
        
    (function(){parm();})();
})();
