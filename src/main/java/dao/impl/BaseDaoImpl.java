package dao.impl;

import dao.BaseDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Author:xianglei
 * Date: 2019-02-25 10:35
 * Description:
 */
public abstract class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {

    //命名空间
    private String ns;

    public void setNs(String ns) {
        this.ns = ns;
    }

    public String getNs() {
        return ns;
    }

    @Autowired
    //mybatis-spring 1.0无须此方法； mybatis-spring1.2必须注入
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public T get(Serializable id) {
        return getSqlSession().selectOne(ns + ".get", id);
    }

    @Override
    public List<T> find(Map map) {
        return getSqlSession().selectList(ns + ".find", map);
    }

    @Override
    public void insert(T entity) {
        getSqlSession().insert(ns + ".insert", entity);
    }

    @Override
    public void update(T entity) {
        getSqlSession().update(ns + ".update", entity);
    }

    @Override
    public void deleteById(Serializable id) {
        getSqlSession().delete(ns + ".deleteById", id);
    }

    @Override
    public void delete(Serializable[] ids) {
        getSqlSession().delete(ns + ".delete", ids);
    }
}
