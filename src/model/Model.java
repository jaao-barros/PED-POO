package model;

import java.time.LocalDateTime;
import java.util.*;

import view.Observer;

public class Model {
    private static Model instancia;
    private final Map<Integer, Coordenacao> coordenacoes;
    private final Map<Integer, Curso> cursos;
    private final Map<Integer, Disciplina> disciplinas;
    private final Map<Integer, PlanoDeEnsino> planosDeEnsino;
    private final Map<Integer, Professor> professores;
    private final Map<Integer, UnidadeAcademica> unidadesAcademicas;
    private final Set<Observer> observers;
    private Usuario usuarioLogado;
    private Map<Integer, Usuario> usuarios;

    public Map<Integer, Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Map<Integer, Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    private Model() {
        coordenacoes = new HashMap<>();
        cursos = new HashMap<>();
        disciplinas = new HashMap<>();
        planosDeEnsino = new HashMap<>();
        professores = new HashMap<>();
        unidadesAcademicas = new HashMap<>();
        observers = new HashSet<>();
        usuarios = new HashMap<>();
    }

    public static Model getInstancia() {
        if (instancia == null) {
            instancia = new Model();
        }

        return instancia;
    }

    public Map<Integer, Coordenacao> getCoordenacoes() {
        return coordenacoes;
    }

    public Map<Integer, Curso> getCursos() {
        return cursos;
    }

    public Map<Integer, Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public Map<Integer, PlanoDeEnsino> getPlanosDeEnsino() {
        return planosDeEnsino;
    }

    public Map<Integer, Professor> getProfessores() {
        return professores;
    }

    public Map<Integer, UnidadeAcademica> getUnidadesAcademicas() {
        return unidadesAcademicas;
    }

    public Set<Observer> getObservers() {
        return observers;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public boolean adicionarCoordenacao(Coordenacao coordenacao) {
        if (coordenacao == null) {
            throw new IllegalArgumentException("Coordenação não pode ser nula");
        }

        int idCoordenacao = coordenacao.getIdCoordenacao();

        if (coordenacoes.containsKey(idCoordenacao)) {
            return false;
        }

        coordenacoes.put(idCoordenacao, coordenacao);
        notificarObservers();

        return true;
    }

    public boolean removerCoordenacao(int idCoordenacao) {
        if (coordenacoes.remove(idCoordenacao) != null) {
            notificarObservers();
            return true;
        }

        return false;
    }

    public Coordenacao buscarCoordenacaoPorId(int idCoordenacao) {
        return coordenacoes.get(idCoordenacao);
    }

    public boolean adicionarCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("Curso não pode ser nulo");
        }

        int idCurso = curso.getIdCurso();

        if (cursos.containsKey(idCurso)) {
            return false;
        }

        cursos.put(idCurso, curso);
        notificarObservers();

        return true;
    }

    public boolean removerCurso(int idCurso) {
        if (cursos.remove(idCurso) != null) {
            notificarObservers();
            return true;
        }

        return false;
    }

    public Curso buscarCursoPorId(int idCurso) {
        return cursos.get(idCurso);
    }

    public boolean adicionarDisciplina(Disciplina disciplina) {
        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina não pode ser nula");
        }

        int id = disciplina.getIdDisciplina();

        if (disciplinas.containsKey(id)) {
            return false;
        }

        disciplinas.put(id, disciplina);
        notificarObservers();

        return true;
    }

    public boolean removerDisciplina(int idDisciplina) {
        if (disciplinas.remove(idDisciplina) != null) {
            notificarObservers();
            return true;
        }

        return false;

    }

    public Disciplina buscarDisciplinaPorId(int idDisciplina) {
        return disciplinas.get(idDisciplina);
    }

    public Disciplina buscarDisciplinaPorCodigo(String codigoDisciplina) {
        for (Disciplina disciplina : disciplinas.values()) {
            if (disciplina.getCodigoDisciplina().equals(codigoDisciplina)) {
                return disciplina;
            }
        }

        return null;
    }

    public boolean adicionarPlanoDeEnsino(PlanoDeEnsino plano) {
        if (plano == null) {
            throw new IllegalArgumentException("Plano de Ensino não pode ser nulo");
        }

        int id = plano.getIdPlanoDeEnsino();

        if (planosDeEnsino.containsKey(id)) {
            return false;
        }

        planosDeEnsino.put(id, plano);
        notificarObservers();

        return true;
    }

    public boolean removerPlanoDeEnsino(int idPlano) {
        if (planosDeEnsino.remove(idPlano) != null) {
            notificarObservers();
            return true;
        }

        return false;
    }

    public PlanoDeEnsino buscarPlanoDeEnsinoPorId(int idPlano) {
        return planosDeEnsino.get(idPlano);
    }

    public boolean adicionarProfessor(Professor professor) {
        if (professor == null) {
            throw new IllegalArgumentException("Professor não pode ser nulo");
        }

        int id = professor.getIdProfessor();

        if (professores.containsKey(id)) {
            return false;
        }

        professores.put(id, professor);
        notificarObservers();

        return true;
    }

    public boolean removerProfessor(int idProfessor) {
        if (professores.remove(idProfessor) != null) {
            notificarObservers();
            return true;
        }

        return false;
    }

    public Professor buscarProfessorPorId(int idProfessor) {
        return professores.get(idProfessor);
    }

    public boolean adicionarUnidadeAcademica(UnidadeAcademica unidade) {
        if (unidade == null) {
            throw new IllegalArgumentException("Unidade Acadêmica não pode ser nula");
        }

        int id = unidade.getIdUnidadeAcademica();

        if (unidadesAcademicas.containsKey(id)) {
            return false;
        }

        unidadesAcademicas.put(id, unidade);
        notificarObservers();

        return true;
    }

    public boolean removerUnidadeAcademica(int idUnidade) {
        if (unidadesAcademicas.remove(idUnidade) != null) {
            notificarObservers();
            return true;
        }

        return false;
    }

    public UnidadeAcademica buscarUnidadeAcademicaPorId(int idUnidade) {
        return unidadesAcademicas.get(idUnidade);
    }

    public void notificarObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public boolean adicionarObserver(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer não pode ser nulo");
        }

        return observers.add(observer);
    }

    public boolean removerObserver(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer não pode ser nulo");
        }

        return observers.remove(observer);
    }

    public boolean adicionarUsuario(Usuario novoUsuario) {

        if (novoUsuario == null) {

            throw new IllegalArgumentException("Usuário não pode ser nulo");

        }

        int id = novoUsuario.getId();

        if (usuarios.containsKey(id) || existeMatricula(novoUsuario.getMatricula())) {

            return false;

        }

        usuarios.put(id, novoUsuario);

        notificarObservers();

        return true;

    }



    public Usuario buscarUsuarioPorId(int id) {

        return usuarios.get(id);

    }



    public boolean existeMatricula(String matricula) {

        if (matricula == null) return false;

        return usuarios.values().stream().anyMatch(u -> u.getMatricula() != null && u.getMatricula().equals(matricula));

    }



    public int gerarIdUnico() {

        int id = 1;

        while (usuarios.containsKey(id)) {

            id++;

        }

        return id;

    }





    public List<Disciplina> buscarDisciplinasPorProfessor(int idProfessor) {

        List<Disciplina> disciplinasDoProfessor = new ArrayList<>();



        for (PlanoDeEnsino plano : this.planosDeEnsino.values()) {



            if (plano.getIdProfessor() == idProfessor) {

                Disciplina disciplina = this.disciplinas.get(plano.getIdDisciplina());



                if (disciplina != null && !disciplinasDoProfessor.contains(disciplina)) {

                    disciplinasDoProfessor.add(disciplina);

                }

            }

        }

        return disciplinasDoProfessor;

    }





    public void aprovarPlano(PlanoDeEnsino plano) {

        if (plano != null) {

            plano.setStatus(StatusPlano.APROVADO);

            plano.setDataUltimaModificacao(LocalDateTime.now());

            planosDeEnsino.put(plano.getIdPlanoDeEnsino(), plano);

            notificarObservers();

        }

    }

    public void reprovarPlano(PlanoDeEnsino plano, String justificativa) {

        if (plano != null) {

            plano.setStatus(StatusPlano.REPROVADO);

            plano.setJustificativa(justificativa);

            plano.setDataUltimaModificacao(LocalDateTime.now());

            planosDeEnsino.put(plano.getIdPlanoDeEnsino(), plano);

            notificarObservers();

        }

    }

    public void atualizarPlano(PlanoDeEnsino plano) {

        if (plano != null) {

            plano.setDataUltimaModificacao(LocalDateTime.now());

            planosDeEnsino.put(plano.getIdPlanoDeEnsino(), plano);

            notificarObservers();

        }

    }



    public void salvarRascunho(PlanoDeEnsino plano) {

        if (plano == null) throw new IllegalArgumentException("Plano não pode ser nulo.");



        plano.setStatus(StatusPlano.PENDENTE);

        plano.setDataUltimaModificacao(LocalDateTime.now());

        planosDeEnsino.put(plano.getIdPlanoDeEnsino(), plano);



        System.out.println("Plano salvo como rascunho.");

        notificarObservers();

    }



    public void submeterParaAprovacao(PlanoDeEnsino plano) {

        if (plano == null) throw new IllegalArgumentException("O Plano não pode ser nulo.");



        plano.setStatus(StatusPlano.EM_REVISAO);

        plano.setDataUltimaModificacao(LocalDateTime.now());



        planosDeEnsino.put(plano.getIdPlanoDeEnsino(), plano);



        System.out.println("O Plano foi submetido para aprovação.");

        notificarObservers();

    }



    public List<PlanoDeEnsino> buscarTodosPlanosSubmetidos() {

        List<PlanoDeEnsino> planosSubmetidos = new ArrayList<>();



        for (PlanoDeEnsino plano : this.planosDeEnsino.values()) {

            if (plano.getStatus() == StatusPlano.EM_REVISAO) {

                planosSubmetidos.add(plano);

            }

        }

        return planosSubmetidos;

    }



    public List<PlanoDeEnsino> buscarPlanosPorProfessor(int idProfessor) {

        List<PlanoDeEnsino> planosDoProfessor = new ArrayList<>();

        for (PlanoDeEnsino plano : this.planosDeEnsino.values()) {

            if (plano.getIdProfessor() == idProfessor) {

                planosDoProfessor.add(plano);

            }

        }

        return planosDoProfessor;

    }



    public List<PlanoDeEnsino> buscarPlanosAprovadosPorAluno(int idAluno) {

        List<PlanoDeEnsino> planosAprovados = new ArrayList<>();



        for (PlanoDeEnsino plano : this.planosDeEnsino.values()) {

            if (plano.getStatus() == StatusPlano.APROVADO) {

                planosAprovados.add(plano);

            }

        }

        return planosAprovados;

    }
}