package com.deise.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deise.bookstore.domain.Categoria;
import com.deise.bookstore.domain.Livro;
import com.deise.bookstore.repositories.CategoriaRepository;
import com.deise.bookstore.repositories.LivroRepository;

@Service 
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Biologia", "Livros de Biologia");
		Categoria cat3 = new Categoria(null, "Matemática", "Livros de Matematica");
		
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Banco de Dados", "Thalia", "Lorem ipsum", cat1);
		Livro l3 = new Livro(null, "Contando mais", "Juan", "Lorem ipsum", cat3);
		Livro l4 = new Livro(null, "Abiogense", "Dylan", "Lorem ipsum", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l1,l2));
		cat2.getLivros().addAll(Arrays.asList(l4));
		cat3.getLivros().addAll(Arrays.asList(l3));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4));
	}

}
