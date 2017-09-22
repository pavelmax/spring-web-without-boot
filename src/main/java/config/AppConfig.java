package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@PropertySource(value = "classpath:db.properties")
@ComponentScan(value = "controller")
public class AppConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private Environment environment;

    @Bean
    public ViewResolver resolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setCache(false);
        resolver.setPrefix("");
        resolver.setSuffix(".ftl");
        resolver.setContentType("text/html; charset=utf-8");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/pages/");
        return freeMarkerConfigurer;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(final DataSource source) {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(source);
        localSessionFactoryBean.setPackagesToScan("model.entity");

        Properties hibernateProperties = localSessionFactoryBean.getHibernateProperties();
        hibernateProperties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        hibernateProperties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
        return localSessionFactoryBean;
    }
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(environment.getProperty("db.driver.name"));
        driverManagerDataSource.setUsername(environment.getProperty("db.user.name"));
        driverManagerDataSource.setPassword(environment.getProperty("db.user.password"));
        driverManagerDataSource.setUrl(environment.getProperty("db.url"));
        return driverManagerDataSource;
    }

}
