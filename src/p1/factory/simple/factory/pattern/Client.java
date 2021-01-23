package p1.factory.simple.factory.pattern;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * 简单工厂模式
 * <p>
 * 简单工厂模式(Simple Factory Pattern)：定义一个工厂类，
 * 它可以根据参数的不同返回不同类的实例，被创建的实例通
 * 常都具有共同的父类。因为在简单工厂模式中用于创建实例
 * 的方法是静态(static)方法，因此简单工厂模式又被称为静
 * 态工厂方法(Static Factory Method)模式，它属于类创建型模式。
 *
 *
 * @author create by Niancheng On 2021/1/23 19:17
 */
public class Client {
    public static void main(String[] args) throws Exception {

        System.out.println("======================");
        Product product;
        product = ProductFactory.getProduct("A"); //通过工厂类创建产品对象
        product.methodSame();
        product.methodDiff();

        System.out.println("======================");
        product = ProductFactory.getProduct("B"); //通过工厂类创建产品对象
        product.methodSame();
        product.methodDiff();
        System.out.println("==================================================================");

        Chart chart;
        chart = ChartFactory.getChart("histogram");
        chart.display();
        System.out.println("======================");

        chart = ChartFactory.getChart("pie");
        chart.display();
        System.out.println("======================");

        chart = ChartFactory.getChart("line");
        chart.display();

        System.out.println("======================");
        // xml配置文件
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document parse = builder.parse("src/p1/factory/simple/factory/pattern/config.xml");
        String chartType = parse.getElementsByTagName("chartType").item(0).getFirstChild().getNodeValue();

        chart = ChartFactory.getChart(chartType);
        chart.display();
    }

}
