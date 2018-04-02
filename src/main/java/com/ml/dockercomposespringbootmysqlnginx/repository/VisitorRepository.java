package com.ml.dockercomposespringbootmysqlnginx.repository;

import com.ml.dockercomposespringbootmysqlnginx.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marcus Li
 * @date 29/03/2018
 */
public interface VisitorRepository extends JpaRepository<Visitor, Long> {
    Visitor findByIp(String ip);
}
