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

@FacesValidator(value = "validators.telephone")
public class TelephoneValidator implements Validator, Serializable {

	private static final long serialVersionUID = 1L;
	private static final String TELEPHONE_PATTERN = "^0[1-9][0-9]{8}$";
	private Pattern pattern;
	private Matcher matcher;
		
	public TelephoneValidator(){
		pattern = Pattern.compile(TELEPHONE_PATTERN);
	}
	
	@Override
	public void validate(FacesContext arg0, UIComponent component, Object value) throws ValidatorException {
		matcher = pattern.matcher(value.toString()); 
		if(!matcher.matches()){
			FacesMessage msg = new FacesMessage("le numéro de téléphone n'est pas bon",
					"Entrez un nombre à 10 chiffres commençant par 0"); 
			msg.setSeverity(FacesMessage.SEVERITY_ERROR); 
			throw new ValidatorException(msg);
		}
		
	}

}