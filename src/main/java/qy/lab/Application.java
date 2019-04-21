package qy.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:context.xml"})
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		SpringApplication app = new SpringApplication(Application.class);
		app.addListeners(new LabEventListener());
		app.addInitializers(new AppInitializer());
		ConfigurableApplicationContext cac = app.run(args);

		AppConfig apc = cac.getBean(AppConfig.class);

//		System.out.println(apc.getParams());
	}
}
