package shop.rp2.colt.src.user.models.user;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * shop.rp2.colt.src.user.models.user.QGetUserProfilesRes is a Querydsl Projection type for GetUserProfilesRes
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QGetUserProfilesRes extends ConstructorExpression<GetUserProfilesRes> {

    private static final long serialVersionUID = -1704950427L;

    public QGetUserProfilesRes(com.querydsl.core.types.Expression<String> nickname, com.querydsl.core.types.Expression<String> userImage, com.querydsl.core.types.Expression<Long> followings, com.querydsl.core.types.Expression<Long> followers) {
        super(GetUserProfilesRes.class, new Class<?>[]{String.class, String.class, long.class, long.class}, nickname, userImage, followings, followers);
    }

}

