/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.View;

import banco.AdminTableModel;
import banco.Banco;
import banco.CadastroClinica;
import banco.CadastroMedico;
import banco.ClienteTableModel;
import banco.ClinicaTableModel;
import banco.FuncaoTableModel;
import banco.FuncionarioTableModel;
import banco.MedicoTableModel;
import banco.Model.Admin;
import banco.Model.Cliente;
import banco.Model.Medico;
import banco.Model.Clinica;
import banco.Model.Funcao;
import banco.Model.Funcionario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author IFMS
 */
public final class CadastroAdm extends javax.swing.JFrame {

    private Connection conn;

    private List<Admin> Admins;
    private List<Clinica> Clinicas;
    private List<Medico> Medicos;
    private List<Cliente> Clientes;
    private List<Funcionario> Funcionarios;
    private List<Funcao> Funcao;

    private List<Medico> lmedico;
    private List<Clinica> lclinica;
    private List<Admin> ladmin;
    private List<Cliente> lcliente;
    private List<Funcionario> lfuncionario;
    private List<Funcao> lfuncao;

    /**
     * ALINHANOD TABELAS
     * =============================================================================================================================*
     */
    public void alinharTbAdmins(JTable tb) {
        AdminTableModel modeloAdmin = new AdminTableModel();

        DefaultTableCellRenderer dtcr = new DefaultTableCellHeaderRenderer();

        dtcr.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < 4; i++) {
            tb.getColumnModel().getColumn(i).setCellRenderer(dtcr);
        }
    }

    public void alinharTbClinicas(JTable tb) {
        ClinicaTableModel modeloClinica = new ClinicaTableModel();

        DefaultTableCellRenderer dtcr = new DefaultTableCellHeaderRenderer();

        dtcr.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < 4; i++) {
            tb.getColumnModel().getColumn(i).setCellRenderer(dtcr);
        }
    }

    public void alinharTbMedicos(JTable tb) {
        MedicoTableModel modeloMedico = new MedicoTableModel();

        DefaultTableCellRenderer dtcr = new DefaultTableCellHeaderRenderer();

        dtcr.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < 4; i++) {
            tb.getColumnModel().getColumn(i).setCellRenderer(dtcr);
        }
    }

    public void alinharTbClientes(JTable tb) {
        ClienteTableModel modeloCliente = new ClienteTableModel();

        DefaultTableCellRenderer dtcr = new DefaultTableCellHeaderRenderer();

        dtcr.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < 4; i++) {
            tb.getColumnModel().getColumn(i).setCellRenderer(dtcr);
        }
    }

    public void alinharTbFuncionarios(JTable tb) {
        FuncionarioTableModel modeloFuncionario = new FuncionarioTableModel();

        DefaultTableCellRenderer dtcr = new DefaultTableCellHeaderRenderer();

        dtcr.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < 4; i++) {
            tb.getColumnModel().getColumn(i).setCellRenderer(dtcr);
        }
    }

    public void alinharTbFuncao(JTable tb) {
        FuncaoTableModel modeloFuncao = new FuncaoTableModel();

        DefaultTableCellRenderer dtcr = new DefaultTableCellHeaderRenderer();

        dtcr.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < 4; i++) {
            tb.getColumnModel().getColumn(i).setCellRenderer(dtcr);
        }
    }

    /*========================================================================================================================================*/

 /*LISTANDO TABELAS ==================================================================================*/
    public List<Admin> listarTbAdmin() throws SQLException {
        Admins = new ArrayList<>();
        lclinica = new ArrayList<>();
        ladmin = new ArrayList<>();
        lcliente = new ArrayList<>();
        lmedico = new ArrayList<>();

        conn = Banco.conecta();
        if (conn == null || conn.isClosed()) {
            System.out.println("erro ao conectar ao banco de dados");
            System.exit(-1);
        }

        String sql = "SELECT idadmin, nome, login, senha, adm FROM Admin";
        System.out.println("sql: " + sql);

        //atravez desse objeto usamos comandos sql
        Statement stmt = conn.createStatement();

        //select
        ResultSet res = stmt.executeQuery(sql);

        while (res.next()) {
            System.out.print("id: " + res.getInt("idadmin"));
            System.out.print("nome: " + res.getString("nome"));
            System.out.print("login: " + res.getString("login"));
            System.out.print("senha: " + res.getString("senha"));
            System.out.print("adm: " + res.getInt("adm"));

            Admin a = new Admin();
            a.setIdadmin(res.getInt("idadmin"));
            a.setNome(res.getString("nome"));
            a.setLogin(res.getString("login"));
            a.setSenha(res.getString("senha"));
            a.setAdm(res.getInt("adm"));

            Admins.add(a);
        }
        stmt.close();
        conn.close();
        return Admins;

    }

    public List<Clinica> listarTbClinica() throws SQLException {
        Clinicas = new ArrayList<>();

        conn = Banco.conecta();
        if (conn == null || conn.isClosed()) {
            System.out.println("erro ao conectar ao banco de dados");
            System.exit(-1);
        }

        String sql = "SELECT idclinica, nome, cnpj, cidadeclinica, leito FROM Clinica";
        System.out.println("sql: " + sql);

        //atravez desse objeto usamos comandos sql
        Statement stmt = conn.createStatement();

        //select
        ResultSet res = stmt.executeQuery(sql);

        while (res.next()) {
            System.out.print("id: " + res.getInt("idclinica"));
            System.out.print("nome: " + res.getString("nome"));
            System.out.print("cnpj: " + res.getString("cnpj"));
            System.out.print("cidade clinica: " + res.getString("cidadeclinica"));

            Clinica a = new Clinica();;
            a.setIdclinica(res.getInt("idclinica"));
            a.setNome(res.getString("nome"));
            a.setCnpj(res.getString("cnpj"));
            a.setCidadeclinica(res.getString("cidadeclinica"));
            a.setLeito(Integer.valueOf(res.getInt("leito")));

            Clinicas.add(a);
        }
        stmt.close();
        conn.close();
        return Clinicas;

    }

    public List<Medico> listarTbMedico() throws SQLException {
        Medicos = new ArrayList<>();
        conn = Banco.conecta();
        if (conn == null || conn.isClosed()) {
            System.out.println("erro ao conectar ao banco de dados");
            System.exit(-1);
        }
        String sql = "SELECT idmedico, nome, cpf, crm, datanascimento, idclinica, idadmin FROM Medico";
        System.out.println("sql: " + sql);

        //atravez desse objeto usamos comandos sql
        Statement stmt = conn.createStatement();

        //select
        ResultSet res = stmt.executeQuery(sql);

        while (res.next()) {

            Medico a = new Medico();;
            a.setIdmedico(res.getInt("idmedico"));
            a.setNome(res.getString("nome"));
            a.setCpf(res.getString("cpf").toString());
            a.setCrm(res.getString("crm"));

            Calendar c = Calendar.getInstance();
            c.setTime(res.getDate("datanascimento"));
            a.setDatanascimento(c);

            a.setIdclinica(res.getInt("idclinica"));
            a.setIdadmin(res.getInt("idadmin"));
            Medicos.add(a);
        }
        stmt.close();
        conn.close();
        return Medicos;

    }

    public List<Cliente> listarTbCliente() throws SQLException {
        Clientes = new ArrayList<>();
        conn = Banco.conecta();
        if (conn == null || conn.isClosed()) {
            System.out.println("erro ao conectar ao banco de dados");
            System.exit(-1);
        }
        String sql = "SELECT idcliente, nome, cpf, rg, datanascimento, idclinica, idmedico FROM Cliente";
        System.out.println("sql: " + sql);

        //atravez desse objeto usamos comandos sql
        Statement stmt = conn.createStatement();

        //select
        ResultSet res = stmt.executeQuery(sql);
        int countClientes = 0;

        while (res.next()) {

            Cliente a = new Cliente();;
            a.setIdcliente(res.getInt("idcliente"));
            a.setNome(res.getString("nome"));
            a.setCpf(res.getString("cpf").toString());
            a.setRg(res.getString("rg"));

            Calendar c = Calendar.getInstance();
            c.setTime(res.getDate("datanascimento"));
            a.setDatanascimento(c);

            a.setIdclinica(res.getInt("idclinica"));
            a.setIdmedico(res.getInt("idmedico"));

            Clientes.add(a);
            countClientes++;
        }
        stmt.close();
        conn.close();
        return Clientes;

    }

    public List<Funcionario> listarTbFuncionario() throws SQLException {
        Funcionarios = new ArrayList<>();
        conn = Banco.conecta();
        if (conn == null || conn.isClosed()) {
            System.out.println("erro ao conectar ao banco de dados");
            System.exit(-1);
        }
        String sql = "SELECT idFuncionario, nome, cpf, rg, datanascimento, idclinica, idfuncao, turno FROM Funcionario";
        System.out.println("sql: " + sql);

        //atravez desse objeto usamos comandos sql
        Statement stmt = conn.createStatement();

        //select
        ResultSet res = stmt.executeQuery(sql);
        int countFuncionarios = 0;

        while (res.next()) {

            Funcionario a = new Funcionario();;
            a.setIdFuncionario(res.getInt("idFuncionario"));
            a.setNome(res.getString("nome"));
            a.setCpf(res.getString("cpf").toString());
            a.setRg(res.getString("rg"));

            Calendar c = Calendar.getInstance();
            c.setTime(res.getDate("datanascimento"));
            a.setDatanascimento(c);

            a.setIdclinica(res.getInt("idclinica"));
            a.setIdfuncao(res.getInt("idfuncao"));
            a.setTurno(res.getString("turno"));

            Funcionarios.add(a);
            countFuncionarios++;
        }
        stmt.close();
        conn.close();
        return Funcionarios;

    }

    public List<Funcao> listarTbFuncao() throws SQLException {
        Funcao = new ArrayList<>();
        lclinica = new ArrayList<>();
        lfuncao = new ArrayList<>();
        lcliente = new ArrayList<>();
        lmedico = new ArrayList<>();

        conn = Banco.conecta();
        if (conn == null || conn.isClosed()) {
            System.out.println("erro ao conectar ao banco de dados");
            System.exit(-1);
        }

        String sql = "SELECT idfuncao, nome, salariobase, vagas FROM funcao";
        System.out.println("sql: " + sql);

        //atravez desse objeto usamos comandos sql
        Statement stmt = conn.createStatement();

        //select
        ResultSet res = stmt.executeQuery(sql);

        while (res.next()) {

            Funcao a = new Funcao();
            a.setIdFuncao(res.getInt("idfuncao"));
            a.setNome(res.getString("nome"));
            a.setSalariobase(res.getInt("salariobase"));
            a.setVagas(res.getInt("vagas"));

            Funcao.add(a);
        }
        stmt.close();
        conn.close();
        return Funcao;

    }

    /*==========================================================================================================================================*/
 /*LISTAR CLINICA E ADMIN COMBO BOX =============================================================================================================*/
    public List<Admin> listarAdmins() throws SQLException {

        List<Admin> Admins = new ArrayList<>();

        conn = Banco.conecta();
        if (conn == null || conn.isClosed()) {
            System.out.println("erro ao conectar ao banco de dados");
            System.exit(-1);
        }

        String sql = "SELECT idadmin, nome,login, senha, adm FROM admin";

        System.out.println("sql: " + sql);
        Statement stmt = conn.createStatement();

        //retorna um conjunto de dados , sempre q for fazer insert usar o executeUpdate
        ResultSet res = stmt.executeQuery(sql);
        while (res.next()) {
            System.out.println("Id:  " + res.getInt("idadmin"));
            System.out.println("Nome:  " + res.getString("nome"));
            System.out.println("Login:  " + res.getString("login"));
            System.out.println("Senha:  " + res.getString("senha"));
            System.out.println("Adm:  " + res.getInt("adm"));

            Admin b = new Admin();
            b.setIdadmin(res.getInt("idadmin"));
            b.setNome(res.getString("nome"));
            b.setLogin(res.getString("login"));
            b.setSenha(res.getString("senha"));
            b.setAdm(res.getInt("adm"));

            Admins.add(b);

        }
        return Admins;

    }

    public List<Clinica> listarClinicas() throws SQLException {

        List<Clinica> Clinicas = new ArrayList<>();
        conn = Banco.conecta();
        if (conn == null || conn.isClosed()) {
            System.out.println("erro ao conectar ao banco de dados");
            System.exit(-1);
        }

        String sql = "SELECT idclinica, nome,cnpj, cidadeclinica, leito FROM Clinica";

        System.out.println("sql: " + sql);
        Statement stmt = conn.createStatement();

        //retorna um conjunto de dados , sempre q for fazer insert usar o executeUpdate
        ResultSet res = stmt.executeQuery(sql);
        while (res.next()) {

            Clinica a = new Clinica();
            a.setIdclinica(res.getInt("idclinica"));
            a.setNome(res.getString("nome"));
            a.setCnpj(res.getString("cnpj"));
            a.setCidadeclinica(res.getString("cidadeclinica"));
            a.setLeito(res.getInt("leito"));

            Clinicas.add(a);

        }
        return Clinicas;

    }

    public List<Medico> listarMedicos() throws SQLException {

        List<Medico> medicos = new ArrayList<>();
        conn = Banco.conecta();
        if (conn == null || conn.isClosed()) {
            System.out.println("erro ao conectar ao banco de dados");
            System.exit(-1);
        }

        String sql = "SELECT idmedico, nome, cpf, crm, datanascimento, idclinica, idadmin FROM Medico";

        System.out.println("sql: " + sql);
        Statement stmt = conn.createStatement();

        //retorna um conjunto de dados , sempre q for fazer insert usar o executeUpdate
        ResultSet res = stmt.executeQuery(sql);
        while (res.next()) {

            Medico a = new Medico();
            a.setIdmedico(res.getInt("idmedico"));
            a.setNome(res.getString("nome"));
            a.setCpf(res.getString("cpf"));
            a.setCrm(res.getString("crm"));

            Calendar c = Calendar.getInstance();
            c.setTime(res.getDate("datanascimento"));
            a.setDatanascimento(c);

            a.setIdclinica(res.getInt("idclinica"));
            a.setIdadmin(res.getInt("idadmin"));
            medicos.add(a);

        }
        return medicos;

    }

    public List<Funcao> listarfuncao() throws SQLException {

        List<Funcao> funcao = new ArrayList<>();

        conn = Banco.conecta();
        if (conn == null || conn.isClosed()) {
            System.out.println("erro ao conectar ao banco de dados");
            System.exit(-1);
        }

        String sql = "SELECT idfuncao, nome,salariobase, vagas FROM funcao";

        System.out.println("sql: " + sql);
        Statement stmt = conn.createStatement();

        //retorna um conjunto de dados , sempre q for fazer insert usar o executeUpdate
        ResultSet res = stmt.executeQuery(sql);
        while (res.next()) {
            Funcao b = new Funcao();
            b.setIdFuncao(res.getInt("idfuncao"));
            b.setNome(res.getString("nome"));
            b.setSalariobase(res.getInt("salariobase"));
            b.setVagas(res.getInt("vagas"));

            funcao.add(b);

        }
        return funcao;

    }

    /*==========================================================================================================================*/
 /*INICIALIZANDO COMPONENTESS====================================================================================================================*/
    public CadastroAdm() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Sistema PiccianiMed Management");

        lmedico = new ArrayList<>();
        lclinica = new ArrayList<>();
        ladmin = new ArrayList<>();
        lfuncao = new ArrayList<>();

        try {
            Admins = listarTbAdmin();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Clinicas = listarTbClinica();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Medicos = listarTbMedico();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Clientes = listarTbCliente();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Funcionarios = listarTbFuncionario();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAdm.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Funcao = listarTbFuncao();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAdm.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            lclinica = listarClinicas();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAdm.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ladmin = listarAdmins();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAdm.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            lmedico = listarMedicos();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            lfuncao = listarfuncao();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAdm.class.getName()).log(Level.SEVERE, null, ex);
        }

        AdminTableModel modeloAdmin = new AdminTableModel();
        modeloAdmin.setListaAdmins(Admins);

        tbAdmin.setModel(modeloAdmin);

        ClinicaTableModel modeloClinica = new ClinicaTableModel();
        modeloClinica.setListaClinicas(Clinicas);

        tbClinica.setModel(modeloClinica);
        alinharTbClinicas(tbClinica);

        //  alinharTbAdmins(tbAdmin);
        MedicoTableModel modeloMedico = new MedicoTableModel();
        modeloMedico.setListamedicos(Medicos);
        tbMedico.setModel(modeloMedico);

        //  alinharTbAdmins(tbAdmin);
        ClienteTableModel modeloCliente = new ClienteTableModel();
        modeloCliente.setListaClientes(Clientes);
        tbCliente.setModel(modeloCliente);

        //  alinharTbAdmins(tbAdmin);
        FuncaoTableModel modeloFuncao = new FuncaoTableModel();
        modeloFuncao.setListaFuncao(Funcao);
        tbFuncao.setModel(modeloFuncao);

        //  alinharTbAdmins(tbAdmin);
        FuncionarioTableModel modeloFuncionario = new FuncionarioTableModel();
        modeloFuncionario.setListaFuncionarios(Funcionarios);
        tbFuncionario.setModel(modeloFuncionario);

        for (int i = 0; i < lclinica.size(); i++) {
            combClinicaMedico.addItem(lclinica.get(i));
            combClinicaCliente.addItem(lclinica.get(i));
            combClinicaFuncionario.addItem(lclinica.get(i));

        }

        for (int i = 0; i < ladmin.size(); i++) {
            combAdminMedico.addItem(ladmin.get(i));

        }

        for (int i = 0; i < lmedico.size(); i++) {
            combMedicoCliente.addItem(lmedico.get(i));

        }

        for (int i = 0; i < lfuncao.size(); i++) {
            combFuncaoFuncionario.addItem(lfuncao.get(i));

        }

        conn = Banco.conecta();

        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("erro ao conectar ao banco de dados");
                System.exit(-1);
            }

            //encerrou a conexão
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(CadastroClinica.class.getName()).log(Level.SEVERE, null, ex);
        }

        //txtDataNascimento.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
        txtDataNascimentoMedico.setFormats("dd/MM/yyyy");
        txtDataNascimentoMedico.setDate(Calendar.getInstance().getTime());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Menu = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        Cliente = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanelBagCad = new javax.swing.JPanel();
        JPainelLabelsTxt = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanelTxtTxt = new javax.swing.JPanel();
        txtNomeCliente = new javax.swing.JTextField();
        txtCpfCliente = new javax.swing.JFormattedTextField();
        txtRgCliente = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtDataNascimentoCliente = new org.jdesktop.swingx.JXDatePicker();
        combClinicaCliente = new javax.swing.JComboBox<>();
        combMedicoCliente = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        btnCadastrarCliente = new javax.swing.JButton();
        btnExcluirCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        clinica = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbClinica = new javax.swing.JTable();
        btnExcluirClinica = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnEditarClinica = new javax.swing.JButton();
        txtNomeClinica = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCidadeClinica = new javax.swing.JTextField();
        btnCadastrarClinica = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        txtLeitoClinica = new javax.swing.JFormattedTextField();
        txtCnpjClinica = new javax.swing.JFormattedTextField();
        medico = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtDataNascimentoMedico = new org.jdesktop.swingx.JXDatePicker();
        combAdminMedico = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        btnExcluirMedico = new javax.swing.JButton();
        txtCrmMedico = new javax.swing.JTextField();
        btnEditarMedico = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        combClinicaMedico = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMedico = new javax.swing.JTable();
        txtNomeMedico = new javax.swing.JTextField();
        jButton1Medico = new javax.swing.JButton();
        txtCpfMedico = new javax.swing.JFormattedTextField();
        funcionario = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        combFuncaoFuncionario = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtDataNascimentoFuncionario = new org.jdesktop.swingx.JXDatePicker();
        jLabel29 = new javax.swing.JLabel();
        btnCadastrarFuncionario = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbFuncionario = new javax.swing.JTable();
        btnEditarFuncionario = new javax.swing.JButton();
        txtCpfFuncionario = new javax.swing.JFormattedTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        btnExcluirFuncionario = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        txtNomeFuncionario = new javax.swing.JTextField();
        combClinicaFuncionario = new javax.swing.JComboBox<>();
        txtRgFuncionario = new javax.swing.JFormattedTextField();
        jLabel33 = new javax.swing.JLabel();
        combTurnoFuncionario = new javax.swing.JComboBox<>();
        função = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtNomeFuncao = new javax.swing.JTextField();
        btnCadastrarFuncao = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbFuncao = new javax.swing.JTable();
        btnExcluirFuncao = new javax.swing.JButton();
        btnEditarFuncao = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        txtSalariobaseFuncao = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtVagasFuncao = new javax.swing.JTextField();
        admin = new javax.swing.JPanel();
        txtNomeAdmin = new javax.swing.JTextField();
        txtLoginAdmin = new javax.swing.JTextField();
        btnCadastrarAdmin = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAdmin = new javax.swing.JTable();
        btnExcluirAdmin = new javax.swing.JButton();
        btnEditarAdmin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        chkAdm = new javax.swing.JCheckBox();
        txtSenhaAdmin = new javax.swing.JPasswordField();
        txtSenhaAdmin2 = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();
        Sair = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jTabbedPane1.setMinimumSize(new java.awt.Dimension(800, 600));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(800, 600));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        Menu.setBackground(new java.awt.Color(255, 255, 255));
        Menu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Menu.setMinimumSize(new java.awt.Dimension(800, 600));
        Menu.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 200));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banco/IMG/NQZSGBCO_400x400.png"))); // NOI18N
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel37);

        Menu.add(jPanel8);

        jTabbedPane1.addTab("", new javax.swing.ImageIcon(getClass().getResource("/banco/IMG/icons8-mais-filled-24.png")), Menu); // NOI18N

        Cliente.setBackground(new java.awt.Color(255, 255, 255));
        Cliente.setMinimumSize(new java.awt.Dimension(800, 600));
        Cliente.setPreferredSize(new java.awt.Dimension(800, 600));
        Cliente.setLayout(new java.awt.GridBagLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Cadastro de Clientes");
        jPanel5.add(jLabel22);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 617;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        Cliente.add(jPanel5, gridBagConstraints);

        jPanelBagCad.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBagCad.setLayout(new java.awt.GridBagLayout());

        JPainelLabelsTxt.setBackground(new java.awt.Color(255, 255, 255));
        JPainelLabelsTxt.setLayout(new java.awt.GridLayout(3, 1));

        jLabel20.setText("Nome:");
        JPainelLabelsTxt.add(jLabel20);

        jLabel24.setText("RG:");
        JPainelLabelsTxt.add(jLabel24);

        jLabel18.setText("CPF:");
        JPainelLabelsTxt.add(jLabel18);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 58;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 58);
        jPanelBagCad.add(JPainelLabelsTxt, gridBagConstraints);

        jPanelTxtTxt.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTxtTxt.setLayout(new java.awt.GridLayout(3, 1, 0, 20));

        txtNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeClienteActionPerformed(evt);
            }
        });
        jPanelTxtTxt.add(txtNomeCliente);

        try {
            txtCpfCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpfCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfClienteActionPerformed(evt);
            }
        });
        jPanelTxtTxt.add(txtCpfCliente);

        try {
            txtRgCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanelTxtTxt.add(txtRgCliente);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 504;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 1);
        jPanelBagCad.add(jPanelTxtTxt, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        Cliente.add(jPanelBagCad, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(3, 1, 0, 10));

        jLabel23.setText("Data de Nascimento:");
        jPanel1.add(jLabel23);

        jLabel19.setText("Clínica:");
        jPanel1.add(jLabel19);

        jLabel21.setText("Médico:");
        jPanel1.add(jLabel21);

        jPanel3.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(180, 76));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 80));
        jPanel2.setLayout(new java.awt.GridLayout(3, 1));

        txtDataNascimentoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataNascimentoClienteActionPerformed(evt);
            }
        });
        jPanel2.add(txtDataNascimentoCliente);

        combClinicaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combClinicaClienteActionPerformed(evt);
            }
        });
        jPanel2.add(combClinicaCliente);

        combMedicoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combMedicoClienteActionPerformed(evt);
            }
        });
        jPanel2.add(combMedicoCliente);

        jPanel3.add(jPanel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        Cliente.add(jPanel3, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnCadastrarCliente.setText("Cadastrar");
        btnCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarClienteActionPerformed(evt);
            }
        });
        jPanel4.add(btnCadastrarCliente);

        btnExcluirCliente.setText("Excluir");
        btnExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirClienteActionPerformed(evt);
            }
        });
        jPanel4.add(btnExcluirCliente);

        btnEditarCliente.setText("Editar");
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });
        jPanel4.add(btnEditarCliente);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 555;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 10);
        Cliente.add(jPanel4, gridBagConstraints);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.GridLayout());

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbCliente.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane4.setViewportView(tbCliente);

        jPanel6.add(jScrollPane4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 757;
        gridBagConstraints.ipady = 283;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 1, 10);
        Cliente.add(jPanel6, gridBagConstraints);

        jTabbedPane1.addTab("<html><b>Clientes", new javax.swing.ImageIcon(getClass().getResource("/banco/IMG/icons8-gestão-de-cliente-filled-24.png")), Cliente, "Cadastre um Paciente\n\n"); // NOI18N

        clinica.setBackground(new java.awt.Color(255, 255, 255));
        clinica.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Cadastro de Clínicas");

        tbClinica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tbClinica);

        btnExcluirClinica.setText("Excluir");
        btnExcluirClinica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirClinicaActionPerformed(evt);
            }
        });

        jLabel5.setText("Nome:");

        btnEditarClinica.setText("Editar");
        btnEditarClinica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClinicaActionPerformed(evt);
            }
        });

        txtNomeClinica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeClinicaActionPerformed(evt);
            }
        });

        jLabel6.setText("CNPJ:");

        jLabel7.setText("Cidade:");

        btnCadastrarClinica.setText("Cadastrar");
        btnCadastrarClinica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarClinicaActionPerformed(evt);
            }
        });

        jLabel25.setText("Leitos Disponiveis:");

        txtLeitoClinica.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##"))));
        txtLeitoClinica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLeitoClinicaActionPerformed(evt);
            }
        });

        try {
            txtCnpjClinica.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout clinicaLayout = new javax.swing.GroupLayout(clinica);
        clinica.setLayout(clinicaLayout);
        clinicaLayout.setHorizontalGroup(
            clinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clinicaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(clinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(clinicaLayout.createSequentialGroup()
                        .addComponent(btnCadastrarClinica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLeitoClinica, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))
                    .addGroup(clinicaLayout.createSequentialGroup()
                        .addComponent(btnExcluirClinica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditarClinica))
                    .addGroup(clinicaLayout.createSequentialGroup()
                        .addGroup(clinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(clinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCnpjClinica)
                            .addComponent(txtCidadeClinica)))
                    .addGroup(clinicaLayout.createSequentialGroup()
                        .addGroup(clinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(clinicaLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNomeClinica, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 139, Short.MAX_VALUE)))
                .addContainerGap())
        );
        clinicaLayout.setVerticalGroup(
            clinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clinicaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(19, 19, 19)
                .addGroup(clinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNomeClinica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(clinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCnpjClinica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(clinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCidadeClinica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(clinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirClinica)
                    .addComponent(btnEditarClinica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(clinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarClinica)
                    .addComponent(jLabel25)
                    .addComponent(txtLeitoClinica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("<html> <b>Clínicas</b> </html>", new javax.swing.ImageIcon(getClass().getResource("/banco/IMG/iconfinder_hospital-o_1608931 (1).png")), clinica, "Cadastre Clinicas\n"); // NOI18N

        medico.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Usuário:");

        txtDataNascimentoMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataNascimentoMedicoActionPerformed(evt);
            }
        });

        combAdminMedico.setToolTipText("");
        combAdminMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combAdminMedicoActionPerformed(evt);
            }
        });

        jLabel10.setText("CRM:");

        btnExcluirMedico.setText("Excluir");
        btnExcluirMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirMedicoActionPerformed(evt);
            }
        });

        btnEditarMedico.setText("Editar");
        btnEditarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarMedicoActionPerformed(evt);
            }
        });

        jLabel11.setText("CPF:");

        jLabel12.setText("Clínica:");

        combClinicaMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combClinicaMedicoActionPerformed(evt);
            }
        });

        jLabel13.setText("Nome:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Cadastro de Médicos");

        jLabel15.setText("Data de Nascimento:");

        tbMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbMedico);

        txtNomeMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeMedicoActionPerformed(evt);
            }
        });

        jButton1Medico.setText("Cadastrar");
        jButton1Medico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1MedicoActionPerformed(evt);
            }
        });

        try {
            txtCpfMedico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpfMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfMedicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout medicoLayout = new javax.swing.GroupLayout(medico);
        medico.setLayout(medicoLayout);
        medicoLayout.setHorizontalGroup(
            medicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(medicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(medicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, medicoLayout.createSequentialGroup()
                        .addComponent(btnExcluirMedico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditarMedico))
                    .addGroup(medicoLayout.createSequentialGroup()
                        .addGroup(medicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(medicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(medicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addGroup(medicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(medicoLayout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addGap(76, 76, 76)
                                            .addComponent(combAdminMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(medicoLayout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(combClinicaMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(medicoLayout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtDataNascimentoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton1Medico))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(medicoLayout.createSequentialGroup()
                        .addGroup(medicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(medicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(medicoLayout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addGap(2, 2, 2))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, medicoLayout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                            .addGroup(medicoLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(13, 13, 13)))
                        .addGroup(medicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCpfMedico)
                            .addComponent(txtCrmMedico)
                            .addComponent(txtNomeMedico))))
                .addContainerGap())
        );
        medicoLayout.setVerticalGroup(
            medicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(medicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(medicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtNomeMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(medicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCrmMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(medicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCpfMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(medicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataNascimentoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(medicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(combClinicaMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(medicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combAdminMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(27, 27, 27)
                .addGroup(medicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirMedico)
                    .addComponent(btnEditarMedico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1Medico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("<html><b>Médicos</b>", new javax.swing.ImageIcon(getClass().getResource("/banco/IMG/iconfinder_49_3678412.png")), medico, "Cadastre um Médico\n"); // NOI18N

        funcionario.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setText("Nome:");

        combFuncaoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combFuncaoFuncionarioActionPerformed(evt);
            }
        });

        jLabel27.setText("Setor:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("Cadastro de Funcionários");

        txtDataNascimentoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataNascimentoFuncionarioActionPerformed(evt);
            }
        });

        jLabel29.setText("Data de Nascimento:");

        btnCadastrarFuncionario.setText("Cadastrar");
        btnCadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarFuncionarioActionPerformed(evt);
            }
        });

        tbFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tbFuncionario);

        btnEditarFuncionario.setText("Editar");
        btnEditarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarFuncionarioActionPerformed(evt);
            }
        });

        try {
            txtCpfFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpfFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfFuncionarioActionPerformed(evt);
            }
        });

        jLabel30.setText("RG:");

        jLabel31.setText("CPF:");

        btnExcluirFuncionario.setText("Excluir");
        btnExcluirFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirFuncionarioActionPerformed(evt);
            }
        });

        jLabel32.setText("Clínica:");

        txtNomeFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeFuncionarioActionPerformed(evt);
            }
        });

        combClinicaFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combClinicaFuncionarioActionPerformed(evt);
            }
        });

        try {
            txtRgFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel33.setText("Turno:");

        combTurnoFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manhã (08:00 - 16:00)", "Tarde (16:00 - 00:00)", "Noite (00:00 - 08:00)" }));

        javax.swing.GroupLayout funcionarioLayout = new javax.swing.GroupLayout(funcionario);
        funcionario.setLayout(funcionarioLayout);
        funcionarioLayout.setHorizontalGroup(
            funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(funcionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, funcionarioLayout.createSequentialGroup()
                        .addComponent(btnExcluirFuncionario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditarFuncionario))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, funcionarioLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(2, 2, 2)
                        .addComponent(txtNomeFuncionario))
                    .addGroup(funcionarioLayout.createSequentialGroup()
                        .addGroup(funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRgFuncionario)
                            .addComponent(txtCpfFuncionario)))
                    .addGroup(funcionarioLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(funcionarioLayout.createSequentialGroup()
                        .addGroup(funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnCadastrarFuncionario)
                                .addGroup(funcionarioLayout.createSequentialGroup()
                                    .addComponent(jLabel29)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtDataNascimentoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(funcionarioLayout.createSequentialGroup()
                                .addGroup(funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel32))
                                .addGap(76, 76, 76)
                                .addGroup(funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(combClinicaFuncionario, 0, 250, Short.MAX_VALUE)
                                    .addComponent(combFuncaoFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combTurnoFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        funcionarioLayout.setVerticalGroup(
            funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(funcionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addGroup(funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtNomeFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtRgFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtCpfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataNascimentoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(combClinicaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(combTurnoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(combFuncaoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirFuncionario)
                    .addComponent(btnEditarFuncionario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrarFuncionario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("<html><b>Funcionários", new javax.swing.ImageIcon(getClass().getResource("/banco/IMG/icons8-homens-trabalhadores-filled-24.png")), funcionario); // NOI18N

        função.setBackground(new java.awt.Color(255, 255, 255));

        jLabel35.setText("Salário Base:");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("Cadastro de Função");

        txtNomeFuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeFuncaoActionPerformed(evt);
            }
        });

        btnCadastrarFuncao.setText("Cadastrar");
        btnCadastrarFuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarFuncaoActionPerformed(evt);
            }
        });

        tbFuncao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tbFuncao);

        btnExcluirFuncao.setText("Excluir");
        btnExcluirFuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirFuncaoActionPerformed(evt);
            }
        });

        btnEditarFuncao.setText("Editar");
        btnEditarFuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarFuncaoActionPerformed(evt);
            }
        });

        jLabel38.setText("Cargo / Função:");

        jLabel34.setText("Vagas Disponíveis");

        javax.swing.GroupLayout funçãoLayout = new javax.swing.GroupLayout(função);
        função.setLayout(funçãoLayout);
        funçãoLayout.setHorizontalGroup(
            funçãoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(funçãoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(funçãoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(funçãoLayout.createSequentialGroup()
                        .addGroup(funçãoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                            .addGroup(funçãoLayout.createSequentialGroup()
                                .addComponent(btnExcluirFuncao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEditarFuncao))
                            .addGroup(funçãoLayout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(funçãoLayout.createSequentialGroup()
                                .addGroup(funçãoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel34))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(funçãoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomeFuncao)
                                    .addComponent(txtSalariobaseFuncao)
                                    .addGroup(funçãoLayout.createSequentialGroup()
                                        .addComponent(txtVagasFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(funçãoLayout.createSequentialGroup()
                        .addComponent(btnCadastrarFuncao)
                        .addGap(85, 709, Short.MAX_VALUE))))
        );
        funçãoLayout.setVerticalGroup(
            funçãoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(funçãoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addGap(48, 48, 48)
                .addGroup(funçãoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38)
                    .addComponent(txtNomeFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(funçãoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtSalariobaseFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(funçãoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtVagasFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(funçãoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirFuncao)
                    .addComponent(btnEditarFuncao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrarFuncao)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("<html><b>Funções", new javax.swing.ImageIcon(getClass().getResource("/banco/IMG/icons8-pasta-filled-24.png")), função, "Cadastre setores ou cargos de funcionarios a seres desenvolvidos!"); // NOI18N

        admin.setBackground(new java.awt.Color(255, 255, 255));

        txtNomeAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeAdminActionPerformed(evt);
            }
        });

        txtLoginAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginAdminActionPerformed(evt);
            }
        });

        btnCadastrarAdmin.setText("Cadastrar");
        btnCadastrarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarAdminActionPerformed(evt);
            }
        });

        tbAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbAdmin);

        btnExcluirAdmin.setText("Excluir");
        btnExcluirAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirAdminActionPerformed(evt);
            }
        });

        btnEditarAdmin.setText("Editar");
        btnEditarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAdminActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        jLabel2.setText("Login:");

        jLabel3.setText("Senha:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Cadastro de Usuários");

        chkAdm.setText("ADMINISTRADOR?");
        chkAdm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chkAdmMouseClicked(evt);
            }
        });
        chkAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAdmActionPerformed(evt);
            }
        });

        txtSenhaAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaAdminActionPerformed(evt);
            }
        });

        txtSenhaAdmin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaAdmin2ActionPerformed(evt);
            }
        });

        jLabel16.setText("Confirmar senha:");

        javax.swing.GroupLayout adminLayout = new javax.swing.GroupLayout(admin);
        admin.setLayout(adminLayout);
        adminLayout.setHorizontalGroup(
            adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminLayout.createSequentialGroup()
                        .addGroup(adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                            .addGroup(adminLayout.createSequentialGroup()
                                .addComponent(btnExcluirAdmin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEditarAdmin))
                            .addGroup(adminLayout.createSequentialGroup()
                                .addGroup(adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLoginAdmin)
                                    .addGroup(adminLayout.createSequentialGroup()
                                        .addComponent(txtSenhaAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSenhaAdmin2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(adminLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 643, Short.MAX_VALUE))
                            .addGroup(adminLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeAdmin)))
                        .addContainerGap())
                    .addGroup(adminLayout.createSequentialGroup()
                        .addComponent(btnCadastrarAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkAdm)
                        .addGap(85, 85, 85))))
        );
        adminLayout.setVerticalGroup(
            adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel8)
                .addGap(21, 21, 21)
                .addGroup(adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLoginAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSenhaAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenhaAdmin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirAdmin)
                    .addComponent(btnEditarAdmin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarAdmin)
                    .addComponent(chkAdm))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("<html><b>Usuários\n", new javax.swing.ImageIcon(getClass().getResource("/banco/IMG/iconfinder_ajax-admin_3018587.png")), admin); // NOI18N

        javax.swing.GroupLayout SairLayout = new javax.swing.GroupLayout(Sair);
        Sair.setLayout(SairLayout);
        SairLayout.setHorizontalGroup(
            SairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        SairLayout.setVerticalGroup(
            SairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("<html><b>SAIR", new javax.swing.ImageIcon(getClass().getResource("/banco/IMG/icons8-sair-24.png")), Sair); // NOI18N

        getContentPane().add(jTabbedPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1MedicoActionPerformed
        conn = Banco.conecta();
        String Mostrar = null;
        String sql = "";

        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("erro ao conectar ao banco de dados");
                System.exit(-1);
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date aux = txtDataNascimentoMedico.getDate();

            String nome = "'" + txtNomeMedico.getText() + "'";
            String crm = "'" + txtCrmMedico.getText() + "'";
            String cpf = "'" + txtCpfMedico.getText() + "'";

            String dataNasc = "'" + sdf.format(aux) + "'";
            if (txtNomeMedico.getText().isEmpty() || txtCrmMedico.getText().isEmpty() || txtCpfMedico.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Preencha Todos os Campos!!");
            } else {

                Statement stmt = conn.createStatement();

                sql = "INSERT INTO Medico (nome,crm, cpf, datanascimento, idclinica, idadmin ) VALUES ("
                        + "" + nome + "," + crm + "," + cpf + "," + dataNasc + "," + ((Clinica) combClinicaMedico.getSelectedItem()).getIdclinica() + ","
                        + " " + ((Admin) combAdminMedico.getSelectedItem()).getIdadmin() + ")";
                System.out.println("sql: " + sql);

                //atravez desse objeto usamos comandos sql
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                //select
                //stmt.executeQuery(sql);
                //retorna um conjunto de dados , sempre q for fazer insert usar o executeUpdate : inset, update, delete

                //encerrou a conexão
                stmt.close();
                conn.close();
                JOptionPane.showMessageDialog(null, "Médico(a) cadastrado!");

                txtNomeMedico.setText(Mostrar);
                txtCpfMedico.setText(Mostrar);
                txtCrmMedico.setText(Mostrar);

                Medicos = listarTbMedico();

                MedicoTableModel modelo = new MedicoTableModel();
                modelo.setListamedicos(Medicos);

                tbMedico.setModel(modelo);

                combMedicoCliente.removeAllItems();

                lmedico = listarMedicos();

                for (int i = 0; i < lmedico.size(); i++) {
                    combMedicoCliente.addItem(lmedico.get(i));
                }

                //   alinharTbMedicos(tbMedico);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1MedicoActionPerformed

    private void txtNomeMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeMedicoActionPerformed

    }//GEN-LAST:event_txtNomeMedicoActionPerformed

    private void combClinicaMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combClinicaMedicoActionPerformed

    }//GEN-LAST:event_combClinicaMedicoActionPerformed

    private void btnEditarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarMedicoActionPerformed
        conn = Banco.conecta();

        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("erro ao conectar ao banco de dados");
                System.exit(-1);

            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date aux = txtDataNascimentoMedico.getDate();

            String nome = "'" + txtNomeMedico.getText() + "'";
            String crm = "'" + txtCrmMedico.getText() + "'";
            String cpf = "'" + txtCpfMedico.getText() + "'";
            String dataNasc = "'" + sdf.format(aux) + "'";

            int k = tbMedico.getSelectedRow();
            if (k == -1) {
                JOptionPane.showMessageDialog(null, "Porfavor Complete os Campos e Selecione a Linha na Tabela a ser editada e em Seguida clicke no botao Editar");
            } else {
                // System.out.println(k);
                int i = ((MedicoTableModel) tbMedico.getModel()).getListamedicos().get(k).getIdmedico();

                Statement stmt = conn.createStatement();
                String sql = "UPDATE medico SET nome = " + nome + ",crm = " + crm + ",cpf = " + cpf + ",datanascimento = " + dataNasc + "WHERE idmedico = " + i + "";
                stmt.executeUpdate(sql);

                stmt.close();
                conn.close();

                JOptionPane.showMessageDialog(null, "Médico(a) Editado!");

                String Mostrar = " ";
                txtNomeMedico.setText(Mostrar);
                txtCpfMedico.setText(Mostrar);
                txtCrmMedico.setText(Mostrar);

                Medicos = listarTbMedico();
                MedicoTableModel modelo = new MedicoTableModel();
                modelo.setListamedicos(Medicos);
                tbMedico.setModel(modelo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditarMedicoActionPerformed

    private void btnExcluirMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirMedicoActionPerformed

        conn = Banco.conecta();

        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("erro ao conectar ao banco de dados");
                System.exit(-1);

            }
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir esse Item?", "Excluindo", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                int k = tbMedico.getSelectedRow();
                if (k == -1) {
                    JOptionPane.showMessageDialog(null, "Selecione um Admin para deletar");
                } else {
                    // System.out.println(k);
                    int i = ((MedicoTableModel) tbMedico.getModel()).getListamedicos().get(k).getIdmedico();

                    Statement stmt = conn.createStatement();
                    String sql = "Delete from medico where idmedico = " + i + " ";
                    stmt.executeUpdate(sql);

                    stmt.close();
                    conn.close();

                    JOptionPane.showMessageDialog(null, "Médico(a) Apagado!");

                    String Mostrar = " ";
                    txtNomeMedico.setText(Mostrar);
                    txtCpfMedico.setText(Mostrar);
                    txtCrmMedico.setText(Mostrar);

                    Medicos = listarTbMedico();
                    MedicoTableModel modelo = new MedicoTableModel();
                    modelo.setListamedicos(Medicos);
                    tbMedico.setModel(modelo);
                }
            } else if (resposta == JOptionPane.NO_OPTION) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcluirMedicoActionPerformed

    private void txtDataNascimentoMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataNascimentoMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataNascimentoMedicoActionPerformed

    @SuppressWarnings("empty-statement")
    private void btnEditarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAdminActionPerformed
        String Mostrar = null;
        conn = Banco.conecta();

        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("erro ao conectar ao banco de dados");
                System.exit(-1);

            }

            String nome = "'" + txtNomeAdmin.getText() + "'";
            String login = "'" + txtLoginAdmin.getText() + "'";
            String senha = "'" + txtSenhaAdmin.getText() + "'";
            Integer adm = 0;
            if (chkAdm.isSelected()) {
                adm = 1;
            } else {
                adm = 0;
            };

            int k = tbAdmin.getSelectedRow();
            if (k == -1) {
                JOptionPane.showMessageDialog(null, "Porfavor Complete os Campos e Selecione a Linha na Tabela a ser editada e em Seguida clicke no botao Editar");
                txtSenhaAdmin.setText(Mostrar);
                txtSenhaAdmin2.setText(Mostrar);
            } else {
                // System.out.println(k);

                int i = ((AdminTableModel) tbAdmin.getModel()).getListaAdmins().get(k).getIdadmin();

                try (Statement stmt = conn.createStatement()) {
                    String sql = "UPDATE admin SET nome = " + nome + ",login = " + login + ",senha = " + senha + ",adm = " + adm + " WHERE idadmin = " + i + "";
                    stmt.executeUpdate(sql);
                }
                conn.close();

                JOptionPane.showMessageDialog(null, "Admin Editado!");

                txtNomeAdmin.setText(Mostrar);
                txtLoginAdmin.setText(Mostrar);
                txtSenhaAdmin.setText(Mostrar);
                txtSenhaAdmin2.setText(Mostrar);

                Admins = listarTbAdmin();
                AdminTableModel modelo = new AdminTableModel();
                modelo.setListaAdmins(Admins);
                tbAdmin.setModel(modelo);

                combAdminMedico.removeAllItems();

                ladmin = listarAdmins();

                for (int i2 = 0; i2 < ladmin.size(); i2++) {
                    combAdminMedico.addItem(ladmin.get(i2));

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditarAdminActionPerformed

    private void btnExcluirAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirAdminActionPerformed
        conn = Banco.conecta();

        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("erro ao conectar ao banco de dados");
                System.exit(-1);

            }
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir esse Item?", "Excluindo", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                int k = tbAdmin.getSelectedRow();
                if (k == -1) {
                    JOptionPane.showMessageDialog(null, "Selecione um Admin para deletar");
                } else {

                    // System.out.println(k);
                    int i = ((AdminTableModel) tbAdmin.getModel()).getListaAdmins().get(k).getIdadmin();

                    Statement stmt = conn.createStatement();
                    if (i == 1) {
                        JOptionPane.showMessageDialog(null, "Nao é Possivel apagar o Admin Nativo!");
                    } else {

                        String sql = "Delete from admin where idadmin = " + i + " ";
                        stmt.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Admin Apagado!");

                    }

                    stmt.close();
                    conn.close();

                    String Mostrar = " ";
                    txtNomeAdmin.setText(Mostrar);
                    txtLoginAdmin.setText(Mostrar);
                    txtSenhaAdmin.setText(Mostrar);

                    Admins = listarTbAdmin();
                    AdminTableModel modelo = new AdminTableModel();
                    modelo.setListaAdmins(Admins);
                    tbAdmin.setModel(modelo);

                    combAdminMedico.removeAllItems();
                    ladmin = listarAdmins();

                    for (int i3 = 0; i3 < ladmin.size(); i3++) {
                        combAdminMedico.addItem(ladmin.get(i3));

                    }
                }
            } else if (resposta == JOptionPane.NO_OPTION) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcluirAdminActionPerformed

    @SuppressWarnings("empty-statement")
    private void btnCadastrarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarAdminActionPerformed
        String Mostrar = null;
        conn = Banco.conecta();
        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("erro ao conectar ao banco de dados");
                System.exit(-1);
            }

            String nome = "'" + txtNomeAdmin.getText() + "'";
            String login = "'" + txtLoginAdmin.getText() + "'";
            String senha = "'" + txtSenhaAdmin.getText() + "'";
            String senha2 = "'" + txtSenhaAdmin2.getText() + "'";

            if (senha.equals(senha2)) {

                Integer adm = null;
                if (chkAdm.isSelected()) {
                    adm = 1;
                } else {
                    adm = 0;
                };

                if (txtNomeAdmin.getText().isEmpty() || txtLoginAdmin.getText().isEmpty() || txtSenhaAdmin.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Preencha Todos os Campos!!");
                } else {

                    String sql = "INSERT INTO admin(nome, login, senha, adm) VALUES ("
                            + "" + nome + "," + login + "," + senha + "," + adm + ")";
                    System.out.println("sql: " + sql);

                    //atravez desse objeto usamos comandos sql
                    Statement stmt = conn.createStatement();

                    //select
                    //stmt.executeQuery(sql);
                    //retorna um conjunto de dados , sempre q for fazer insert usar o executeUpdate : inset, update, delete
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Admin" + nome + "cadastrado!!");

                    //encerrou a conexão
                    stmt.close();
                    conn.close();

                    txtNomeAdmin.setText(Mostrar);
                    txtLoginAdmin.setText(Mostrar);
                    txtSenhaAdmin.setText(Mostrar);
                    txtSenhaAdmin2.setText(Mostrar);

                    Admins = listarTbAdmin();

                    AdminTableModel modelo = new AdminTableModel();
                    modelo.setListaAdmins(Admins);

                    tbAdmin.setModel(modelo);

                    for (int i = 0; i < ladmin.size(); i++) {
                        combAdminMedico.addItem(ladmin.get(i));

                    }
                    combAdminMedico.removeAllItems();
                    ladmin = listarAdmins();

                    for (int i = 0; i < ladmin.size(); i++) {
                        combAdminMedico.addItem(ladmin.get(i));

                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Senhas Não São Iguais!");
                txtSenhaAdmin.setText(Mostrar);
                txtSenhaAdmin2.setText(Mostrar);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCadastrarAdminActionPerformed

    private void txtLoginAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginAdminActionPerformed

    private void txtNomeAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeAdminActionPerformed

    private void btnCadastrarClinicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarClinicaActionPerformed
        conn = Banco.conecta();
        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("erro ao conectar ao banco de dados");
                System.exit(-1);
            }

            String nome = "'" + txtNomeClinica.getText() + "'";
            String cnpj = "'" + txtCnpjClinica.getText() + "'";
            String cidade = "'" + txtCidadeClinica.getText() + "'";
            Integer leito = Integer.parseInt(txtLeitoClinica.getText());

            if (txtNomeClinica.getText().isEmpty() || txtCnpjClinica.getText().isEmpty() || txtCidadeClinica.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Preencha Todos os Campos!!");
            } else {

                String sql = "INSERT INTO Clinica (nome, cnpj, cidadeclinica, leito) VALUES ("
                        + "" + nome + "," + cnpj + "," + cidade + "," + leito + ")";
                System.out.println("sql: " + sql);

                //atravez desse objeto usamos comandos sql
                Statement stmt = conn.createStatement();

                //select
                //stmt.executeQuery(sql);
                //retorna um conjunto de dados , sempre q for fazer insert usar o executeUpdate : inset, update, delete
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Clínica  " + nome + "  cadastrada!!");

                //encerrou a conexão
                stmt.close();
                conn.close();

                String Mostrar = null;
                txtNomeClinica.setText(Mostrar);
                txtCnpjClinica.setText(Mostrar);
                txtCidadeClinica.setText(Mostrar);
                txtLeitoClinica.setText(Mostrar);

                Clinicas = listarTbClinica();

                ClinicaTableModel modelo = new ClinicaTableModel();
                modelo.setListaClinicas(Clinicas);

                tbClinica.setModel(modelo);

                combClinicaMedico.removeAllItems();
                combClinicaCliente.removeAllItems();
                combClinicaFuncionario.removeAllItems();
                lclinica = listarClinicas();

                for (int i = 0; i < lclinica.size(); i++) {
                    combClinicaMedico.addItem(lclinica.get(i));
                    combClinicaCliente.addItem(lclinica.get(i));
                    combClinicaFuncionario.addItem(lclinica.get(i));

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCadastrarClinicaActionPerformed

    private void txtNomeClinicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeClinicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeClinicaActionPerformed

    private void btnEditarClinicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClinicaActionPerformed

        conn = Banco.conecta();

        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("erro ao conectar ao banco de dados");
                System.exit(-1);

            }

            String nome = "'" + txtNomeClinica.getText() + "'";
            String cnpj = "'" + txtCnpjClinica.getText() + "'";
            String cidade = "'" + txtCidadeClinica.getText() + "'";

            int k = tbClinica.getSelectedRow();
            if (k == -1) {
                JOptionPane.showMessageDialog(null, "Porfavor Complete os Campos e Selecione a Linha na Tabela a ser editada e em Seguida clicke no botao Editar");
            } else {
                // System.out.println(k);

                int i = ((ClinicaTableModel) tbClinica.getModel()).getListaclinicas().get(k).getIdclinica();

                Statement stmt = conn.createStatement();
                String sql = "UPDATE clinica SET nome = " + nome + ",cnpj = " + cnpj + ",cidadeclinica = " + cidade + " WHERE idclinica = " + i + "";
                stmt.executeUpdate(sql);

                stmt.close();
                conn.close();

                JOptionPane.showMessageDialog(null, "Clinica Editada!");

                String Mostrar = " ";
                txtNomeClinica.setText(Mostrar);
                txtCnpjClinica.setText(Mostrar);
                txtCidadeClinica.setText(Mostrar);

                Clinicas = listarTbClinica();
                ClinicaTableModel modelo = new ClinicaTableModel();
                modelo.setListaClinicas(Clinicas);
                tbClinica.setModel(modelo);

                combClinicaMedico.removeAllItems();

                lclinica = listarClinicas();

                for (int i2 = 0; i2 < lclinica.size(); i2++) {
                    combClinicaMedico.addItem(lclinica.get(i2));

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditarClinicaActionPerformed

    private void btnExcluirClinicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirClinicaActionPerformed
        conn = Banco.conecta();

        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("erro ao conectar ao banco de dados");
                System.exit(-1);

            }
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir esse Item?", "Excluindo", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                int k = tbClinica.getSelectedRow();
                if (k == -1) {
                    JOptionPane.showMessageDialog(null, "Selecione um Admin para deletar");
                } else {
                    // System.out.println(k);
                    int i = ((ClinicaTableModel) tbClinica.getModel()).getListaclinicas().get(k).getIdclinica();

                    Statement stmt = conn.createStatement();
                    String sql = "Delete from clinica where idclinica = " + i + " ";
                    stmt.executeUpdate(sql);

                    stmt.close();
                    conn.close();

                    JOptionPane.showMessageDialog(null, "Clinica Apagada!");

                    String Mostrar = " ";
                    txtNomeAdmin.setText(Mostrar);
                    txtCnpjClinica.setText(Mostrar);
                    txtCidadeClinica.setText(Mostrar);

                    Clinicas = listarTbClinica();
                    ClinicaTableModel modelo = new ClinicaTableModel();
                    modelo.setListaClinicas(Clinicas);
                    tbClinica.setModel(modelo);

                    combClinicaMedico.removeAllItems();

                    lclinica = listarClinicas();

                    for (int i2 = 0; i2 < lclinica.size(); i2++) {
                        combClinicaMedico.addItem(lclinica.get(i2));

                    }
                }
            } else if (resposta == JOptionPane.NO_OPTION) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcluirClinicaActionPerformed

    private void chkAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAdmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkAdmActionPerformed

    private void txtCpfMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfMedicoActionPerformed

    private void txtSenhaAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaAdminActionPerformed

    private void txtSenhaAdmin2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaAdmin2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaAdmin2ActionPerformed

    private void btnCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarClienteActionPerformed
        conn = Banco.conecta();
        String Mostrar = null;
        String sql = "";
        String sql2 = "";

        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("erro ao conectar ao banco de dados");
                System.exit(-1);
            }

            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
            Date aux = txtDataNascimentoCliente.getDate();

            String nome = "'" + txtNomeCliente.getText() + "'";
            String rg = "'" + txtRgCliente.getText() + "'";
            String cpf = "'" + txtCpfCliente.getText() + "'";

            String dataNasc = "'" + sdf1.format(aux) + "'";
            Integer idclinica = ((Clinica) combClinicaCliente.getSelectedItem()).getIdclinica();
            Integer idclinicaLeito = ((Clinica) combClinicaCliente.getSelectedItem()).getLeito();
            Integer idmedico = ((Medico) combMedicoCliente.getSelectedItem()).getIdmedico();

            
            if (idclinicaLeito < 1) {
                

                JOptionPane.showMessageDialog(null, "Vagas Esgotadas");

            } else {

                if (txtNomeCliente.getText().isEmpty() || txtRgCliente.getText().isEmpty() || txtCpfCliente.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Preencha Todos os Campos!!");
                } else {

                    Statement stmt = conn.createStatement();

                    sql = "INSERT INTO Cliente (nome,rg, cpf, datanascimento, idclinica, idmedico ) VALUES ("
                            + "" + nome + "," + rg + "," + cpf + "," + dataNasc + "," + idclinica + ","
                            + " " + idmedico + ")";
                    // subtraindo quantidade de leitos da clinica onde o clinete foi cadastrado
                    sql2 = "UPDATE clinica SET leito = leito -1 WHERE idclinica = " + idclinica + "";

                    System.out.println("sql: " + sql);

                    //atravez desse objeto usamos comandos sql
                    stmt = conn.createStatement();
                    stmt.executeUpdate(sql);
                    stmt.executeUpdate(sql2);
                    //select
                    //stmt.executeQuery(sql);
                    //retorna um conjunto de dados , sempre q for fazer insert usar o executeUpdate : inset, update, delete

                    //encerrou a conexão
                    stmt.close();
                    conn.close();
                    JOptionPane.showMessageDialog(null, "Paciente cadastrado!");

                    txtNomeCliente.setText(Mostrar);
                    txtCpfCliente.setText(Mostrar);
                    txtRgCliente.setText(Mostrar);

                    Clientes = listarTbCliente();

                    ClienteTableModel modelo = new ClienteTableModel();
                    modelo.setListaClientes(Clientes);

                    tbCliente.setModel(modelo);

                    Clinicas = listarTbClinica();

                    ClinicaTableModel modelo2 = new ClinicaTableModel();
                    modelo2.setListaClinicas(Clinicas);

                    tbClinica.setModel(modelo2);

                    //   alinharTbMedicos(tbMedico);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCadastrarClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        conn = Banco.conecta();

        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("erro ao conectar ao banco de dados");
                System.exit(-1);

            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date aux = txtDataNascimentoCliente.getDate();

            String nome = "'" + txtNomeCliente.getText() + "'";
            String rg = "'" + txtRgCliente.getText() + "'";
            String cpf = "'" + txtCpfCliente.getText() + "'";
            String dataNasc = "'" + sdf.format(aux) + "'";

            int k = tbCliente.getSelectedRow();
            if (k == -1) {
                JOptionPane.showMessageDialog(null, "Porfavor Complete os Campos e Selecione a Linha na Tabela a ser editada e em Seguida clicke no botao Editar");
            } else {
                // System.out.println(k);
                int i = ((ClienteTableModel) tbCliente.getModel()).getListaClientes().get(k).getIdcliente();

                Statement stmt = conn.createStatement();
                String sql = "UPDATE cliente SET nome = " + nome + ",rg = " + rg + ",cpf = " + cpf + ",datanascimento = " + dataNasc + "WHERE idcliente = " + i + "";
                stmt.executeUpdate(sql);

                stmt.close();
                conn.close();

                JOptionPane.showMessageDialog(null, "Cliente Editado!");

                String Mostrar = null;
                txtNomeCliente.setText(Mostrar);
                txtCpfCliente.setText(Mostrar);
                txtRgCliente.setText(Mostrar);

                Clientes = listarTbCliente();
                ClienteTableModel modelo = new ClienteTableModel();
                modelo.setListaClientes(Clientes);
                tbCliente.setModel(modelo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void combClinicaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combClinicaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combClinicaClienteActionPerformed

    private void txtDataNascimentoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataNascimentoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataNascimentoClienteActionPerformed

    private void btnExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirClienteActionPerformed

        conn = Banco.conecta();

        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("erro ao conectar ao banco de dados");
                System.exit(-1);

            }

            int resposta = JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir esse Item?", "Excluindo", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {

                int k = tbCliente.getSelectedRow();
                if (k == -1) {
                    JOptionPane.showMessageDialog(null, "Selecione um Cliente para deletar");
                } else {
                    // System.out.println(k);
                    int i = ((ClienteTableModel) tbCliente.getModel()).getListaClientes().get(k).getIdcliente();
                    int j = ((ClienteTableModel) tbCliente.getModel()).getListaClientes().get(k).getIdclinica();

                    Statement stmt = conn.createStatement();
                    String sql = "Delete from cliente where idcliente = " + i + " ";
                    String sql2 = "UPDATE clinica SET leito = leito +1 WHERE idclinica = " + j + "";
                    stmt.executeUpdate(sql);
                    stmt.executeUpdate(sql2);

                    stmt.close();
                    conn.close();

                    JOptionPane.showMessageDialog(null, "Cliente(a) Apagado!");

                    String Mostrar = null;
                    txtNomeCliente.setText(Mostrar);
                    txtCpfCliente.setText(Mostrar);
                    txtRgCliente.setText(Mostrar);

                    Clientes = listarTbCliente();
                    ClienteTableModel modelo = new ClienteTableModel();
                    modelo.setListaClientes(Clientes);
                    tbCliente.setModel(modelo);

                    Clinicas = listarTbClinica();
                    ClinicaTableModel modelo2 = new ClinicaTableModel();
                    modelo2.setListaClinicas(Clinicas);
                    tbClinica.setModel(modelo2);
                }
            } else if (resposta == JOptionPane.NO_OPTION) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcluirClienteActionPerformed

    private void combAdminMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combAdminMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combAdminMedicoActionPerformed

    private void combMedicoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combMedicoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combMedicoClienteActionPerformed

    private void txtLeitoClinicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLeitoClinicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLeitoClinicaActionPerformed

    private void combFuncaoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combFuncaoFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combFuncaoFuncionarioActionPerformed

    private void txtDataNascimentoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataNascimentoFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataNascimentoFuncionarioActionPerformed

    private void btnCadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarFuncionarioActionPerformed
        conn = Banco.conecta();
        String Mostrar = null;
        String sql = "";
        String sql2 = "";

        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("erro ao conectar ao banco de dados");
                System.exit(-1);
            }

            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
            Date aux = txtDataNascimentoFuncionario.getDate();

            String nome = "'" + txtNomeFuncionario.getText() + "'";
            String rg = "'" + txtRgFuncionario.getText() + "'";
            String cpf = "'" + txtCpfFuncionario.getText() + "'";

            String dataNasc = "'" + sdf1.format(aux) + "'";
            Integer idclinica = ((Clinica) combClinicaFuncionario.getSelectedItem()).getIdclinica();
            Integer idfuncao = ((Funcao) combFuncaoFuncionario.getSelectedItem()).getIdFuncao();
            Integer idfuncaoVagas = ((Funcao) combFuncaoFuncionario.getSelectedItem()).getVagas();
            Integer turnoaux = (Integer) combTurnoFuncionario.getSelectedIndex();
            String turno = "";

            if (idfuncaoVagas <= 0) {

                JOptionPane.showMessageDialog(null, "Vagas Esgotadas");

            } else {

                switch (turnoaux) {
                    case 0:
                        turno = "'Manhâ'";
                        break;
                    case 1:
                        turno = "'Tarde'";
                        break;
                    case 2:
                        turno = "'Noite'";
                        break;
                    default:

                        break;

                }

                if (txtNomeFuncionario.getText().isEmpty() || txtRgFuncionario.getText().isEmpty() || txtCpfFuncionario.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Preencha Todos os Campos!!");
                } else {

                    Statement stmt = conn.createStatement();

                    sql = "INSERT INTO Funcionario (nome,rg, cpf, datanascimento, idclinica, idfuncao, turno ) VALUES ("
                            + "" + nome + "," + rg + "," + cpf + "," + dataNasc + "," + idclinica + ","
                            + " " + idfuncao + "," + turno + ")";
                    // subtraindo quantidade de leitos da clinica onde o clinete foi cadastrado
                    sql2 = "UPDATE funcao SET vagas = vagas -1 WHERE idfuncao = " + idfuncao + "";

                    System.out.println("sql: " + sql);

                    //atravez desse objeto usamos comandos sql
                    stmt = conn.createStatement();
                    stmt.executeUpdate(sql);
                    stmt.executeUpdate(sql2);
                    //select
                    //stmt.executeQuery(sql);
                    //retorna um conjunto de dados , sempre q for fazer insert usar o executeUpdate : inset, update, delete

                    //encerrou a conexão
                    stmt.close();
                    conn.close();
                    JOptionPane.showMessageDialog(null, "Funcionário(a) Cadastrado!");

                    txtNomeFuncionario.setText(Mostrar);
                    txtCpfFuncionario.setText(Mostrar);
                    txtRgFuncionario.setText(Mostrar);

                    Funcionarios = listarTbFuncionario();

                    FuncionarioTableModel modelo = new FuncionarioTableModel();
                    modelo.setListaFuncionarios(Funcionarios);

                    tbFuncionario.setModel(modelo);

                    Funcao = listarTbFuncao();

                    FuncaoTableModel modelo2 = new FuncaoTableModel();
                    modelo2.setListaFuncao(Funcao);
                    tbFuncao.setModel(modelo2);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCadastrarFuncionarioActionPerformed

    private void btnEditarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarFuncionarioActionPerformed
        conn = Banco.conecta();

        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("erro ao conectar ao banco de dados");
                System.exit(-1);

            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date aux = txtDataNascimentoFuncionario.getDate();

            String nome = "'" + txtNomeFuncionario.getText() + "'";
            String rg = "'" + txtRgFuncionario.getText() + "'";
            String cpf = "'" + txtCpfFuncionario.getText() + "'";
            String dataNasc = "'" + sdf.format(aux) + "'";
            Integer turnoaux = (Integer) combTurnoFuncionario.getSelectedIndex();
            String turno = "";

            switch (turnoaux) {
                case 0:
                    turno = "'Manhâ'";
                    break;
                case 1:
                    turno = "'Tarde'";
                    break;
                case 2:
                    turno = "'Noite'";
                    break;
                default:
                    break;

            }

            int k = tbFuncionario.getSelectedRow();
            if (k == -1) {
                JOptionPane.showMessageDialog(null, "Porfavor Complete os Campos e Selecione a Linha na Tabela a ser editada e em Seguida clicke no botao Editar");
            } else {
                // System.out.println(k);
                int i = ((FuncionarioTableModel) tbFuncionario.getModel()).getListaFuncionarios().get(k).getIdFuncionario();

                Statement stmt = conn.createStatement();
                String sql = "UPDATE Funcionario SET nome = " + nome + ",rg = " + rg + ","
                        + "cpf = " + cpf + ",datanascimento = " + dataNasc + ", turno = " + turno + "WHERE idFuncionario = " + i + "";
                stmt.executeUpdate(sql);

                stmt.close();
                conn.close();

                JOptionPane.showMessageDialog(null, "Funcionario Editado!");

                String Mostrar = null;
                txtNomeFuncionario.setText(Mostrar);
                txtCpfFuncionario.setText(Mostrar);
                txtRgFuncionario.setText(Mostrar);

                Funcionarios = listarTbFuncionario();
                FuncionarioTableModel modelo = new FuncionarioTableModel();
                modelo.setListaFuncionarios(Funcionarios);
                tbFuncionario.setModel(modelo);

                Funcao = listarTbFuncao();

                FuncaoTableModel modelo2 = new FuncaoTableModel();
                modelo2.setListaFuncao(Funcao);
                tbFuncao.setModel(modelo2);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditarFuncionarioActionPerformed

    private void txtCpfFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfFuncionarioActionPerformed

    private void btnExcluirFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirFuncionarioActionPerformed
        conn = Banco.conecta();

        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("erro ao conectar ao banco de dados");
                System.exit(-1);

            }
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir esse Item?", "Excluindo", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                int k = tbFuncionario.getSelectedRow();
                if (k == -1) {
                    JOptionPane.showMessageDialog(null, "Selecione um Funcionario para deletar");
                } else {
                    // System.out.println(k);
                    int i = ((FuncionarioTableModel) tbFuncionario.getModel()).getListaFuncionarios().get(k).getIdFuncionario();
                    int j = ((FuncionarioTableModel) tbFuncionario.getModel()).getListaFuncionarios().get(k).getIdfuncao();

                    Statement stmt = conn.createStatement();
                    String sql = "Delete from Funcionario where idFuncionario = " + i + " ";
                    String sql2 = "UPDATE funcao SET vagas = vagas +1 WHERE idfuncao = " + j + "";
                    stmt.executeUpdate(sql);
                    stmt.executeUpdate(sql2);

                    stmt.close();
                    conn.close();

                    JOptionPane.showMessageDialog(null, "Funcionario(a) Apagado!");

                    String Mostrar = null;
                    txtNomeFuncionario.setText(Mostrar);
                    txtCpfFuncionario.setText(Mostrar);
                    txtRgFuncionario.setText(Mostrar);

                    Funcionarios = listarTbFuncionario();
                    FuncionarioTableModel modelo = new FuncionarioTableModel();
                    modelo.setListaFuncionarios(Funcionarios);
                    tbFuncionario.setModel(modelo);

                    Funcao = listarTbFuncao();

                    FuncaoTableModel modelo2 = new FuncaoTableModel();
                    modelo2.setListaFuncao(Funcao);
                    tbFuncao.setModel(modelo2);
                }
            } else if (resposta == JOptionPane.NO_OPTION) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcluirFuncionarioActionPerformed

    private void txtNomeFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeFuncionarioActionPerformed

    private void combClinicaFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combClinicaFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combClinicaFuncionarioActionPerformed

    private void txtNomeFuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeFuncaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeFuncaoActionPerformed

    private void btnCadastrarFuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarFuncaoActionPerformed
        String Mostrar = null;
        conn = Banco.conecta();
        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("erro ao conectar ao banco de dados");
                System.exit(-1);
            }

            String nome = "'" + txtNomeFuncao.getText() + "'";
            String salariobase = txtSalariobaseFuncao.getText();
            String vagas = txtVagasFuncao.getText();

            if (txtNomeFuncao.getText().isEmpty() || txtSalariobaseFuncao.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Preencha Todos os Campos!!");
            } else {

                String sql = "INSERT INTO Funcao(nome, salariobase, vagas) VALUES ("
                        + "" + nome + "," + salariobase + "," + vagas + ")";
                System.out.println("sql: " + sql);

                //atravez desse objeto usamos comandos sql
                Statement stmt = conn.createStatement();

                //select
                //stmt.executeQuery(sql);
                //retorna um conjunto de dados , sempre q for fazer insert usar o executeUpdate : inset, update, delete
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Funcao" + nome + "cadastrado!!");

                //encerrou a conexão
                stmt.close();
                conn.close();

                txtNomeFuncao.setText(Mostrar);
                txtSalariobaseFuncao.setText(Mostrar);
                txtVagasFuncao.setText(Mostrar);

                Funcao = listarTbFuncao();

                FuncaoTableModel modelo = new FuncaoTableModel();
                modelo.setListaFuncao(Funcao);
                tbFuncao.setModel(modelo);

            }
            combFuncaoFuncionario.removeAllItems();
                lfuncao = listarfuncao();
                for (int i = 0; i < lfuncao.size(); i++) {
                    combFuncaoFuncionario.addItem(lfuncao.get(i));
                }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCadastrarFuncaoActionPerformed

    private void btnExcluirFuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirFuncaoActionPerformed
        conn = Banco.conecta();

        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("erro ao conectar ao banco de dados");
                System.exit(-1);

            }
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir esse Item?", "Excluindo", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                int k = tbFuncao.getSelectedRow();
                if (k == -1) {
                    JOptionPane.showMessageDialog(null, "Selecione um Funcao para deletar");
                } else {

                    // System.out.println(k);
                    int i = ((FuncaoTableModel) tbFuncao.getModel()).getListaFuncao().get(k).getIdFuncao();

                    Statement stmt = conn.createStatement();

                    String sql = "Delete from Funcao where idFuncao = " + i + " ";
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Funcao Apagado!");

                    stmt.close();
                    conn.close();

                    String Mostrar = " ";
                    txtNomeFuncao.setText(Mostrar);
                    txtSalariobaseFuncao.setText(Mostrar);
                    // txtVagas.setText(Mostrar);

                    Funcao = listarTbFuncao();
                    FuncaoTableModel modelo = new FuncaoTableModel();
                    modelo.setListaFuncao(Funcao);
                    tbFuncao.setModel(modelo);

                }
            } else if (resposta == JOptionPane.NO_OPTION) {

            }
            combFuncaoFuncionario.removeAllItems();
                lfuncao = listarfuncao();
                for (int i = 0; i < lfuncao.size(); i++) {
                    combFuncaoFuncionario.addItem(lfuncao.get(i));
                }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcluirFuncaoActionPerformed

    private void btnEditarFuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarFuncaoActionPerformed
        String Mostrar = null;
        conn = Banco.conecta();

        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("erro ao conectar ao banco de dados");
                System.exit(-1);

            }

            String nome = "'" + txtNomeFuncao.getText() + "'";
            String salariobase = "'" + txtSalariobaseFuncao.getText() + "'";
            //     String Vagas = "'" + txtSenhaFuncao.getText() + "'";

            int k = tbFuncao.getSelectedRow();
            if (k == -1) {
                JOptionPane.showMessageDialog(null, "Porfavor Complete os Campos e Selecione a Linha na Tabela a ser editada e em Seguida clicke no botao Editar");
                txtSalariobaseFuncao.setText(Mostrar);
            } else {
                // System.out.println(k);

                int i = ((FuncaoTableModel) tbFuncao.getModel()).getListaFuncao().get(k).getIdFuncao();

                try (Statement stmt = conn.createStatement()) {
                    String sql = "UPDATE Funcao SET nome = " + nome + ",salariobase = " + salariobase + " WHERE idFuncao = " + i + "";
                    stmt.executeUpdate(sql);
                }
                conn.close();

                JOptionPane.showMessageDialog(null, "Funcao Editado!");

                txtNomeFuncao.setText(Mostrar);
                txtSalariobaseFuncao.setText(Mostrar);
                //txtVaga.setText(Mostrar);

                Funcao = listarTbFuncao();
                FuncaoTableModel modelo = new FuncaoTableModel();
                modelo.setListaFuncao(Funcao);
                tbFuncao.setModel(modelo);
            }
            combFuncaoFuncionario.removeAllItems();
                lfuncao = listarfuncao();
                for (int i = 0; i < lfuncao.size(); i++) {
                    combFuncaoFuncionario.addItem(lfuncao.get(i));
                }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditarFuncaoActionPerformed

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        JOptionPane.showMessageDialog(null, "Click no Botao de Sair na Ultima Aba");
    }//GEN-LAST:event_jLabel37MouseClicked

    private void chkAdmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkAdmMouseClicked
        JOptionPane.showMessageDialog(null, "Tem Certeza que deseja Tornar esse Usuário como Admin?");
    }//GEN-LAST:event_chkAdmMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        if (jTabbedPane1.getSelectedIndex() == 7) {

            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente Sair do Sistema?", "Saindo", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                Login init = new Login();
                init.setVisible(true); //torna visivel frame de cadastro
                setVisible(false);//tira a tela de login
                dispose(); //fecha o form de login (quem chamou)
            } else if (resposta == JOptionPane.NO_OPTION) {

            }
        }

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void txtNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeClienteActionPerformed

    private void txtCpfClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroAdm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Cliente;
    private javax.swing.JPanel JPainelLabelsTxt;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel Sair;
    private javax.swing.JPanel admin;
    private javax.swing.JButton btnCadastrarAdmin;
    private javax.swing.JButton btnCadastrarCliente;
    private javax.swing.JButton btnCadastrarClinica;
    private javax.swing.JButton btnCadastrarFuncao;
    private javax.swing.JButton btnCadastrarFuncionario;
    private javax.swing.JButton btnEditarAdmin;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEditarClinica;
    private javax.swing.JButton btnEditarFuncao;
    private javax.swing.JButton btnEditarFuncionario;
    private javax.swing.JButton btnEditarMedico;
    private javax.swing.JButton btnExcluirAdmin;
    private javax.swing.JButton btnExcluirCliente;
    private javax.swing.JButton btnExcluirClinica;
    private javax.swing.JButton btnExcluirFuncao;
    private javax.swing.JButton btnExcluirFuncionario;
    private javax.swing.JButton btnExcluirMedico;
    private javax.swing.JCheckBox chkAdm;
    private javax.swing.JPanel clinica;
    private javax.swing.JComboBox<Admin> combAdminMedico;
    private javax.swing.JComboBox<Clinica> combClinicaCliente;
    private javax.swing.JComboBox<Clinica> combClinicaFuncionario;
    private javax.swing.JComboBox<Clinica> combClinicaMedico;
    private javax.swing.JComboBox<Funcao> combFuncaoFuncionario;
    private javax.swing.JComboBox<Medico> combMedicoCliente;
    private javax.swing.JComboBox<String> combTurnoFuncionario;
    private javax.swing.JPanel funcionario;
    private javax.swing.JPanel função;
    private javax.swing.JButton jButton1Medico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelBagCad;
    private javax.swing.JPanel jPanelTxtTxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel medico;
    private javax.swing.JTable tbAdmin;
    private javax.swing.JTable tbCliente;
    private javax.swing.JTable tbClinica;
    private javax.swing.JTable tbFuncao;
    private javax.swing.JTable tbFuncionario;
    private javax.swing.JTable tbMedico;
    private javax.swing.JTextField txtCidadeClinica;
    private javax.swing.JFormattedTextField txtCnpjClinica;
    private javax.swing.JFormattedTextField txtCpfCliente;
    private javax.swing.JFormattedTextField txtCpfFuncionario;
    private javax.swing.JFormattedTextField txtCpfMedico;
    private javax.swing.JTextField txtCrmMedico;
    private org.jdesktop.swingx.JXDatePicker txtDataNascimentoCliente;
    private org.jdesktop.swingx.JXDatePicker txtDataNascimentoFuncionario;
    private org.jdesktop.swingx.JXDatePicker txtDataNascimentoMedico;
    private javax.swing.JFormattedTextField txtLeitoClinica;
    private javax.swing.JTextField txtLoginAdmin;
    private javax.swing.JTextField txtNomeAdmin;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeClinica;
    private javax.swing.JTextField txtNomeFuncao;
    private javax.swing.JTextField txtNomeFuncionario;
    private javax.swing.JTextField txtNomeMedico;
    private javax.swing.JFormattedTextField txtRgCliente;
    private javax.swing.JFormattedTextField txtRgFuncionario;
    private javax.swing.JTextField txtSalariobaseFuncao;
    private javax.swing.JPasswordField txtSenhaAdmin;
    private javax.swing.JPasswordField txtSenhaAdmin2;
    private javax.swing.JTextField txtVagasFuncao;
    // End of variables declaration//GEN-END:variables

}
