package shop.rp2.colt.src.singer;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * shop.rp2.colt.src.singer.QTestSinger is a Querydsl Projection type for TestSinger
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QTestSinger extends ConstructorExpression<TestSinger> {

    private static final long serialVersionUID = -725532178L;

    public QTestSinger(com.querydsl.core.types.Expression<Long> singerId, com.querydsl.core.types.Expression<String> singerName) {
        super(TestSinger.class, new Class<?>[]{long.class, String.class}, singerId, singerName);
    }

}

