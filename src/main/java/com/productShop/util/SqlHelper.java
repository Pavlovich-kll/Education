//package com.productShop.util;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class SqlHelper {
//   DBConnection connection;
//
//    public SqlHelper(String url, String user, String password) {
//        connection = () -> DriverManager.getConnection(url, user, password);
//    }
//
//    public void execute(String sqlCommand) {
//        execute(sqlCommand, PreparedStatement::execute);
//    }
//
//    public <T> T execute(String sqlCommand, SqlProcessor<T> sqlProcessor) {
//        try (Connection conn = connectionFactory.getConnection();
//             PreparedStatement ps = conn.prepareStatement(sqlCommand)) {
//            return sqlProcessor.process(ps);
//        } catch (SQLException e) {
//            throw ExceptionUtil.convertException(e);
//        }
//    }
//
//    public <T> T transactionalExecute(SqlTransaction<T> executor) {
//        try (Connection conn = connectionFactory.getConnection()) {
//            try {
//                conn.setAutoCommit(false);//после каждого execute транзакция коммитится
//                T res = executor.execute(conn);
//                conn.commit();
//                return res;
//            } catch (SQLException e) {
//                conn.rollback();
//                throw ExceptionUtil.convertException(e);
//            }
//        } catch (SQLException e) {
//            throw new StorageException(e);
//        }
//    }
//}