oa_06:

DWR�Ļ���ʹ�ã�

1������dwr.jar�ļ�
2���޸�web.xml�ļ������dwr servlet���ã�
  <servlet>
    <servlet-name>dwr-invoker</servlet-name>
    <servlet-class>org.directwebremoting.servlet.DwrServlet</servlet-class>
    <init-param>
      <param-name>debug</param-name>
      <param-value>true</param-value>
    </init-param>
  </servlet>
  <servlet-mapping>
    <servlet-name>dwr-invoker</servlet-name>
    <url-pattern>/dwr/*</url-pattern>
  </servlet-mapping> 
3����web-inf�������dwr.xml�����ļ���
4������ҳ��
����������javascript��

<script type="text/javascript" src="dwr/engine.js"></script>
<script type="text/javascript" src="dwr/util.js"></script>
<script type="text/javascript" src="dwr/interface/test.js"></script>

�����ʹ�ò��ԣ���ο�dwrtest��Ŀ��

----------------------------------------------------------------
Ȩ�޹����ʵ�֣�

1����¼֮�󣬸��ݵ�ǰ��¼��Ա��Ȩ�ޣ��г���ӵ��Ȩ�޵�����ģ�飨�ο�IndexAction.java/back_index.jsp��
2��ֻ�е�¼֮�󣬲ſ��Է��ʺ�̨ģ�飨�����BaseAction����ͳһ�ĵ�¼��֤��
	- ����execute���������������������¼��֤
3��ʵ�ּ�ʱ��֤����ֻ��ӵ����Ӧ��Ȩ�ޣ���������Ӧ�Ĳ�����
	- ����JSTL�������ο�SecurityFunctions.java��
	- ��JSPҳ���ϣ�����JSTL��������ʱ��֤��ֻ��ͨ����֤֮�󣬲���ʾ��Ӧ�Ĺ��ܰ�ť
