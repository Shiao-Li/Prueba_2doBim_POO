import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class estudiantes {
    private JPanel panel1;
    private JTextField ingresarID;
    private JTextField ingresarNombre;
    private JTextField ingresarCelular;
    private JTextField ingresarCorreo;
    private JComboBox comboBoxSEXO;
    private JComboBox comboBoxESTUDIOS;
    private JButton crearButton;
    private JButton buscarButton;
    private JButton actualizarButton;
    private JButton borrarButton;
    private JButton cancelarButton;
    private JButton borrarCamposButton;
    PreparedStatement ps;

    Statement pss;


    public estudiantes() {
        comboBoxSEXO.setEnabled(false);
        comboBoxESTUDIOS.setEnabled(false);
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con;
                try {
                    con = getConection();
                    ps = con.prepareStatement("INSERT INTO infoestudiantes (`idestudiante`, `nombreEstudiante`, `celularEstudiante`, `correoEstudiante`) VALUES(?,?,?,?)");
                    ps.setString(1, ingresarID.getText());
                    ps.setString(2, ingresarNombre.getText());
                    ps.setString(3, ingresarCelular.getText());
                    ps.setString(4, ingresarCorreo.getText());

                    System.out.println(ps);//imprimo en consola para verificación

                    int res = ps.executeUpdate();

                    if (res > 0) {
                        JOptionPane.showMessageDialog(null, "Estudiante creado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al crear al estudiante");
                    }

                    con.close();//importante!!!!
                } catch (HeadlessException | SQLException f) {
                    System.err.println(f);
                }
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBoxSEXO.setEnabled(true);
                comboBoxESTUDIOS.setEnabled(true);
                Connection con;
                try {
                    con = getConection();
                    pss= con.createStatement();
                    ResultSet rs, rss;
                    rs=pss.executeQuery("select * from estudiantes.infoestudiantes where idestudiante= " + ingresarID.getText()+";");
                    DefaultComboBoxModel model = new DefaultComboBoxModel();
                    while (rs.next()){
                        ingresarNombre.setText(rs.getString("nombreEstudiante"));
                        ingresarCorreo.setText(rs.getString("correoEstudiante"));
                        ingresarCelular.setText(rs.getString("celularEstudiante"));
                    }


                    con.close();//importante!!!!
                }catch (HeadlessException | SQLException f){
                    System.err.println(f);
                }
            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con;

                try{
                    con = getConection();
                    ps = con.prepareStatement("UPDATE infoestudiantes SET nombreEstudiante = ?, celularEstudiante = ?, correoEstudiante = ? WHERE idestudiante ="+ingresarID.getText() );

                    ps.setString(1, ingresarNombre.getText());
                    ps.setString(2, ingresarCelular.getText());
                    ps.setString(3, ingresarCorreo.getText());

                    System.out.println(ps);
                    int res = ps.executeUpdate();

                    if(res > 0){
                        JOptionPane.showMessageDialog(null, "Persona modificada correctamente");
                    }else{
                        JOptionPane.showMessageDialog(null, "Persona no modificada");
                    }
                    con.close();

                }catch (HeadlessException | SQLException f){
                    System.out.println(f);
                }
            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con = null;
                PreparedStatement ps = null;
                try {
                    con = getConection();
                    ps = con.prepareStatement("DELETE FROM estudiantes.infoestudiantes WHERE idestudiante = ?");
                    ps.setInt(1, Integer.parseInt(ingresarID.getText()));

                    int res = ps.executeUpdate();
                    if (res > 0) {
                        JOptionPane.showMessageDialog(null, "Estudiante eliminado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar");
                    }
                    con.close();//importante!!!!
                } catch (HeadlessException | SQLException f) {
                    System.err.println(f);
                }
            }
        });


        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        borrarCamposButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingresarID.setText(null);
                ingresarNombre.setText(null);
                ingresarCorreo.setText(null);
                ingresarCelular.setText(null);
            }
        });
    }

    public static void main(String[] arg) {
        JFrame frame1 = new JFrame("Registro");
        estudiantes f1 = new estudiantes();

        frame1.setContentPane(f1.panel1);
        frame1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame1.pack();
        frame1.setSize(600, 400);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }

    public static Connection getConection() {
        Connection con = null;
        String base = "estudiantes"; //Nombre de la base de datos
        String url = "jdbc:mysql://localhost:3306/" + base; //Direccion, puerto y nombre de la Base de Datos
        String user = "root"; //Usuario de Acceso a MySQL
        String password = "root1"; //Password del usuario

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
        return con;
    }
}
