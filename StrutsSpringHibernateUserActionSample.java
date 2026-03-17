import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

/**
 * Sample Struts 2 Action managed by Spring and using Hibernate to save a user.
 *
 * Notes:
 * - Spring manages this action bean (@Controller + @Scope("prototype")).
 * - Struts 2 maps the action method via @Action.
 * - Hibernate persists the User inside a transaction.
 */
@Controller
@Scope("prototype")
@Namespace("/users")
public class StrutsSpringHibernateUserActionSample extends ActionSupport {

    @Autowired
    private SessionFactory sessionFactory;

    private String name;
    private String email;

    @Action(
        value = "save",
        results = {
            @Result(name = SUCCESS, location = "/WEB-INF/jsp/users/success.jsp"),
            @Result(name = INPUT, location = "/WEB-INF/jsp/users/form.jsp")
        }
    )
    @Transactional
    public String execute() {
        if (name == null || name.isBlank() || email == null || email.isBlank()) {
            addActionError("Name and email are required.");
            return INPUT;
        }

        Session session = sessionFactory.getCurrentSession();
        User user = new User();
        user.setName(name.trim());
        user.setEmail(email.trim());

        session.save(user);
        addActionMessage("User saved successfully.");
        return SUCCESS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Minimal placeholder entity for a single-file example.
     * In a real app, keep this in its own file with full JPA/Hibernate mapping.
     */
    public static class User {
        private Long id;
        private String name;
        private String email;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
