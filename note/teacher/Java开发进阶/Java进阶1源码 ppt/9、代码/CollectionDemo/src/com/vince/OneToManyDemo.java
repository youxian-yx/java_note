package com.vince;

/**
 * 对象的一对多关系
 * 
 * @author vince
 * @description
 */
public class OneToManyDemo {

	public static void main(String[] args) {

		Teacher t1 = new Teacher("张老师",18,"女");
		Student s1 = new Student("小李",10);
		Student s2 = new Student("小王",12);
		Student s3 = new Student("小赵",11);
		
		//关联关系
		t1.getStudents().add(s1);
		t1.getStudents().add(s2);
		t1.getStudents().add(s3);
		
		s1.setTeacher(t1);
		s2.setTeacher(t1);
		s3.setTeacher(t1);
		
		print(t1);
	}

	private static void print(Teacher t1) {
		System.out.println(t1.getName());
		for(Student s: t1.getStudents()){
			System.out.println(s);
		}
	}

}
