import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Managesystem { public static void main(String[] args) {
    List<Stu> list = new ArrayList();
    while (true) {
        System.out.println("********学生信息管理系统********");
        System.out.println("1->查询学生");
        System.out.println("2->增加学生");
        System.out.println("3->修改学生");
        System.out.println("4->删除学生");
        System.out.println("0->退出系统");
        String key = new Scanner(System.in).nextLine();
        switch (key) {
            case "1":
                findAll(list);
                break;
            case "2":
                System.out.println("请输入增加的学生学号:");
                String id = new Scanner(System.in).nextLine();
                System.out.println("请输入增加的学生姓名:");
                String name = new Scanner(System.in).nextLine();
                add(list, id, name);
                break;
            case "3":
                System.out.println("请输入要修改的学生学号:");
                String editID = new Scanner(System.in).nextLine();
                System.out.println("请输入要修改的学生姓名:");
                String editName = new Scanner(System.in).nextLine();
                edit(list, editID, editName);//
                break;
            case "4":
                System.out.println("请输入要删除的学生学号:");
                String delID = new Scanner(System.in).nextLine();
                delete(list, delID);
                break;
            default:
                System.out.println("退出系统");
                System.exit(0);
                break;
        }
    }
}
    public static void findAll(List<Stu> list) {
        if (list.size() == 0) {
            System.out.println("暂无学生信息，请返回重试!");
            return;
        } else {
            for (Stu stu : list) {
                System.out.println("学号:"+ stu.getId() + "\n" +"姓名:" + stu.getName());
            }
        }
    }
    public static void add(List<Stu> list, String id, String name) {

        for (Stu stu : list) {
            if (stu.getId().equals(id)) {
                System.out.println("学号重复，请返回重试!");
                return;
            }
        }
        Stu s = new Stu(id, name);
        list.add(s);
        System.out.println("添加成功!");
    }
    public static void edit(List<Stu> list, String editID, String editName) {
        for (Stu stu : list) {
            if (!stu.getId().equals(editID)) {
                System.out.println("该学生不存在，请返回重试!");
                return;
            } else {
                stu.setName(editName);
                list.set(Integer.parseInt(editID) - 1, stu);
                System.out.println("修改成功!");
            }
        }
    }
    public static void delete(List<Stu> list, String delID) {
        for (Stu stu : list) {
            if (!stu.getId().equals(delID)) {
                System.out.println("该学生不存在，请返回重试!");
                return;
            } else {
                list.remove(Integer.parseInt(delID) - 1);
                System.out.println("删除成功!");
                break;
            }
        }
    }
}
