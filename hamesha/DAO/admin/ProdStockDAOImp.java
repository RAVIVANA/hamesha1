package eStoreProduct.DAO.admin;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import eStoreProduct.model.admin.output.ProdStock;
import eStoreProduct.model.admin.output.ProductStockRowMapper;

@Component
public class ProdStockDAOImp implements ProdStockDAO {
	private static final String PD_STK_QUERY = "SELECT * FROM slam_productstock";
	private static final String SELECT_PRD_STK_QUERY = "SELECT * FROM slam_productstock WHERE prod_id = ?";
	private static final String PD_PRICE_QUERY = "SELECT prod_price FROM slam_productstock WHERE prod_id = ?";
	private static final String PD_MRP_QUERY = "SELECT prod_price FROM slam_productstock WHERE prod_id = ?";
	private static final Logger logger = LoggerFactory.getLogger(ProdStockDAOImp.class);


	private JdbcTemplate jdbcTemplate;

	public ProdStockDAOImp(DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<ProdStock> getAllProdStocks() {
								    logger.info("in ProdStockDAOImp.getAllProdStocks() ");

		return jdbcTemplate.query(PD_STK_QUERY, new ProductStockRowMapper());
	}

	@Override
	public ProdStock getProdStockById(int prodId) {
										    logger.info("in ProdStockDAOImp.getProdStockById() ");

		return jdbcTemplate.queryForObject(SELECT_PRD_STK_QUERY, new ProductStockRowMapper(), prodId);
	}

	@Override
	public double getProdPriceById(int prodId) {
												    logger.info("in ProdStockDAOImp.getProdPriceById() ");

		return jdbcTemplate.queryForObject(PD_PRICE_QUERY, Double.class, prodId);
	}

	@Override
	public double getProdMrpById(int prodId) {
														    logger.info("in ProdStockDAOImp.getProdMrpById() ");

		return jdbcTemplate.queryForObject(PD_MRP_QUERY, Double.class, prodId);
	}
}