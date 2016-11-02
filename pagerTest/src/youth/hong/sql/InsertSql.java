package youth.hong.sql;

public class InsertSql {
	public static void main(String[] args) {
		StringBuilder sql = new StringBuilder("insert into t_student values");
		for(int i = 0; i < 100; i++) {
			sql.append("(null,'youth" + i + "',2,22,'ÃÀ¹ú'),");
		}
		sql = sql.deleteCharAt(sql.length() - 1);
		sql = sql.insert(sql.length(), "\\g");
		
		System.out.println(sql);
	}
}
