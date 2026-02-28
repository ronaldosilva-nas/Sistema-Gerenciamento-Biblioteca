package servicos;
import java.util.List;
import java.util.Optional;
import entidades.Usuario;
import java.util.ArrayList;

public class UsuarioService {
    private List<Usuario> usuarios;

    public UsuarioService() {
        this.usuarios = new ArrayList<>();
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Optional<Usuario> buscarPorMatricula(int matricula) {
        for (Usuario u : usuarios) {
            if (u.getMatricula() == matricula) {
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }
}
