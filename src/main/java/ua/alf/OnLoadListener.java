package ua.alf;

import ua.alf.task.PickInformationTask;
import ua.alf.util.HibernateUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Eugene Chipachenko
 * Date: 20.04.2014
 * Time: 14:36
 */
public class OnLoadListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ThreadPoolManager.getInstance();
        HibernateUtil.getSessionFactory();

        ThreadPoolManager.getInstance().scheduleAtFixedRate(new PickInformationTask(), 5, 60 * 60 * 24, TimeUnit.SECONDS);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed");

        ThreadPoolManager.getInstance().shutdown();
        HibernateUtil.shutdown();

        Enumeration<Driver> drivers = DriverManager.getDrivers();

        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                System.out.println("Unregistered: " + driver.getClass());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
