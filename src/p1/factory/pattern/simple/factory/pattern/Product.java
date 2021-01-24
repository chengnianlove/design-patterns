package p1.factory.pattern.simple.factory.pattern;

/**
 * @author create by Niancheng On 2021/1/23 19:33
 */
public abstract class Product {

    //所有产品类的公共业务方法
    public void methodSame() {
        //公共方法的实现
        System.out.println("the same method");
    }

    //声明抽象业务方法
    public abstract void methodDiff();

}

class ConcreteProductA extends Product{
    @Override
    public void methodDiff() {
        System.out.println("ConcreteProductA");
    }
}


class ConcreteProductB extends Product{
    @Override
    public void methodDiff() {
        System.out.println("ConcreteProductB");
    }
}

class ProductFactory {
    //静态工厂方法
    public static Product getProduct(String arg) {
        Product product = null;
        if (arg.equalsIgnoreCase("A")) {
            product = new ConcreteProductA();
            //初始化设置product
        }
        else if (arg.equalsIgnoreCase("B")) {
            product = new ConcreteProductB();
            //初始化设置product
        }
        return product;
    }

}
