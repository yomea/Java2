oa_02:

分页逻辑的封装处理（请参考AbstractManager.java）

为了避免在Action（呈现层）和Manager（业务逻辑层）之间传递大量的参数，
可以使用ThreadLocal模式来传递分页参数（包括：offset和pagesize）。
	- 定义： 参考SystemContext.java
	- 往ThreadLocal中赋值：参考PagerFilter.java
	- 从ThreadLocal中获取分页参数：参考AbstractManager.java


