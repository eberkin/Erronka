package ticketbaiproiektua;

public void adduser(User s) {
    try {
         sql = "insert into users ('u_fname', 'u_lname', 'u_uname', 'u_pass', 'u_age', 'u_adderess')"
                 + "values('" + s.getFirstname() + "','" + s.getLastname()
                 + "','" + s.getUsername() + "','" + s.getPassword() + "','" + s.getAge() + "','" + s.getAdderss() + "')";
         stmt = conn.createStatement();
         int i = stmt.executeUpdate(sql);
         if (i > 0) {
             System.out.println("ROW INSERTED");
         } else {
             System.out.println("ROW NOT INSERTED");
         }
     } catch (Exception e) {
         System.out.println(e);
     }
 
 }