package dao;

import model.Good;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GoodDAO {
    JdbcTemplate jdbcTemplate;

    public GoodDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public int save(Good p){
        String sql="insert into Goods(title,amount,description) values('"+p.getTitle()+"',"+p.getAmount()+",'"+p.getDescription()+"')";
        return jdbcTemplate.update(sql);
    }
    public int update(Good p){
        String sql="update Goods set title='"+p.getTitle()+"', amount="+p.getAmount()+",description='"+p.getDescription()+"' where id="+p.getId()+"";
        return jdbcTemplate.update(sql);
    }
    public int delete(int id){
        String sql="delete from Goods where id="+id+"";
        return jdbcTemplate.update(sql);
    }
    public Good getGoodById(int id){
        String sql="select * from Goods where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Good>(Good.class));
    }
    public List<Good> getGoods(){
        return jdbcTemplate.query("select * from Goods",new RowMapper<Good>(){
            public Good mapRow(ResultSet rs, int row) throws SQLException {
                Good e=new Good();
                e.setId(rs.getInt(1));
                e.setTitle(rs.getString(2));
                e.setAmount(rs.getFloat(3));
                e.setDescription(rs.getString(4));
                return e;
            }
        });
    }
}
