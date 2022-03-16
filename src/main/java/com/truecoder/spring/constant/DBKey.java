package com.truecoder.spring.constant;

public class DBKey {

    public static final String USER_TABLE = "user";

    public static final class USER {
        public static final String ID = "user_id";
        public static final String USERNAME = "username";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
        public static final String ACTIVE = "active";
    }

    public static final String ROLE_TABLE = "role";

    public static final class ROLE {
        public static final String ID = "role_id";
        public static final String NAME = "name";
    }

    public static final String CLAZZ_TABLE = "clazz";

    public static final class CLAZZ {
        public static final String ID = "class_id";
        public static final String NAME = "name";
    }

    public static final String POST_TABLE = "post";

    public static final class POST {
        public static final String ID = "post_id";
        public static final String CONTENT = "content";
    }

    public static final String CATEGORY_TABLE = "category";

    public static final class CATEGORY {
        public static final String ID = "category_id";
        public static final String CATEGORY = "category";
    }

    public static final String PERMISSION_TABLE = "permission";

    public static final class PERMISSION {
        public static final String ID = "permission_id";
        public static final String NAME = "name";
        public static final String DESCRIPTION = "description";
    }

    public static final String LESSON_TABLE = "lesson";

    public static final class LESSON {
        public static final String ID = "lesson_id";
        public static final String NAME = "name";
        public static final String CODE = "code";
        public static final String DOCUMENTATION = "documentation";
        public static final String SCORE = "score";
        public static final String CREATE = "created_at";
        public static final String UPDATE = "update_at";
        public static final String VIDEO_FILENAME = "video_filename";
    }

    public static final String COURSE_TABLE = "course";

    public static final class COURSE {
        public static final String ID = "courses_id";
        public static final String NAME = "name";
        public static final String CREATE = "created_at";
        public static final String UPDATE = "update_at";
        public static final String COURSE_CODE = "course_code";
        public static final String PRICE_TAG = "price_tag";
        public static final String TOTAL_LESSONS = "total_lessons";
        public static final String TOTAL_TIME = "total_time";
        public static final String DESCRIPTION = "description";
        public static final String VIEWS = "views";
        public static final String IMAGE_PATH = "image_path";
    }

    public static final String LEVEL_TABLE = "level";

    public static final class LEVEL {
        public static final String ID = "level_id";
        public static final String NAME = "name";
    }
}
