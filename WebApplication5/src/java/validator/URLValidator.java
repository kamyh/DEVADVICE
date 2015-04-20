
package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
 
@FacesValidator("validator.URLValidator")
public class URLValidator implements Validator{
 
	private static final String USERS_PATTERN = "(^[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*([-a-zA-Z0-9+&@#/%=~_|])+(\\.[A-Za-z]{2,}))$";
 
	private Pattern pattern;
	private Matcher matcher;
 
	public URLValidator(){
		  pattern = Pattern.compile(USERS_PATTERN);
	}
 
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
 
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
 
			FacesMessage msg = 
				new FacesMessage("Url validation failed.", 
						"Invalid field format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
                
                
 
	}
}