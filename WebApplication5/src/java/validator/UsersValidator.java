
package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
 
@FacesValidator("validator.UsersValidator")
public class UsersValidator implements Validator{
 
	private static final String USERS_PATTERN = "([A-Za-z]+)$";
 
	private Pattern pattern;
	private Matcher matcher;
 
	public UsersValidator(){
		  pattern = Pattern.compile(USERS_PATTERN);
	}
 
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
 
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
 
			FacesMessage msg = 
				new FacesMessage("User validation failed.", 
						"Invalid field format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
                
                
 
	}
}