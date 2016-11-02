
二维码的分类： //线性堆叠式二维码 //矩阵式二维码 //邮政码

/*

目前流行的三大国际标准
PDF417：不支持中文
DM：专利未公开，需支付专利费用
QR code：专利公开，支持中文
Quick Response Code

QR code比其他二维码相比，具有识读速度快，数据密度大，占用空间小的优势。

QR Code是有日本Demso公司于1994年研制的一种矩阵二维码符号码

纠错能力：

L级：约可纠错7%的数据码字
M级：约可纠错15%的数据码字
Q级：约可纠错25%的数据码字
H级：约可纠错30%的数据码字
纠错能力越高，存储的数据就越少
第一种方法
借助第三方jar如zxing和QR Code jar
第二种方法
javascript如jQuery.qrcode.js
/
https://github.com/jeromeetienne/jquery-qrcode下载js插件
下载后按照它的文档进行设置
zxingjar包的下载，请移步到https://github.com/zxing/zxing/wiki/Getting-Started-Developing，或者去maven库下载，只需要下载core包和javase包即可