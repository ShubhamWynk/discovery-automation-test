package config;

//import com.datastax.driver.core.Cluster;
//import com.datastax.driver.core.Session;

public class CassandraConnector {

//    private Cluster cluster;
//    private Session session;
//
//    public void connect(String node, Integer port) {
//        Cluster.Builder b = Cluster.builder().addContactPoint(node);
//        if (port != null) {
//            b.withPort(port);
//        }
//        cluster = b.build();
//
//        session = cluster.connect();
//    }
//
//    public Session getSession() {
//        return this.session;
//    }
//
//    public void createKeyspace(String keyspaceName, String replicationStrategy, int replicationFactor) {
//        StringBuilder sb =
//                new StringBuilder("CREATE KEYSPACE IF NOT EXISTS ")
//                        .append(keyspaceName).append(" WITH replication = {")
//                        .append("'class':'").append(replicationStrategy)
//                        .append("','replication_factor':").append(replicationFactor)
//                        .append("};");
//
//        String query = sb.toString();
//        session.execute(query);
//    }
//
//    public void deleteKeyspace(String keyspaceName) {
//        StringBuilder sb =
//                new StringBuilder("DROP KEYSPACE ").append(keyspaceName);
//
//        String query = sb.toString();
//        session.execute(query);
//    }
//
//    public void createTable(String tableName) {
//        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
//                .append(tableName).append("(")
//                .append("id uuid PRIMARY KEY, ")
//                .append("title text,")
//                .append("subject text);");
//
//        String query = sb.toString();
//        session.execute(query);
//    }
//
//    public void alterTableBooks(String tableName, String columnName, String columnType) {
//        StringBuilder sb = new StringBuilder("ALTER TABLE ")
//                .append(tableName).append(" ADD ")
//                .append(columnName).append(" ")
//                .append(columnType).append(";");
//
//        String query = sb.toString();
//        session.execute(query);
//    }
//
//    public void deleteTable(String tableName) {
//        StringBuilder sb =
//                new StringBuilder("DROP TABLE IF EXISTS ").append(tableName);
//
//        String query = sb.toString();
//        session.execute(query);
//    }
//
//    public void close() {
//        session.close();
//        cluster.close();
//    }
}