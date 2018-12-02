package qy.lab;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class AppInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext ac) {
		ConfigurableListableBeanFactory bf = ac.getBeanFactory();
		
		System.out.println("++++Test: AppInitializer...");
		
		for (String t : bf.getBeanDefinitionNames()) {
			System.out.println(t);
		}
		
	}
	
}