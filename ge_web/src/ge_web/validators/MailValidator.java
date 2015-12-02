package ge_web.validators;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "validators.mail")
public class MailValidator implements Validator, Serializable {
	private static final long serialVersionUID = 1L;
	private static final String MAIL_PATTERN = "[a-zA-Z0-9-._]+@[a-zA-Z0-9-._]+.[a-z]+";
	private Pattern pattern;
	private Matcher matcher;
		
	public MailValidator(){
		pattern = Pattern.compile(MAIL_PATTERN);
	}
	
	@Override
	public void validate(FacesContext arg0, UIComponent component, Object value) throws ValidatorException {
		matcher = pattern.matcher(value.toString()); 
		if(!matcher.matches()){
			FacesMessage msg = new FacesMessage("L'adresse mail n'est pas correcte.",
					"Entrez une adresse valide."); 
			msg.setSeverity(FacesMessage.SEVERITY_ERROR); 
			throw new ValidatorException(msg);
		}
		
	}

}
