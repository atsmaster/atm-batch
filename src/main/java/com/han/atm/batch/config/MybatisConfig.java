package com.han.atm.batch.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.han.atm.batch"} )
public class MybatisConfig {
    /**
     * SQL Session 정보 리턴
     * @author 지우석
     * @since 2019. 11. 5.
     * @MethodName  sqlSessionFactory
     * @param
     * @return  SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource)throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        //config location 설정
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource configLocation = resolver.getResource("classpath:mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(configLocation);

        //mapper location 설정
        Resource[] mapperLocations = resolver.getResources("classpath*:com/han/atm/batch/**/mapper-*.xml");
        sqlSessionFactoryBean.setMapperLocations(mapperLocations);

        return sqlSessionFactoryBean.getObject();
    }

    /**
     * SQL Factory에 데몬에서 사용할 SQL Template을 등록
     * @author 지우석
     * @since 2019. 11. 5.
     * @MethodName  sqlSession
     * @param
     * @return  SqlSessionTemplate
     */
    @Bean("sqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
