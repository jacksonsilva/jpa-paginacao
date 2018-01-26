package br.com.estudo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.estudo.jpa.filters.UsuarioFilters;
import br.com.estudo.jpa.model.Usuario;
import br.com.estudo.jpa.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping("/usuario/save")
	public String save() {

		char[] possivel = "1234567890abcdefghijklmnopqrstuvxywz1a2b3c4d5d6f7g9h9j0i".toCharArray();
		char[] buff = new char[11];

		Random generated = new Random();

		for (int a = 0; a < 101; a++) {
			for (int i = 0; i < 11; i++) {
				buff[i] = possivel[generated.nextInt(possivel.length)];
			}

			String gerado = new String(buff);

			Usuario usuario = new Usuario();
			usuario.setEmail("email" + a + "_@estudo.com.br");
			usuario.setNome(gerado);
			usuario.setPassword(gerado.toCharArray());
			usuario.setUltimonome(gerado);
			
			usuarioService.save(usuario);
		}
		
		return "ok";
	}

	@RequestMapping(value="/usuario/list/{page}", method=RequestMethod.GET)
	public String listUsuarios(@PathVariable int page, Model model) {

		UsuarioFilters usuarioFilters = new UsuarioFilters();
		
		usuarioFilters.setPageNumber(page);

		List<Usuario> usuarios = usuarioService.retornaTodosUsuarios(usuarioFilters);

		for (Usuario usuario : usuarios) {
			System.out.println(usuario.getNome());
		}

		model.addAttribute("users", usuarios);
		
		return "ok";
	}
}
