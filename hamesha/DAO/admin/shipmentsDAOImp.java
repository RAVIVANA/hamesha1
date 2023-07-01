package eStoreProduct.DAO.admin;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class shipmentsDAOImp implements shipmentsDAO {

	private EntityManager entityManager;
	private final JdbcTemplate jdbcTemplate;
	    private static final Logger logger = LoggerFactory.getLogger(shipmentsDAOImp.class);


	@Autowired
	public shipmentsDAOImp(DataSource dataSource) {
								    logger.info("in shipmentsDAOImp constructor ");

		jdbcTemplate = new JdbcTemplate(dataSource);
	}

}
