public class scratch {
    


  
  public List<Ticket> getAllById(int employee_id) {
    List<Ticket> tickets = new ArrayList<>();

    try {
        String sql = "SELECT * FROM tickets WHERE employee_id = ?";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, employee_id);

        ResultSet rs = pstmt.executeQuery();

        // Returns a ticket therefore a new instance of a ticket from database has
        // to be created
        Ticket ticket = new Ticket();

        while (rs.next()) {
            ticket.setId(rs.getInt("id"));
            ticket.setAmount(rs.getDouble("amount"));
            ticket.setStatus(rs.getString("status"));
            ticket.setDescription(rs.getString("description"));
            tickets.add(ticket);
        }

        return tickets;

    } catch (SQLException sqlException) {
        System.out.println(sqlException.getMessage());
    }
    return null;
}

}
