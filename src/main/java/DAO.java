import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DAO { //data access object
    public boolean existeUsuario (Usuario usuario) throws Exception{
        String sql = "select * from tb_usuario " +
                "where login = ? and senha = ?";
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection conn = factory.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             ps.setString(1, usuario.getNome());
             ps.setString(2, usuario.getSenha());
             try (ResultSet rs = ps.executeQuery()) {
                 return rs.next();
             }  
        }
    }
}
