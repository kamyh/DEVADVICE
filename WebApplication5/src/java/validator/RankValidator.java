
package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
 
@FacesValidator("validator.RankValidator")
public class RankValidator implements Validator{
 
	private static final String RANK_PATTERN = "([0-9]+)$";
 
	private Pattern pattern;
	private Matcher matcher;
 
	public RankValidator(){
		  pattern = Pattern.compile(RANK_PATTERN);
	}
 
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
 
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
 
			FacesMessage msg = 
				new FacesMessage("Rank validation failed. Only numerical value", 
						"Invalid field format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
                
                
 
	}
}