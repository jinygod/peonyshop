package config;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import beans.UserBean;
import interceptor.CheckLoginInterceptor;
import interceptor.TopMenuInterceptor;
import mapper.AdminMapper;
import mapper.BasketMapper;
import mapper.GoodsMapper;
import mapper.NoticeMapper;
import mapper.OrderMapper;
import mapper.TopMenuMapper;
import mapper.UserMapper;
import service.TopMenuService;

// Spring MVC 프로젝트에 관련된 설정을 하는 클래스
@Configuration
// Controller 어노테이션이 셋팅되어 있는 클래스를 Controller로 등록한다.
@EnableWebMvc
// 스캔할 패키지를 지정한다.
@ComponentScan("controller")
@ComponentScan("service")
@ComponentScan("dao")



@PropertySource("/WEB-INF/properties/db.properties")
public class ServletAppContext implements WebMvcConfigurer{
	
	@Value("${db.classname}")
	private String db_classname;
	
	@Value("${db.url}")
	private String db_url;
	
	@Value("${db.username}")
	private String db_username;
	
	@Value("${db.password}")
	private String db_password;
	
	@Autowired
	private TopMenuService topMenuService;
	
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
	
	// Controller의 메서드가 반환하는 jsp의 이름 앞뒤에 경로와 확장자를 붙혀주도록 설정한다.
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	// 정적 파일의 경로를 매핑한다.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	// 데이터베이스 접속 정보를 관리하는 Bean
		@Bean
		public BasicDataSource dataSource() {
			BasicDataSource source = new BasicDataSource();
			source.setDriverClassName(db_classname);
			source.setUrl(db_url);
			source.setUsername(db_username);
			source.setPassword(db_password);
			
			return source;
		}
		
		// 쿼리문과 접속 정보를 관리하는 객체
		@Bean
		public SqlSessionFactory factory(BasicDataSource source) throws Exception{
			SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
			factoryBean.setDataSource(source);
			SqlSessionFactory factory = factoryBean.getObject();
			return factory;
		}
		
		// 쿼리문 실행을 위한 객체(Mapper 관리)
		@Bean
		public MapperFactoryBean<UserMapper> getUserMapper(SqlSessionFactory factory) throws Exception{
			MapperFactoryBean<UserMapper> factoryBean = new MapperFactoryBean<UserMapper>(UserMapper.class);
			factoryBean.setSqlSessionFactory(factory);
			return factoryBean;
		}
		
		@Bean
		public MapperFactoryBean<AdminMapper> getAdminMapper(SqlSessionFactory factory) throws Exception{
			MapperFactoryBean<AdminMapper> factoryBean = new MapperFactoryBean<AdminMapper>(AdminMapper.class);
			factoryBean.setSqlSessionFactory(factory);
			return factoryBean;
		}
		
		@Bean
		public MapperFactoryBean<NoticeMapper> getNoticeMapper(SqlSessionFactory factory) throws Exception{
			MapperFactoryBean<NoticeMapper> factoryBean = new MapperFactoryBean<NoticeMapper>(NoticeMapper.class);
			factoryBean.setSqlSessionFactory(factory);
			return factoryBean;
		}
		
		@Bean
		public MapperFactoryBean<TopMenuMapper> getTopMenuMapper(SqlSessionFactory factory) throws Exception{
			MapperFactoryBean<TopMenuMapper> factoryBean = new MapperFactoryBean<TopMenuMapper>(TopMenuMapper.class);
			factoryBean.setSqlSessionFactory(factory);
			return factoryBean;
		}
		
		@Bean
		public MapperFactoryBean<GoodsMapper> getGoodsMapper(SqlSessionFactory factory) throws Exception{
			MapperFactoryBean<GoodsMapper> factoryBean = new MapperFactoryBean<GoodsMapper>(GoodsMapper.class);
			factoryBean.setSqlSessionFactory(factory);
			return factoryBean;
		}
		
		@Bean
		public MapperFactoryBean<BasketMapper> getBasketMapper(SqlSessionFactory factory) throws Exception{
			MapperFactoryBean<BasketMapper> factoryBean = new MapperFactoryBean<BasketMapper>(BasketMapper.class);
			factoryBean.setSqlSessionFactory(factory);
			return factoryBean;
		}
		
		@Bean
		public MapperFactoryBean<OrderMapper> getOrderMapper(SqlSessionFactory factory) throws Exception{
			MapperFactoryBean<OrderMapper> factoryBean = new MapperFactoryBean<OrderMapper>(OrderMapper.class);
			factoryBean.setSqlSessionFactory(factory);
			return factoryBean;
		}
		
		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			// TODO Auto-generated method stub
			WebMvcConfigurer.super.addInterceptors(registry);
			
			TopMenuInterceptor topMenuInterceptor = new TopMenuInterceptor(topMenuService, loginUserBean);
			InterceptorRegistration reg1 = registry.addInterceptor(topMenuInterceptor);
			reg1.addPathPatterns("/**");
			
			CheckLoginInterceptor checkLoginInterceptor = new CheckLoginInterceptor(loginUserBean);
			InterceptorRegistration reg2 = registry.addInterceptor(checkLoginInterceptor);
			// 로그아웃된 상태에서는 접근 불가능한 메뉴 (정보수정, 로그아웃)
			reg2.addPathPatterns("/user/modify", "/user/logout");
		}
		
		@Bean
		public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() {
			return new PropertySourcesPlaceholderConfigurer();
		}
		
		@Bean
		public ReloadableResourceBundleMessageSource messageSource() {
			ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
			res.setBasenames("/WEB-INF/properties/error_message");
			return res;
		}
		
		// multipart/form-data 세팅 시 일반적으로 요청을 할때 데이터를 전달하는 방식이 아닌 다른 방식을 사용하기 때문에
		// Controller에서 자동으로 주입되지 않는 현상이 나타나기 때문에 아래 빈을 정의해줌
		@Bean
		public StandardServletMultipartResolver multipartResolver() {
			return new StandardServletMultipartResolver();
		}
		
}










