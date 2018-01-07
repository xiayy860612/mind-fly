package s2u2m.mindfly.gate.config.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;

/**
 *
 * @author xiayy860612
 */
public class StatelessDefaultSubjectFactory extends DefaultWebSubjectFactory {

	@Override
	public Subject createSubject(SubjectContext context) {
		//不创建session.
		context.setSessionCreationEnabled(false);
		return super.createSubject(context);
	}

}