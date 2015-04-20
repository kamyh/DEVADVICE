
package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
 
@FacesValidator("validator.CommentValidator")
public class CommentValidator implements Validator{
 
 
 
	public CommentValidator(){
	}
 
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

                
                if(value.toString().length() < 1){
 
			FacesMessage msg = 
				new FacesMessage("Password validation failed. Too short, write somethings !", 
						"Invalid field format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
 
	}
}