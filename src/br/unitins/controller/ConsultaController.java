package br.unitins.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.application.Util;
import br.unitins.dao.UsuarioDAO;
import br.unitins.model.Perfil;
import br.unitins.model.Usuario;

@Named
@ViewScoped
public class ConsultaController implements Serializable{

	private static final long serialVersionUID = -856921708297077261L;

	private Usuario usuario;

	private List<Usuario> listaUsuario = null;

	public ConsultaController() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		usuario = (Usuario) flash.get("usuarioFlash");
	}
	
	public void excluir(Usuario usuario) {
		UsuarioDAO dao = new UsuarioDAO();
		if (dao.delete(getUsuario().getId())) {
			limpar();
			// para atualizar o data table
			listaUsuario = null;
		}
		dao.closeConnection();
	}
	
	public void novo() {
		Util.redirect("cadastro.xhtml");
	}
	
	public void voltar() {
		Util.redirect("menu.xhtml");
	}

	public void limpar() {
		usuario = null;
	}
	
	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null) {
			UsuarioDAO dao = new UsuarioDAO();
			listaUsuario = dao.findAll();
			if (listaUsuario == null)
				listaUsuario = new ArrayList<Usuario>();
			dao.closeConnection();
		}
		return listaUsuario;
	}

	public Perfil[] getListaPerfil() {
		return Perfil.values();
	}

	public Usuario getUsuario() {
		if (usuario == null)
			usuario = new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}