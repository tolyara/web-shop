package jstl;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloWorldTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().print("Hello World!");
		} catch (IOException ioException) {
			throw new JspException("Error: " + ioException.getMessage());
		}
		return SKIP_BODY;
	}

}
