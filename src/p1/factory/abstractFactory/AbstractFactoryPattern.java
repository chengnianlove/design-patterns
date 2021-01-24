package p1.factory.abstractFactory;

/**
 * 抽象工厂模式(Abstract Factory Pattern)：
 * <p>
 * 提供一个创建一系列相关或相互依赖对象的接口，
 * 而无须指定它们具体的类。抽象工厂模式又称为
 * Kit模式，它是一种对象创建型模式。
 *
 * @author create by Niancheng On 2021/1/24 19:52
 */
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        SkinFactory skinFactory = new SpringSkinFactory();
        skinFactory.createComboBox().display();
        skinFactory.createButton().display();
        skinFactory.createTextField().display();
    }
}

/**
 * 抽象皮肤工厂
 * 1、 spring风格
 * 2、 其他风格
 */
abstract class SkinFactory {
    // 创建按钮样式
    public abstract Button createButton();

    // 创建文本框样式
    public abstract TextField createTextField();

    // 创建组合框样式
    public abstract ComboBox createComboBox();
}

/**
 * spring风格
 */
class SpringSkinFactory extends SkinFactory {

    @Override
    public Button createButton() {
        return new SpringButton();
    }

    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }

    @Override
    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}

/**
 * 按钮样式
 */
abstract class Button {
    public abstract void display();
}

class SpringButton extends Button {

    @Override
    public void display() {
        System.out.println("创建spring button!");
    }
}

/**
 * 文本框样式
 */
abstract class TextField {
    public abstract void display();
}

class SpringTextField extends TextField {

    @Override
    public void display() {
        System.out.println("创建spring text field!");
    }
}

/**
 * 组合框样式
 */
abstract class ComboBox {
    public abstract void display();
}

class SpringComboBox extends ComboBox {

    @Override
    public void display() {
        System.out.println("创建spring combo box");
    }
}