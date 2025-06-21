package br.com.sdvweb.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sdvweb.backend.dto.UserDTO;
import br.com.sdvweb.backend.entity.User;
import br.com.sdvweb.backend.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;

	public List<UserDTO> listarTodos() {
		List<User> user = userRepository.findAll();
		return user.stream().map(UserDTO::new).toList();
	}

	public void inserir(UserDTO usuario) {
		User user = new User(usuario);
		userRepository.save(user);
	}

	public UserDTO alterar(UserDTO usuario) {
		User user = new User(usuario);
		return new UserDTO(userRepository.save(user));
	}

	public void excluir(Long id) {
		User user = userRepository.findById(id).get();
		userRepository.delete(user);
	}

	public UserDTO login(String email, String senha) {
		User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Email não encontrado"));

		if (!user.getSenha().equals(senha)) {
			throw new RuntimeException("Senha incorreta");
		}

		return new UserDTO(user);

	}

}
