import java.sql.*;


public class Database {

    //Controls Database

    private static final String URL = "jdbc:mysql://localhost:3306/fairFlow";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void registerCategory(Category category) {
        String query = "INSERT INTO categories (id, name, description) VALUES (?, ?, ?)";

        String queryForCategoryExistence = "SELECT * FROM categories WHERE name = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stz = conn.prepareStatement(queryForCategoryExistence)) {
            stz.setString(1, category.getName());
            ResultSet resultSet = stz.executeQuery();

            if (!resultSet.next()) {
                //If Category Doesn't Exist Register It
                try (PreparedStatement st = conn.prepareStatement(query)) {

                    st.setString(1, category.getId());
                    st.setString(2, category.getName());
                    st.setString(3, category.getDescription());

                    st.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }else {
                System.out.println("CATEGORY 200 OK -- Already Exists");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void registerOrganization(Organization organization) {
        String query = "INSERT INTO organizations (id, name, email, password, description, location) VALUES (?, ?, ?, ?, ?, ?)";

        String queryForCompanyExistence = "SELECT * FROM organizations WHERE name = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stz = conn.prepareStatement(queryForCompanyExistence)) {
            stz.setString(1, organization.getName());
            ResultSet resultSet = stz.executeQuery();

            if (!resultSet.next()) {
                //If Company Doesn't Exist Register It
                try (PreparedStatement st = conn.prepareStatement(query)) {

                    st.setString(1, organization.getId());
                    st.setString(2, organization.getName());
                    st.setString(3, organization.getEmail());
                    st.setString(4, organization.getPassword());
                    st.setString(5, organization.getDescription());
                    st.setString(6, organization.getDescription());

                    st.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }else {
                System.out.println("Company 200 OK -- Already Exists");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void registerFunds(Fund fund) {

        String query = "INSERT INTO funds (id, name, description, organization) VALUES (?, ?, ?, ?)";

        String queryForCompanyExistence = "SELECT * FROM organizations WHERE id = ?";
        //The organization Must be registered for them to add funds

        try (Connection conn = Database.getConnection();
             PreparedStatement stz = conn.prepareStatement(queryForCompanyExistence)) {
            stz.setString(1, fund.getOrganization());
            ResultSet resultSet = stz.executeQuery();

            if (resultSet.next()) {
                //If Company Exists Add The fund
                //--First Check if the Fund Is already added
                String queryForFundExistence = "SELECT * FROM funds WHERE name = ?";

                try (conn; PreparedStatement s = conn.prepareStatement(queryForFundExistence)) {
                    s.setString(1, fund.getName());
                    ResultSet reset = s.executeQuery();

                    if (!reset.next()) {
                        try (PreparedStatement st = conn.prepareStatement(query)) {

                            st.setString(1, fund.getId());
                            st.setString(2, fund.getName());
                            st.setString(3, fund.getDescription());
                            st.setString(4, fund.getOrganization());

                            st.executeUpdate();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("200 OK--FUND NAME ALREADY EXISTS");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }else {
                System.out.println("Company 404 ERR -- Not Found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean registerUser(User user) {
        String query = "INSERT INTO users (id, name, email, password, userType, organization) VALUES (?, ?, ?, ?, ?, ?)";

        String queryForUserExistence = "SELECT * FROM users WHERE name = ?";
        String queryForCompanyExistence = "SELECT * FROM organizations WHERE id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stz = conn.prepareStatement(queryForCompanyExistence)) {
            stz.setString(1, user.getOrganization());
            ResultSet resultSet = stz.executeQuery();

            if (!resultSet.next()) {
                //If Company Doesn't Exist
                System.out.println("Company 404");
            }else {
                try (conn;
                     PreparedStatement stmt = conn.prepareStatement(queryForUserExistence)) {
                    stmt.setString(1, user.getName());
                    ResultSet rs = stmt.executeQuery();

                    if (!rs.next()) {

                        try (PreparedStatement st = conn.prepareStatement(query)) {

                            st.setString(1, user.getId());
                            st.setString(2, user.getName());
                            st.setString(3, user.getEmail());
                            st.setString(4, user.getPassword());
                            st.setString(5, user.getAccountType());
                            st.setString(6, user.getOrganization());

                            st.executeUpdate();
                            return true;
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    } else {
                        System.out.println("User name " + user.getName() + " is already registered");
                    }


                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
