package qy.lab;

import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

public class LabEventListener implements ApplicationListener<ApplicationPreparedEvent> {
	@Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        SpringApplication app = event.getSpringApplication();        
        ConfigurableApplicationContext context = event.getApplicationContext();
        ConfigurableListableBeanFactory bf = context.getBeanFactory();
        
        
        
        System.out.println("++++Test: LabEventListener...");
		
		for (String t : bf.getBeanDefinitionNames()) {
			System.out.println(t);
		}
    }
}
