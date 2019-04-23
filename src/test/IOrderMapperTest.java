package test;

import com.jsc.mapper.IOrdersMapper;
import com.jsc.model.Items;
import com.jsc.model.Orderdetail;
import com.jsc.model.Orders;
import com.jsc.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class IOrderMapperTest {
    @Test
    public void test1() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = ssf.openSession();
        IOrdersMapper mapper = sqlSession.getMapper(IOrdersMapper.class);
        List<User> users = mapper.findOrdersByItemid(1);
        for (User user : users) {
            System.out.println(user);
            for (Orders order : user.getOrdersList()) {
                System.out.println(order);
            }
            System.out.println("-----------------");
        }
    }

    @Test
    public void test2() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = ssf.openSession();
        IOrdersMapper mapper = sqlSession.getMapper(IOrdersMapper.class);
        User user = mapper.findOrdersByOrdersId(4);
        System.out.println(user);
        List<Orders> ordersList = user.getOrdersList();
        for (Orders orders : ordersList) {
            System.out.println(orders);
            for (Orderdetail orderdetail : orders.getOrderdetails()) {
                System.out.println(orderdetail);
            }
        }
        System.out.println("----------------------");
    }


    @Test
    public void test3() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = ssf.openSession();
        IOrdersMapper mapper = sqlSession.getMapper(IOrdersMapper.class);
        List<User> users = mapper.findUserAndItems();

        for (User user : users) {
            System.out.println(user);
            List<Orders> ordersLists = user.getOrdersList();
            for (Orders ordersList : ordersLists) {
                for (Orderdetail orderdetail : ordersList.getOrderdetails()) {
                    Items item = orderdetail.getItems();
                    System.out.println(item);
                }
            }
            System.out.println("-------------------");
        }
    }
}
