package com.tenco.blog.reply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ReplyJPARepository extends JpaRepository<Reply,Long> {

}
