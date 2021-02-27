/**
 * 
 */
package com.devOsLP.Prueba_JSP.controllers;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * @author becario4
 *
 */

@ManagedBean
public class LoginController {
	private String user;
	private String pass;

	public void ingresar() {
		System.out.println("User:" + user);

		if (user.equals("oscar") && pass.equals("12345")) {
			try {
				this.redireccionar("principal.xhtml");
			} catch (IOException e) {
				FacesContext.getCurrentInstance().addMessage("formLogin:txtuser",
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "La paguina no existe", ""));
				e.printStackTrace();
			}
			
		} else {

			FacesContext.getCurrentInstance().addMessage("formLogin:txtpass",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "usuario y contraseñas incorrectos", ""));
		}

	}
	
	/*Metodo de redireccionamiento de paginas*/
	/*Creando la segunda version*/
	public void redireccionar(String pagina) throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(pagina);
		
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

}
