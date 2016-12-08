package utils;

import org.quartz.*;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by Alexandr on 08.12.2016.
 */
@WebListener
public class CurrencyQuartzListener implements ServletContextListener {

    private Scheduler scheduler;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        JobDetail job = JobBuilder.newJob(CurrencyUpdate.class)
                .withIdentity("myJob", "group1").build();

        // Trigger the job to run now, and then every 10 minutes
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInHours(3).repeatForever())
                .build();
        // Tell quartz to schedule the job using our trigger

        try {
            scheduler = ((StdSchedulerFactory) servletContextEvent.getServletContext()
                    .getAttribute(
                            QuartzInitializerListener.QUARTZ_FACTORY_KEY))
                    .getScheduler();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {

        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
