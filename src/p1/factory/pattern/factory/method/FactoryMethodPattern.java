package p1.factory.pattern.factory.method;


/**
 * 工厂方法模式(Factory Method Pattern)：
 * <p>
 * 定义一个用于创建对象的接口，
 * 让子类决定将哪一个类实例化。工厂方法模式让一个类的实例化延迟到其
 * 子类。工厂方法模式又简称为工厂模式(Factory Pattern)，又可称作虚
 * 拟构造器模式(Virtual Constructor Pattern)或多态工厂模式(Polymorphic Factory Pattern)。
 * 工厂方法模式是一种类创建型模式。
 *
 * @author create by Niancheng On 2021/1/24 16:24
 */
public class FactoryMethodPattern {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Logger logger;
        LogFactory logFactory;
//        logFactory = new FileLoggerFactory();
        logFactory = (LogFactory) Class.forName("p1.factory.pattern.factory.method.FileLoggerFactory").newInstance();
//        logger = logFactory.createLogger();
//        logger.writeLog();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
//        logFactory = (LogFactory) Class.forName("p1.factory.factory.method.DataBaseLoggerFactory").newInstance();
        logFactory.writeLog();
//        logger = logFactory.createLogger();
//        logger.writeLog();
    }
}

abstract class LogFactory {

    public void writeLog(){
        Logger logger = this.createLogger();
        System.out.println(logger);
        logger.writeLog();
    }

    abstract Logger createLogger();
}

class FileLoggerFactory extends LogFactory {

    @Override
    public Logger createLogger() {
        return new FileLogger();
    }
}

class DataBaseLoggerFactory extends LogFactory {

    @Override
    public Logger createLogger() {
        return new DataBaseLogger();
    }
}

class FileLogger implements Logger {
    public FileLogger() {
        System.out.println("创建文件日志！");
    }

    @Override
    public void writeLog() {
        System.out.println("文件日志记录！");
    }
}

class DataBaseLogger implements Logger {

    public DataBaseLogger() {
        System.out.println("创建数据库日志！");
    }

    @Override
    public void writeLog() {
        System.out.println("数据库日志记录！");
    }
}

interface Logger {
    void writeLog();
}