package br.com.fornow.solicitacao.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.fornow.solicitacao.model.Pessoa;
import br.com.fornow.solicitacao.model.TipoFiliacaoPessoa;

public class PessoaRepository {
	
	public static void main(String[] args) {
		List<Pessoa> pessoas = new PessoaRepository().listar();
		if (!pessoas.isEmpty()) {
			System.out.println(pessoas.get(0).getNome());
		}
	}
	
	public void salvar(Pessoa p){
		SessionFactory sessionFactory = Repository.getInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		session.persist(p);
		transaction.commit();
		session.close();
	}
	
	public List<Pessoa> listar(){
		SessionFactory sessionFactory = Repository.getInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query<Pessoa> createQuery = session.createQuery("Select a from Pessoa a", Pessoa.class);
		List<Pessoa> resultList = createQuery.getResultList();
		return resultList;
	}
	
	public void atualizarPessoa(Pessoa p){
		SessionFactory sessionFactory = Repository.getInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.merge(p);
		transaction.commit();
		session.close();
	}

	public void deletarPessoa(long id) {
		SessionFactory sessionFactory = Repository.getInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Pessoa find = session.find(Pessoa.class, id);
		session.remove(find);
		transaction.commit();
		session.close();
	}

	public Pessoa procurarPessoaPorId(long id) {
		SessionFactory sessionFactory = Repository.getInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Pessoa find = session.find(Pessoa.class, id);
//		session.close();
		return find;
	}

	public Pessoa listarPorId(long id) {
		Pessoa pessoa = procurarPessoaPorId(id);
		return pessoa;
	}

	public List<Pessoa> listarClientes(){
		SessionFactory sessionFactory = Repository.getInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query<Pessoa> createQuery = session.createQuery("Select a from Pessoa a where a.tiposFiliacao = ? ", Pessoa.class);
		createQuery.setParameter(1, TipoFiliacaoPessoa.CLIENTE);
		List<Pessoa> resultList = createQuery.getResultList();
		return resultList;
	}
	
	public List<Pessoa> listarFornecedores() {
		SessionFactory sessionFactory = Repository.getInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query<Pessoa> createQuery = session.createQuery("Select a from Pessoa a where a.tiposFiliacao = :filiacao ", Pessoa.class);
		createQuery.setParameter("filiacao", TipoFiliacaoPessoa.FORNECEDOR);
//		createQuery.setParameter(1, TipoFiliacaoPessoa.FORNECEDOR);
		List<Pessoa> resultList = createQuery.getResultList();
		return resultList;
	}
}
