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
	
	
	
	
	//��ʾ�Ѿ���student��teacher����ӳ���ˣ���д��ൽstudentId�����������������˫������бر�
	/**
     * @OneToOne��һ��һ����
      * mappedBy = "teacher"����˼��˵�����һ��һ���òο���teacher
     * teacher����ʲô��?teacher��Icard���е�getTeacher(),ע�ⲻ��Icard���е�
      * teacher����,Icard���е�OneToOne���þ�����getTeacher()�����������.
     * ���Icard���е�getTeacher�����ĳ�getIdTeacher(),��������Ļ�,
     * �����Ҫд�ɣ�mappedBy = "idTeacher"
     */
	@OneToOne(mappedBy="teacher")
	/*@JoinColumns(
			value={@JoinColumn(name="tid"), @JoinColumn(name="name")}
	)*///���Բ�д
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
	@GenericGenerator(strategy="assigned", name="hh")*///����д����������Ĭ�Ͼ����ֶ��Ĳ���
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
