package src.com.netease.xyt.binding;

public class Son extends Father {
    //对于重写方法，子类无法修改访问权限小于父类
    /*private void test1() {

    }*/
    //不过访问权限可以修改为大于父类
    public final void test2() {

    }
    //不可重写private（相当于final）方法
    public void test3() {

    }
}
