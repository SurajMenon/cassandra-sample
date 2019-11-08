package io.cassandra;

import java.util.List;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Cluster.Builder;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class CassandraConnector {

	public static void main(String args[]) {
		
		Builder b = Cluster.builder().addContactPoint("localhost");
        
        Cluster cluster = b.build();
        Session session = cluster.connect();
        
        String query = "select * from test.emp where emp_id=1";
        ResultSet response = session.execute(query);
        
        List<Row> results = response.all();
        System.out.println(results.get(0).getString("emp_name"));
        
        session.close();
        cluster.close();
	}
}
