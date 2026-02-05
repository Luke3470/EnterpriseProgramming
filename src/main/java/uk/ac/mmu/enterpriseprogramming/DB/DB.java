package uk.ac.mmu.enterpriseprogramming.DB;

import java.sql.Connection;
import java.sql.SQLException;

public interface DB {
    Connection createCon() throws SQLException;
}
