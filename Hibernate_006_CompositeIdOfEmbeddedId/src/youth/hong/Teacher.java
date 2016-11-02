package youth.hong;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Entity(name="t_teacher")
public class Teacher {
	private TeacherPK pk;
	private Title title;
	
	private Icard card;
	
	public Teacher() {}
	
	
	
	
	//表示已经被student的teacher属性映射了，不写会多到studentId这个外键，这个属性在双向关联中必备
	/**
     * @OneToOne：一对一关联
      * mappedBy = "teacher"：意思是说这里的一对一配置参考了teacher
     * teacher又是什么呢?teacher是Icard类中的getTeacher(),注意不是Icard类中的
      * teacher属性,Icard类中的OneToOne配置就是在getTeacher()方法上面配的.
     * 如果Icard类中的getTeacher方法改成getIdTeacher(),其他不变的话,
     * 这里就要写成：mappedBy = "idTeacher"
     */
	@OneToOne(mappedBy="teacher")
	/*@JoinColumns(
			value={@JoinColumn(name="tid"), @JoinColumn(name="name")}
	)*///可以不写
	public Icard getCard() {
		return card;
	}






	public void setCard(Icard card) {
		this.card = card;
	}






	public Teacher(TeacherPK pk, Title title) {
		
		this.pk = pk;
		this.title = title;
	}
	@EmbeddedId
	/*@GeneratedValue(generator="hh")
	@GenericGenerator(strategy="assigned", name="hh")*///不用写，联合主键默认就是手动的策略
	public TeacherPK getPk() {
		return pk;
	}



	public void setPk(TeacherPK pk) {
		this.pk = pk;
	}



	@Enumerated(EnumType.ORDINAL)/*@Enumerated(EnumType.STRING)*/
	public Title getTitle() {
		return title;
	}



	public void setTitle(Title title) {
		this.title = title;
	}

	
}
