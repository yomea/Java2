package youth.hong;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Upload extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream inputStream = req.getInputStream();

		File file = new File("D:/temp", "test.txt");
		if (!file.exists()) {
			file.getParentFile().mkdirs();
		}
		
		System.out.println(req.getContentLengthLong());
		
		// rw表示可读写
		RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");

		byte[] buff = new byte[1024];

		// 将文件的内容写入到test.txt查看它的内容部分
		// 从第五行开始到倒数第五行才是文件的内容，所以需要提取出来
		/*------WebKitFormBoundaryevO1J37xgdQaAPJK
		Content-Disposition: form-data; name="file"; filename="8771615_144122554190_2.jpg"
		Content-Type: image/jpeg
		
		?? JFIF  H H  ? C 
		
		
		
		
		? C		
		
		? €  ?             	? O  !1"AQaq?2B憽?#Rb裂r傖$3挗?C?%&5c馭sDu摚陈??            ? =   !1AQa"q亼2”裂疳BR#3?4br?C挗乱?   ? ?X?
		------WebKitFormBoundaryevO1J37xgdQaAPJK--
		銭?瑅檅慍$T?zH?鹬o??挂`屮螩讚瀵1婴'Zf愋??zPs灔砈酶?奠h涓鍺\G曊睼陂?焼jj猒侔PSU??諯W$?]w?拼掜撚'+^5◢?覶?ΖUL,И覆W?"i鞃?
		hs?€8n藻躹阭鏚k拵獨?}/?vl庣%d?盖狄v5濂胿|烯";GSo6Z
		5扠9碨識结蠝]gF的睅钬N謱7n?2G%{\?鍢6Obn幉??忺4跻曝酃?{ZL嵹鹨<[A+娳苯莉詍殩	铛t戄f咨K豕)椋|N壽樧?道凎崇宀膎鰨琡ゅ蒢o[鑾袚I[-忾ll赸諘阨閖卙朢?{鱋?橒Z 銕x笈穓F冻柒?Emm?垫褒^鞼p┖?mD:B?胰噼秲!??7g?9瀞Zu0污姦^n4麴哲?芒╬弔??拗1〗?? 訃g.?级Y碊H墨此SG55?T斺qOX舜蠛>鶴,粯? o?n|8/m挸??)."暠?铦G悭?柠a.芶挡;''w\瀥+踖Z6狯魉
		 */
		while ((inputStream.read(buff)) != -1) {
			randomAccessFile.write(buff, 0, buff.length);
		}
		// 定位从文件字符第零个开始
		randomAccessFile.seek(0);
		// 先读出一行，让指针指向第二行
		String firstLine = randomAccessFile.readLine();
		// 读取第二行，得到content-disposition,它存有文件信息
		String fileName = randomAccessFile.readLine();

		int endIndex = fileName.lastIndexOf("\"");

		int beginIndex = fileName.lastIndexOf("=\"");
		// 得到文件的名字
		fileName = fileName.substring(beginIndex + 2, endIndex);

		System.out.println(fileName);

		byte bt = 0;

		int n = 0;

		long startPos = 0;

		long endPos = 0;
		
		String lastLine = "";

		randomAccessFile.seek(0);

		// 循环读取字节，不是文件内容的行有四个，需要拿到文件内容开始的位置
		while ((bt = randomAccessFile.readByte()) != -1 && n <= 3) {
			if (bt == '\n') {
				// 得到文件指针位置
				startPos = randomAccessFile.getFilePointer();
				n++;
			}
		}
		
		// 得到文件结束的位置
		while ((lastLine = randomAccessFile.readLine()) != null) {
			if (lastLine.startsWith(firstLine)) {
				endPos = randomAccessFile.getFilePointer() - lastLine.getBytes().length;
				break;
			}
		}
		// 将文件指针定位到文件开始的位置
		randomAccessFile.seek(startPos);
		// 测试一下位置有没有找对
		System.out.println((char) randomAccessFile.readByte());

		randomAccessFile.seek(endPos);
		// 测试一下位置有没有找对
		System.out.println((char) randomAccessFile.readByte());

		randomAccessFile.seek(startPos);

		byte[] b = new byte[1024];
		// 得到当前文件的大小
		System.out.println("size" + (int) (endPos - startPos));

		// 将要保存的文件形式
		File f = new File("D:/temp", "hello" + fileName);

		FileOutputStream raf = new FileOutputStream(f, true);

		// 将文件输出
		while ((randomAccessFile.read(b)) != -1 && startPos < endPos) {
			startPos = randomAccessFile.getFilePointer();
			raf.write(b);
		}

		System.out.println("upload success!");
		randomAccessFile.close();
		inputStream.close();
		raf.close();
	}

}
