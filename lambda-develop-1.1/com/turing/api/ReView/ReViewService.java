package com.turing.api.ReView;

import java.sql.SQLException;
import java.util.List;

public interface ReViewService {
    List<?> showall() throws SQLException;
}
