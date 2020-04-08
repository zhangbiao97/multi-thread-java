package thread.core.uncaughtexception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 描述：自定义UncaughtExceptionHandler
 * <p>
 * Create By ZhangBiao
 * 2020/4/8
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    private String name;

    public MyUncaughtExceptionHandler(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.WARNING, t.getName() + "线程异常，终止啦！");
        System.out.println(name + "捕获了异常" + t.getName() + "异常");
    }
}
