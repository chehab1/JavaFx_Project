public class connn {

    public static void main(String[] args) {
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","chehabhatesjava");
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery("select * from login");
            while(set.next()){
                System.out.println(set.getString("name"))
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
