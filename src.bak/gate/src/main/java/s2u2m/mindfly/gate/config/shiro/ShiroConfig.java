package s2u2m.mindfly.gate.config.shiro;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import s2u2m.mindfly.gate.config.shiro.realm.JwtTokenRealm;
import s2u2m.mindfly.gate.config.shiro.realm.UserNamePasswordRealm;

@Configuration
public class ShiroConfig {



	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

		// set realms
		List<Realm> realms = Arrays.asList(
			(Realm)new UserNamePasswordRealm(),
			new JwtTokenRealm());
		securityManager.setRealms(realms);

		// disable session
		securityManager.setSubjectFactory(subjectFactory());
		securityManager.setSessionManager(sessionManager());

		DefaultSubjectDAO subjectDAO = (DefaultSubjectDAO) securityManager.getSubjectDAO();
		DefaultSessionStorageEvaluator evaluator =
			(DefaultSessionStorageEvaluator)subjectDAO.getSessionStorageEvaluator();
		evaluator.setSessionStorageEnabled(false);

		return  securityManager;
	}

	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
		factoryBean.setSecurityManager(securityManager);

		// config filters
		Map<String, String> filterChainMap = new LinkedHashMap<String, String>();

		filterChainMap.put("/register", "anon");

//		filterChainMap.put("/login", "logout");
		filterChainMap.put("/logout", "logout");

		return factoryBean;
	}

	@Bean
	public DefaultWebSubjectFactory subjectFactory(){
		StatelessDefaultSubjectFactory subjectFactory = new StatelessDefaultSubjectFactory();
		return subjectFactory;
	}

	@Bean
	public DefaultSessionManager sessionManager(){
		DefaultSessionManager sessionManager = new DefaultSessionManager();
		sessionManager.setSessionValidationSchedulerEnabled(false);
		return sessionManager;
	}

}
