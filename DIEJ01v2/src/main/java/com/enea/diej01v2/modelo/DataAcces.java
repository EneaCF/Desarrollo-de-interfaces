package com.enea.diej01v2.modelo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Properties;


public class DataAcces {

    private Connection getConnection() {
        Connection connection = null;
        Properties properties = new Properties();
        try {
            InputStream is = new FileInputStream("src/main/java/com/enea/diej01v2/propiedades/application.propierties");
            properties.load(is);
            is.close();
            //properties.load(DataAcces.class.getClassLoader().getResourceAsStream("pro1/application.propierties"));
            connection = DriverManager.getConnection(properties.getProperty("application.url"),
                    properties.getProperty("application.user"), 
                    properties.getProperty("application.password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ArrayList<Municipi> getMunicipis() {
        ArrayList<Municipi> municipis = new ArrayList<>();
        String sql = "SELECT * FROM municipi";
        try ( Connection connection = getConnection();  PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Municipi municipi = new Municipi();
                municipi.setId(resultSet.getInt("id"));
                municipi.setNom(resultSet.getString("nom"));
                municipis.add(municipi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return municipis;
    }

    public String findUserPassword(String email) {
        String passwordInDb = null;
        String sql = "SELECT password FROM usuari WHERE email = ?";
        try ( Connection connection = getConnection();  PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setString(1, email);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                passwordInDb = resultSet.getString("password");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passwordInDb;
    }

    public int getUserId(String email) {
        int userId = 0;
        String sql = "SELECT id FROM usuaris WHERE email = ?";
        try ( Connection connection = getConnection();  PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setString(1, email);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                userId = resultSet.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    }

    public Usuari getUser(String email) {
        Usuari user = null;
        String sql = "SELECT * FROM usuari WHERE email = ?";
        try ( Connection connection = getConnection();  PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setString(1, email);
            ResultSet resultSet = selectStatement.executeQuery();
            user = new Usuari();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setNom(resultSet.getString("nom"));
                user.setLlinatges(resultSet.getString("llinatges"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setAdmin(resultSet.getBoolean("isAdmin"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public ArrayList<Allotjament> getAllotjaments(int userId) {
        ArrayList<Allotjament> allotjaments = new ArrayList<>();
        String sql = "SELECT allotjament.id AS id_allotjament, allotjament.nom AS nom_allotjament, descripcio, adresa,"
                + " municipi.nom AS nom_municipi, num_persones, preu_per_nit"
                + " FROM allotjament JOIN municipi ON allotjament.id_municipi=municipi.id"
                + " WHERE id_propietari=?";
        try ( Connection connection = getConnection();  PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, userId);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Allotjament allotjament = new Allotjament();
                allotjament.setId(resultSet.getInt("id_allotjament"));
                allotjament.setNom(resultSet.getString("nom_allotjament"));
                allotjament.setDescripcio(resultSet.getString("descripcio"));
                allotjament.setAdresa(resultSet.getString("adresa"));
                allotjament.setMunicipi(resultSet.getString("nom_municipi"));
                allotjament.setNum_persones(resultSet.getInt("num_persones"));
                allotjament.setPreu_per_nit(resultSet.getFloat("preu_per_nit"));

                allotjaments.add(allotjament);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allotjaments;
    }

    public Allotjament getAllotjament(int id) {
        Allotjament allotjament = new Allotjament();
        String sql = "SELECT allotjament.id AS id_allotjament, allotjament.nom AS nom_allotjament, descripcio, adresa,"
                + " municipi.nom AS nom_municipi, num_persones, preu_per_nit"
                + " FROM allotjament JOIN municipi ON allotjament.id_municipi=municipi.id"
                + " WHERE allotjament.id=?";
        try ( Connection connection = getConnection();  PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, id);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                allotjament.setId(resultSet.getInt("id_allotjament"));
                allotjament.setNom(resultSet.getString("nom_allotjament"));
                allotjament.setDescripcio(resultSet.getString("descripcio"));
                allotjament.setAdresa(resultSet.getString("adresa"));
                allotjament.setMunicipi(resultSet.getString("nom_municipi"));
                allotjament.setNum_persones(resultSet.getInt("num_persones"));
                allotjament.setPreu_per_nit(resultSet.getFloat("preu_per_nit"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allotjament;
    }

    public int updateAllojtament(Allotjament allotjament) {
        int result = 0;
        String sql = "UPDATE allotjament SET nom = ?, descripcio = ?,"
                + " num_persones = ?, adresa = ?, id_municipi = ?,"
                + " id_propietari = ?, destacat = ?, preu_per_nit = ?"
                + " WHERE id = ?";
        try ( Connection connection = getConnection();  PreparedStatement updateStatement = connection.prepareStatement(sql);) {
            updateStatement.setInt(9, allotjament.getId());
            updateStatement.setString(1, allotjament.getNom());
            updateStatement.setString(2, allotjament.getDescripcio());
            updateStatement.setInt(3, allotjament.getNum_persones());
            updateStatement.setString(4, allotjament.getAdresa());
            updateStatement.setInt(5, Integer.parseInt(allotjament.getMunicipi()));
            updateStatement.setInt(6, allotjament.getId_propietari());
            updateStatement.setBoolean(7, false);
            updateStatement.setFloat(8, allotjament.getPReu_per_nit());
            
            //System.out.println(allotjament.getId() + allotjament.getNom() + allotjament.getDescripcio() + allotjament.getNum_persones() + allotjament.getAdresa() 
            //+ allotjament.getId_municipi() + allotjament.getId_propietari() + "false" + allotjament.getPReu_per_nit());
            result = updateStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
     public int updateUsuari(Usuari usuari) {
        int result = 0;
        String sql = "UPDATE usuari SET nom = ?, llinatges = ?,"
                + " email = ?, password = ?"
                + " WHERE id = ?";
        try ( Connection connection = getConnection();  PreparedStatement updateStatement = connection.prepareStatement(sql);) {
            //updateStatement.setInt(9, allotjament.getId());
            updateStatement.setString(1, usuari.getNom());
            updateStatement.setString(2, usuari.getLlinatges());
            updateStatement.setString(3, usuari.getEmail());
            updateStatement.setString(4, usuari.getPassword());
            updateStatement.setInt(5, usuari.getId());
            
            result = updateStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int insertAllotjament(Allotjament allotjament) {
        int result = 0;
        String sql = "INSERT INTO allotjament (nom, descripcio, num_persones, adresa, "
                + "id_municipi, id_propietari, destacat, preu_per_nit) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        try ( Connection connection = getConnection();  PreparedStatement insertStatement = connection.prepareStatement(sql);) {
            insertStatement.setString(1, allotjament.getNom());
            insertStatement.setString(2, allotjament.getDescripcio());
            insertStatement.setInt(3, allotjament.getNum_persones());
            insertStatement.setString(4, allotjament.getAdresa());
            insertStatement.setInt(5, Integer.parseInt(allotjament.getMunicipi()));
            insertStatement.setInt(6, allotjament.getId_propietari());
            insertStatement.setBoolean(7, false);
            insertStatement.setFloat(8, allotjament.getPReu_per_nit());

            result = insertStatement.executeUpdate();

            if (result > 0) {
                result = getIdLastInsertedAllotjament();
            }
        } catch (SQLException e) {
            //e.printStackTrace();
        }
        return result;
    }

    public int getIdLastInsertedAllotjament() {
        int idAllotjament = 0;
        String sql = "SELECT MAX(id) AS last_id_allotjament FROM allotjament";
        try ( Connection connection = getConnection();  PreparedStatement selectStatement = connection.prepareStatement(sql);) {

            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                idAllotjament = resultSet.getInt("last_id_allotjament");  
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idAllotjament;
    }

    public ArrayList<Servei> getServeisAllotjament(int idAllotjament) {
        ArrayList<Servei> serveis = new ArrayList<>();
        String sql = "SELECT servei.id, servei.descripcio FROM servei JOIN servei_allotjament"
                + " ON servei.id=servei_allotjament.id_servei"
                + " WHERE servei_allotjament.id_allotjament=?";
        try ( Connection connection = getConnection();  PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, idAllotjament);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Servei servei = new Servei();
                servei.setId(resultSet.getInt("id"));
                servei.setDescripcio(resultSet.getString("descripcio"));
                serveis.add(servei);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serveis;
    }

    public int insertServei(int idservicio, int idAllotjament) {
        int result = 0;
        String sql = "INSERT INTO servei_allotjament (id_servei, id_allotjament) VALUES (?,?)";
        try ( Connection connection = getConnection();  PreparedStatement insertStatement = connection.prepareStatement(sql);) {
            insertStatement.setInt(1, idservicio);
            insertStatement.setInt(2, idAllotjament);
            result = insertStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("CATH DA INSERTSERVEI");
        }
        return result;
    }

    public void updateServeisAllotjament(int idAllotjament, int[] serveis) {
        
    }

    public ArrayList<Comentari> getComentaris(int idAllotjament) {
        ArrayList<Comentari> comentaris = new ArrayList<>();
        String sql = "SELECT comentari.id, comentari.text, comentari.dataihora,"
                + " comentari.id_usuari, comentari.id_allotjament, comentari.id_comentari_pare"
                + " FROM comentari WHERE id_allotjament = ?";
        try ( Connection connection = getConnection();  PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, idAllotjament);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Comentari comentari = new Comentari();
                comentari.setId(resultSet.getInt("id"));
                comentari.setText(resultSet.getString("text"));
                comentari.setDataihora(resultSet.getString("dataihora"));
                comentari.setIdUsuari(resultSet.getInt("id_usuari"));
                comentari.setIdAllotjament(resultSet.getInt("id_allotjament"));
                comentari.setIdComentariPare(resultSet.getInt("id_comentari_pare"));
                comentaris.add(comentari);
                /*
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dataihora = LocalDateTime.parse(resultSet.getString("dataihora"), dtf);
                System.out.println(getUser(resultSet.getInt("id_usuari")).getNom()
                        + " said:\n " + resultSet.getString("text") + "\nOn "
                        + dataihora.toString());
                 */
            }
        } catch (SQLException e) {
            
        }

        return comentaris;
    }
      
      
    public float getValoracioAllotjamentAvg(int idAllotjament) {
        float valoracioAvg = 0.0f;
        String sql = "SELECT AVG(num_estrelles) AS avg_valoracio FROM valoracio WHERE id_allotjament = ?";
        try ( Connection connection = getConnection();  PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, idAllotjament);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                valoracioAvg = resultSet.getFloat("avg_valoracio");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return valoracioAvg;
    }

    public int insertComentari(String text, int userId, int idAllotjament, int idComentariPare) {
        int result = 0;
        String sql = "INSERT INTO comentari (text, dataihora, id_usuari, id_allotjament"
                + ", id_comentari_pare) VALUES (?,?,?,?,?)";
        try ( Connection connection = getConnection();  PreparedStatement insertStatement = connection.prepareStatement(sql);) {
            insertStatement.setString(1, text);
            insertStatement.setString(2, LocalDateTime.now().toString());
            insertStatement.setInt(3, userId);
            insertStatement.setInt(4, idAllotjament);
            insertStatement.setInt(5, idComentariPare);
            result = insertStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

