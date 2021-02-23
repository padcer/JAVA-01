package ass5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanApplication {
    @Autowired
    StudentBean4 studentBean4;

    public static void main(String[] args) {
        StudentBean1 studentBean1 = new StudentBean1();
        studentBean1.print();

        StudentBean2 studentBean2 = new StudentBean2();
        studentBean2.print();


        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentBean6 studentBean6 = (StudentBean6) context.getBean("student6");
        studentBean6.print();
    }

    public void print() {
        studentBean4.print();
    }

    private class Bean5 {
        @Autowired
        StudentBean5 studentBean5;

        public void print() {
            studentBean5.print();
        }
    }
}
