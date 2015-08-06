package net.kalpas.web.init;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import net.kalpas.VKCore.VKModule;

@Configuration
@ComponentScan("net.kalpas")
@Import(VKModule.class)
public class WebAppConfig extends WebMvcConfigurerAdapter {

	// private static final String DATABASE_DRIVER = "db.driver";
	// private static final String DATABASE_PASSWORD = "db.password";
	// private static final String DATABASE_URL = "db.url";
	// private static final String DATABASE_USERNAME = "db.username";
	//
	// private static final String HIBERNATE_DIALECT = "hibernate.dialect";
	// private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	// private static final String ENTITYMANAGER_PACKAGES_TO_SCAN =
	// "entitymanager.packages.to.scan";

	@Autowired
	private Environment         env;

	// @Bean
	// public DataSource dataSource() {
	// DriverManagerDataSource dataSource = new DriverManagerDataSource();
	//
	// dataSource.setDriverClassName(env.getRequiredProperty(DATABASE_DRIVER));
	// dataSource.setUrl(env.getRequiredProperty(DATABASE_URL));
	// dataSource.setUsername(env.getRequiredProperty(DATABASE_USERNAME));
	// dataSource.setPassword(env.getRequiredProperty(DATABASE_PASSWORD));
	//
	// return dataSource;
	// }

	// @Bean
	// public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	// LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new
	// LocalContainerEntityManagerFactoryBean();
	// entityManagerFactoryBean.setDataSource(dataSource());
	// entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
	// entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty(ENTITYMANAGER_PACKAGES_TO_SCAN));
	// entityManagerFactoryBean.setJpaProperties(hibernateProperties());
	// return entityManagerFactoryBean;
	// }

	// private Properties hibernateProperties() {
	// Properties properties = new Properties();
	// properties.put(HIBERNATE_DIALECT,
	// env.getRequiredProperty(HIBERNATE_DIALECT));
	// properties.put(HIBERNATE_SHOW_SQL,
	// env.getRequiredProperty(HIBERNATE_SHOW_SQL));
	// return properties;
	// }

	// @Bean
	// public JpaTransactionManager transactionManager() {
	// JpaTransactionManager transactionManager = new JpaTransactionManager();
	// transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
	// return transactionManager;
	// }

	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(86400);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(86400);
		registry.addResourceHandler("/css/img/**").addResourceLocations("/css/img/").setCachePeriod(86400);
	}

	// @Bean
	// public CacheManager cacheManager() {
	// GuavaCacheManager cacheManager = new GuavaCacheManager();
	// cacheManager.setCacheBuilder(CacheBuilder.newBuilder().expireAfterAccess(30,
	// TimeUnit.MINUTES));
	// return cacheManager;
	// }

	// @Bean
	// public CommonsMultipartResolver multipartResolver() {
	// CommonsMultipartResolver resolver = new CommonsMultipartResolver();
	// resolver.setMaxUploadSize(10485760);
	// return resolver;
	// }
}