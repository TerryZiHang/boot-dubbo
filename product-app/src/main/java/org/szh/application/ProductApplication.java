package org.szh.application;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.jboss.logging.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@SpringBootApplication(scanBasePackages = "org.szh")
@MapperScan("org.szh.mapper")
@ImportResource(locations = { "dubbo-provider.xml" })
public class ProductApplication {

	private static Logger logger = Logger.getLogger(ProductApplication.class);
	private static final String MYABTIS_CONFIG_PATH = "mybatis-config.xml";
	private static final String LOCATION_PATTERN = "classpath:/mybatis-mapper/*.xml";
	private static volatile boolean running = true;

	/**
	 * 配置连接池
	 * 
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return new DruidDataSource();
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(MYABTIS_CONFIG_PATH));
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(LOCATION_PATTERN));
		return sqlSessionFactoryBean.getObject();
	}

	/**
	 * 事务处理
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class,args);
		logger.debug("==== APP Start ON SpringBoot Success ====");
		synchronized (ProductApplication.class) {
			while(running) {
				try {
					ProductApplication.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
