package solux.woodong.web.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass  //jpa entity들이 basetimeentity 상속할 경우 baseTimeEntity의 필드들도 칼럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class)  //auditing 기능 포함시킴
public abstract class BaseTimeEntity {    //jpa auditing으로 모든 entity의 상위 클래스가 되어 date 자동 관리
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
